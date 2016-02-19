package in.society.maintain.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.society.maintain.model.Complaint;
import in.society.maintain.model.User;

@Repository
public class ComplaintDAOImpl implements ComplaintDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public String raiseComplaint(Complaint complaint) {
		LOGGER.debug("Add new DAo");
		System.out.println("in  raiseComplaint Service");
		this.sessionFactory.getCurrentSession().save(complaint);
		LOGGER.debug("user {} is added successfully", complaint.getComplaintDescription());
		return complaint.getComplaintDescription();

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
			userName = user.getUserName();
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
	public List<Complaint> getAllComplaints() {
		LOGGER.debug("Getting all complaints");
		return this.sessionFactory.getCurrentSession().createQuery("from Complaint").list();
	}

	

}
