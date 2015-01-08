package com.miroshnichenco.webtester.l5.mvc.controllers;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.miroshnichenco.webtester.l1.entities.Role;
import com.miroshnichenco.webtester.l1.entities.User;
import com.miroshnichenco.webtester.l3.services.AdminService;
import com.miroshnichenco.webtester.l3.services.exception.InvalidUserInputException;
import com.miroshnichenco.webtester.l5.mvc.forms.LoginForm;
import com.miroshnichenco.webtester.l5.mvc.forms.SignUpForm;

@Controller
@RequestMapping("/admin")
public class AdminControler extends AbstractController {

	@Autowired
	@Qualifier("adminService")
	protected AdminService adminService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "admin/home";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String manageUsers(Model model) {
		userList(model);
		return "admin/users";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET, params = "userId")
	public String deleteUser(@RequestParam("userId") String userId) {
		// TODO what should I do with empty string?
		if (StringUtils.isNotBlank(userId)) {
			Long id = Long.parseLong(userId);
			try {
				adminService.delete(id);
			} catch (InvalidUserInputException e) {
				// result.addError(new ObjectError("", e.getMessage()));
				// TODO how should I process exceptions?

				LOGGER.error(
						"request :  " + "raise exception " + e.getMessage(), e);
				// return "admin/users";
				return "redirect:" + "/admin/users";
			}
		}
		return "redirect:" + "/admin/users";
		// return "admin/users";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET, params = "userId")
	public String showEditForm(@RequestParam("userId") String userId,
			Model model) {
		if (StringUtils.isEmpty(userId)) {
			// TODO
		}
		Long id = Long.parseLong(userId);
		try {
			User user = adminService.findById(id);

			SignUpForm form = new SignUpForm();
			form.setLogin(user.getLogin());
			form.setEmail(user.getEmail());
			form.setName(user.getName());
			form.setPassword(user.getPassword());
			form.setIdUser(user.getIdUser());
			
			model.addAttribute("signUpForm", form);
		} catch (InvalidUserInputException e) {
			// TODO how to process exception
			e.printStackTrace();
		}
		return "signUp";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String editUser(
			@Validated @ModelAttribute("signUpForm") SignUpForm signUpForm,
			BindingResult result, @RequestParam(required=false, value="save") String save, @RequestParam(required=false, value="cancel" ) String cancel) {
		//TODO how to process cansel
				if (cancel != null ){
					return "redirect:" + "/admin/users";
				}
		try {
			adminService.edit(signUpForm);
		} catch (InvalidUserInputException e) {
			result.addError(new ObjectError("", e.getMessage()));
			return "/edit";
		}
		return "redirect:" + "/admin/users";
	}

	protected void userList(Model model) {
		List<User> users = adminService.listAllUsers();
		model.addAttribute("users", users);
	}
}
