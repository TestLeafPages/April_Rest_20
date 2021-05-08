package basic;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CreateIncidentWithoutBodyAndAssert {

	public static void main(String[] args) {
//		Step1: Set Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		Step2: set authentication 
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123"); 
//		Step3: Request Type, - Post 
		Response response = RestAssured
				  .given()
				  .contentType(ContentType.JSON)
				  .post()
				  .then()
				  .assertThat()
				  .statusCode(201)
				  .contentType(ContentType.JSON)
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
