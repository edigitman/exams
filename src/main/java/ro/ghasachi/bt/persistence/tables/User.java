/**
 * This class is generated by jOOQ
 */
package ro.ghasachi.bt.persistence.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import ro.ghasachi.bt.persistence.Keys;
import ro.ghasachi.bt.persistence.Public;
import ro.ghasachi.bt.persistence.tables.records.UserRecord;


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
public class User extends TableImpl<UserRecord> {

	private static final long serialVersionUID = -337901063;

	/**
	 * The reference instance of <code>PUBLIC.USER</code>
	 */
	public static final User USER = new User();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<UserRecord> getRecordType() {
		return UserRecord.class;
	}

	/**
	 * The column <code>PUBLIC.USER.ID</code>.
	 */
	public final TableField<UserRecord, Long> ID = createField("ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>PUBLIC.USER.EMAIL</code>.
	 */
	public final TableField<UserRecord, String> EMAIL = createField("EMAIL", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>PUBLIC.USER.ENABLED</code>.
	 */
	public final TableField<UserRecord, Boolean> ENABLED = createField("ENABLED", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

	/**
	 * The column <code>PUBLIC.USER.LASTNAME</code>.
	 */
	public final TableField<UserRecord, String> LASTNAME = createField("LASTNAME", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>PUBLIC.USER.NAME</code>.
	 */
	public final TableField<UserRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * The column <code>PUBLIC.USER.PASSWORD</code>.
	 */
	public final TableField<UserRecord, String> PASSWORD = createField("PASSWORD", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>PUBLIC.USER.ROLE</code>.
	 */
	public final TableField<UserRecord, String> ROLE = createField("ROLE", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * Create a <code>PUBLIC.USER</code> table reference
	 */
	public User() {
		this("USER", null);
	}

	/**
	 * Create an aliased <code>PUBLIC.USER</code> table reference
	 */
	public User(String alias) {
		this(alias, USER);
	}

	private User(String alias, Table<UserRecord> aliased) {
		this(alias, aliased, null);
	}

	private User(String alias, Table<UserRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<UserRecord, Long> getIdentity() {
		return Keys.IDENTITY_USER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<UserRecord> getPrimaryKey() {
		return Keys.CONSTRAINT_27;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<UserRecord>> getKeys() {
		return Arrays.<UniqueKey<UserRecord>>asList(Keys.CONSTRAINT_27);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User as(String alias) {
		return new User(alias, this);
	}

	/**
	 * Rename this table
	 */
	public User rename(String name) {
		return new User(name, null);
	}
}
