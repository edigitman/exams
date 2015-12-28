/**
 * This class is generated by jOOQ
 */
package ro.ghasachi.bt.persistence.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;

import ro.ghasachi.bt.persistence.tables.User;


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
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record7<Long, String, Boolean, String, String, String, String> {

	private static final long serialVersionUID = 1030458390;

	/**
	 * Setter for <code>PUBLIC.USER.ID</code>.
	 */
	public UserRecord setId(Long value) {
		setValue(0, value);
		return this;
	}

	/**
	 * Getter for <code>PUBLIC.USER.ID</code>.
	 */
	public Long getId() {
		return (Long) getValue(0);
	}

	/**
	 * Setter for <code>PUBLIC.USER.EMAIL</code>.
	 */
	public UserRecord setEmail(String value) {
		setValue(1, value);
		return this;
	}

	/**
	 * Getter for <code>PUBLIC.USER.EMAIL</code>.
	 */
	public String getEmail() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>PUBLIC.USER.ENABLED</code>.
	 */
	public UserRecord setEnabled(Boolean value) {
		setValue(2, value);
		return this;
	}

	/**
	 * Getter for <code>PUBLIC.USER.ENABLED</code>.
	 */
	public Boolean getEnabled() {
		return (Boolean) getValue(2);
	}

	/**
	 * Setter for <code>PUBLIC.USER.LASTNAME</code>.
	 */
	public UserRecord setLastname(String value) {
		setValue(3, value);
		return this;
	}

	/**
	 * Getter for <code>PUBLIC.USER.LASTNAME</code>.
	 */
	public String getLastname() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>PUBLIC.USER.NAME</code>.
	 */
	public UserRecord setName(String value) {
		setValue(4, value);
		return this;
	}

	/**
	 * Getter for <code>PUBLIC.USER.NAME</code>.
	 */
	public String getName() {
		return (String) getValue(4);
	}

	/**
	 * Setter for <code>PUBLIC.USER.PASSWORD</code>.
	 */
	public UserRecord setPassword(String value) {
		setValue(5, value);
		return this;
	}

	/**
	 * Getter for <code>PUBLIC.USER.PASSWORD</code>.
	 */
	public String getPassword() {
		return (String) getValue(5);
	}

	/**
	 * Setter for <code>PUBLIC.USER.ROLE</code>.
	 */
	public UserRecord setRole(String value) {
		setValue(6, value);
		return this;
	}

	/**
	 * Getter for <code>PUBLIC.USER.ROLE</code>.
	 */
	public String getRole() {
		return (String) getValue(6);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Long> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record7 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row7<Long, String, Boolean, String, String, String, String> fieldsRow() {
		return (Row7) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row7<Long, String, Boolean, String, String, String, String> valuesRow() {
		return (Row7) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field1() {
		return User.USER.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return User.USER.EMAIL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Boolean> field3() {
		return User.USER.ENABLED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return User.USER.LASTNAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field5() {
		return User.USER.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field6() {
		return User.USER.PASSWORD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field7() {
		return User.USER.ROLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getEmail();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean value3() {
		return getEnabled();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getLastname();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value5() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value6() {
		return getPassword();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value7() {
		return getRole();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value1(Long value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value2(String value) {
		setEmail(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value3(Boolean value) {
		setEnabled(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value4(String value) {
		setLastname(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value5(String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value6(String value) {
		setPassword(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord value7(String value) {
		setRole(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserRecord values(Long value1, String value2, Boolean value3, String value4, String value5, String value6, String value7) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UserRecord
	 */
	public UserRecord() {
		super(User.USER);
	}

	/**
	 * Create a detached, initialised UserRecord
	 */
	public UserRecord(Long id, String email, Boolean enabled, String lastname, String name, String password, String role) {
		super(User.USER);

		setValue(0, id);
		setValue(1, email);
		setValue(2, enabled);
		setValue(3, lastname);
		setValue(4, name);
		setValue(5, password);
		setValue(6, role);
	}
}