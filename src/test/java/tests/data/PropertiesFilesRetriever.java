package tests.data;

import java.io.IOException;
import java.util.Properties;

public class PropertiesFilesRetriever {

	private final static String endpoints =  "config.properties.endpoints";
	private static Properties endpointsProps = null;
	
	
	public static Properties getEndpointProperties() throws IOException {
		
		if(endpointsProps == null)
		{
			endpointsProps = new Properties();
			endpointsProps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(endpoints));
		}
		
		return endpointsProps;
	}


	}

