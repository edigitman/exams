/**
 * This class is generated by jOOQ
 */
package ro.ghasachi.bt.persistence.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
public class Exam implements Serializable {

	private static final long serialVersionUID = -1211791173;

	private Integer   id;
	private String    name;
	private Integer   userid;
	private String    dificulty;
	private Timestamp datecreated;

	public Exam() {}

	public Exam(Exam value) {
		this.id = value.id;
		this.name = value.name;
		this.userid = value.userid;
		this.dificulty = value.dificulty;
		this.datecreated = value.datecreated;
	}

	public Exam(
		Integer   id,
		String    name,
		Integer   userid,
		String    dificulty,
		Timestamp datecreated
	) {
		this.id = id;
		this.name = name;
		this.userid = userid;
		this.dificulty = dificulty;
		this.datecreated = datecreated;
	}

	@NotNull
	public Integer getId() {
		return this.id;
	}

	public Exam setId(Integer id) {
		this.id = id;
		return this;
	}

	@NotNull
	@Size(max = 100)
	public String getName() {
		return this.name;
	}

	public Exam setName(String name) {
		this.name = name;
		return this;
	}

	@NotNull
	public Integer getUserid() {
		return this.userid;
	}

	public Exam setUserid(Integer userid) {
		this.userid = userid;
		return this;
	}

	@Size(max = 10)
	public String getDificulty() {
		return this.dificulty;
	}

	public Exam setDificulty(String dificulty) {
		this.dificulty = dificulty;
		return this;
	}

	@NotNull
	public Timestamp getDatecreated() {
		return this.datecreated;
	}

	public Exam setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Exam (");

		sb.append(id);
		sb.append(", ").append(name);
		sb.append(", ").append(userid);
		sb.append(", ").append(dificulty);
		sb.append(", ").append(datecreated);

		sb.append(")");
		return sb.toString();
	}
}
