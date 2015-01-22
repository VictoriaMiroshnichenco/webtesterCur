package com.miroshnichenco.webtester.l3.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.miroshnichenco.webtester.l1.entities.Test;
import com.miroshnichenco.webtester.l3.services.TestService;
import com.miroshnichenco.webtester.l3.services.TutorService;
import com.miroshnichenco.webtester.l6.security.CurrentAccount;
import com.miroshnichenco.webtester.l6.security.SecurityUtils;
@Service("tutorService")

@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TutorServiceImpl implements TutorService {
	@Autowired
	protected TestService testService;
	@Override
	public boolean checkOwner(Long testId) {
		Test test = testService.getTestById(testId);
		CurrentAccount currentAccount = SecurityUtils.getCurrentAccount();
		return test.getUser().getIdUser().equals(currentAccount.getIdAccount()) ;
	}

}
