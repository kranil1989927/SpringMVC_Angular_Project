package in.society.maintain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import in.society.maintain.model.Module;

public class ModuleServiceHelper {
	Map<String, List<Module>> subModuleMap;
	Set<String> topModulelist;
	List<Module> complaintsList=new ArrayList<Module>();
	List<Module> amendmensList=new ArrayList<Module>();
	List<Module> usersList=new ArrayList<Module>();
	

	public Map<String, List<Module>> getSubModules(final List<Module> modulelist) {
		subModuleMap = new TreeMap<String, List<Module>>();
		for (Module module : modulelist) {
			if( module.getModuleTopName().toString().equals("Complaint")){
				complaintsList.add(module);
			}
			if( module.getModuleTopName().toString().equals("Amendments")){
				amendmensList.add(module);
			}
			if( module.getModuleTopName().toString().equals("User")){
				usersList.add(module);
			}
//			if( module.getModuleTopName().toString().equals("Users")){
//				complaintsList.add(module);
//			}

		}
		subModuleMap.put("Complaint", complaintsList);
		subModuleMap.put("Amendments", amendmensList);
		subModuleMap.put("User", usersList);
		

		return subModuleMap;

	}

	public Set<String> getTopbModules(List<Module> modulelist) {
		topModulelist=new TreeSet<String>();
		System.out.println("Size"+modulelist.size());
		for (Module module: modulelist) {
			String key=	module.getModuleTopName().toString();
			System.out.println("Keu="+key);
			topModulelist.add(key);
		}
		return topModulelist;
	}
}
