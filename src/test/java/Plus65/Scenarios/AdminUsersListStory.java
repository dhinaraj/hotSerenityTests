package Plus65.Scenarios;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Plus65.steps.serenity.AdminNavigation;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)

public class AdminUsersListStory {

    @Steps
    AdminNavigation admin;
 

    @Managed
    WebDriver browser;


    @Test
    
    public void searchAdminandVerifyEdit() {

    	admin.isAtAdminHomepage();

        //login
    	admin.logsInWithValidCredentials("arrowme@email.com", "123qwe");
    	
    	admin.navigateToUsers();
    	
    	admin.searchUser("testautomation");
    	
    	admin.clickEditUser();
    	
    	admin.editUserDeatils();
    	
    	admin.searchUser("testautomation");
    	
    	admin.verifyUpdatedUserDetails();
    	
    	admin.clickEditUser();
    	
    	admin.editUserDeatilsBack();
    }

    @Test

    public void searchAdminandVerifyDelete() {

    	admin.isAtAdminHomepage();

        //login
    	admin.logsInWithValidCredentials("arrowme@email.com", "123qwe");
    	
    	admin.navigateToUsers();
    	
    	admin.searchUser("testautomation");
    	
    	admin.deleteUser("testautomation");
    	
    	    	   	
    	admin.verifyUserDeleted();
    }

    
    
    @Test

    public void searchAdminandVerifyRestore() {

    	admin.isAtAdminHomepage();

        //login
    	admin.logsInWithValidCredentials("arrowme@email.com", "123qwe");
    	
    	admin.navigateToUsers();
    	
    	admin.searchUser("testautomation");
    	
    	admin.deleteUser("testautomation");
    	 	    	   	
    	    	
    	admin.restoreUser();
    	
    	admin.verifyUserRestored();
    }
    
}
