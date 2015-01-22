package com.miroshnichenco.webtester.l5.mvc.controllers;

import java.beans.PropertyEditorSupport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.miroshnichenco.webtester.l0.application.ApplicationConstants;
import com.miroshnichenco.webtester.l1.entities.Answer;
import com.miroshnichenco.webtester.l1.entities.Question;
import com.miroshnichenco.webtester.l1.entities.Test;
import com.miroshnichenco.webtester.l3.services.TestService;
import com.miroshnichenco.webtester.l3.services.exception.InvalidUserInputException;
import com.miroshnichenco.webtester.l5.mvc.forms.QuestionForm;
import com.miroshnichenco.webtester.l5.mvc.forms.SignUpForm;
import com.miroshnichenco.webtester.l5.mvc.forms.TestForm;


@Controller
@RequestMapping("/tutor")
public class TutorController extends AbstractTutorController implements InitializingBean{
	//TODO move from here
	private final Map<Integer, String> redirects = new HashMap<Integer, String>();
	@Override
	public void afterPropertiesSet() throws Exception {

		redirects.put(ApplicationConstants.TUTOR_ROLE, "/tutor/home");
		redirects.put(ApplicationConstants.ADVANCED_TUTOR_ROLE, "/advanced_tutor/home");

	}

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
	
	@RequestMapping(value = "/createTest", method = RequestMethod.GET)
	public String viewCreateForm( Model model) {
		model.addAttribute("testForm", new TestForm());
		setModeForPage("create");
		return "tutor/createTest";
	}
	@RequestMapping(value = "/editTest", method = RequestMethod.GET)
	public String viewEditForm( Model model) {
		model.addAttribute("testForm", new TestForm());
		setModeForPage("edit");
		return "tutor/editTest";
	}

	@RequestMapping(value = "/createTest", method = RequestMethod.POST)
	public String testCreate(@Validated @ModelAttribute("testForm") TestForm testForm,  BindingResult result, Model model) {
		
		try {
			Long testId =  testService.createTest(testForm);
			// setModeForPage("view");
			return "redirect:/advanced_tutor/viewTest?testId="+testId;
		} catch (Exception e) {
			result.addError(new ObjectError("", e.getMessage()));
			setModeForPage("create");
			//TODO return to error page
			return "tutor/createTest";
		}
		
	}
	@RequestMapping(value = "/viewTest", method = RequestMethod.GET)
	public String viewTest(@RequestParam("testId") String testId, Model model) {
		
		
		if (!StringUtils.isBlank(testId)) {
			Long id = Long.parseLong(testId);

			if (null != id) {
				if(!checkOwner(id)){
					return "redirect:error";
				}

				
			}
		}
		
		
		return "redirect:/advanced_tutor/viewTest?testId="+testId;
	}
	
	@RequestMapping(value = "/addQuestion", method = RequestMethod.GET)
	public String viewAddQuestionForm( @RequestParam("testId") String testId,  Model model ) {
		QuestionForm questionForm = new QuestionForm();
		Test test = testService.getTestById(Long.parseLong(testId));
		questionForm.setTestId(Long.parseLong(testId));
		model.addAttribute("questionForm",questionForm );
		setModeForPage("create");
		return "tutor/addQuestion";
	}
	
	@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	public String addQuestion(@Validated @ModelAttribute("testForm") QuestionForm questionForm, BindingResult result, Model model) {
		
		try {
			Long questionId =  testService.createQuestion(questionForm);
			Long testId = questionForm.getTestId();
			model.addAttribute("questionForm",questionForm );
			setModeForPage("create");

			return "tutor/addQuestion";
			
		} catch (Exception e) {
			result.addError(new ObjectError("", e.getMessage()));
			setModeForPage("create");
			//TODO return to error page
			return "tutor/addQuestion";
		}
		
	}
	
	@RequestMapping(value = "/viewQuestions", method = RequestMethod.GET)
	public String questionList(@RequestParam("testId") String testId, Model model) {
		if (!StringUtils.isBlank(testId)) {
			Long id = Long.parseLong(testId);

			if (null != id) {
				getQuestionList(id,model);
			}
		}
		return "tutor/questionList";
	}
	
	@RequestMapping(value = "/viewQuestion", method = RequestMethod.GET)
	public String viewQuestion(@RequestParam("questionId") String questionId, Model model) {
		
		
		if (!StringUtils.isBlank(questionId)) {
			Long id = Long.parseLong(questionId);

			if (null != id) {
				

				
			}
		}
		
		
		return "redirect:/advanced_tutor/viewQuestion?questionId="+questionId;
	}
	
	

	private boolean checkOwner(Long testId) {
		return tutorService.checkOwner(testId);
	}

	protected void getTestList(Long userId, Model model) {
		List<Test> tests = testService.listTests(userId);
		model.addAttribute("tests", tests);
	}
	
	private void getQuestionList(Long id, Model model) {
		Test test = testService.getTestById(id);
		List<Question> questions = test.getQuestions();
		model.addAttribute("questions", questions);
		
	}
	
	
	
	class AnswerEditor extends PropertyEditorSupport {
		 
        @Override
        public void setAsText(String text){
            Long id = Long.parseLong(text);
            List<Answer> answers = testService.getTestById(id).getQuestions().get(0).getAnswers();
            setValue(answers);
        }
    }
 
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Answer.class, new AnswerEditor());
    }
}
