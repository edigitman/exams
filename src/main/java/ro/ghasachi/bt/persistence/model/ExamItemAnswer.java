package ro.ghasachi.bt.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "examItemAnswer")
public class ExamItemAnswer extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4542988499914321434L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private boolean correct;
	private String value;
	@ManyToOne
	private ExamItem item;

	// API
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
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

	//
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (correct ? 1231 : 1237);
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
		ExamItemAnswer other = (ExamItemAnswer) obj;
		if (correct != other.correct)
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
		return "ExamItemAnswer [id=" + id + ", correct=" + correct + ", value=" + value + ", item=" + item + "]";
	}
}
