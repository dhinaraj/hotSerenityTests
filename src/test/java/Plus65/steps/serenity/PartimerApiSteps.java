package Plus65.steps.serenity;

import net.thucydides.core.annotations.Step;


import org.apache.http.HttpStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.jayway.restassured.RestAssured;

import net.serenitybdd.*;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.*;

import javax.validation.constraints.AssertTrue;

/**
 * Created by Dhinakaran on 20/07/2017.
 */

public class PartimerApiSteps {
	

	
	private  String baseURI = "https://staging-api.arrowmepro.com";
	  

//Step  Functions //	  
	@Step
	public  void registerUser(String newpartTimerEmail, String newPartimerPassword) {
		
		Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("first_name", "Test First Name");
        jsonAsMap.put("last_name", "Test Last Name");
        jsonAsMap.put("email", newpartTimerEmail);
        jsonAsMap.put("password", newPartimerPassword);
        jsonAsMap.put("password_confirmation", "1234qwer");
        jsonAsMap.put("referral_code", "");

		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.accept("application/json").body(jsonAsMap).baseUri(baseURI).basePath("/ptt/v1/register")
				.when().post();
	}
	
	@Step
	public void confirmUserSubscription(String confirmationCode) {
		
		Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("code", confirmationCode);

		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.accept("application/json").body(jsonAsMap).baseUri(baseURI).basePath("/ptt/v1/register/verify")
				.when().post();
	}
	

	@Step
	public void getFullAccountDetails(String newpartTimerEmail, String bearerCode) {
		 SerenityRest.
         given().relaxedHTTPSValidation().contentType("application/json").accept("application/json")
		.header("Authorization", "Bearer " + bearerCode).
		baseUri(baseURI).
		basePath("/ptt/v1/account/full").
		when().get();
	}
	
	@Step
	public void verifyFullAccountDetailsResponse(String newpartTimerEmail) {
		
     SerenityRest.then().
		assertThat().statusCode(HttpStatus.SC_OK).and().
		body("data.profile.email", equalTo(newpartTimerEmail)).
		body("data.profile.first_name", equalTo("Test First Name")).
		body("data.profile.last_name", equalTo("Test Last Name")).
		body("description", equalTo("Full account profile details request successful."));

	}
	
	
	@Step
	public void resendRegistration(String newpartTimerEmail) {
		
		Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", newpartTimerEmail);
		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.accept("application/json").body(jsonAsMap).baseUri(baseURI).basePath("/ptt/v1/register/resend")
				.when().post();

	}
	

	@Step
	public void forgotPassword(String newpartTimerEmail) {
		
		Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", newpartTimerEmail);
		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.accept("application/json").body(jsonAsMap).baseUri(baseURI).basePath("/ptt/v1/forgot-password")
				.when().post();

	}
	

	@Step
	public void forgotPasswordResend(String newpartTimerEmail) {
		
		Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("email", newpartTimerEmail);
		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.accept("application/json").body(jsonAsMap).baseUri(baseURI).basePath("/ptt/v1/forgot-password/resend")
				.when().post();

	}
	

	@Step
	public void updatePhoneNumber(String phoneNumber, String bearerCode) {
		
		Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("phone", phoneNumber);
		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.accept("application/json").header("Authorization", "Bearer " + bearerCode).body(jsonAsMap).baseUri(baseURI).basePath("/ptt/v1/account/phone/update")
				.when().post();

	}
	

	@Step
	public void verifyPhoneNumberUsingOTP(String otp, String phone, String bearerCode) {
		
		Map<String, Object> jsonAsMap = new HashMap<>();
		jsonAsMap.put("phone", phone);
        jsonAsMap.put("otp", otp);
		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.accept("application/json").header("Authorization", "Bearer " + bearerCode).body(jsonAsMap).baseUri(baseURI).basePath("/ptt/v1/account/phone/verify")
				.when().post();

	}
	

	@Step
	public void resendOtpCode(String phoneNumber, String bearerCode) {
		
		Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("phone", phoneNumber);
		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.accept("application/json").header("Authorization", "Bearer " + bearerCode).body(jsonAsMap).baseUri(baseURI).basePath("/ptt/v1/account/phone/resend")
				.when().post();

	}
	

	@Step
	public void onBoardingServices(String serviceNumbers, String bearerCode) {
		
		Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("services", serviceNumbers);
		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.accept("application/json").header("Authorization", "Bearer " + bearerCode).body(jsonAsMap).baseUri(baseURI).basePath("/ptt/v1/onboarding/services")
				.when().post();

	}
	
	
	@Step
	public void verifyOnBoardingServicesResponse(String services) {
		String[] servicesSplit = services.split(",");
     SerenityRest.then().
		assertThat().statusCode(HttpStatus.SC_OK).and().
		body("description", equalTo("New service lines have been successfully added.")).
		body("data.id[0]", equalTo(Integer.parseInt(servicesSplit[0]))).
        body("data.id[1]", equalTo(Integer.parseInt(servicesSplit[1]))).
        body("data.pivot[0].service_id", equalTo(Integer.parseInt(servicesSplit[0]))).
        body("data.pivot[1].service_id", equalTo(Integer.parseInt(servicesSplit[1])));
	}
	
	@Step
	public void gettingStarted(String bearerCode) {
		
		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.accept("application/json").header("Authorization", "Bearer " + bearerCode).baseUri(baseURI).basePath("/ptt/v1/onboarding/getting-started")
				.when().get();

	}
	
	@Step
	public void verifyGettingStartedResponse(boolean is_profile_complete, boolean has_work_experience, boolean is_bank_complete) {
     SerenityRest.then().
		assertThat().statusCode(HttpStatus.SC_OK).and().
		body("description", equalTo("Getting started summary request successful.")).
		body("data.is_profile_complete", equalTo(is_profile_complete)).
        body("data.has_work_experience", equalTo(has_work_experience)).
        body("data.is_bank_complete", equalTo(is_bank_complete));
	}
	
	@Step
	public void updateProfileData(String bearerCode, String firstname, String lastName, String nickName, String dob, String nric, String address, String postalCode, String student, String schoolName, String schoolId, String residentailStatus, String iswaiverAccepted) {
		 Map<String, Object> jsonMap = new HashMap<>();
		 jsonMap.put("first_name", firstname);
		 jsonMap.put("last_name", lastName);
		 jsonMap.put("nick_name", nickName);
		 jsonMap.put("dob", dob);
		 jsonMap.put("nric", nric);
		 jsonMap.put("address", address);
		 jsonMap.put("postal_code", postalCode);
		 jsonMap.put("student", student);
		 jsonMap.put("school_name", schoolName);
		 jsonMap.put("school_identification", schoolId);
		 jsonMap.put("class", residentailStatus);
		 jsonMap.put("is_waiver_accepted", iswaiverAccepted);
		 
		
		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.accept("application/json").header("Authorization", "Bearer " + bearerCode).body(jsonMap).baseUri(baseURI).basePath("/ptt/v1/account/settings/profile")
				.when().put();

	}
	

	@Step
	public void updateBankDetails(String bearerCode, String bank_account_first_name, String bank_account_last_name, String bank, String others_bank, String bank_account_number) {
		 Map<String, Object> jsonMap = new HashMap<>();
		 jsonMap.put("bank_account_first_name", bank_account_first_name);
		 jsonMap.put("bank_account_last_name", bank_account_last_name);
		 jsonMap.put("bank", bank);
		 jsonMap.put("others_bank", others_bank);
		 jsonMap.put("bank_account_number", bank_account_number);

		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.accept("application/json").header("Authorization", "Bearer " + bearerCode).body(jsonMap).baseUri(baseURI).basePath("/ptt/v1/account/settings/bank")
				.when().put();

	}
	

	@Step
	public void addWorkExperience(String bearerCode, String service_id, String jobTitle,String enterprise_name, String starts_at, String ends_at, String hours_worked, String endorsed_by_email,String is_team_lead) {
		 Map<String, Object> jsonMap = new HashMap<>();
		 jsonMap.put("service_id", service_id);
		 jsonMap.put("name", jobTitle);
		 jsonMap.put("enterprise_name", enterprise_name);
		 jsonMap.put("starts_at", starts_at);
		 jsonMap.put("ends_at", ends_at);
		 jsonMap.put("hours_worked", hours_worked);
		 jsonMap.put("endorsed_by_email", endorsed_by_email);
		 jsonMap.put("is_team_lead", is_team_lead);
		 
		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.accept("application/json").header("Authorization", "Bearer " + bearerCode).body(jsonMap).baseUri(baseURI).basePath("/ptt/v1/work-experience")
				.when().post();

	}
	
	@Step
	public void gettingStartedComplete(String bearerCode) {
		
		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.accept("application/json").header("Authorization", "Bearer " + bearerCode).baseUri(baseURI).basePath("/ptt/v1/onboarding/getting-started/complete")
				.when().post();

	}
	
	@Step
	public void getMatchedJobs(String bearerCode) {
		
		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.accept("application/json").header("Authorization", "Bearer " + bearerCode).baseUri(baseURI).basePath("/ptt/v1/job/match")
				.when().post();

	}
	
	@Step
	public void verifyGetMatchedJobResponse(String dateToVerify, String jobTitle) {
    SerenityRest.then().
		assertThat().statusCode(HttpStatus.SC_OK).and().
		body("total_count", equalTo(1)).
		body("description", equalTo("Matched jobs listing request successful.")).
		body("data.current_page", equalTo(1)).
        body("data.last_page", equalTo(1)).
        
        body("data.data."+dateToVerify+".name", equalTo(jobTitle)).
        body("data.data."+dateToVerify+".enterprise_id", equalTo(jobTitle)).
        body("data.data."+dateToVerify+".service_id", equalTo(jobTitle)).
        body("data.data."+dateToVerify+".venue", equalTo(jobTitle)).
        body("data.data."+dateToVerify+".postal_code", equalTo(jobTitle)).
        body("data.data."+dateToVerify+".starts_at", equalTo(jobTitle)).
        body("data.data."+dateToVerify+".ends_at", equalTo(jobTitle)).   
        body("data.data."+dateToVerify+".part_timers_count", equalTo(jobTitle)).
        body("data.data."+dateToVerify+".payment", equalTo(jobTitle)).
        body("data.data."+dateToVerify+".term", equalTo(jobTitle)).
        body("data.data."+dateToVerify+".created_by_id", equalTo(jobTitle)).
        body("data.data."+dateToVerify+".forfeited_credit", equalTo(jobTitle)).
        body("data.data."+dateToVerify+".ratings", equalTo(jobTitle)).
        body("data.data."+dateToVerify+".status", equalTo(jobTitle)).
        body("data.data."+dateToVerify+".duration", equalTo(jobTitle)).
        body("data.data."+dateToVerify+".partimer_distance", equalTo(jobTitle)).and().
        
        
        body("data.data."+dateToVerify+".service.id", equalTo(jobTitle)).and().
        body("data.data."+dateToVerify+".service.name", equalTo(jobTitle)).and().
        body("data.data."+dateToVerify+".service.name", equalTo(jobTitle)).and()
        
        
        
        ;
	}
	
	
	@Step
	public void getAllJobs(String bearerCode) {
		
		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.accept("application/json").header("Authorization", "Bearer " + bearerCode).baseUri(baseURI).basePath("/ptt/v1/job/all")
				.when().get();

	}
	
	@Step
	public int verifygetAllJobsResponse() {
     int lastPage =  SerenityRest.then().
		assertThat().statusCode(HttpStatus.SC_OK).and().
		body("description", equalTo("All jobs listing request successful.")).
		body("data.current_page", equalTo(1)).extract().jsonPath().get("data.last_page");
	return lastPage;
	}
	

	@Step
	public int getLastPageCountFromGetAllJobsResponse() {
     int totalJobCount =  SerenityRest.then().extract().jsonPath().get("total_count");
	return totalJobCount;
	}
	
	

	
	
	
	
	
	
	
	
	
	
// Repeat Functions //	  
	@Step
	public String getBearerCode(String partTimerEmail, String partimerPassword) {

		String bearerCodeRequestBody = "{\"grant_type\":\"password\", \"client_id\":\"1\",\"client_secret\":\"WUxNdGi5ptoNVtQ8u3HtT4JoU4wTeK1qX6ZN8uCq\",\"username\":\""
				+ partTimerEmail + "\",\"password\":\"" + partimerPassword + "\"}";

		String bearerCode = SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.body(bearerCodeRequestBody).baseUri(baseURI).basePath("/oauth/token").when().post().then().extract()
				.jsonPath().get("access_token");
		return bearerCode;

	}

	@Step
	public void verifySucessfulResponseWithOnlyDescription(String description) {

		SerenityRest.then().assertThat().statusCode(HttpStatus.SC_OK).and().body("description", equalTo(description))
				.extract().jsonPath().get("description");
	}

	@Step
	public int getStatusCode() {
		return SerenityRest.then().extract().statusCode();
	}



	@Step
	public void DummyWithLogAll(String newpartTimerEmail, String newPartimerPassword) {

		String bearerCodeRequestBody = "{\"grant_type\":\"password\", \"client_id\":\"1\",\"client_secret\":\"WUxNdGi5ptoNVtQ8u3HtT4JoU4wTeK1qX6ZN8uCq\",\"username\":\""
				+ newpartTimerEmail + "\",\"password\":\"" + newPartimerPassword + "\"}";

		String bearerCode = SerenityRest.given().relaxedHTTPSValidation().contentType("application/json")
				.body(bearerCodeRequestBody).log().all().baseUri(baseURI).basePath("/oauth/token").when().post().then()
				.extract().jsonPath().get("access_token");

		SerenityRest.given().relaxedHTTPSValidation().contentType("application/json").accept("application/json")
				.header("Authorization", "Bearer " + bearerCode).log().all().baseUri(baseURI)
				.basePath("/ptt/v1/job/all/" + "123" + "/apply").when().post().then().log().body().assertThat()
				.statusCode(HttpStatus.SC_OK);
	}

	public String getTimeNow() {
		Calendar calendar = Calendar.getInstance();
		// get a date to represent "today"
		Date today = calendar.getTime();
		// System.out.println("Today: " + today);
		// System.out.println(new SimpleDateFormat("d/M/yyyy").format(today));
		String formattedDateToday = new SimpleDateFormat("dd_MM_yy_mm_ss").format(today);
		return formattedDateToday;
	}


}
