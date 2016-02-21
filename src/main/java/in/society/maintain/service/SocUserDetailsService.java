package in.society.maintain.service;

import java.util.List;

import in.society.maintain.common.SocietyMaintenanceException;

public interface SocUserDetailsService {

	/**
	 * Method to save or update the society user details
	 * 
	 * @param socUserDetailsVO {@link socUserDetailsVO}
	 * @return Updated or newly created Society User
	 * 
	 * @throws SocietyMaintenanceException
	 */
	SocUserDetailsVO saveOrUpdate(SocUserDetailsVO socUserDetailsVO) throws SocietyMaintenanceException;

	/**
	 * Method to delete the society user based on the User Id
	 * 
	 * @param userId {@link Long}
	 * @return True if deleted
	 * 
	 * @throws SocietyMaintenanceException
	 */
	Boolean deleteSocUser(Long userId) throws SocietyMaintenanceException;

	/**
	 * Method to get the society user details based on user id.
	 * 
	 * @param userId{@link Long}
	 * @return User Details {@link UserDetailsVO}
	 * 
	 * @throws SocietyMaintenanceException
	 */
	SocUserDetailsVO getSocUserDetails(Long userId) throws SocietyMaintenanceException;

	/**
	 * This method is used to get all the existing users
	 * 
	 * @return List of Users {@linkplain List<SocUserDetailsVO>}
	 * 
	 * @throws SocietyMaintenanceException
	 */

	List<SocUserDetailsVO> getAllUsers() throws SocietyMaintenanceException;

}
