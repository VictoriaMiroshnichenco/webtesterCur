package com.miroshnichenco.webtester.l5.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.miroshnichenco.webtester.l0.utils.ReflectionUtils;
import com.miroshnichenco.webtester.l1.entities.Test;
import com.miroshnichenco.webtester.l3.services.TestService;
import com.miroshnichenco.webtester.l3.services.TutorService;
import com.miroshnichenco.webtester.l5.mvc.forms.TestForm;



/**
 * @author nedis
 * @version 1.0
 */
public abstract class AbstractTutorController extends AbstractController {

	@Autowired
	protected TestService testService;
	@Autowired
	protected TutorService tutorService;
	
//	@Autowired
//	protected AdvancedTutorService advancedTutorService;
	
	protected void getTest(Long idTest, Model model) {
		TestForm form = new TestForm();
		Test test = testService.getTestById(idTest);
		ReflectionUtils.copyByFields(form, test );

		model.addAttribute("test", test);
		model.addAttribute("testForm",form );
	}
}
