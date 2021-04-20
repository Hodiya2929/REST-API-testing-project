package com.whatslly.rest.api.testing_project;

public class AbstractTest {
	
	private String basicUrl = "https://api-.whatslly.com/test/ping.json";

	public String getBasicUrl() {
		return basicUrl;
	}
	
	public String initializeEndpoint(String endpoint)
	{
		int index = basicUrl.indexOf("api-");
		int indexToInsertEndpoint = index + endpoint.length();
		
	    StringBuffer resString = new StringBuffer(basicUrl);
	    resString.insert(indexToInsertEndpoint + 1, endpoint);
	    
	    return resString.toString();
	}
	
	
	

}
