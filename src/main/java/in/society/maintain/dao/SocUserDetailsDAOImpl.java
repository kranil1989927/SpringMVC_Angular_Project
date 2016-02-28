package in.society.maintain.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.society.maintain.model.SocUser;

@Repository
public class SocUserDetailsDAOImpl implements SocUserDetailsDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(SocUserDetailsDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SocUser saveOrUpdateSocUser(SocUser socUser) {
		LOGGER.debug("Saving society user details");
		String userName = socUser.getFirstName() + " " + socUser.getLastName();
		this.getCurrSession().saveOrUpdate(socUser);
		if (null != socUser.getUserId()) {
			LOGGER.debug("Socity user {} is updated successfully", userName);
		} else {
			LOGGER.debug("Socity user {} is added successfully", userName);
		}
		return socUser;
	}

	@Override
	public Boolean deleteSocUser(Long userId) {
		Boolean isDeleted = Boolean.FALSE;
		LOGGER.debug("Deleting user with user id {}", userId);
		SocUser socUser = this.getSocUserDetails(userId);
		if (null != socUser) {
			String userName = socUser.getFirstName() + " " +socUser.getLastName();
			this.getCurrSession().delete(socUser);
			isDeleted = Boolean.TRUE;
			LOGGER.debug("user {} is deleted successfully", userName);
		}
		return isDeleted;
	}

	@Override
	public SocUser getSocUserDetails(Long userId) {
		LOGGER.debug("Fetching society user with user id {}", userId);
		return (SocUser) this.getCurrSession().load(SocUser.class, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SocUser> getAllSocUsers() {
		LOGGER.debug("Getting all the society user");
		return this.getCurrSession().createQuery("from SocUser").list();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/**
	 * Method to get current session.
	 * @return Session from session factory.
	 */
	private Session getCurrSession(){
		return this.getSessionFactory().getCurrentSession();
	}

}
