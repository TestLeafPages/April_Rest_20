package day1_restassured;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAllIncidentWithXMLResp {

	public static void main(String[] args) {
//		Step1: Set Endpoint
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123"); 
//		Step3: Request Type + Param + accept
		  Response response = RestAssured
				  .given()
				  .queryParam("category", "hardware")
				  .queryParam("sysparm_fields", "number,category,sys_id,short_description")
//				  .accept("application/xml")
				  .accept(ContentType.XML)
				  .get();
		  
		  
//		Step4: print status code
		  System.out.println(response.statusCode()); 
// 				Print response type
		  System.out.println(response.contentType());
//		Step5: print response body
		  response.prettyPrint();
		  
		  // response object into xml value
		  XmlPath xml = response.xmlPath();
		  	  
		  // get the sys_id from xml
		  String sysID = xml.get("response.result.sys_id[0]");
		  System.out.println(sysID);
		 // json.getList(path)  -> fetch list of value
		  List<String> list = xml.getList("response.result.sys_id");
		  System.out.println(list.size());
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  

	}

}
