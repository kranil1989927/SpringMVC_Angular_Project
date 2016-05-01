package in.society.maintain.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import in.society.maintain.controller.UserController;
import in.society.maintain.model.LoginDetails;
import in.society.maintain.model.SocUser;

@Component
public class SocUserDetailsServiceHelper {

	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

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
		if (socUser.getProfileImage() != null) {
			socUserDetailsVO.setProfileImage(new String(socUser.getProfileImage()));
		}
		socUserDetailsVO.setIsOwner(socUser.getIsOwner());
		socUserDetailsVO.setAddress(socUser.getAddress());
		socUserDetailsVO.setNoOfMembers(socUser.getNoOfMembers());
		socUserDetailsVO.setStartDate(socUser.getStartDate());
		socUserDetailsVO.setEndDate(socUser.getEndDate());
		socUserDetailsVO.setUserName(socUser.getLoginDetails().getUserName());
		return socUserDetailsVO;
	}

	public SocUser populateSocUserDetailsModelFromVO(SocUserDetailsVO socUserDetailsVO) {
		SocUser socUser = new SocUser();
		if (socUserDetailsVO.getUserId() != null) {
			socUser.setUserId(socUserDetailsVO.getUserId());
		}
		socUser.setFirstName(socUserDetailsVO.getFirstName());
		socUser.setMiddleName(socUserDetailsVO.getMiddleName());
		socUser.setLastName(socUserDetailsVO.getLastName());
		socUser.setEmailId(socUserDetailsVO.getEmailId());
		socUser.setPhoneNo(socUserDetailsVO.getPhoneNo());
		socUser.setProfileImage(socUserDetailsVO.getProfileImage().getBytes());
		socUser.setPanNo(socUserDetailsVO.getPanNo());
		socUser.setIsOwner(socUserDetailsVO.getIsOwner());
		socUser.setAddress(socUserDetailsVO.getAddress());
		socUser.setNoOfMembers(socUserDetailsVO.getNoOfMembers());
		socUser.setStartDate(socUserDetailsVO.getStartDate());
		socUser.setEndDate(socUserDetailsVO.getEndDate());
		return socUser;
	}

	public LoginDetails populateLoginDetailsModelFromVO(SocUserDetailsVO socUserDetailsVO) {
		LoginDetails loginDetails = new LoginDetails();
		loginDetails.setUserName(socUserDetailsVO.getUserName());
		loginDetails.setPassword(generateMD5Password("NEW_USER"));
		loginDetails.setEnabled(Boolean.TRUE);
		return loginDetails;
	}

	private String generateMD5Password(String password) {
		String passwordToHash = password;
		MessageDigest md;
		StringBuilder generatedPassword = new StringBuilder();
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(passwordToHash.getBytes());
			byte[] bytes = md.digest();
			for (int i = 0; i < bytes.length; i++) {
				generatedPassword.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("Failed to convert the string message to MD5");
		}
		return generatedPassword.toString();
	}
}
