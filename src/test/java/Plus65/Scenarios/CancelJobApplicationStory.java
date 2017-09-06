package Plus65.Scenarios;

import Plus65.features.navigation.Login;
import Plus65.pages.PartimerMyJobs;
import Plus65.steps.serenity.PartimerNavigation;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by glen on 3/1/17.
 */

@RunWith(SerenityRunner.class)



public class CancelJobApplicationStory {

    Login login;
    PartimerMyJobs myJobs;


    @Steps
    PartimerNavigation bob;


    @Managed
    WebDriver browser;


    @Test
    public void cancelJobApplication() {

        //
        bob.isAtPartimerHomepage();

        //login
        bob.logsInWithValidCredentials();

        //navigate to My Jobs
        bob.navigateToMyJobs();

        //select first job in list
        bob.navigateToActiveJobDetails();

        //Cancel job application
        bob.cancelJobApplication();

        bob.confirmJobApplicationCancellation();



    }


}
