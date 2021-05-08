package basic;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIssue {

	public static void main(String[] args) {
//		Step1: Set Endpoint
		//Classname.varaible;
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/search";
//		Step2: set authentication 
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "1tFDjllY3jwISCost2cZ8C09");
//		Step3: Request Type, ctrl+2 , l
		  Response response = RestAssured.get();
//		Step4: print status code
		  System.out.println(response.statusCode());  

//		Step5: print response body
		  response.prettyPrint();

	}

}
