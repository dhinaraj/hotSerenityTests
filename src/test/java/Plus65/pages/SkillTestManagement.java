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

public class SkillTestManagement extends PageObject{
	@Override
    public WebDriver getDriver() { return super.getDriver();}

	public void clickSkillTests() {
		getDriver().findElement(By.xpath("//li[5]/ul/li/a")).click();
		getDriver().findElement(By.xpath("//a[contains(text(),'Skill Tests')]")).click();
	}

	public void searchOpenSkillTest(String serviceLineName, int level) {
		getDriver().findElement(By.name("search")).sendKeys(serviceLineName);
	//	getDriver().findElement(By.xpath("//div[3]/div[2]/input")).sendKeys("Level "+level);
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().findElements(By.xpath("//a[contains(text(),'Edit')]")).get(level-1).click();
		
	}

	public void addQuestion(int questioNo) {
		getDriver().findElement(By.id("description")).sendKeys("Question"+questioNo);
		getDriver().findElement(By.id("choices0")).sendKeys("Option1");
		for(int i=1;i<=3; i++)
		{
			getDriver().findElement(By.id("add-option")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getDriver().findElement(By.id("choices"+i)).sendKeys("Option"+(i+1));
		}
		getDriver().findElement(By.xpath("//label[@for='correct0']")).click();
		getDriver().findElement(By.xpath("//button[contains(text(),'Submit Question')]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickSave() {
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",getDriver().findElement(By.xpath("//button[@name='button']")));
		
		
	}

	public void clickPublish() {
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",getDriver().findElement(By.xpath("//a[@id='publish-test']")));
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();",getDriver().findElement(By.xpath("//button[@id='real-submit']")));
		
	}

	
	
	
	
	
	
	
	
}

