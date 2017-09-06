package Plus65.Scenarios;

import Plus65.steps.serenity.AdminNavigation;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
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
public class CreditStory {
	
    @Steps
    AdminNavigation admin;
 

    @Managed
    WebDriver browser;
    
	private String ChainName;
	private String EnterpriseName;
	private String PIN;
	private String EnterpriseType;
	private String GroupName;
	private String LoginId;
	private String LoginPwd;
	private String ServiceLineMinHours;
	private String ServiceLineIconPath;
	private String ServiceLineName;
	private String MailNo;

  
    @Test
    
    public void aabServiceLineCreditRequestandApproval ()  {
    	String currentHOCredit;
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials("testautomation65+hiringofficer"+MailNo+"@gmail.com", LoginPwd);
    	currentHOCredit=admin.getCurrentHOCredit();
    	admin.requestCreditfromHO("100");
    	admin.logout();
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials("testautomation65+enterprise"+MailNo+"@gmail.com", LoginPwd);
    	admin.approveHOCreditReuest("100");
    	admin.logout();
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials("testautomation65+hiringofficer"+MailNo+"@gmail.com", LoginPwd);
    	admin.verifyHOCredit("100",currentHOCredit);
    }
    

    @Test
    public void aaaEnterpriseCreditRequestandApproval ()  {
    	String currentHRCredit;
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials("testautomation65+enterprise"+MailNo+"@gmail.com", LoginPwd);
    	currentHRCredit=admin.getCurrentHRCredit();
    	admin.requestCreditfromHR("100");
    	admin.logout();
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials(LoginId, LoginPwd);
    	admin.approveHRCreditReuest("100", MailNo);
    	admin.logout();
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials("testautomation65+enterprise"+MailNo+"@gmail.com", LoginPwd);
    	admin.verifyHRCredit("100",currentHRCredit);
    }
    
    @Test
    public void AddCreditandverify()  {
    	String beforeHOCredit;
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials("testautomation65+hiringofficer"+MailNo+"@gmail.com", LoginPwd);
    	beforeHOCredit=admin.getCurrentHOCredit();
    	admin.logout();
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials("testautomation65+enterprise"+MailNo+"@gmail.com", LoginPwd);
    	
    	admin.addCredit(beforeHOCredit,  "100");
    	admin.verifyCreditIsAdded(beforeHOCredit,  "100");
    	admin.logout();
    	String afterHOCredit;
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials("testautomation65+hiringofficer"+MailNo+"@gmail.com", LoginPwd);
    	afterHOCredit=admin.getCurrentHOCredit();
    	admin.verifyCreditIsAddedwithHOLogin( afterHOCredit,  String.valueOf((Integer.parseInt(beforeHOCredit)+Integer.parseInt("100"))));
    }
    
    @Test
    public void DeductCreditandverify()  {
    	String beforeHOCredit;
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials("testautomation65+hiringofficer"+MailNo+"@gmail.com", LoginPwd);
    	beforeHOCredit=admin.getCurrentHOCredit();
    	admin.logout();
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials("testautomation65+enterprise"+MailNo+"@gmail.com", LoginPwd);
    	
    	admin.deductCredit(beforeHOCredit,  "100");
    	admin.verifyCreditIsDeducted(beforeHOCredit,  "100");
    	admin.logout();
    	String afterHOCredit;
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials("testautomation65+hiringofficer"+MailNo+"@gmail.com", LoginPwd);
    	afterHOCredit=admin.getCurrentHOCredit();
    	admin.verifyCreditIsAddedwithHOLogin( afterHOCredit,  String.valueOf((Integer.parseInt(beforeHOCredit)-Integer.parseInt("100"))));
    }
    
    
}
