package in.society.maintain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.dao.AmenityDetailDAOImpl;

@Service
public class AmenityDetailServiceImpl implements AmenityDetailService {

	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(AmenityDetailServiceImpl.class);

	@Override
	public AmenityDetailsVO saveOrUpdate(AmenityDetailsVO amenityDetailsVO) throws SocietyMaintenanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AmenityDetailsVO getAmenityDetail(Long amenityId) throws SocietyMaintenanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AmenityDetailsVO> getAllAmenities() throws SocietyMaintenanceException {
		// TODO Auto-generated method stub
		return null;
	}

}
