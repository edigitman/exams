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
@Table(name = "exam")
public class Exam extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6823947371373847143L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String description;
	@ManyToOne
	private EUser professor;
	@OneToMany(mappedBy = "exam")
	private List<ExamItem> items;
	@OneToMany(mappedBy = "exam")
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ExamItem> getItems() {
		return items;
	}

	public void setItems(List<ExamItem> items) {
		this.items = items;
	}

	public EUser getProfessor() {
		return professor;
	}

	public void setProfessor(EUser professor) {
		this.professor = professor;
	}

	public List<ExamInstance> getExamInstances() {
		return examInstances;
	}

	public void setExamInstances(List<ExamInstance> examInstances) {
		this.examInstances = examInstances;
	}

	//
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Exam other = (Exam) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", name=" + name + ", description=" + description + ", items=" + items + "]";
	}

}
