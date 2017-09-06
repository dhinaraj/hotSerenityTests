package Plus65.Scenarios;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import Plus65.steps.serenity.AdminNavigation;
import Plus65.steps.serenity.HoNavigationPage;
import Plus65.steps.serenity.PartimerDailyTestJobAPISteps;
import Plus65.steps.serenity.PartimerNavigation;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="TestData/ArrowMii_WebdriverJobData.csv")
@Concurrent(threads="1")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DailyTestJobStory_DataDriven {

	@Steps
	HoNavigationPage ho;
	@Steps
	AdminNavigation admin;
	@Steps
	PartimerNavigation partimerNav;
	
	@Steps
	PartimerDailyTestJobAPISteps dailyJobApi;

	@Managed
	WebDriver browser;



	private String finalStatus; 
	private String enterprise;
	private String hoEmail;
	private String serviceLine;
	private String jobTitle;
	private String eventStartDate;
	private String eventEndDate;
	private String eventStartTime;
	private String eventEndTime;
	private String totalHours;
	private String noOfPartTimers;
	private String ratePerHour;
	private int creditsToBeDedcuted;	
	private int matchesThatAccept;
	private int matchesThatDecline;
	private String activeMatches;
	private String passiveMatches;
	private int applicants;
	private int applicationsApproved;
	private int rejectedApplications;
	private int partTimersWithdrawn;
	private int cancelledPartTimers;
	private String fulfilment;
	private int actualCreditUsed;
	private String payoutAmount;
	
	
	public void setfinalStatus(String finalStatus) {
        this.finalStatus = finalStatus;
    }
	
	public void setenterprise(String enterprise) {
        this.enterprise = enterprise;
    }
	
	public void sethoEmail(String hoEmail) {
        this.hoEmail = hoEmail;
    }
	
	public void setserviceLine(String serviceLine) {
        this.serviceLine = serviceLine;
    }
	
	public void setjobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
	
	public void seteventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }
	
	public void seteventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }
	
	public void seteventEnd(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }
	
	public void seteventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }
	
	public void seteventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }
	
	public void settotalHours(String totalHours) {
        this.totalHours = totalHours;
    }
	
	public void setnoOfPartTimers(String noOfPartTimers) {
        this.noOfPartTimers = noOfPartTimers;
    }
	
	public void setratePerHour(String ratePerHour) {
        this.ratePerHour = ratePerHour;
    }
	
	public void setcreditsToBeDedcuted(int creditsToBeDedcuted) {
        this.creditsToBeDedcuted = creditsToBeDedcuted;
    }
	
	public void setmacthesThatAccept(int matchesThatAccept) {
        this.matchesThatAccept = matchesThatAccept;
    }
	
	public void setmatchesThatDecline(int matchesThatDecline) {
		this.matchesThatDecline = matchesThatDecline;
	}
	
	public void setActiveMatches(String activeMatches) {
		this.activeMatches = activeMatches;
	}
	
	public void passiveMatches(String passiveMatches) {
		this.passiveMatches = passiveMatches;
	}
	
	public void setapplicants(int applicants) {
		this.applicants = applicants;
	}

	public void setapplicationsApproved(int applicationsApproved) {
		this.applicationsApproved = applicationsApproved;
	}

	public void setrejectedApplications(int rejectedApplications) {
		this.rejectedApplications = rejectedApplications;
	}

	public void setpartTimersWithdrawn(int partTimersWithdrawn) {
		this.partTimersWithdrawn = partTimersWithdrawn;
	}

	public void setcancelledPartTimers(int cancelledPartTimers) {
		this.cancelledPartTimers = cancelledPartTimers;
	}

	public void setfulfilment(String fulfilment) {
		this.fulfilment = fulfilment;
	}

	public void setactualCreditUsed(int actualCreditUsed) {
		this.actualCreditUsed = actualCreditUsed;
	}

	public void setpayoutAmount(String payoutAmount) {
		this.payoutAmount = payoutAmount;
	}
	

	private String startDate;
	private String endDate;
	private String[] startTime=new String[2];
	private String[] endTime= new String[2];
	private String startMonth;
	private String endMonth;
	private String partimerPassword = "123qwe";
	private String jobId;
	private String creditBeforeJobCreation;
	
	
	@Test
	@Title("Daily Test Job - Create Job and Partimer's Accept/Apply for Jobs")
	// Given
	public void dailyTestJobUsingWebDriverAndAPI() throws InterruptedException {

		// HO Creates Job
		
		createJob();

		// Matched Partimers Accepts Job Offer 

		if(matchesThatAccept>0)
		{
			System.out.println("=========== Beginning to Accept Offers By Part Timers =============");
			dailyJobApi.acceptJobOffer(matchesThatAccept, serviceLine, jobId);
			//dailyJobApi.acceptJobOffer(matchesThatAccept, serviceLine, "2094");
			System.out.println("=========== Jobs accepted by: " + matchesThatAccept+ " Part Timers=============");
		}

		// Unmatched Partimers Apply for Job Offer
		if(applicants>0)
		{
			System.out.println("=========== Beginning to Apply for Jobs By Part Timers =============");
			dailyJobApi.applyJobs(applicants, serviceLine, jobId);
			//dailyJobApi.applyJobs(applicants, serviceLine, "2094");
			System.out.println("=========== Jobs Applied By : " + applicants+ " Part Timers=============");
		}

		// HO Approves Partimers out of applications
		if(applicationsApproved>0)
		{
		approveUnmatchedPartimers(applicationsApproved);
		}
		
		// Part Timers Decline Job 
		if(matchesThatDecline>0)
		{
			System.out.println("=========== Beginning to Decline Jobs By Part Timers =============");
			dailyJobApi.declineJob(matchesThatDecline, serviceLine, jobId);
			System.out.println("=========== Jobs Declined By : " + matchesThatDecline+ " Part Timers=============");
		}
		
		// Part Timers Withdraw Job		
		if(partTimersWithdrawn>0)
		{
			System.out.println("=========== Beginning to Withdraw Job Applications By Part Timers =============");
			dailyJobApi.withDrawJobApplication(partTimersWithdrawn, serviceLine, jobId);
			System.out.println("=========== Jobs Withdrawn By : " + partTimersWithdrawn+ " Part Timers=============");
		}
		
		// HO Rejects Applications		
		if(rejectedApplications>0)
		{
			rejectApplications();
		}
		
		// HO Cancels Confirmed PartTimers	
		if(cancelledPartTimers>0)
		{
			cancelConfirmedPartTimers();
		}

		// Validate Job Fulfilment before Completing the Job/Cancelling the job
		
		validateJobFulfilment();
		
		// HO Clocks IN /OUT and Reviews all PartTimers
		
		if(finalStatus.equalsIgnoreCase("completed"))
		{
		completeJob();
		}
		
		// HO Cancels Job
		
		if(finalStatus.equalsIgnoreCase("cancelled"))
		{
		checkIfJobExistsAndCancel();
		}
		
		
	}

	
	
	private void createJob() throws InterruptedException {
		admin.isAtAdminHomepage();
		admin.logsInWithValidCredentials(hoEmail, "123qwe");
		ho.shouldSeePageTitle("ArrowMii - Dashboard");

		ho.clickJobListings();

		/******* Check if Job already exits and cancel if it exists *******/

		if (!ho.checkForExistinJobWithSameTitle(jobTitle))
		{
			/******* Proceed to create new Job *******/
			creditBeforeJobCreation = ho.getCurrentCredit();
			System.out.println("Beginning to Create Job for: " + hoEmail);
			ho.clickCreatNewJob();
			setJobDetails();
			ho.clickPartimercount(noOfPartTimers);
			ho.clickPartimerAmount(ratePerHour);
			// ho.selectEventSupervisor();
			// ho.enterJobInstrAndVideo();
			ho.jobCreatNow();
			ho.jobSubmit();
			ho.shouldSeeMessage("Success! Your New Job Has Been Posted In ArrowMii");
			ho.jobPostVeiw();
			ho.verifyJobMatches("MATCHES ("+activeMatches+" + "+passiveMatches+")");
			validateCreditSummary();
			//validateJobSummary();

			admin.quitAdminDriver();
		} else {
			System.out.println("Job With Same Title Already Exist");
			admin.quitAdminDriver();
		}
	}
	
	public void applyForMatchedPartimers() {
		 for (int i = 0; i <= matchesThatAccept-1; i++) { System.out.
			  println("Beginning to Accept Offer for job created by: " + hoEmail +" for Partimer: " +
			  (i + 1));
			  
			  partimerNav.isAtPartimerHomepage();
			  getPartimerLogin(i);
			  partimerNav.navigateToJobOffersByLinkText();
			  partimerNav.selectFirstJob(); 
			  partimerNav.clickApplyForJob();
			  partimerNav.confirmJobApplication(); // Then 
			  partimerNav.shouldSeeText("You Have Successfully Accepted The Matched Job.");
			  partimerNav.quitPartimerDriver();
			  
			  } 
	}
	
	public void applyForUnMatchedPartimers() {
		 for (int i = 50; i <= (50+applicants-1); i++) { System.out.
			  println("Beginning to Apply for job created by: " + hoEmail +" for Partimer: " +
					  (i + 1));
			  partimerNav.isAtPartimerHomepage();
			  getPartimerLogin(i);
			  partimerNav.navigateToJobMatchLink();
			  partimerNav.navigateToAllJobsTab();
			  partimerNav.searchForJobs(jobTitle); 
			  partimerNav.selectFirstJob();
			  partimerNav.clickApplyForJob(); 
			  partimerNav.confirmJobApplication();
			  partimerNav.shouldSeeText("You Have Successfully Applied The Job.");
			  partimerNav.quitPartimerDriver();
			 } 

	}
	
	public void approveUnmatchedPartimers(int numberOfPartimerstoApprove) throws InterruptedException {
		admin.isAtAdminHomepage();
		admin.logsInWithValidCredentials(hoEmail, "123qwe");
		ho.shouldSeePageTitle("ArrowMii - Dashboard");
		ho.clickJobListings();
		ho.searchForJobs(jobTitle);
		ho.openJob();
		//ho.openJobApplicantsPage();
		ho.clickOnApplicationsTab();
		ho.approvePartimers(numberOfPartimerstoApprove, hoEmail); 
		admin.quitAdminDriver();
	}

	private void completeJob() throws InterruptedException {
		ho.clickOnJobAttendance();
		//if (ho.checkForExistinJobWithSameTitle("Daily Test Job" + "_" + getTodayDate())) {
		if (ho.checkForExistinJobWithSameTitle(jobTitle)) {
			
			System.out.println("===========Beginning to Complete Job===========");
			String creditBeforeJobCompletion = ho.getCurrentCredit();
			int expectedCreditAfterJobCompletion = Integer.parseInt(creditBeforeJobCompletion.replaceAll(",", ""))+(creditsToBeDedcuted-actualCreditUsed);
			System.out.println("Credit Before Job Completion: "+ creditBeforeJobCompletion);
			System.out.println("Expected Credit After Job Completion: "+ expectedCreditAfterJobCompletion);
			ho.openJobAttendanceView();
			ho.doBulkClockIn();
			ho.doBulkClockOut();
			ho.doBulkReview();
			
			System.out.println("===========Job Completed Sucessfully===========");
			Thread.sleep(10000);
			ho.refereshPage();
			System.out.println("Credit After Job Completion: "+ ho.getCurrentCredit());
			assertThat(ho.getCurrentCredit().replaceAll(",", "")).isEqualTo(String.valueOf(expectedCreditAfterJobCompletion));
			admin.quitAdminDriver();
		}
		
		else {
			System.out.println("NO JOB AVAILBALE FOR COMPLETION TODAY");
		}
	}
	
	public void checkIfJobExistsAndCancel() throws InterruptedException {
		
		ho.clickJobListings();
		
		if (ho.checkForExistinJobWithSameTitle(jobTitle)) {
			
			System.out.println("===========Beginning to Cancel Job===========");
			String creditBeforeJobCancellation = ho.getCurrentCredit();
			int expectedCreditAfterJobCancellation = Integer.parseInt(creditBeforeJobCancellation.replaceAll(",", ""))+(creditsToBeDedcuted-actualCreditUsed);
			System.out.println("Credit Before Job Completion: "+ creditBeforeJobCancellation);
			System.out.println("Expected Credit After Job Completion: "+ expectedCreditAfterJobCancellation);
			ho.cancelFirstJobinList();
			
			System.out.println("===========Job Cancelled Sucessfully===========");
			
			Thread.sleep(10000);
			ho.refereshPage();
			System.out.println("Credit After Job Cancellation: "+ ho.getCurrentCredit());
			assertThat(ho.getCurrentCredit().replaceAll(",", "")).isEqualTo(String.valueOf(expectedCreditAfterJobCancellation));
			
			admin.quitAdminDriver();
		}
		else
		{
			System.out.println("NO JOB AVAILBALE FOR CANCELLATION WITH TITLE: "+ jobTitle);
			admin.quitAdminDriver();
		}
		

	}

	/*private void validateJobSummary() {
		
		ho.validateJobBaseInformationAfterJobCreation(jobTitle, expectedStartDate, expectedEndDate,
				expectedSchedule, 50, 10, expectedServiceLine, expectedHoName,
				expectedESname, expectedjobDescription, expectedSpecialInstructions, expectedVenue);
		
	}*/

	private String validateCreditSummary() {

		try {
			System.out.println("Credit Before Job Creation = " + creditBeforeJobCreation);
			int expectedRemainingCredit = Integer.parseInt(creditBeforeJobCreation.replaceAll(",",""))-creditsToBeDedcuted;
			System.out.println("Expected Credit After Job Creation = " + expectedRemainingCredit);
			jobId = ho.validateCreditSummaryAfterJobCreation(expectedRemainingCredit, totalHours, noOfPartTimers,
					String.valueOf(creditsToBeDedcuted));

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobId;
	}
	
	
	private void validateJobFulfilment() throws InterruptedException {
		
		admin.isAtAdminHomepage();
		admin.logsInWithValidCredentials(hoEmail, "123qwe");
		ho.shouldSeePageTitle("ArrowMii - Dashboard");
		ho.clickJobListings();
		ho.searchForJobs(jobTitle);
		ho.openJob();
		System.out.println("========== Validating Job Fulfilment Count ==============");
			System.out.println("Expected Fulfilment: " + fulfilment);
			ho.validateFulfilledCount(fulfilment);
		System.out.println("========== Validating Job Fulfilment Count ==============");
		if(finalStatus.equalsIgnoreCase("none"))
		{
			admin.quitAdminDriver();
		}

	}

	public String getTodayDate() {
		Calendar calendar = Calendar.getInstance();
		// get a date to represent "today"
		Date today = calendar.getTime();
		//System.out.println("Today: " + today);
		//System.out.println(new SimpleDateFormat("d/M/yyyy").format(today));
		String formattedDateToday = new SimpleDateFormat("d/M/yyyy").format(today);
		return formattedDateToday;
	}
	

	
	public void setJobDetails() {

		getJobDetails();
		System.out.println("=======Job Details=======");
		System.out.println("Job Title: " + jobTitle);
		System.out.println("Start Date: " + eventStartDate + " " + eventStartTime);
		System.out.println("End Date: " + eventEndDate+ " " + eventEndTime);
		System.out.println("Number of Partimers: " + noOfPartTimers);
		System.out.println("Total Hours: " + totalHours);
		System.out.println("=======Job Details=======");
		ho.enterTitle(jobTitle);
		ho.selectDate(startDate, startMonth, "startdate");
		//ho.selectDate("31", "9", "startdate");
		ho.clickStartTime(Integer.parseInt(startTime[0]), startTime[1]);
		ho.selectDate(endDate, endMonth, "enddate");
		//ho.selectDate("31", "9", "enddate");
		ho.clickEndTime(Integer.parseInt(endTime[0]), endTime[1]);

	}

	public void getJobDetails() {

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
	

	public void getPartimerLogin(int i) {
		
		if(hoEmail.equalsIgnoreCase("dailytestjob+ho1@gmail.com")) 
		  {
		  partimerNav.logsInWithValidCredentials(partimerEmailForServiceLine1[i], partimerPassword); 
		  } 
		  else if
		  (hoEmail.equalsIgnoreCase("dailytestjob+ho2@gmail.com")) 
		  {
		  partimerNav.logsInWithValidCredentials(partimerEmailForServiceLine2[i], partimerPassword); 
		  } 
	}
	
	
	public void rejectApplications() throws InterruptedException {
		
			admin.isAtAdminHomepage();
			admin.logsInWithValidCredentials(hoEmail, "123qwe");
			ho.shouldSeePageTitle("ArrowMii - Dashboard");
			ho.clickJobListings();
			ho.searchForJobs(jobTitle);
			ho.openJob();
			ho.clickOnApplicationsTab();
			ho.rejectApplications(applicationsApproved, rejectedApplications, hoEmail); 
		    admin.quitAdminDriver();

	}
	
	public void cancelConfirmedPartTimers() throws InterruptedException {
		 	admin.isAtAdminHomepage();
			admin.logsInWithValidCredentials(hoEmail, "123qwe");
			ho.shouldSeePageTitle("ArrowMii - Dashboard");
			ho.clickJobListings();
			ho.searchForJobs(jobTitle);
			ho.openJob();
			ho.clickOnConfirmedPartimersTab();
			ho.cancelConfirmedPartTimers(partTimersWithdrawn, cancelledPartTimers, hoEmail); 
			admin.quitAdminDriver();

	}
	

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

}
