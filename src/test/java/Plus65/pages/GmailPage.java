package Plus65.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.WebDriver;

@DefaultUrl("https://mail.google.com")

public class GmailPage extends PageObject {

	@Override
	public WebDriver getDriver() {
		return super.getDriver();
	}

	public void clickonSignIn() {
		getDriver().manage().window().maximize();
		getDriver().findElement(By.xpath("/html/body/nav/div/a[2]")).click();
	}

	public void enterEmailAddress(String email) {
		getDriver().findElement(By.id("identifierId")).sendKeys(email);
	}

	public void clickOnNextButton() {
		getDriver().findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[2]/form/div[2]/div/div[2]/div[1]/content/span")).click();
	}

	public void enterPassword(String password) {
		getDriver().findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[2]/form/div[2]/div/div/div[1]/div[1]/div/div[1]/div/div[1]/input")).sendKeys(password);
	}

	public void clickonSignInAfterPassword() {
		getDriver().findElement(By.xpath(".//*[@id='passwordNext']/div[2]")).click();
	}

	public void openMail() {
		getDriver().findElement(By.xpath("//span[@id=':31']/b")).click();

	}

	public void verifyRegistation() {
		getDriver().findElement(By.partialLinkText("https://uat.arrowmii.com/auth")).click();

	}
	
	public void clickonResetPassword() {
		  getDriver().findElement(By.partialLinkText("https://uat.arrowmii.com/auth/reset-password")).click();

	}
	

	
	
  

}
