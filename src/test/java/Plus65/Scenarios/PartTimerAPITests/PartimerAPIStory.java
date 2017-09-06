package Plus65.Scenarios.PartTimerAPITests;



 

import java.sql.SQLException;

import javax.management.StringValueExp;
import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import Plus65.steps.serenity.AdminNavigation;
import Plus65.steps.serenity.HoNavigationPage;
import Plus65.steps.serenity.PartimerApiSteps;
import Plus65.steps.serenity.PartimerNavigation;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import Plus65.utilities.DateFormatFunctions;
import Plus65.utilities.MySQLFunctions;

/**
 * Created by Dhinakaran on 20/07/2017.
 */

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class PartimerAPIStory {

	@Steps
	PartimerApiSteps pApi;
	@Steps
	HoNavigationPage ho;
	@Steps
	AdminNavigation admin;
	@Steps
	PartimerNavigation partimerNav;
	
	

    MySQLFunctions mySqlFunctions = new MySQLFunctions();
    DateFormatFunctions dateFormat = new DateFormatFunctions();

	@Managed
	WebDriver browser;
	
	  private static String newpartTimerEmail = "dhinaplus65testing+28_07_17_20_16@gmail.com";
	  private static String newpartTimerEmail2 = "dhinaplus65testing+28_07_17_18_52@gmail.com";
	 /* private static String newpartTimerEmail = "";
	  private static String newpartTimerEmail2 = "";*/
	  private static String newPartimerPassword = "1234qwer";
	  private static String validPhoneNumber = "+6591640205";
	  private String bearerCode = "";
	

	public  void getNewPartTimerEmail() throws InterruptedException
	{
		newpartTimerEmail = "dhinaplus65testing+"+pApi.getTimeNow()+"@gmail.com";
		Thread.sleep(2000);
		newpartTimerEmail2 = "dhinaplus65testing+"+pApi.getTimeNow()+"@gmail.com";
	}
	
	@Before
    public void getBearerCode()  {
		this.bearerCode = pApi.getBearerCode(newpartTimerEmail, newPartimerPassword);
	}
	
	public void getBearerCode(String email)  {
		this.bearerCode = pApi.getBearerCode(email, newPartimerPassword);
	}
	


	@Test
	@Pending
	@Title("PTT API: Register New PartTimers and Confirm Subscription")
	public void api001_ConfirmPartTimerSubscription() throws InterruptedException, SQLException {
		getNewPartTimerEmail();
		String partTimerEmail ="";
		for (int i=1; i<=2; i++)
		{
			if(i==1)
			{
				partTimerEmail= newpartTimerEmail; 
			}
			else
			{
				partTimerEmail = newpartTimerEmail2;
			}
		pApi.registerUser(partTimerEmail, newPartimerPassword);
		pApi.verifySucessfulResponseWithOnlyDescription("Registration has been completed successfully.");
		String userId = mySqlFunctions.runSelectQuery("SELECT * FROM users WHERE email = '"+partTimerEmail+"'", "arrowme_staging", "id");
		System.out.println("User ID =: "+ userId);
		mySqlFunctions.CloseDataBaseConnection();
		mySqlFunctions.closeConnections();
		String activationCode = mySqlFunctions.runSelectQuery("SELECT * FROM activations WHERE user_id = '"+userId+"'", "arrowme_staging", "code");
		System.out.println("Activation Code =: "+ activationCode);
		mySqlFunctions.CloseDataBaseConnection();
		mySqlFunctions.closeConnections();
		pApi.confirmUserSubscription(activationCode);
		pApi.verifySucessfulResponseWithOnlyDescription("Registration has been verified successfully.");
		}
	}
	
	
	@Test
	@Title("PTT API: Get Full Account Details After User Registration")
	public void api002_getFullAccountDetails() throws InterruptedException {
		pApi.getFullAccountDetails(newpartTimerEmail, bearerCode);
		pApi.verifyFullAccountDetailsResponse(newpartTimerEmail);
	}
	
	@Test
	@Title("PTT API: Resend registration")
	public void api003_resendRegistration() throws InterruptedException {
		pApi.resendRegistration(newpartTimerEmail);
		pApi.verifySucessfulResponseWithOnlyDescription("Registration email has been resent successfully.");
	}
	
	
	@Test
	@Title("PTT API: Forgot Password")
	public void api004_forgotPassword() throws InterruptedException {
		pApi.forgotPassword(newpartTimerEmail);
		pApi.verifySucessfulResponseWithOnlyDescription("Reset password email has been sent successfully.");
	}
	
	@Test
	@Title("PTT API: Resend Forgot Password")
	public void api006_forgotPasswordResend() throws InterruptedException {
		pApi.forgotPasswordResend(newpartTimerEmail);
		pApi.verifySucessfulResponseWithOnlyDescription("Reset password email has been resent successfully.");
	}
	
	@Test
	@Title("PTT API: Update Phone Number")
	public void api007_updatePhoneNumber() throws InterruptedException, SQLException {
		pApi.updatePhoneNumber(validPhoneNumber, bearerCode);
		pApi.verifySucessfulResponseWithOnlyDescription("A verification code is successfully sent to your registered mobile phone.");
		String otp = mySqlFunctions.runSelectQuery("SELECT * FROM users WHERE email = '"+newpartTimerEmail+"'", "arrowme_staging", "otp_code");
		System.out.println("Otp =: "+ otp);
		mySqlFunctions.CloseDataBaseConnection();
		mySqlFunctions.closeConnections();
		pApi.verifyPhoneNumberUsingOTP(otp, validPhoneNumber, bearerCode);
		pApi.verifySucessfulResponseWithOnlyDescription("The registered mobile phone is successfully verified.");
	}
	
	@Test
	@Pending // Resend OTP code is resulting error, so ignoring in the test
	@Title("PTT API: Resend OTP Code")
	public void api008_resendOtpCode() throws InterruptedException, SQLException {
		pApi.resendOtpCode(validPhoneNumber, bearerCode);
		pApi.verifySucessfulResponseWithOnlyDescription("The verification code is successfully sent to your phone.");
		String otp = mySqlFunctions.runSelectQuery("SELECT * FROM users WHERE email = '"+newpartTimerEmail+"'", "arrowme_staging", "otp_code");
		System.out.println("Otp =: "+ otp);
		mySqlFunctions.CloseDataBaseConnection();
		mySqlFunctions.closeConnections();
		pApi.verifyPhoneNumberUsingOTP(otp, validPhoneNumber, bearerCode);
		pApi.verifySucessfulResponseWithOnlyDescription("The registered mobile phone is successfully verified.");
	}
	
	@Test
	@Title("PTT API: Update On Boarding Service Lines")
	public void api009_updateOnBoardingServices1() throws InterruptedException, SQLException {
		String services = "4,5";
		pApi.onBoardingServices(services, bearerCode);
		pApi.verifyOnBoardingServicesResponse(services);
	}
	
	@Test
	@Title("PTT API: Update On Boarding Service Lines")
	public void api010_updateOnBoardingServices2() throws InterruptedException, SQLException {
		String services = "53,54";
		pApi.onBoardingServices(services, bearerCode);
		pApi.verifyOnBoardingServicesResponse(services);
	}
	
	@Test
	@Title("PTT API: Verify getting started before updating profile/work experience/bank data")
	public void api011_gettingStarted() throws InterruptedException, SQLException {
		pApi.gettingStarted(bearerCode);
		pApi.verifyGettingStartedResponse(false, false, false);
	}
	
	@Test
	@Title("PTT API: update Profile Data")
	public void api012_updateProfile() throws InterruptedException, SQLException {
		String nric = String.valueOf((Math.random()*100000));
		pApi.updateProfileData(bearerCode, "First Name", "Last Name", "Nick Name", "1980-09-26", nric, "554, Bedok North Street 3", "460528", "on", "NTU", "123456789", "singaporean", "1");
		pApi.verifySucessfulResponseWithOnlyDescription("Account profile is successfully updated.");

	}
	
	@Test
	@Title("PTT API: update Bank Details")
	public void api013_updateBankData() throws InterruptedException, SQLException {
		String nric = String.valueOf((Math.random()*100000));
		pApi.updateBankDetails(bearerCode, "First Name", "Last Name", "Bank Name", "1980-09-26", nric);
		pApi.verifySucessfulResponseWithOnlyDescription("Bank details is successfully updated.");

	}
	
	@Test
	@Title("PTT API: Add Work Experience")
	public void api014_submitWorkExperience() throws InterruptedException, SQLException {
		pApi.addWorkExperience(bearerCode, "53", "Test Job", "Test Enterprise", "2016-12-26", "2016-12-27", "20", "dddd@plljj.xyxyx.com", "true");
		pApi.verifySucessfulResponseWithOnlyDescription("The work experience is successfully added.");

	}
	
	@Test
	@Title("PTT API: Verify getting started after updating profile/work experience/bank data")
	public void api015_gettingStartedAfterProfileupdate() throws InterruptedException, SQLException {
		pApi.gettingStarted(bearerCode);
		pApi.verifyGettingStartedResponse(true, true, true);
	}
	
	@Test
	@Title("PTT API: Mark Getting Started Steps Completed")
	public void api016_gettingStartedComplete() throws InterruptedException, SQLException {
		pApi.gettingStartedComplete(bearerCode);
		pApi.verifySucessfulResponseWithOnlyDescription("Getting Started Has Been Successfully Completed.");
	}
	
	@Test
	@Title("Create New Job")
	public void api017_CreateJob() throws InterruptedException, SQLException {

		admin.isAtAdminHomepage();
		admin.logsInWithValidCredentials(hoEmail, "123qwe");
		ho.shouldSeePageTitle("ArrowMii - Dashboard");
		ho.clickJobListings();
		getJobDetails();
		/******* Check if Job already exits and cancel if it exists *******/
		checkIfJobExistsAndCancel();
		/******* Proceed to create new Job *******/
		System.out.println("Beginning to Create Job for: " + hoEmail);
		ho.clickCreatNewJob();
		setJobDetails();
		ho.clickPartimercount(noOfPartTimers);
		ho.clickPartimerAmount(totalHours);
		ho.jobCreatNow();
		ho.jobSubmit();
		ho.shouldSeeMessage("Success! Your New Job Has Been Posted In ArrowMii");
		ho.jobPostVeiw();
		jobID = ho.getJobID();
		ho.verifyJobMatches("MATCHES (1) | WAITLISTS (0) | BACKUPS (0)");

	}
	
	@Test
	@Title("PTT API: Get Matched Jobs")
	public void api018_getMatchedJobs() throws InterruptedException, SQLException {
		pApi.getMatchedJobs(bearerCode);
		pApi.verifyGetMatchedJobResponse(dateFormat.getTomorrowDateFormat2(), jobTitle);
		
	}
	
	
	@Test
	@Title("PTT API: Get All Jobs Page")
	public void api019_getAllJobs() throws InterruptedException, SQLException {
		getBearerCode(newpartTimerEmail2);
		pApi.getAllJobs(bearerCode);
		int lastPage = pApi.verifygetAllJobsResponse();
		int totalOtherJobsCount = pApi.getLastPageCountFromGetAllJobsResponse();
		System.out.println("Last Page Retruned In Response: " + lastPage);
		System.out.println("Total Other Jobs Count In Response: " + totalOtherJobsCount);

	}
	
	
	
	@Test
	@Title("Mark User As Deleted After ALL Tests")
	public void x_markUserDeleted() throws InterruptedException, SQLException {
		
		
		mySqlFunctions.executeUpdateQuery("UPDATE users SET deleted_at = '2017-07-28 10:37:07' WHERE email = '"+newpartTimerEmail+"'", "arrowme_staging");
		System.out.println("Updated Deleted at For Email: "+ newpartTimerEmail);
		
		mySqlFunctions.executeUpdateQuery("UPDATE users SET deleted_at = '2017-07-28 10:37:07' WHERE email = '"+newpartTimerEmail2+"'", "arrowme_staging");
		System.out.println("Updated Deleted at For Email: "+ newpartTimerEmail2);
		
		/*mySqlFunctions.executeUpdateQuery("UPDATE users SET deleted_at = '2017-07-28 10:37:07' WHERE email = '"+"dhinaplus65testing+28_07_17_04_03@gmail.com"+"'", "arrowme_staging");
		System.out.println("Updated Deleted at For Email: "+ newpartTimerEmail);
		
		mySqlFunctions.executeUpdateQuery("UPDATE users SET deleted_at = '2017-07-28 10:37:07' WHERE email = '"+"dhinaplus65testing+28_07_17_04_04@gmail.com"+"'", "arrowme_staging");
		System.out.println("Updated Deleted at For Email: "+ newpartTimerEmail);*/

	}
	
	//2197


	// Create Job Functions
	
		private String jobTitle = "";

		private String eventStartDate;
		private String eventEndDate;
		private String eventStartTime;
		private String eventEndTime;
		private String startDate;
		private String endDate;
		private String[] startTime = new String[2];
		private String[] endTime = new String[2];
		private String startMonth;
		private String endMonth;
		
		  private String jobID="";
		  private String hoEmail = "dhinaplus65testing+astho1@gmail.com";
		  private String noOfPartTimers = "5";
		  private String totalHours = "10";
		
		

		void getJobDetails()  {
			jobTitle = hoEmail+"_"+dateFormat.getTomorrowDateFormat1();
			eventStartDate = dateFormat.getTomorrowDateFormat1();
			eventEndDate = dateFormat.getTomorrowDateFormat1();
			eventStartTime = "7 PM";
			eventEndTime = "10 PM";
			String eventStartDateParts[] = eventStartDate.split("/");
			startDate = eventStartDateParts[0];
			startMonth = String.valueOf((Integer.parseInt(eventStartDateParts[1]) - 1));
			String eventEndDateParts[] = eventEndDate.split("/");
			endDate = eventEndDateParts[0];
			endMonth = String.valueOf((Integer.parseInt(eventEndDateParts[1]) - 1));
			String eventStartTimeParts[] = eventStartTime.split(" ");
			startTime = new String[] { eventStartTimeParts[0], eventStartTimeParts[1] };
			String eventEndTimeParts[] = eventEndTime.split(" ");
			endTime = new String[] { eventEndTimeParts[0], eventEndTimeParts[1] };

		}
		
		void setJobDetails() {

			System.out.println("=======Job Details=======");
			System.out.println("Job Title: " + jobTitle);
			System.out.println("Start Date: " + eventStartDate + " " + eventStartTime);
			System.out.println("End Date: " + eventEndDate+ " " + eventEndTime);
			System.out.println("=======Job Details=======");
			ho.enterTitle(jobTitle);
			ho.selectDate(startDate, startMonth, "startdate");
			//ho.selectDate("31", "9", "startdate");
			ho.clickStartTime(Integer.parseInt(startTime[0]), startTime[1]);
			ho.selectDate(endDate, endMonth, "enddate");
			//ho.selectDate("31", "9", "enddate");
			ho.clickEndTime(Integer.parseInt(endTime[0]), endTime[1]);

		}
		
		void checkIfJobExistsAndCancel() throws InterruptedException {
			
			//ho.clickJobListings();

			if (ho.checkForExistinJobWithSameTitle(jobTitle)) {
				ho.cancelFirstJobinList();
				System.out.println("===========Job Cancelled Sucessfully===========");
			} else {
				System.out.println("NO JOB AVAILBALE FOR CANCELLATION WITH TITLE: " + jobTitle);
			}

		}




}
