package ro.ghasachi.bt.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ro.ghasachi.bt.persistence.model.ExamGroup;
import ro.ghasachi.bt.persistence.model.ExamInstance;

public interface IExamInstanceDao extends JpaRepository<ExamInstance, Long>, JpaSpecificationExecutor<ExamInstance>{

	@Query("SELECT ei FROM ExamInstance ei WHERE ei.group in :groups")
	List<ExamInstance> findForGroups(List<ExamGroup> groups);

}
