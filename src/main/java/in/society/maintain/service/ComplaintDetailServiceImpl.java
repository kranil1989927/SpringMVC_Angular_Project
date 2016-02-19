package in.society.maintain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.controller.ComplaintDetailsFormBean;
import in.society.maintain.controller.UserControllerHelper;
import in.society.maintain.dao.ComplaintDAO;
import in.society.maintain.dao.UserDAO;
import in.society.maintain.model.Complaint;
import in.society.maintain.model.User;


@Service
public class ComplaintDetailServiceImpl implements ComplaintDetailService {

	@Autowired
	private ComplaintDAO complaintDAO;
	
	@Autowired
	private ComplaintDetailServiceHelper complaintDetailServiceHelper;
	




	public void setComplaintDAO(ComplaintDAO complaintDAO) {
		this.complaintDAO = complaintDAO;
	}



	@Override
	@Transactional
	public String raiseComplaint(ComplaintDetailsVO complaintDetailsVO) throws SocietyMaintenanceException {
		String userName = null;
		try {
			//UserDetailServiceHelper userDetailServiceHelper = new UserDetailServiceHelper(); 
			Complaint complaint = complaintDetailServiceHelper.populateComplaint(complaintDetailsVO);
			System.out.println("in  raiseComplaint Service");
			userName = complaintDAO.raiseComplaint(complaint);
		} catch (Exception e) {
			System.out.println("Execption while adding  Complaint");
			throw new SocietyMaintenanceException(e.getMessage(), e);
		}
		return userName;
	}



	@Override
	public UserDetailsVO updateUser(UserDetailsVO userDetail) throws SocietyMaintenanceException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String deleteUser(Integer userId) throws SocietyMaintenanceException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public UserDetailsVO getUserDetails(Integer userId) throws SocietyMaintenanceException {
		// TODO Auto-generated method stub
		return null;
	}






	@Override
	@Transactional
	public List<ComplaintDetailsVO> getAllComplaints() throws SocietyMaintenanceException {
		
		List<Complaint> complaint=complaintDAO.getAllComplaints();
		List<ComplaintDetailsVO> ComplaintDetailsVOList=complaintDetailServiceHelper.populateComplaintDetailVOList(complaint);
		return ComplaintDetailsVOList;
	}

}
