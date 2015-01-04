package com.miroshnichenco.webtester.l2.dao.impl.hibernate;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.miroshnichenco.webtester.l1.entities.Role;
import com.miroshnichenco.webtester.l2.dao.RoleDao;
@Repository("hibernateRoleDao")
public class RoleDaoImpl extends AbstractEntityDao<Role> implements RoleDao{

	@Override
	protected Class getEntityClass() {
		return Role.class;
	}
	@Override
	public Role getStudentRole() {
		return (Role) getSession().createCriteria(getEntityClass()).add(Restrictions.eq("idRole", 4L)).uniqueResult();
	}

}
