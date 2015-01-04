package com.miroshnichenco.webtester.l2.dao;

import com.miroshnichenco.webtester.l1.entities.Role;

public interface RoleDao extends IEntityDao<Role>{
	public Role getStudentRole();
}
