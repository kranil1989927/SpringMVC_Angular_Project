package in.society.maintain.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.service.SocUserDetailsService;
import in.society.maintain.service.SocUserDetailsVO;

/**
 * This is user management controller that take handles user management related request.
 * 
 * @author ANIL
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	/** userDetailService represents user related business operations */
	@Autowired
	private SocUserDetailsService socUserDetailsService;

	/** userControllerHelper it take care of additional overhead of controller */
	@Autowired
	private UserControllerHelper userControllerHelper;

	/** User Management View */
	private static final String USER_DETAILS_VIEW = "/usermgmt/view";
	private static final String ADD_USER = "/usermgmt/adduser";
	private static final String UPDATE_USER = "/usermgmt/edituser";
	private static final String SEARCH_USER = "/usermgmt/search";
	//private static final String SEARCH_USER_ALL = "/usermgmt/searchuser";

	/**
	 * Method to get the add new user page.
	 * 
	 * @param model {@link ModelMap}
	 * @return Add new user page
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddUserPage() {
		return ADD_USER;
	}

	/**
	 * Method to get the update user page.
	 * 
	 * @param model {@link ModelMap}
	 * @param userId {@link Long}
	 * @return update existing user page
	 */
	@RequestMapping(value = "/update/{userId}", method = RequestMethod.GET)
	public String getUpdateUserPage(ModelMap model, @PathVariable(value = "userId") Long userId) {
		LOGGER.debug("Request to get the user details of userid : {}", userId);
		SocUserDetailsVO socUserDetailsVO = null;
		try {
			socUserDetailsVO = this.getSocUserDetailsService().getSocUserDetails(userId);
			if (socUserDetailsVO != null) {
				LOGGER.info("User Details of User Id : {} is fetched successfully", userId);
			}
			model.put("userId", userId);
			model.put("socUserDetails", socUserDetailsVO);
		} catch (SocietyMaintenanceException ex) {
			LOGGER.error("Society Maintenance Service exception while getting the user details of user id : {} due to : {}", userId, ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Exception while getting the user details of user id : {} due to : {}", userId, ex.getMessage());
		}
		return UPDATE_USER;
	}

	/**
	 * Method to save or update the user details.
	 * 
	 * @param socUserFormBean {@link SocUserFormBean}
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public SocUserFormBean saveOrUpdate(@RequestBody SocUserFormBean socUserFormBean) {
		LOGGER.debug("Trying to save the user details");
		try {
			SocUserDetailsVO socUserDetailsVO = this.getUserControllerHelper().populateUsersDetailsVO(socUserFormBean);
			socUserDetailsVO = this.getSocUserDetailsService().saveOrUpdate(socUserDetailsVO);
		} catch (SocietyMaintenanceException ex) {
			LOGGER.error("Service exception while saving the user of user id : {} due to : {}", "", ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Exception while saving the user of user id : {} due to : {}", "", ex.getMessage());
		}
		return socUserFormBean;
	}

	/**
	 * Method to delete the user based on user id.
	 * 
	 * @param model {@link ModelMap}
	 * @param userId {@link Long}
	 * @return update existing user page
	 */
	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String deleteUser(Model model, @PathVariable(value = "userId") Long userId) {
		String message = "Failed to delete User of Id : "+ userId;
		Boolean isDeleted = Boolean.FALSE;
		LOGGER.debug("Request for deleting the user of userid : {}", userId);
		try {
			isDeleted = this.getSocUserDetailsService().deleteSocUser(userId);
			if (isDeleted) {
				message = "User of Id : "+ userId +" is deleted successfully";
				LOGGER.info("User of Id : {} is deleted successfully", userId);
			}
		} catch (SocietyMaintenanceException ex) {
			LOGGER.error("Service exception while deleting the user of user id : {} due to : {}", userId, ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Exception while deleting the user of user id : {} due to : {}", userId, ex.getMessage());
		}
		return message;
	}

	/**
	 * Method to get society user details based on userId.
	 * 
	 * @param model {@link ModelMap}
	 * @param userId {@link Long}
	 * @return User Details view page.
	 */
	@RequestMapping(value = "/view/{userId}", method = RequestMethod.GET, produces = "application/json")
	public String getUserDetails(ModelMap model, @PathVariable(value = "userId") Long userId) {
		LOGGER.debug("Request to get the user details of userid : {}", userId);
		SocUserDetailsVO socUserDetailsVO = null;
		try {
			socUserDetailsVO = this.getSocUserDetailsService().getSocUserDetails(userId);
			if (socUserDetailsVO != null) {
				LOGGER.info("User Details of User Id : {} is fetched successfully", userId);
			}
			model.put("userId", userId);
			model.put("socUserDetails", socUserDetailsVO);
		} catch (SocietyMaintenanceException ex) {
			LOGGER.error("Service exception while getting the user details of user id : {} due to : {}", userId, ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Exception while getting the user details of user id : {} due to : {}", userId, ex.getMessage());
		}
		return USER_DETAILS_VIEW;
	}

	/**
	 * Method to get all the society user.
	 * 
	 * @param model {@link ModelMap}
	 * @return List of all society user.
	 */
	@RequestMapping(value = "/viewAll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<SocUserDetailsVO> getAllUsers(ModelMap model) {
		LOGGER.debug("Fetching all the society users");
		List<SocUserDetailsVO> socUserDetailsVOList = null;
		try {
			socUserDetailsVOList = this.getSocUserDetailsService().getAllUsers();
		} catch (SocietyMaintenanceException ex) {
			LOGGER.error("Society Maintenance Exception of getting all the users due to {}", ex.getMessage(), ex);
		} catch (Exception ex) {
			LOGGER.error("Exception of getting all the users due to {}", ex.getMessage(), ex);
		}
		return socUserDetailsVOList;
	}

	/**
	 * Method to get all the society user.
	 * 
	 * @param model {@link ModelMap}
	 * @return All society user view page.
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getAllSocUsers(ModelMap model) {
		LOGGER.debug("Fetching all the society users");
		return SEARCH_USER;
	}

	public SocUserDetailsService getSocUserDetailsService() {
		return socUserDetailsService;
	}

	public UserControllerHelper getUserControllerHelper() {
		return userControllerHelper;
	}

}
