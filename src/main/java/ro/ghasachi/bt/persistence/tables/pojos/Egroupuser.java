/**
 * This class is generated by jOOQ
 */
package ro.ghasachi.bt.persistence.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;


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
public class Egroupuser implements Serializable {

	private static final long serialVersionUID = 1900331592;

	private Integer id;
	private Integer groupid;
	private Integer userid;

	public Egroupuser() {}

	public Egroupuser(Egroupuser value) {
		this.id = value.id;
		this.groupid = value.groupid;
		this.userid = value.userid;
	}

	public Egroupuser(
		Integer id,
		Integer groupid,
		Integer userid
	) {
		this.id = id;
		this.groupid = groupid;
		this.userid = userid;
	}

	@NotNull
	public Integer getId() {
		return this.id;
	}

	public Egroupuser setId(Integer id) {
		this.id = id;
		return this;
	}

	@NotNull
	public Integer getGroupid() {
		return this.groupid;
	}

	public Egroupuser setGroupid(Integer groupid) {
		this.groupid = groupid;
		return this;
	}

	@NotNull
	public Integer getUserid() {
		return this.userid;
	}

	public Egroupuser setUserid(Integer userid) {
		this.userid = userid;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Egroupuser (");

		sb.append(id);
		sb.append(", ").append(groupid);
		sb.append(", ").append(userid);

		sb.append(")");
		return sb.toString();
	}
}
