package Plus65.Scenarios;

import Plus65.steps.serenity.AdminNavigation;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
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

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="TestData/SetupOrg.csv") 

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceLineCreditRequestandapprovalStory  {

    @Steps
    AdminNavigation admin;
 

    @Managed
    WebDriver browser;


	private String LoginId;


	private String LoginPwd;


	private String EnterpriseName;


	private String GroupName;


	private String ServiceLineName;


	private String ChainName;


	private String MailNo;


    @Test
    public void addGroupHRAccount() {
    	
    	admin.isAtAdminHomepage();

        //login
    	admin.logsInWithValidCredentials(LoginId, LoginPwd);
    	
    	admin.navigateToUsers();

    	admin.addAccount("group", EnterpriseName,GroupName,ChainName,ServiceLineName, MailNo);
    	
    	admin.verifyAccountSuccessfullyCreated("group", MailNo);
    	
    	admin.logout();
    	
    	admin.veifyEmailandSetPassword();
    	
    	
    }
}
