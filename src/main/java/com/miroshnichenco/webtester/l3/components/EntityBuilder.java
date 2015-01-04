package com.miroshnichenco.webtester.l3.components;

import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l1.entities.UserRole;
import com.miroshnichenco.webtester.l1.entities.Role;

public interface EntityBuilder {

	User buildAccount();
	Role buildRole(String name);
	UserRole buildAccountRole(User user, Role role);
}
