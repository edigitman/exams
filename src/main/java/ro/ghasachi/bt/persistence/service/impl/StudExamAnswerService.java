package ro.ghasachi.bt.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ghasachi.bt.persistence.dao.IStudExamAnswerDao;
import ro.ghasachi.bt.persistence.model.StudExamAnswer;
import ro.ghasachi.bt.persistence.service.IStudExamAnswerService;
import ro.ghasachi.bt.persistence.service.common.AbstractService;

@Service
@Transactional
public class StudExamAnswerService extends AbstractService<StudExamAnswer> implements IStudExamAnswerService {

    @Autowired
    private IStudExamAnswerDao dao;

    public StudExamAnswerService() {
        super();
    }

    // API

    @Override
    protected PagingAndSortingRepository<StudExamAnswer, Long> getDao() {
        return dao;
    }

}
