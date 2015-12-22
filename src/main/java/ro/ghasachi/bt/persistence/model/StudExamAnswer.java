package ro.ghasachi.bt.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "studExamAnswer")
public class StudExamAnswer extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7772609942749193979L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String value;
	@ManyToOne(optional = true)
	private ExamItem item;
	@ManyToOne
	private ExamInstance examInstance;

	// API
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ExamItem getItem() {
		return item;
	}

	public void setItem(ExamItem item) {
		this.item = item;
	}

	public ExamInstance getExamInstance() {
		return examInstance;
	}

	public void setExamInstance(ExamInstance examInstance) {
		this.examInstance = examInstance;
	}

	//
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((examInstance == null) ? 0 : examInstance.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		StudExamAnswer other = (StudExamAnswer) obj;
		if (examInstance == null) {
			if (other.examInstance != null)
				return false;
		} else if (!examInstance.equals(other.examInstance))
			return false;
		if (id != other.id)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudExamAnswer [id=" + id + ", value=" + value + ", item=" + item + ", examInstance=" + examInstance
				+ "]";
	}

}
