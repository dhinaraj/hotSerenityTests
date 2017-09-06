package Plus65.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import Plus65.pages.AdminHomepage;
import Plus65.pages.CurrentPage;
import Plus65.pages.JobAttendancePage;
import Plus65.pages.JobCreation;
import Plus65.pages.JobDetailsPage;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class HoNavigationPage {
	
	
	 CurrentPage currentPage;
	 JobCreation jobCreat;
	 JobDetailsPage jobDetails;
	 JobAttendancePage jobAttendance;
	
	@Steps
	    AdminNavigation admin;
	 

	    @Managed
	    WebDriver browser;

	   
 //Create job and verify matched partimers 
	 
	

	@Step
	public void shouldSeePageTitle(String expectedTitle) {
		assertThat(currentPage.getTitle()).isEqualTo(expectedTitle);
		 
	}
	
	@Step
	public void refereshPage() throws InterruptedException {
		jobCreat.refersh();

	}
	

	@Step
	public void clickJobListings() throws InterruptedException {
		jobCreat.clickOnJobListings();

	}

	@Step
	public void clickCreatNewJob() {
		jobCreat.clickOnCreateNewJob();

	}

	@Step
	public void enterTitle(String jobName) {
		jobCreat.enterJobTitle(jobName);// check

	}

	@Step
	public void clickStartDate(String date) {
		// jobCreat.clickOnStartDate();
		jobCreat.selectStartDate(date);

	}

	@Step
	public void clickEndDate(String date) {
		// jobCreat.clickOnEndDate();
		jobCreat.selectEndDate(date);
	}

	
	
	

	@Step
	public void clickStartTime() {
		jobCreat.clickOnStartTime();

	}

	
	
	@Step
	public void selectDate(String date, String month, String whichDateField) {
		jobCreat.selectDate(date, month, whichDateField);

	}
	
	


	@Step
	public void clickEndTime() {
		jobCreat.clickOnEndTime();

	}

	@Step
	public void clickStartTime(int time, String timeOfDay) {
		jobCreat.clickOnStartTime(time, timeOfDay);

	}

	@Step
	public void clickEndTime(int time, String timeOfDay) {
		jobCreat.clickOnEndTime(time, timeOfDay);

	}

	@Step
	public void clickPartimercount() {
		jobCreat.enterNoOfPartimers();// no of partimer

	}

	@Step
	public void clickPartimercount(String partimerCount) {
		jobCreat.enterNoOfPartimers(partimerCount);// no of partimer

	}

	@Step
	public void clickPartimerAmount() {
		jobCreat.enterAmountPerHour();// amount per hour
	}

	@Step
	public void clickPartimerAmount(String amountPerHour) {
		jobCreat.enterAmountPerHour(amountPerHour);// amount per hour
	}

	@Step
	public void selectEventSupervisor() {
		jobCreat.selectEventSupervisor();// amount per hour
	}

	// @Step
	// public void selectEventSuper(){
	// jobCreat.selectEventSupervisor();
	//
	// }
	@Step
	public void enterJobInstrAndVideo() {

		jobCreat.enterJobInstruction();
		jobCreat.UploadVideo();

	}

	@Step
	public void jobCreatNow() {
		jobCreat.jobCreationNow();

	}

	@Step
	public void jobSubmit() {
		jobCreat.jobCreationSubmit();

	}

	@Step
	public void jobPostVeiw() {
		jobCreat.clickOnJobPost();
	}

	@Step
	public void shouldSeeMessage(String expectedMessage) {
		assertThat(jobCreat.shouldSeeMessage(expectedMessage).equals(expectedMessage));
	}

	@Step
	public void verifyJobMatches(String strng) {
		jobCreat.jobMatches(strng);
	}

	// cancel job
	@Step
	public void selectJobCreatedforcancel() {
		jobCreat.selectfirstJobCreatedforcancel();
	}

	@Step
	public void clickEditJob() {
		jobCreat.clickEditofJobCreated();
	}

	@Step
	public void clickCancel() {
		jobCreat.clickCancelEvent();
	}

	@Step
	public void clickCancelJob() {
		jobCreat.clickYesCancelJob();
	}

	@Step
	public void shouldSeeText(String expectedText) {
		assertTrue(currentPage.containsText(expectedText));
	}

	// Partimer Payment
	@Step
	public void clickPayPartimer() {
		jobCreat.clickOnPartimerPayment();
	}

	@Step
	public void selectCheckbox() {
		jobCreat.tickCheckbox();
	}

	@Step
	public void selectMarkProcessing() {
		jobCreat.selectMarkasProcessing();
	}

	@Step
	public void clickOnApply() {
		jobCreat.clickApply();
	}

	@Step
	public void clickOnProcessingtoConfirm() {
		jobCreat.clickMarkasProcessingtoConfirm();
	}

	@Step
	public void clickOnProcessing() {
		jobCreat.clickProcessing();
	}

	@Step
	public void clickOnCheckboxPaid() {
		jobCreat.tickCheckboxPaid();
	}

	@Step
	public void selectMarkPaid() {
		jobCreat.selectMarkasPaid();
	}

	@Step
	public void clickOnApplyToPay() {
		jobCreat.clickApplyforPaying();
	}

	@Step
	public void clickOnPaid() {
		jobCreat.clickPaid();
	}

	@Step
	public void clickPaidAtlast() {
		jobCreat.clickPaidButton();
	}

	@Step
	public void SeePaidConfirmation(String Message) {
		Message = jobCreat.shouldSeePaidConfirmation();
	}

	@Step
	public void approvePartimers(int applicationsApproved, String email) {
		jobDetails.approveSpecfiedNumberOfPartimers(applicationsApproved, email);
	}
	
	@Step
	public void rejectApplications(int applicationsApproved, int rejectedApplications, String email) {
		jobDetails.rejectSepecifiedNumberOfApplications(applicationsApproved, rejectedApplications, email);
	}
	
	@Step
	public void cancelConfirmedPartTimers(int partTimersWithdrawn, int cancelledPartTimers, String email) {
		jobDetails.cancelConfirmedPartTimers(partTimersWithdrawn, cancelledPartTimers, email);
	}

	@Step
	public void searchForJobs(String jobTitle) {
		jobDetails.searchForJob(jobTitle);
	}

	@Step
	public void openJob() {
		jobDetails.openJobView();
	}

	@Step
	public void clickOnApplicationsTab() throws InterruptedException {
		jobDetails.clickOnApplicationsTab();
	}
	
	@Step
	public void clickOnConfirmedPartimersTab() throws InterruptedException {
		jobDetails.clickOnConfirmedPartimersTab();
	}

	@Step
	public void clickOnJobAttendance() throws InterruptedException {
		jobAttendance.clickOnJobAttendance();
		Thread.sleep(10000);
		

	}
	
	@Step
	public void openJobAttendanceView() {
		jobAttendance.openJobAttendanceView();
		

	}
	


	@Step
	public void doBulkClockIn() {
		
			jobAttendance.selectBulkClockIn();


	}

	@Step
	public void doBulkClockOut() {

		jobAttendance.selectBulkClockOut();
	
	}
	
	@Step
	public void doBulkReview() {

		jobAttendance.selectBulkReview();
	
	}
	
	@Step
	public void selectItemsPerPage(String numOfRecords) {

		jobAttendance.selectItemsPerPage(numOfRecords);
	
	}
	
	@Step
	public void reviewAllPartimers() {

		jobAttendance.reviewAllPartimers();
	
	}
	
	@Step
	public boolean checkForExistinJobWithSameTitle(String jobTitle) {
		
		jobDetails.searchForJob(jobTitle);
		boolean isJobPresent = jobCreat.checkElementDisplayedByXpath("html/body/div[4]/div/div[4]/div/div/div/div/div[3]/div/div/div[2]/div[2]/div/div[2]/a/span");
		return isJobPresent;
	
	}
	
	@Step
	public void cancelFirstJobinList() {
		jobDetails.cancelFirstJobInList();
	
	}
	
	@Step
	public void openJobApplicantsPage() {
		jobDetails.openJobApplicantsPage();
	
	}
	
	@Step
	public String getCurrentCredit() {
		String[] currentCredit = jobDetails.getCurrentCredit().split(" ");
		return currentCredit[1];
	}
	
	@Step
	public String validateCreditSummaryAfterJobCreation(int expectedRemainingCredit, String expectedTotalHours, String expectedTotalPartimers, String expectedCreditsToDeduct) {
		//jobDetails.clickOnDetailsTab();
		System.out.println("=======Beginning to Validate Credit Summary=======");
		String jobId = jobDetails.getJobID();
		jobDetails.getJobDetailsTabByLink(jobId);
		String remainingCredit = jobDetails.getRemainingCredit();
		String totalHours = jobDetails.getTotalHours();
		String getTotalPartimers = jobDetails.getTotalPartimers();
		String getTotalCreditsDeducted = jobDetails.getTotalCreditsDeducted();

		System.out.println("Remaining Credit: "+ remainingCredit);
		System.out.println("Total Hours "+ totalHours);
		System.out.println("Total Part Timers: "+ getTotalPartimers);
		System.out.println("Total Credits Deducted: "+ getTotalCreditsDeducted);
		
		assertThat(jobDetails.getRemainingCredit().replaceAll(",", "")).isEqualTo(String.valueOf(expectedRemainingCredit));
		assertThat(jobDetails.getTotalHours()).isEqualTo(expectedTotalHours);
		assertThat(jobDetails.getTotalPartimers()).isEqualTo(expectedTotalPartimers);
		assertThat(jobDetails.getTotalCreditsDeducted()).isEqualTo(expectedCreditsToDeduct);
		
		System.out.println("=======Credit Summary Verified Sucessfully=======");
		return jobId;
	}
	
	@Step
	public String getJobID() {
		
		String jobID = jobDetails.getJobID();
		return jobID;

	}

	@Step
	public void validateJobBaseInformationAfterJobCreation(String expectedJobTitle, String expectedStartDate,
			String expectedEndDate, String expectedSchedule, String expectedPartimerRequested, String expectedRates,
			String expectedServiceLine, String expectedHoName, String expectedESname, String expectedjobDescription,
			String expectedSpecialInstructions, String expectedVenue) {
		
		
		assertThat(jobDetails.getJobTitle()).isEqualTo(expectedJobTitle);
		assertThat(jobDetails.getStartDate()).isEqualTo(expectedStartDate);
		assertThat(jobDetails.getEndDate()).isEqualTo(expectedEndDate);
		assertThat(jobDetails.getSchedule()).isEqualTo(expectedSchedule);

		assertThat(jobDetails.getPartimerRequested()).isEqualTo(expectedPartimerRequested);

		assertThat(jobDetails.getRates()).isEqualTo(expectedRates);
		assertThat(jobDetails.getServiceLine()).isEqualTo(expectedServiceLine);
		assertThat(jobDetails.getHoName()).isEqualTo(expectedHoName);
		assertThat(jobDetails.getEsName()).isEqualTo(expectedESname);
		assertThat(jobDetails.getJobDescription()).isEqualTo(expectedjobDescription);
		assertThat(jobDetails.getSpecialInstruction()).isEqualTo(expectedSpecialInstructions);
		assertThat(jobDetails.getVenue()).isEqualTo(expectedVenue);

	}
	
	@Step
	public void validateFulfilledCount(String expectedFulfilledCount) {
		System.out.println("Job Fulfilment Count Actual:" + jobDetails.getFulfilledCount());
		assertThat(jobDetails.getFulfilledCount()).isEqualTo(expectedFulfilledCount);
		
	}
	
	@Step
	public void validateApplicantCount(String expectedApplicationCount) {
		assertThat(jobDetails.getApplicantCount()).isEqualTo(expectedApplicationCount);
		
	}
	

	 
}
