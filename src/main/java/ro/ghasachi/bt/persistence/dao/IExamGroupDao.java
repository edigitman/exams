package ro.ghasachi.bt.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ro.ghasachi.bt.persistence.model.EUser;
import ro.ghasachi.bt.persistence.model.ExamGroup;

public interface IExamGroupDao extends JpaRepository<ExamGroup, Long>, JpaSpecificationExecutor<ExamGroup>{

	@Query("SELECT eg FROM ExamGroup eg WHERE :user in eg.students")
	List<ExamGroup> findforStudent(EUser user);
	
}
