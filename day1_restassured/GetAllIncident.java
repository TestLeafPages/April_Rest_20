package day1_restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncident {

	public static void main(String[] args) {
		// ctrl+/
//		Step1: Set Endpoint
		//Classname.varaible; F3
//		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		Step2: set authentication 
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123"); 
//		Step3: Request Type, ctrl+2 , l
		  Response response = RestAssured.get();
//		Step4: print status code
		  System.out.println(response.statusCode()); 
		// Print response type
		  System.out.println(response.contentType());

//		Step5: print response body
		  response.prettyPrint();

	}

}
