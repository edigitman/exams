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

import ro.ghasachi.bt.persistence.tables.Verificationtoken;
import ro.ghasachi.bt.persistence.tables.records.VerificationtokenRecord;


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
public class VerificationtokenDao extends DAOImpl<VerificationtokenRecord, ro.ghasachi.bt.persistence.tables.pojos.Verificationtoken, Integer> {

	/**
	 * Create a new VerificationtokenDao without any configuration
	 */
	public VerificationtokenDao() {
		super(Verificationtoken.VERIFICATIONTOKEN, ro.ghasachi.bt.persistence.tables.pojos.Verificationtoken.class);
	}

	/**
	 * Create a new VerificationtokenDao with an attached configuration
	 */
	@Autowired
	public VerificationtokenDao(Configuration configuration) {
		super(Verificationtoken.VERIFICATIONTOKEN, ro.ghasachi.bt.persistence.tables.pojos.Verificationtoken.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Integer getId(ro.ghasachi.bt.persistence.tables.pojos.Verificationtoken object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Verificationtoken> fetchById(Integer... values) {
		return fetch(Verificationtoken.VERIFICATIONTOKEN.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public ro.ghasachi.bt.persistence.tables.pojos.Verificationtoken fetchOneById(Integer value) {
		return fetchOne(Verificationtoken.VERIFICATIONTOKEN.ID, value);
	}

	/**
	 * Fetch records that have <code>expiredate IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Verificationtoken> fetchByExpiredate(Timestamp... values) {
		return fetch(Verificationtoken.VERIFICATIONTOKEN.EXPIREDATE, values);
	}

	/**
	 * Fetch records that have <code>token IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Verificationtoken> fetchByToken(String... values) {
		return fetch(Verificationtoken.VERIFICATIONTOKEN.TOKEN, values);
	}

	/**
	 * Fetch records that have <code>verified IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Verificationtoken> fetchByVerified(Byte... values) {
		return fetch(Verificationtoken.VERIFICATIONTOKEN.VERIFIED, values);
	}

	/**
	 * Fetch records that have <code>userid IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Verificationtoken> fetchByUserid(Integer... values) {
		return fetch(Verificationtoken.VERIFICATIONTOKEN.USERID, values);
	}

	/**
	 * Fetch records that have <code>datecreated IN (values)</code>
	 */
	public List<ro.ghasachi.bt.persistence.tables.pojos.Verificationtoken> fetchByDatecreated(Timestamp... values) {
		return fetch(Verificationtoken.VERIFICATIONTOKEN.DATECREATED, values);
	}
}
