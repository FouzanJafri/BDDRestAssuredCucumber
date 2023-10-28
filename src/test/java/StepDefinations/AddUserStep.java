package StepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import pojo.RegisterUserPayload;
import pojo.RegisterUserResponce;
import pojo.User;
import resources.ApiResource;
import resources.TestDataBuilder;
import resources.Utils;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.fasterxml.jackson.core.TSFBuilder;

import groovyjarjarpicocli.CommandLine.Spec;

public class AddUserStep extends Utils {
	
	RequestSpecification res;
	RegisterUserResponce resp;
	TestDataBuilder ts = new TestDataBuilder();
	Response response;
	
	@Given("{string} User Payload")
	public void user_payload(String string) throws IOException {
		
		res = given()
				.spec(requestSpecification())
				.body(ts.RegisterUserPayloadBuilder());

	}
			
		
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
	    
		ApiResource resourceApi = ApiResource.valueOf(resource);
	    System.out.println(resourceApi.getResource());
		
	    if(method.equalsIgnoreCase("POST")){
	    	 response = res.when().post(resourceApi.getResource());
	    	 	resp = response.as(RegisterUserResponce.class);
	    		
	    }else if (method.equalsIgnoreCase("GET")) {
			response = res.when().get(resourceApi.getResource());
			String resStr = response.asString();
			JsonPath jso = new JsonPath(resStr);
			System.out.println(jso.get("data.email"));
			assertEquals(jso.get("data.email"), "janet.weaver@reqres.in");

	    }
		    
	   
	    	
	    
	}

	@Then("the api call should be sucess with status code {string}")
	public void the_api_call_should_be_sucess_with_status_code(String string) {
		assertEquals(response.getStatusCode(), 200);	
		
	}

	@Then("status code should be {string}")
	public void status_code_should_be(String string) {
//		assertEquals(response.getStatusCode(),string);
		}
	@Then("user should view with id Post http request")
	public void user_should_view_with_id_post_http_request() {
	    int Id = resp.getId();
	    System.out.println(Id);
	    System.out.println(basePath);
	    System.out.println(baseURI);
	    User resp = given().spec(res).when().get("users/{Id}",Id).then().log().all().extract().response().as(User.class);
	    
	    System.out.println(resp.getData().getId());
	    System.out.println(resp.getData().getFirst_name());
	    
	}

	@Then("get Users {string} and {string}")
	public void get_users_and(String string, String string2) throws IOException {
		response = given()
				.spec(requestSpecification()).body(ts.userpayload(string, string2))
				.when().post("users").then().log().all().extract().response();
			String respSt = response.asString();
			JsonPath jso = new JsonPath(respSt);
			System.out.println(jso.get("name"));
	}

}
