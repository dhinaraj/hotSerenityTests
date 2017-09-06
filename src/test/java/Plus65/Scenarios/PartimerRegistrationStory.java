package Plus65.Scenarios;

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

public class PartimerRegistrationStory {
	

	@Steps
	PartimerNavigation partimerNav;
	
    @Managed
    WebDriver browser;
    

	
    private String firstName = "Dhinakaran";
    private String lastName = "Rajkumar";
    private static Random rand = new Random(); 
    private static int value = rand.nextInt(5000); 
    private static String emailAppender = Integer.toString(value);
    private static String email ="dhinaplus65testing+"+emailAppender+"@gmail.com";
    private String password ="1234qwer";
   /* private static String email ="dhinaplus65testing+1837@gmail.com";
    private String password ="1234qwer";*/
    private String password_confirmation ="1234qwer";
    private String referral_code ="";
    private String gmailEmail ="dhinaplus65testing@gmail.com";
    private String gmailPassword ="casuarina1";
    
    /*private String defaultPartimerEmail ="partimer@email.com";
    private String defaultPartimerPassword ="123qwe";*/
  
    
    
    
    @Test
    @Title ("Register new partimer and Login")
    public void validate_A_NewPartimer_Registration_And_Login() throws InterruptedException
    {
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.entersNewAccountDetails(firstName, lastName, email, password, password_confirmation, referral_code);
    	partimerNav.clicksOnCreateNowButton();
    	partimerNav.shouldSeeText("A Confirmation Email Has Been Sent");
    	partimerNav.isAtGmailLoginPage();
    	partimerNav.verifiesPartimerEmailRegistration(gmailEmail, gmailPassword);
    	partimerNav.partimerLogsInAfterEmailVerification("Construction", "Dishwasher");
    	//ThendefaultPartimerEmaildefaultPartimerEmaildefaultPartimerEmail
    	
    	partimerNav.shouldSeePageTitle("ArrowMii - Getting Started");
    }
    
    @Test
    @Title ("Login with no email & password")
    public void validate_Login_With_No_Password() throws InterruptedException
    {
    	String email = "";
    	String noPassword = "";
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.logsInWithValidCredentials(email, noPassword);
    	//Then
    	partimerNav.shouldSeeText("The email field is required.");
    	partimerNav.shouldSeeText("The password field is required.");
    }
    
    
    
    @Test
    @Title ("Login with wrong password")
    public void validate_Login_With_Incorrect_Password() throws InterruptedException
    {
    
    	String incorrectPassword = "wrongPassword";
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.logsInWithValidCredentials(email, incorrectPassword);
    	//Then
    	Thread.sleep(2000);
    	partimerNav.shouldSeeText("Email Or Password Not Found.");
    }
    
    @Test
    @Title ("Login with an unregistred email")
    public void validate_Login_With_Unregistered_Email() throws InterruptedException
    {
    	String email = "test@test.com";
    	String incorrectPassword = "wrongPassword";
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.logsInWithValidCredentials(email, incorrectPassword);
    	//Then
    	Thread.sleep(2000);
    	partimerNav.shouldSeeText("Email Or Password Not Found.");
    }
       
    
    @Test
    @Title ("Forgot Password, Reset Password and Login")
    public void validate_Forgot_Password() throws InterruptedException
    {
    	

    	String newPassword = "1234qwer123";
    	String newPasswordConfirmation = "1234qwer123";
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.clickOnForgotPasswordAndResetPassword(email);
    	partimerNav.shouldSeeText("Password Reset Sent!");
    	partimerNav.isAtGmailLoginPage();
    	partimerNav.resetsPartimersPassword(gmailEmail, gmailPassword);
    	partimerNav.enterNewPasswordForReset(newPassword, newPasswordConfirmation);
    	//Then
    	partimerNav.shouldSeePageTitle("ArrowMii - Matched Jobs");
    	
    }
    
    @Test
    @Title ("Try forgot password for unregistered email")
    public void validate_Forgot_Password_For_Unregistered_Email() throws InterruptedException
    {
    	
    	String email = "test@test.com";

    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.clickOnForgotPasswordAndResetPassword(email);

    	//Then
    	partimerNav.shouldSeeText("The selected email is invalid.");
    	
    }
    
    
    @Test
    @Title ("Click on Back to Sign in page")
    public void validate_BacktoSignIn()
    {
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.clickOnCreateNewAccountButton();
    	partimerNav.clickOnBackToSignIn();
    	//Then
    	partimerNav.shouldSeePageTitle("ArrowMii - Login");
    }
    
    @Test
    @Title ("Create user without filling required fields")
    public void validate_RequiredFields_Partimer_Registarion()
    {
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.entersNewAccountDetails("", "", "", "", "", "");
    	partimerNav.clicksOnCreateNowButton();
    	//Then
    	partimerNav.shouldSeeRequiredFieldsAlert();
    }
    
    
    @Test
    @Title ("Password min requirement validation")
    public void validate_Password_For_Min_Char()
    {
    	
    	String[] invalidPassword = {"pw1","12345678","qwertyui"};
    	
    	for (int i=0; i<invalidPassword.length; i++ )
    	{
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.entersNewAccountDetails(firstName, lastName, email, invalidPassword[i], password_confirmation, referral_code);
    	partimerNav.clicksOnCreateNowButton();
    	//Then
			if (invalidPassword[i].equals("pw1")) {
				partimerNav.shouldSeeText("Your password must be at least 8 characters.");
			} else {
				partimerNav.shouldSeeText("Please include at least a digit and a character.");
    	}
    	}
    }
    
    @Test
    @Title ("Mismatching Password and Confirm Password")
    public void validate_Password_And_ConfirmedPassword_Mismatch()
    {
    	String mismatchingConfirmationPassword = "1234qwer1";
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.entersNewAccountDetails(firstName, lastName, email, password, mismatchingConfirmationPassword, referral_code);
    	partimerNav.clicksOnCreateNowButton();
    	partimerNav.shouldSeeText("The password confirmation does not match.");
    	//Then
    	
    }

}
