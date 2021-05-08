package channing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateIncident extends Base{
	//Path of the @Test Method -> packageName.className.MethodNmae
	@Test(dependsOnMethods = {"channing.CreateIncidentWithoutBody.ci"})
	public void ui() {
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		Step2: set authentication 
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123"); 
//		Step3: Request Type
		  Response response = RestAssured
				  .given()
				  .log().all()
				  .pathParam("sysID", id)
				  .contentType(ContentType.JSON)
				  .body("{\"short_description\": \"create incident with body as String\",\"category\": \"hardware\"}")
				  .put("{sysID}");
//		Step4: print status code
		  System.out.println(response.statusCode()); 
		// Print response type
		  System.out.println(response.contentType());

//		Step5: print response body
		  response.prettyPrint();

	}

}
