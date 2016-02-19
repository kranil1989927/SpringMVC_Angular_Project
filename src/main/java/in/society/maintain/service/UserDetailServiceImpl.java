package in.society.maintain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.controller.UserControllerHelper;
import in.society.maintain.dao.UserDAO;
import in.society.maintain.model.SocUser;
import in.society.maintain.model.User;


@Service
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserDetailServiceHelper userDetailServiceHelper;
	
	@Override
	@Transactional
	public String addSocUser(SocUserDetailsVO socUserDetailsVO) throws SocietyMaintenanceException {
		String userName = null;
		
		
		try {
			//UserDetailServiceHelper userDetailServiceHelper = new UserDetailServiceHelper(); 
			SocUser socUser = userDetailServiceHelper.populateSocUser(socUserDetailsVO);
			userName = userDAO.addSocUser(socUser);
		} catch (Exception e) {
			System.out.println("Execption while adding user");
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
	public List<UserDetailsVO> getAllUsers() throws SocietyMaintenanceException {
		List<User> user=userDAO.getAllUsers();
		List<UserDetailsVO> userDetailsVOList=userDetailServiceHelper.populateUserDetailVOList(user);
		return userDetailsVOList;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
