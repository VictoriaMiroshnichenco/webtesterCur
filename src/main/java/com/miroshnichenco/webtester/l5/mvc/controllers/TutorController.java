package com.miroshnichenco.webtester.l5.mvc.controllers;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miroshnichenco.webtester.l1.entities.Test;
import com.miroshnichenco.webtester.l3.services.TestService;


@Controller
@RequestMapping("/tutor")
public class TutorController extends AbstractTutorController {
	
	
	

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(){
		return "tutor/home";
	}
	
	@RequestMapping(value = "/testList", method = RequestMethod.GET)
	public String testList(@RequestParam("userId") String userId, Model model) {
		if (!StringUtils.isBlank(userId)) {
			Long id = Long.parseLong(userId);

			if (null != id) {
				getTestList(id,model);
			}
		}
		return "tutor/testList";
	}
	
	protected void getTestList(Long userId, Model model) {
		//TODO id
		List<Test> tests = testService.listTests();
		model.addAttribute("tests", tests);
	}
}
