package com.miroshnichenco.webtester.l5.mvc.controllers;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miroshnichenco.webtester.l1.entities.Answer;
import com.miroshnichenco.webtester.l1.entities.Question;
import com.miroshnichenco.webtester.l1.entities.Test;
import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l3.services.StudentService;
import com.miroshnichenco.webtester.l3.services.TestService;


@Controller
@RequestMapping("/student")
public class StudentController extends AbstractController {

	@Autowired
	protected StudentService studentService;
	
	@Autowired
	protected TestService testService;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(){
		return "student/home";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(@RequestParam("testId") String testId, Model model) {
		if(StringUtils.isNotBlank(testId)){
			Long id = Long.parseLong(testId);
			if(null!=id){
				Test test = testService.getTestById(id);
				model.addAttribute("test", test);
			}
		}
		return "student/test";
	}
	
	
	@RequestMapping(value = "/testList", method = RequestMethod.GET)
	public String testList( Model model) {
		
		getTestList(model);
		
		return "student/testList";
	}
	
	@RequestMapping(value = "/testQuestion", method = RequestMethod.GET)
	public String testQuestion(@RequestParam("testId") String testId,@RequestParam("count") String countStr,
			Model model) {
		// TODO not null
		int count = Integer.parseInt(countStr);
		Long id = Long.parseLong(testId);

		Test test = testService.getTestById(id);
		List<Question> listQuestion = test.getQuestions();
		if (count >= listQuestion.size()) {
			return "student/endTest";
		}
		Question question = listQuestion.get(count);// testService.getQuestion(id,1)
													// ;

		List<Answer> answers = question.getAnswers();
		model.addAttribute("test", test);
		model.addAttribute("question", question);
		model.addAttribute("answers", answers);
		model.addAttribute("count", count);
		return "student/testQuestion";
	}
	
	@RequestMapping(value = "/processAnswer", method = RequestMethod.POST)
	public String processAnswer(@RequestParam("testId") String testId,@RequestParam("answerId") String answerId,@RequestParam("count") String countStr,
			Model model) {
		
		int count = Integer.parseInt(countStr);
		
		// TODO not null
	//	Long id = Long.parseLong(testId);
	//	Test test = testService.getTestById(id);
		boolean correct = testService.processAnswer(answerId);
		
	/*	Question question = null;
		List<Answer> answers = null;
		List<Question> listQuestions = test.getQuestions();
		if (!(listQuestions == null || listQuestions.isEmpty())) {
			question = test.getQuestions().get(0);// testService.getQuestion(id,1)
													
			if (question!= null ) {
				answers = question.getAnswers();
			}
		}
		model.addAttribute("test", test);
		model.addAttribute("question", question);
		model.addAttribute("answers", answers);
		*/
		count++;
		return "redirect:/student/testQuestion?count="+count+"&testId="+testId;
	}

	protected void getTestList(Model model) {
		List<Test> tests = testService.listTests();
		model.addAttribute("tests", tests);
	}
}
