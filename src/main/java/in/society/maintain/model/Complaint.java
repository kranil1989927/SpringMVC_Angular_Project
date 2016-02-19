package in.society.maintain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPLAINT")
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPLAINT_NO", unique = true, nullable = false)
	private Integer complaintNo;
	
	@Column(name = "COMPLAINT_TYPE")
	private String complaintType;
	
	@Column(name = "COMPLAINT_DESCRIPTION")
	private String complaintDescription;
	
	@Column(name = "PHONE_NO")
	private String phoneNo;
	
	@Column(name = "AVAILABLE_TIME")
	private String availableTime;

	public Integer getComplaintNo() {
		return complaintNo;
	}

	public void setComplaintNo(Integer complaintNo) {
		this.complaintNo = complaintNo;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public String getComplaintDescription() {
		return complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

}
