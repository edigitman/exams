package ro.ghasachi.bt.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ghasachi.bt.persistence.dao.IExamDao;
import ro.ghasachi.bt.persistence.model.Exam;
import ro.ghasachi.bt.persistence.service.IExamService;
import ro.ghasachi.bt.persistence.service.common.AbstractService;

@Service
@Transactional
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
