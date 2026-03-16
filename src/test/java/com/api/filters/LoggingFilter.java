package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.api.models.response.LoginResponse;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {

	private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec);
		LogResponse(response);
		return response;
	}

	public void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("BASE URI: " + requestSpec.getBaseUri());
		logger.info("BASE PAYLOAD: " + requestSpec.getBody());
		logger.info("HEADER: "+ requestSpec.getHeaders());

	}

	public void LogResponse(Response response) {
		logger.info("STATUS CODE: " + response.getStatusCode());
		logger.info("RESPONSE BODY: " + response.getBody());

	}

	
	//Filters in Rest Assured intercept API requests and responses.
	//They are commonly used for logging, modifying requests,
	//generating log files, and attaching request and response 
	  //details to reports like Extent Reports or Allure for easier debugging.
}
