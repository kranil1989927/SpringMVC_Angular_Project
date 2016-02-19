package in.society.maintain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="MODULES")
public class Module {

	@Id
	@Column(name = "MODULE_ID", unique = true, nullable = false)
	private Integer moduleId;
	@Column(name = "MODULE_NAME")
	private String moduleName;
	@Column(name = "MODULE_URL")
	private String moduleUrl;
	@Column(name = "ADMIN_ROLE")
	private String adminRole;
	@Column(name = "USER_ROLE")
	private String userRole;
	@Column(name = "EMPLOYEE_ROLE")
	private String employeeRole;
	@Column(name = "MODULE_TOP_NAME")
	private String moduleTopName;
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleUrl() {
		return moduleUrl;
	}
	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}

	public String getModuleTopName() {
		return moduleTopName;
	}
	public void setModuleTopName(String moduleTopName) {
		this.moduleTopName = moduleTopName;
	}
	public String getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getEmployeeRole() {
		return employeeRole;
	}
	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	

}
