package in.society.maintain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "AMENITY_DETAIL")
public class AmenityDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AMENITY_ID", unique = true, nullable = false)
	private Long amenityId;

	@Column(name = "AMENITY_TYPE")
	private String amenityType;

	@Column(name = "AMENITY_STATUS")
	private String amenityStatus;

	@Column(name = "USER_NAME")
	private String userName;

	@Temporal(TemporalType.TIME)
	@Column(name = "START_DATE")
	private Date startDate;

	@Temporal(TemporalType.TIME)
	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "AMENITY_NOTES")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amenityId == null) ? 0 : amenityId.hashCode());
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
		AmenityDetail other = (AmenityDetail) obj;
		if (amenityId == null) {
			if (other.amenityId != null)
				return false;
		} else if (!amenityId.equals(other.amenityId))
			return false;
		return true;
	}

}
