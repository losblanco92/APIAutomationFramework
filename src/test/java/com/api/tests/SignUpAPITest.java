package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class SignUpAPITest {
	@Test(description = "Verify if user is able to create an account")
	public void signUpTest ()
	{   
		  SignUpRequest signUpRequest= new SignUpRequest.Builder().userName("LoBlanco196").email("reat1@test.com").firstName("Neer").lastName("Jo").
		  mobileNumber("0700000000").password("Test@123").build();
		AuthService authService = new AuthService();
		Response response= authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
	
		
		
	}

}
