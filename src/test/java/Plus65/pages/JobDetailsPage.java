package Plus65.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.List;

import org.jruby.RubyProcess.Sys;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;


/**
 * Created by Dhinakaran
 */

@DefaultUrl("http://staging-admin.arrowmepro.com/en/auth/login")

public class JobDetailsPage extends PageObject {
	public WebDriver getDriver() {
		super.setImplicitTimeout(20, TimeUnit.SECONDS);
		return super.getDriver();

	}
	
	
	public boolean checkElementPresentByXpath(String elementId) {
        try {
        	getDriver().findElement(By.xpath(elementId));
            return true;

        } catch (Exception e) {
        	return false;
        }
    }
	
	public boolean checkElementDisplayedByXpath(String elementId) {
        try {
        	boolean is_displayed = getDriver().findElement(By.xpath(elementId)).isDisplayed();
            return is_displayed;

        } catch (Exception e) {
        	return false;
        }
    }
	

	public void searchForJob(String jobTitle) {
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div/div/div/div/div[1]/form/div[2]/div[1]/input"))
				.clear();
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div/div/div/div/div[1]/form/div[2]/div[1]/input"))
				.sendKeys(jobTitle);
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div/div/div/div/div[1]/form/div[2]/div[1]/input"))
				.sendKeys(Keys.ENTER);
	}

	public void openJobView() {
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div/div/div/div/div[3]/div/div/div[2]/div[2]/div/div[2]/a/span")).click();

	}

	public void clickOnApplicationsTab() throws InterruptedException {
		getDriver().navigate().refresh();
		//getDriver().findElement(By.partialLinkText("Applicants")).click();
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[3]/div/div/ul/li[4]/a")).click();
		Thread.sleep(5000);

	}
	
	public void openJobApplicantsPage() {
		String jobUrl = getDriver().getCurrentUrl();
		getDriver().navigate().to(jobUrl+"?tab=applications-tab");
		

	}

	public void selectPartimerCheckbox(String partimerNumber) {
		getDriver().navigate().refresh();

		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		
		if(Integer.parseInt(partimerNumber)>5)
		{
		String partTimerPreviousCheckBox = String.valueOf(Integer.parseInt(partimerNumber)-1);
		WebElement partimerCheckBoxTest = getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div/div/div/div[2]/div/div/div[" + partTimerPreviousCheckBox
				+ "]/div[1]/div[1]/label"));
		jse.executeScript("window.scrollTo(0,"+partimerCheckBoxTest.getLocation().y+")");
		}

		WebElement partimerCheckBox = getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div/div/div/div[2]/div/div/div[" + partimerNumber
				+ "]/div[1]/div[1]/label"));
		partimerCheckBox.click();


	}

	public void openActionsListPopup(String partimerNumber) {

		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div/div/div/div[2]/div/div/div["+partimerNumber+"]/div[4]/div/i")).click();


	}
	
	public void clickOnApprove(String partimerNumber) {

		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div/div/div/div[2]/div/div/div["+ partimerNumber + "]/div[4]/div/div/div/a[3]/div")).click();

	}
	
	public void clickOnDecline(String partimerNumber) {

		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div/div/div/div[2]/div/div/div["+ partimerNumber + "]/div[4]/div/div/div/a[4]/div")).click();
		

	}
	
	public void clickOnCancel(String partimerNumber) {

		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div/div/div/div[2]/div/div/div["+ partimerNumber + "]/div[4]/div/div/div/a[2]/div")).click();
		

	}
	


	public void approveSpecfiedNumberOfPartimers(int applicationsApproved, String hoEmail) {
		for(int i =1; i<=applicationsApproved; i++)
		{
			System.out.println("Beginnging to Approve Partimer: " + i + "- for Job created by: "+ hoEmail);
			selectPartimerCheckbox(String.valueOf(i));
			openActionsListPopup(String.valueOf(i));
			clickOnApprove(String.valueOf(i));
			System.out.println("Partimer Approved Sucessfully");
		}
		
	}
	 
	
	public void cancelFirstJobInList() {
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div/div/div/div/div[3]/div/div/div[2]/div[6]/div/i")).click();
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div/div/div/div/div[3]/div/div/div[2]/div[6]/div/div/div/a[2]/div")).click();
		getDriver().findElement(By.xpath("html/body/div[2]/div/div/div[2]/div[2]/div/a")).click();

	}
	
	public String getCurrentCredit() {
		String currentCredit = getDriver().findElement(By.xpath(".//*[@id='nav-right']/li[1]")).getText();
		return currentCredit;

	}
	
	
	
	public String getRemainingCredit() {
		String remainingCredit = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[1]/div[2]/div/div[1]/div[2]")).getText();
		return remainingCredit;
		

	}
	
	public String getTotalHours() {
		String totalHours = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[1]/div[2]/div/div[3]/div[2]")).getText();
		return totalHours;

	}
	
	public String getTotalPartimers() {
		String totalPartimers = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[1]/div[2]/div/div[5]/div[2]")).getText();
		return totalPartimers;

	}
	
	public String getTotalCreditsDeducted() {
		 String totalCreditsDeducted = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[1]/div[2]/div/div[7]/div")).getText();
		 return totalCreditsDeducted;
	}
	
	public String getJobTitle() {
		 String jobTitle = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[1]/div[1]/div/div[1]/div[2]")).getText();
		 return jobTitle;
	}
	
	public String getStartDate() {
		 String startDate = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[1]/div[1]/div/div[3]/div[2]")).getText();
		 return startDate;
	}
	
	public String getEndDate() {
		 String endDate = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[1]/div[1]/div/div[5]/div[2]")).getText();
		 return endDate;
	}
	
	public String getSchedule() {
		 String schedule = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[1]/div[1]/div/div[7]/div[2]")).getText();
		 return schedule;
	}
	
	public String getPartimerRequested() {
		 String partTimerRequested = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[1]/div[1]/div/div[9]/div[2]")).getText();
		 return partTimerRequested;
	}
	
	public String getPartTimerFilled() {
		 String partimerFilled = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[1]/div[1]/div/div[11]/div[2]")).getText();
		 return partimerFilled;
	}
	
	public String getRates() {
		 String rates = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[1]/div[1]/div/div[13]/div[2]")).getText();
		 return rates;
	}
	
	public String getServiceLine() {
		 String serviceLine = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[2]/div/div/div[1]/div/div[1]/div[2]")).getText();
		 return serviceLine;
	}
	
	
	public String getHoName() {
		 String hoName = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/a")).getText();
		 return hoName;
	}
	
	public String getEsName() {
		 String esName = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[2]/div/div/div[3]/div[1]/div[1]/div[2]/a")).getText();
		 return esName;
	}
	
	public String getJobDescription() {
		 String jobDesc = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[2]/div/div/div[4]/div[2]")).getText();
		 return jobDesc;
	}
	
	public String getSpecialInstruction() {
		 String specialIns = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[2]/div/div/div[6]/div[2]")).getText();
		 return specialIns;
	}
	
	public String getVenue() {
		 String venue = getDriver().findElement(By.xpath(".//*[@id='details-tab']/div[2]/div/div/div[2]/div[2]/div[1]/div[2]")).getText();
		 return venue;
	}

	public String getJobVideo() {
		 String venue = getDriver().findElement(By.xpath(".//*[@id='training-video-1-btn']")).getText();
		 return venue;
	}
	
	public String getFulfilledCount() {
		 getDriver().navigate().refresh();
		 String fulfilledCount = getDriver().findElement(By.xpath("html/body/div[4]/div/div[2]/div/div[4]/h5/strong")).getText();
		 return fulfilledCount;
	}
	
	public String getApplicantCount() {
		 String applicantCount = getDriver().findElement(By.xpath("html/body/div[4]/div/div[3]/div/div/ul/li[4]/a")).getText();
		 return applicantCount;
	}
	
	public void clickOnDetailsTab() {
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[3]/div/div/ul/li[1]/a")).click();

	}
	
	public String getJobID() {
		String jobID =  getDriver().findElement(By.xpath("html/body/div[4]/div/div[2]/div/div[2]/div[3]/span[4]")).getText();
		System.out.println("Job ID: = " + jobID);
		return jobID;

	}
	
	
	public void getJobDetailsTabByLink(String jobID) {
		getDriver().get("http://staging-admin.arrowmepro.com/en/job/listings/"+jobID+"/view?tab=details-tab");
		

	}
	
	
	public void rejectSepecifiedNumberOfApplications(int applicationsApproved, int rejectedApplications, String hoEmail) {
		for(int i =applicationsApproved+1; i<=applicationsApproved+rejectedApplications; i++)
		{
			System.out.println("Beginnging to Reject Partimer: " + i + "- for Job created by: "+ hoEmail);
			selectPartimerCheckbox(String.valueOf(i));
			openActionsListPopup(String.valueOf(i));
			clickOnDecline(String.valueOf(i));
			System.out.println("Partimer Rejected Sucessfully");
		}
		
	}


	public void clickOnConfirmedPartimersTab() throws InterruptedException {
		getDriver().navigate().refresh();
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[3]/div/div/ul/li[2]/a")).click();
		Thread.sleep(5000);
		
	}


	public void cancelConfirmedPartTimers(int partTimersWithdrawn, int cancelledPartTimers, String hoEmail) {
		
		
		
		for(int i =partTimersWithdrawn+1; i<=partTimersWithdrawn+cancelledPartTimers; i++)
		
		{
			System.out.println("Beginnging to cancel Confirmed Partimer: " + i + "- for Job created by: "+ hoEmail);
			selectPartimerCheckbox(String.valueOf(i));
			openActionsListPopup(String.valueOf(i));
			clickOnCancel(String.valueOf(i));
			System.out.println("Partimer Cancelled Sucessfully");
		}
		
	}
	

	
		
		
}