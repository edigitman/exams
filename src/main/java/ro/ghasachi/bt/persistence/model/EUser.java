package ro.ghasachi.bt.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by edi on 12/19/2015.
 */
@Entity
@Table(name = "user")
public class EUser extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 197990727073096343L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false)
	private String email;
	private String token;
	private String password;
	private String role;

	@OneToMany(mappedBy = "professor")
	private List<Exam> exams;
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	//

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		EUser eUser = (EUser) o;

		if (id != eUser.id)
			return false;
		if (name != null ? !name.equals(eUser.name) : eUser.name != null)
			return false;
		if (lastname != null ? !lastname.equals(eUser.lastname) : eUser.lastname != null)
			return false;
		return !(email != null ? !email.equals(eUser.email) : eUser.email != null);

	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "EUser{" + "id=" + id + ", name='" + name + '\'' + ", lastname='" + lastname + '\'' + ", email='" + email
				+ '\'' + ", token='" + token + '\'' + ", password='" + password + '\'' + '}';
	}
}
