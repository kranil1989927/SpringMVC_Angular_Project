package in.society.maintain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import in.society.maintain.model.NoticeDetail;

@Component
public class NoticeDetailServiceHelper {

	public NoticeDetailVO populateNoticeVOFromModel(NoticeDetail noticeDetail) {
		NoticeDetailVO noticeDetailVO = new NoticeDetailVO();
		noticeDetailVO.setNoticeId(noticeDetail.getId());
		noticeDetailVO.setNoticeTitle(noticeDetail.getTitle());
		noticeDetailVO.setNoticeDesc(noticeDetail.getMessage());
		noticeDetailVO.setNoticeDate(noticeDetail.getNoticeDate());
		return noticeDetailVO;
	}

	public List<NoticeDetailVO> populateNoticeDetailVOListFromModelList(List<NoticeDetail> noticeDetailList) {
		List<NoticeDetailVO> noticeDetailVOList = new ArrayList<NoticeDetailVO>(noticeDetailList.size());
		for(NoticeDetail noticeDetail : noticeDetailList){
			NoticeDetailVO noticeDetailVO = this.populateNoticeVOFromModel(noticeDetail);
			noticeDetailVOList.add(noticeDetailVO);
		}
		return noticeDetailVOList;
	}

	public NoticeDetail populateNoticeDetailModelFromVO(NoticeDetailVO noticeDetailVO) {
		NoticeDetail noticeDetail = new NoticeDetail();
		noticeDetail.setId(noticeDetailVO.getNoticeId());
		noticeDetail.setTitle(noticeDetailVO.getNoticeTitle());
		noticeDetail.setMessage(noticeDetailVO.getNoticeDesc());
		noticeDetail.setNoticeDate(noticeDetailVO.getNoticeDate());
		return noticeDetail;
	}

}
