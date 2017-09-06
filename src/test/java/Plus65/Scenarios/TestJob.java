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

public class TestJob {
	

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
    private String password_confirmation ="1234qwer";
    private String referral_code ="";
    private String gmailEmail ="dhinaplus65testing@gmail.com";
    private String gmailPassword ="casuarina1";
    
    private String defaultPartimerEmail ="partimer@email.com";
    private String defaultPartimerPassword ="123qwe";
  
    
    
    
   
    
    
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
       
    
   

}
