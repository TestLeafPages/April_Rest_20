package params;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class RequestParams {

	// Step 2: Received the data provider -> data as argument
	@Test
	public void requestParams() {

		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";

		// Step 2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");


		Map<String, String> headers = new HashMap<String, String>();
		headers.put("content-type", "application/json");
		headers.put("accept", "application/xml");
		
		// Step 3: Request type -> query param / form param -> request param (Get/ Post & etc)
		Response response = RestAssured
				.given()
				.headers(headers)
//				.header("content-type",ContentType.JSON)
//				.header("accept",ContentType.XML)
//				.param("sysparm_fields", "number,sys_id")
				.post();

		// Step 4: Validate (Response -> Status Code : 200)
		System.out.println(response.getStatusCode());

		// Print the response time as well
		System.out.println(response.getTime());

		// Check what is the response format
		System.out.println(response.getContentType());

		// print the response
		response.prettyPrint();

		// Need to parse JSON
		XmlPath jsonResponse = response.xmlPath();

		// Get the incident.numbers
		String listOfNumbers = jsonResponse.get("response.result.number");

		// How to count of numbers?
		System.out.println(listOfNumbers);




	}


}
