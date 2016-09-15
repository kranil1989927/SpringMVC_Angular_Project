package in.society.maintain.controller;

import org.springframework.stereotype.Component;

import in.society.maintain.common.CommonUtils;
import in.society.maintain.service.AmenityDetailsVO;

@Component
public class AmenityControllerHelper {

	public AmenityDetailsFormBean populateAmenityDetailsFormBean(AmenityDetailsVO amenityDetailsVO) {
		AmenityDetailsFormBean amenityDetailsFormBean = new AmenityDetailsFormBean();

		amenityDetailsFormBean.setAmenityId(String.valueOf(amenityDetailsVO.getAmenityId()));
		amenityDetailsFormBean.setAmenityType(amenityDetailsVO.getAmenityType());
		amenityDetailsFormBean.setAmenityStatus(amenityDetailsVO.getAmenityStatus());

		String userName = amenityDetailsVO.getSocUserDetailsVO().getFirstName() + " " + amenityDetailsVO.getSocUserDetailsVO().getLastName();
		amenityDetailsFormBean.setUserName(userName);
		amenityDetailsFormBean.setStartDate(CommonUtils.convertToDateString(amenityDetailsVO.getStartDate(), "MM/dd/yyyy"));
		amenityDetailsFormBean.setEndDate(CommonUtils.convertToDateString(amenityDetailsVO.getEndDate(), "MM/dd/yyyy"));
		amenityDetailsFormBean.setNotes(amenityDetailsVO.getNotes());

		return amenityDetailsFormBean;
	}

	public AmenityDetailsVO populateAmenityDetailsVO(AmenityDetailsFormBean amenityFormBean) {
		AmenityDetailsVO amenityDetailsVO = new AmenityDetailsVO();

		if (!CommonUtils.isNullorEmpty(amenityFormBean.getAmenityId())) {
			amenityDetailsVO.setAmenityId(Long.valueOf(amenityFormBean.getAmenityId()));
		}

		if (!CommonUtils.isNullorEmpty(amenityFormBean.getAmenityType())) {
			amenityDetailsVO.setAmenityType(amenityFormBean.getAmenityType());
		}

		if (!CommonUtils.isNullorEmpty(amenityFormBean.getAmenityStatus())) {
			amenityDetailsVO.setAmenityStatus(amenityFormBean.getAmenityStatus());
		}

		if (!CommonUtils.isNullorEmpty(amenityFormBean.getUserId())) {
			amenityDetailsVO.setUserId(Long.valueOf(amenityFormBean.getUserId()));
		}

		if (!CommonUtils.isNullorEmpty(amenityFormBean.getStartDate())) {
			amenityDetailsVO.setStartDate(CommonUtils.convertToDate(amenityFormBean.getStartDate(), "MM/dd/yyyy"));
		}

		if (!CommonUtils.isNullorEmpty(amenityFormBean.getEndDate())) {
			amenityDetailsVO.setEndDate(CommonUtils.convertToDate(amenityFormBean.getEndDate(), "MM/dd/yyyy"));
		}

		if (!CommonUtils.isNullorEmpty(amenityFormBean.getNotes())) {
			amenityDetailsVO.setNotes(amenityFormBean.getNotes());
		}

		return amenityDetailsVO;
	}
}
