package com.miroshnichenco.webtester.l5.mvc.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;

import com.miroshnichenco.webtester.l1.entities.Role;
import com.miroshnichenco.webtester.l3.services.CommonService;


public abstract class AbstractController {
	protected final Logger LOGGER = Logger.getLogger(getClass());
	
	@Autowired
	@Qualifier("commonService") 
	protected CommonService commonService;
	
	 protected void initRoles(Model model){
	    	List<Role> roles = commonService.listAllRoles();
			model.addAttribute("roles", roles);
	    }
}
