package utils;

public enum EndpointsServer {

	EU1("eu1"),
	US1("us1"),
	BR1("br1");

	private final String endpoint;

	EndpointsServer(String endpoint)
	{
		this.endpoint = endpoint;
	}
	
	public String getEndpoint() {
		return this.endpoint;
	}

}
