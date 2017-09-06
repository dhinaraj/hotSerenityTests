package Plus65.pages;

import java.math.BigDecimal;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import static org.assertj.core.api.Assertions.assertThat;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://staging-admin.arrowmepro.com/accounts")

public class EnterpriseManagement extends PageObject{
	@Override
    public WebDriver getDriver() { return super.getDriver();}
	
	
	public void clickEnterprises()   { getDriver().findElement(By.linkText("Enterprises")).click();}


	public void clickAddEnterprise()   {
		getDriver().findElement(By.xpath("//a[contains(text(),'Add Enterprise')]")).click();
	}


	public void enterEnterpriseName(String EnterpriseName)  {
		getDriver().findElement(By.id("name")).click();
		getDriver().findElement(By.id("name")).sendKeys(EnterpriseName);;
		
	}


	public void enterBusinessRegistrationNumber(String BusinessRegistrationNumber)  {
		getDriver().findElement(By.id("business_registration_number")).click();
		getDriver().findElement(By.id("business_registration_number")).sendKeys(BusinessRegistrationNumber);
		
	}


	public void enterDescription(String Description)   {
		getDriver().findElement(By.id("description")).click();
		getDriver().findElement(By.id("description")).sendKeys(Description);
		
	}


	public void enterPostalCode(String postalCode)   {
		getDriver().findElement(By.id("postal_code")).click();
		getDriver().findElement(By.id("postal_code")).sendKeys(postalCode);
		
	}


	public void enterLegalEntityName(String LegalEntityName)   {
		getDriver().findElement(By.id("legal_entity_name")).click();
		getDriver().findElement(By.id("legal_entity_name")).sendKeys(LegalEntityName);
		
	}


	public void selectEnterpriseType(String enterpriseType)  {
//		Select type = new Select(getDriver().findElement(By.xpath("//input[@value='Type']")));
//		type.selectByIndex(2);
		Selenium selenium = new WebDriverBackedSelenium(getDriver(), getDriver().getCurrentUrl());
		//getDriver().findElement(By.xpath("//input[@value='Type']")).clear();
		selenium.type("xpath=//input[@value='Type']", "Hotel");
		//selenium.click("xpath=//input[@value='Type']");
		//selenium.click("xpath=//div/li[2]/span");
//		
//		
////		new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath("//input[@value='Type']")));
//		getDriver().findElement(By.id("legal_entity_name")).click();
//		getDriver().findElement(By.id("legal_entity_name")).sendKeys(Keys.TAB);
////		getDriver().findElement(By.xpath("//input[@value='Type']")).sendKeys("Hotel");;
////		getDriver().findElement(By.xpath("//input[@value='Type']")).sendKeys(Keys.ENTER);;
////		new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath("//div[4]/div[2]/div/ul/li[3]/span")));
//		getDriver().findElement(By.xpath("//div[4]/div[2]/div/ul")).sendKeys("Hotel");
		while(( (getDriver().findElement(By.xpath("//div[4]/div[2]/div/ul/li[2]"))).getAttribute("class").equalsIgnoreCase("active selected"))==false)
		{
			getDriver().findElement(By.xpath("//div[4]/div[2]/div/ul/li[2]/span")).click();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}


	public void submitEnterprise()  {
		while(getDriver().findElements(By.xpath("//a[contains(@href,'view')]")).size()==0)
		{
			((JavascriptExecutor)getDriver()).executeScript("scroll(0, 250);", "");
			getDriver().findElement(By.xpath("//button[@type='button']")).click();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}


	public void viewEnterprise()  {
		getDriver().findElement(By.xpath("//a[contains(@href,'view')]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}


	public void openServiceLinesTabinEnterprise(String enterpriseName)  {
		getDriver().findElement(By.name("name")).sendKeys(enterpriseName);
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		getDriver().findElement(By.xpath("//a[text()='"+enterpriseName+"']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().findElement(By.xpath("//a[contains(@href, 'manage-service')]")).click();
		
	}


	public void clickAssignServiceLine()  {
		getDriver().findElement(By.xpath("//a[contains(text(),'Assign Service Line')]")).click();
		
	}


	public void submitServiceLine(String serviceLine)   {
		getDriver().findElement(By.xpath("//input[@value='Select A Service Line']")).click();
		new Actions(getDriver()).moveToElement(getDriver().findElement(By.xpath("//span[text()='"+serviceLine+"']")));
		getDriver().findElement(By.xpath("//span[text()='"+serviceLine+"']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().findElement(By.id("added-interprise-serviceline")).click();
		try {
			Thread.sleep(4000);
			getDriver().findElement(By.id("added-interprise-serviceline")).click();
			Thread.sleep(4000);
		} catch (InterruptedException e) {
	
		}
	}
	
	public void verifyServiceLine(String serviceLine)   {
		getDriver().findElements(By.name("search")).get(0).sendKeys(serviceLine);
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		assertThat(getDriver().findElement(By.xpath("//td[contains(text(),'"+serviceLine+"')]")).isDisplayed());
	}
}

