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
import Com.JC.ResourceFiles.Payload;
import Utilities.Log;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

/**
 * @author jayashreehemmige
 *
 */
public class Req3_GET_request_Base64EncodedTCs extends BaseURI {

	Payload pl = new Payload();
	static String jobID;
	RequestSpecification req;
	Response JobID_as_response;

	@BeforeClass
	public void Ping_Hash_application() throws IOException {

		DOMConfigurator.configure("log4j.xml");

		getBaseURI("BaseURI");

		req = given().log().all().header("Accept", "application/json").port(8088);

		JobID_as_response = req.body(pl.getPayload()).port(8088).when().post("/hash").then().log().all().extract()
				.response();

		jobID = JobID_as_response.getBody().asString();

		System.out.println("this is jobID=" + jobID);

	}

	/*
	 * TC_011 : This method is to Get request to /hash endpoint along with the job
	 * identifier to receive Base64 encoded password
	 */
	@Test(priority = 1)

	public void Get_Base64_Password() throws IOException {

		Log.startTestCase("Get_Base64_Password()");

		Response Newresponse = req.when().get("/hash" + "/" + jobID).then().log().all().extract().response();

		String BaseEncondedpassword = Newresponse.asString();

		System.out.println("This is the" + " " + BaseEncondedpassword);

		Log.info("BASE64 ENCODED PASSWORD RETURNED SUCCESSFULLY");

		Log.endTestCase("Get_Base64_Password()");

		System.out.println("*****************************************************************************************");
	}

	/*
	 * TC_015 : Ensure GET request Fails when no job Identifier is passed to the
	 * /hash endpoint
	 */

	@SuppressWarnings("deprecation")
	@Test(priority = 2)

	public void Get_request_fail_withNo_job_iD() {

		Log.startTestCase("void Get_request_fail_withNo_job_iD(");

		Response response_with_No_job_Id = req.when().get("/hash").then().log().all().extract().response();

		String currentresponse = response_with_No_job_Id.getBody().asString();

		int statusCode = response_with_No_job_Id.getStatusCode();

		Log.info("GET NOT SUPPORTED");

		Assert.assertTrue(statusCode >= 400);

		Log.endTestCase("void Get_request_fail_withNo_job_iD(");

		System.out.println("*****************************************************************************************");

	}

	/*
	 * TC_016- Ensure GET request Fails when a non-existent Job Identifier is passed
	 * to the /hash endpoint
	 */

	@Test(priority = 3)

	public void Get_request_fail_with_non_existent_JID() {

		Response non_existent_JID = req.when().get("/hash" + "/" + "100").then().log().all().extract().response();

		non_existent_JID.getStatusCode();

		Assert.assertTrue(non_existent_JID.statusLine().contains("Bad Request"));

	}

}
