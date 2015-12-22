package ro.ghasachi.bt.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ro.ghasachi.bt.persistence.model.ExamItem;

public interface IExamItemDao extends JpaRepository<ExamItem, Long>, JpaSpecificationExecutor<ExamItem>{

}
