package tests.data;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "allValidEndpoints")
	public static Object[][] getValidEndpoints() throws IOException {
		
		String endpointsArrayString = PropertiesFilesRetriever.getEndpointProperties().getProperty("endpoints");
		
		String[] endpointsArray = endpointsArrayString.split(",");
		
		int endpointsNumber = endpointsArray.length; 

		Object[][] endpointsData = new Object[endpointsNumber][1];
		
		for (int index = 0; index < endpointsNumber; index++) {
			endpointsData[index][0] = endpointsArray[index];
		}
		
		return endpointsData;
	}
	
	
	@DataProvider(name = "unvalidEndpoints")
	public static Object[][] getUnvalidEndpoints() throws IOException {
		
		String endpointsArrayString = PropertiesFilesRetriever.getEndpointProperties().getProperty("endpointsNotExist");
		
		String[] endpointsArray = endpointsArrayString.split(",");
		
		int endpointsNumber = endpointsArray.length; 

		Object[][] endpointsData = new Object[endpointsNumber][1];
		
		for (int index = 0; index < endpointsNumber; index++) {
			endpointsData[index][0] = endpointsArray[index];
		}
		
		return endpointsData;
	}


}
