package com.miroshnichenco.webtester.l3.services.impl;

import org.springframework.stereotype.Service;

import com.miroshnichenco.webtester.l3.services.EmailService;




@Service("emailService")
public class EmailServiceImpl implements EmailService {

	@Override
	public void sendVerificationEmail() {
		//Do nothing
	}

	@Override
	public void sendGeneratedPasswordToEmail() {
		//Do nothing
	}
}
