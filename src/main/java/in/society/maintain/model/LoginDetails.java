package in.society.maintain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOGIN_DETAILS")
public class LoginDetails {

	@Id
	@Column(name = "USER_NAME", nullable = false, unique = true, length = 45)
	private String userName;

	@Column(name = "PASSWORD", nullable = false, length = 60)
	private String password;

	@Column(name = "ENABLED", nullable = false)
	private boolean isEnabled;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loginDetails")
	private Set<UserRole> roles = new HashSet<UserRole>(0);

	public LoginDetails() {
	}

	public LoginDetails(String userName, String password, boolean isEnabled) {
		this.userName = userName;
		this.password = password;
		this.isEnabled = isEnabled;
	}

	public LoginDetails(String userName, String password, boolean isEnabled, Set<UserRole> roles) {
		this.userName = userName;
		this.password = password;
		this.isEnabled = isEnabled;
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

}
