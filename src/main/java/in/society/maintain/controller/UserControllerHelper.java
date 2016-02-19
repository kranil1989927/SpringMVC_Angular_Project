package in.society.maintain.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import in.society.maintain.common.CommonUtils;
import in.society.maintain.service.UserDetailsVO;
import in.society.maintain.service.SocUserDetailsVO;

@Component
public class UserControllerHelper {

	public UserDetailsVO populateUserDetailsVO(UserDetailsFormBean userDetailsFormBean) {
		UserDetailsVO userDetailsVO = new UserDetailsVO();

		/*if (null != Integer.valueOf(userDetailsFormBean.getUserId())) {
			userDetailsVO.setUserId(Integer.valueOf(userDetailsFormBean.getUserId()));
		}*/

		if (!CommonUtils.isNullorEmpty(userDetailsFormBean.getUserName())) {
			userDetailsVO.setUserName(userDetailsFormBean.getUserName());
		}
		if (!CommonUtils.isNullorEmpty(userDetailsFormBean.getPassword())) {
			userDetailsVO.setPassword(userDetailsFormBean.getPassword());
		}

		return userDetailsVO;
	}
	public List<UserDetailsFormBean> populateUserDetailsFormBeanVOList(List<UserDetailsVO> userDetailsVO) {
		List<UserDetailsFormBean> userDetailsFormBean = new ArrayList<UserDetailsFormBean>();
		
		for (UserDetailsVO userDetailVO : userDetailsVO) {
			UserDetailsFormBean userDetailFormBean = new UserDetailsFormBean();
			
			userDetailFormBean.setUserId(userDetailVO.getUserId());
			userDetailFormBean.setUserName(userDetailVO.getUserName());
			userDetailFormBean.setPassword(userDetailVO.getPassword());
			userDetailsFormBean.add(userDetailFormBean);
		}
		
		return userDetailsFormBean;
	}

	
	public SocUserDetailsVO populateUsersDetailsVO(SocUserFormBean userFormBean) {
		SocUserDetailsVO userVO = new SocUserDetailsVO();

		if (!CommonUtils.isNullorEmpty(userFormBean.getFirstName())) {
			userVO.setFirstName(userFormBean.getFirstName());
		}

		if (!CommonUtils.isNullorEmpty(userFormBean.getMiddleName())) {
			userVO.setMiddleName(userFormBean.getMiddleName());
		}
		if (!CommonUtils.isNullorEmpty(userFormBean.getLastName())) {
			userVO.setLastName(userFormBean.getLastName());
		}
		if (!CommonUtils.isNullorEmpty(userFormBean.getEmailId())) {
			userVO.setEmailId(userFormBean.getEmailId());
		}
		if (!CommonUtils.isNullorEmpty(userFormBean.getPanNo())) {
			userVO.setPanNo(userFormBean.getPanNo());
		}
		if (!CommonUtils.isNullorEmpty(userFormBean.getPhoneNo())) {
			userVO.setPhoneNo(userFormBean.getPhoneNo());
		}
		if (!CommonUtils.isNullorEmpty(userFormBean.getAddress())) {
			userVO.setAddress(userFormBean.getAddress());
		}
		if (!CommonUtils.isNullorEmpty(userFormBean.getNoOfMembers())) {
			userVO.setNoOfMembers(userFormBean.getNoOfMembers());
		}
		if (!CommonUtils.isNullorEmpty(userFormBean.getIsOwner())) {
			userVO.setIsOwner(userFormBean.getIsOwner());
		}
		if (!CommonUtils.isNullorEmpty(userFormBean.getStartDate())) {
			userVO.setStartDate(userFormBean.getStartDate());
		}
		if (!CommonUtils.isNullorEmpty(userFormBean.getEndDate())) {
			userVO.setEndDate(userFormBean.getEndDate());
		}
		return userVO;
	}
}
