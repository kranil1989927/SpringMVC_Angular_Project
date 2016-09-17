package in.society.maintain.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import in.society.maintain.common.CommonUtils;
import in.society.maintain.common.SocietyMaintenanceConstants;
import in.society.maintain.service.AmenityDetailsVO;

@Component
public class AmenityControllerHelper {

	public AmenityDetailsFormBean populateAmenityDetailsFormBean(AmenityDetailsVO amenityDetailsVO, Boolean isUpdated) {
		AmenityDetailsFormBean amenityDetailsFormBean = new AmenityDetailsFormBean();

		amenityDetailsFormBean.setAmenityId(String.valueOf(amenityDetailsVO.getAmenityId()));
		if (isUpdated) {
			amenityDetailsFormBean.setAmenityType(amenityDetailsVO.getAmenityType());
			amenityDetailsFormBean.setAmenityStatus(amenityDetailsVO.getAmenityStatus());
		} else {
			amenityDetailsFormBean.setAmenityType(populateAmenityType(amenityDetailsVO.getAmenityType()));
			amenityDetailsFormBean.setAmenityStatus(populateAmityStatus(amenityDetailsVO.getAmenityStatus()));
		}

		String userName = amenityDetailsVO.getSocUserDetailsVO().getFirstName() + " " + amenityDetailsVO.getSocUserDetailsVO().getLastName();
		amenityDetailsFormBean.setUserName(userName);
		amenityDetailsFormBean.setStartDate(CommonUtils.convertToDateString(amenityDetailsVO.getStartDate(), "MM/dd/yyyy"));
		amenityDetailsFormBean.setEndDate(CommonUtils.convertToDateString(amenityDetailsVO.getEndDate(), "MM/dd/yyyy"));
		amenityDetailsFormBean.setNotes(amenityDetailsVO.getNotes());
		amenityDetailsFormBean.setUserId(String.valueOf(amenityDetailsVO.getUserId()));

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

	public List<AmenityDetailsFormBean> populateAmenityFormBeanListFromVO(List<AmenityDetailsVO> amenityDetailsVOList) {
		List<AmenityDetailsFormBean> amenityDetailsFormBeanList = new ArrayList<AmenityDetailsFormBean>(amenityDetailsVOList.size());
		for (AmenityDetailsVO amenityDetailsVO : amenityDetailsVOList) {
			amenityDetailsFormBeanList.add(this.populateAmenityDetailsFormBean(amenityDetailsVO, Boolean.FALSE));
		}
		return amenityDetailsFormBeanList;
	}

	private String populateAmenityType(String amenityType) {

		Map<String, String> amenityTypeMap = new LinkedHashMap<String, String>();
		amenityTypeMap.put("badmintonCourt", SocietyMaintenanceConstants.BADMINTON_COURT);
		amenityTypeMap.put("clubhouse", SocietyMaintenanceConstants.CLUB_HOUSE);
		amenityTypeMap.put("parking", SocietyMaintenanceConstants.PARKING);
		amenityTypeMap.put("swimming", SocietyMaintenanceConstants.SWIMMING);

		return amenityTypeMap.get(amenityType);
	}

	private String populateAmityStatus(String amenityStatus) {

		Map<String, String> amenityStatusMap = new LinkedHashMap<String, String>();
		amenityStatusMap.put("inprogress", SocietyMaintenanceConstants.INPROGRESS);
		amenityStatusMap.put("applied", SocietyMaintenanceConstants.APPLIED);
		amenityStatusMap.put("approved", SocietyMaintenanceConstants.APPROVED);
		amenityStatusMap.put("expired", SocietyMaintenanceConstants.EXPIRED);

		return amenityStatusMap.get(amenityStatus);
	}
}
