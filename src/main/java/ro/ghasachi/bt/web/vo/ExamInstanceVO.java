package ro.ghasachi.bt.web.vo;

import java.math.BigDecimal;
import java.util.Date;

import ro.ghasachi.bt.persistence.tables.pojos.Examinstance;


public class ExamInstanceVO {

	private int id;
	private String name;
	private Date startDate;
	private Date endDate;
	private int status;
	private long points;
	private int examId;
	private int groupId;
	private ExamVO exam;
	private ExamGroupVO examGroup;

	public ExamInstanceVO() {
	}

	public ExamInstanceVO(int id, String name, Date startDate, int status) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.status = status;
	}

	public ExamInstanceVO(Examinstance instance) {
		this.name = instance.getName();
		this.startDate = instance.getStartdate();
		this.endDate = instance.getEnddate();
		this.status = instance.getStatus();
		this.points = instance.getPoints();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public long getPoints() {
		return points;
	}

	public void setPoints(long points) {
		this.points = points;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public ExamVO getExam() {
		return exam;
	}

	public void setExam(ExamVO exam) {
		this.exam = exam;
	}

	public ExamGroupVO getExamGroup() {
		return examGroup;
	}

	public void setExamGroup(ExamGroupVO examGroup) {
		this.examGroup = examGroup;
	}
}
