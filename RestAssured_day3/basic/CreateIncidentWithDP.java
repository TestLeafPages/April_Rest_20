package basic;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithDP {

	
	//Data provider -> Array
	@DataProvider(name= "incident")
	public String[][] getData() {
		//dataType[][] obj_Name = new dataType[no of dataSet(Row size)][no of file(size)]
		String[][] data = new String[2][1];
		//Row 1 -> index
		data[0][0] = "./data/Incident1.json";
		//Row 2 -> index
		data[1][0] = "./data/Incident2.json";
		
		return data;		
	}
	
	@Test(dataProvider = "incident")
	public void createIncidentWithDP(String filePath) {
//		Step1: Set Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
//		Step2: set authentication 
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123"); 

//		File file = new File("./data/Incident.json");
		
		//		Step3: Request Type, - Post +
		  Response response = RestAssured
				  .given()
				  .contentType(ContentType.JSON)
				  .body(new File(filePath))
				  .post();
//		Step4: print status code
		  System.out.println(response.statusCode()); 
		// Print response type
		  System.out.println(response.contentType());
//		Step5: print response body
		  response.prettyPrint();

	}

}
