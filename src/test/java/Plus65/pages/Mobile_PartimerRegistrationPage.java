package Plus65.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Created by Dhinakaran on 09/02/17.
 */


public class Mobile_PartimerRegistrationPage extends PageObject {
	
	@Override
	public WebDriver getDriver() { return super.getDriver();}
	
	public void enterFirstName(String firstName)
	{
		if(MobileDriver.os=="android")
		MobileDriver.driver.findElement(By.xpath("//*[@text='First Name']/../*[@class='android.widget.EditText']")).sendKeys(firstName);
		else
			MobileDriver.driver.findElement(By.xpath("//XCUIElementTypeOther[@name=' First Name']/XCUIElementTypeTextField")).sendKeys(firstName);
	}

	public void enterLastName(String lastName)
	{
		if(MobileDriver.os=="android")
		MobileDriver.driver.findElement(By.xpath("//*[@text='Last Name']/../*[@class='android.widget.EditText']")).sendKeys(lastName);
		else
			MobileDriver.driver.findElement(By.xpath("//XCUIElementTypeOther[@name=' Last Name']/XCUIElementTypeTextField")).sendKeys(lastName);
	}
	
	public void enterEmail(String email)
	{
		if(MobileDriver.os=="android")
		MobileDriver.driver.findElement(By.xpath("//*[@text='Email Address']/../*[@class='android.widget.EditText']")).sendKeys(email);
		else
			MobileDriver.driver.findElement(By.xpath("//XCUIElementTypeOther[@name=' Email Address']/XCUIElementTypeTextField")).sendKeys(email);

	}

	public void enterPassword(String password)
	{
		if(MobileDriver.os=="android")
		 MobileDriver.driver.findElement(By.xpath("//*[@text='Password']/../*[@class='android.widget.EditText']")).sendKeys(password);
		else
			MobileDriver.driver.findElement(By.xpath("//XCUIElementTypeOther[@name=' Password']/XCUIElementTypeSecureTextField")).sendKeys(password);
			
     }
	
	public void enterConfirmationPassword(String password_confirmation)
	{	 
		if(MobileDriver.os=="android")
		{
		  Dimension dimensions = MobileDriver.driver.manage().window().getSize();
	      Double screenHeightStart = dimensions.getHeight() * 0.5;
	      int scrollStart = screenHeightStart.intValue();
	      System.out.println("s="+scrollStart);
	      Double screenHeightEnd = dimensions.getHeight() * 0.2;
	      int scrollEnd = screenHeightEnd.intValue();
	      MobileDriver.driver.swipe(0,scrollStart,0,scrollEnd,2000);
	      try {
			Thread.sleep(6000);
	      } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	      } 
		  MobileDriver.driver.findElement(By.xpath("//*[@text='Confirm Password']/../*[@class='android.widget.EditText']")).sendKeys(password_confirmation);
		}
		else
		{
			MobileDriver.driver.findElement(By.xpath("//XCUIElementTypeOther[@name=' Confirm Password']/XCUIElementTypeSecureTextField")).sendKeys(password_confirmation);
		}
		
	}
	
	public void enterReferralCode(String referral_code) throws InterruptedException
	{
		if(MobileDriver.os=="android")
		MobileDriver.driver.findElement(By.xpath("//*[@text='Referral Code (Optional)']/../*[@class='android.widget.EditText']")).sendKeys(referral_code);
		else
		{
			if(referral_code=="")
				MobileDriver.driver.findElement(By.xpath("//XCUIElementTypeOther[@name=' Referral Code (Optional)']/XCUIElementTypeTextField")).sendKeys(Keys.RETURN);
			else
				MobileDriver.driver.findElement(By.xpath("//XCUIElementTypeOther[@name=' Referral Code (Optional)']/XCUIElementTypeTextField")).sendKeys(referral_code);
			Thread.sleep(1000);
	        JavascriptExecutor js = (JavascriptExecutor) MobileDriver.driver;
	    	HashMap<String, String> scrollObject = new HashMap<String, String>();
	    	scrollObject.put("direction", "down");
	    	js.executeScript("mobile: scroll", scrollObject);
		}
	}
	
	public void clickOnCreateNow() throws InterruptedException
	{	
		if(MobileDriver.os=="android")
		MobileDriver.driver.findElement(By.xpath("//*[@text='CREATE NOW']")).click();
		else
		{
	        MobileDriver.driver.findElement(By.xpath("//XCUIElementTypeOther[@name='  CREATE NOW']")).click();

	        Thread.sleep(5000);
		}
	}
	
	public void clickOnBackToSignIn()
	{
		getDriver().findElement(By.xpath(".//*[@id='registration']/div/div[2]/div/a")).click();
	}
	
	
	public void clickOnRestToLoginNow()
	{
		getDriver().findElement(By.id("login-submit")).click();
	}
	
	
}


	