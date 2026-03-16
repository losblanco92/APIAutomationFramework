package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class LoginAPITest {
	
	@Test
	public void logintest ()
	
	{  
		LoginRequest loginRequest = new LoginRequest("string", "string");
		AuthService authService = new AuthService();
		Response response= authService.login(loginRequest);
		LoginResponse loginResponse= response.as(LoginResponse.class);
		
		System.out.println(response.asPrettyString());
		
		System.out.println(loginResponse.getToken());
		
	}
	

}
