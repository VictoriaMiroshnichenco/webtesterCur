package com.miroshnichenco.webtester.l3.services.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miroshnichenco.webtester.l1.entities.Question;
import com.miroshnichenco.webtester.l1.entities.Test;
import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l2.dao.AccountDao;
import com.miroshnichenco.webtester.l2.dao.TestDao;
import com.miroshnichenco.webtester.l3.services.StudentService;
import com.miroshnichenco.webtester.l3.services.TestService;
import com.miroshnichenco.webtester.l3.services.exception.InvalidUserInputException;
import com.miroshnichenco.webtester.l5.mvc.forms.SignUpForm;



@Service
public class TestServiceImpl implements TestService {
	@Autowired
	@Qualifier("testDao")
	private TestDao testDao;

	@Override
	@Transactional(readOnly=true, rollbackFor={InvalidUserInputException.class, RuntimeException.class})
	public List<Test> listTests() {
		List<Test> retval = new ArrayList<Test>();

		retval = testDao.finfAll();
		return retval;
	}

	@Override
	public Test getTestById(Long id) {
		return testDao.findByID(id);
	}

	@Override
	public Question getQuestion(Long testId, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean processAnswer(String ids) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
