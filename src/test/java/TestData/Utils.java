package TestData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException {
		if (req==null) 
		{
			PrintStream stream = new PrintStream(new FileOutputStream("log.txt"));
			RequestSpecification req = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl"))
					.addHeader("Content-Type", "application/json").addFilter(RequestLoggingFilter.logRequestTo(stream))
					.addFilter(ResponseLoggingFilter.logResponseTo(stream))
					.addQueryParam("key", "qaclick123")
					.setContentType(ContentType.JSON).build();
			return req;
		}
		return req;

	}

	public static String getGlobalValues(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\USER\\eclipse-workspace\\RestAssuredBdd\\src\\test\\java\\TestData\\globalValues.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}

}
