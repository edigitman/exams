package ro.ghasachi.bt.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ro.ghasachi.bt.persistence.model.ExamGroup;

public interface IExamGroupDao extends JpaRepository<ExamGroup, Long>, JpaSpecificationExecutor<ExamGroup>{

}
