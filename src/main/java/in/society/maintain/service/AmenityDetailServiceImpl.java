package in.society.maintain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.dao.AmenityDetailDAO;
import in.society.maintain.model.AmenityDetail;

@Service
public class AmenityDetailServiceImpl implements AmenityDetailService {

	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(AmenityDetailServiceImpl.class);

	/** amenityDetailDAO represents the amenity related DAO operations */
	@Autowired
	private AmenityDetailDAO amenityDetailDAO;

	/** amenityDetailServiceHelper it take cares of amenity detail service overhead */
	@Autowired
	private AmenityDetailServiceHelper amenityDetailServiceHelper;

	@Override
	@Transactional
	public AmenityDetailsVO saveOrUpdate(AmenityDetailsVO amenityDetailsVO) throws SocietyMaintenanceException {
		AmenityDetail amenityDetail = null;
		AmenityDetailsVO amenityDetailVO = null;
		LOGGER.debug("Saving Amenity Details");
		try {
			amenityDetail = this.getAmenityDetailServiceHelper().populateAmenityDetailModelFromVO(amenityDetailsVO);
			if (amenityDetail.getAmenityId() != null) {
				LOGGER.info("Amenity No : {} is updated successfully", amenityDetail.getAmenityId());
			} else {
				LOGGER.info("Amenity No : {} is added successfully", amenityDetail.getAmenityType());
			}
			amenityDetail = this.getAmenityDetailDAO().saveOrUpdate(amenityDetail);
			amenityDetailVO = this.getAmenityDetailServiceHelper().populateAmenityDetailVOFromModel(amenityDetail);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while saving/updating details of amenity due to {}", dae.getMessage());
			throw new SocietyMaintenanceException("Exception while saving/updating details of amenity due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while saving/updating details of amenity of user due to {}", ex.getMessage());
			throw new SocietyMaintenanceException("Exception while saving/updating details of amenity due to : " + ex.getMessage(), ex);
		}

		return amenityDetailVO;
	}

	@Override
	@Transactional
	public AmenityDetailsVO getAmenityDetail(Long amenityId) throws SocietyMaintenanceException {
		AmenityDetailsVO amenityDetailsVO = null;
		LOGGER.debug("Getting a amenity details of amenity id : {}", amenityId);
		try {
			final AmenityDetail amenityDetail = this.getAmenityDetailDAO().getAmenityDetail(amenityId);
			amenityDetailsVO = this.getAmenityDetailServiceHelper().populateAmenityDetailVOFromModel(amenityDetail);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while getting details of amenity of amenity id : {} due to {}", amenityId, dae.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of amenity of amenity id : " + amenityId + "due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while getting details of amenity of amenity id : {} due to {}", amenityId, ex.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of amenity of amenity id : " + amenityId + "due to : " + ex.getMessage(), ex);
		}

		return amenityDetailsVO;
	}

	@Override
	@Transactional
	public List<AmenityDetailsVO> getAllAmenities() throws SocietyMaintenanceException {
		List<AmenityDetailsVO> amenityDetailsVOList = null;
		LOGGER.debug("Getting a details of all amenity details");
		try {
			final List<AmenityDetail> amenityDetailList = this.getAmenityDetailDAO().getAllAmenities();
			amenityDetailsVOList = this.getAmenityDetailServiceHelper().populateAmenityDetailVOListFromModelList(amenityDetailList);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while getting details of all amenities due to {}", dae.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of all amenities due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while getting details of all amenities due to {}", ex.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of all amenities due to : " + ex.getMessage(), ex);
		}

		return amenityDetailsVOList;
	}

	public AmenityDetailDAO getAmenityDetailDAO() {
		return amenityDetailDAO;
	}

	public AmenityDetailServiceHelper getAmenityDetailServiceHelper() {
		return amenityDetailServiceHelper;
	}
}
