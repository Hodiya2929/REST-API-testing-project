package com.whatslly.rest.api.testing_project;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import tests.data.DataProviders;

public class AllEndpointsOutputTheSameValues extends AbstractTest {

	static tests.data.Response respond = null;

	@Parameters("endpoint")
	@BeforeClass()
	public void initilaizeResponse(String parameter)
	{
		String url = initializeEndpoint(parameter);
		Response response = io.restassured.RestAssured.given().when().get(url);
		JsonPath json = response.jsonPath();

		respond = new tests.data.Response(json.getBoolean("success"), json.getString("sfVersion"),
				json.getString("host"), json.getString("version"), json.getString("saEndpoint"), json.getBoolean("newPackage"));
	}


	@Test(dataProvider = "allValidEndpoints", dataProviderClass = DataProviders.class)
	public void ValidateTheSameValuesInAllEndpoints(String endpoint) throws Exception
	{
		String url = initializeEndpoint(endpoint);

		Response response = io.restassured.RestAssured.given().when().get(url);
		JsonPath json = response.jsonPath();
		
		if(json.getBoolean("success")!=respond.isSuccess()||
				!json.getString("sfVersion").equals(respond.getSfVersion())||
				!json.getString("version").equals(respond.getVersion())||
				!json.getString("saEndpoint").equals(respond.getSaEndpoint())||
				json.getBoolean("newPackage")!=respond.isNewPackage())

		{
			throw new Exception("The Endpoints gives different data");
		}

	}

}
