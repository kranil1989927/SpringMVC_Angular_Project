package in.society.maintain.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.dao.SocUserDetailsDAO;
import in.society.maintain.service.AmenityDetailService;
import in.society.maintain.service.AmenityDetailsVO;
import in.society.maintain.service.SocUserDetailsService;
import in.society.maintain.service.SocUserDetailsServiceHelper;

@Controller
@RequestMapping("/amenities")
public class AmenityController {

	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(AmenityController.class);

	/** amenityDetailService represents amenity related business operations */
	@Autowired
	private AmenityDetailService amenityDetailService;

	/** amenityControllerHelper it takes care of additional overhead of controller */
	@Autowired
	private AmenityControllerHelper amenityControllerHelper;
	
	/** socUserDetailsServiceHelper it take cares of society user details service overhead */
	@Autowired
	private SocUserDetailsServiceHelper socUserDetailsServiceHelper; 
	
	/** socUserDetailsService represents socUserDetails related business operations */
	@Autowired
	private SocUserDetailsService socUserDetailsService;
	
	/** Amenity View */
	private static final String AMENITY_DETAILS_VIEW = "/amenities/view";
	private static final String REQUEST_AMENITY = "/amenities/requestforAmenities";
	private static final String UPDATE_AMENITY = "/amenities/update";
	private static final String SEARCH_AMENITIES = "/amenities/search";

	/**
	 * Method to get a request amenity page.
	 * 
	 * @param model {@link ModelMap}
	 * @return Request new amenity page
	 */
	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public String getRequestAmenityPage() {
		LOGGER.info("Loading request amenity page");
		return REQUEST_AMENITY;
	}

	/**
	 * Method to get all the society amenities search page.
	 * 
	 * @param model {@link ModelMap}
	 * @return All society amenities view page.
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getSearchPage(ModelMap model) {
		LOGGER.debug("Fetching all the society amenities");
		return SEARCH_AMENITIES;
	}

	/**
	 * Method to get the update amenity page.
	 * 
	 * @param model {@link ModelMap}
	 * @param amenityId {@link Long}
	 * 
	 * @return update existing amenity details page
	 */
	@RequestMapping(value = "/update/{amenityId}", method = RequestMethod.GET)
	public String getUpdateAmenityPage(ModelMap model, @PathVariable(value = "amenityId") Long amenityId) {
		LOGGER.debug("Request to get the amenity details of amenity no. : {}", amenityId);
		this.getAmenityDetailsById(model, amenityId);
		return UPDATE_AMENITY;
	}

	/**
	 * Method to get society amenity details based on amenityId.
	 * 
	 * @param model {@link ModelMap}
	 * @param amenityId {@link Long}
	 * 
	 * @return Amenity Details view page.
	 */
	@RequestMapping(value = "/view/{amenityId}", method = RequestMethod.GET, produces = "application/json")
	public String getAmenityDetails(ModelMap model, @PathVariable(value = "amenityId") Long amenityId) {
		LOGGER.debug("Request to get the amenity details of amenity no. : {}", amenityId);
		this.getAmenityDetailsById(model, amenityId);
		return AMENITY_DETAILS_VIEW;
	}

	/**
	 * Method to get society amenity details based on amenityId.
	 * 
	 * @param model {@link ModelMap}
	 * @param amenityId {@link Long}
	 */
	private void getAmenityDetailsById(ModelMap model, Long amenityId) {
		AmenityDetailsVO amenityDetailsVO = null;
		try {
			amenityDetailsVO = this.getAmenityDetailService().getAmenityDetail(amenityId);
			if (amenityDetailsVO != null) {
				LOGGER.info("Amenity Details of Amenity Id : {} is fetched successfully", amenityId);
				AmenityDetailsFormBean amenityDetailsFormBean = this.getAmenityControllerHelper().populateAmenityDetailsFormBean(amenityDetailsVO);
				model.put("amenityId", amenityId);
				model.put("amenityDetails", amenityDetailsFormBean);
			}
		} catch (SocietyMaintenanceException ex) {
			LOGGER.error("Society Maintenance Service exception while getting the amenity details of amenity id : {} due to : {}", amenityId, ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Exception while getting the amenity details of amenity id : {} due to : {}", amenityId, ex.getMessage());
		}
	}

	/**
	 * Method to save or update the Complaint details.
	 * 
	 * @param amenityDetailFormBean {@link amenityDetailFormBean}
	 * 
	 * @return AmenityDetailsFormBean
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public AmenityDetailsFormBean saveOrUpdate(@RequestBody AmenityDetailsFormBean amenityDetailFormBean) {
		AmenityDetailsFormBean amenityFormBean  = amenityDetailFormBean;
		LOGGER.debug("Trying to save the amenity details");
		try {
			AmenityDetailsVO amenityDetailsVO = this.getAmenityControllerHelper().populateAmenityDetailsVO(amenityFormBean);
			amenityDetailsVO = this.getAmenityDetailService().saveOrUpdate(amenityDetailsVO);
		} catch (SocietyMaintenanceException ex) {
			LOGGER.error("Service exception while saving the amenity of amenity id : {} due to : {}", "", ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Exception while saving the amenity of amenity id {} due to : {}", "", ex.getMessage());
		}
		return amenityFormBean;
	}

	/**
	 * Method to get all the society Amenities.
	 * 
	 * @param model {@link ModelMap}
	 * @return All society Amenities.
	 */
	@RequestMapping(value = "/viewAllAmenities", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<AmenityDetailsVO> getAllAmenities(ModelMap model) {
		LOGGER.debug("Fetching all the society amenities");
		List<AmenityDetailsVO> amenityDetailsVOList = null;
		try {
			amenityDetailsVOList = this.getAmenityDetailService().getAllAmenities();
		} catch (SocietyMaintenanceException ex) {
			LOGGER.error("Society Maintenance Exception of getting all the amenities due to {}", ex.getMessage(), ex);
		} catch (Exception ex) {
			LOGGER.error("Exception of getting all the amenities due to {}", ex.getMessage(), ex);
		}
		return amenityDetailsVOList;
	}

	public AmenityDetailService getAmenityDetailService() {
		return amenityDetailService;
	}

	public AmenityControllerHelper getAmenityControllerHelper() {
		return amenityControllerHelper;
	}
}
