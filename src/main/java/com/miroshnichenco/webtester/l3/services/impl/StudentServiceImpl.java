package com.miroshnichenco.webtester.l3.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miroshnichenco.webtester.l1.entities.Test;
import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l2.dao.AccountDao;
import com.miroshnichenco.webtester.l2.dao.TestDao;
import com.miroshnichenco.webtester.l3.services.StudentService;
import com.miroshnichenco.webtester.l3.services.exception.InvalidUserInputException;
import com.miroshnichenco.webtester.l5.mvc.forms.SignUpForm;



@Service
public class StudentServiceImpl implements StudentService {
	
	
	
	@Autowired
	@Qualifier("hibernateAccountDao")
	private AccountDao accountDao;
	
	@Override
	@Transactional(readOnly=false, rollbackFor={InvalidUserInputException.class, RuntimeException.class})
	public User edit(SignUpForm form) throws InvalidUserInputException {
	/*	User user= new USer;//= findById(form.getIdUser());
		user.setName(form.getName());
		user.setEmail(form.getEmail());
		user.setUpdated(new Timestamp(System.currentTimeMillis()));
		
		//accountDao.update(user);
		return user;
		*/ return null;
	}

	
	
}
