package in.society.maintain.service;

import java.util.List;

import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.model.Module;

public interface ModuleService {

	

	List<Module> getAllTopModules(String role) throws SocietyMaintenanceException;

}
