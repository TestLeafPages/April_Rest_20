package params;

import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncident {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		Step2: set authentication 
//		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123"); 
//		Step3: Request Type, ctrl+2 , l
		  Response response = RestAssured
				  .given()
				  .cookie("JSESSIONID","C17FD040E3CB18007EF579E81CE3E7F5")
				  .queryParam("category", "software")
				  .get()
				 ;
//		Step4: print status code
		  System.out.println(response.statusCode()); 
		// Print response type
		  System.out.println(response.contentType());

//		Step5: print response body
		  response.prettyPrint();
		  
		  
		  
		 /* Map<String, String> cookies = response.getCookies();  
		  
		  for( Entry<String, String> eachCookie : cookies.entrySet()) {
			  System.out.println(eachCookie.getKey()+" --------------------> "+eachCookie.getValue());
		  }*/
		  
		  
		  
		  
		  

	}

}
