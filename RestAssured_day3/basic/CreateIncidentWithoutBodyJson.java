package basic;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class CreateIncidentWithoutBodyJson {

	@Test
	public void ci() {
//		Step1: Set Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		Step2: set authentication 
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123"); 
//		Step3: Request Type, - Post +
		 
		Response response = RestAssured
				  .given()
				  .contentType(ContentType.JSON)
				  .post()
				  .then()
				  .assertThat()
				  .body(matchesJsonSchema(new File("./incident.json")))
				  .extract().response()
				  ;
//		Step4: print status code
		  System.out.println(response.statusCode()); 
		// Print response type
		  System.out.println(response.contentType());
//		Step5: print response body
		  response.prettyPrint();

	}

}
