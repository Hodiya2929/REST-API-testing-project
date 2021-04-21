package com.whatslly.rest.api.testing_project;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import tests.data.DataProviders;

public class NegativeTestWrongEndpoint extends AbstractTest {

	@Test(dataProvider = "unvalidEndpoints", dataProviderClass = DataProviders.class)
	public void verifyWrongEndpointStatusCode(String unvalidEndpoint)
	{

		String url = initializeEndpoint(unvalidEndpoint);
		System.out.println(url);
		io.restassured.RestAssured.given()
		.config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames()))
		.when().get(url)
		.then().statusCode(404);
		/*RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames()) - this 
	to allow insecure get request - to bypass the SSL certificate - in order to reach to server
	 and get the status response
		 */	
	}
}
