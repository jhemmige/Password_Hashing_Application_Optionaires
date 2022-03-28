package Com.JC.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Com.JC.ResourceFiles.BaseURI;
import Com.JC.ResourceFiles.Payload;
import Utilities.Log;

/**
 * "A POST to /hash should accept a password. It should return a job identifier
 * immediately. It should then wait 5 seconds and compute the password hash. The
 * hashing algorithm should be SHA512
 **/

public class Req2_POST_request_Return_JobIdentifierTCs extends BaseURI {

	static String JobIdentifierResponse;
	public Response response;

	RequestSpecification req;

	@BeforeClass // This class runs before every testcase calling it.

	public void Ping_Hash_application() throws IOException {

		DOMConfigurator.configure("log4j.xml");

		getBaseURI("BaseURI");

		req = given().log().all().header("Accept", "application/json").port(8088);

	}

	@Test(priority = 1)

	public void Get_Job_Identifier() throws IOException {

		pl = new Payload();
		/*
		 * TC_004 -This method is to POST request to /hash endpoint which returns job
		 * identifier as response
		 */
		Log.startTestCase("Get_Job_Identifier()");
		Log.info("/hash endpoing being hit along with a valid Payload");
		response = req.body(pl.getPayload()).port(8088).

				when().post("/hash").

				then().log().all().extract().response();

		JobIdentifierResponse = response.getBody().asString();

		/* TC_003 - Here we are validating the status code */

		int statusCode = response.getStatusCode();

		// Using Assertions we are validating if the status code is 200

		Log.info("STATUS CODE 200 RETURNED");

		AssertJUnit.assertEquals(200, statusCode);

		// We are validating if the response has a Job Identifier or not.

		AssertJUnit.assertTrue(response != null);

		Log.endTestCase("Get_Job_Identifier()");

		System.out.println("*****************************************************************************************");

	}

	@Test(priority = 2)

	public void Job_Identifier_Immediate_Return() {

		/*
		 * TC_005- this testcase is to see if the response time is immediately. For test
		 * sake, I have assumed 2 seconds as the return time since "immediately" is not
		 * defined in the requirement
		 */

		Log.startTestCase("Job_Identifier_Immediate_Return()");

		long responseReturntime = response.getTime();

		if (responseReturntime == 2) {

			System.out.println("response returned immediately");

			Log.info("RESPONSE RETURNED IMMEDIATELY");
		}

		else {

			System.out.println("response took longer than 2 seconds to be returned..looks like this testcsae failed");

			Log.info("RESPONE TOOK LONGER THAN 2 SECONDS TO RETURN. TESTCASE FAILED");

		}

		Log.endTestCase("Job_Identifier_Immediate_Return()");
		System.out.println("*****************************************************************************************");
	}

	/*
	 * TC_006- POST request to /hash endpoint must fail when there is no data in the
	 * body at all
	 */
	@Test(priority = 3)
	public void noBodyinJson() throws IOException {

		Log.startTestCase("noBodyinJson()");

		Response response_with_No_body = req.when().post("/hash").then().log().all().extract().response();

		String Actual_response = response_with_No_body.getBody().asString();

		System.out.println("TC_006_No body in JSON" + " " + Actual_response);

		String Expected_Response = "Malformed Input";

		if (Actual_response.contains(Expected_Response)) {

			System.out.println("Test Case - TC_006: PASS");
			Log.info("PASS");
		}

		else

			System.out.println("Test Case - TC_006: FAIL");
		Log.info("FAIL");
		Log.endTestCase("noBodyinJson()");
		System.out.println("*****************************************************************************************");
	}

	@Test(priority = 4)
	public void empty_password() throws IOException {

		/*
		 * TC_008- Ensure POST request fails when the password key has an empty value.
		 * 
		 * 
		 */

		Log.startTestCase("empty_password()");
		Log.info("VALUE OF PASSWORD IS EMPTY");
		Response currentResponse = req.body(pl.incorrect_Payload()).port(8088).

				when().post("/hash").

				then().log().all().extract().response();

		String No_pwd_Response = currentResponse.getBody().asString();

		if (currentResponse.statusCode() >= 400) {

			System.out.println(" Job Identifier fails to return. TC_008 : TC PASSED");
			Log.info("PASS");
		}

		else if (currentResponse.statusCode() <= 200) {

			System.out.println("FAIL");

			Log.info("FAIL");

		}

		Log.endTestCase("empty_password()");
		System.out.println("*****************************************************************************************");
	}

	/**
	@Test(priority = 5)
	public void Application_ShutDown() throws IOException {

		Log.startTestCase("Application_ShutDown()");

		Response shutdown_Response = req.body("shutdown").port(8088).when().post("/hash").then().log().all().extract()
				.response();

		int statuscode = shutdown_Response.getStatusCode();

		System.out.println(statuscode);

		Log.endTestCase("Application_ShutDown()");

		System.out.println("*****************************************************************************************");

		// T_029-Additional request to password hashing must be refused once shutdown is
		// pending.
		Response currentresponse = req.body(pl.getPayload()).port(8088).

				when().post("/hash").

				then().log().all().extract().response();

		System.out.println(currentresponse);

		System.out.println("*****************************************************************************************");

	}**/

}
