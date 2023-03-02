package com.gayathri.springboot.myFirstApp.login;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gayathri.springboot.myFirstApp.hello.AuthenticationService;

import ch.qos.logback.classic.Logger;

//web controller
@Controller
@SessionAttributes("name")
public class WelcomeController {
	//using logger instead of sysout
//	private Logger logger=(Logger) LoggerFactory.getLogger(getClass());
	
	//use constructor injection to autowire private authenticationService
	
//	private AuthenticationService authenticationService;
	
	
	
	/*
	 * public LoginController(AuthenticationService authenticationService) {
	 * super(); this.authenticationService = authenticationService; }
	 */


	//get , post are handled - to tell to handle only post use Requestmethod
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name",getLoggedinUsername());
		return "welcome";
		
	}
	
	
	/*
	 * //capturing form data using requestparam
	 * 
	 * @RequestMapping(value="login",method=RequestMethod.POST) public String
	 * goToWelcome(@RequestParam String name,@RequestParam String password,ModelMap
	 * model) {
	 * 
	 * if(authenticationService.authenticate(name, password)) {
	 * model.put("name",name); model.put("password",password); return "welcome";
	 * //authentication - hardcoded
	 * 
	 * //name=gayathri //password=gayathri } else { model.put("error",
	 * "incorrect username or password"); return "Login"; }
	 * 
	 * 
	 * 
	 * }
	 */	/*
	 * Spring security takes care of login and logout
	 * */
	
	private String getLoggedinUsername() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	
}
