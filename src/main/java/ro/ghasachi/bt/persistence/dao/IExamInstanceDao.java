package ro.ghasachi.bt.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ro.ghasachi.bt.persistence.model.ExamInstance;

public interface IExamInstanceDao extends JpaRepository<ExamInstance, Long>, JpaSpecificationExecutor<ExamInstance>{

}
