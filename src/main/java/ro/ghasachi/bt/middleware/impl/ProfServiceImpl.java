package ro.ghasachi.bt.middleware.impl;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ghasachi.bt.middleware.ProfService;
import ro.ghasachi.bt.persistence.tables.daos.*;
import ro.ghasachi.bt.persistence.tables.pojos.*;
import ro.ghasachi.bt.persistence.tables.records.ExamRecord;
import ro.ghasachi.bt.persistence.tables.records.ExaminstanceRecord;
import ro.ghasachi.bt.web.exception.MyArgumentIllegalException;
import ro.ghasachi.bt.web.vo.*;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ro.ghasachi.bt.persistence.tables.User.USER;
import static ro.ghasachi.bt.persistence.tables.Exam.EXAM;
import static ro.ghasachi.bt.persistence.tables.Examitem.EXAMITEM;
import static ro.ghasachi.bt.persistence.tables.Examinstance.EXAMINSTANCE;
import static ro.ghasachi.bt.persistence.tables.Egroup.EGROUP;
import static ro.ghasachi.bt.persistence.tables.Egroupuser.EGROUPUSER;


@Service
@Transactional
public class ProfServiceImpl implements ProfService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ExamDao examDao;
    @Autowired
    private ExamitemDao examitemDao;
    @Autowired
    private ExamitemanswerDao examitemanswerDao;
    @Autowired
    private EgroupDao egroupDao;
    @Autowired
    private EgroupuserDao egroupuserDao;
    @Autowired
    private ExaminstanceDao examinstanceDao;
    @Autowired
    private StudexaminstanceDao studexaminstanceDao;

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public Integer createExam(ExamVO examVO) {

        // get the principal
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        DSLContext jooq = DSL.using(userDao.configuration());
        ExamRecord result = jooq.insertInto(EXAM, EXAM.NAME, EXAM.DIFICULTY, EXAM.USERID, EXAM.DATECREATED)
                .values(examVO.getName(), examVO.getDifficulty(), user.getId(), new Timestamp(new Date().getTime()))
                .returning(EXAM.ID).fetchOne();

        return result.getId();
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public ExamVO updateExam(ExamVO examVO) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        if (examVO.getId() == 0) {
            throw new MyArgumentIllegalException("Invalid exam");
        }

        Exam exam = examDao.fetchOneById(examVO.getId());
        if (!exam.getUserid().equals(user.getId())) {
            throw new MyArgumentIllegalException("Invalid exam");
        }

        exam.setName(examVO.getName());
        exam.setDificulty(examVO.getDifficulty());

        examDao.update(exam);

        return examVO;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public ExamVO getOneExam(Long id) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        Exam exam = examDao.fetchOneById(id.intValue());
        if (!exam.getUserid().equals(user.getId())) {
            throw new MyArgumentIllegalException("Invalid exam");
        }

        List<Examitem> examItems = examitemDao.fetchByExamid(exam.getId());

        ExamVO examVO = new ExamVO(exam.getId(), exam.getName(), exam.getDificulty());

        for (Examitem examitem : examItems) {
            ExamItemVO itemVO = new ExamItemVO(examitem);
            List<Examitemanswer> answers = examitemanswerDao.fetchByItemid(examitem.getId());
            for (Examitemanswer answer : answers) {
                itemVO.addAnswer(new ExamItemAnswerVO(answer));
            }
            examVO.addItem(itemVO);
        }

        return examVO;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public List<ExamVO> getExams() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        DSLContext jooq = DSL.using(userDao.configuration());
        Result<Record3<Integer, String, String>> rs = jooq.select(EXAM.ID, EXAM.NAME, EXAM.DIFICULTY)
                .from(EXAM)
                .where(EXAM.USERID.equal(user.getId()))
                .fetch();

        List<ExamVO> result = new ArrayList<>();
        for (Record3 record : rs) {
            result.add(new ExamVO(record.getValue(EXAM.ID), record.getValue(EXAM.NAME), record.getValue(EXAM.DIFICULTY)));
        }

        return result;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public void createExamItem(ExamItemVO examItemVO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        int examId = examItemVO.getExamId();

        Exam exam = examDao.fetchOneById(examId);
        if (!exam.getUserid().equals(user.getId())) {
            throw new MyArgumentIllegalException("Not my exam");
        }

        Examitem examitem = new Examitem();
        examitem.setAssertion(examItemVO.getAssertion());
        examitem.setType(examItemVO.getType());
        examitem.setPoints(examItemVO.getPoints());
        examitem.setDifficulty(examItemVO.getDifficulty());
        examitem.setExamid(exam.getId());

        examitemDao.insert(examitem);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public ExamItemVO updateExamItem(ExamItemVO examItemVO) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        int examId = examItemVO.getExamId();
        int itemId = examItemVO.getId();

        Exam exam = examDao.fetchOneById(examId);
        if (!exam.getUserid().equals(user.getId())) {
            throw new MyArgumentIllegalException("Not my exam");
        }

        Examitem examitem = examitemDao.fetchOneById(itemId);
        if (!examitem.getExamid().equals(exam.getId())) {
            throw new MyArgumentIllegalException("Not my item");
        }

        examitem.setAssertion(examItemVO.getAssertion());
        examitem.setPoints(examItemVO.getPoints());
        examitem.setType(examItemVO.getType());

        examitemDao.update(examitem);

        return new ExamItemVO(examitem);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public ExamItemVO getOneExamItem(int id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        DSLContext jooq = DSL.using(userDao.configuration());
        Examitem examitem = jooq.select(EXAMITEM.ID, EXAMITEM.ASSERTION, EXAMITEM.TYPE, EXAMITEM.POINTS)
                .from(EXAMITEM)
                .join(EXAM).on(EXAMITEM.EXAMID.equal(EXAM.ID))
                .join(USER).on(EXAM.USERID.equal(USER.ID))
                .where(USER.ID.equal(user.getId()).and(EXAMITEM.ID.equal(id)))
                .fetchOneInto(Examitem.class);

        return new ExamItemVO(examitem);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public void removeExamItem(Long id) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        DSLContext jooq = DSL.using(userDao.configuration());
        Examitem examitem = jooq.select(EXAMITEM.ID, EXAMITEM.ASSERTION, EXAMITEM.TYPE, EXAMITEM.POINTS)
                .from(EXAMITEM)
                .join(EXAM).on(EXAMITEM.EXAMID.equal(EXAM.ID))
                .join(USER).on(EXAM.USERID.equal(USER.ID))
                .where(USER.ID.equal(user.getId()).and(EXAMITEM.ID.equal(id.intValue())))
                .fetchOneInto(Examitem.class);

        examitemDao.delete(examitem);
    }

    // EXAM ITEM ANSWERS
    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public void createExamItemAnswer(ExamItemAnswerVO examItemAnswerVO) {

        ExamItemVO examitem = getOneExamItem(examItemAnswerVO.getItemId());

        Examitemanswer examitemanswer = new Examitemanswer();
        examitemanswer.setCorrect((byte) (examItemAnswerVO.getCorrect() ? 1 : 0));
        examitemanswer.setItemid(examitem.getId());
        examitemanswer.setValue(examItemAnswerVO.getValue());

        examitemanswerDao.insert(examitemanswer);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public ExamItemAnswerVO updateExamItemAnswer(ExamItemAnswerVO examItemAnswerVO) {

        ExamItemVO examitem = getOneExamItem(examItemAnswerVO.getItemId());

        Examitemanswer examitemanswer = examitemanswerDao.fetchOneById(examItemAnswerVO.getId());

        if (!examitemanswer.getItemid().equals(examitem.getId())) {
            throw new MyArgumentIllegalException("Not my item for the answer");
        }

        examitemanswer.setCorrect((byte) (examItemAnswerVO.getCorrect() ? 1 : 0));
        examitemanswer.setValue(examItemAnswerVO.getValue());

        examitemanswerDao.update(examitemanswer);
        return new ExamItemAnswerVO(examitemanswer);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public ExamItemAnswerVO getOneExamItemAnswer(Long id) {
        return null;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public void removeExamItemAnswer(int id) {

        Examitemanswer examitemanswer = examitemanswerDao.fetchOneById(id);

        ExamItemVO examitem = getOneExamItem(examitemanswer.getItemid());

        if (examitem == null) {
            throw new MyArgumentIllegalException("Not my item answer");
        }

        examitemanswerDao.delete(examitemanswer);
    }

    // EXAM GROUPS
    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public void createExamGroup(ExamGroupVO examGroupVO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        Egroup egroup = new Egroup();
        egroup.setName(examGroupVO.getName());
        egroup.setUser(user.getId());

        egroupDao.insert(egroup);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public ExamGroupVO updateExamGroup(ExamGroupVO examGroupVO) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        Egroup egroup = egroupDao.fetchOneById(examGroupVO.getId());
        if (!egroup.getUser().equals(user.getId())) {
            throw new MyArgumentIllegalException("Not my group");
        }
        egroup.setName(examGroupVO.getName());

        egroupDao.update(egroup);

        return new ExamGroupVO(egroup);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public List<ExamGroupVO> getExamGroups() {

        List<ExamGroupVO> result = new ArrayList<>();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        DSLContext jooq = DSL.using(userDao.configuration());
        List<Egroup> rs = jooq.select(EGROUP.ID, EGROUP.NAME)
                .from(EGROUP)
                .where(EGROUP.USER.equal(user.getId()))
                .fetchInto(Egroup.class);

        for (Egroup group : rs) {
            result.add(new ExamGroupVO(group));
        }
        return result;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public ExamGroupVO getOneExamGroup(Integer id) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        DSLContext jooq = DSL.using(userDao.configuration());
        Egroup rs = jooq.select(EGROUP.ID, EGROUP.NAME)
                .from(EGROUP)
                .where(EGROUP.USER.equal(user.getId()).and(EGROUP.ID.equal(id)))
                .fetchOneInto(Egroup.class);

        List<User> studs = jooq.select(USER.NAME, USER.LASTNAME)
                .from(USER)
                .join(EGROUPUSER).on(EGROUPUSER.USERID.equal(USER.ID))
                .join(EGROUP).on(EGROUPUSER.GROUPID.equal(EGROUP.ID))
                .where(EGROUP.ID.equal(rs.getId()))
                .fetchInto(User.class);

        ExamGroupVO examGroupVO = new ExamGroupVO(rs);

        for (User stud : studs) {
            examGroupVO.add(new UserVO(stud));
        }
        return examGroupVO;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public void removeExamGroup(Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        DSLContext jooq = DSL.using(userDao.configuration());
        Egroup rs = jooq.selectFrom(EGROUP)
                .where(EGROUP.USER.equal(user.getId()).and(EGROUP.ID.equal(id.intValue())))
                .fetchOneInto(Egroup.class);

        egroupDao.delete(rs);

        //TODO also consider deleting all dependencies (egroupuser only)
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public void addStudFromGroup(ExamGroupStudVO examGroupStudVO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        DSLContext jooq = DSL.using(userDao.configuration());
        Egroup egroup = jooq.selectFrom(EGROUP)
                .where(EGROUP.USER.equal(user.getId()).and(EGROUP.ID.equal(examGroupStudVO.getGroupId())))
                .fetchOneInto(Egroup.class);

        Egroupuser egroupuser = new Egroupuser();
        egroupuser.setUserid(examGroupStudVO.getStudId());
        egroupuser.setGroupid(egroup.getId());

        egroupuserDao.insert(egroupuser);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public void removeStudFromGroup(ExamGroupStudVO examGroupStudVO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        DSLContext jooq = DSL.using(userDao.configuration());
        Egroup egroup = jooq.select(EGROUP.ID, EGROUP.NAME)
                .from(EGROUP)
                .where(EGROUP.USER.equal(user.getId()).and(EGROUP.ID.equal(examGroupStudVO.getGroupId())))
                .fetchOneInto(Egroup.class);

        int result = jooq.delete(EGROUPUSER)
                .where(EGROUPUSER.GROUPID.equal(egroup.getId())
                        .and(EGROUPUSER.USERID.equal(examGroupStudVO.getStudId())))
                .execute();
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public void createExamInstance(ExamInstanceVO examInstanceVO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        Exam exam = examDao.fetchOneById(examInstanceVO.getExamId());

        if (!exam.getUserid().equals(user.getId())) {
            throw new MyArgumentIllegalException("Not my exam");
        }

        Egroup egroup = egroupDao.fetchOneById(examInstanceVO.getGroupId());
        if (!egroup.getUser().equals(user.getId())) {
            throw new MyArgumentIllegalException("Not my group");
        }

        DSLContext jooq = DSL.using(userDao.configuration());
        ExaminstanceRecord examInstance = jooq.insertInto(EXAMINSTANCE,
                EXAMINSTANCE.NAME,
                EXAMINSTANCE.EXAMID,
                EXAMINSTANCE.EGROUPID,
                EXAMINSTANCE.POINTS,
                EXAMINSTANCE.STATUS,
                EXAMINSTANCE.STARTDATE)
                .values(examInstanceVO.getName(), exam.getId(), egroup.getId(), examInstanceVO.getPoints(), 0, new Timestamp(examInstanceVO.getStartDate().getTime()))
                .returning(EXAMINSTANCE.ID)
                .fetchOne();

        Result<Record1<Integer>> studIds = jooq.select(USER.ID)
                .from(USER)
                .join(EGROUPUSER).on(USER.ID.equal(EGROUPUSER.USERID))
                .join(EGROUP).on(EGROUPUSER.GROUPID.equal(EGROUP.ID))
                .where(EGROUP.ID.equal(egroup.getId()))
                .fetch();

        for (Record studId : studIds) {
            Studexaminstance studexaminstance = new Studexaminstance();
            studexaminstance.setStatus(0);
            studexaminstance.setExamid(examInstance.getId());
            studexaminstance.setUserid(studId.getValue(USER.ID));
            studexaminstanceDao.insert(studexaminstance);
        }

        //todo send email to students to notify about the new exams
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public ExamInstanceVO updateExamInstance(ExamInstanceVO examInstanceVO) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        Examinstance examinstance = examinstanceDao.fetchOneById(examInstanceVO.getId());
        Exam exam = examDao.fetchOneById(examinstance.getExamid());

        if (!exam.getUserid().equals(user.getId())) {
            throw new MyArgumentIllegalException("Not my exam instance");
        }

        examinstance.setPoints(examInstanceVO.getPoints());
        examinstance.setStatus(examInstanceVO.getStatus());
        examinstance.setName(examinstance.getName());
        examinstance.setEgroupid(examInstanceVO.getGroupId());
        examinstance.setStartdate(new Timestamp(examInstanceVO.getStartDate().getTime()));

        examinstanceDao.update(examinstance);

        return new ExamInstanceVO(examinstance);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public ExamInstanceVO setStateOnExamInstance(int id, String state) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        Examinstance examinstance = examinstanceDao.fetchOneById(id);
        Exam exam = examDao.fetchOneById(examinstance.getExamid());

        if (!exam.getUserid().equals(user.getId())) {
            throw new MyArgumentIllegalException("Not my exam instance");
        }

        switch (state) {
            case "start":
                examinstance.setStatus(1);
                break;
            case "stop":
                examinstance.setStatus(0);
                break;
            case "finish":
                examinstance.setStatus(2);
                break;
        }

        examinstanceDao.update(examinstance);

        return new ExamInstanceVO(examinstance);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public ExamInstanceVO getOneExamInstance(int id) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        Examinstance examinstance = examinstanceDao.fetchOneById(id);
        Exam exam = examDao.fetchOneById(examinstance.getExamid());

        if (!exam.getUserid().equals(user.getId())) {
            throw new MyArgumentIllegalException("Not my exam instance");
        }

        ExamInstanceVO instance = new ExamInstanceVO(examinstance);
        instance.setExam(new ExamVO(exam));
        instance.setExamGroup(getOneExamGroup(examinstance.getEgroupid()));

        return instance;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_PROF')")
    public List<ExamInstanceVO> getExamInstances() {
        List<ExamInstanceVO> result = new ArrayList<>();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userDao.fetchOne(USER.EMAIL, name);

        DSLContext jooq = DSL.using(userDao.configuration());
        List<Examinstance> insts = jooq.select(EXAMINSTANCE.ID, EXAMINSTANCE.NAME, EXAMINSTANCE.STARTDATE, EXAMINSTANCE.STATUS)
                .from(EXAMINSTANCE)
                .join(EXAM).on(EXAMINSTANCE.EXAMID.equal(EXAM.ID))
                .join(USER).on(EXAM.USERID.equal(USER.ID))
                .where(USER.ID.equal(user.getId()))
                .fetchInto(Examinstance.class);

        for(Examinstance ei : insts){
            result.add(new ExamInstanceVO(ei));
        }

        return result;
    }
}
