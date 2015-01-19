package com.miroshnichenco.webtester.l5.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.miroshnichenco.webtester.l3.services.TestService;



/**
 * @author nedis
 * @version 1.0
 */
public abstract class AbstractTutorController extends AbstractController {

	@Autowired
	protected TestService testService;
	//@Autowired
	//protected TutorService tutorService;
	
//	@Autowired
	//protected AdvancedTutorService advancedTutorService;
}
