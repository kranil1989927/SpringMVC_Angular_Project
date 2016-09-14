package in.society.maintain.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import in.society.maintain.model.AmenityDetail;

@Repository
public class AmenityDetailDAOImpl implements AmenityDetailDAO {

	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(AmenityDetailDAOImpl.class);
	
	@Override
	public AmenityDetail saveOrUpdate(AmenityDetail amenityDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AmenityDetail getAmenityDetail(Long amenityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AmenityDetail> getAllAmenities() {
		// TODO Auto-generated method stub
		return null;
	}

}
