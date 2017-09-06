package Plus65.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Created by Dhinakaran on 09/02/17.
 */


public class PartimerRegistrationPage extends PageObject {
	
	@Override
	public WebDriver getDriver() { return super.getDriver();}
	
	public void enterFirstName(String firstName)
	{
		getDriver().findElement(By.id("first_name")).sendKeys(firstName);	
	}

	public void enterLastName(String lastName)
	{
		getDriver().findElement(By.id("last_name")).sendKeys(lastName);
	}
	
	public void enterEmail(String email)
	{
		getDriver().findElement(By.id("email")).sendKeys(email);
	}

	public void enterPassword(String password)
	{
		getDriver().findElement(By.id("password")).clear();
		getDriver().findElement(By.id("password")).sendKeys(password);

	}
	
	public void enterConfirmationPassword(String password_confirmation)
	{	
		getDriver().findElement(By.id("password_confirmation")).clear();
		getDriver().findElement(By.id("password_confirmation")).sendKeys(password_confirmation);
	}
	
	public void enterReferralCode(String referral_code)
	{
		getDriver().findElement(By.name("referral_code")).sendKeys(referral_code);
	}
	
	public void clickOnCreateNow()
	{
		getDriver().findElement(By.id("register-submit")).click();
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
