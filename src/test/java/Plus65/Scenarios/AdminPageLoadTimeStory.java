package Plus65.Scenarios;

import Plus65.steps.serenity.AdminNavigation;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.junit.runners.MethodSorters;

/**
 * Created by glen on 22/12/16.
 */

//@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom(value="TestData/SetupOrg.csv") 

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@RunWith(SerenityRunner.class)
public class AdminPageLoadTimeStory {

    @Steps
    AdminNavigation admin;
 

    @Managed
    WebDriver browser;

    
    @Test
    public void checkPageLoadTimeasArrowmiiAdmin() {

    		admin.checkPageLoadTimeasArrowmiiAdmin();

    }
}
