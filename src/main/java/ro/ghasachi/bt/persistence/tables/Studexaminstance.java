/**
 * This class is generated by jOOQ
 */
package ro.ghasachi.bt.persistence.tables;


import java.sql.Timestamp;
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
import ro.ghasachi.bt.persistence.tables.records.StudexaminstanceRecord;


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
public class Studexaminstance extends TableImpl<StudexaminstanceRecord> {

	private static final long serialVersionUID = 160050411;

	/**
	 * The reference instance of <code>mydb.studexaminstance</code>
	 */
	public static final Studexaminstance STUDEXAMINSTANCE = new Studexaminstance();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<StudexaminstanceRecord> getRecordType() {
		return StudexaminstanceRecord.class;
	}

	/**
	 * The column <code>mydb.studexaminstance.id</code>.
	 */
	public final TableField<StudexaminstanceRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>mydb.studexaminstance.examid</code>.
	 */
	public final TableField<StudexaminstanceRecord, Integer> EXAMID = createField("examid", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>mydb.studexaminstance.userid</code>.
	 */
	public final TableField<StudexaminstanceRecord, Integer> USERID = createField("userid", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>mydb.studexaminstance.status</code>.
	 */
	public final TableField<StudexaminstanceRecord, Integer> STATUS = createField("status", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>mydb.studexaminstance.datecreated</code>.
	 */
	public final TableField<StudexaminstanceRecord, Timestamp> DATECREATED = createField("datecreated", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>mydb.studexaminstance.dateupdated</code>.
	 */
	public final TableField<StudexaminstanceRecord, Timestamp> DATEUPDATED = createField("dateupdated", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * Create a <code>mydb.studexaminstance</code> table reference
	 */
	public Studexaminstance() {
		this("studexaminstance", null);
	}

	/**
	 * Create an aliased <code>mydb.studexaminstance</code> table reference
	 */
	public Studexaminstance(String alias) {
		this(alias, STUDEXAMINSTANCE);
	}

	private Studexaminstance(String alias, Table<StudexaminstanceRecord> aliased) {
		this(alias, aliased, null);
	}

	private Studexaminstance(String alias, Table<StudexaminstanceRecord> aliased, Field<?>[] parameters) {
		super(alias, Mydb.MYDB, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<StudexaminstanceRecord, Integer> getIdentity() {
		return Keys.IDENTITY_STUDEXAMINSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<StudexaminstanceRecord> getPrimaryKey() {
		return Keys.KEY_STUDEXAMINSTANCE_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<StudexaminstanceRecord>> getKeys() {
		return Arrays.<UniqueKey<StudexaminstanceRecord>>asList(Keys.KEY_STUDEXAMINSTANCE_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<StudexaminstanceRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<StudexaminstanceRecord, ?>>asList(Keys.STUD_EXAM_FK, Keys.STUD_USER_FK);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Studexaminstance as(String alias) {
		return new Studexaminstance(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Studexaminstance rename(String name) {
		return new Studexaminstance(name, null);
	}
}
