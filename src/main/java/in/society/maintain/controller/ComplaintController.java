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
import in.society.maintain.service.ComplaintDetailService;
import in.society.maintain.service.ComplaintDetailsVO;

@Controller
@RequestMapping("/complaint")
public class ComplaintController {
	
	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintController.class);
	
	/** complaintDetailService represents complaint related business operations */
	@Autowired
	private ComplaintDetailService complaintDetailService;

	/** complaintControllerHelper it takes care of additional overhead of controller */
	@Autowired
	private ComplaintControllerHelper complaintControllerHelper;

	
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
	 * Method to get all the society complaints search page.
	 * 
	 * @param model {@link ModelMap}
	 * @return All society complaints view page.
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getSearchPage(ModelMap model) {
		LOGGER.debug("Fetching all the society complaints");
		return SEARCH_COMPLAINT;
	}
	
	/**
	 * Method to get the update Complaint page.
	 * 
	 * @param model {@link ModelMap}
	 * @param complaintId {@link Long}
	 * 
	 * @return update existing complaint page
	 */
	@RequestMapping(value = "/update/{complaintId}", method = RequestMethod.GET)
	public String getUpdateComplaintPage(ModelMap model, @PathVariable(value = "complaintId") Long complaintId) {
		LOGGER.debug("Request to get the complaint details of complaint no. : {}", complaintId);
		ComplaintDetailsVO complaintDetailsVO = null;
		try {
			complaintDetailsVO = this.getComplaintDetailService().getComplaintDetail(complaintId);
			if (complaintDetailsVO != null) {
				LOGGER.info("Complaint Details of Complaint Id : {} is fetched successfully", complaintId);
				ComplaintDetailsFormBean complaintFormBean = this.getComplaintControllerHelper().populateComplaintDetailsFormBean(complaintDetailsVO);
				model.put("complaintId", complaintId);
				model.put("complaintDetails", complaintFormBean);
			}
		} catch (SocietyMaintenanceException ex) {
			LOGGER.error("Society Maintenance Service exception while getting the complaint details of complaint id : {} due to : {}", complaintId, ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Exception while getting the complaint details of complaint id : {} due to : {}", complaintId, ex.getMessage());
		}
		return UPDATE_COMPLAINT;
	}
	
	/**
	 * Method to get society Complaint details based on complaintId.
	 * 
	 * @param model {@link ModelMap}
	 * @param complaintId {@link Long}
	 * 
	 * @return Complaint Details view page.
	 */
	@RequestMapping(value = "/view/{complaintId}", method = RequestMethod.GET, produces = "application/json")
	public String getComplaintDetails(ModelMap model, @PathVariable(value = "complaintId") Long complaintId) {
		LOGGER.debug("Request to get the complaint details of complaint no. : {}", complaintId);
		ComplaintDetailsVO complaintDetailsVO = null;
		try {
			complaintDetailsVO = this.getComplaintDetailService().getComplaintDetail(complaintId);
			if (complaintDetailsVO != null) {
				LOGGER.info("Complaint Details of complaint Id : {} is fetched successfully", complaintId);
				ComplaintDetailsFormBean complaintFormBean = this.getComplaintControllerHelper().populateComplaintDetailsFormBean(complaintDetailsVO);
				model.put("complaintId", complaintId);
				model.put("complaintDetails", complaintFormBean);
			}
		} catch (SocietyMaintenanceException ex) {
			LOGGER.error("Society Maintenance Service exception while getting the complaint details of complaint id : {} due to : {}", complaintId, ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Exception while getting the complaint details of complaint id : {} due to : {}", complaintId, ex.getMessage());
		}
		return COMPLAINT_DETAILS_VIEW;
	}
	
	/**
	 * Method to save or update the Complaint details.
	 * 
	 * @param complaintDetailsFormBean {@link ComplaintDetailsFormBean}
	 * 
	 * @return complaintDetailsFormBean
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ComplaintDetailsFormBean saveOrUpdate(@RequestBody ComplaintDetailsFormBean complaintDetailsFormBean) {
		ComplaintDetailsFormBean complaintFormBean = complaintDetailsFormBean;
		LOGGER.debug("Trying to save the complaint details");
		try {
			ComplaintDetailsVO complaintDetailsVO = this.getComplaintControllerHelper().populateComplaintDetailsVO(complaintFormBean);
			complaintDetailsVO = this.getComplaintDetailService().saveOrUpdate(complaintDetailsVO);
		} catch (SocietyMaintenanceException ex) {
			LOGGER.error("Service exception while saving the compliant of compliant id : {} due to : {}", "", ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Exception while saving the compliant of compliant id : {} due to : {}", "", ex.getMessage());
		}
		return complaintFormBean;
	}
	
	/**
	 * Method to get all the society complaints.
	 * 
	 * @param model {@link ModelMap}
	 * @return All society complaints.
	 */
	@RequestMapping(value = "/viewAllComplaint", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<ComplaintDetailsVO> getAllComplaints(ModelMap model) {
		LOGGER.debug("Fetching all the society users");
		List<ComplaintDetailsVO> complaintDetailsVOList = null;
		try {
			complaintDetailsVOList = this.getComplaintDetailService().getAllComplaints();
		} catch (SocietyMaintenanceException ex) {
			LOGGER.error("Society Maintenance Exception of getting all the complaints due to {}", ex.getMessage(), ex);
		} catch (Exception ex) {
			LOGGER.error("Exception of getting all the complaints due to {}", ex.getMessage(), ex);
		}
		return complaintDetailsVOList;
	}

	public ComplaintDetailService getComplaintDetailService() {
		return complaintDetailService;
	}

	public ComplaintControllerHelper getComplaintControllerHelper() {
		return complaintControllerHelper;
	}
}
