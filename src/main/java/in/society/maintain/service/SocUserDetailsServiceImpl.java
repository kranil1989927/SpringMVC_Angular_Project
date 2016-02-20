package in.society.maintain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.dao.SocUserDetailsDAO;
import in.society.maintain.model.SocUser;

/**
 * This contains the business logic of User management module
 * @author ANIL
 *
 */
@Service
public class SocUserDetailsServiceImpl implements SocUserDetailsService {
	
	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(SocUserDetailsServiceImpl.class);

	/** socUserDAO represents the user management related DAO operations*/
	@Autowired
	private SocUserDetailsDAO socUserDAO;
	
	/** userDetailServiceHelper it take cares of user management service overhead*/
	@Autowired
	private SocUserDetailsServiceHelper socUserDetailsServiceHelper;
	
	@Override
	public String addSocUser(SocUserDetailsVO socUserDetailsVO) throws SocietyMaintenanceException {
		String userName = null;
		
		
		try {
			//UserDetailServiceHelper userDetailServiceHelper = new UserDetailServiceHelper(); 
			SocUser socUser = socUserDetailsServiceHelper.populateSocUser(socUserDetailsVO);
			//userName = userDAO.addSocUser(socUser);
		} catch (Exception e) {
			System.out.println("Execption while adding user");
			throw new SocietyMaintenanceException(e.getMessage(), e);
		}
		return userName;
	}

	@Override
	public List<UserDetailsVO> getAllUsers() throws SocietyMaintenanceException {
		//List<User> user=userDAO.getAllUsers();
		//List<UserDetailsVO> userDetailsVOList=userDetailServiceHelper.populateUserDetailVOList(user);
		return null;
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
	public UserDetailsVO getUserDetails(Long userId) throws SocietyMaintenanceException {
		LOGGER.debug("Method to fetch the society user details for the user id :{} ", userId);
		
		return null;
	}

	public SocUserDetailsDAO getSocUserDAO() {
		return socUserDAO;
	}

	public void setSocUserDAO(SocUserDetailsDAO socUserDAO) {
		this.socUserDAO = socUserDAO;
	}

	public SocUserDetailsServiceHelper getSocUserDetailsServiceHelper() {
		return socUserDetailsServiceHelper;
	}

	public void setSocUserDetailsServiceHelper(SocUserDetailsServiceHelper socUserDetailsServiceHelper) {
		this.socUserDetailsServiceHelper = socUserDetailsServiceHelper;
	}
	
}
