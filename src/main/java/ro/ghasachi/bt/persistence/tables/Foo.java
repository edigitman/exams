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
import ro.ghasachi.bt.persistence.tables.records.FooRecord;


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
public class Foo extends TableImpl<FooRecord> {

	private static final long serialVersionUID = 1322404721;

	/**
	 * The reference instance of <code>PUBLIC.FOO</code>
	 */
	public static final Foo FOO = new Foo();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<FooRecord> getRecordType() {
		return FooRecord.class;
	}

	/**
	 * The column <code>PUBLIC.FOO.ID</code>.
	 */
	public final TableField<FooRecord, Long> ID = createField("ID", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>PUBLIC.FOO.NAME</code>.
	 */
	public final TableField<FooRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * Create a <code>PUBLIC.FOO</code> table reference
	 */
	public Foo() {
		this("FOO", null);
	}

	/**
	 * Create an aliased <code>PUBLIC.FOO</code> table reference
	 */
	public Foo(String alias) {
		this(alias, FOO);
	}

	private Foo(String alias, Table<FooRecord> aliased) {
		this(alias, aliased, null);
	}

	private Foo(String alias, Table<FooRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<FooRecord, Long> getIdentity() {
		return Keys.IDENTITY_FOO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<FooRecord> getPrimaryKey() {
		return Keys.CONSTRAINT_1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<FooRecord>> getKeys() {
		return Arrays.<UniqueKey<FooRecord>>asList(Keys.CONSTRAINT_1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Foo as(String alias) {
		return new Foo(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Foo rename(String name) {
		return new Foo(name, null);
	}
}