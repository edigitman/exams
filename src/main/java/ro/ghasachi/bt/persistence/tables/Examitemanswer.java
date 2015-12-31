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
import ro.ghasachi.bt.persistence.Mydb;
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

	private static final long serialVersionUID = -120024901;

	/**
	 * The reference instance of <code>mydb.examitemanswer</code>
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
	 * The column <code>mydb.examitemanswer.id</code>.
	 */
	public final TableField<ExamitemanswerRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>mydb.examitemanswer.correct</code>.
	 */
	public final TableField<ExamitemanswerRecord, Byte> CORRECT = createField("correct", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

	/**
	 * The column <code>mydb.examitemanswer.value</code>.
	 */
	public final TableField<ExamitemanswerRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

	/**
	 * The column <code>mydb.examitemanswer.itemid</code>.
	 */
	public final TableField<ExamitemanswerRecord, Integer> ITEMID = createField("itemid", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * Create a <code>mydb.examitemanswer</code> table reference
	 */
	public Examitemanswer() {
		this("examitemanswer", null);
	}

	/**
	 * Create an aliased <code>mydb.examitemanswer</code> table reference
	 */
	public Examitemanswer(String alias) {
		this(alias, EXAMITEMANSWER);
	}

	private Examitemanswer(String alias, Table<ExamitemanswerRecord> aliased) {
		this(alias, aliased, null);
	}

	private Examitemanswer(String alias, Table<ExamitemanswerRecord> aliased, Field<?>[] parameters) {
		super(alias, Mydb.MYDB, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<ExamitemanswerRecord, Integer> getIdentity() {
		return Keys.IDENTITY_EXAMITEMANSWER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<ExamitemanswerRecord> getPrimaryKey() {
		return Keys.KEY_EXAMITEMANSWER_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<ExamitemanswerRecord>> getKeys() {
		return Arrays.<UniqueKey<ExamitemanswerRecord>>asList(Keys.KEY_EXAMITEMANSWER_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<ExamitemanswerRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<ExamitemanswerRecord, ?>>asList(Keys.ITEM_FK);
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
