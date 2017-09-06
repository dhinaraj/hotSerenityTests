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
public class CreateEnterpriseGroupChainassignServiceLine {
	
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

  
    @Test
    
    public void acreateEnterprise()  {
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials(LoginId, LoginPwd);
    	admin.navigateToEnterprises();
    	admin.createEnterprise(EnterpriseName, PIN,EnterpriseType );
    }
    
   
    @Test
    public void bcreateGroup()  {
    	
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials(LoginId, LoginPwd);
    	admin.navigateToGroups();
    	admin.createGroup(GroupName, EnterpriseName );
    }
    
  
    @Test
    public void ccreateChain()  {
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials(LoginId, LoginPwd);
    	admin.navigateToChains();
    	admin.createChain(ChainName, EnterpriseName );
    }
   
    @Test
    public void dcreateServiceLine()  {
    	
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials(LoginId, LoginPwd);
    	admin.navigateToServicLines();
    	admin.createServiceLine(ServiceLineName, ServiceLineMinHours, System.getProperty("user.dir")+ ServiceLineIconPath );
    }
    
    @Test
    public void eassignServiceLine()  {
    	
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials(LoginId, LoginPwd);
    	admin.navigateToEnterprises();
    	admin.assignServiceLine(EnterpriseName, ServiceLineName );
    	}
   
    
}
