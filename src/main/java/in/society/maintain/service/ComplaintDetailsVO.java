package in.society.maintain.service;

import java.util.Date;

public class ComplaintDetailsVO {

	private Long complaintNo;
	private String complaintType;
	private String complaintDescription;
	private String phoneNo;
	private Date availableTime;
	private String complaintStatus;
	private String complaintLog;

	public Long getComplaintNo() {
		return complaintNo;
	}

	public void setComplaintNo(Long complaintNo) {
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

	public Date getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(Date availableTime) {
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

}
