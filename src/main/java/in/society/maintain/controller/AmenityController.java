package in.society.maintain.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/amenities")
public class AmenityController {

	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(AmenityController.class);

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
}
