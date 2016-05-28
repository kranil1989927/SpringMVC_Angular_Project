package in.society.maintain.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/complaint")
public class ComplaintController {
	
	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintController.class);
	
	/** User Management View */
	private static final String COMPLAINT_DETAILS_VIEW = "/complaint/view";
	private static final String ADD_COMPLAINT = "/complaint/addcomplain";
	private static final String UPDATE_COMPLAINT = "/complaint/editcomplain";
	private static final String SEARCH_COMPLAINT = "/complaint/search";
	
	/**
	 * Method to get the add new complaint page.
	 * 
	 * @param model {@link ModelMap}
	 * @return Add new complaint page
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddComplaintPage() {
		LOGGER.info("Loading add new complaint page");
		return ADD_COMPLAINT;
	}
	
	/**
	 * Method to get all the society complaints.
	 * 
	 * @param model {@link ModelMap}
	 * @return All society complaints view page.
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getAllComplaints(ModelMap model) {
		LOGGER.debug("Fetching all the society complaints");
		return SEARCH_COMPLAINT;
	}
	
	/**
	 * Method to get the update Complaint page.
	 * 
	 * @param model {@link ModelMap}
	 * @param complaintId {@link Long}
	 * @return update existing complaint page
	 */
	@RequestMapping(value = "/update/{complaintId}", method = RequestMethod.GET)
	public String getUpdateComplaintPage(ModelMap model, @PathVariable(value = "complaintId") Long complaintId) {
		LOGGER.debug("Request to get the complaint details of complaint no. : {}", complaintId);
		return UPDATE_COMPLAINT;
	}
	
	/**
	 * Method to get society Complaint details based on complaintId.
	 * 
	 * @param model {@link ModelMap}
	 * @param complaintId {@link Long}
	 * @return Complaint Details view page.
	 */
	@RequestMapping(value = "/view/{complaintId}", method = RequestMethod.GET, produces = "application/json")
	public String getComplaintDetails(ModelMap model, @PathVariable(value = "complaintId") Long complaintId) {
		LOGGER.debug("Request to get the complaint details of complaint no. : {}", complaintId);
		return COMPLAINT_DETAILS_VIEW;
	}
}
