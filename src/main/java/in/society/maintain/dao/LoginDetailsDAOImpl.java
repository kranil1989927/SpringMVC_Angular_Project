package in.society.maintain.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.society.maintain.model.LoginDetails;

@Repository
public class LoginDetailsDAOImpl implements LoginDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public LoginDetails loadUserByUsername(String userName) {

		List<LoginDetails> users = new ArrayList<LoginDetails>();

		System.out.println("Query Start");
		users = this.sessionFactory.getCurrentSession().createQuery(" from LoginDetails where userName=:userName")
				.setParameter("userName", userName).list();
		System.out.println("Query Ended");
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}
}
