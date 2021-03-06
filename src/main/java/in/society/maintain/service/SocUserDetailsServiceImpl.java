package in.society.maintain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.dao.LoginDetailsDAO;
import in.society.maintain.dao.SocUserDetailsDAO;
import in.society.maintain.model.LoginDetails;
import in.society.maintain.model.SocUser;
import in.society.maintain.model.UserRole;

/**
 * This contains the business logic of User management module
 * 
 * @author ANIL
 *
 */
@Service
public class SocUserDetailsServiceImpl implements SocUserDetailsService {

	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(SocUserDetailsServiceImpl.class);

	/** socUserDAO represents the user management related DAO operations */
	@Autowired
	private SocUserDetailsDAO socUserDAO;

	/** socUserDetailsServiceHelper it take cares of user management service overhead */
	@Autowired
	private SocUserDetailsServiceHelper socUserDetailsServiceHelper;
	
	/** loginUserDetailsService represents the Logged In user related Business operations */
	@Autowired
	private LoginUserDetailsService loginUserDetailsService;
	
	/** loginDetailsDAO represents the LoggedIn user related DAO operations */
	@Autowired
	private LoginDetailsDAO loginDetailsDAO;

	@Override
	@Transactional
	public SocUserDetailsVO saveOrUpdate(SocUserDetailsVO socUserDetailsVO) throws SocietyMaintenanceException {
		LOGGER.debug("Saving Society User Details");
		SocUser socUser = null;
		try {
			socUser = this.getSocUserDetailsServiceHelper().populateSocUserDetailsModelFromVO(socUserDetailsVO);
			// Update existing user
			if (socUserDetailsVO.getUserId() != null) {
				this.getSocUserDAO().saveOrUpdateSocUser(socUser);
			}
			// Create new society user.
			else {
				LoginDetails loginDetails = this.getSocUserDetailsServiceHelper().populateLoginDetailsModelFromVO(socUserDetailsVO);
				loginDetails.setSocUser(socUser);
				socUser.setLoginDetails(loginDetails);
				this.getSocUserDAO().saveOrUpdateSocUser(socUser);

				// Add Roles to User
				// for (UserRoleVO userRoleVO : socUserDetailsVO.getRoles()) {
				UserRoleVO userRoleVO = new UserRoleVO();
				UserRole userRole = new UserRole();
				if (userRoleVO.getRole() == null) {
					userRole.setRole("ROLE_USER");
				} else {
					userRole.setRole(userRoleVO.getRole());
				}
				userRole.setLoginDetails(loginDetails);
				loginDetails.getRoles().add(userRole);
				this.getSocUserDAO().saveOrUpdateUserRole(userRole);
				// }
			}

		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while saving details of society user due to {}", dae.getMessage());
			throw new SocietyMaintenanceException("Exception while saving details of society user due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while saving details of society user of user due to {}", ex.getMessage());
			throw new SocietyMaintenanceException("Exception while saving details of society user due to : " + ex.getMessage(), ex);
		}
		return socUserDetailsVO;
	}

	@Override
	@Transactional
	public Boolean deleteSocUser(Long userId) throws SocietyMaintenanceException {
		Boolean isDeleted = Boolean.FALSE;
		LOGGER.debug("Deleting a society user of user id : {}", userId);
		try {
			isDeleted = this.getSocUserDAO().deleteSocUser(userId);
			LOGGER.info("Society User of user id {} is deleted successfully", userId);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while deleting the society user of user id : {} due to {}", userId, dae.getMessage());
			throw new SocietyMaintenanceException("Exception while deleting the society user of user id : " + userId + "due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while deleting the society user of user id : {} due to {}", userId, ex.getMessage());
			throw new SocietyMaintenanceException("Exception while deleting the society user of user id : " + userId + "due to : " + ex.getMessage(), ex);
		}
		return isDeleted;
	}

	@Override
	@Transactional
	public SocUserDetailsVO getSocUserDetails(Long userId) throws SocietyMaintenanceException {
		SocUserDetailsVO socUserDetailsVO = null;
		LOGGER.debug("Getting a society user details of user id : {}", userId);
		try {
			final SocUser socUser = this.getSocUserDAO().getSocUserDetails(userId);
			socUserDetailsVO = this.getSocUserDetailsServiceHelper().populateSocUserDetailVOFromModel(socUser);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while getting details of society user of user id : {} due to {}", userId, dae.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of society user of user id : " + userId + "due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while getting details of society user of user id : {} due to {}", userId, ex.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of society user of user id : " + userId + "due to : " + ex.getMessage(), ex);
		}
		return socUserDetailsVO;
	}

	@Override
	@Transactional
	public List<SocUserDetailsVO> getAllUsers() throws SocietyMaintenanceException {
		List<SocUserDetailsVO> socUserDetailsVOList = null;
		LOGGER.debug("Getting a details of all society user");
		try {
			final List<SocUser> socUserList = this.getSocUserDAO().getAllSocUsers();
			socUserDetailsVOList = this.getSocUserDetailsServiceHelper().populateSocUserDetailsVOListFromModelList(socUserList);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while getting details of all society user due to {}", dae.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of all society user due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while getting details of all society user due to {}", ex.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of all society user due to : " + ex.getMessage(), ex);
		}
		return socUserDetailsVOList;
	}
	
	@Override
	@Transactional
	public SocUserDetailsVO getSocUserDetailsByUserName(String userName) throws SocietyMaintenanceException {
		SocUserDetailsVO socUserDetailsVO = null;
		LOGGER.debug("Getting a society user details of user name : {}", userName);
		try {
			final LoginDetails loginDetails = this.getLoginDetailsDAO().loadUserByUsername(userName);
			final SocUser socUser = loginDetails.getSocUser();
			socUserDetailsVO = this.getSocUserDetailsServiceHelper().populateSocUserDetailVOFromModel(socUser);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while getting details of society user of user name : {} due to {}", userName, dae.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of society user of user name : " + userName + "due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while getting details of society user of user name : {} due to {}", userName, ex.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of society user of user name : " + userName + "due to : " + ex.getMessage(), ex);
		}
		return socUserDetailsVO;
	}

	public SocUserDetailsDAO getSocUserDAO() {
		return socUserDAO;
	}

	public SocUserDetailsServiceHelper getSocUserDetailsServiceHelper() {
		return socUserDetailsServiceHelper;
	}

	public LoginUserDetailsService getLoginUserDetailsService() {
		return loginUserDetailsService;
	}

	public LoginDetailsDAO getLoginDetailsDAO() {
		return loginDetailsDAO;
	}

}
