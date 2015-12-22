package ro.ghasachi.bt.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ghasachi.bt.persistence.dao.IExamGroupDao;
import ro.ghasachi.bt.persistence.model.ExamGroup;
import ro.ghasachi.bt.persistence.service.IExamGroupService;
import ro.ghasachi.bt.persistence.service.common.AbstractService;

@Service
@Transactional
public class ExamGroupService extends AbstractService<ExamGroup> implements IExamGroupService {

	@Autowired
	private IExamGroupDao dao;

	public ExamGroupService() {
		super();
	}

	@Override
	protected PagingAndSortingRepository<ExamGroup, Long> getDao() {
		return dao;
	}

}
