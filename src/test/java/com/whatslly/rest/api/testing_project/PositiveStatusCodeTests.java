package com.whatslly.rest.api.testing_project;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import tests.data.DataProviders;
import tests.data.PropertiesFilesRetriever;
import utils.TestUtil;


public class PositiveStatusCodeTests extends AbstractTest {
	
	
	@BeforeSuite(alwaysRun = true)
	public void loadPropertiesFiles() throws FileNotFoundException, Exception {
		
		
		String endpointsArrayString = PropertiesFilesRetriever.getEndpointProperties().getProperty("endpoints");

		String[] endpointsArray = endpointsArrayString.split(",");
		
		for (String endpoint : endpointsArray) {
			TestUtil.validateEndpointServer(endpoint);
		}

	}


	/**
	 * This test use a data provider annotation - load the 
	 */

	
	@Test(dataProvider = "allValidEndpoints", dataProviderClass = DataProviders.class)
	public void testAllEndpointsRespond(String endpoint)
	{
		String url = initializeEndpoint(endpoint);
		
		Response res = io.restassured.RestAssured.given().when().get(url);
		System.out.println(url);
		System.out.println(res.asString());
		res.then().statusCode(200); //validate the status code is 200
		
	}
	
	
	

}
