package ro.ghasachi.bt.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ro.ghasachi.bt.persistence.model.ExamItemAnswer;

public interface IExamItemAnswerDao extends JpaRepository<ExamItemAnswer, Long>, JpaSpecificationExecutor<ExamItemAnswer>{

}
