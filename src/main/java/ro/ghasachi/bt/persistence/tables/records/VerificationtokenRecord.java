/**
 * This class is generated by jOOQ
 */
package ro.ghasachi.bt.persistence.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;

import ro.ghasachi.bt.persistence.tables.Verificationtoken;


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
public class VerificationtokenRecord extends UpdatableRecordImpl<VerificationtokenRecord> implements Record6<Integer, Timestamp, String, Byte, Integer, Timestamp> {

	private static final long serialVersionUID = -233432097;

	/**
	 * Setter for <code>mydb.verificationtoken.id</code>.
	 */
	public VerificationtokenRecord setId(Integer value) {
		setValue(0, value);
		return this;
	}

	/**
	 * Getter for <code>mydb.verificationtoken.id</code>.
	 */
	@NotNull
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>mydb.verificationtoken.expiredate</code>.
	 */
	public VerificationtokenRecord setExpiredate(Timestamp value) {
		setValue(1, value);
		return this;
	}

	/**
	 * Getter for <code>mydb.verificationtoken.expiredate</code>.
	 */
	@NotNull
	public Timestamp getExpiredate() {
		return (Timestamp) getValue(1);
	}

	/**
	 * Setter for <code>mydb.verificationtoken.token</code>.
	 */
	public VerificationtokenRecord setToken(String value) {
		setValue(2, value);
		return this;
	}

	/**
	 * Getter for <code>mydb.verificationtoken.token</code>.
	 */
	@NotNull
	@Size(max = 37)
	public String getToken() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>mydb.verificationtoken.verified</code>.
	 */
	public VerificationtokenRecord setVerified(Byte value) {
		setValue(3, value);
		return this;
	}

	/**
	 * Getter for <code>mydb.verificationtoken.verified</code>.
	 */
	public Byte getVerified() {
		return (Byte) getValue(3);
	}

	/**
	 * Setter for <code>mydb.verificationtoken.userid</code>.
	 */
	public VerificationtokenRecord setUserid(Integer value) {
		setValue(4, value);
		return this;
	}

	/**
	 * Getter for <code>mydb.verificationtoken.userid</code>.
	 */
	@NotNull
	public Integer getUserid() {
		return (Integer) getValue(4);
	}

	/**
	 * Setter for <code>mydb.verificationtoken.datecreated</code>.
	 */
	public VerificationtokenRecord setDatecreated(Timestamp value) {
		setValue(5, value);
		return this;
	}

	/**
	 * Getter for <code>mydb.verificationtoken.datecreated</code>.
	 */
	@NotNull
	public Timestamp getDatecreated() {
		return (Timestamp) getValue(5);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record6 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row6<Integer, Timestamp, String, Byte, Integer, Timestamp> fieldsRow() {
		return (Row6) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row6<Integer, Timestamp, String, Byte, Integer, Timestamp> valuesRow() {
		return (Row6) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Verificationtoken.VERIFICATIONTOKEN.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field2() {
		return Verificationtoken.VERIFICATIONTOKEN.EXPIREDATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return Verificationtoken.VERIFICATIONTOKEN.TOKEN;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Byte> field4() {
		return Verificationtoken.VERIFICATIONTOKEN.VERIFIED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field5() {
		return Verificationtoken.VERIFICATIONTOKEN.USERID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field6() {
		return Verificationtoken.VERIFICATIONTOKEN.DATECREATED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value2() {
		return getExpiredate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getToken();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Byte value4() {
		return getVerified();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value5() {
		return getUserid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value6() {
		return getDatecreated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VerificationtokenRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VerificationtokenRecord value2(Timestamp value) {
		setExpiredate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VerificationtokenRecord value3(String value) {
		setToken(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VerificationtokenRecord value4(Byte value) {
		setVerified(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VerificationtokenRecord value5(Integer value) {
		setUserid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VerificationtokenRecord value6(Timestamp value) {
		setDatecreated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public VerificationtokenRecord values(Integer value1, Timestamp value2, String value3, Byte value4, Integer value5, Timestamp value6) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached VerificationtokenRecord
	 */
	public VerificationtokenRecord() {
		super(Verificationtoken.VERIFICATIONTOKEN);
	}

	/**
	 * Create a detached, initialised VerificationtokenRecord
	 */
	public VerificationtokenRecord(Integer id, Timestamp expiredate, String token, Byte verified, Integer userid, Timestamp datecreated) {
		super(Verificationtoken.VERIFICATIONTOKEN);

		setValue(0, id);
		setValue(1, expiredate);
		setValue(2, token);
		setValue(3, verified);
		setValue(4, userid);
		setValue(5, datecreated);
	}
}
