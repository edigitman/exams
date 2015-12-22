package ro.ghasachi.bt.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import ro.ghasachi.bt.persistence.dao.IExamDao;
import ro.ghasachi.bt.persistence.model.Exam;
import ro.ghasachi.bt.persistence.service.IExamService;
import ro.ghasachi.bt.persistence.service.common.AbstractService;

public class ExamService extends AbstractService<Exam> implements IExamService{

	@Autowired
    private IExamDao dao;

    public ExamService() {
        super();
    }
	
	@Override
	protected PagingAndSortingRepository<Exam, Long> getDao() {
		return dao;
	}

}
