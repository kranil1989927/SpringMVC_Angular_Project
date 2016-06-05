package in.society.maintain.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.society.maintain.model.ComplaintDetail;

@Repository
public class ComplaintDetailsDAOImpl implements ComplaintDetailsDAO {
	
	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintDetailsDAOImpl.class);

	/** sessionFactory represents SessionFactory that provides database connection session */
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ComplaintDetail saveOrUpdate(ComplaintDetail complaintDetail) {
		LOGGER.debug("Saving complaint details details");
		String complaint = complaintDetail.getComplaintType() + " : " + complaintDetail.getComplaintDescription(); 
		this.getCurrSession().saveOrUpdate(complaintDetail);
		if (null != complaintDetail.getComplaintNo()) {
			LOGGER.debug("Complaint Details {} is updated successfully", complaint);
		} else {
			LOGGER.debug("Complaint Details {} is added successfully", complaint);
		}
		return complaintDetail;
	}

	@Override
	public ComplaintDetail getComplaintDetail(Long complaintId) {
		LOGGER.debug("Fetching complaint details with compalint id {}", complaintId);
		return (ComplaintDetail) this.getCurrSession().load(ComplaintDetail.class, complaintId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ComplaintDetail> getAllComplaints() {
		LOGGER.debug("Getting all complaints");
		return this.sessionFactory.getCurrentSession().createQuery("from ComplaintDetail order by complaintNo").list();
	}

	/**
	 * Method to get current session.
	 * 
	 * @return Session from session factory.
	 */
	private Session getCurrSession() {
		return this.getSessionFactory().getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
