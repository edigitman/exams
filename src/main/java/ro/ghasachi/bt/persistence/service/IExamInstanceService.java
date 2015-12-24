package ro.ghasachi.bt.persistence.service;

import java.util.List;

import ro.ghasachi.bt.persistence.IOperations;
import ro.ghasachi.bt.persistence.model.EUser;
import ro.ghasachi.bt.persistence.model.ExamInstance;

public interface IExamInstanceService extends IOperations<ExamInstance>{
	
	List<ExamInstance> findForStudent(EUser stud);
	
}
