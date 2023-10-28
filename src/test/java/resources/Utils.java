package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;
	
	
	public RequestSpecification requestSpecification() throws IOException {
		if(req==null) {
		PrintStream ps = new PrintStream(new FileOutputStream("Loggin.txt"));
		 req = new RequestSpecBuilder()
				 .addFilter(RequestLoggingFilter.logRequestTo(ps))
				.addFilter(ResponseLoggingFilter.logResponseTo(ps))
				 .setBaseUri(getGlobalProperties("baseUrl")).setContentType(ContentType.JSON).build();
		 return req;
		}
		return req;
	}
	
	public String getGlobalProperties(String key) throws IOException {
		File file  = new File("src/test/java/resources/global.properties");
		FileInputStream fileInt = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInt);
		return prop.getProperty(key);
	}

	
	
}
