package in.society.maintain.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.society.maintain.model.SocUser;
import in.society.maintain.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String addSocUser(SocUser socUser) {
		LOGGER.debug("Add new soc user");
		this.sessionFactory.getCurrentSession().save(socUser);
		LOGGER.debug("user {} is added successfully", socUser.getFirstName());
		return socUser.getFirstName()+" "+socUser.getLastName();
	}

	@Override
	public String updateUser(User user) {
		LOGGER.debug("Update user {}", user.getUserName());
		this.sessionFactory.getCurrentSession().saveOrUpdate(user);
		LOGGER.debug("user {} is updated successfully", user.getUserName());
		return user.getUserName();
	}

	@Override
	public String deleteUser(Integer userId) {
		String userName = "";
		LOGGER.debug("Deleting user with user id {}", userId);
		User user = (User) this.sessionFactory.getCurrentSession().load(User.class, userId);
		if (null != user) {
			this.sessionFactory.getCurrentSession().delete(user);
			LOGGER.debug("user {} is updated successfully", user.getUserName());
			userName =  user.getUserName();
		}
		return userName;
	}

	@Override
	public User getUserDetails(Integer userId) {
		LOGGER.debug("Fetching user with user id {}", userId);
		return (User) this.sessionFactory.getCurrentSession().load(User.class, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		LOGGER.debug("Getting all the user");
		return this.sessionFactory.getCurrentSession().createQuery("from User").list();
	}

}
