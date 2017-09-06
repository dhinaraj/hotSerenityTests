package Plus65.Scenarios;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import Plus65.pages.PartimerHomepage;
import Plus65.steps.serenity.PartimerNavigation;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.TestData;

/**
 * Created by Dhinakaran on 09/02/17.
 */

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PartimerOtherStory {

	@Steps
	PartimerNavigation partimerNav;

	@Managed
	WebDriver browser;

	private String firstName = "Dhinakaran PT2";
	private String lastName = "Rajkumar PT2";
	private static Random rand = new Random();
	private static int value = rand.nextInt(5000);
	private static String emailAppender = Integer.toString(value);
	private static String email = "dhinaplus65testing+" + emailAppender + "@gmail.com";
	private static Random rand2 = new Random();
	private static int value2 = rand2.nextInt(5000);
	private static String emailAppender2 = Integer.toString(value2);
	private static String newEmail = "dhinaplus65testing+" + emailAppender2 + "@gmail.com";
	private String password = "1234qwer";
	private String password_confirmation = "1234qwer";
	private String referral_code = "";
	private String invalidPassword = "qwertyui";
	private String gmailEmail = "dhinaplus65testing@gmail.com";
	private String gmailPassword = "casuarina1";

	private String defaultPartimerEmail = "partimer@email.com";
	private String defaultPartimerPassword = "123qwe";

	private String referrerEmail = "dhinaplus65testing@gmail.com.sg";

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
	LocalDateTime date = LocalDateTime.now();
	String formattedDateToday = dtf.format(date);

	@Test
	@Title("Sign up as partimer ")
	public void A_CreatePartimerAndLogin() throws InterruptedException {
		// Given
		partimerNav.isAtPartimerHomepage();
		// When
		partimerNav.entersNewAccountDetails(firstName, lastName, email, password, password_confirmation, referral_code);
		partimerNav.clicksOnCreateNowButton();
		partimerNav.shouldSeeText("A Confirmation Email Has Been Sent");
		partimerNav.isAtGmailLoginPage();
		partimerNav.verifiesPartimerEmailRegistration(gmailEmail, gmailPassword);
		partimerNav.partimerLogsInAfterEmailVerification("Construction", "Dishwasher");
		// Then
		partimerNav.shouldSeePageTitle("ArrowMii - Getting Started");
	}

	/****** Event Tests *****/

	@Test
	@Title("Add event in calendar ")
	public void addPersonalEvent() {
		// Given
		partimerNav.isAtPartimerHomepage();

		// When
		partimerNav.logsInWithValidCredentials("dhinaplus65testing+bfpt1@gmail.com", "1234qwer");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM, yyyy");
		LocalDateTime date = LocalDateTime.now();
		System.out.println("Current Date " + dtf.format(date));
		partimerNav.addWorkEvent(dtf.format(date), dtf.format(date));
		// Then
	}

	/****** Profile Page Tests *****/

	@Test
	@Title("Update Name and Nick Name, Dob, Student details, Pin Code from Profile Page")
	public void updateProfileData() throws InterruptedException {
		// Given
		partimerNav.isAtPartimerHomepage();
		// When
		partimerNav.logsInWithValidCredentials(email, password);

		partimerNav.clickOnProfileName();
		partimerNav.clickOnProfileLink();
		partimerNav.clickOnEditProfileIcon();
		partimerNav.editProfilePageName("Dhinakaran edited", "Rajkumar editied", "Dhina edited");
		partimerNav.saveProfilePageChanges();
		partimerNav.editProfilePageDOBAndStudentDetails(formattedDateToday, "Anna University");
		partimerNav.saveProfilePageChanges();
		partimerNav.editProfilePageAddress("Test New Address");
		partimerNav.saveProfilePageChanges();
		// Then
		partimerNav.shouldSeeText("Dhinakaran edited Rajkumar editied");
		partimerNav.shouldSeeText("My New Address");
		partimerNav.shouldSeeText("Anna University");
	}

	@Test
	@Pending
	@Title("Upload Profile Picture")
	public void uploadProfilePicture() throws InterruptedException, AWTException {
		// Given
		partimerNav.isAtPartimerHomepage();
		// When
		// partimerNav.logsInWithValidCredentials(email, password);
		partimerNav.logsInWithValidCredentials("dhinaplus65testing+4533@gmail.com", "1234qwer");

		partimerNav.clickOnProfileName();
		partimerNav.clickOnProfileLink();
		partimerNav.clickOnEditProfileIcon();
		partimerNav.uploadProfilePicture("/Users/Dhinakaran/Downloads/My Profile Pic.jpg");
		// Then

	}

	@Test
	@Title("Update Service Line")
	public void updateServiceLine() throws InterruptedException, AWTException {
		// Given
		partimerNav.isAtPartimerHomepage();
		// When
		partimerNav.logsInWithValidCredentials(email, password);

		partimerNav.clickOnProfileName();
		partimerNav.clickOnProfileLink();
		partimerNav.clickOnEditProfileIcon();
		partimerNav.updateServiceLines("Gardening");
		// Then
		Thread.sleep(3000);
		partimerNav.shouldSeeText("Gardening");

	}

	@Test
	@Title("Take skill test Level 1")
	public void takeASkillTestLevel1() {
		// Given
		partimerNav.isAtPartimerHomepage();
		// When
		partimerNav.logsInWithValidCredentials(email, password);

		partimerNav.clickOnSkillTest();
		partimerNav.takeSkillTestForFirstServiceLine();
		partimerNav.selectRightAnswers(10);
		partimerNav.clickOnSubmitMyTest();
		partimerNav.shouldSeeText("You Have Successfully Completed");
		partimerNav.shouldSeeText("10 Out Of 10 Questions");
		partimerNav.clickOnShowMyResults();

		// Then
		partimerNav.shouldSeeText("Passed");
	}

	@Test
	@Pending
	@Title("Add work experience")
	public void addWorkExperience() throws InterruptedException {
		// Given
		partimerNav.isAtPartimerHomepage();
		// When
		partimerNav.logsInWithValidCredentials(email, password);

		partimerNav.clickOnProfileName();
		partimerNav.clickOnProfileLink();
		partimerNav.clickOnEditProfileIcon();
		partimerNav.addWorkExperieceDetails("Server", "The Marmaris Hotel, Dubai", "120", referrerEmail, "February",
				"2015", "10", "March", "2015", "10");
		partimerNav.submitWorkExperience();

		// Then
		partimerNav.shouldSeeText("Server (Banquet Server)");
		partimerNav.shouldSeeText("The Marmaris Hotel, Dubai");

	}

	/****** Getting Started Page Tests *****/

	@Test
	@Title("Update Profile (Profile Information, Email Notification Settings) from Getting Started Page")
	public void updateProfileDataFromGettingStartedPage() throws InterruptedException {
		// Given
		partimerNav.isAtPartimerHomepage();
		// When
		partimerNav.logsInWithValidCredentials(email, password);

		partimerNav.clickOnGettingStartedPageLink();
		partimerNav.updateProfileInfoFromGettingStartedPage("Dhinakaran New", "Rajkumar New", "Dhina New",
				formattedDateToday, "GXXX12434T", "MY New 123## ADDRESS IN SINGAPORE", "572234", "StudentId1223",
				"Anna University");
		partimerNav.updateEmailNotificationSettings();
		partimerNav.clickOnProfileInfoTab();

		// Then
		Thread.sleep(2000);
		partimerNav.shouldSeeText("Dhinakaran New");
		partimerNav.shouldSeeText("Rajkumar New");

	}

	@Test
	@Title("Take skill test for 2nd Service Line from Getting Started Page")
	public void takeSkillTestFromGettingStartedPage() {
		// Given
		partimerNav.isAtPartimerHomepage();
		// When
		partimerNav.logsInWithValidCredentials(email, password);

		partimerNav.clickOnGettingStartedPageLink();
		partimerNav.clickOnTakeSkillTestLink();
		partimerNav.takeSkillTestForSecondServiceLine();
		partimerNav.selectRightAnswers(10);
		partimerNav.clickOnSubmitMyTest();
		partimerNav.shouldSeeText("You Have Successfully Completed");
		partimerNav.shouldSeeText("10 Out Of 10 Questions");
		partimerNav.clickOnShowMyResults();

		// Then
		partimerNav.shouldSeeText("Passed");

	}

	@Test
	@Title("Add Bank Account Details")
	public void addBankAccountDetailsFromGettingStartedPage() {
		// Given
		partimerNav.isAtPartimerHomepage();
		// When
		partimerNav.logsInWithValidCredentials(email, password);
		//partimerNav.logsInWithValidCredentials("dhinaplus65testing+4533@gmail.com", "1234qwer");

		partimerNav.clickOnGettingStartedPageLink();
		partimerNav.clickOnAddBankAccountLink();
		partimerNav.addBankAccountDetails(firstName, lastName, "POSB", "1111-11-111");

		// Then
		partimerNav.shouldSeeText("Passed");

	}
	
	

	@Test
	@Title("Change email")
	public void updateEmailAddressAndLoginWithNewEmail() {
		// Given
		partimerNav.isAtPartimerHomepage();
		// When
		partimerNav.logsInWithValidCredentials(email, password);
		//partimerNav.logsInWithValidCredentials("dhinaplus65testing+4533@gmail.com", "1234qwer");

		partimerNav.clickOnGettingStartedPageLink();
		partimerNav.clickOnAddBankAccountLink();
		partimerNav.addBankAccountDetails(firstName, lastName, "POSB", "1111-11-111");

		// Then
		partimerNav.shouldSeeText("Passed");

	}

}
