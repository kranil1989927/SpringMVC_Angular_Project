package in.society.maintain.dao;

import java.util.List;

import in.society.maintain.model.SocUser;
import in.society.maintain.model.UserRole;

public interface SocUserDetailsDAO {

	/**
	 * Method to add/update the society user.
	 * 
	 * @param socUser {@link SocUser}
	 * @return Newly created/Updated society user.
	 */
	SocUser saveOrUpdateSocUser(SocUser socUser);

	/**
	 * Method to delete the society user.
	 * 
	 * @param userId {@link Integer}
	 * @return true if society user is deleted.
	 */
	Boolean deleteSocUser(Long userId);

	/**
	 * Method to get society user details.
	 * 
	 * @param userId{@link Long}
	 * @return User Details {@link SocUser}
	 */
	SocUser getSocUserDetails(Long userId);

	/**
	 * Method to get all the existing society users
	 * 
	 * @return List of Users {@link List<SocUser>}
	 */
	List<SocUser> getAllSocUsers();

	
	/**
	 * Method to add/update the user role.
	 * 
	 * @param userRole {@link UserRole}
	 * @return Newly created/Updated user role.
	 */
	UserRole saveOrUpdateUserRole(UserRole userRole);
}
