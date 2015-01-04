package com.miroshnichenco.webtester.l2.dao.impl.hibernate;


import org.springframework.stereotype.Repository;

import com.miroshnichenco.webtester.l1.entities.UserRole;
import com.miroshnichenco.webtester.l2.dao.AccountRoleDao;


@Repository("hibernateAccountRoleDao")
public class AccountRoleDaoImpl extends AbstractEntityDao<UserRole> implements AccountRoleDao {

	@Override
	protected Class<UserRole> getEntityClass() {
		return UserRole.class;
	}

}
