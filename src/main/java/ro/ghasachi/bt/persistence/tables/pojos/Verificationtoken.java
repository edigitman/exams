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
public class Verificationtoken implements Serializable {

	private static final long serialVersionUID = 886813197;

	private Integer   id;
	private Timestamp expiredate;
	private String    token;
	private Byte      verified;
	private Integer   userid;
	private Timestamp datecreated;

	public Verificationtoken() {}

	public Verificationtoken(Verificationtoken value) {
		this.id = value.id;
		this.expiredate = value.expiredate;
		this.token = value.token;
		this.verified = value.verified;
		this.userid = value.userid;
		this.datecreated = value.datecreated;
	}

	public Verificationtoken(
		Integer   id,
		Timestamp expiredate,
		String    token,
		Byte      verified,
		Integer   userid,
		Timestamp datecreated
	) {
		this.id = id;
		this.expiredate = expiredate;
		this.token = token;
		this.verified = verified;
		this.userid = userid;
		this.datecreated = datecreated;
	}

	@NotNull
	public Integer getId() {
		return this.id;
	}

	public Verificationtoken setId(Integer id) {
		this.id = id;
		return this;
	}

	@NotNull
	public Timestamp getExpiredate() {
		return this.expiredate;
	}

	public Verificationtoken setExpiredate(Timestamp expiredate) {
		this.expiredate = expiredate;
		return this;
	}

	@NotNull
	@Size(max = 37)
	public String getToken() {
		return this.token;
	}

	public Verificationtoken setToken(String token) {
		this.token = token;
		return this;
	}

	public Byte getVerified() {
		return this.verified;
	}

	public Verificationtoken setVerified(Byte verified) {
		this.verified = verified;
		return this;
	}

	@NotNull
	public Integer getUserid() {
		return this.userid;
	}

	public Verificationtoken setUserid(Integer userid) {
		this.userid = userid;
		return this;
	}

	@NotNull
	public Timestamp getDatecreated() {
		return this.datecreated;
	}

	public Verificationtoken setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Verificationtoken (");

		sb.append(id);
		sb.append(", ").append(expiredate);
		sb.append(", ").append(token);
		sb.append(", ").append(verified);
		sb.append(", ").append(userid);
		sb.append(", ").append(datecreated);

		sb.append(")");
		return sb.toString();
	}
}
