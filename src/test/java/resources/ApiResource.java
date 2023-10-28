package resources;

//enum is a special class in Java which has collection of constants or methods
public enum ApiResource {
	
	RegisterAPI("register"),
	GetUser("users/2"),
	UpdateAPI("users/2");
	private String resource;
	
	 ApiResource(String resource) {
		this.resource = resource;
	}
	public String getResource() {
		return resource;
	}

}
