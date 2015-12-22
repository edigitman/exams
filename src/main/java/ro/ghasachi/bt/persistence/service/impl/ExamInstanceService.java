package ro.ghasachi.bt.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ghasachi.bt.persistence.dao.IExamInstanceDao;
import ro.ghasachi.bt.persistence.model.ExamInstance;
import ro.ghasachi.bt.persistence.service.IExamInstanceService;
import ro.ghasachi.bt.persistence.service.common.AbstractService;

@Service
@Transactional
public class ExamInstanceService extends AbstractService<ExamInstance> implements IExamInstanceService{

	@Autowired
	private IExamInstanceDao dao;

	public ExamInstanceService() {
		super();
	}

	@Override
	protected PagingAndSortingRepository<ExamInstance, Long> getDao() {
		return dao;
	}
	
}
