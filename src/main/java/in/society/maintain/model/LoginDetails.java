package in.society.maintain.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "LOGIN_DETAILS")
public class LoginDetails implements Serializable {

	private static final long serialVersionUID = -6004583363863927934L;

	@GenericGenerator(name = "userIdGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "socUser") )
	@Id
	@GeneratedValue(generator = "userIdGenerator")
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long userId;

	@Column(name = "USER_NAME", nullable = false, unique = true, length = 45)
	private String userName;

	@Column(name = "PASSWORD", nullable = false, length = 60)
	private String password;

	@Column(name = "ENABLED", nullable = false)
	private boolean isEnabled;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loginDetails")
	private Set<UserRole> roles = new HashSet<UserRole>(0);

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private SocUser socUser;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public SocUser getSocUser() {
		return socUser;
	}

	public void setSocUser(SocUser socUser) {
		this.socUser = socUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		LoginDetails other = (LoginDetails) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
