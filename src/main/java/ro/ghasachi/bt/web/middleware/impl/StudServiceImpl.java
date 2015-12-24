package ro.ghasachi.bt.web.middleware.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ghasachi.bt.persistence.model.EUser;
import ro.ghasachi.bt.persistence.model.ExamInstance;
import ro.ghasachi.bt.persistence.service.IExamInstanceService;
import ro.ghasachi.bt.persistence.service.IUserService;
import ro.ghasachi.bt.web.middleware.StudService;
import ro.ghasachi.bt.web.vo.ExamInstanceVO;
import ro.ghasachi.bt.web.vo.ExamItemVO;
import ro.ghasachi.bt.web.vo.StudExamInstanceVO;

@Service
public class StudServiceImpl implements StudService {

	@Autowired
	private IExamInstanceService IExamInstanceService;
	@Autowired
	private IUserService iUserService;

	@Override
	@Transactional
	@PreAuthorize("hasRole('ROLE_STUD')")
	public List<ExamInstanceVO> getMyExams() {

		// get the principal
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		// get the user
		EUser stud = iUserService.findByEmail(name);

		// get all the exams
		List<ExamInstance> exams = IExamInstanceService.findForStudent(stud);

		// convert to VO
		List<ExamInstanceVO> result = new ArrayList<>();
		for (ExamInstance ei : exams) {
			result.add(new ExamInstanceVO(ei));
		}

		return result;
	}

	@Override
	@Transactional
	@PreAuthorize("hasRole('ROLE_STUD')")
	public ExamInstanceVO getOneExam(long id) {
		
		// get the principal
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		// get the user
		EUser stud = iUserService.findByEmail(name);

		// get all the exams
		List<ExamInstance> exams = IExamInstanceService.findForStudent(stud);

		for (ExamInstance ei : exams) {
			if (ei.getId() == id) {
				return new ExamInstanceVO(ei);
			}
		}
		return null;
	}

	@Override
	@Transactional
	@PreAuthorize("hasRole('ROLE_STUD')")
	public StudExamInstanceVO changeExamInstance(Long id, String state) {
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
