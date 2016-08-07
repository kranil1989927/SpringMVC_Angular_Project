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
import in.society.maintain.service.NoticeDetailService;
import in.society.maintain.service.NoticeDetailVO;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(NoticeController.class);

	/** noticeDetailService represents notice related business operations */
	@Autowired
	private NoticeDetailService noticeDetailService;

	/** noticeControllerHelper it takes care of additional overhead of controller */
	@Autowired
	private NoticeControllerHelper noticeControllerHelper;

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
		try {
			List<NoticeDetailVO> noticeDetailVOList = this.getNoticeDetailService().getAllNotices();
			if(null != noticeDetailVOList){
				List<NoticeDetailFormBean> noticeDetailFormBeamList = this.getNoticeControllerHelper().populateNoticeDetailsFormBeanList(noticeDetailVOList);
				model.put("noticeDetailList", noticeDetailFormBeamList);
			}
		} catch (SocietyMaintenanceException ex) {
			LOGGER.error("Society Maintenance Exception of getting all the notice details due to {}", ex.getMessage(), ex);
		} catch (Exception ex) {
			LOGGER.error("Exception of getting all the  notice details due to {}", ex.getMessage(), ex);
		}
		return SEARCH_NOTICE;
	}
	
	/**
	 * Method to save or update the Notice details.
	 * 
	 * @param noticeDetailFormBean {@link NoticeDetailFormBean}
	 * 
	 * @return noticeDetailFormBean
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public NoticeDetailFormBean saveOrUpdate(@RequestBody NoticeDetailFormBean noticeDetailFormBean) {
		NoticeDetailFormBean noticeFormBean = noticeDetailFormBean;
		LOGGER.debug("Trying to save the notice details");
		try {
			NoticeDetailVO noticeDetailVO = this.getNoticeControllerHelper().populateNoticeDetailsVOFromBean(noticeFormBean);
			noticeDetailVO = this.getNoticeDetailService().saveOrUpdate(noticeDetailVO);
		} catch (SocietyMaintenanceException ex) {
			LOGGER.error("Service exception while saving the notice of notice id : {} due to : {}", "", ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Exception while saving the the notice of notice id : {} due to : {}", "", ex.getMessage());
		}
		return noticeFormBean;
	}

	/**
	 * Method to get the update Notice page.
	 * 
	 * @param model {@link ModelMap}
	 * @param noticeId {@link Long}
	 * 
	 * @return update existing notice page
	 */
	@RequestMapping(value = "/update/{noticeId}", method = RequestMethod.GET, produces = "application/json")
	public String getUpdateNoticePage(ModelMap model, @PathVariable(value = "noticeId") Long noticeId) {
		LOGGER.debug("Request to get the notice details of notice no. : {}", noticeId);
		this.populateNoticeDetails(noticeId, model);
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
		this.populateNoticeDetails(noticeId, model);
		return NOTICE_DETAILS_VIEW;
	}

	/**
	 * Method to populate society Notice details based on noticeId in View and Update Page.
	 * 
	 * @param model {@link ModelMap}
	 * @param noticeId {@link Long}
	 */
	private void populateNoticeDetails(Long noticeId, ModelMap model) {
		NoticeDetailVO noticeDetailVO = null;
		try {
			noticeDetailVO = this.getNoticeDetailService().getNoticeDetail(noticeId);
			if (noticeDetailVO != null) {
				LOGGER.info("Notice Details of notice Id : {} is fetched successfully", noticeId);
				NoticeDetailFormBean noticeDetailFormBean = this.getNoticeControllerHelper().populateNoticeDetailsFormBean(noticeDetailVO);
				model.put("noticeId", noticeId);
				model.put("noticeDetails", noticeDetailFormBean);
			}
		} catch (SocietyMaintenanceException ex) {
			LOGGER.error("Society Maintenance Service exception while getting the notice details of notice id : {} due to : {}", noticeId, ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Exception while getting the notice details of notice id : {} due to : {}", noticeId, ex.getMessage());
		}
	}

	public NoticeDetailService getNoticeDetailService() {
		return noticeDetailService;
	}

	public NoticeControllerHelper getNoticeControllerHelper() {
		return noticeControllerHelper;
	}
}
