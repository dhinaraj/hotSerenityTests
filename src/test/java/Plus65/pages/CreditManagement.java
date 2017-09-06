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

public class CreditManagement extends PageObject{
	@Override
    public WebDriver getDriver() { return super.getDriver();}
	
	public void requestCreditfromHO(String amount) {
		getDriver().findElement(By.xpath("//a[contains(text(),'Request')]")).click();
		getDriver().findElement(By.xpath("//input[@id='amount']")).sendKeys(amount);
		getDriver().findElement(By.id("send-requests-submit")).click();
		try {
			Thread.sleep(2000);
			getDriver().findElement(By.cssSelector("div.flash")).click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void clickCreditManagement() { 
		getDriver().findElement(By.linkText("Credit Management")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void clickManage() {
		getDriver().findElement(By.xpath("//div[2]/div/div/div[2]/div[3]/div[3]/a")).click();
	}


	public void allocateFund() {
		getDriver().findElement(By.xpath("//a[contains(text(),'Allocate')]")).click();
		
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

	public String getCurrentHOCredit() {
		String str = getDriver().findElement(By.xpath("//li[contains(text(),'Credit:')]")).getText();
		str = str.substring(str.indexOf(":")+2, str.length());
		str=str.trim();
		return str;
		
	}
	public void verifyHOCredit(String reqAmount, String currentAmount) {
		String str = getDriver().findElement(By.xpath("//li[contains(text(),'Credit:')]")).getText();
		str = str.substring(str.indexOf(":")+2, str.length());
		str=str.trim();
		assertThat(str.equals(String.valueOf(Integer.parseInt(reqAmount)+Integer.parseInt(currentAmount))));
	}
	
	public String getCurrentHRCredit() {
		String str = getDriver().findElement(By.xpath("//li[contains(text(),'Credit:')]")).getText();
		str = str.substring(str.indexOf(":")+2, str.length());
		str=str.trim();
		return str;
		
	}
	public void verifyHRCredit(String reqAmount, String currentAmount) {
		String str = getDriver().findElement(By.xpath("//li[contains(text(),'Credit:')]")).getText();
		str = str.substring(str.indexOf(":")+2, str.length());
		str=str.trim();
		assertThat(str.equals(String.valueOf(Integer.parseInt(reqAmount)+Integer.parseInt(currentAmount))));
	}

	public void requestCreditfromHR(String amount) {
		getDriver().findElement(By.xpath("//a[contains(text(),'Top Up')]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",getDriver().findElement(By.xpath("//input[@id='corporate-request']")));
		
		getDriver().findElement(By.xpath("//input[@id='credit']")).sendKeys(amount);
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().findElement(By.xpath("//a[contains(text(),'View Transaction')]")).click();
		
	}

	public void clickCredit() {
		getDriver().findElement(By.xpath("//li[5]/ul/li/a")).click();
		getDriver().findElement(By.xpath("//a[contains(text(),'Credit')]")).click();
	}

	public void approveHRCreditReuest(String mailNo) {
		getDriver().findElement(By.xpath("//input[@name='search']")).sendKeys( "FN" + mailNo);;
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		getDriver().findElement(By.xpath("//a[contains(text(),'View')]")).click();
		getDriver().findElement(By.xpath("//a[contains(text(),'Process Invoice')]")).click();
		getDriver().findElement(By.xpath("//a[contains(text(),'Yes')]")).click();
		getDriver().findElement(By.xpath("//a[contains(text(),'Mark As Paid')]")).click();
		getDriver().findElement(By.xpath("//a[contains(text(),'Yes')]")).click();
		assertThat(getDriver().findElement(By.xpath("//a[contains(text(),'Yes')]")).getText().contains("Completed"));
		
	}

	public void clickViewCreditActivities() {
		getDriver().findElement(By.xpath("//a[contains(@href, 'credit-logs')]")).click();
		
	}
}

