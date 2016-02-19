package in.society.maintain.dao;

import in.society.maintain.model.LoginDetails;

public interface LoginDetailsDAO {
	
	LoginDetails loadUserByUsername(String userName);
}
