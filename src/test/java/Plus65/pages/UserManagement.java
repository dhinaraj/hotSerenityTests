package Plus65.pages;

import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://staging-admin.arrowmepro.com/accounts")

public class UserManagement extends PageObject{
	@Override
    public WebDriver getDriver() { return super.getDriver();}
	
	public void clickUsers() { getDriver().findElement(By.xpath("//a[contains(@href,'accounts')]")).click();}
	
	
	
	public void clickAddNewAccount() { getDriver().findElement(By.id("add-new-account")).click();}
	
	public void enterFistName(String fn) { getDriver().findElement(By.id("first_name")).click(); getDriver().findElement(By.id("first_name")).sendKeys(fn);}
	
	public void enterLastName(String ln) { getDriver().findElement(By.id("last_name")).click(); getDriver().findElement(By.id("last_name")).sendKeys(ln);}
	
	public void enterEmail(String em) { getDriver().findElement(By.id("email")).click(); getDriver().findElement(By.id("email")).sendKeys(em);}
	
	public void enterPhone(String ph) { getDriver().findElement(By.id("phone")).click(); getDriver().findElement(By.id("phone")).sendKeys(ph);}
	
	public void selectAccountFor(String rl) { 
		getDriver().findElement(By.id("role_slug")).click(); 
		getDriver().findElement(By.id("role_slug")).sendKeys(rl);
		getDriver().findElement(By.id("role_slug")).sendKeys(Keys.ENTER);
	}
	
	public void selectGroup(String val) { 
		(new Select(getDriver().findElement(By.id("group_id")))).selectByVisibleText(val);;
	}
	
	public void selectChain(String val) { 
		(new Select(getDriver().findElement(By.id("chain_id")))).selectByVisibleText(val);;
		//getDriver().findElement(By.id("chain_id")).click(); getDriver().findElement(By.id("chain_id")).sendKeys(val);
	}
	
	public void selectEnterprise(String val) { 
		(new Select(getDriver().findElement(By.id("enterprise_id")))).selectByVisibleText(val);
		//getDriver().findElement(By.id("enterprise_id")).click(); getDriver().findElement(By.id("enterprise_id")).sendKeys(val);
	}
	
	public void selectService(String val) { 
		(new Select(getDriver().findElement(By.id("service_id")))).selectByVisibleText(val);
		//getDriver().findElement(By.id("service_id")).click(); getDriver().findElement(By.id("service_id")).sendKeys(val);
	}
	
	public void clickCreate() { getDriver().findElement(By.id("pushcreate_new_account")).click();}
	
	public void clickCancel() { getDriver().findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();}

	public boolean verifyFirstName(String fn) {
		return getDriver().findElement(By.xpath("//td[contains(text(),'"+ fn + "')]")).isDisplayed();
	}

	public boolean verifyLastName(String ln) {
		return getDriver().findElement(By.xpath("//td[contains(text(),'"+ ln + "')]")).isDisplayed();
		
	}

	public boolean verifyName(String em) {
		return getDriver().findElement(By.xpath("//td[contains(text(),'"+ em + "')]")).isDisplayed();
		
	}

	public boolean verifyPhone(String ph) {
		return getDriver().findElement(By.xpath("//td[contains(text(),'"+ ph + "')]")).isDisplayed();
		
	}

	public boolean verifyRole(String rl) {
		return getDriver().findElement(By.xpath("//td[contains(text(),'"+ rl + "')]")).isDisplayed();
		
	}
	
	public void clickClose() { getDriver().findElement(By.xpath("//div[3]/div/button")).click();}

	public void serachByKeword(String user) {
		getDriver().findElement(By.xpath("//button[@type='button']")).click();
		getDriver().findElement(By.name("search")).sendKeys(user);
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
	}

	public void clickEditLink() {
		getDriver().findElement(By.linkText("Edit")).click();
		
	}

	public String editName() {
		String val = getDriver().findElement(By.id("first_name")).getAttribute("value");
		val=val + "updated";
		getDriver().findElement(By.id("first_name")).clear();
		getDriver().findElement(By.id("first_name")).sendKeys(val);
		getDriver().findElement(By.id("push_update_account")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return val;
	}
	
	public String editNameBack() {
		String val = getDriver().findElement(By.id("first_name")).getAttribute("value");
		val=val.replace("updated", "");
		getDriver().findElement(By.id("first_name")).clear();
		getDriver().findElement(By.id("first_name")).sendKeys(val);
		getDriver().findElement(By.id("push_update_account")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return val;
	}

	public String deleteUser(String em) {
		String email =getDriver().findElement(By.xpath("//td[contains(text(),'"+ em + "')]")).getText();
		getDriver().findElement(By.linkText("Delete")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().findElement(By.id("confirm-modal")).click();
		
		return email;
	}

	public boolean verifyLink(String lnk) {
		
		 return getDriver().findElement(By.xpath("//a[contains(text(),'"+lnk+"')]")).isDisplayed();
	}

	public void restoreUser() {
		getDriver().findElement(By.xpath("//a[contains(text(),'Restore')]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().findElement(By.id("confirm-modal")).click();
		
	}

	public void logintoMailAccount() {
		getDriver().navigate().to("http://gmail.com");
		//getDriver().findElement(By.linkText("Sign In")).click();
		getDriver().findElement(By.id("identifierId")).sendKeys("testautomation65");
		getDriver().findElement(By.xpath("//span[contains(text(),'Next')]")).click();	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().findElement(By.name("password")).sendKeys("qwer1234#");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().findElement(By.xpath("//span[contains(text(),'Next')]")).click();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void ResetPassword() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span/b[contains(text(),'User Registered')]")));

		element.click();	
		String currentWindow = getDriver().getWindowHandle();
		getDriver().findElement(By.xpath("//a[contains(text(),'Get Started')]")).click();
		for(String winHandle : getDriver().getWindowHandles()){
            if(currentWindow.equalsIgnoreCase(winHandle))
               continue; 
            getDriver().switchTo().window(winHandle);
        }  
		getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("123qwe");
		getDriver().findElement(By.xpath("//input[@name='password_confirmation']")).sendKeys("123qwe");
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		
	}

	
	
}

