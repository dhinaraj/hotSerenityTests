package Plus65.steps.serenity;

import net.thucydides.core.annotations.Step;

import org.apache.http.HttpStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.jayway.restassured.RestAssured;

import net.serenitybdd.*;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.AssertTrue;

/**
 * Created by Dhinakaran on 22/12/16.
 */

public class PartimerDailyTestJobAPISteps {
	
	  private String partTimerEmail = "";
	  private String partimerPassword = "123qwe";
	  private String baseURI = "https://staging-api.arrowmepro.com";
	 
	 
	
	
	  private String partimerEmailForServiceLine1[] = new String[] { "dailytestjob+service1+pt1@gmail.com",
				"dailytestjob+service1+pt2@gmail.com", "dailytestjob+service1+pt3@gmail.com", "dailytestjob+service1+pt4@gmail.com",
				"dailytestjob+service1+pt5@gmail.com", "dailytestjob+service1+pt6@gmail.com", "dailytestjob+service1+pt7@gmail.com",
				"dailytestjob+service1+pt8@gmail.com", "dailytestjob+service1+pt9@gmail.com", "dailytestjob+service1+pt10@gmail.com",
				"dailytestjob+service1+pt11@gmail.com", "dailytestjob+service1+pt12@gmail.com", "dailytestjob+service1+pt13@gmail.com",
				"dailytestjob+service1+pt14@gmail.com", "dailytestjob+service1+pt15@gmail.com", "dailytestjob+service1+pt16@gmail.com",
				"dailytestjob+service1+pt17@gmail.com", "dailytestjob+service1+pt18@gmail.com", "dailytestjob+service1+pt19@gmail.com",
				"dailytestjob+service1+pt20@gmail.com", "dailytestjob+service1+pt21@gmail.com", "dailytestjob+service1+pt22@gmail.com",
				"dailytestjob+service1+pt23@gmail.com", "dailytestjob+service1+pt24@gmail.com", "dailytestjob+service1+pt25@gmail.com",
				"dailytestjob+service1+pt26@gmail.com", "dailytestjob+service1+pt27@gmail.com", "dailytestjob+service1+pt28@gmail.com",
				"dailytestjob+service1+pt29@gmail.com", "dailytestjob+service1+pt30@gmail.com", "dailytestjob+service1+pt31@gmail.com",
				"dailytestjob+service1+pt32@gmail.com", "dailytestjob+service1+pt33@gmail.com", "dailytestjob+service1+pt34@gmail.com",
				"dailytestjob+service1+pt35@gmail.com", "dailytestjob+service1+pt36@gmail.com", "dailytestjob+service1+pt37@gmail.com",
				"dailytestjob+service1+pt38@gmail.com", "dailytestjob+service1+pt39@gmail.com", "dailytestjob+service1+pt40@gmail.com",
				"dailytestjob+service1+pt41@gmail.com", "dailytestjob+service1+pt42@gmail.com", "dailytestjob+service1+pt43@gmail.com",
				"dailytestjob+service1+pt44@gmail.com", "dailytestjob+service1+pt45@gmail.com", "dailytestjob+service1+pt46@gmail.com",
				"dailytestjob+service1+pt47@gmail.com", "dailytestjob+service1+pt48@gmail.com", "dailytestjob+service1+pt49@gmail.com",
				"dailytestjob+service1+pt50@gmail.com", "dailytestjob+service1+pt51@gmail.com", "dailytestjob+service1+pt52@gmail.com",
				"dailytestjob+service1+pt53@gmail.com", "dailytestjob+service1+pt54@gmail.com", "dailytestjob+service1+pt55@gmail.com",
				"dailytestjob+service1+pt56@gmail.com", "dailytestjob+service1+pt57@gmail.com", "dailytestjob+service1+pt58@gmail.com",
				"dailytestjob+service1+pt59@gmail.com", "dailytestjob+service1+pt60@gmail.com" };
	  
	  private String partimerEmailForServiceLine2[] = new String[] { "dailytestjob+service2+pt1@gmail.com",
				"dailytestjob+service2+pt2@gmail.com", "dailytestjob+service2+pt3@gmail.com", "dailytestjob+service2+pt4@gmail.com",
				"dailytestjob+service2+pt5@gmail.com", "dailytestjob+service2+pt6@gmail.com", "dailytestjob+service2+pt7@gmail.com",
				"dailytestjob+service2+pt8@gmail.com", "dailytestjob+service2+pt9@gmail.com", "dailytestjob+service2+pt10@gmail.com",
				"dailytestjob+service2+pt11@gmail.com", "dailytestjob+service2+pt12@gmail.com", "dailytestjob+service2+pt13@gmail.com",
				"dailytestjob+service2+pt14@gmail.com", "dailytestjob+service2+pt15@gmail.com", "dailytestjob+service2+pt16@gmail.com",
				"dailytestjob+service2+pt17@gmail.com", "dailytestjob+service2+pt18@gmail.com", "dailytestjob+service2+pt19@gmail.com",
				"dailytestjob+service2+pt20@gmail.com", "dailytestjob+service2+pt21@gmail.com", "dailytestjob+service2+pt22@gmail.com",
				"dailytestjob+service2+pt23@gmail.com", "dailytestjob+service2+pt24@gmail.com", "dailytestjob+service2+pt25@gmail.com",
				"dailytestjob+service2+pt26@gmail.com", "dailytestjob+service2+pt27@gmail.com", "dailytestjob+service2+pt28@gmail.com",
				"dailytestjob+service2+pt29@gmail.com", "dailytestjob+service2+pt30@gmail.com", "dailytestjob+service2+pt31@gmail.com",
				"dailytestjob+service2+pt32@gmail.com", "dailytestjob+service2+pt33@gmail.com", "dailytestjob+service2+pt34@gmail.com",
				"dailytestjob+service2+pt35@gmail.com", "dailytestjob+service2+pt36@gmail.com", "dailytestjob+service2+pt37@gmail.com",
				"dailytestjob+service2+pt38@gmail.com", "dailytestjob+service2+pt39@gmail.com", "dailytestjob+service2+pt40@gmail.com",
				"dailytestjob+service2+pt41@gmail.com", "dailytestjob+service2+pt42@gmail.com", "dailytestjob+service2+pt43@gmail.com",
				"dailytestjob+service2+pt44@gmail.com", "dailytestjob+service2+pt45@gmail.com", "dailytestjob+service2+pt46@gmail.com",
				"dailytestjob+service2+pt47@gmail.com", "dailytestjob+service2+pt48@gmail.com", "dailytestjob+service2+pt49@gmail.com",
				"dailytestjob+service2+pt50@gmail.com", "dailytestjob+service2+pt51@gmail.com", "dailytestjob+service2+pt52@gmail.com",
				"dailytestjob+service2+pt53@gmail.com", "dailytestjob+service2+pt54@gmail.com", "dailytestjob+service2+pt55@gmail.com",
				"dailytestjob+service2+pt56@gmail.com", "dailytestjob+service2+pt57@gmail.com", "dailytestjob+service2+pt58@gmail.com",
				"dailytestjob+service2+pt59@gmail.com", "dailytestjob+service2+pt60@gmail.com" };


	  
	@Step
	public void applyJobs(int numberOfPartimersToApply, String serviceLine, String jobId) {
		
		System.out.println("Applying Jobs.......");

		 for (int i = 50; i <= (50+numberOfPartimersToApply - 1); i++) {

			 try {
				getPartimer(i, serviceLine);

				String bearerCodeRequestBody = "{\"grant_type\":\"password\", \"client_id\":\"1\",\"client_secret\":\"WUxNdGi5ptoNVtQ8u3HtT4JoU4wTeK1qX6ZN8uCq\",\"username\":\""
						+ partTimerEmail + "\",\"password\":\"" + partimerPassword + "\"}";

				/*System.out.println(
						"Beginning to Apply job for Partimer number: " + (i + 1) + " Part Timer Email: " + partTimerEmail);*/

				String bearerCode = SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
						.body(bearerCodeRequestBody).baseUri(baseURI).basePath("/oauth/token").when().post()
						.then().extract().jsonPath().get("access_token");

				SerenityRest.given().relaxedHTTPSValidation().contentType("application/json").accept("application/json")
						.header("Authorization", "Bearer " + bearerCode).baseUri(baseURI)
						.basePath("/ptt/v1/job/all/" + jobId + "/apply").when().post().then().assertThat()
						.statusCode(HttpStatus.SC_OK);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Error when Applying jobs for Part Timer: "+partTimerEmail );
				e.printStackTrace();
			}
		}
		
	}
	
	
	@Step
	public void acceptJobOffer(int numberOfPartimersToAccept, String serviceLine, String jobId) {
		
		System.out.println("Accepting Jobs.......");
		
		for (int i = 0; i <= numberOfPartimersToAccept - 1; i++) {

			try {
				getPartimer(i, serviceLine);
				
				/*System.out.println(
						"Beginning to Accept job for Partimer number: " + (i + 1) + " Part Timer Email: " + partTimerEmail);*/

				String bearerCodeRequestBody = "{\"grant_type\":\"password\", \"client_id\":\"1\",\"client_secret\":\"WUxNdGi5ptoNVtQ8u3HtT4JoU4wTeK1qX6ZN8uCq\",\"username\":\""
						+ partTimerEmail + "\",\"password\":\"" + partimerPassword + "\"}";

				String bearerCode = SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
						.body(bearerCodeRequestBody).baseUri(baseURI).basePath("/oauth/token").when().post()
						.then().extract().jsonPath().get("access_token");

				SerenityRest.given().relaxedHTTPSValidation().contentType("application/json").accept("application/json")
						.header("Authorization", "Bearer " + bearerCode).baseUri(baseURI)
						.basePath("/ptt/v1/job/match/" + jobId + "/accept").when().post().then().assertThat()
						.statusCode(HttpStatus.SC_OK);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Error when Accepting jobs for Part Timer: "+partTimerEmail );
				e.printStackTrace();
			}

		}

	}
	
	
	@Step
	public void declineJob(int numberOfPartimersToDecline, String serviceLine, String jobId) {
		
		System.out.println("Declining Jobs.....");
		
		for (int i = 40; i <= (40+numberOfPartimersToDecline - 1); i++) {

			try {
				getPartimer(i, serviceLine);
				
				/*System.out.println(
						"Beginning to Decline job for Partimer number: " + (i + 1) + " Part Timer Email: " + partTimerEmail);*/

				String bearerCodeRequestBody = "{\"grant_type\":\"password\", \"client_id\":\"1\",\"client_secret\":\"WUxNdGi5ptoNVtQ8u3HtT4JoU4wTeK1qX6ZN8uCq\",\"username\":\""
						+ partTimerEmail + "\",\"password\":\"" + partimerPassword + "\"}";

				String bearerCode = SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
						.body(bearerCodeRequestBody).baseUri(baseURI).basePath("/oauth/token").when().post()
						.then().extract().jsonPath().get("access_token");

				SerenityRest.given().relaxedHTTPSValidation().contentType("application/json").accept("application/json")
						.header("Authorization", "Bearer " + bearerCode).baseUri(baseURI)
						.basePath("/ptt/v1/job/match/" + jobId + "/decline").when().post().then().assertThat()
						.statusCode(HttpStatus.SC_OK);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Error when Declining jobs for Part Timer: "+partTimerEmail );
				e.printStackTrace();
			}

		}

	}
	
	
	@Step
	public void withDrawJobApplication(int numberOfPartimersToWithDraw, String serviceLine, String jobId) {
		
		System.out.println("Withdrawing Jobs.....");
		

			for (int i = 0; i <= (numberOfPartimersToWithDraw - 1); i++) {

				try {
					getPartimer(i, serviceLine);
					/*System.out.println(
							"Beginning to WithDraw job for Partimer number: " + (i + 1) + " Part Timer Email: " + partTimerEmail);*/

					String bearerCodeRequestBody = "{\"grant_type\":\"password\", \"client_id\":\"1\",\"client_secret\":\"WUxNdGi5ptoNVtQ8u3HtT4JoU4wTeK1qX6ZN8uCq\",\"username\":\""
							+ partTimerEmail + "\",\"password\":\"" + partimerPassword + "\"}";

					String bearerCode = SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
							.body(bearerCodeRequestBody).baseUri(baseURI).basePath("/oauth/token").when().post()
							.then().extract().jsonPath().get("access_token");

					SerenityRest.given().relaxedHTTPSValidation().contentType("application/json").accept("application/json")
							.header("Authorization", "Bearer " + bearerCode).baseUri(baseURI)
							.basePath("/ptt/v1/job/" + jobId + "/withdraw").when().post().then().assertThat()
							.statusCode(HttpStatus.SC_OK);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Error when withdrawing jobs for Part Timer: "+partTimerEmail );
					e.printStackTrace();
				}

			}

			


	}
	
	public void getPartimer(int partTimerNumber, String serviceLine)
	{
		if (serviceLine.equalsIgnoreCase("Daily Job Test ServiceLine1")) {
			partTimerEmail = partimerEmailForServiceLine1[partTimerNumber];
		} else if (serviceLine.equalsIgnoreCase("Daily Job Test ServiceLine2")) {
			partTimerEmail = partimerEmailForServiceLine2[partTimerNumber];
		}
	}
	
	
	@Step
	public void DummyWithLogAll(int numberOfPartimersToApply, String serviceLine, String jobId) {

		 for (int i = 50; i <= (50+numberOfPartimersToApply - 1); i++) {

			 getPartimer(i, serviceLine);

			String bearerCodeRequestBody = "{\"grant_type\":\"password\", \"client_id\":\"1\",\"client_secret\":\"WUxNdGi5ptoNVtQ8u3HtT4JoU4wTeK1qX6ZN8uCq\",\"username\":\""
					+ partTimerEmail + "\",\"password\":\"" + partimerPassword + "\"}";

			System.out.println(
					"Beginning to Apply job for Partimer number: " + (i + 1) + " Part Timer Email: " + partTimerEmail);

			String bearerCode = SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
					.body(bearerCodeRequestBody).log().all().baseUri(baseURI).basePath("/oauth/token").when().post()
					.then().extract().jsonPath().get("access_token");

			SerenityRest.given().relaxedHTTPSValidation().contentType("application/json").accept("application/json")
					.header("Authorization", "Bearer " + bearerCode).log().all().baseUri(baseURI)
					.basePath("/ptt/v1/job/all/" + jobId + "/apply").when().post().then().log().body().assertThat()
					.statusCode(HttpStatus.SC_OK);
		}
		
	}
 


}
