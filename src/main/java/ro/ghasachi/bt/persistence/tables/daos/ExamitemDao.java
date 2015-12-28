/**
 * This class is generated by jOOQ
 */
package ro.ghasachi.bt.persistence.tables.daos;


import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.ghasachi.bt.persistence.tables.Examitem;
import ro.ghasachi.bt.persistence.tables.records.ExamitemRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class ExamitemDao extends DAOImpl<ExamitemRecord, ro.ghasachi.bt.persistence.tables.pojos.Examitem, Long> {

	/**
	 * Create a new ExamitemDao without any configuration
	 */
	public ExamitemDao() {
		super(Examitem.EXAMITEM, ro.ghasachi.bt.persistence.tables.pojos.Examitem.class);
	}

	/**
	 * Create a new ExamitemDao with an attached configuration
	 */
	@Autowired
	public ExamitemDao(Configuration configuration) {
		super(Examitem.EXAMITEM, ro.ghasachi.bt.persistence.tables.pojos.Examitem.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Long getId(ro.ghasachi.bt.persistence.tables.pojos.Examitem object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>ID IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Examitem> fetchById(Long... values) {
		return fetch(Examitem.EXAMITEM.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>ID = value</code>
	 */
	public ro.ghasachi.bt.persistence.tables.pojos.Examitem fetchOneById(Long value) {
		return fetchOne(Examitem.EXAMITEM.ID, value);
	}

	/**
	 * Fetch records that have <code>ASSERTION IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Examitem> fetchByAssertion(String... values) {
		return fetch(Examitem.EXAMITEM.ASSERTION, values);
	}

	/**
	 * Fetch records that have <code>DIFICULTY IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Examitem> fetchByDificulty(Integer... values) {
		return fetch(Examitem.EXAMITEM.DIFICULTY, values);
	}

	/**
	 * Fetch records that have <code>POINTS IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Examitem> fetchByPoints(Integer... values) {
		return fetch(Examitem.EXAMITEM.POINTS, values);
	}

	/**
	 * Fetch records that have <code>TYPE IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Examitem> fetchByType(Integer... values) {
		return fetch(Examitem.EXAMITEM.TYPE, values);
	}

	/**
	 * Fetch records that have <code>EXAM_ID IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Examitem> fetchByExamId(Long... values) {
		return fetch(Examitem.EXAMITEM.EXAM_ID, values);
	}
}