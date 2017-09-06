package Plus65.Scenarios;

import static org.junit.Assert.assertTrue;

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

public class PartimerJobApplicationStory {
	
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
    private String invalidPassword="qwertyui";
    private String gmailEmail ="dhinaplus65testing@gmail.com";
    private String gmailPassword ="casuarina1";
    
    private String defaultPartimerEmail ="partimer@email.com";
    private String defaultPartimerPassword ="123qwe";
    
    private String referrerEmail="dhinaplus65testing@gmail.com.sg";
  
    
    @Test
    @Title ("Sign up as partimer ")
    public void A_CreatePartimerAndLogin() throws InterruptedException
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
    	//Then
    	partimerNav.shouldSeePageTitle("ArrowMii - Getting Started");

    	
    }
    
    /*** Matched Jobs Page***/
    
    @Test
    @Title ("Apply for matched job")
    public void applyforMacthedJob()
    {
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	
    	//When
    	partimerNav.logsInWithValidCredentials(defaultPartimerEmail, defaultPartimerPassword);
    	partimerNav.navigateToJobOffersByLinkText();
    	partimerNav.selectFirstJob();
    	partimerNav.clickApplyForJob();
    	partimerNav.confirmJobApplication();
    	//Then
    	partimerNav.shouldSeeText("You Have Successfully Accepted The Matched Job.");
    }
    
    @Test
    @Title ("Withdraw a job Application")
    public void withDrawJobApplication()
    {
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.logsInWithValidCredentials(defaultPartimerEmail, defaultPartimerPassword);
    	partimerNav.navigateToMyJobs();
    	partimerNav.selectFistUpcomingJobs();
    	partimerNav.withdrawJobApplication();
    	partimerNav.confirmJobApplicationWithdrawl();
    	//Then
    	partimerNav.shouldSeeText("You Have Successfully Withdrawn The Job.");	 
    }
    
    @Test
    @Title ("Decline a matched job")
    public void declineMatchedJob() throws InterruptedException
    {
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.logsInWithValidCredentials(defaultPartimerEmail, defaultPartimerPassword);
    	partimerNav.navigateToJobOffersByLinkText();
    	partimerNav.selectFirstJob();
    	partimerNav.clickDeclineOffer();
    	partimerNav.confirmJobDecline();
    	Thread.sleep(2000);
    	//Then
    	partimerNav.shouldSeeText("You Have Successfully Declined The Matched Job.");	 
    }
    
    
    /*** All Jobs Page***/
    
    @Test
    @Title ("Apply for unmatched job")
    public void applyForUnmatchedJob()
    {
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.logsInWithValidCredentials(email, password);
    	partimerNav.navigateToJobOffersByLinkText();
    	partimerNav.navigateToAllJobsTab();
    	partimerNav.selectFirstJob();
    	partimerNav.clickApplyForJob();
    	partimerNav.confirmJobApplication();
    	//Then
    	partimerNav.shouldSeeText("You Have Successfully Applied The Job.");
    }
    
    
    @Test
    @Title ("Cancel a job application")
    public void cancelJobApplication()
    {
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.logsInWithValidCredentials(email, password);
    	partimerNav.navigateToMyJobs();
    	partimerNav.navigateToPendingJobsTab();
    	partimerNav.selectFirstPendingJob();
    	partimerNav.cancelJobApplication();
    	partimerNav.confirmJobApplicationCancellation();

    	//Then
    	partimerNav.shouldSeeText("You Have Successfully Canceled The Job Application.");
    }
    
    @Test
    @Title ("Add a Job to Watch List")
    public void jobAddToWatchList()
    {
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.logsInWithValidCredentials(email, password);
    	partimerNav.navigateToAllJobsTab();
    	partimerNav.addFirstJobToWatchList();
    	partimerNav.navigateToWatchList();
    	//Then
    	partimerNav.shouldSeeText("You Have 1 Job(s) In The Watch List.");
    }
    
    @Test
    @Title ("Remove a Job from Watch List")
    public void removeJobFromWatchList()
    {
    	//Given
    	partimerNav.isAtPartimerHomepage();
    	//When
    	partimerNav.logsInWithValidCredentials(email, password);
    	partimerNav.navigateToWatchList();
    	partimerNav.removeFirstJobFromWatchList();
    	//Then
    
    	partimerNav.shouldSeeText("You Have 0 Job(s) In The Watch List.");
    }
    
    
 	
    
    


}
