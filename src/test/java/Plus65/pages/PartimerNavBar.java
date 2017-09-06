package Plus65.pages;

import net.serenitybdd.core.pages.PageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by glen on 22/12/16.
 */
public class PartimerNavBar extends PageObject {

	@Override
	public WebDriver getDriver() {
		return super.getDriver();
	}
	
	public boolean checkElementDisplayedByXpath(String elementId) {

			try {
				boolean is_displayed = getDriver().findElement(By.xpath(elementId)).isDisplayed();
	            return is_displayed;

	        } catch (Exception e) {
	        	return false;
	        }
			
	       }
	
	public boolean checkElementPresentByXpath(String elementId) {

		try {
			getDriver().findElement(By.xpath(elementId));
            return true;

        } catch (Exception e) {
        	return false;
        }
		
       }

	      

	public boolean checkElementPresentBylinkText(String elementId) {
      
   		try {
   			
			getDriver().findElement(By.linkText(elementId));
            return true;


           } catch (Exception e) {
           	return false;
           }
          }
	
	public boolean checkElementPresentByName(String elementId) {
	      
   		try {
   			
			getDriver().findElement(By.name(elementId));
            return true;


           } catch (Exception e) {
           	return false;
           }
          }
       
	
	public void clickOnGettingStarted() {
		getDriver().findElement(By.linkText("Getting Started")).click();
	}

	public void clickOnJobOffers() {
		getDriver().findElement(By.linkText("My Jobs")).click();
	}

	public void clickOnMyJobs() {
		getDriver().findElement(By.linkText("My Jobs")).click();
	}

	public void clickOnJobOffersByLink() {
      boolean isElementPresent  = checkElementDisplayedByXpath( "html/body/div[6]/div/div/div/div[3]/form/div[1]/button");
  
		
		if (isElementPresent)
		{
			getDriver().findElement(By.xpath("html/body/div[6]/div/div/div/div[3]/form/div[1]/button")).click();
		}
		
		getDriver().findElement(By.partialLinkText("Job Offers")).click();
		
		/*if (checkElementPresentByXpath("html/body/header/nav/div/ul[1]/li[1]/a"))
		{
		
			//getDriver().findElement(By.xpath("html/body/header/nav/div/ul[1]/li[2]/a")).click();
		}
		else
		{
			getDriver().findElement(By.xpath("html/body/header/nav/div/ul[1]/li[1]/a")).click();
		}*/
		
	}
	
	public void getMatchedJobLink() {
		 boolean isElementPresent  = checkElementDisplayedByXpath( "html/body/div[6]/div/div/div/div[3]/form/div[1]/button");
		  
			
			if (isElementPresent)
			{
				getDriver().findElement(By.xpath("html/body/div[6]/div/div/div/div[3]/form/div[1]/button")).click();
			}
	     getDriver().navigate().to("http://staging.arrowmepro.com/en/job/match");
			
		}
	
	
	

	public void clickOnSkillTest() {
		getDriver().findElement(By.linkText("Skill Test")).click();
	}

	public void clickOnMyCalendar() {
		getDriver().findElement(By.partialLinkText("My Calendar")).click();
	}

	public void clickOnNotifications() {
		getDriver().findElement(By.xpath(".//*[@id='header']/nav/div/ul[1]/li[6]/a/i")).click();
	}

	public void clickOnLanguage() throws InterruptedException {

		if (getDriver().findElement(By.linkText("Getting Started")).isDisplayed()) {
			getDriver().findElement(By.xpath("html/body/ul/li/div/div")).click();
			Thread.sleep(2000);
			getDriver().findElement(By.xpath(".//*[@id='header']/nav/div/ul[1]/li[7]/a")).click();
		}

		else {
			getDriver().findElement(By.xpath("html/body/ul/li/div/div")).click();
			Thread.sleep(2000);
			getDriver().findElement(By.xpath(".//*[@id='header']/nav/div/ul[1]/li[6]/a")).click();
		}
	}

	public void clickOnProfileName() throws InterruptedException

	{
		//
		boolean isElementPresent  = checkElementPresentBylinkText("Getting Started");
		
		if (isElementPresent) {
			getDriver().findElement(By.xpath("html/body/header/nav/div/ul[1]/li[8]/a")).click();
		}

		else {
			getDriver().findElement(By.xpath("html/body/header/nav/div/ul[1]/li[7]/a")).click();
			
		}
	}
	


	public void clickOnUpdateYourProfile() {
		getDriver().findElement(By.partialLinkText("Update Your Profile")).click();
	}

	public void clickOnAddWorkExperience() {
		getDriver().findElement(By.partialLinkText("Add A Work Experience")).click();
	}

	public void clickOnTakeSkillTest() {
		getDriver().findElement(By.partialLinkText("Take A Skill Test")).click();
	}

	public void clickOnAddBankAccount() {
		getDriver().findElement(By.partialLinkText("Add Bank Account")).click();
	}

	public String getTitle() {
		String pageTitle = getDriver().getTitle();
		return pageTitle;
	}
	
	public void clickOnLogout() {
		getDriver().findElement(By.linkText("Logout")).click();
	}
	
	
}
