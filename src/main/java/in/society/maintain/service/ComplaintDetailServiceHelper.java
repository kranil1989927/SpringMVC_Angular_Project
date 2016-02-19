package in.society.maintain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import in.society.maintain.common.CommonUtils;
import in.society.maintain.model.Complaint;
import in.society.maintain.model.User;

@Component
public class ComplaintDetailServiceHelper {

	public Complaint populateComplaint(ComplaintDetailsVO complaintDetailsVO) {

		Complaint complaint = new Complaint();

		/*
		 * if (null != Integer.valueOf(userDetailsVO.getUserId())) {
		 * user.setUserId(userDetailsVO.getUserId()); }
		 */

		if (!CommonUtils.isNullorEmpty(complaintDetailsVO.getComplaintType())) {
			complaint.setComplaintType(complaintDetailsVO.getComplaintType());
		}
		if (!CommonUtils.isNullorEmpty(complaintDetailsVO.getComplaintDescription())) {
			complaint.setComplaintDescription(complaintDetailsVO.getComplaintDescription());
		}
		
		if (!CommonUtils.isNullorEmpty(complaintDetailsVO.getPhoneNo())) {
			complaint.setPhoneNo(complaintDetailsVO.getPhoneNo());
		}
		if (!CommonUtils.isNullorEmpty(complaintDetailsVO.getAvailableTime())) {
			complaint.setAvailableTime(complaintDetailsVO.getAvailableTime());
		}

		return complaint;
	}

	public UserDetailsVO populateUserDetailVO(User user) {

		UserDetailsVO userDetailsVO = new UserDetailsVO();

		if (null != Integer.valueOf(user.getUserId())) {
			userDetailsVO.setUserId(user.getUserId());
		}
		if (!CommonUtils.isNullorEmpty(user.getUserName())) {
			userDetailsVO.setUserName(user.getUserName());
		}
		if (!CommonUtils.isNullorEmpty(user.getPassword())) {
			userDetailsVO.setPassword(user.getPassword());
		}
		return userDetailsVO;
	}

	public List<ComplaintDetailsVO> populateComplaintDetailVOList(List<Complaint> complaint) {

		List<ComplaintDetailsVO> complaintDetailsVOlist = new ArrayList<ComplaintDetailsVO>();
		for (Complaint complaintValue : complaint) {
			ComplaintDetailsVO complaintDetailsVO = new ComplaintDetailsVO();
			complaintDetailsVO.setComplaintNo(complaintValue.getComplaintNo());
			complaintDetailsVO.setComplaintType(complaintValue.getComplaintType());
			complaintDetailsVO.setComplaintDescription(complaintValue.getComplaintDescription());
			complaintDetailsVO.setPhoneNo(complaintValue.getPhoneNo());
			complaintDetailsVO.setAvailableTime(complaintValue.getAvailableTime());
			complaintDetailsVOlist.add(complaintDetailsVO);
		}
		return complaintDetailsVOlist;
	}
}
