package mock.services;

import org.codehaus.groovy.control.customizers.builder.PostCompletionFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class learnRecordAndPlayback {

	@Test
	public void learnStub() {
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";// serviceNow
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123"); 
		  Response response = RestAssured
				  .given()
				  .contentType(ContentType.JSON)
				  .post();
		  System.out.println(response.statusCode()); 
		  System.out.println(response.contentType());
		  response.prettyPrint();

	}

	
	
}
