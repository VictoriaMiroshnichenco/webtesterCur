package com.miroshnichenco.webtester.l3.services;

import java.util.List;

import com.miroshnichenco.webtester.l1.entities.Test;
import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l3.services.exception.InvalidUserInputException;
import com.miroshnichenco.webtester.l5.mvc.forms.SignUpForm;


public interface StudentService {

	User edit(SignUpForm form) throws InvalidUserInputException;


}
