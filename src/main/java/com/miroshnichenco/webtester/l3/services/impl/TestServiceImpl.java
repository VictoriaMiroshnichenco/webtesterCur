package com.miroshnichenco.webtester.l3.services.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miroshnichenco.webtester.l0.utils.ReflectionUtils;
import com.miroshnichenco.webtester.l1.entities.Question;
import com.miroshnichenco.webtester.l1.entities.Test;
import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l2.dao.AccountDao;
import com.miroshnichenco.webtester.l2.dao.AnswerDao;
import com.miroshnichenco.webtester.l2.dao.QuestionDao;
import com.miroshnichenco.webtester.l2.dao.TestDao;
import com.miroshnichenco.webtester.l3.services.TestService;
import com.miroshnichenco.webtester.l3.services.exception.InvalidUserInputException;
import com.miroshnichenco.webtester.l5.mvc.forms.QuestionForm;
import com.miroshnichenco.webtester.l5.mvc.forms.TestForm;
import com.miroshnichenco.webtester.l6.security.SecurityUtils;



@Service
public class TestServiceImpl implements TestService {
	@Autowired
	@Qualifier("testDao")
	private TestDao testDao;
	@Autowired
	@Qualifier("questionDao")
	private QuestionDao questionDao;
	@Qualifier("answerDao")
	private AnswerDao answerDao;

	
	@Autowired
	@Qualifier("hibernateAccountDao")
	private AccountDao accountDao;

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

	@Override
	public List<Test> listTests(Long userId) {
		List<Test> retval = new ArrayList<Test>();
		User user = accountDao.findByID(userId);
		retval = testDao.listTestsForUser(user);
		return retval;
	}
	
	@Transactional(readOnly=false, rollbackFor={RuntimeException.class})
	@Override
	public Long createTest(TestForm testForm) {
		Test test = new Test();
		Long testId = null;
		ReflectionUtils.copyByFields(test, testForm);
		User user = accountDao.findByID(SecurityUtils.getCurrentIdAccount());
		test.setUser(user);
		test.setCreated(new Timestamp(System.currentTimeMillis()));
		//how to avoid exception if it will be string
		testId = (Long) testDao.save(test);
		return testId;
		
	}
	
	@Transactional(readOnly=false, rollbackFor={RuntimeException.class})
	@Override
	public Long createQuestion(QuestionForm questionForm) {
		Long testId = questionForm.getTestId();
		
		//TODO move test from form
		Test test = testDao.findByID(testId);
		Question question = new Question();
		question.setQuestion(questionForm.getQuestion());
		question.setCreated(new Timestamp(System.currentTimeMillis()));
		question.setTest(test);
		//question.setAnswers(answers);
	
		//test.setQuestions(questions);
		//question.setAnswers(questionForm.getAnswers());
		questionDao.save(question);
		return test.getIdTest();
	}

	@Override
	public Question getQuestion(Long id) {
		
		return questionDao.findByID(id);
	}

	
}
