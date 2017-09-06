package Plus65.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Created by Dhinakaran on 09/02/17.
 */


public class PartimerOnBoardingPage extends PageObject {
	
	@Override
	public WebDriver getDriver() { return super.getDriver();}
	
	
	/***   Partimer Common Functions ***/

	public String switchToNewWindow()
	{
		String parentWindow = getDriver().getWindowHandle();
		for(String winHandle : getDriver().getWindowHandles()){
			if(!winHandle.equals(parentWindow))
			{
			getDriver().switchTo().window(winHandle);
			}
		}
		
		return parentWindow;
	}
	
	public void closeNewWindowAndReturn(String parentWindow)
	{

			getDriver().close();
			getDriver().switchTo().window(parentWindow);

	}
	
	public boolean checkElementPresentByXpath(String elementId) {
        try {
        	getDriver().findElement(By.xpath(elementId));
            return true;

        } catch (Exception e) {
        	System.out.println("Service Line does not exist");
        	return false;
        }
    }
	
	
	/***   End of common Functions ***/

	public void clickonGetStartedNow()
	{
		getDriver().findElement(By.xpath(".//*[@id='onboarding']/div/div[3]/div/a")).click();
	}
	
	public void skipPhoneVerification()
	{
		getDriver().findElement(By.partialLinkText("Skip For Now")).click();
	}

	public void selectServiceLineCheckBox(String serviceLineName) {
		int i = 1;
		String checkBoxElementName = ".//*[@id='onboarding']/div/div[2]/form/div[1]/div[" + i + "]/span/label";
		boolean isElementPresent = checkElementPresentByXpath(checkBoxElementName);
		boolean isElementClicked = false;

		while (isElementPresent) {
			
			if (getDriver().findElement(By.xpath(checkBoxElementName)).getText().equals(serviceLineName)) {
				getDriver().findElement(By.xpath(checkBoxElementName)).click();
				isElementClicked = true;
				break;
			}
			
			i = i + 1;
			checkBoxElementName = ".//*[@id='onboarding']/div/div[2]/form/div[1]/div[" + i + "]/span/label";
			isElementPresent = checkElementPresentByXpath(checkBoxElementName);
		}
		
		if (!isElementClicked)
		{
			System.out.println("Intended element not found, clicking on the first Service Line");
			getDriver().findElement(By.xpath(".//*[@id='onboarding']/div/div[2]/form/div[1]/div[1]/span/label")).click();
		}
	}
	
	public void selectFirstServiceLine()
	{
		getDriver().findElement(By.xpath(".//*[@id='onboarding']/div/div[2]/form/div[1]/div[1]/span/label")).click();
	}
	
	public void selectSecondServiceLine()
	{
		getDriver().findElement(By.xpath(".//*[@id='onboarding']/div/div[2]/form/div[1]/div[2]/span/label")).click();
	}
	
	public void clickOnNext()
	{
		getDriver().findElement(By.id("save")).click();
	}
	
	
	
}
