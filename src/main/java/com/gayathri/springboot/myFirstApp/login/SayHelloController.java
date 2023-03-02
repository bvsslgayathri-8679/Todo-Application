package com.gayathri.springboot.myFirstApp.login;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//web controller
public class SayHelloController {
	//SAY HELLO
	//HELLO WHAT R U DOING TODAY
	
	@RequestMapping("say-hello")
	@ResponseBody
	//will return what ever is returned by the function as it is
	public String sayHello() {
		return "hello! what r u learning today";
		
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	//will return what ever is returned by the function as it is
	public String sayHelloHtml() {
		StringBuffer sb=new StringBuffer();
		//hardcoding html file
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>my first html page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("my 1st hhtml page with body!");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();

	}
	//sayhello.jsp
	//sayhellojsp->sayhello.jsp
	
	
//	@ResponseBody
	//will return what ever is returned by the function as it is
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHi";
		
	}
	
	
	
	
	
}
