package in.society.maintain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.dao.SocUserDetailsDAO;
import in.society.maintain.model.SocUser;

/**
 * This contains the business logic of User management module
 * 
 * @author ANIL
 *
 */
@Service
public class SocUserDetailsServiceImpl implements SocUserDetailsService {

	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(SocUserDetailsServiceImpl.class);

	/** socUserDAO represents the user management related DAO operations */
	@Autowired
	private SocUserDetailsDAO socUserDAO;

	/** socUserDetailsServiceHelper it take cares of user management service overhead */
	@Autowired
	private SocUserDetailsServiceHelper socUserDetailsServiceHelper;

	@Override
	public SocUserDetailsVO saveOrUpdate(SocUserDetailsVO socUserDetailsVO) throws SocietyMaintenanceException {
		LOGGER.debug("Saving Society User Details");
		try {
			SocUser socUser = this.getSocUserDetailsServiceHelper().populateSocUserDetailsModelFromVO(socUserDetailsVO);
			this.getSocUserDAO().saveOrUpdateSocUser(socUser);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while saving details of society user due to {}", dae.getMessage());
			throw new SocietyMaintenanceException("Exception while saving details of society user due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while saving details of society user of user due to {}", ex.getMessage());
			throw new SocietyMaintenanceException("Exception while saving details of society user due to : " + ex.getMessage(), ex);
		}
		return socUserDetailsVO;
	}

	@Override
	public Boolean deleteSocUser(Long userId) throws SocietyMaintenanceException {
		Boolean isDeleted = Boolean.FALSE;
		LOGGER.debug("Deleting a society user of user id : {}", userId);
		try {
			isDeleted = this.getSocUserDAO().deleteSocUser(userId);
			LOGGER.info("Society User of user id {} is deleted successfully", userId);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while deleting the society user of user id : {} due to {}", userId, dae.getMessage());
			throw new SocietyMaintenanceException("Exception while deleting the society user of user id : " + userId + "due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while deleting the society user of user id : {} due to {}", userId, ex.getMessage());
			throw new SocietyMaintenanceException("Exception while deleting the society user of user id : " + userId + "due to : " + ex.getMessage(), ex);
		}
		return isDeleted;
	}

	@Override
	public SocUserDetailsVO getSocUserDetails(Long userId) throws SocietyMaintenanceException {
		SocUserDetailsVO socUserDetailsVO = null;
		LOGGER.debug("Getting a society user details of user id : {}", userId);
		try {
			final SocUser socUser = this.getSocUserDAO().getSocUserDetails(userId);
			socUserDetailsVO = this.getSocUserDetailsServiceHelper().populateSocUserDetailVOFromModel(socUser);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while getting details of society user of user id : {} due to {}", userId, dae.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of society user of user id : " + userId + "due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while getting details of society user of user id : {} due to {}", userId, ex.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of society user of user id : " + userId + "due to : " + ex.getMessage(), ex);
		}
		return socUserDetailsVO;
	}

	@Override
	public List<SocUserDetailsVO> getAllUsers() throws SocietyMaintenanceException {
		List<SocUserDetailsVO> socUserDetailsVOList = null;
		LOGGER.debug("Getting a details of all society user");
		try {
			final List<SocUser> socUserList = this.getSocUserDAO().getAllSocUsers();
			socUserDetailsVOList = this.getSocUserDetailsServiceHelper().populateSocUserDetailsVOListFromModelList(socUserList);
		} catch (DataAccessException dae) {
			LOGGER.error("Database exception while getting details of all society user due to {}", dae.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of all society user due to : " + dae.getMessage(), dae);
		} catch (Exception ex) {
			LOGGER.error("Exception while getting details of all society user due to {}", ex.getMessage());
			throw new SocietyMaintenanceException("Exception while getting details of all society user due to : " + ex.getMessage(), ex);
		}
		return socUserDetailsVOList;
	}

	public SocUserDetailsDAO getSocUserDAO() {
		return socUserDAO;
	}

	public SocUserDetailsServiceHelper getSocUserDetailsServiceHelper() {
		return socUserDetailsServiceHelper;
	}

}
