package in.society.maintain.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import in.society.maintain.common.CommonUtils;
import in.society.maintain.service.SocUserDetailsVO;
import in.society.maintain.service.UserDetailsVO;
import in.society.maintain.service.UserRoleVO;

@Component
public class UserControllerHelper {
	
	private static final String IMG_BASE_64 = "data:image/jpeg;base64,";

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

	
	public SocUserDetailsVO populateUsersDetailsVO(SocUserFormBean socUserFormBean) {
		SocUserDetailsVO socUserDetailsVO = new SocUserDetailsVO();
		if (!CommonUtils.isNullorEmpty(socUserFormBean.getUserId())) {
			socUserDetailsVO.setUserId(Long.valueOf(socUserFormBean.getUserId()));
		}
		if (!CommonUtils.isNullorEmpty(socUserFormBean.getUserName())) {
			socUserDetailsVO.setUserName(socUserFormBean.getUserName());
		}
		if (!CommonUtils.isNullorEmpty(socUserFormBean.getFirstName())) {
			socUserDetailsVO.setFirstName(socUserFormBean.getFirstName());
		}
		if (!CommonUtils.isNullorEmpty(socUserFormBean.getMiddleName())) {
			socUserDetailsVO.setMiddleName(socUserFormBean.getMiddleName());
		}
		if (!CommonUtils.isNullorEmpty(socUserFormBean.getLastName())) {
			socUserDetailsVO.setLastName(socUserFormBean.getLastName());
		}
		if (!CommonUtils.isNullorEmpty(socUserFormBean.getEmailId())) {
			socUserDetailsVO.setEmailId(socUserFormBean.getEmailId());
		}
		if (!CommonUtils.isNullorEmpty(socUserFormBean.getPanNo())) {
			socUserDetailsVO.setPanNo(socUserFormBean.getPanNo());
		}
		
		if(!CommonUtils.isNullorEmpty(socUserFormBean.getProfileImage())){
			String profilePic = socUserFormBean.getProfileImage().replace(IMG_BASE_64, "");
			socUserDetailsVO.setProfileImage(profilePic);
		}
		
		if (!CommonUtils.isNullorEmpty(socUserFormBean.getPhoneNo())) {
			socUserDetailsVO.setPhoneNo(socUserFormBean.getPhoneNo());
		}
		if (!CommonUtils.isNullorEmpty(socUserFormBean.getAddress())) {
			socUserDetailsVO.setAddress(socUserFormBean.getAddress());
		}
		if (!CommonUtils.isNullorEmpty(socUserFormBean.getNoOfMembers())) {
			socUserDetailsVO.setNoOfMembers(socUserFormBean.getNoOfMembers());
		}
		if (!CommonUtils.isNullorEmpty(socUserFormBean.getIsOwner())) {
			socUserDetailsVO.setIsOwner(socUserFormBean.getIsOwner());
		}
		if (!CommonUtils.isNullorEmpty(socUserFormBean.getStartDate())) {
			socUserDetailsVO.setStartDate(CommonUtils.convertToDate(socUserFormBean.getStartDate(), "MM/dd/yyyy"));
		}
		if (!CommonUtils.isNullorEmpty(socUserFormBean.getEndDate())) {
			socUserDetailsVO.setEndDate(CommonUtils.convertToDate(socUserFormBean.getEndDate(), "MM/dd/yyyy"));
		}
		if (!CommonUtils.isNullorEmpty(socUserFormBean.getUserRoles())) {
			String[] roles = socUserFormBean.getUserRoles().split(",");
			Set<UserRoleVO> userRoleSet = new HashSet<UserRoleVO>();
			for (String userRole : roles) {
				UserRoleVO userRoleVO = new UserRoleVO();
				userRoleVO.setRole(userRole);
				userRoleSet.add(userRoleVO);
			}
			socUserDetailsVO.setRoles(userRoleSet);
		}
		return socUserDetailsVO;
	}
}
