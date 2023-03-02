package com.gayathri.springboot.myFirstApp.hello;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username,String password) {
		boolean isValidUsername=username.equalsIgnoreCase("gayathri");
		boolean isValidPwd=password.equalsIgnoreCase("gayathri");
		
		return isValidUsername && isValidPwd;
	}
}
