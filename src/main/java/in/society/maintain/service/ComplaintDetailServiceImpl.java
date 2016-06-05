package in.society.maintain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.dao.ComplaintDetailsDAO;
import in.society.maintain.model.ComplaintDetail;

@Service
public class ComplaintDetailServiceImpl implements ComplaintDetailService {

	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintDetailServiceImpl.class);

	/** complaintDetailsDAO represents the complaint related DAO operations */
	@Autowired
	private ComplaintDetailsDAO complaintDetailsDAO;

	/** complaintDetailServiceHelper it take cares of complaint detail service overhead */
	@Autowired
	private ComplaintDetailServiceHelper complaintDetailServiceHelper;

	@Override
	@Transactional
	public ComplaintDetailsVO saveOrUpdate(ComplaintDetailsVO complaintDetailsVO) throws SocietyMaintenanceException {
		ComplaintDetail complaintDetail = null;
		ComplaintDetailsVO complaintDetailVO = null;
		LOGGER.debug("Saving Complaint Details");
		try {
			complaintDetail = this.getComplaintDetailServiceHelper().populateComplaintDetailModelFromVO(complaintDetailsVO);
			complaintDetail = this.complaintDetailsDAO.saveOrUpdate(complaintDetail);

			if (complaintDetail.getComplaintNo() != null) {
				LOGGER.info("Complaint No : {} is updated successfully", complaintDetail.getComplaintNo());
			} else {
				LOGGER.info("Complaint No : {} is added successfully", complaintDetail.getComplaintNo());
			}
			complaintDetailVO = this.getComplaintDetailServiceHelper().populateComplaintDetailVOFromModel(complaintDetail);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while saving/updating details of complaint due to {}", dae.getMessage());
			throw new SocietyMaintenanceException("Exception while saving/updating details of complaint due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while saving/updating details of complaint of user due to {}", ex.getMessage());
			throw new SocietyMaintenanceException("Exception while saving/updating details of complaint due to : " + ex.getMessage(), ex);
		}

		return complaintDetailVO;
	}

	@Override
	@Transactional
	public ComplaintDetailsVO getComplaintDetail(Long complaintId) throws SocietyMaintenanceException {
		ComplaintDetailsVO complaintDetailsVO = null;
		LOGGER.debug("Getting a complaint details of complaint id : {}", complaintId);
		try {
			final ComplaintDetail complaintDetail = this.getComplaintDetailsDAO().getComplaintDetail(complaintId);
			complaintDetailsVO = this.getComplaintDetailServiceHelper().populateComplaintDetailVOFromModel(complaintDetail);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while getting details of complaint of complaint id : {} due to {}", complaintId, dae.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of complaint of complaint id : " + complaintId + "due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while getting details of complaint of complaint id : {} due to {}", complaintId, ex.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of complaint of complaint id : " + complaintId + "due to : " + ex.getMessage(), ex);
		}

		return complaintDetailsVO;
	}

	@Override
	@Transactional
	public List<ComplaintDetailsVO> getAllComplaints() throws SocietyMaintenanceException {
		List<ComplaintDetailsVO> complaintDetailsVOList = null;
		LOGGER.debug("Getting a details of all complaints details");
		try {
			final List<ComplaintDetail> complaintDetailList = this.getComplaintDetailsDAO().getAllComplaints();
			complaintDetailsVOList = this.getComplaintDetailServiceHelper().populateComplaintDetailVOListFromModelList(complaintDetailList);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while getting details of all complaints due to {}", dae.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of all complaints due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while getting details of all complaints due to {}", ex.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of all complaints due to : " + ex.getMessage(), ex);
		}
		return complaintDetailsVOList;
	}

	public ComplaintDetailsDAO getComplaintDetailsDAO() {
		return complaintDetailsDAO;
	}

	public ComplaintDetailServiceHelper getComplaintDetailServiceHelper() {
		return complaintDetailServiceHelper;
	}

}
