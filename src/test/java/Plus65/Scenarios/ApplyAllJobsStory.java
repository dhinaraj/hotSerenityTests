package Plus65.Scenarios;

import Plus65.features.navigation.Login;
import Plus65.steps.serenity.AbstractPage;
import Plus65.steps.serenity.PartimerNavigation;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Plus65.pages.ParitimerJobOffers;

/**
 * Created by glen on 22/12/16.
 */

@RunWith(SerenityRunner.class)

public class ApplyAllJobsStory {





    Login login;
    ParitimerJobOffers jobOffers;
    PartimerNavigation partimerNavigation;





    @Steps
    PartimerNavigation partimer;




    @Managed
    WebDriver browser;


    @Test
    public void applyAllJobs() {

        partimer.isAtPartimerHomepage();

        //login
        partimer.logsInWithValidCredentials();

        //select All Jobs tab
        partimer.navigateToAllJobsTab();

        //select first job in list
        partimer.selectFirstJob();

        //click Apply For Job button
        partimer.clickApplyForJob();

        //Confirm application
        partimer.confirmJobApplication();

        //Verify application sent successfully
        partimer.shouldSeeSuccessMessage();












    }
}
