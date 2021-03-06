/**
 * This class is generated by jOOQ
 */
package ro.ghasachi.bt.persistence.tables.records;


import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import ro.ghasachi.bt.persistence.tables.Egroupuser;


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
public class EgroupuserRecord extends UpdatableRecordImpl<EgroupuserRecord> implements Record3<Integer, Integer, Integer> {

	private static final long serialVersionUID = -207484031;

	/**
	 * Setter for <code>mydb.egroupuser.id</code>.
	 */
	public EgroupuserRecord setId(Integer value) {
		setValue(0, value);
		return this;
	}

	/**
	 * Getter for <code>mydb.egroupuser.id</code>.
	 */
	@NotNull
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>mydb.egroupuser.groupid</code>.
	 */
	public EgroupuserRecord setGroupid(Integer value) {
		setValue(1, value);
		return this;
	}

	/**
	 * Getter for <code>mydb.egroupuser.groupid</code>.
	 */
	@NotNull
	public Integer getGroupid() {
		return (Integer) getValue(1);
	}

	/**
	 * Setter for <code>mydb.egroupuser.userid</code>.
	 */
	public EgroupuserRecord setUserid(Integer value) {
		setValue(2, value);
		return this;
	}

	/**
	 * Getter for <code>mydb.egroupuser.userid</code>.
	 */
	@NotNull
	public Integer getUserid() {
		return (Integer) getValue(2);
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
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row3<Integer, Integer, Integer> fieldsRow() {
		return (Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row3<Integer, Integer, Integer> valuesRow() {
		return (Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Egroupuser.EGROUPUSER.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return Egroupuser.EGROUPUSER.GROUPID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field3() {
		return Egroupuser.EGROUPUSER.USERID;
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
	public Integer value2() {
		return getGroupid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value3() {
		return getUserid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EgroupuserRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EgroupuserRecord value2(Integer value) {
		setGroupid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EgroupuserRecord value3(Integer value) {
		setUserid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EgroupuserRecord values(Integer value1, Integer value2, Integer value3) {
		value1(value1);
		value2(value2);
		value3(value3);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached EgroupuserRecord
	 */
	public EgroupuserRecord() {
		super(Egroupuser.EGROUPUSER);
	}

	/**
	 * Create a detached, initialised EgroupuserRecord
	 */
	public EgroupuserRecord(Integer id, Integer groupid, Integer userid) {
		super(Egroupuser.EGROUPUSER);

		setValue(0, id);
		setValue(1, groupid);
		setValue(2, userid);
	}
}
