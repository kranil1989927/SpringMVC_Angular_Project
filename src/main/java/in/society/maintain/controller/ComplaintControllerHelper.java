package in.society.maintain.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import in.society.maintain.common.CommonUtils;
import in.society.maintain.service.ComplaintDetailsVO;
import in.society.maintain.service.UserDetailsVO;

@Component
public class ComplaintControllerHelper {

	public ComplaintDetailsVO populateComplaintDetailsVO(ComplaintDetailsFormBean complaintDetailsFormBean) {
		ComplaintDetailsVO complaintDetailsVO = new ComplaintDetailsVO();


		if (!CommonUtils.isNullorEmpty(complaintDetailsFormBean.getComplaintType())) {
			complaintDetailsVO.setComplaintType(complaintDetailsFormBean.getComplaintType());
		}
		if (!CommonUtils.isNullorEmpty(complaintDetailsFormBean.getComplaintDescription())) {
			complaintDetailsVO.setComplaintDescription(complaintDetailsFormBean.getComplaintDescription());
		}
		
		if (!CommonUtils.isNullorEmpty(complaintDetailsFormBean.getPhoneNo())) {
			complaintDetailsVO.setPhoneNo(complaintDetailsFormBean.getPhoneNo());
		}
		if (!CommonUtils.isNullorEmpty(complaintDetailsFormBean.getAvailableTime())) {
			complaintDetailsVO.setAvailableTime(complaintDetailsFormBean.getAvailableTime());
		}

		return complaintDetailsVO;
	}
	public List<ComplaintDetailsFormBean> populateComplaintDetailsFormBeanList(List<ComplaintDetailsVO> complaintDetailsVO) {
		List<ComplaintDetailsFormBean> complaintDetailsFormBeanList = new ArrayList<ComplaintDetailsFormBean>();
		
		for (ComplaintDetailsVO complaintDetailsVo : complaintDetailsVO) {
			ComplaintDetailsFormBean complaintDetailsFormBean = new ComplaintDetailsFormBean();
			
			complaintDetailsFormBean.setComplaintNo(complaintDetailsVo.getComplaintNo());
			complaintDetailsFormBean.setComplaintType(complaintDetailsVo.getComplaintType());
			complaintDetailsFormBean.setComplaintDescription(complaintDetailsVo.getComplaintDescription());
			complaintDetailsFormBean.setPhoneNo(complaintDetailsVo.getPhoneNo());
			complaintDetailsFormBean.setAvailableTime(complaintDetailsVo.getAvailableTime());
			complaintDetailsFormBeanList.add(complaintDetailsFormBean);
		}
		
		return complaintDetailsFormBeanList;
	}

}
