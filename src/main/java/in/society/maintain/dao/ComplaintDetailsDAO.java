package in.society.maintain.dao;

import java.util.List;

import in.society.maintain.model.ComplaintDetail;

public interface ComplaintDetailsDAO {

	/**
	 * Method to save or update the complaint details
	 * 
	 * @param complaintDetail {@link ComplaintDetail}
	 * @return Updated or newly raised complaint
	 */
	ComplaintDetail saveOrUpdate(ComplaintDetail complaintDetail);

	/**
	 * Method to get the complaint details based on complaint id.
	 * 
	 * @param complaintId {@link Long}
	 * @return Complaint Detail {@link ComplaintDetail}
	 */
	ComplaintDetail getComplaintDetail(Long complaintId);

	/**
	 * This method is used to get all the existing complaints
	 * 
	 * @return List of complaints {@link List<ComplaintDetail>}
	 */
	List<ComplaintDetail> getAllComplaints();
}
