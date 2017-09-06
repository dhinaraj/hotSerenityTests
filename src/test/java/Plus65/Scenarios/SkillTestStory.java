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
public class SkillTestStory {
	
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
    public void AddQuestionsToSkillTestandPublish ()  {
    	admin.isAtAdminHomepage();
    	admin.logsInWithValidCredentials(LoginId, LoginPwd);
    	admin.addQuestions(ServiceLineName,1);
    	admin.saveQuestions();
    	admin.publish();
    	admin.addQuestions(ServiceLineName,2);
    	admin.saveQuestions();
    	admin.publish();
    	admin.addQuestions(ServiceLineName,3);
    	admin.saveQuestions();
    	admin.publish();
    }
    

 
    
}
