package utils;

import tests.data.NoSuchEndointException;

public class TestUtil {
	
	
	public static void validateEndpointServer(String endpoint) throws NoSuchEndointException
	{
		
		boolean exist = false;
		EndpointsServer[] endpointArr = EndpointsServer.values();
		
		for (int i = 0; i < endpointArr.length; i++) {
			EndpointsServer endpointsServer = endpointArr[i];
			if(endpointsServer.getEndpoint().equals(endpoint))
			{
				exist = true;
			}
		}
		
		if(!exist)
		{
			throw new NoSuchEndointException(endpoint+ " is not a valid exnpoint");
		}
	}

}
