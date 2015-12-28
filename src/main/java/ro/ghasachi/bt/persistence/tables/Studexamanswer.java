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
public class Studexamanswer extends TableImpl<StudexamanswerRecord> {

	private static final long serialVersionUID = -703165032;

	/**
	 * The reference instance of <code>PUBLIC.STUDEXAMANSWER</code>
	 */
	public static final Studexamanswer STUDEXAMANSWER = new Studexamanswer();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<StudexamanswerRecord> getRecordType() {
		return StudexamanswerRecord.class;
	}

	/**
	 * The column <code>PUBLIC.STUDEXAMANSWER.ID</code>.
	 */
	public final TableField<StudexamanswerRecord, Long> ID = createField("ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>PUBLIC.STUDEXAMANSWER.VALUE</code>.
	 */
	public final TableField<StudexamanswerRecord, String> VALUE = createField("VALUE", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>PUBLIC.STUDEXAMANSWER.EXAMINSTANCE_ID</code>.
	 */
	public final TableField<StudexamanswerRecord, Long> EXAMINSTANCE_ID = createField("EXAMINSTANCE_ID", org.jooq.impl.SQLDataType.BIGINT, this, "");

	/**
	 * The column <code>PUBLIC.STUDEXAMANSWER.ITEM_ID</code>.
	 */
	public final TableField<StudexamanswerRecord, Long> ITEM_ID = createField("ITEM_ID", org.jooq.impl.SQLDataType.BIGINT, this, "");

	/**
	 * Create a <code>PUBLIC.STUDEXAMANSWER</code> table reference
	 */
	public Studexamanswer() {
		this("STUDEXAMANSWER", null);
	}

	/**
	 * Create an aliased <code>PUBLIC.STUDEXAMANSWER</code> table reference
	 */
	public Studexamanswer(String alias) {
		this(alias, STUDEXAMANSWER);
	}

	private Studexamanswer(String alias, Table<StudexamanswerRecord> aliased) {
		this(alias, aliased, null);
	}

	private Studexamanswer(String alias, Table<StudexamanswerRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<StudexamanswerRecord, Long> getIdentity() {
		return Keys.IDENTITY_STUDEXAMANSWER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<StudexamanswerRecord> getPrimaryKey() {
		return Keys.CONSTRAINT_24;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<StudexamanswerRecord>> getKeys() {
		return Arrays.<UniqueKey<StudexamanswerRecord>>asList(Keys.CONSTRAINT_24);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<StudexamanswerRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<StudexamanswerRecord, ?>>asList(Keys.FK_E0CPK002DT9NL0O5JVMKQ02HO, Keys.FK_JDAMVHEKGX8LTM0PAUOBGAKW9);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Studexamanswer as(String alias) {
		return new Studexamanswer(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Studexamanswer rename(String name) {
		return new Studexamanswer(name, null);
	}
}
