package in.society.maintain.service;

import java.util.Date;

public class AmenityDetailsVO {

	private Long amenityId;
	private String amenityType;
	private String amenityStatus;
	private String userName;
	private Date startDate;
	private Date endDate;
	private String notes;

	public Long getAmenityId() {
		return amenityId;
	}

	public void setAmenityId(Long amenityId) {
		this.amenityId = amenityId;
	}

	public String getAmenityType() {
		return amenityType;
	}

	public void setAmenityType(String amenityType) {
		this.amenityType = amenityType;
	}

	public String getAmenityStatus() {
		return amenityStatus;
	}

	public void setAmenityStatus(String amenityStatus) {
		this.amenityStatus = amenityStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
