package com.miroshnichenco.webtester.l3.services.impl;

import java.util.ArrayList;
import java.util.List;



import java.util.UUID;

















import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miroshnichenco.webtester.l0.utils.ReflectionUtils;
import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l2.dao.AccountDao;
import com.miroshnichenco.webtester.l3.components.EntityBuilder;
import com.miroshnichenco.webtester.l3.services.AdminService;
import com.miroshnichenco.webtester.l3.services.exception.InvalidUserInputException;
import com.miroshnichenco.webtester.l5.mvc.forms.SignUpForm;









@Service("adminService")

@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	@Qualifier("hibernateAccountDao")
	private AccountDao accountDao;
	
	@Autowired
	@Qualifier("entityBuilder")
	private EntityBuilder entityBuilder;
	
	@Override
	public List<User> listAllUsers() {
		List<User> retval = new ArrayList<User>();
		retval = accountDao.finfAll();
		return retval;
	}
	
	@Override
	@Transactional(readOnly=false, rollbackFor={InvalidUserInputException.class, RuntimeException.class})
	public void delete (Long id) throws InvalidUserInputException {
		User user = accountDao.findByID(id);
		if(null == user){
			throw new InvalidUserInputException("User does not exist ");
		}
		accountDao.delete(user);
	
	}

	@Override
	@Transactional(readOnly=false, rollbackFor={InvalidUserInputException.class, RuntimeException.class})
	public User edit(SignUpForm form) throws InvalidUserInputException {
		User user = entityBuilder.buildAccount();
		ReflectionUtils.copyByFields(user, form);
		accountDao.update(user);
		return user;
		
	}

	@Override
	public User findById(Long id) throws InvalidUserInputException {
		User user = accountDao.findByID(id);
		if(null == user){
			throw new InvalidUserInputException("No such user");
		}
		return user;
	}
}
