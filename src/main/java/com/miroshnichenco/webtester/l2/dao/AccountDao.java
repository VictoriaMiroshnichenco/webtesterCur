package com.miroshnichenco.webtester.l2.dao;



import com.miroshnichenco.webtester.l1.entities.User;


public interface AccountDao extends IEntityDao<User>{
	User findByEmail(String email);
}
