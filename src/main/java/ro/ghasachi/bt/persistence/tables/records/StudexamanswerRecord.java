/**
 * This class is generated by jOOQ
 */
package ro.ghasachi.bt.persistence.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import ro.ghasachi.bt.persistence.tables.Studexamanswer;


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
public class StudexamanswerRecord extends UpdatableRecordImpl<StudexamanswerRecord> implements Record4<Long, String, Long, Long> {

	private static final long serialVersionUID = 115743668;

	/**
	 * Setter for <code>PUBLIC.STUDEXAMANSWER.ID</code>.
	 */
	public StudexamanswerRecord setId(Long value) {
		setValue(0, value);
		return this;
	}

	/**
	 * Getter for <code>PUBLIC.STUDEXAMANSWER.ID</code>.
	 */
	public Long getId() {
		return (Long) getValue(0);
	}

	/**
	 * Setter for <code>PUBLIC.STUDEXAMANSWER.VALUE</code>.
	 */
	public StudexamanswerRecord setValue(String value) {
		setValue(1, value);
		return this;
	}

	/**
	 * Getter for <code>PUBLIC.STUDEXAMANSWER.VALUE</code>.
	 */
	public String getValue() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>PUBLIC.STUDEXAMANSWER.EXAMINSTANCE_ID</code>.
	 */
	public StudexamanswerRecord setExaminstanceId(Long value) {
		setValue(2, value);
		return this;
	}

	/**
	 * Getter for <code>PUBLIC.STUDEXAMANSWER.EXAMINSTANCE_ID</code>.
	 */
	public Long getExaminstanceId() {
		return (Long) getValue(2);
	}

	/**
	 * Setter for <code>PUBLIC.STUDEXAMANSWER.ITEM_ID</code>.
	 */
	public StudexamanswerRecord setItemId(Long value) {
		setValue(3, value);
		return this;
	}

	/**
	 * Getter for <code>PUBLIC.STUDEXAMANSWER.ITEM_ID</code>.
	 */
	public Long getItemId() {
		return (Long) getValue(3);
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
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Long, String, Long, Long> fieldsRow() {
		return (Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Long, String, Long, Long> valuesRow() {
		return (Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field1() {
		return Studexamanswer.STUDEXAMANSWER.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Studexamanswer.STUDEXAMANSWER.VALUE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field3() {
		return Studexamanswer.STUDEXAMANSWER.EXAMINSTANCE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field4() {
		return Studexamanswer.STUDEXAMANSWER.ITEM_ID;
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
		return getValue();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value3() {
		return getExaminstanceId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value4() {
		return getItemId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StudexamanswerRecord value1(Long value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StudexamanswerRecord value2(String value) {
		setValue(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StudexamanswerRecord value3(Long value) {
		setExaminstanceId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StudexamanswerRecord value4(Long value) {
		setItemId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StudexamanswerRecord values(Long value1, String value2, Long value3, Long value4) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached StudexamanswerRecord
	 */
	public StudexamanswerRecord() {
		super(Studexamanswer.STUDEXAMANSWER);
	}

	/**
	 * Create a detached, initialised StudexamanswerRecord
	 */
	public StudexamanswerRecord(Long id, String value, Long examinstanceId, Long itemId) {
		super(Studexamanswer.STUDEXAMANSWER);

		setValue(0, id);
		setValue(1, value);
		setValue(2, examinstanceId);
		setValue(3, itemId);
	}
}
