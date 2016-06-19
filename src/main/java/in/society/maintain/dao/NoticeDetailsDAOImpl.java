package in.society.maintain.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.society.maintain.model.NoticeDetail;

@Repository
public class NoticeDetailsDAOImpl implements NoticeDetailsDAO {

	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(NoticeDetailsDAOImpl.class);

	/** sessionFactory represents SessionFactory that provides database connection session */
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public NoticeDetail saveOrUpdate(NoticeDetail noticeDetail) {
		LOGGER.debug("Saving notice details");
		String notice = noticeDetail.getTitle();
		this.getCurrSession().saveOrUpdate(noticeDetail);
		if (null != noticeDetail.getId()) {
			LOGGER.debug("Notice Details {} is updated successfully", notice);
		} else {
			LOGGER.debug("Notice Details {} is added successfully", notice);
		}
		return noticeDetail;
	}

	@Override
	public NoticeDetail getNoticeDetail(Long noticeId) {
		LOGGER.debug("Fetching notice details with notice id {}", noticeId);
		return (NoticeDetail) this.getCurrSession().load(NoticeDetail.class, noticeId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NoticeDetail> getAllNotices() {
		LOGGER.debug("Getting all notices");
		return this.sessionFactory.getCurrentSession().createQuery("from NoticeDetail order by id").list();
	}

	/**
	 * Method to get current session.
	 * 
	 * @return Session from session factory.
	 */
	private Session getCurrSession() {
		return this.getSessionFactory().getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
