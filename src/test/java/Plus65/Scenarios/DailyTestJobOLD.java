package Plus65.Scenarios;

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

@RunWith(SerenityParameterizedRunner.class)
@Concurrent(threads="2")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DailyTestJobOLD {

	@Steps
	HoNavigationPage ho;
	@Steps
	AdminNavigation admin;
	@Steps
	PartimerNavigation partimerNav;

	@Managed
	WebDriver browser;

	@TestData
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][] { //{ "dailytestjob+ho1@gmail.com" },
			{"dailytestjob+ho2@gmail.com"},

		});
	}

	private final String hoEmail;
	public String jobTitle;
	public String startDate;
	public String endDate;
	public String[] startTime=new String[2];
	public String[] endTime= new String[2];
	public String startMonth;
	public String endMonth;
	public String serviceLine;

	public DailyTestJobOLD(String hoEmail) {
		this.hoEmail = hoEmail;

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


	@Test
	@Title("Daily Test Job - Create Job and Partimer's Accept/Apply for Jobs")
	// Given
	public void dailyTestJob() throws InterruptedException {

		/******* HO Creates Job *******/

		admin.isAtAdminHomepage();
		admin.logsInWithValidCredentials(hoEmail, "123qwe");
		ho.shouldSeePageTitle("ArrowMii - Dashboard");

		ho.clickJobListings();

		/******* Check if Job already exits and cancel if it exists *******/

		checkIfJobExistsAndCancel();

		/******* Proceed to create new Job *******/
		
		System.out.println("Beginning to Create Job for: " + hoEmail);
		ho.clickCreatNewJob();
		setJobDetails();
		ho.clickPartimercount("2");
		ho.clickPartimerAmount("10");
		// ho.selectEventSupervisor();
		// ho.enterJobInstrAndVideo();
		ho.jobCreatNow();
		ho.jobSubmit();
		ho.shouldSeeMessage("Success! Your New Job Has Been Posted In ArrowMii");
		ho.jobPostVeiw();
		ho.verifyJobMatches("MATCHES (2 + 48)");
		validateCreditSummary();
		//validateJobSummary();
		admin.quitAdminDriver();

		/******* 40 Matched Partimers Accepts Job Offer *******/

		applyForMatchedPartimers();

		/******* 10 UNmatched Partimers Apply for Job Offer *******/

		applyForUnMatchedPartimers();

		/******* HO Approves 3 Partimers out of 10 Partimer Applications  *******/
		
		approveThreeUnmatchedPartimers(3);

		/******* HO Clocks IN /OUT and Reviews all 43 Partimers *******/

		completeJob();
		
		
	}

	private void completeJob() throws InterruptedException {
		admin.isAtAdminHomepage();
		admin.logsInWithValidCredentials(hoEmail, "123qwe");
		ho.shouldSeePageTitle("ArrowMii - Dashboard");
		ho.clickOnJobAttendance();
		ho.searchForJobs("Daily Test Job" + "_" + getTodayDate());
		ho.openJobAttendanceView();
		ho.selectItemsPerPage("100");
		Thread.sleep(5000);
		ho.doBulkClockIn();
		ho.doBulkClockOut();
		ho.reviewAllPartimers();
	}

	/*private void validateJobSummary() {
		
		ho.validateJobBaseInformationAfterJobCreation(getJobTitle(), expectedStartDate, expectedEndDate,
				expectedSchedule, 50, 10, expectedServiceLine, expectedHoName,
				expectedESname, expectedjobDescription, expectedSpecialInstructions, expectedVenue);
		
	}*/

	private void validateCreditSummary() {
		
		String currentCredit = ho.getCurrentCredit();
		int remainingCredit = Integer.parseInt(currentCredit)-150;
		System.out.println("Reamining Credit = "+ remainingCredit);
		ho.validateCreditSummaryAfterJobCreation(remainingCredit, "3", "50", "150");
	}
	
	
	private String partimerPassword = "123qwe";
	
	public String getTodayDate() {
		Calendar calendar = Calendar.getInstance();
		// get a date to represent "today"
		Date today = calendar.getTime();
		//System.out.println("Today: " + today);
		//System.out.println(new SimpleDateFormat("d/M/yyyy").format(today));
		String formattedDateToday = new SimpleDateFormat("d/M/yyyy").format(today);
		return formattedDateToday;
	}

	public String getTomorrowDate() {
		Calendar calendar = Calendar.getInstance();
		// get a date to represent "today"
		Date today = calendar.getTime();
		// add one day to the date/calendar
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		// now get "tomorrow"
		Date tomorrow = calendar.getTime();
		// print out tomorrow's date
		//System.out.println("Tomorrow: " + tomorrow);
		//System.out.println(new SimpleDateFormat("d/M/yyyy").format(tomorrow));
		String formattedDateTomorrow = new SimpleDateFormat("d/M/yyyy").format(tomorrow);
		return formattedDateTomorrow;
	}

	public String getDayAfterTomorrowDate() {
		Calendar calendar = Calendar.getInstance();
		// get a date to represent "today"
		Date today = calendar.getTime();
		// add two days to the date/calendar
		calendar.add(Calendar.DAY_OF_YEAR, 2);
		// now get "tomorrow"
		Date dayAfterTomorrow = calendar.getTime();
		// print out tomorrow's date
		//System.out.println("Day After Tomorrow: " + dayAfterTomorrow);
		//System.out.println(new SimpleDateFormat("d/M/yyyy").format(dayAfterTomorrow));
		String formattedDateDayAfterTomorrow = new SimpleDateFormat("d/M/yyyy").format(dayAfterTomorrow);
		return formattedDateDayAfterTomorrow;
	}
	
	public void checkIfJobExistsAndCancel() {

		if (ho.checkForExistinJobWithSameTitle(getJobTitle())) {
			ho.cancelFirstJobinList();
		}

	}
	
	public void setJobDetails() {

		getJobDetails();
		ho.enterTitle(jobTitle);
		ho.selectDate(startDate, startMonth, "startdate");
		// ho.clickStartDate("14", "5");
		ho.clickStartTime(Integer.parseInt(startTime[0]), startTime[1]);
		ho.selectDate(startDate, startMonth, "enddate");
		// ho.clickEndDate("14", "5");
		ho.clickEndTime(Integer.parseInt(endTime[0]), endTime[1]);

	}
	
	public void applyForMatchedPartimers() {
		 for (int i = 0; i <= 39; i++) { System.out.
			  println("Beginning to Accept Offer for job created by: " + hoEmail +" for Partimer: " +
			  (i + 1));
			  
			  partimerNav.isAtPartimerHomepage();
			  getPartimerLogin(i);
			  partimerNav.navigateToJobOffersByLinkText();
			  partimerNav.selectFirstJob(); 
			  partimerNav.clickApplyForJob();
			  partimerNav.confirmJobApplication(); // Then 
			  partimerNav.shouldSeeText("You Have Successfully Accepted The Matched Job.");
			  //partimerNav.clickToCloseTheSucessfulMessage();
			  partimerNav.quitPartimerDriver();
			  
			  } 
	}
	
	public void applyForUnMatchedPartimers() {
		 for (int i = 50; i <= 59; i++) { System.out.
			  println("Beginning to Apply for job created by: " + hoEmail +" for Partimer: " +
					  (i + 1));
			  
			  partimerNav.isAtPartimerHomepage();
			  getPartimerLogin(i);
			  //partimerNav.navigateToJobOffersByLinkText();
			  partimerNav.navigateToJobMatchLink();
			  partimerNav.navigateToAllJobsTab();
			  partimerNav.searchForJobs(getJobTitle()); 
			  partimerNav.selectFirstJob();
			  partimerNav.clickApplyForJob(); 
			  partimerNav.confirmJobApplication();
			  partimerNav.shouldSeeText("You Have Successfully Applied The Job.");
			  partimerNav.quitPartimerDriver();
			 } 

	}
	
	public void approveThreeUnmatchedPartimers(int numberOfPartimerstoApprove) throws InterruptedException {
		admin.isAtAdminHomepage();
		admin.logsInWithValidCredentials(hoEmail, "123qwe");
		ho.shouldSeePageTitle("ArrowMii - Dashboard");
		ho.clickJobListings();
		ho.searchForJobs(getJobTitle());
		ho.openJob();
		//ho.openJobApplicantsPage();
		ho.clickOnApplicationsTab();
		ho.approvePartimers(numberOfPartimerstoApprove, hoEmail); 
	}
	
	public String getJobTitle() {

		if (hoEmail.equalsIgnoreCase("dailytestjob+ho1@gmail.com")) {
			jobTitle = hoEmail + "_" + "Daily Test Job" + "_" + getTomorrowDate();

		}

		if (hoEmail.equalsIgnoreCase("dailytestjob+ho2@gmail.com")) {
			jobTitle = hoEmail + "_" + "Daily Test Job" + "_" + getDayAfterTomorrowDate();

		}

		return jobTitle;

	}
	
	
	public void getJobDetails() {


		if(hoEmail.equalsIgnoreCase("dailytestjob+ho1@gmail.com"))
		  {
			jobTitle = hoEmail + "_" + "Daily Test Job" + "_" + getTomorrowDate();
			String tomorrowsDate[] = getTomorrowDate().split("/");
			startDate = tomorrowsDate[0];
			startMonth =String.valueOf((Integer.parseInt(tomorrowsDate[1]) - 1));
			endDate = tomorrowsDate[0];
			endMonth = String.valueOf((Integer.parseInt(tomorrowsDate[1]) - 1));
			startTime = new String[]{"3", "PM"};
			endTime = new String[]{"6", "PM"};
			serviceLine = "Daily Job TestServiceLine1";
		  }
		
		/*if(hoEmail.equalsIgnoreCase("dailytestjob+ho2@gmail.com"))
		  {
			jobTitle = hoEmail + "_" + "Daily Test Job" + "_" + getDayAfterTomorrowDate();
			String dayAfterTomorrow[] = getDayAfterTomorrowDate().split("/");
			startDate = dayAfterTomorrow[0];
			startMonth =String.valueOf((Integer.parseInt(dayAfterTomorrow[1]) - 1));
			endDate = dayAfterTomorrow[0];
			endMonth = String.valueOf((Integer.parseInt(dayAfterTomorrow[1]) - 1));
			startTime = new String[]{"7", "PM"};
			endTime = new String[]{"10", "PM"};
			serviceLine = "Daily Job TestServiceLine2";
		  }*/
		
		if(hoEmail.equalsIgnoreCase("dailytestjob+ho2@gmail.com"))
		  {
			jobTitle = hoEmail + "_" + "Daily Test Job" + "_" + getDayAfterTomorrowDate();
			String dayAfterTomorrow[] = getDayAfterTomorrowDate().split("/");
			startDate = "9";
			startMonth =String.valueOf((Integer.parseInt(dayAfterTomorrow[1]) - 1));
			endDate = "9";
			endMonth = String.valueOf((Integer.parseInt(dayAfterTomorrow[1]) - 1));
			startTime = new String[]{"7", "PM"};
			endTime = new String[]{"10", "PM"};
			serviceLine = "Daily Job TestServiceLine2";
		  }
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



	
}
