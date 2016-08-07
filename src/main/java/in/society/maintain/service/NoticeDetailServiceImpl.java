package in.society.maintain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.dao.NoticeDetailsDAO;
import in.society.maintain.model.NoticeDetail;

@Service
public class NoticeDetailServiceImpl implements NoticeDetailService {

	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(NoticeDetailServiceImpl.class);

	/** noticeDetailsDAO represents the notice details related DAO operations */
	@Autowired
	private NoticeDetailsDAO noticeDetailsDAO;

	/** noticeDetailServiceHelper it take cares of notice detail service overhead */
	@Autowired
	private NoticeDetailServiceHelper noticeDetailServiceHelper;

	@Override
	@Transactional
	public NoticeDetailVO saveOrUpdate(NoticeDetailVO noticeDetailVO) throws SocietyMaintenanceException {
		NoticeDetail noticeDetail = null;
		NoticeDetailVO noticeDetailVONew = null;
		LOGGER.debug("Saving notice details");
		try {
			noticeDetail = this.getNoticeDetailServiceHelper().populateNoticeDetailModelFromVO(noticeDetailVO);
			noticeDetail = this.getNoticeDetailsDAO().saveOrUpdate(noticeDetail);

			if (noticeDetailVO.getNoticeId() != null) {
				LOGGER.info("Notice No : {} is updated successfully", noticeDetail.getId());
			} else {
				LOGGER.info("Notice No : {} is added successfully", noticeDetail.getId());
			}
			noticeDetailVONew = this.getNoticeDetailServiceHelper().populateNoticeVOFromModel(noticeDetail);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while saving/updating details of notice due to {}", dae.getMessage());
			throw new SocietyMaintenanceException("Exception while saving/updating details of notice due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while saving/updating details of notice of user due to {}", ex.getMessage());
			throw new SocietyMaintenanceException("Exception while saving/updating details of notice due to : " + ex.getMessage(), ex);
		}

		return noticeDetailVONew;
	}

	@Override
	@Transactional
	public NoticeDetailVO getNoticeDetail(Long noticeId) throws SocietyMaintenanceException {
		NoticeDetailVO noticeDetailVO = null;
		LOGGER.debug("Getting a notice details of notice id : {}", noticeId);
		try {
			final NoticeDetail noticeDetail = this.getNoticeDetailsDAO().getNoticeDetail(noticeId);
			noticeDetailVO = this.getNoticeDetailServiceHelper().populateNoticeVOFromModel(noticeDetail);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while getting details of notice of notice id : {} due to {}", noticeId, dae.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of notice of notice id : " + noticeId + "due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while getting details of notice of notice id : {} due to {}", noticeId, ex.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of notice of notice id : " + noticeId + "due to : " + ex.getMessage(), ex);
		}

		return noticeDetailVO;
	}

	@Override
	@Transactional
	public List<NoticeDetailVO> getAllNotices() throws SocietyMaintenanceException {
		List<NoticeDetailVO> noticeDetailVOList = null;
		LOGGER.debug("Getting a details of all notice");
		try {
			final List<NoticeDetail> noticeDetailList = this.getNoticeDetailsDAO().getAllNotices();
			noticeDetailVOList = this.getNoticeDetailServiceHelper().populateNoticeDetailVOListFromModelList(noticeDetailList);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while getting details of all notices due to {}", dae.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of all notices due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while getting details of all notices due to {}", ex.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of all notices due to : " + ex.getMessage(), ex);
		}
		return noticeDetailVOList;
	}

	public NoticeDetailsDAO getNoticeDetailsDAO() {
		return noticeDetailsDAO;
	}

	public NoticeDetailServiceHelper getNoticeDetailServiceHelper() {
		return noticeDetailServiceHelper;
	}

}
