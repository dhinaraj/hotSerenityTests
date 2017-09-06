package Plus65.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


/**
 * Created by glen on 23/12/16.
 */
public class ParitimerJobOffers extends PageObject {


    @Override
    public WebDriver getDriver() { return super.getDriver();}

    //click All Jobs tab
    public void selectAllJobs() { getDriver().findElement(By.xpath("html/body/div[1]/div[2]/div/div/div/ul/li[2]/a/div")).click();}
    
    
 

    //Select first job in All Jobs list
    public void selectFirstInAllJobs() { 
    	
    	try {
			getDriver().findElement(By.xpath("html/body/div[1]/div[2]/div/div/div/div[2]/ul/a/li")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No job present for the user/ element could not be found");
			e.printStackTrace();
		}}

    
    //Click Apply For Job button
    public void clickApplyForJobButton() { getDriver().findElement(By.xpath("html/body/div[1]/div[2]/div[1]/div/div[2]/div/div/div[4]/button")).click();}

    //Confirm application
    public void clickYesIWantToApply() { getDriver().findElement(By.xpath("html/body/div[1]/div[4]/div/div/div/div[3]/form/div/button[1]")).click();}
    
    public void clickToCloseTheSucessfulMessage() { getDriver().findElement(By.xpath("html/body/ul/li/div/div/span/div/div")).click();


	}
    
    

    //Click Decline For Job button
    public void clickDeclineJobButton() { getDriver().findElement(By.xpath("html/body/div[1]/div[2]/div[1]/div/div[2]/div/div/div[4]/button[2]")).click();}
   
    //Confirm Job Decline
    public void clickYesIWantToDecline() { getDriver().findElement(By.xpath("html/body/div[1]/div[4]/div/div/div/div[3]/form/div/button[1]")).click();}
  
	public void addFirstJobInListToWatchList() {
		try {

			getDriver().findElement(By.xpath("html/body/div[1]/div[2]/div/div/div/div[2]/ul/a[1]/li/div/div[2]/div/div[1]/div/i")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No job present for the user/ element could not be found");
			e.printStackTrace();
		}

	}

	public void selectWatchList() {

		getDriver().findElement(By.xpath("//li[3]/a/div")).click();

	}

	public void removeFirstJobFromWatchList() {
		
		try {

			getDriver().findElement(By.xpath("html/body/div[1]/div[2]/div/div/div/div[2]/ul/a/li/div/div[2]/div/div[1]/div/i")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No job present for the user/ element could not be found");
			e.printStackTrace();
		}

		

	}
	
	public void searchForJobs(String jobName)
	{
		getDriver().findElement(By.xpath("html/body/div[1]/div[2]/div/div/div/div[1]/div/div[1]/form/div[1]/div/label")).sendKeys(jobName);
		getDriver().findElement(By.xpath("html/body/div[1]/div[2]/div/div/div/div[1]/div/div[1]/form/div[1]/div/label")).sendKeys(Keys.ENTER);
	}
    
    
   
}
