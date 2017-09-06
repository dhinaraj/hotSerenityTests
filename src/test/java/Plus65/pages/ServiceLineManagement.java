package Plus65.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://staging-admin.arrowmepro.com/accounts")

public class ServiceLineManagement extends PageObject{
	@Override
    public WebDriver getDriver() { return super.getDriver();}
	
	
	public void clickServiceLines()   { 
		getDriver().findElement(By.xpath("//li[5]/ul/li/a")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().findElement(By.xpath("//a[contains(text(),'Service Lines')]")).click();
	}


	public void clickCreateServiceLine()  {
		getDriver().findElement(By.xpath("//a[contains(text(),'Create Service Line')]")).click();
	}


	public void enterServiceLineName(String ServiceLineName)  {
		getDriver().findElement(By.id("name")).click();
		getDriver().findElement(By.id("name")).sendKeys(ServiceLineName);
		
	}
	public void enterMinimumHours(String hrs)  {
		getDriver().findElement(By.name("ml_number_of_hours")).click();
		getDriver().findElement(By.name("ml_number_of_hours")).sendKeys(hrs);
		
	}
	
	public void uploadIcon(String iconPath)   {
//		getDriver().findElement(By.name("icon")).click();
		getDriver().findElement(By.name("icon")).sendKeys(iconPath);
		
	}

	public void submitServiceLine()  {
		getDriver().findElement(By.xpath("//div[2]/div/button")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void viewServiceLine(String ServiceLineName)   {
		getDriver().findElement(By.name("search")).sendKeys(ServiceLineName);
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		assertThat(getDriver().findElement(By.xpath("//td[contains(text(),'"+ServiceLineName+"')]")).isDisplayed());
	}


	public void clickBalanceLink(String balance) {
		getDriver().findElement(By.linkText("Service Lines")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().findElement(By.xpath("//a[contains(text(),'"+balance+"')]")).click();
		
	}


	public void enterAddAmount(String credit) {	
		getDriver().findElement(By.xpath("//input[@name='add_credit']")).sendKeys(credit);
	}


	public void submitAmount() {
		getDriver().findElement(By.xpath("//button[@id='confirm-credit-adjust']")).click();
	}

	public void checkBlanceforServiceLine( String amount) {
		assertThat(getDriver().findElement(By.xpath("//a[contains(text(),'"+amount+"')]")).isDisplayed());
	}


	public void checkCreditActivities(String addamount) {
		assertThat(getDriver().findElement(By.xpath("//td[contains(text(),'An Amount Of "+ addamount +" By')]")).isDisplayed());
	}


	public void enterDeductAmount(String credit) {
		getDriver().findElement(By.xpath("//input[@name='deduct_credit']")).sendKeys(credit);
		
	}
	
	
	
}

