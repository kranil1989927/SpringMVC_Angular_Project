package in.society.maintain.service;

import java.util.List;

import in.society.maintain.common.SocietyMaintenanceException;

public interface NoticeDetailService {

	/**
	 * Method to save or update the notice details
	 * 
	 * @param noticeDetailVO {@link NoticeDetailVO}
	 * @return Updated or newly added notice
	 * 
	 * @throws SocietyMaintenanceException
	 */
	NoticeDetailVO saveOrUpdate(NoticeDetailVO noticeDetailVO) throws SocietyMaintenanceException;

	/**
	 * Method to get the notice details based on notice id.
	 * 
	 * @param noticeId {@link Long}
	 * @return notice Details {@link NoticeDetailVO}
	 * 
	 * @throws SocietyMaintenanceException
	 */
	NoticeDetailVO getNoticeDetail(Long noticeId) throws SocietyMaintenanceException;

	/**
	 * This method is used to get all the existing notices.
	 * 
	 * @return List of notices {@link List<NoticeDetailVO>}
	 * 
	 * @throws SocietyMaintenanceException
	 */
	List<NoticeDetailVO> getAllNotices() throws SocietyMaintenanceException;
}
