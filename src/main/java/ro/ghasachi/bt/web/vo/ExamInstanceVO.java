package ro.ghasachi.bt.web.vo;

import java.util.Date;

import ro.ghasachi.bt.persistence.tables.pojos.Examinstance;


public class ExamInstanceVO {

	private String name;
	private Date startDate;
	private Date endDate;
	private int status;

	public ExamInstanceVO() {
	}

	public ExamInstanceVO(Examinstance instance) {
		this.name = instance.getName();
		this.startDate = instance.getStartdate();
		this.endDate = instance.getEnddate();
		this.status = instance.getStatus();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
