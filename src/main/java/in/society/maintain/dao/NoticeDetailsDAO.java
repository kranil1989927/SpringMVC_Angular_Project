package in.society.maintain.dao;

import java.util.List;

import in.society.maintain.model.NoticeDetail;

public interface NoticeDetailsDAO {

	/**
	 * Method to save or update the notice details
	 * 
	 * @param noticeDetail {@link NoticeDetail}
	 * @return Updated or newly add notice detail
	 */
	NoticeDetail saveOrUpdate(NoticeDetail noticeDetail);

	/**
	 * Method to get the notice details based on notice id.
	 * 
	 * @param noticeId {@link Long}
	 * @return Notice Detail {@link NoticeDetail}
	 */
	NoticeDetail getNoticeDetail(Long noticeId);

	/**
	 * This method is used to get all the existing notices
	 * 
	 * @return List of notices {@link List<NoticeDetail>}
	 */
	List<NoticeDetail> getAllNotices();
}
