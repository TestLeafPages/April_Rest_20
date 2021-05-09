package steps;

import java.io.File;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IncidentManagement {

	private static RequestSpecification requestSpecification;
	private static Response response;
	
	@Given("set the Endpoint")
	public void setEndPoint() {
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
	}
	
	@And("set the Authorization")
	public void setAuthorization() {
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
	}
	
	@And("set the content type as json")
	public void setContentType() {
		requestSpecification = RestAssured
		  .given()
		  .contentType(ContentType.JSON);
	}
	
	
	@When("send the request as post with file (.*)$")
	public void sendPostRequest(String file) {
		response = requestSpecification
		.body(new File("./data/"+file))
		.post();
	}
	
	@And("confirm the response status code is {int}")
	public void verifyStatusCode(int statusCode) {
		response.then()
		.assertThat()
		.statusCode(statusCode);
	}
	
	@And("confirm the response type is json")
	public void verifyContentType() {
		response.then()
		.assertThat()
		.contentType(ContentType.JSON);
	}
	
	
	
	
	
	
	
	
	
	
}


