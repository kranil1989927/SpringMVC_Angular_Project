package in.society.maintain.service;

import java.util.List;

import in.society.maintain.common.SocietyMaintenanceException;

public interface AmenityDetailService {

	/**
	 * Method to save or update the amenity details
	 * 
	 * @param amenityDetailsVO {@link AmenityDetailsVO}
	 * @return Updated or newly requested amenity
	 * 
	 * @throws SocietyMaintenanceException
	 */
	AmenityDetailsVO saveOrUpdate(AmenityDetailsVO amenityDetailsVO) throws SocietyMaintenanceException;

	/**
	 * Method to get the amenity details based on amenity id.
	 * 
	 * @param amenityId {@link Long}
	 * @return Amenity Details {@link AmenityDetailsVO}
	 * 
	 * @throws SocietyMaintenanceException
	 */
	AmenityDetailsVO getAmenityDetail(Long amenityId) throws SocietyMaintenanceException;

	/**
	 * This method is used to get all the existing amenities
	 * 
	 * @return List of amenities {@link List<AmenityDetailsVO>}
	 * 
	 * @throws SocietyMaintenanceException
	 */
	List<AmenityDetailsVO> getAllAmenities() throws SocietyMaintenanceException;
}
