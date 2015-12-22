package ro.ghasachi.bt.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ghasachi.bt.persistence.dao.IExamItemAnswerDao;
import ro.ghasachi.bt.persistence.model.ExamItemAnswer;
import ro.ghasachi.bt.persistence.service.IExamItemAnswerService;
import ro.ghasachi.bt.persistence.service.common.AbstractService;

@Service
@Transactional
public class ExamItemAnswerService extends AbstractService<ExamItemAnswer> implements IExamItemAnswerService{

	@Autowired
	private IExamItemAnswerDao dao;

	public ExamItemAnswerService() {
		super();
	}

	@Override
	protected PagingAndSortingRepository<ExamItemAnswer, Long> getDao() {
		return dao;
	}
	
	
}
