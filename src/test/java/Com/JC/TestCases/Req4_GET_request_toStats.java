/**
 * 
 */
package Com.JC.TestCases;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Com.JC.ResourceFiles.BaseURI;
import Utilities.Log;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author jayashreehemmige
 *
 */
public class Req4_GET_request_toStats extends BaseURI{
	
	RequestSpecification req;
	
	
	@BeforeClass
	public void Ping_Hash_application() throws IOException {

		DOMConfigurator.configure("log4j.xml");

		getBaseURI("BaseURI");

		req = given().log().all().header("Accept", "application/json").port(8088);

	}
	
	
	
	/*
	 * This method is for GET request to /stats endpoint which returns the total
	 * requests sent and average time taken to receive response
	 */

	@Test
	public void getStats() throws IOException {

		Log.startTestCase("getStats()");

		Response responsetats = req.when().get("/stats").then().log().all().extract().response();

		String responseString = responsetats.getBody().asString();

		System.out.println("this is the total requests" + responseString);

		JsonPath jp = new JsonPath(responseString);

		String Totalrequests = jp.get("TotalRequests").toString();

		System.out.println(Totalrequests);

		Log.info("RETURNED TOTAL REQUESTS + AVERAGE TIME");

		Log.endTestCase("getStats()");

		System.out.println("*****************************************************************************************");
	}
	

}
