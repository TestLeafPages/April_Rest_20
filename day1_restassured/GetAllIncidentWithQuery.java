package day1_restassured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidentWithQuery {

	public static void main(String[] args) {
//		Step1: Set Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123"); 
//		Step3: Request Type + Param
		  Response response = RestAssured
				  .given()
				  .queryParam("category", "hardware")
//				  .queryParam("sysparm_fields", "number,category,sys_id,short_description")
				  .get();
		  
		  
//		Step4: print status code
		  System.out.println(response.statusCode()); 
// 				Print response type
		  System.out.println(response.contentType());
//		Step5: print response body
		  response.prettyPrint();
		  
		  // response object into json value
		  JsonPath json = response.jsonPath();
		  // get the sys_id from json
		 // json.getList(path)  -> fetch list of value
		  //fetch first matching value
		List<String> list = json.getList("result.sys_id");
		System.out.println(list);
		
		String sysID = json.get("result.sys_id[0]");
		  System.out.println(sysID);
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  

	}

}
