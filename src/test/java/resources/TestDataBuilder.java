package resources;

import pojo.GetUsers;
import pojo.RegisterUserPayload;

public class TestDataBuilder {
	
	public RegisterUserPayload RegisterUserPayloadBuilder() {
		RegisterUserPayload rsUp = new RegisterUserPayload();
		rsUp.setEmail("eve.holt@reqres.in");
		rsUp.setPassword("pistol");
		return rsUp;
	}
	public GetUsers userpayload(String name,String job) {
	GetUsers gu = new GetUsers();
	gu.setName(name);
	gu.setJob(job);
	return gu;
	}

}
