package ro.ghasachi.bt.web.middleware.impl;

import static ro.ghasachi.bt.persistence.tables.Examinstance.EXAMINSTANCE;
import static ro.ghasachi.bt.persistence.tables.Studexaminstance.STUDEXAMINSTANCE;
import static ro.ghasachi.bt.persistence.tables.User.USER;

import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ghasachi.bt.persistence.tables.daos.ExaminstanceDao;
import ro.ghasachi.bt.persistence.tables.daos.UserDao;
import ro.ghasachi.bt.web.middleware.StudService;
import ro.ghasachi.bt.web.vo.ExamInstanceVO;
import ro.ghasachi.bt.web.vo.ExamItemVO;
import ro.ghasachi.bt.web.vo.StudExamInstanceVO;;

@Service
public class StudServiceImpl implements StudService {

	@Autowired
	private ExaminstanceDao examinstanceDao;
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	@PreAuthorize("hasRole('ROLE_STUD')")
	public List<ExamInstanceVO> getMyExams() {
		List<ExamInstanceVO> result = new ArrayList<>();

		// get the principal
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();


		DSLContext jooq = DSL.using(userDao.configuration());
		List<Record2<Long, String>> rs = jooq.select(EXAMINSTANCE.ID, EXAMINSTANCE.NAME)
				.from(EXAMINSTANCE)
				.join(STUDEXAMINSTANCE)
				.on(EXAMINSTANCE.ID.equal(STUDEXAMINSTANCE.EXAMINSTANCE_ID))
				.join(USER)
				.on(STUDEXAMINSTANCE.STUDENT_ID.equal(USER.ID))
				.where(USER.EMAIL.equal(name)).fetch();

		//convert

		return result;
	}

	@Override
	@Transactional
	@PreAuthorize("hasRole('ROLE_STUD')")
	public ExamInstanceVO getOneExam(long id) {

		// get the principal
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		DSLContext jooq = DSL.using(userDao.configuration());

		List<Record2<Long, String>> rs = jooq.select(EXAMINSTANCE.ID, EXAMINSTANCE.NAME)
				.from(EXAMINSTANCE)
				.join(STUDEXAMINSTANCE)
				.on(EXAMINSTANCE.ID.equal(STUDEXAMINSTANCE.EXAMINSTANCE_ID))
				.join(USER)
				.on(STUDEXAMINSTANCE.STUDENT_ID.equal(USER.ID))
				.where(USER.EMAIL.equal(name).and(EXAMINSTANCE.ID.equal(id)))
				.fetch();
		
		
		return null;
	}

	@Override
	@Transactional
	@PreAuthorize("hasRole('ROLE_STUD')")
	public StudExamInstanceVO changeExamInstance(Long id, String state) {
		// get the principal
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		
		DSLContext jooq = DSL.using(userDao.configuration());
		Result<Record1<Long>> rs = jooq.select(STUDEXAMINSTANCE.ID)
				.from(STUDEXAMINSTANCE)
				.join(USER)
				.on(STUDEXAMINSTANCE.STUDENT_ID.equal(USER.ID))
				.where(USER.EMAIL.equal(name))
				.fetch();
		
		// TODO find exam instance for me
		// TODO create or find StudExamInstance
		// TODO change status (start or stop an exam)
		return null;
	}

	@Override
	public ExamItemVO getExamItem(Long examId, Long itemId) {
		// TODO get my exam instances
		// TODO find the exam with the id
		// TODO validate exam is in progress for the current client (match )
		// TODO find item for id in the exam instance
		// TODO validate if the item was already answered or skipped
		// TODO get responses for item / create random order
		return null;
	}

	@Override
	public void saveExamItem(ExamItemVO examItemVO) {
		// TODO extract exam instance and itemId
		// TODO validate exam instance is still available
		// TODO validate item is not answered yet
		// TODO save answer
	}

}
