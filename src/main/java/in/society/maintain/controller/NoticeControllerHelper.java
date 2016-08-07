package in.society.maintain.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import in.society.maintain.common.CommonUtils;
import in.society.maintain.service.NoticeDetailVO;

@Component
public class NoticeControllerHelper {

	public NoticeDetailFormBean populateNoticeDetailsFormBean(NoticeDetailVO noticeDetailVO) {
		NoticeDetailFormBean noticeDetailFormBean = new NoticeDetailFormBean();
		noticeDetailFormBean.setNoticeId(String.valueOf(noticeDetailVO.getNoticeId()));
		noticeDetailFormBean.setNoticeTitle(noticeDetailVO.getNoticeTitle());
		noticeDetailFormBean.setNoticeDesc(noticeDetailVO.getNoticeDesc());
		noticeDetailFormBean.setNoticeDate(CommonUtils.convertToDateString(noticeDetailVO.getNoticeDate(), "MM/dd/yyyy"));

		return noticeDetailFormBean;
	}

	public NoticeDetailVO populateNoticeDetailsVOFromBean(NoticeDetailFormBean noticeFormBean) {
		NoticeDetailVO noticeDetailVO = new NoticeDetailVO();
		if (!CommonUtils.isNullorEmpty(noticeFormBean.getNoticeId())) {
			noticeDetailVO.setNoticeId(Long.valueOf(noticeFormBean.getNoticeId()));
		}
		noticeDetailVO.setNoticeTitle(noticeFormBean.getNoticeTitle());
		noticeDetailVO.setNoticeDesc(noticeFormBean.getNoticeDesc());
		
		// Always todays date while adding new notice
		noticeDetailVO.setNoticeDate(new Date());

		return noticeDetailVO;
	}

	public List<NoticeDetailFormBean> populateNoticeDetailsFormBeanList(List<NoticeDetailVO> noticeDetailVOList) {
		List<NoticeDetailFormBean> noticeDetailFormBeanList = new ArrayList<NoticeDetailFormBean>(noticeDetailVOList.size());
		for (NoticeDetailVO noticeDetailVO : noticeDetailVOList) {
			NoticeDetailFormBean noticeDetailFormBean = this.populateNoticeDetailsFormBean(noticeDetailVO);
			noticeDetailFormBeanList.add(noticeDetailFormBean);
		}
		return noticeDetailFormBeanList;
	}

}
