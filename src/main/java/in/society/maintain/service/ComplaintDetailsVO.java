package in.society.maintain.service;

public class ComplaintDetailsVO {

	private Integer complaintNo;
	private String complaintType;
	private String complaintDescription;
	private String phoneNo;
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

	public void setPhoneNo(String string) {
		this.phoneNo = string;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

}
