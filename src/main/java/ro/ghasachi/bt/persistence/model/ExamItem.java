package ro.ghasachi.bt.persistence.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "examItem")
public class ExamItem extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -312573207398755796L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String assertion;
	private int points;
	private int dificulty;
	private int type;
	@ManyToOne
	private Exam exam;
	@OneToMany(mappedBy = "item")
	private List<ExamItemAnswer> answers;

	// API
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAssertion() {
		return assertion;
	}

	public void setAssertion(String assertion) {
		this.assertion = assertion;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getDificulty() {
		return dificulty;
	}

	public void setDificulty(int dificulty) {
		this.dificulty = dificulty;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public List<ExamItemAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<ExamItemAnswer> answers) {
		this.answers = answers;
	}

	//
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assertion == null) ? 0 : assertion.hashCode());
		result = prime * result + dificulty;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + points;
		result = prime * result + type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExamItem other = (ExamItem) obj;
		if (assertion == null) {
			if (other.assertion != null)
				return false;
		} else if (!assertion.equals(other.assertion))
			return false;
		if (dificulty != other.dificulty)
			return false;
		if (id != other.id)
			return false;
		if (points != other.points)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExamItem [id=" + id + ", assertion=" + assertion + ", points=" + points + ", dificulty=" + dificulty
				+ ", type=" + type + ", exam=" + exam + ", answers=" + answers + "]";
	}
}
