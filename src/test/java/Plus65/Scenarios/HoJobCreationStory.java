package Plus65.Scenarios;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Plus65.steps.serenity.AdminNavigation;
import Plus65.steps.serenity.HoNavigationPage;
import Plus65.steps.serenity.PartimerNavigation;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class HoJobCreationStory {
	

    @Steps
    HoNavigationPage ho;
    @Steps
    AdminNavigation admin;
    @Steps
	PartimerNavigation partimerNav;
 

    @Managed
    WebDriver browser;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
	LocalDateTime date = LocalDateTime.now();
	String formattedDateToday = dtf.format(date);
	

	
	
	@Test
	@Title("Creating a job application")
	// Given
	public void creatNewJob() throws InterruptedException {
		admin.isAtAdminHomepage();
		admin.logsInWithValidCredentials("rohinithyagarajan1990+ho1@gmail.com", "123qwe");
		ho.shouldSeePageTitle("ArrowMii - Dashboard");

		// When -Create job and verify matched partimers //

		ho.clickJobListings();
		Thread.sleep(30000);
		ho.clickCreatNewJob();
		ho.enterTitle("Job Test Opening-internal");// Enter Job Title
		ho.clickStartDate(formattedDateToday);
		ho.clickStartTime();
		ho.clickEndDate(formattedDateToday);
		ho.clickEndTime();
		ho.clickPartimercount();
		ho.clickPartimerAmount();
		// ho.selectEventSuper();
		ho.enterJobInstrAndVideo();
		ho.jobCreatNow();
		ho.jobSubmit();
		// Then
		ho.shouldSeeMessage("Success! Your Job Has Been Posted In");
		ho.jobPostVeiw();
		ho.verifyJobMatches("Matches (4)"); // check the logic
	}
   

 /** @Test
    @Title ("Cancel a job application")
  //Given 
  
  public void cancelJob() {
	
	admin.isAtAdminHomepage();
	admin.logsInWithValidCredentials("rohinithyagarajan1990+ho1@gmail.com", "1234qwer");
	ho.shouldSeePageTitle("ArrowMii - Dashboard");
	//When
	ho.clickJobListings();
	ho.selectJobCreatedforcancel();
	ho.clickEditJob();
    ho.clickCancel();
  //Then
    ho.clickCancelJob();
    ho.shouldSeeText("Cancelled");
 	
    }
 @Test
 @Title ("Partimer Payment")
//Given 

public void partimerPaymet() {
	
	admin.isAtAdminHomepage();
	admin.logsInWithValidCredentials("prasadqc+ehr@gmail.com", "123qwe");
	ho.shouldSeePageTitle("ArrowMii - Dashboard");
	
	//When
	ho.clickPayPartimer();
	ho.selectCheckbox();
 	ho.selectMarkProcessing();
 	ho.clickOnApply();
 	ho.clickOnProcessingtoConfirm();
 	ho.clickOnProcessing();
 	ho.clickOnCheckboxPaid();
 	ho.selectMarkPaid();
 	ho.clickOnApplyToPay();
 	ho.clickOnPaid();
 	ho.clickPaidAtlast();
 	ho.SeePaidConfirmation("You Have 3 Paid Payments");// each time changes..pls enter the paid count //check
 	
	}*/
}