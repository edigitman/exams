package ro.ghasachi.bt.web.vo;

import ro.ghasachi.bt.persistence.tables.pojos.User;

/**
 * Created by edi on 12/19/2015.
 */
public class UserVO {

	private String name;
	private String lastName;
	private String email;
	private String role;
	private String password;
	private String token;

	public UserVO() {
	}

	public UserVO(User user) {
		this.name = user.getName();
		this.lastName = user.getLastname();
		this.email = user.getEmail();
		this.role = user.getRole();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "UserVO{" +
				"name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", role='" + role + '\'' +
				", password='" + password + '\'' +
				", token='" + token + '\'' +
				'}';
	}
}
