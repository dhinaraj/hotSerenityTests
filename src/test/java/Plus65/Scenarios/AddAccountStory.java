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
public class AddAccountStory {

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
    	try{
    	admin.isAtAdminHomepage();

        //login
    	admin.logsInWithValidCredentials(LoginId, LoginPwd);
    	
    	admin.navigateToUsers();

    	admin.addAccount("group", EnterpriseName,GroupName,ChainName,ServiceLineName, MailNo);
    	
    	admin.verifyAccountSuccessfullyCreated("group", MailNo);
    	
    	admin.logout();
    	
    	admin.veifyEmailandSetPassword();
    	
    	
    	
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
    
    
    @Test
    public void addChainHRAccount() {
    	try{
    	admin.isAtAdminHomepage();

        //login
    	admin.logsInWithValidCredentials(LoginId, LoginPwd);
    	
    	admin.navigateToUsers();
    	
    	admin.addAccount("chain",EnterpriseName,GroupName,ChainName,ServiceLineName, MailNo);
    	
    	admin.verifyAccountSuccessfullyCreated("chain", MailNo);
    	
    	admin.logout();
    	
    	admin.veifyEmailandSetPassword();
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
    
    @Test
    public void addEnterpriseHRAccount() {
    	try{
    	admin.isAtAdminHomepage();

        //login
    	admin.logsInWithValidCredentials(LoginId, LoginPwd);
    	
    	admin.navigateToUsers();
    	
    	admin.addAccount("enterprise",EnterpriseName,GroupName,ChainName,ServiceLineName, MailNo);
    	
    	admin.verifyAccountSuccessfullyCreated("enterprise", MailNo);
    	admin.logout();
    	
    	admin.veifyEmailandSetPassword();
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
    
    @Test
    public void addHiringOfficerAccount() {
    	try{
    	admin.isAtAdminHomepage();

        //login
    	admin.logsInWithValidCredentials(LoginId, LoginPwd);

    	admin.navigateToUsers();
    	
    	admin.addAccount("hiringofficer",EnterpriseName,GroupName,ChainName,ServiceLineName, MailNo);
    	
    	admin.verifyAccountSuccessfullyCreated("hiringofficer", MailNo);
    	admin.logout();
    	
    	admin.veifyEmailandSetPassword();
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
    
    @Test
    public void addEventSupervisorAccount() {
    	try{
	    	admin.isAtAdminHomepage();
	
	        //login
	    	admin.logsInWithValidCredentials(LoginId, LoginPwd);
	
	    	admin.navigateToUsers();
	    	
	    	admin.addAccount("eventsupervisor",EnterpriseName,GroupName,ChainName,ServiceLineName, MailNo);
	    	
	    	admin.verifyAccountSuccessfullyCreated("eventsupervisor", MailNo);
	    	admin.logout();
	    	
	    	admin.veifyEmailandSetPassword();
    	
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
}
