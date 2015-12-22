package ro.ghasachi.bt.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ro.ghasachi.bt.persistence.model.Exam;

public interface IExamDao extends JpaRepository<Exam, Long>, JpaSpecificationExecutor<Exam>{

}
