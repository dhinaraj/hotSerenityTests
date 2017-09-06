package Plus65.steps.serenity;

import Plus65.pages.*;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.constraints.AssertTrue;

/**
 * Created by Dhinakaran on 22/12/16.
 */

public class PartimerNavigation {

	PartimerHomepage partimerHomepage;
	CurrentPage currentPage;
	PartimerNavBar navBar;
	ParitimerJobOffers jobOffers;
	PartimerMyJobs myJobs;
	PartimerRegistrationPage partimerRegistrationPage;
	PartimerOnBoardingPage partimerOnBoarding;
	GmailPage gmailPage;
	PartimerSkillTestPage partimerSkillTest;
	PartimerProfilePage partimerProfile;
	PartimeCalendarPage partimerCalendar;
	PartimerGettingStartedPage gettingStartedPage;

	@Step
	public void isAtPartimerHomepage() {
		partimerHomepage.open();
		partimerHomepage.maximizeWindow();
	}

	@Step
	public void isAtGmailLoginPage() {
		gmailPage.open();
	}

	@Step
	public void logsInWithValidCredentials() {
		partimerHomepage.clickOnSignInButton();
		partimerHomepage.enterEmailAddress();
		partimerHomepage.enterPassword();
		partimerHomepage.clickSignIn();
	}

	@Step
	public void logsInWithValidCredentials(String email, String password) {

				partimerHomepage.clickOnSignInButton();
				partimerHomepage.enterEmailAddress(email);
				partimerHomepage.enterPassword(password);
				partimerHomepage.clickSignIn();

	}

	@Step
	public void shouldSeePageTitle(String expectedTitle) {
		assertTrue(currentPage.getTitle().equals(expectedTitle));
	}

	@Step
	public void shouldSeeText(String expectedText) {
		assertTrue(currentPage.containsText(expectedText));
		System.out.println("Job Sucessfully Applied");
		
	}

	@Step
	public void navigateToJobOffers() {
		navBar.clickOnJobOffers();
	}

	@Step
	public void navigateToJobOffersByLinkText() {
		navBar.clickOnJobOffersByLink();
	}
	
	@Step
	public void navigateToJobMatchLink() {
		navBar.getMatchedJobLink();
	}

	@Step
	public void navigateToAllJobsTab() {
		jobOffers.selectAllJobs();
	}
	
	@Step
	public void searchForJobs(String jobName) {
		jobOffers.searchForJobs(jobName);
	}
	


	@Step
	public void navigateToWatchList() {
		jobOffers.selectWatchList();
	}

	@Step
	public void selectFirstJob() {
		jobOffers.selectFirstInAllJobs();
	}

	@Step
	public void clickApplyForJob() {
		jobOffers.clickApplyForJobButton();
	}
	
	@Step
	public void clickToCloseTheSucessfulMessage() {
		jobOffers.clickToCloseTheSucessfulMessage();
	}

	@Step
	public void clickDeclineOffer() {
		jobOffers.clickDeclineJobButton();
	}

	@Step
	public void confirmJobApplication() {
		jobOffers.clickYesIWantToApply();
	}

	@Step
	public void confirmJobDecline() {
		jobOffers.clickYesIWantToDecline();
	}

	@Step
	// user should see success message after applying for a job
	public void shouldSeeSuccessMessage() {
		assertTrue(currentPage.containsElements(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]")));
		
	}

	@Step
	public void navigateToMyJobs() {
		navBar.clickOnMyJobs();
	}

	@Step
	public void navigateToActiveJobDetails() {
		myJobs.selectFirstInActiveJobs();
	}

	@Step
	public void selectFistUpcomingJobs() {
		myJobs.selectFirstUpcomingJobs();
	}

	@Step
	public void cancelJobApplication() {
		myJobs.clickCancelJobApplicationButton();
	}

	@Step
	public void confirmJobApplicationCancellation() {
		myJobs.confirmCancellation();
	}

	@Step
	public void withdrawJobApplication() {
		myJobs.clickWithDrawJobApplication();
	}

	@Step
	public void confirmJobApplicationWithdrawl() {
		myJobs.confirmJobWithdrawl();
	}

	@Step
	public void navigateToPendingJobsTab() {
		myJobs.clickOnPendingJobsTab();
	}

	@Step
	public void selectFirstPendingJob() {
		myJobs.selectFirstPendingJob();
	}

	@Step
	public void clickOnCreateNewAccountButton() {
		partimerHomepage.clickCreateNewAccountNow();
	}

	@Step
	public void entersNewAccountDetails(String firstName, String lastName, String email, String password,
			String password_confirmation, String referral_code) {
		clickOnCreateNewAccountButton();
		partimerRegistrationPage.enterFirstName(firstName);
		partimerRegistrationPage.enterLastName(lastName);
		partimerRegistrationPage.enterEmail(email);
		partimerRegistrationPage.enterPassword(password);
		partimerRegistrationPage.enterConfirmationPassword(password_confirmation);
		partimerRegistrationPage.enterReferralCode(referral_code);
	}

	@Step
	public void clicksOnCreateNowButton() {
		partimerRegistrationPage.clickOnCreateNow();
	}

	@Step
	public void verifiesPartimerEmailRegistration(String email, String password) throws InterruptedException {
		Thread.sleep(15000);
		gmailPage.enterEmailAddress(email);
		gmailPage.clickOnNextButton();
		gmailPage.enterPassword(password);
		gmailPage.clickonSignInAfterPassword();
		gmailPage.openMail();
		gmailPage.verifyRegistation();

	}

	@Step
	public void resetsPartimersPassword(String email, String password) throws InterruptedException {
		Thread.sleep(15000);
		gmailPage.enterEmailAddress(email);
		gmailPage.clickOnNextButton();
		gmailPage.enterPassword(password);
		gmailPage.clickonSignInAfterPassword();
		gmailPage.openMail();
		gmailPage.clickonResetPassword();

	}

	@Step
	public void partimerLogsInAfterEmailVerification(String serviceLineName1, String serviceLineName2)
			throws InterruptedException {
		partimerOnBoarding.switchToNewWindow();
		partimerOnBoarding.clickonGetStartedNow();
		partimerOnBoarding.skipPhoneVerification();
		partimerOnBoarding.selectServiceLineCheckBox(serviceLineName1);
		partimerOnBoarding.selectServiceLineCheckBox(serviceLineName2);
		/*
		 * partimerOnBoarding.selectFirstServiceLine();
		 * partimerOnBoarding.selectSecondServiceLine();
		 */
		partimerOnBoarding.clickOnNext();
		// partimerOnBoarding.closeNewWindowAndReturn(parentWindow);

	}

	@Step
	public void shouldSeeRequiredFieldsAlert() {

		String firstNameAlert;
		String lastNameAlert;
		String emailAlert;
		String passwordAlert;

		firstNameAlert = currentPage.getDriver()
				.findElement(By.xpath(".//*[@id='registration']/div/form/div[3]/div[1]/div/span")).getText();
		lastNameAlert = currentPage.getDriver()
				.findElement(By.xpath(".//*[@id='registration']/div/form/div[3]/div[2]/div/span")).getText();
		emailAlert = currentPage.getDriver().findElement(By.xpath(".//*[@id='registration']/div/form/div[4]/div/span"))
				.getText();
		passwordAlert = currentPage.getDriver()
				.findElement(By.xpath(".//*[@id='registration']/div/form/div[5]/div[1]/span")).getText();

		assertTrue(firstNameAlert.equals("The first name field is required."));
		assertTrue(lastNameAlert.equals("The last name field is required."));
		assertTrue(emailAlert.equals("The email field is required."));
		assertTrue(passwordAlert.equals("The password field is required."));

	}

	@Step
	public void clickOnSkillTest() {
		navBar.clickOnSkillTest();
	}

	@Step
	public void takeSkillTestForFirstServiceLine() {
		partimerSkillTest.clickOnTakeSkillTestForFirstServiceLine();
		partimerSkillTest.clickOnIAgreeCheckBox();
		partimerSkillTest.clickOnStartExamNow();

	}

	@Step
	public void takeSkillTestForSecondServiceLine() {
		partimerSkillTest.clickOnTakeSkillTestForSecondServiceLine();
		partimerSkillTest.clickOnIAgreeCheckBox();
		partimerSkillTest.clickOnStartExamNow();

	}

	@Step
	public void selectRightAnswers(int NumOfAnswers) {
		for (int i = 1; i <= NumOfAnswers; i++) {
			partimerSkillTest.selectRightAnswer();
			if (i != NumOfAnswers) {
				partimerSkillTest.clikcOnNext();
			}
		}

	}

	@Step
	public void clickOnSubmitMyTest() {
		partimerSkillTest.clikcOnSubmitMyTest();
	}

	@Step
	public void clickOnShowMyResults() {
		partimerSkillTest.clikcOnShowMyResults();
	}

	@Step
	public void clickOnProfileName() throws InterruptedException {
		navBar.clickOnProfileName();
	}

	@Step
	public void clickOnProfileLink() {
		partimerProfile.clickOnProfileLink();
	}

	@Step
	public void clickOnEditProfileIcon() {
		partimerProfile.clickOnEditProfileIcon();
	}

	public void selectWorkedFromDate(String month, String year, String date) {
		partimerProfile.selectMonth(month);
		partimerProfile.selectYear(year);
		partimerProfile.selectStartDate(date);
	}

	public void selectWorkedToDate(String month, String year, String date) {
		partimerProfile.selectMonth(month);
		partimerProfile.selectYear(year);
		partimerProfile.selectEndDate(date);
	}

	public void selectWorkedToDate(String jobName, String enterpriseName, String hoursWorked, String referralEmail) {
	}

	@Step
	public void addWorkExperieceDetails(String jobName, String enterpriseName, String hoursWorked, String referralEmail,
			String startMonth, String startYear, String startDate, String endMonth, String endYear, String endDate) {
		partimerProfile.clickOnAddWorkExperience();
		partimerProfile.enterWhatJob(jobName);
		partimerProfile.enterWhereYouWorked(enterpriseName);
		partimerProfile.clickOnWorkedFrom();
		selectWorkedFromDate(startMonth, startYear, startDate);
		partimerProfile.clickOnWorkedTo();
		selectWorkedToDate(endMonth, endYear, endDate);
		partimerProfile.enterHoursWorked(hoursWorked);
		partimerProfile.enterReferrerEmail(referralEmail);
	}

	@Step
	public void submitWorkExperience() {
		partimerProfile.clickOnSubmit();
	}

	@Step
	public void addWorkEvent(String startDate, String endDate) {
		partimerCalendar.clickOnMyCalenderLink();
		partimerCalendar.clickOnAddEvent();
		partimerCalendar.enterName();
		partimerCalendar.enterNotes();
		partimerCalendar.enterStartDate(startDate);
		partimerCalendar.enterStartTime();
		partimerCalendar.enterEndDate(endDate);
		partimerCalendar.enterEndTime();
		partimerCalendar.clickOnAddEventConfirmation();

	}

	public void clickOnBackToSignIn() {
		partimerRegistrationPage.clickOnBackToSignIn();

	}

	public void clickOnForgotPasswordAndResetPassword(String emailAddress) {
		partimerHomepage.clickOnForgotPassword();
		partimerHomepage.enterEmailAddress(emailAddress);
		partimerHomepage.clickOnResetPasswordButton();
	}

	public void enterNewPasswordForReset(String newPassword, String newPasswordConfirmation) {
		partimerOnBoarding.switchToNewWindow();
		partimerRegistrationPage.enterPassword(newPassword);
		partimerRegistrationPage.enterConfirmationPassword(newPasswordConfirmation);
		partimerRegistrationPage.clickOnRestToLoginNow();
	}

	public void editProfilePageName(String newFirstName, String newLastName, String newNickName) {
		partimerProfile.clickOnEditNameIcon();
		partimerProfile.enterFirstName(newFirstName);
		partimerProfile.enterLastName(newLastName);
		partimerProfile.enterNickName(newNickName);

	}

	public void editProfilePageDOBAndStudentDetails(String dateOfBirth, String schoolName) {
		partimerProfile.clickOnEditDOBIcon();
		partimerProfile.enterDOB(dateOfBirth);
		// partimerProfile.selectStudent();
		partimerProfile.enterSchoolName(schoolName);
	}

	public void editProfilePageAddress(String newAddress) {
		partimerProfile.clickOnEditAddressIcon();
		partimerProfile.enterNewAddress(newAddress);
	}

	public void saveProfilePageChanges() {
		partimerProfile.clickOnSaveProfileChangesButton();
	}

	public void uploadProfilePicture(String filePath) throws AWTException {
		partimerProfile.clickOnUploadProfilePicButton();

		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(50);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void addFirstJobToWatchList() {
		jobOffers.addFirstJobInListToWatchList();
	}

	public void removeFirstJobFromWatchList() {
		jobOffers.removeFirstJobFromWatchList();
	}

	public void updateServiceLines(String serviceLineName) {
		partimerProfile.clickOnUpdateServiceLineButton();
		partimerProfile.selectServiceLineCheckBox(serviceLineName);
		partimerProfile.confirmUpdateServiceLine();
	}

	public void clickOnGettingStartedPageLink() {
		navBar.clickOnGettingStarted();
	}

	public void clickOnProfileInfoTab() {
		gettingStartedPage.clickOnProfileInfoTab();
	}

	public void clickOnAddWorkExperienceLink() {
		gettingStartedPage.clickOnAddAWorkExperience();
	}

	public void clickOnTakeSkillTestLink() {
		gettingStartedPage.clickOntakeASkillTest();
	}

	public void clickOnAddBankAccountLink() {
		gettingStartedPage.clickOnAddBankAccount();
	}

	public void updateProfileInfoFromGettingStartedPage(String bankFirstName, String lastName, String nickName,
			String date, String nric, String address, String postalCode, String studentId, String schoolName) {
		gettingStartedPage.clickOnUpdateProfile();
		gettingStartedPage.enterFirstName(bankFirstName);
		gettingStartedPage.enterLastName(lastName);
		gettingStartedPage.enterNickName(nickName);
		gettingStartedPage.enterDOB(date);
		gettingStartedPage.enterNric(nric);
		gettingStartedPage.enterAddress(address);
		gettingStartedPage.enterPostalCode(postalCode);
		gettingStartedPage.enterStudentId(studentId);
		gettingStartedPage.enterShoolName(schoolName);
		gettingStartedPage.clickOnUpdateButton();
	}

	public void updateEmailNotificationSettings() {
		gettingStartedPage.clickEmailAndNotificationTab();
		gettingStartedPage.clickOnAllEmailNotification();
		gettingStartedPage.clickOnMatchedOfferNotify();
		gettingStartedPage.clickOnUpdateNotificationSettingsButton();
	}

	public void addBankAccountDetails(String bankFirstName, String bankLastName, String bankName,
			String accountNumber) {
		gettingStartedPage.enterBankFirstName(bankFirstName);
		gettingStartedPage.enterBankLastName(bankLastName);
		gettingStartedPage.selectBank(bankName);
		gettingStartedPage.enterBankAccountNumber(accountNumber);
		gettingStartedPage.clickOnBankDetailsUpdateButton();
	}
	
	public void logout() throws InterruptedException {
		navBar.clickOnProfileName();
		navBar.clickOnLogout();
	}
	
	@Step
	public void quitPartimerDriver() {

		partimerHomepage.quitPartimerDriver();
	
	}
	

}
