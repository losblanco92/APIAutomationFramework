package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {

	@Test
	public void GetProfileRequestTest() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("LosBlanco19", "Test@123"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());

		UserManagementService userManagementService = new UserManagementService();
		response= userManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
	}

}
