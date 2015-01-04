package com.miroshnichenco.webtester.l0.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.miroshnichenco.webtester.l2.dao.AccountDao;


public class MainTest {

	public static void main(String[] args) {
		System.out.println(1);
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");			
		System.out.println(ctx.isActive());
	//	AccountDao   dao = (AccountDao) ctx.getBean("hibernateAccountDao");
		//System.out.println(dao);
	//	System.out.println(dao.findByEmail("ivnov@fake.net"));
	}

}
