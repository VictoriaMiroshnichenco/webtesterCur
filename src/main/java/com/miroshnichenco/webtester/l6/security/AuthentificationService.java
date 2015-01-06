package com.miroshnichenco.webtester.l6.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.miroshnichenco.webtester.l0.application.ApplicationConstants;
import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l1.entities.UserRole;
import com.miroshnichenco.webtester.l2.dao.AccountDao;

@Service("accountAuthentificationService")
public class AuthentificationService implements UserDetailsService {
	private static final Map<Integer, String> ROLES = new HashMap<Integer, String>();
	static {
		ROLES.put(ApplicationConstants.ADMIN_ROLE, "ADMIN");
		ROLES.put(ApplicationConstants.TUTOR_ROLE, "TUTOR");
		ROLES.put(ApplicationConstants.ADVANCED_TUTOR_ROLE, "ADVANCED_TUTOR");
		ROLES.put(ApplicationConstants.STUDENT_ROLE, "STUDENT");
	}
	static Collection<? extends GrantedAuthority> convert(List<UserRole> roles) {
		Collection<SimpleGrantedAuthority> res = new ArrayList<SimpleGrantedAuthority>();
		for(UserRole ar : roles) {
			res.add(new SimpleGrantedAuthority(ROLES.get(ar.getRole().getIdRole().intValue())));
		}
		return res;
	}
	
	@Autowired
	@Qualifier("hibernateAccountDao")
	private AccountDao accountDao;
	
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		User a = accountDao.findByEmail(email);
		if(a == null) {
			throw new UsernameNotFoundException("Account not found by email="+email);
		}
		return new CurrentAccount(a);
	}
}
