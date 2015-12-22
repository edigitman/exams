package ro.ghasachi.bt.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ro.ghasachi.bt.persistence.model.StudExamAnswer;

public interface IStudExamAnswerDao extends JpaRepository<StudExamAnswer, Long>, JpaSpecificationExecutor<StudExamAnswer>{

}
