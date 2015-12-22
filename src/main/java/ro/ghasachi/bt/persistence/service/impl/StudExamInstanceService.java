package ro.ghasachi.bt.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import ro.ghasachi.bt.persistence.dao.IStudExamInstanceDao;
import ro.ghasachi.bt.persistence.model.StudExamInstance;
import ro.ghasachi.bt.persistence.service.IStudExamInstanceService;
import ro.ghasachi.bt.persistence.service.common.AbstractService;

public class StudExamInstanceService extends AbstractService<StudExamInstance> implements IStudExamInstanceService {

    @Autowired
    private IStudExamInstanceDao dao;

    public StudExamInstanceService() {
        super();
    }

    // API

    @Override
    protected PagingAndSortingRepository<StudExamInstance, Long> getDao() {
        return dao;
    }
}
