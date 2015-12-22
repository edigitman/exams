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
@Table(name = "studExamInstance")
public class StudExamInstance extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -303146281258269800L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	private EUser student;
	@ManyToOne
	private ExamInstance examInstance;
	@OneToMany(mappedBy = "examInstance")
	private List<StudExamAnswer> answers;

	// API
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EUser getStudent() {
		return student;
	}

	public void setStudent(EUser student) {
		this.student = student;
	}

	public ExamInstance getExamInstance() {
		return examInstance;
	}

	public void setExamInstance(ExamInstance examInstance) {
		this.examInstance = examInstance;
	}

	public List<StudExamAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<StudExamAnswer> answers) {
		this.answers = answers;
	}

	//
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
		result = prime * result + ((examInstance == null) ? 0 : examInstance.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		StudExamInstance other = (StudExamInstance) obj;
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		if (examInstance == null) {
			if (other.examInstance != null)
				return false;
		} else if (!examInstance.equals(other.examInstance))
			return false;
		if (id != other.id)
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudExamInstance [id=" + id + ", student=" + student + ", examInstance=" + examInstance + ", answers="
				+ answers + "]";
	}
}
