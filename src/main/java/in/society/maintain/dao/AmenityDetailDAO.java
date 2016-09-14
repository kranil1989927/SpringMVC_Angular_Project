package in.society.maintain.dao;

import java.util.List;

import in.society.maintain.model.AmenityDetail;

public interface AmenityDetailDAO {

	/**
	 * Method to save or update the amenity details
	 * 
	 * @param amenityDetail {@link AmenityDetail}
	 * @return Updated or newly requested amenity
	 */
	AmenityDetail saveOrUpdate(AmenityDetail amenityDetail);

	/**
	 * Method to get the amenity details based on amenity id.
	 * 
	 * @param amenityId {@link Long}
	 * @return Amenity Details {@link AmenityDetail}
	 */
	AmenityDetail getAmenityDetail(Long amenityId);

	/**
	 * This method is used to get all the existing amenities
	 * 
	 * @return List of amenities {@link List<AmenityDetail>}
	 */
	List<AmenityDetail> getAllAmenities();
}
