package in.society.maintain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import in.society.maintain.model.SocUser;

@Component
public class SocUserDetailsServiceHelper {

	public List<SocUserDetailsVO> populateSocUserDetailsVOListFromModelList(List<SocUser> socUserList) {
		List<SocUserDetailsVO> socUserDetailsVOList = new ArrayList<SocUserDetailsVO>(socUserList.size());
		for (SocUser socUser : socUserList) {
			SocUserDetailsVO socUserDetailsVO = populateSocUserDetailVOFromModel(socUser);
			socUserDetailsVOList.add(socUserDetailsVO);
		}
		return socUserDetailsVOList;
	}

	public SocUserDetailsVO populateSocUserDetailVOFromModel(SocUser socUser) {
		SocUserDetailsVO socUserDetailsVO = new SocUserDetailsVO();
		socUserDetailsVO.setUserId(socUser.getUserId());
		socUserDetailsVO.setFirstName(socUser.getFirstName());
		socUserDetailsVO.setMiddleName(socUser.getMiddleName());
		socUserDetailsVO.setLastName(socUser.getLastName());
		socUserDetailsVO.setEmailId(socUser.getEmailId());
		socUserDetailsVO.setPhoneNo(socUser.getPhoneNo());
		socUserDetailsVO.setPanNo(socUser.getPanNo());
		socUserDetailsVO.setIsOwner(socUser.getIsOwner());
		socUserDetailsVO.setAddress(socUser.getAddress());
		socUserDetailsVO.setNoOfMembers(socUser.getNoOfMembers());
		socUserDetailsVO.setStartDate(socUser.getStartDate());
		socUserDetailsVO.setEndDate(socUser.getEndDate());
		return socUserDetailsVO;
	}

	public SocUser populateSocUserDetailsModelFromVO(SocUserDetailsVO socUserDetailsVO) {
		SocUser socUser = new SocUser();
		socUser.setUserId(socUserDetailsVO.getUserId());
		socUser.setFirstName(socUserDetailsVO.getFirstName());
		socUser.setMiddleName(socUserDetailsVO.getMiddleName());
		socUser.setLastName(socUserDetailsVO.getLastName());
		socUser.setEmailId(socUserDetailsVO.getEmailId());
		socUser.setPhoneNo(socUserDetailsVO.getPhoneNo());
		socUser.setPanNo(socUserDetailsVO.getPanNo());
		socUser.setIsOwner(socUserDetailsVO.getIsOwner());
		socUser.setAddress(socUserDetailsVO.getAddress());
		socUser.setNoOfMembers(socUserDetailsVO.getNoOfMembers());
		socUser.setStartDate(socUserDetailsVO.getStartDate());
		socUser.setEndDate(socUserDetailsVO.getEndDate());
		return socUser;
	}

}
