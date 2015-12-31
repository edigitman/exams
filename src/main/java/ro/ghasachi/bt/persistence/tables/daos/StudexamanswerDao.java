/**
 * This class is generated by jOOQ
 */
package ro.ghasachi.bt.persistence.tables.daos;


import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.ghasachi.bt.persistence.tables.Studexamanswer;
import ro.ghasachi.bt.persistence.tables.records.StudexamanswerRecord;


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
public class StudexamanswerDao extends DAOImpl<StudexamanswerRecord, ro.ghasachi.bt.persistence.tables.pojos.Studexamanswer, Integer> {

	/**
	 * Create a new StudexamanswerDao without any configuration
	 */
	public StudexamanswerDao() {
		super(Studexamanswer.STUDEXAMANSWER, ro.ghasachi.bt.persistence.tables.pojos.Studexamanswer.class);
	}

	/**
	 * Create a new StudexamanswerDao with an attached configuration
	 */
	@Autowired
	public StudexamanswerDao(Configuration configuration) {
		super(Studexamanswer.STUDEXAMANSWER, ro.ghasachi.bt.persistence.tables.pojos.Studexamanswer.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Integer getId(ro.ghasachi.bt.persistence.tables.pojos.Studexamanswer object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Studexamanswer> fetchById(Integer... values) {
		return fetch(Studexamanswer.STUDEXAMANSWER.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public ro.ghasachi.bt.persistence.tables.pojos.Studexamanswer fetchOneById(Integer value) {
		return fetchOne(Studexamanswer.STUDEXAMANSWER.ID, value);
	}

	/**
	 * Fetch records that have <code>studexaminst IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Studexamanswer> fetchByStudexaminst(Integer... values) {
		return fetch(Studexamanswer.STUDEXAMANSWER.STUDEXAMINST, values);
	}

	/**
	 * Fetch records that have <code>examitem IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Studexamanswer> fetchByExamitem(Integer... values) {
		return fetch(Studexamanswer.STUDEXAMANSWER.EXAMITEM, values);
	}

	/**
	 * Fetch records that have <code>value IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Studexamanswer> fetchByValue(String... values) {
		return fetch(Studexamanswer.STUDEXAMANSWER.VALUE, values);
	}

	/**
	 * Fetch records that have <code>datecreated IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Studexamanswer> fetchByDatecreated(Timestamp... values) {
		return fetch(Studexamanswer.STUDEXAMANSWER.DATECREATED, values);
	}
}
