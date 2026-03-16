package com.api.base;

import com.api.models.request.ProfileUpdateRequest;

import io.restassured.response.Response;

public class UserManagementService extends BaseService {
	
	private final static String BASE_PATH ="api/users/";
	
	
      public Response getProfile (String token)
      
       {  setAuthToken(token);
    	  return getRequest(BASE_PATH+"/profile");
      }
      
      
      public void updateProfile(String token, ProfileUpdateRequest  payload)
      { 
    	  setAuthToken(token);
    	  putRequest(payload, BASE_PATH+"/profile");
      }
}
