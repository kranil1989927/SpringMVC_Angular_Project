package in.society.maintain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import in.society.maintain.model.ComplaintDetail;

@Component
public class ComplaintDetailServiceHelper {

	public List<ComplaintDetailsVO> populateComplaintDetailVOListFromModelList(List<ComplaintDetail> complaintDetailList) {
		List<ComplaintDetailsVO> complaintDetailsVOList = new ArrayList<ComplaintDetailsVO>(complaintDetailList.size());
		for (ComplaintDetail complaintDetail : complaintDetailList) {
			ComplaintDetailsVO complaintDetailsVO = populateComplaintDetailVOFromModel(complaintDetail);
			complaintDetailsVOList.add(complaintDetailsVO);
		}
		return complaintDetailsVOList;
	}

	public ComplaintDetailsVO populateComplaintDetailVOFromModel(ComplaintDetail complaintDetail) {
		ComplaintDetailsVO complaintDetailsVO = new ComplaintDetailsVO();
		complaintDetailsVO.setComplaintNo(complaintDetail.getComplaintNo());
		complaintDetailsVO.setComplaintType(complaintDetail.getComplaintType());
		complaintDetailsVO.setComplaintDescription(complaintDetail.getComplaintDescription());
		complaintDetailsVO.setAvailableTime(complaintDetail.getAvailableTime());
		complaintDetailsVO.setPhoneNo(complaintDetail.getPhoneNo());
		complaintDetailsVO.setComplaintStatus(complaintDetail.getComplaintStatus());
		complaintDetailsVO.setComplaintLog(complaintDetail.getComplaintLog());

		return complaintDetailsVO;
	}

	public ComplaintDetail populateComplaintDetailModelFromVO(ComplaintDetailsVO complaintDetailsVO) {
		ComplaintDetail complaintDetail = new ComplaintDetail();

		if (null != complaintDetailsVO.getComplaintNo()) {
			complaintDetail.setComplaintNo(complaintDetailsVO.getComplaintNo());
		}
		complaintDetail.setComplaintType(complaintDetailsVO.getComplaintType());
		complaintDetail.setComplaintDescription(complaintDetailsVO.getComplaintDescription());
		complaintDetail.setPhoneNo(complaintDetailsVO.getPhoneNo());
		complaintDetail.setAvailableTime(complaintDetailsVO.getAvailableTime());
		complaintDetail.setComplaintStatus(complaintDetailsVO.getComplaintStatus());
		complaintDetail.setComplaintLog(complaintDetailsVO.getComplaintLog());

		return complaintDetail;
	}

}
