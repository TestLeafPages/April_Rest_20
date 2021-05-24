package mock.services;

import org.codehaus.groovy.control.customizers.builder.PostCompletionFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnStub {
/*	//1.
	@BeforeMethod
	public void sampleStub() {
		stubFor(post("/api/now/table/incident")
				.willReturn(aResponse()
				.withStatus(201)
				.withBody("{ 'name': 'Sarath', 'Company': 'TestLeaf'}")
				.withHeader("content-type","application/json")));
	}
	*/
//2.
	@Test
	public void learnStub() {
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";// serviceNow
//		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123"); 
		  Response response = RestAssured
				  .given()
				  .contentType(ContentType.JSON)
				  .post();
		  System.out.println(response.statusCode()); 
		  System.out.println(response.contentType());
		  response.prettyPrint();

	}

	
	
}
