package basic;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CreateIncidentWithoutBodyAndAssertBody {

	public static void main(String[] args) {
//		Step1: Set Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		Step2: set authentication 
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123"); 
//		Step3: Request Type, - Post 
		Response response = RestAssured
				  .given()
				  .contentType(ContentType.JSON)
				  .body("{\"short_description\": \"create incident with body json1\",\"category\": \"hardware\"}")
				  .post()
				  .then()
//				  .body("result.short_description", Matchers.equalTo("create incident with body json"))
				  .body("result.short_description", Matchers.containsString("create incident"))
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
