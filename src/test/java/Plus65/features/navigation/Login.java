package Plus65.features.navigation;

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


public class Login {

    @Steps
    PartimerNavigation bob;

    @Managed
    WebDriver browser;


    @Test
    public void login() {
        //given
        bob.isAtPartimerHomepage();

        //when
        bob.logsInWithValidCredentials();

        //then
        bob.shouldSeePageTitle("ArrowMe - Matched Jobs");

    }

}
