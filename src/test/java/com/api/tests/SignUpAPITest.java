package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import com.api.uitils.RandomEntries;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class SignUpAPITest {
	@Test(description = "Verify if user is able to create an account")
	public void signUpTest ()
	{   
		  SignUpRequest signUpRequest= new SignUpRequest.Builder().userName(RandomEntries.randomUserName()).email("reat1@test.com").firstName("Neer").lastName("Jo").
		  mobileNumber(RandomEntries.randomPhoneNumber()).password(RandomEntries.randomPassword()).build();
		AuthService authService = new AuthService();
		Response response= authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
	
		
		
	}

}
