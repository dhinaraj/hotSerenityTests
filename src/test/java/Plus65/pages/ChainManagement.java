package Plus65.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://staging-admin.arrowmepro.com/accounts")

public class ChainManagement extends PageObject{
	@Override
    public WebDriver getDriver() { return super.getDriver();}
	
	
	public void clickChains() { 
		getDriver().findElement(By.xpath("//li[4]/ul/li/a")).click();
		getDriver().findElement(By.xpath("//a[contains(text(),'Corporate Chains')]")).click();
	}


	public void clickCreateChain() {
		getDriver().findElement(By.xpath("//a[contains(text(),'Create Chain')]")).click();
	}


	public void enterChainName(String ChainName) {
		getDriver().findElement(By.id("name")).click();
		getDriver().findElement(By.id("name")).sendKeys(ChainName);;
		
	}


	public void selectEnterprise(String EnterpriseName) {
		getDriver().findElement(By.xpath("//input[@value='Select An Enterprise']")).click();
		new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath("//span[contains(text(),'"+EnterpriseName+"')]")));
		//getDriver().findElement(By.xpath("//span[contains(text(),'"+EnterpriseName+"')]")).click();
		
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", getDriver().findElement(By.xpath("//span[contains(text(),'"+EnterpriseName+"')]")));
		
	}


	


	public void submitChain() {
		
		getDriver().findElement(By.id("btn-save-group-chain")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void viewChain(String ChainName) {
		getDriver().findElement(By.name("search")).sendKeys(ChainName);
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		assertThat(getDriver().findElement(By.xpath("//div[contains(text(),'"+ChainName+"')]")).isDisplayed());
	}
}

