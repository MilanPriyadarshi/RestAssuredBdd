package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;



import TestData.AddPlacePayload;
import TestData.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinations extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	@Given("Add place payload")
	public void add_place_payload() {
		AddPlacePayload p=new AddPlacePayload();
		
		
		resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		res=given().spec(requestSpecification()).body(p.addPlacepayload()).log().all();
	}
	@When("User calls {string} with POST http request")
	public void user_calls_with_post_http_request(String string) {
		response=res.post("/maps/api/place/add/json").then().spec(resspec).log().all().extract().response();
	}
	@Then("The API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	    assertEquals(response.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		String responseString = response.asString();
		JsonPath js = new JsonPath(responseString);
		String s = js.get(keyValue);
		assertEquals(s, expectedValue);
	    
	}
}
