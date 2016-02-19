package in.society.maintain.service;

import java.util.List;

import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.model.User;

public interface UserDetailService {

	/**
	 * This method is used to add new user
	 * 
	 * @param user{{@link
	 * 			UserDetailsVO}
	 * @return Newly created user name
	 */
	String addSocUser(SocUserDetailsVO socUserDetailsVO) throws SocietyMaintenanceException;

	/**
	 * This method is used to update the user details
	 * 
	 * @param user{{@link
	 * 			UserDetailsVO}
	 * @return updated user name
	 */

	UserDetailsVO updateUser(UserDetailsVO userDetail) throws SocietyMaintenanceException;

	/**
	 * this method is used to delete usr
	 * 
	 * @param user{{@link
	 * 			UserDetailsVO}
	 * @returnDeleted user name
	 * @throws SocietyMaintenanceException
	 */

	String deleteUser(Integer userId) throws SocietyMaintenanceException;

	/**
	 * This method is used to get user details
	 * 
	 * @param userId{{@link
	 * 			Integer}
	 * @return User Details {@link UserDetailsVO}
	 */

	UserDetailsVO getUserDetails(Integer userId) throws SocietyMaintenanceException;

	/**
	 * This method is used to get all the existing users
	 * 
	 * @return List of Users {@linkplain List<UserDetailsVO>}
	 */

	List<UserDetailsVO> getAllUsers() throws SocietyMaintenanceException;

}
