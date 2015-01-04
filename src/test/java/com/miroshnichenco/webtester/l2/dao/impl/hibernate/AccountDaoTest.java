package com.miroshnichenco.webtester.l2.dao.impl.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l1.entities.Role;
import com.miroshnichenco.webtester.l2.dao.AccountDao;
import com.miroshnichenco.webtester.l2.dao.RoleDao;
import com.miroshnichenco.webtester.l2.dao.impl.hibernate.utils.HibernateUtils;
import com.miroshnichenco.webtester.l3.components.EntityBuilder;
import com.miroshnichenco.webtester.l3.components.impl.EntityBuilderImpl;

public class AccountDaoTest {
	EntityBuilder builder = new EntityBuilderImpl();
	//@Test
	public void createRoleTest(){
		
	RoleDao dao = new RoleDaoImpl();
	Role testEntity = builder.buildRole("UnitTestRole");
	
	Session s = HibernateUtils.getSessionFactory().openSession();
	s.beginTransaction();
	dao.save(testEntity);
	System.out.println(testEntity.getIdRole());
	Assert.assertNotNull(testEntity.getIdRole());
	s.close();
}
	@Test
	public void findAllRoleTest(){
		Session s = HibernateUtils.getSessionFactory().openSession();
		s.beginTransaction();	
		AccountDao dao = new AccountDaoImpl();
		
		List<User> list = dao.finfAll();
		System.out.println(list);
		Assert.assertNotNull(list);
	}
}
