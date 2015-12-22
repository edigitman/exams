package ro.ghasachi.bt.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ghasachi.bt.persistence.dao.IExamItemDao;
import ro.ghasachi.bt.persistence.model.ExamItem;
import ro.ghasachi.bt.persistence.service.IExamItemService;
import ro.ghasachi.bt.persistence.service.common.AbstractService;

@Service
@Transactional
public class ExamItemService extends AbstractService<ExamItem> implements IExamItemService{

	
	@Autowired
	private IExamItemDao dao;

	public ExamItemService() {
		super();
	}

	@Override
	protected PagingAndSortingRepository<ExamItem, Long> getDao() {
		return dao;
	}
	
	
}
