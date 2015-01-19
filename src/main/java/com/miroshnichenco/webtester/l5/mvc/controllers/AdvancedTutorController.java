package com.miroshnichenco.webtester.l5.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.miroshnichenco.webtester.l0.utils.ReflectionUtils;
import com.miroshnichenco.webtester.l1.entities.Test;
import com.miroshnichenco.webtester.l5.mvc.forms.TestForm;

@Controller
@RequestMapping("/advanced_tutor")
public class AdvancedTutorController extends AbstractTutorController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "advanced_tutor/home";
	}

	@RequestMapping(value = "/testList", method = RequestMethod.GET)
	public String testList(Model model) {

		getTestList(model);

		return "advanced_tutor/testList";
	}

	@RequestMapping(value = "/viewTest", method = RequestMethod.GET)
	public String viewTest(@RequestParam("testId") String userId, Model model) {
		
		if (!StringUtils.isBlank(userId)) {
			Long id = Long.parseLong(userId);

			if (null != id) {
				 getTest(id, model);
				
			}
		}
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("MODE", "view");
		return "advanced_tutor/testForm";
	}

	protected void getTest(Long idTest, Model model) {
		TestForm form = new TestForm();
		Test test = testService.getTestById(idTest);
		ReflectionUtils.copyByFields(form, test );

		model.addAttribute("test", test);
		model.addAttribute("testForm",form );
	}
	protected void getTestList( Model model) {

		List<Test> tests = testService.listTests();
		model.addAttribute("tests", tests);
	}
}
