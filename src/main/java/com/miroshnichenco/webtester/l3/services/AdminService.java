package com.miroshnichenco.webtester.l3.services;

import java.util.List;

import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l1.entities.Role;
import com.miroshnichenco.webtester.l3.services.exception.InvalidUserInputException;
import com.miroshnichenco.webtester.l5.mvc.forms.SignUpForm;



public interface AdminService {

	List<User> listAllUsers();
	
	 void delete (Long id) throws InvalidUserInputException;

	 User edit(SignUpForm signUpForm) throws InvalidUserInputException;
	 User findById(Long id) throws InvalidUserInputException;
}
