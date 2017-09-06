package Plus65.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://staging-admin.arrowmepro.com/accounts")

public class GroupManagement extends PageObject{
	@Override
    public WebDriver getDriver() { return super.getDriver();}
	
	
	public void clickGroups() { 
		getDriver().findElement(By.xpath("//li[4]/ul/li/a")).click();
		getDriver().findElement(By.xpath("//a[contains(text(),'Owning Groups')]")).click();
	}


	public void clickCreateGroup() {
		getDriver().findElement(By.xpath("//a[contains(text(),'Create Group')]")).click();
	}


	public void enterGroupName(String GroupName) {
		getDriver().findElement(By.id("name")).click();
		getDriver().findElement(By.id("name")).sendKeys(GroupName);;
		
	}


	public void selectEnterprise(String EnterpriseName) {
		getDriver().findElement(By.xpath("//input[@value='Select An Enterprise']")).click();
		new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath("//span[contains(text(),'"+EnterpriseName+"')]")));
		
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", getDriver().findElement(By.xpath("//span[contains(text(),'"+EnterpriseName+"')]")));
		
		//(new WebDriverBackedSelenium(getDriver(), getDriver().getCurrentUrl())).click("xpath=//span[contains(text(),'"+EnterpriseName+"')]"); 
		//getDriver().findElement(By.xpath("//span[contains(text(),'"+EnterpriseName+"')]")).click();
		
	}


	


	public void submitGroup() {
		
		getDriver().findElement(By.id("btn-save-group-chain")).click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void viewGroup(String GroupName) {
		getDriver().findElement(By.name("search")).sendKeys(GroupName);
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		assertThat(getDriver().findElement(By.xpath("//div[contains(text(),'"+GroupName+"')]")).isDisplayed());
	}
}

