package Plus65.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by glen on 3/1/17.
 */
public class PartimerMyJobs extends PageObject{

    @Override
    public WebDriver getDriver() { return super.getDriver();}

    //Select first job in Active list
    public void selectFirstInActiveJobs()
    {
	try {
		getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/ul[1]/a[1]/li/div")).click();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("No job present for the user/ element could not be found");
		e.printStackTrace();
	}
    }
    
    public void selectFirstUpcomingJobs()
    {
	try {
		getDriver().findElement(By.xpath("html/body/div[1]/div[2]/div/div/div/div[2]/ul[1]/a/li ")).click();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("No job present for the user/ element could not be found");
		e.printStackTrace();
	}
    }
    
       //Cancel application
    public void clickCancelJobApplicationButton() {getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div/a")).click();}

    //Confirm cancellation
    public void confirmCancellation() {getDriver().findElement(By.xpath("html/body/div[1]/div[4]/div/div/div/div[3]/form/div/button[1]")).click();}
    
    //withdraw job application
    public void clickWithDrawJobApplication() {getDriver().findElement(By.linkText("Withdraw Job")).click();}
    
    //confirm Job WithDrawl
    public void confirmJobWithdrawl() {getDriver().findElement(By.id("submit")).click();}
    
    //go to Upcoming Jobs tab
    public void clickOnPendingJobsTab() {getDriver().findElement(By.xpath("html/body/div[1]/div[2]/div/div/div/div[1]/ul/li[2]/a/div")).click();}
    
   //Select First Pending Job
    public void selectFirstPendingJob() {getDriver().findElement(By.xpath("html/body/div[1]/div[2]/div/div/div/div[2]/ul[1]/a[1]/li")).click();}
    
  //Select First Pending Job
    public void addFirstJobInListToWatchList() {getDriver().findElement(By.xpath("html/body/div[1]/div[2]/div/div/div/div[2]/ul[1]/a[1]/li")).click();}
    
    //this is a comment

}
