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
public class Req5_Graceful_Shutdown_Tcs extends BaseURI {

	Payload pl = new Payload();
	RequestSpecification req;

	/**
	 * The software should support a graceful shutdown request. Meaning, it should
	 * allow any in-flight password hashing to complete, reject any new requests,
	 * respond with a 200 and shutdown.
	 **/

	@BeforeClass
	public void Ping_Hash_application() throws IOException {

		DOMConfigurator.configure("log4j.xml");

		getBaseURI("BaseURI");

		req = given().log().all().header("Accept", "application/json").port(8088);

	}

	/*
	 * TC_026: Ensure the application finishes the password hashing that is in
	 * process to be completed even when shut of application is initiated.
	 */

	@Test(priority = 1)
	public void Password_Hashing_Success_whileShutDown() throws IOException {

		Log.startTestCase("Password_Hashing_Success_whileShutDown()");

		Response job_Identifier = req.body(pl.getPayload()).port(8088).

				when().post("/hash").

				then().log().all().extract().response();

		String JobIdentifier_Return_OnShutdowninProgress = job_Identifier.getBody().asString();

		System.out.println(JobIdentifier_Return_OnShutdowninProgress);

		Response shutdown = req.body("shutdown").port(8088).when().post("/hash").then().log().all().extract()
				.response();

		int statusCode = shutdown.getStatusCode();

		Assert.assertTrue(statusCode == 200);

		Log.endTestCase("Password_Hashing_Success_whileShutDown()");
		System.out.println("*****************************************************************************************");

	}

	/*
	 * TC_029: Ensure any additional request to password hashing must be refused
	 * once shutdown is initiated
	 */
	@Test(priority = 2)

	public void passwordHashingDenied_when_shutdown_in_progress() throws IOException {

		Log.startTestCase("Password_Hashing_Success_whileShutDown()");

		Response currentresponse =

				req.body(pl.getPayload()).port(8088).

						when().post("/hash").

						then().log().all().extract().response();

		System.out.println(currentresponse);

		Assert.assertTrue(currentresponse.getBody().asString().contains("Connection refused"));

		System.out.println("*****************************************************************************************");

		Log.endTestCase("Password_Hashing_Success_whileShutDown()");
		System.out.println("*****************************************************************************************");
	}

}
