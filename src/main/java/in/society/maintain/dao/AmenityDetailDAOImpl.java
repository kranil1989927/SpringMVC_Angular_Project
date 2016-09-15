package in.society.maintain.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.society.maintain.model.AmenityDetail;

@Repository
public class AmenityDetailDAOImpl implements AmenityDetailDAO {

	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(AmenityDetailDAOImpl.class);

	/** sessionFactory represents SessionFactory that provides database connection session */
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public AmenityDetail saveOrUpdate(AmenityDetail amenityDetail) {
		LOGGER.debug("Saving amenity details");
		String amenity = amenityDetail.getAmenityType();
		this.getCurrSession().saveOrUpdate(amenityDetail);
		if (null != amenityDetail.getAmenityId()) {
			LOGGER.debug("Amenity Details {} is updated successfully", amenity);
		} else {
			LOGGER.debug("Amenity Details {} is added successfully", amenity);
		}
		return amenityDetail;
	}

	@Override
	public AmenityDetail getAmenityDetail(Long amenityId) {
		LOGGER.debug("Fetching amenity details with amenity id {}", amenityId);
		return (AmenityDetail) this.getCurrSession().load(AmenityDetail.class, amenityId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AmenityDetail> getAllAmenities() {
		LOGGER.debug("Getting all Amenities");
		return this.getCurrSession().createQuery("from AmenityDetail order by amenityId").list();
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
