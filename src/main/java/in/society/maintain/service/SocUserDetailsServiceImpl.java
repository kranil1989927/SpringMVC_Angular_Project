package in.society.maintain.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.society.maintain.dao.LoginDetailsDAO;
import in.society.maintain.model.LoginDetails;
import in.society.maintain.model.UserRole;

@Service
public class SocUserDetailsServiceImpl implements SocUserDetailsService {

	@Autowired
	private LoginDetailsDAO loginDetailsDAO;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
		LoginDetails loginDetails = loginDetailsDAO.loadUserByUsername(userName);
		List<GrantedAuthority> authorities = getUserRolesAuthority(loginDetails.getRoles());
		return getUserForAuthentication(loginDetails, authorities);
	}

	private User getUserForAuthentication(LoginDetails loginDetails, List<GrantedAuthority> authorities) {
		return new User(loginDetails.getUserName(), loginDetails.getPassword(), loginDetails.isEnabled(), true, true,
				true, authorities);
	}

	private List<GrantedAuthority> getUserRolesAuthority(Set<UserRole> userRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(setAuths);
		return authorities;
	}
}
