package com.miroshnichenco.webtester.l3.services;

import java.util.List;

import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l1.entities.Role;
import com.miroshnichenco.webtester.l3.services.exception.InvalidUserInputException;
import com.miroshnichenco.webtester.l5.mvc.forms.SignUpForm;



public interface CommonService {
	User login (String email, String password, int role) throws InvalidUserInputException;
	
	User signUp (SignUpForm form) throws InvalidUserInputException;
	
	List<Role> listAllRoles();
	
	String getSupportEmailAddress();
}
