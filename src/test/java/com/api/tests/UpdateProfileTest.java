package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileUpdateRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	
	public void updateProfileTest ()
	{
		AuthService authService = new AuthService();
		Response response=  authService.login(new LoginRequest("string", "string"));
		LoginResponse loginResponse= response.as(LoginResponse.class);
		
		UserManagementService usrManagementService = new UserManagementService();
		
		ProfileUpdateRequest profileUpdateRequest = new ProfileUpdateRequest.Builder().firstName("Josh").email("abc@xyz.com")
		.lastName("Smith").mobileNumber("0900000000").build();
		
		usrManagementService.updateProfile(loginResponse.getToken(), profileUpdateRequest);
		
		
		
	}

}
