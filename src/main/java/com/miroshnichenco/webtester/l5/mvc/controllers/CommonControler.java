package com.miroshnichenco.webtester.l5.mvc.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;





import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miroshnichenco.webtester.l0.application.ApplicationConstants;
import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l1.entities.Role;
import com.miroshnichenco.webtester.l3.services.exception.InvalidUserInputException;
import com.miroshnichenco.webtester.l5.mvc.forms.LoginForm;
import com.miroshnichenco.webtester.l5.mvc.forms.SignUpForm;
import com.miroshnichenco.webtester.l6.security.CurrentAccount;
import com.miroshnichenco.webtester.l6.security.SecurityUtils;


@Controller
public class CommonControler extends AbstractController implements InitializingBean {
	
	private final Map<Integer, String> redirects = new HashMap<Integer, String>();
	
	@Override
	public void afterPropertiesSet() throws Exception {
		redirects.put(ApplicationConstants.ADMIN_ROLE, "/admin/home");
		redirects.put(ApplicationConstants.ADVANCED_TUTOR_ROLE, "/advanced_tutor/home");
		redirects.put(ApplicationConstants.TUTOR_ROLE, "/tutor/home");
		redirects.put(ApplicationConstants.STUDENT_ROLE, "/home");
	}
	
	//@Autowired
	//protected CommonService commonService;
	
	//TODO how to bind validator?
	/*@Autowired
    @Qualifier("loginFormValidator")// it is name of validator from bean config
    private Validator validator;
 
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }*/
   /**
    *  
    * @param result - for error, has to follow for form?
    * @return
    */
    @RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
			@Validated @ModelAttribute("loginForm") LoginForm loginForm,
			BindingResult result, Model model, HttpSession session) {
		try {
			if (result.hasErrors()) {
				initRoles(model);
				return "login";
			}
			User a = commonService.login(loginForm.getLogin(),
					loginForm.getPassword(), loginForm.getIdRole());
			session.setAttribute("CURRENT_ACCOUNT", a);
			return "redirect:" + redirects.get(loginForm.getIdRole());
		} catch (InvalidUserInputException e) {
			result.addError(new ObjectError("", e.getMessage()));
			initRoles(model);
			return "login";
		}
	}
    
    protected void initRoles(Model model){
    	List<Role> roles = commonService.listAllRoles();
		model.addAttribute("roles", roles);
    }
    
	@RequestMapping(value={"/login","/loginFailed"}, method=RequestMethod.GET)
	public String showLogin(Model model){
		model.addAttribute("loginForm", new LoginForm());
		initRoles(model);
		return "login";
	}
	@RequestMapping(value="/signUp", method=RequestMethod.GET)
	public String showSignUp(Model model){
		model.addAttribute("signUpForm", new SignUpForm());

		return "signUp";
	}
	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public String signUp(@Validated @ModelAttribute("signUpForm") SignUpForm signUpForm, BindingResult result, @RequestParam(required=false, value="save") String save, @RequestParam(required=false, value="cancel") String cancel){
		
		//TODO how to process cansel
		if (cancel != null ){
			return "login";
		}
		
		try {
			 commonService.signUp(signUpForm);
		} catch (InvalidUserInputException e) {
			result.addError(new ObjectError("", e.getMessage()));
			return "/signUp";
		}

		return "signUpSuccess";
	}
	@RequestMapping(value={"/myInfo"}, method=RequestMethod.GET)
	public String myInfo(Model model){
		CurrentAccount currentAccount = SecurityUtils.getCurrentAccount();
		return "redirect:"+redirects.get(currentAccount.getRole());
	}
}
