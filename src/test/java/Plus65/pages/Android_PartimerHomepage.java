package Plus65.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.TimeOutDuration;

/**
 * Created by glen on 22/12/16.
 */

//@DefaultUrl("https://uat.arrowmii.com/en/auth/login")
@DefaultUrl("https://staging.arrowmepro.com/en")

public class Android_PartimerHomepage extends PageObject {

	@Override
    public WebDriver getDriver() { 
     
		return super.getDriver();
		}
	
	
	
	public void clickOnSignInButton() {
		// To Do
	}

	
	public void enterEmailAddress() {
		getDriver().findElement(By.xpath("//div/form/div[2]/div/input")).sendKeys("shtogdill+pt@gmail.com");
	}

	public void enterPassword() {
		getDriver().findElement(By.xpath("//div/form/div[3]/div/input")).sendKeys("ferret88");
	}

	public void clickSignIn() {
		getDriver().findElement(By.id("login-submit")).click();
	}
	
	
	public void enterEmailAddress(String emailAddress) {
		getDriver().findElement(By.id("email")).clear();
		getDriver().findElement(By.id("email")).sendKeys(emailAddress);
	}

	public void enterPassword(String password) {
		getDriver().findElement(By.id("password")).clear();
	    getDriver().findElement(By.id("password")).sendKeys(password);
	}


	public void clickCreateNewAccountNow() {
		if(MobileDriver.os=="android")
			MobileDriver.driver.findElement(By.xpath("//*[@text='CREATE AN ACCOUNT']")).click();
		else
//			MobileDriver.driver.findElementByAccessibilityId("CREATE AN ACCOUNT").click();
			MobileDriver.driver.findElement(By.name("  CREATE AN ACCOUNT")).click();
	
	}
	
	
	public void clickOnForgotPassword() {
		getDriver().findElement(By.linkText("Forgot Password?")).click();
	}
	
	public void clickOnResetPasswordButton() {
		 getDriver().findElement(By.id("login-submit")).click();;
	}
	
	public void quitPartimerDriver() {
		getDriver().quit();
	}
	
	public void selectStagingEnv() throws InterruptedException
	{
		if(MobileDriver.os=="android")
		{
			AndroidElement version = (AndroidElement) MobileDriver.driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'V')]"));
	        
	        for(int i=1; i<=7; i++)
	        {
	        	TouchAction ta = new TouchAction(MobileDriver.driver);
	        	ta.press(version).release().perform();
	        	
	                try {
	                    Thread.sleep(10);
	                } catch (Exception e1) {
	                }
	        }
	        
	        MobileDriver.driver.findElement(By.xpath("//*[@text='STAGING']")).click(); 
		}
		else
		{
			IOSElement version = (IOSElement) MobileDriver.driver.findElement(By.xpath("//XCUIElementTypeStaticText[starts-with(@name, 'V')]"));
	        for(int i=1; i<=7; i++)
	        {

	        	TouchAction ta = new TouchAction(MobileDriver.driver);
	        	ta.press(version).release().perform();
                Thread.sleep(10);

	        }
	        MobileDriver.driver.findElement(By.xpath("//*[@name='Staging']")).click();
	        Thread.sleep(1000);
		}
		
	}

}
