package in.society.maintain.dao;

import java.util.List;

import in.society.maintain.model.Module;

public interface ModuleDAO {


	List<Module> getAllTopModules(String role);


}
