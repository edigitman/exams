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
public class Examinstance implements Serializable {

	private static final long serialVersionUID = 1368973084;

	private Integer   id;
	private String    name;
	private Integer   status;
	private Timestamp startdate;
	private Timestamp enddate;
	private Long      points;
	private Integer   examid;
	private Integer   egroupid;
	private Timestamp datecreated;

	public Examinstance() {}

	public Examinstance(Examinstance value) {
		this.id = value.id;
		this.name = value.name;
		this.status = value.status;
		this.startdate = value.startdate;
		this.enddate = value.enddate;
		this.points = value.points;
		this.examid = value.examid;
		this.egroupid = value.egroupid;
		this.datecreated = value.datecreated;
	}

	public Examinstance(
		Integer   id,
		String    name,
		Integer   status,
		Timestamp startdate,
		Timestamp enddate,
		Long      points,
		Integer   examid,
		Integer   egroupid,
		Timestamp datecreated
	) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.startdate = startdate;
		this.enddate = enddate;
		this.points = points;
		this.examid = examid;
		this.egroupid = egroupid;
		this.datecreated = datecreated;
	}

	@NotNull
	public Integer getId() {
		return this.id;
	}

	public Examinstance setId(Integer id) {
		this.id = id;
		return this;
	}

	@NotNull
	@Size(max = 45)
	public String getName() {
		return this.name;
	}

	public Examinstance setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getStatus() {
		return this.status;
	}

	public Examinstance setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Timestamp getStartdate() {
		return this.startdate;
	}

	public Examinstance setStartdate(Timestamp startdate) {
		this.startdate = startdate;
		return this;
	}

	public Timestamp getEnddate() {
		return this.enddate;
	}

	public Examinstance setEnddate(Timestamp enddate) {
		this.enddate = enddate;
		return this;
	}

	public Long getPoints() {
		return this.points;
	}

	public Examinstance setPoints(Long points) {
		this.points = points;
		return this;
	}

	public Integer getExamid() {
		return this.examid;
	}

	public Examinstance setExamid(Integer examid) {
		this.examid = examid;
		return this;
	}

	public Integer getEgroupid() {
		return this.egroupid;
	}

	public Examinstance setEgroupid(Integer egroupid) {
		this.egroupid = egroupid;
		return this;
	}

	@NotNull
	public Timestamp getDatecreated() {
		return this.datecreated;
	}

	public Examinstance setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Examinstance (");

		sb.append(id);
		sb.append(", ").append(name);
		sb.append(", ").append(status);
		sb.append(", ").append(startdate);
		sb.append(", ").append(enddate);
		sb.append(", ").append(points);
		sb.append(", ").append(examid);
		sb.append(", ").append(egroupid);
		sb.append(", ").append(datecreated);

		sb.append(")");
		return sb.toString();
	}
}
