package in.society.maintain.service;

import java.util.List;

import in.society.maintain.common.SocietyMaintenanceException;

public interface ComplaintDetailService {

	/**
	 * Method to save or update the complaint details
	 * 
	 * @param complaintDetailsVO {@link ComplaintDetailsVO}
	 * @return Updated or newly raised complaint
	 * 
	 * @throws SocietyMaintenanceException
	 */
	ComplaintDetailsVO saveOrUpdate(ComplaintDetailsVO complaintDetailsVO) throws SocietyMaintenanceException;

	/**
	 * Method to get the complaint details based on complaint id.
	 * 
	 * @param complaintId {@link Long}
	 * @return Complaint Details {@link ComplaintDetailsVO}
	 * 
	 * @throws SocietyMaintenanceException
	 */
	ComplaintDetailsVO getComplaintDetail(Long complaintId) throws SocietyMaintenanceException;

	/**
	 * This method is used to get all the existing complaints
	 * 
	 * @return List of complaints {@linkplain List<ComplaintDetailsVO>}
	 * 
	 * @throws SocietyMaintenanceException
	 */
	List<ComplaintDetailsVO> getAllComplaints() throws SocietyMaintenanceException;

}
