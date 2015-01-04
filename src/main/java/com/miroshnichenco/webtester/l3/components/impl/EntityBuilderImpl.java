package com.miroshnichenco.webtester.l3.components.impl;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l1.entities.UserRole;
import com.miroshnichenco.webtester.l1.entities.Role;
import com.miroshnichenco.webtester.l3.components.EntityBuilder;




@Component("entityBuilder")
public class EntityBuilderImpl implements EntityBuilder {
	
	@Override
	public User buildAccount() {
		User a = new User();
		a.setCreated(new Timestamp(System.currentTimeMillis()));
		a.setActive(Boolean.FALSE);
		return a;
	}
	
	@Override
	public UserRole buildAccountRole(User user, Role role) {
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		return userRole;
		
	}

	@Override
	public Role buildRole(String name) {
		Role role = new Role();
		role.setName(name);
		return role;
	}
}
