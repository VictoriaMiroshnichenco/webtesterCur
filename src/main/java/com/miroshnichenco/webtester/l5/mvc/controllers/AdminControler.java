package com.miroshnichenco.webtester.l5.mvc.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/admin")
public class AdminControler extends AbstractController {

//	@Autowired
//	protected AdminService adminService;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(){
		return "admin/home";
	}
}
