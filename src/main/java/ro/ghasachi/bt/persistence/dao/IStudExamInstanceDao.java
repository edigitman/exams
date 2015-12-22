package ro.ghasachi.bt.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ro.ghasachi.bt.persistence.model.StudExamInstance;

public interface IStudExamInstanceDao extends JpaRepository<StudExamInstance, Long>, JpaSpecificationExecutor<StudExamInstance>{

}
