package com.miroshnichenco.webtester.l2.dao.impl.hibernate;


import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l2.dao.AccountDao;
@Repository("hibernateAccountDao")
public class AccountDaoImpl extends AbstractEntityDao<User> implements AccountDao{

	public User findByEmail(String email) {
		return (User) getSession().createCriteria(getEntityClass()).add(Restrictions.eq("email", email)).uniqueResult();
	}
	public User findByLogin(String login) {
		return (User) getSession().createCriteria(getEntityClass()).add(Restrictions.eq("login", login)).uniqueResult();
	}

	@Override
	protected Class getEntityClass() {
		return User.class;
	}

}
