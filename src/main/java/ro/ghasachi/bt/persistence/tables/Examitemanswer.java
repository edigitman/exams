/**
 * This class is generated by jOOQ
 */
package ro.ghasachi.bt.persistence.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import ro.ghasachi.bt.persistence.Keys;
import ro.ghasachi.bt.persistence.Public;
import ro.ghasachi.bt.persistence.tables.records.ExamitemanswerRecord;


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
public class Examitemanswer extends TableImpl<ExamitemanswerRecord> {

	private static final long serialVersionUID = 1180139495;

	/**
	 * The reference instance of <code>PUBLIC.EXAMITEMANSWER</code>
	 */
	public static final Examitemanswer EXAMITEMANSWER = new Examitemanswer();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<ExamitemanswerRecord> getRecordType() {
		return ExamitemanswerRecord.class;
	}

	/**
	 * The column <code>PUBLIC.EXAMITEMANSWER.ID</code>.
	 */
	public final TableField<ExamitemanswerRecord, Long> ID = createField("ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>PUBLIC.EXAMITEMANSWER.CORRECT</code>.
	 */
	public final TableField<ExamitemanswerRecord, Boolean> CORRECT = createField("CORRECT", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

	/**
	 * The column <code>PUBLIC.EXAMITEMANSWER.VALUE</code>.
	 */
	public final TableField<ExamitemanswerRecord, String> VALUE = createField("VALUE", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>PUBLIC.EXAMITEMANSWER.ITEM_ID</code>.
	 */
	public final TableField<ExamitemanswerRecord, Long> ITEM_ID = createField("ITEM_ID", org.jooq.impl.SQLDataType.BIGINT, this, "");

	/**
	 * Create a <code>PUBLIC.EXAMITEMANSWER</code> table reference
	 */
	public Examitemanswer() {
		this("EXAMITEMANSWER", null);
	}

	/**
	 * Create an aliased <code>PUBLIC.EXAMITEMANSWER</code> table reference
	 */
	public Examitemanswer(String alias) {
		this(alias, EXAMITEMANSWER);
	}

	private Examitemanswer(String alias, Table<ExamitemanswerRecord> aliased) {
		this(alias, aliased, null);
	}

	private Examitemanswer(String alias, Table<ExamitemanswerRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<ExamitemanswerRecord, Long> getIdentity() {
		return Keys.IDENTITY_EXAMITEMANSWER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<ExamitemanswerRecord> getPrimaryKey() {
		return Keys.CONSTRAINT_4;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<ExamitemanswerRecord>> getKeys() {
		return Arrays.<UniqueKey<ExamitemanswerRecord>>asList(Keys.CONSTRAINT_4);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<ExamitemanswerRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<ExamitemanswerRecord, ?>>asList(Keys.FK_3PXCG18V6FWPWR9W6ALU1AW5I);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Examitemanswer as(String alias) {
		return new Examitemanswer(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Examitemanswer rename(String name) {
		return new Examitemanswer(name, null);
	}
}