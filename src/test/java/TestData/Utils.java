package TestData;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	ResponseSpecification req;
	public RequestSpecification requestSpecification()
	{
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Content-Type","application/json").
				addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		return req;
	}

}
