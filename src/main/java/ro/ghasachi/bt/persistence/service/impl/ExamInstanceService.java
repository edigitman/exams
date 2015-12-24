package ro.ghasachi.bt.persistence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ghasachi.bt.persistence.dao.IExamGroupDao;
import ro.ghasachi.bt.persistence.dao.IExamInstanceDao;
import ro.ghasachi.bt.persistence.model.EUser;
import ro.ghasachi.bt.persistence.model.ExamGroup;
import ro.ghasachi.bt.persistence.model.ExamInstance;
import ro.ghasachi.bt.persistence.service.IExamInstanceService;
import ro.ghasachi.bt.persistence.service.common.AbstractService;

@Service
@Transactional
public class ExamInstanceService extends AbstractService<ExamInstance> implements IExamInstanceService{

	@Autowired
	private IExamInstanceDao dao;
	@Autowired
	private IExamGroupDao groupDao;

	public ExamInstanceService() {
		super();
	}

	@Override
	protected PagingAndSortingRepository<ExamInstance, Long> getDao() {
		return dao;
	}

	@Override
	public List<ExamInstance> findForStudent(EUser stud) {
		
		List<ExamGroup> groups = groupDao.findforStudent(stud);
		
		List<ExamInstance> list = dao.findForGroups(groups);
		
		return list;
	}
	
}
