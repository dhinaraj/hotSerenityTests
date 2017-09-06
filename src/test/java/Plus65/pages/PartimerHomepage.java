package Plus65.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

/**
 * Created by glen on 22/12/16.
 */

//@DefaultUrl("https://uat.arrowmii.com/en/auth/login")
@DefaultUrl("https://staging.arrowmepro.com/en")

public class PartimerHomepage extends PageObject {

	@Override
	public WebDriver getDriver() {
		return super.getDriver();
	}
	
	public void maximizeWindow() {
		getDriver().manage().window().maximize();
	}

	public void clickOnSignInButton() {
		getDriver().findElement(By.xpath("html/body/header/nav/div[1]/div/div[2]/div/div[3]/div/a[2]")).click();
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
		getDriver().manage().window().maximize();
		getDriver().findElement(By.xpath("/html/body/div[1]/div/form/div[6]/div/p[2]/a")).click();
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
	

}
