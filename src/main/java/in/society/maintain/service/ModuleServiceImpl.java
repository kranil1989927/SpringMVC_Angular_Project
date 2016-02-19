package in.society.maintain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.society.maintain.dao.ModuleDAO;
import in.society.maintain.model.Module;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleDAO moduleDAO;

	@Autowired
	private UserDetailServiceHelper userDetailServiceHelper;

	@Override
	@Transactional
	public List<Module> getAllTopModules(String role) {
		List<Module> moduleList = moduleDAO.getAllTopModules(role);
		return moduleList;
	}

	public void setModuleDAO(ModuleDAO moduleDAO) {
		this.moduleDAO = moduleDAO;
	}

}
