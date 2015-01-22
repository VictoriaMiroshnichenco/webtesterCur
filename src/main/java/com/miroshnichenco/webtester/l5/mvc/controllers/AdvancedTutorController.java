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
import com.miroshnichenco.webtester.l1.entities.Question;
import com.miroshnichenco.webtester.l1.entities.Test;
import com.miroshnichenco.webtester.l5.mvc.forms.QuestionForm;
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

		return "tutor/testList";
	}

	@RequestMapping(value = "/viewTest", method = RequestMethod.GET)
	public String viewTest(@RequestParam("testId") String testId, Model model) {
		
		if (!StringUtils.isBlank(testId)) {
			Long id = Long.parseLong(testId);

			if (null != id) {
				 getTest(id, model);
				
			}
		}
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("MODE", "view");
		request.setAttribute("testId", "testId");
		return "tutor/viewTest";
	}
	@RequestMapping(value = "/createTest", method = RequestMethod.GET)
	public String createTest() {
		
		return  "redirect:advanced_tutor/createTest";
	}
	
	@RequestMapping(value = "/editTest", method = RequestMethod.GET)
	public String viewEditForm( Model model) {
		model.addAttribute("testForm", new TestForm());
		setModeForPage("edit");
		return "tutor/editTest";
	}
	
	@RequestMapping(value = "/viewQuestion", method = RequestMethod.GET)
	public String viewQuestion(@RequestParam("questionId") String questionId, Model model) {
		
		if (!StringUtils.isBlank(questionId)) {
			Long id = Long.parseLong(questionId);

			if (null != id) {
				 getQuestion(id, model);
				
			}
		}
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		request.setAttribute("MODE", "view");
		request.setAttribute("questionId", questionId);
		return "tutor/viewQuestion";
	}
	private void getQuestion(Long id, Model model) {
		QuestionForm questionForm = new QuestionForm();
		Question question = testService.getQuestion(id);
		ReflectionUtils.copyByFields(questionForm, question);
		questionForm.setTestId(question.getTest().getIdTest());
		questionForm.setAnswers(question.getAnswers());
		model.addAttribute("questionForm", questionForm);
		setModeForPage("view");
		
	}

	protected void getTestList( Model model) {

		List<Test> tests = testService.listTests();
		model.addAttribute("tests", tests);
	}
}
