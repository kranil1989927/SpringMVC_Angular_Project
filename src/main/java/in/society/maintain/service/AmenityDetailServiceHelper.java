package in.society.maintain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.society.maintain.model.AmenityDetail;

@Component
public class AmenityDetailServiceHelper {
	
	/** socUserDetailsServiceHelper it take cares of society user details service overhead */
	@Autowired
	private SocUserDetailsServiceHelper socUserDetailsServiceHelper; 

	public AmenityDetailsVO populateAmenityDetailVOFromModel(AmenityDetail amenityDetail) {
		AmenityDetailsVO amenityDetailsVO = new AmenityDetailsVO();
		amenityDetailsVO.setAmenityId(amenityDetail.getAmenityId());
		amenityDetailsVO.setAmenityType(amenityDetail.getAmenityType());
		amenityDetailsVO.setAmenityStatus(amenityDetail.getAmenityStatus());
		amenityDetailsVO.setSocUserDetailsVO(this.getSocUserDetailsServiceHelper().populateSocUserDetailVOFromModel(amenityDetail.getSocUser()));
		amenityDetailsVO.setUserId(amenityDetail.getSocUser().getUserId());
		
		String userName = amenityDetail.getSocUser().getFirstName() + " " + amenityDetail.getSocUser().getLastName();
		amenityDetailsVO.setUserName(userName);
		amenityDetailsVO.setStartDate(amenityDetail.getStartDate());
		amenityDetailsVO.setEndDate(amenityDetail.getEndDate());
		amenityDetailsVO.setNotes(amenityDetail.getNotes());

		return amenityDetailsVO;
	}

	public List<AmenityDetailsVO> populateAmenityDetailVOListFromModelList(List<AmenityDetail> amenityDetailList) {

		List<AmenityDetailsVO> amenityDetailsVOList = new ArrayList<AmenityDetailsVO>(amenityDetailList.size());
		for (AmenityDetail amenityDetail : amenityDetailList) {
			amenityDetailsVOList.add(this.populateAmenityDetailVOFromModel(amenityDetail));
		}

		return amenityDetailsVOList;
	}

	public AmenityDetail populateAmenityDetailModelFromVO(AmenityDetailsVO amenityDetailsVO) {
		AmenityDetail amenityDetail = new AmenityDetail();

		if (null != amenityDetailsVO.getAmenityId()) {
			amenityDetail.setAmenityId(amenityDetailsVO.getAmenityId());
		}

		amenityDetail.setAmenityStatus(amenityDetailsVO.getAmenityStatus());
		amenityDetail.setAmenityType(amenityDetailsVO.getAmenityType());
		amenityDetail.setSocUser(this.getSocUserDetailsServiceHelper().populateSocUserDetailsModelFromVO(amenityDetailsVO.getSocUserDetailsVO()));
		amenityDetail.setStartDate(amenityDetailsVO.getStartDate());
		amenityDetail.setEndDate(amenityDetailsVO.getEndDate());
		amenityDetail.setNotes(amenityDetailsVO.getNotes());

		return amenityDetail;
	}

	public SocUserDetailsServiceHelper getSocUserDetailsServiceHelper() {
		return socUserDetailsServiceHelper;
	}

}
