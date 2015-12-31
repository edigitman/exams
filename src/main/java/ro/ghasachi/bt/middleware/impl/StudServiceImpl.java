package ro.ghasachi.bt.middleware.impl;

import static ro.ghasachi.bt.persistence.tables.Examinstance.EXAMINSTANCE;
import static ro.ghasachi.bt.persistence.tables.Examitem.EXAMITEM;
import static ro.ghasachi.bt.persistence.tables.Exam.EXAM;
import static ro.ghasachi.bt.persistence.tables.Studexaminstance.STUDEXAMINSTANCE;
import static ro.ghasachi.bt.persistence.tables.User.USER;
import static ro.ghasachi.bt.persistence.tables.Examitemanswer.EXAMITEMANSWER;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ghasachi.bt.middleware.StudService;
import ro.ghasachi.bt.persistence.tables.daos.*;
import ro.ghasachi.bt.persistence.tables.pojos.*;
import ro.ghasachi.bt.web.exception.MyArgumentIllegalException;
import ro.ghasachi.bt.web.vo.ExamInstanceVO;
import ro.ghasachi.bt.web.vo.ExamItemAnswerVO;
import ro.ghasachi.bt.web.vo.ExamItemVO;
import ro.ghasachi.bt.web.vo.StudExamInstanceVO;;

@Service
@Transactional
public class StudServiceImpl implements StudService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private StudexamanswerDao studexamanswerDao;
    @Autowired
    private StudexaminstanceDao studexaminstanceDao;

    @Override
    @PreAuthorize("hasRole('ROLE_STUD')")
    public List<ExamInstanceVO> getMyExams() {
        List<ExamInstanceVO> result = new ArrayList<>();

        // get the principal
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();


        DSLContext jooq = DSL.using(userDao.configuration());
        Result<Record4<Integer, String, Timestamp, Integer>> rs = jooq.select(EXAMINSTANCE.ID, EXAMINSTANCE.NAME, EXAMINSTANCE.STARTDATE, EXAMINSTANCE.STATUS)
                .from(EXAMINSTANCE)
                .join(STUDEXAMINSTANCE)
                .on(EXAMINSTANCE.ID.equal(STUDEXAMINSTANCE.EXAMID))
                .join(USER)
                .on(STUDEXAMINSTANCE.USERID.equal(USER.ID))
                .where(USER.EMAIL.equal(name)).fetch();

        //convert
        for (Record4 r : rs) {
            result.add(new ExamInstanceVO(r.getValue(EXAMINSTANCE.ID), r.getValue(EXAMINSTANCE.NAME), new Date(r.getValue(EXAMINSTANCE.STARTDATE).getTime()), r.getValue(EXAMINSTANCE.STATUS)));
        }
        return result;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_STUD')")
    public ExamInstanceVO getOneExam(long id) {

        // get the principal
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        DSLContext jooq = DSL.using(userDao.configuration());

        Result<Record5<Integer, String, Integer, Timestamp, Long>> rs = jooq.select(EXAMINSTANCE.ID, EXAMINSTANCE.NAME, EXAMINSTANCE.STATUS, EXAMINSTANCE.STARTDATE, EXAMINSTANCE.POINTS)
                .from(EXAMINSTANCE)
                .join(STUDEXAMINSTANCE)
                .on(EXAMINSTANCE.ID.equal(STUDEXAMINSTANCE.EXAMID))
                .join(USER)
                .on(STUDEXAMINSTANCE.USERID.equal(USER.ID))
                .where(USER.EMAIL.equal(name).and(EXAMINSTANCE.ID.equal((int) id)))
                .fetch();

        List<ExamInstanceVO> result = rs.into(ExamInstanceVO.class);

        return result.isEmpty() ? null : result.get(0);
    }

    /**
     * Change the state of a student exam instance, used to start or stop and exam
     *
     * @param id    - exam id
     * @param state - new state to pass: start or stop
     * @return new representation of student exam instance
     */
    @Override
    @PreAuthorize("hasRole('ROLE_STUD')")
    public StudExamInstanceVO changeExamInstance(Long id, String state) {
        // get the principal
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        //get the exam instance for the student
        DSLContext jooq = DSL.using(userDao.configuration());
        Result<Record2<Integer, Integer>> rs = jooq.select(STUDEXAMINSTANCE.ID, STUDEXAMINSTANCE.STATUS)
                .from(STUDEXAMINSTANCE)
                .join(USER)
                .on(STUDEXAMINSTANCE.USERID.equal(USER.ID))
                .where(USER.EMAIL.equal(name).and(STUDEXAMINSTANCE.ID.equal(id.intValue())))
                .fetch();

        List<Studexaminstance> eis = rs.into(Studexaminstance.class);
        if (eis == null || eis.isEmpty()) {
            throw new MyArgumentIllegalException("Cannot find student exam instance");
        }

        Studexaminstance ei = eis.get(0);

        //exam closed OR (not started AND request to stop) OR (running AND request to start)
        if (ei.getStatus() == 2 || (ei.getStatus() == 0 && "stop".equals(state)) || (ei.getStatus() == 1 && "start".equals(state))) {
            throw new MyArgumentIllegalException("Invalid action");
        }

        if (ei.getStatus() == 1) {
            if ("stop".equals(state)) {
                ei.setStatus(2);
            }
        }
        if (ei.getStatus() == 0) {
            if ("start".equals(state)) {
                ei.setStatus(1);
            }
        }

        studexaminstanceDao.update(ei);

        return new StudExamInstanceVO(ei.getId(), ei.getStatus());
    }

    @Override
    @PreAuthorize("hasRole('ROLE_STUD')")
    public ExamItemVO getExamItem(int examId, int itemId) {

        // get the principal
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        User user = userDao.fetchOne(USER.EMAIL, name);

        DSLContext jooq = DSL.using(userDao.configuration());
        Examitem item = jooq.select(EXAMITEM.ID, EXAMITEM.ASSERTION, EXAMITEM.TYPE)
                .from(EXAMITEM)
                .join(EXAM).on(EXAMITEM.EXAMID.equal(EXAM.ID))
                .join(EXAMINSTANCE).on(EXAMINSTANCE.EXAMID.equal(EXAM.ID))
                .join(STUDEXAMINSTANCE).on(STUDEXAMINSTANCE.EXAMID.equal(EXAMINSTANCE.ID))
                .where(STUDEXAMINSTANCE.ID.equal(examId)
                        .and(EXAMITEM.ID.equal(itemId))
                        .and(STUDEXAMINSTANCE.USERID.equal(user.getId()))
                        .and(STUDEXAMINSTANCE.STATUS.equal(1)))
                .fetchOneInto(Examitem.class);

        Result<Record1<String>> rsa = jooq.select(EXAMITEMANSWER.VALUE)
                .from(EXAMITEMANSWER)
                .join(EXAMITEM).on(EXAMITEMANSWER.ITEMID.equal(EXAMITEM.ID))
                .where(EXAMITEM.ID.equal(item.getId()))
                .fetch();

        ExamItemVO itemVo = new ExamItemVO();
        itemVo.setAssertion(item.getAssertion());
        itemVo.setId(item.getId());
        itemVo.setType(item.getType());
        itemVo.setExamId(examId);

        for (Record1 r : rsa) {
            itemVo.addAnswer(new ExamItemAnswerVO(r.getValue(EXAMITEMANSWER.VALUE)));
        }
        Collections.shuffle(itemVo.getAnswers());

        return itemVo;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_STUD')")
    public void saveExamItem(ExamItemAnswerVO examItemAnswerVO) {

        // get the principal
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        //extract data
        Timestamp timestamp = new Timestamp(new Date().getTime());
        int studExamInstanceId = examItemAnswerVO.getExamInstanceId();
        int examItem = examItemAnswerVO.getItemId();
        String response = examItemAnswerVO.getValue();

        User user = userDao.fetchOne(USER.EMAIL, name);

        // fetch the student exam instance
        Studexaminstance sei = studexaminstanceDao.fetchOneById(studExamInstanceId);

        //validate is my exam instance and it is active
        if (!sei.getStatus().equals(1) || !sei.getUserid().equals(user.getId())) {
            throw new MyArgumentIllegalException("Illegal exam instance");
        }

        // validate the question wasn't answered yet
        List<Studexamanswer> answers = studexamanswerDao.fetchByExamitem(sei.getExamid());
        for (Studexamanswer answer : answers) {
            if (answer.getExamitem().equals(examItem)) {
                throw new MyArgumentIllegalException("already answered");
            }
        }

        // get a list of items for the exam to validate exam item id
        DSLContext jooq = DSL.using(userDao.configuration());
        Result<Record1<Integer>> rs = jooq.select(EXAMITEM.ID)
                .from(EXAMITEM)
                .join(EXAM).on(EXAMITEM.EXAMID.equal(EXAM.ID))
                .join(EXAMINSTANCE).on(EXAMINSTANCE.EXAMID.equal(EXAM.ID))
                .join(STUDEXAMINSTANCE).on(STUDEXAMINSTANCE.EXAMID.equal(EXAMINSTANCE.ID))
                .where(STUDEXAMINSTANCE.ID.equal(sei.getId()))
                .fetch();

        boolean validItem = false;
        for (Record1 r : rs) {
            if (r.getValue(EXAMITEM.ID).equals(examItem)) {
                validItem = true;
                break;
            }
        }

        if (!validItem) {
            throw new MyArgumentIllegalException("Invalid item");
        }

        studexamanswerDao.insert(new Studexamanswer(null, studExamInstanceId, examItem, response, timestamp));
    }
}
