package basic;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIncident {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		Step2: set authentication 
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123"); 
//		Step3: Request Type, ctrl+2 , l
		  Response response = RestAssured
				  .given()
				  .pathParam("sysID", "f2ed4ba02f003010a99d857cf699b6cc")
				  .delete("{sysID}");
//		Step4: print status code
		  System.out.println(response.statusCode()); 
		// Print response type
		  System.out.println(response.contentType());

//		Step5: print response body
		  response.prettyPrint();

	}

}
