package Plus65.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import Plus65.pages.AdminHomepage;
import Plus65.pages.ChainManagement;
import Plus65.pages.CreditManagement;
import Plus65.pages.CurrentPage;
import Plus65.pages.EnterpriseManagement;
import Plus65.pages.GroupManagement;
import Plus65.pages.ServiceLineManagement;
import Plus65.pages.SkillTestManagement;
import Plus65.pages.UserManagement;
import net.thucydides.core.annotations.Step;

public class AdminNavigation {

	AdminHomepage adminHomepage;
    CurrentPage currentPage;
    UserManagement umpage;
    EnterpriseManagement empage;
	GroupManagement gmpage;
	ChainManagement cmpage;
	ServiceLineManagement slpage;
    static String updateName;
    CreditManagement crmpage;
	SkillTestManagement stpage;




    @Step
    public void isAtAdminHomepage() {
    	adminHomepage.open();
    }

    @Step
    public void logsInWithValidCredentials(String emial, String pwd){
    	adminHomepage.enterEmailAddress(emial);
    	adminHomepage.enterPassword(pwd);
    	adminHomepage.clickSignIn();
    }

    @Step
    public void shouldSeePageTitle(String expectedTitle){
        assertThat(currentPage.getTitle()).isEqualTo(expectedTitle);
    }
    
    @Step
    public void navigateToUsers() {
    	umpage.clickUsers();
    }
   
    
    @Step
    public void addAccount(String account_type, String EnterpriseName, String GroupName, String ChainName, String ServiceLineName, String mailNo) {
    
    	
    	    	
    	umpage.clickAddNewAccount();
    	umpage.enterFistName(account_type+"FN"+mailNo);
    	umpage.enterLastName(account_type+"LN"+mailNo);
    	umpage.enterEmail("testautomation65+"+ account_type + mailNo +"@gmail.com");
    	umpage.enterPhone("+6561234567");
    	if (account_type.equalsIgnoreCase("group"))
    	{
    		
    		umpage.selectAccountFor("Group HR");
        	umpage.selectGroup(GroupName);
    	}
    	else if(account_type.equalsIgnoreCase("chain"))
    	{
    		
    		umpage.selectAccountFor("Chain HR");
        	umpage.selectChain(ChainName);
    	}
    	else if(account_type.equalsIgnoreCase("enterprise"))
    	{
    		
    		umpage.selectAccountFor("Enterprise HR");
        	umpage.selectEnterprise(EnterpriseName);
    	}
    	else if(account_type.equalsIgnoreCase("hiringofficer"))
    	{
    		
    		umpage.selectAccountFor("Hiring Officer");
        	umpage.selectEnterprise(EnterpriseName);
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	umpage.selectService(ServiceLineName);
    	}
    	else if(account_type.equalsIgnoreCase("eventsupervisor"))
    	{
    		umpage.selectAccountFor("Event Supervisor");
    		umpage.selectEnterprise(EnterpriseName);
    		try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	umpage.selectService(ServiceLineName);
    	}
    	
    	umpage.clickCreate();
    }
    
   
    
    @Step
	public void verifyAccountSuccessfullyCreated(String role, String mailNo) {
    	assertThat(umpage.verifyFirstName(role+"FN"+mailNo));
    	assertThat(umpage.verifyLastName(role+"LN"+mailNo));
    	assertThat(umpage.verifyName("testautomation65+"+ role+ mailNo +"@gmail.com"));
    	assertThat(umpage.verifyPhone("+6561234567"));
    	if(role.equalsIgnoreCase("group"))
    		assertThat(umpage.verifyRole(role + "_hr"));
    	else if(role.equalsIgnoreCase("chain"))
    		assertThat(umpage.verifyRole(role + "_hr"));
    	else if(role.equalsIgnoreCase("enterprise"))
    		assertThat(umpage.verifyRole("hr"));
    	else if(role.equalsIgnoreCase("hiringofficer"))
    		assertThat(umpage.verifyRole("hiring_officer"));
    	else if(role.equalsIgnoreCase("eventsupervisor"))
    		assertThat(umpage.verifyRole("event_supervisor"));
    	
		umpage.clickClose();
	}

    @Step
	public void searchUser(String user) {
		umpage.serachByKeword(user);
		
	}

    @Step
	public void clickEditUser() {
    	umpage.clickEditLink();
		
	}

    @Step
	public void editUserDeatils() {
		updateName=umpage.editName();
		
	}
    
    @Step
	public void editUserDeatilsBack() {
		updateName=umpage.editNameBack();
		
	}

	@Step
	public void verifyUpdatedUserDetails() {
		
		umpage.verifyName(updateName);
		
	}

	@Step
	public void deleteUser(String em){
		updateName=umpage.deleteUser(em);
		
	}

	@Step
	public void verifyUserDeleted() {
		umpage.serachByKeword(updateName);
		assertThat(umpage.verifyName(updateName));
		assertThat(umpage.verifyLink("Restore"));
		umpage.restoreUser();
	}

	@Step
	public void restoreUser() {
		umpage.serachByKeword(updateName);
		umpage.restoreUser();
		
	}

	@Step
	public void verifyUserRestored() {
		umpage.serachByKeword(updateName);
		assertThat(umpage.verifyName(updateName));
		assertThat(umpage.verifyLink("Delete"));
	}
    
	@Step
    public void navigateToEnterprises() {
    	empage.clickEnterprises();
    }
	
	@Step
	public void createEnterprise(String enterprise, String postalCode, String enterpriseType) {
		
		empage.clickAddEnterprise();
		empage.selectEnterpriseType(enterpriseType);
		empage.enterEnterpriseName(enterprise);
		empage.enterBusinessRegistrationNumber("AutoBRN");
		empage.enterDescription("AutoDesc");
		empage.enterPostalCode(postalCode);
		empage.enterLegalEntityName("AutoLEN");
		
		empage.submitEnterprise();
		empage.viewEnterprise();
		
	}
	@Step
	public void navigateToGroups() {
		gmpage.clickGroups();
		
	}

	@Step
	public void createGroup(String groupId, String enterpriseId) {
		gmpage.clickCreateGroup();
		gmpage.enterGroupName( groupId);
		gmpage.selectEnterprise( enterpriseId);
		gmpage.submitGroup();
		gmpage.viewGroup(groupId);
		
	}
	@Step
	public void navigateToChains() {
		cmpage.clickChains();
		
	}
	@Step
	public void createChain(String chainID, String enterpriseId){
		cmpage.clickCreateChain();
		cmpage.enterChainName( chainID);
		cmpage.selectEnterprise( enterpriseId);
		cmpage.submitChain();
		cmpage.viewChain( chainID);
		
	}

	@Step
	public void navigateToServicLines() {
		slpage.clickServiceLines();
		
	}

	@Step
	public void createServiceLine(String slID, String minHrs, String iconPath) {
		slpage.clickCreateServiceLine();
		slpage.enterServiceLineName( slID);
		slpage.enterMinimumHours(minHrs);
		slpage.uploadIcon(iconPath);
		slpage.submitServiceLine();
		slpage.viewServiceLine(slID);
		
	}

	@Step
	public void assignServiceLine(String enterpriseId, String slID){
		empage.openServiceLinesTabinEnterprise(enterpriseId);
		empage.clickAssignServiceLine();
		empage.submitServiceLine(slID);
		empage.verifyServiceLine(slID);
	}

	 @Step
	public void veifyEmailandSetPassword() {
		umpage.logintoMailAccount();
		umpage.ResetPassword();
		
	}

	 @Step
	public void logout() {
		adminHomepage.logout();
		
	}

	 @Step
	public void requestCreditfromHO(String amount) {
		crmpage.requestCreditfromHO(amount);
	}

	 @Step
	public void approveHOCreditReuest(String string) {
		crmpage.clickCreditManagement();
		crmpage.clickManage();
		crmpage.allocateFund();
		
	}

	 @Step
	public String getCurrentHOCredit() {
		return crmpage.getCurrentHOCredit();
		
	}
	 @Step
	public void verifyHOCredit(String reqAmount, String currentAmount ) {
		crmpage.verifyHOCredit(reqAmount, currentAmount);
		
	}
    
	 
	 @Step
		public void requestCreditfromHR(String amount) {
			crmpage.requestCreditfromHR(amount);
		}

		 @Step
		public void approveHRCreditReuest(String string, String mailNo) {
			crmpage.clickCredit();
			crmpage.approveHRCreditReuest(mailNo);
			
		}

		 @Step
		public String getCurrentHRCredit() {
			return crmpage.getCurrentHRCredit();
		}
		 @Step
		public void verifyHRCredit(String reqAmount, String currentAmount ) {
			crmpage.verifyHOCredit(reqAmount, currentAmount);
		}

		@Step
		public void addCredit(String currentBalance, String credit) {
			slpage.clickBalanceLink(currentBalance);
			slpage.enterAddAmount(credit);
			slpage.submitAmount();
		}
		
		@Step
		public void verifyCreditIsAdded(String currentHOCredit, String addamount) {
			slpage.checkBlanceforServiceLine( String.valueOf((Integer.parseInt(currentHOCredit)+Integer.parseInt(addamount))));
			crmpage.clickCreditManagement();
			crmpage.clickViewCreditActivities();
			slpage.checkCreditActivities(addamount);
		}
		
		@Step
		public void verifyCreditIsAddedwithHOLogin( String afterHOCredit, String amount) {
			assertThat(afterHOCredit.equalsIgnoreCase(amount));
		}

		public void deductCredit(String currentBalance, String credit) {
			slpage.clickBalanceLink(currentBalance);
			slpage.enterDeductAmount(credit);
			slpage.submitAmount();
			
		}

		public void verifyCreditIsDeducted(String currentHOCredit, String deductAmount) {
			slpage.checkBlanceforServiceLine( String.valueOf((Integer.parseInt(currentHOCredit)-Integer.parseInt(deductAmount))));
			crmpage.clickCreditManagement();
			crmpage.clickViewCreditActivities();
		}

		public void addQuestions(String serviceLineName, int level) {
			stpage.clickSkillTests();
			stpage.searchOpenSkillTest(serviceLineName,level);
			for(int i=1;i<=10;i++)
			{
				stpage.addQuestion(i);
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void saveQuestions() {
			stpage.clickSave();
			
		}

		public void publish() {
			stpage.clickPublish();
			
		}
		
		@Step
		public void quitAdminDriver() {

			adminHomepage.quitAdminDriver();
		
		}
		
		
		@Step
		 public void checkPageLoadTimeasArrowmiiAdmin() {
			
			adminHomepage.checkPageLoadTimeasArrowmiiAdmin();
			
		}
		
}