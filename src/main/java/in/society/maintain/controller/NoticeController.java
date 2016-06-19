package in.society.maintain.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(NoticeController.class);
	
	/** Notice View */
	private static final String NOTICE_DETAILS_VIEW = "/notice/view";
	private static final String ADD_NOTICE = "/notice/add";
	private static final String UPDATE_NOTICE = "/notice/update";
	private static final String SEARCH_NOTICE = "/notice/search";
	
	
	/**
	 * Method to get the add new notice page.
	 * 
	 * @param model {@link ModelMap}
	 * @return Add new notice page
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNoticePage() {
		LOGGER.info("Loading add new notice page");
		return ADD_NOTICE;
	}
	
	/**
	 * Method to get all the society notice search page.
	 * 
	 * @param model {@link ModelMap}
	 * @return All society notice search page.
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getSearchPage(ModelMap model) {
		LOGGER.debug("Fetching all the society notices");
		return SEARCH_NOTICE;
	}
	
	/**
	 * Method to get the update Notice page.
	 * 
	 * @param model {@link ModelMap}
	 * @param noticeId {@link Long}
	 * 
	 * @return update existing notice page
	 */
	@RequestMapping(value = "/update/{noticeId}", method = RequestMethod.GET)
	public String getUpdateNoticePage(ModelMap model, @PathVariable(value = "noticeId") Long noticeId) {
		LOGGER.debug("Request to get the notice details of notice no. : {}", noticeId);
		return UPDATE_NOTICE;
	}
	
	/**
	 * Method to get society Notice details based on noticeId.
	 * 
	 * @param model {@link ModelMap}
	 * @param noticeId {@link Long}
	 * 
	 * @return Notice Details view page.
	 */
	@RequestMapping(value = "/view/{noticeId}", method = RequestMethod.GET, produces = "application/json")
	public String getNoticeDetails(ModelMap model, @PathVariable(value = "noticeId") Long noticeId) {
		LOGGER.debug("Request to get the notice details of notice no. : {}", noticeId);
		return NOTICE_DETAILS_VIEW;
	}
}
