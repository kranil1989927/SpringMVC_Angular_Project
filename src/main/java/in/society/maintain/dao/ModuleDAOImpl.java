package in.society.maintain.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.society.maintain.model.Module;

@Repository
public class ModuleDAOImpl implements ModuleDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(ModuleDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Module> getAllTopModules(String role) {
		LOGGER.debug("Getting all the user");
		String Query = "select * from modules m where m.user_role = 'Y'";
		SQLQuery queryString = sessionFactory.getCurrentSession().createSQLQuery(Query).addEntity(Module.class);
		List<Module> modules = new ArrayList<Module>();
		modules = queryString.list();
		for (Module module : modules) {
			System.out.println("Top module :  "+module.getModuleTopName());
			System.out.println("Module     :"+module.getModuleName());
		}
		return modules;
	}}
