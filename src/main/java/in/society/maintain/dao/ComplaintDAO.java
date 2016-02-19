package in.society.maintain.dao;

import java.util.List;

import in.society.maintain.model.Complaint;
import in.society.maintain.model.User;

public interface ComplaintDAO {

	/**
	 * This method is used to add complaint
	 * 
	 * @param user{{@link User}
	 * @return Newly created user name
	 */
	String raiseComplaint(Complaint complaint);

	/**
	 * This method is used to update the user details
	 * 
	 * @param user{{@link User}
	 * @return updated user name
	 */
	String updateUser(User user);

	/**
	 * This method is used to delete existing user
	 * 
	 * @param userId{{@link Integer}
	 * @return Deleted user name
	 */
	String deleteUser(Integer userId);

	/**
	 * This method is used to get user details
	 * 
	 * @param userId{{@link Integer}
	 * @return User Details {@link User}
	 */
	User getUserDetails(Integer userId);

	/**
	 * This method is used to get all the existing users
	 * 
	 * @return List of Users {@linkplain List<User>}
	 */
	List<Complaint> getAllComplaints();

}
