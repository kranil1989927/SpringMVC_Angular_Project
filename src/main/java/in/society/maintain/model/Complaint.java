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

	@Column(name = "STATUS")
	private String complaintStatus;

	@Column(name = "COMPLAINT_LOG")
	private String complaintLog;

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

	public String getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	public String getComplaintLog() {
		return complaintLog;
	}

	public void setComplaintLog(String complaintLog) {
		this.complaintLog = complaintLog;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((complaintNo == null) ? 0 : complaintNo.hashCode());
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
		Complaint other = (Complaint) obj;
		if (complaintNo == null) {
			if (other.complaintNo != null)
				return false;
		} else if (!complaintNo.equals(other.complaintNo))
			return false;
		return true;
	}

}
