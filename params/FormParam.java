package params;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FormParam {
	
	@Test
	public void loginLeaftaps() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "http://leaftaps.com/opentaps/control/login";
		// Step 2: Request type - Post + form param / Body
		
		Map<String, String> allParams = new HashMap<String, String>();
		allParams.put("USERNAME", "DemoSalesmanager");
		allParams.put("PASSWORD", "crmsfa");
		
		Response post = RestAssured
			.given()
//			.contentType(ContentType.JSON)
			.when()
			.formParams(allParams)
			/*.formParam("USERNAME", "DemoSalesmanager")
			.formParam("PASSWORD", "crmsfa")*/
			.post();
			
		post.prettyPrint();
		
	}
	

}
