package ro.ghasachi.bt.persistence.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "examGroup")
public class ExamGroup extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -931853341849292361L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	@ManyToMany
	private List<EUser> students;
	@OneToMany(mappedBy = "group")
	private List<ExamInstance> examInstances;

	// API

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EUser> getStudents() {
		return students;
	}

	public void setStudents(List<EUser> students) {
		this.students = students;
	}

	//

	public List<ExamInstance> getExamInstances() {
		return examInstances;
	}

	public void setExamInstances(List<ExamInstance> examInstances) {
		this.examInstances = examInstances;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExamGroup other = (ExamGroup) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExamGroup [id=" + id + ", name=" + name + ", students=" + students + "]";
	}
}
