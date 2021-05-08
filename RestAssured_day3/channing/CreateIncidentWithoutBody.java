package channing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithoutBody extends Base{

	@Test
	public void ci() {
//		Step1: Set Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		Step2: set authentication 
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123"); 
//		RestAssured.authentication =  RestAssured.oauth2("SXE6UHIWSqc1dhkqHfnW3Zkziumc9fRddeiOQ4BIsz6uboTAKxS-yBBhH1qUTtKK1ZwD-Ghu4kz0IKlzLk3hRw");
//		Step3: Request Type, - Post +
		  Response response = RestAssured
				  .given()
				  .contentType(ContentType.JSON)
				  .post();
//		Step4: print status code
		  System.out.println(response.statusCode()); 
		// Print response type
		  System.out.println(response.contentType());
//		Step5: print response body
		  response.prettyPrint();
		  
		  JsonPath jsonPath = response.jsonPath();
		  id = jsonPath.get("result.sys_id");
		  

	}

}
