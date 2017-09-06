package Plus65.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dhinakaran on 22/12/16.
 */


public class PartimerSkillTestPage extends PageObject {

	@Override
	public WebDriver getDriver() {
		return super.getDriver();
	}
	
	public void clickOnTakeSkillTestForFirstServiceLine() {
		 getDriver().findElement(By.xpath("html/body/div[1]/div/div/div/div/form/div[2]/div[1]/div[1]/div[1]/div[3]/a")).click();
	}
	
	public void clickOnTakeSkillTestForSecondServiceLine() {
		 getDriver().findElement(By.xpath("html/body/div[1]/div/div/div/div/form/div[2]/div[1]/div[2]/div[1]/div[3]/a")).click();
	}
	
	public void clickOnIAgreeCheckBox() {
		 getDriver().findElement(By.xpath("html/body/div[4]/div[2]/form/div[1]/span/label")).click();
	}
	
	public void clickOnStartExamNow() {
		 getDriver().findElement(By.id("submit")).click();
	}
	
	public void selectRightAnswer() {
		 getDriver().findElement(By.xpath("html/body/div[1]/div/div/form/div[1]/div[2]/div[6]/span/label")).click();
	}
	
	public void clikcOnNext() {
		 getDriver().findElement(By.name("Next")).click();
	}
	
	public void clikcOnSubmitMyTest() {
		 getDriver().findElement(By.id("submit-trigger")).click();
	}
	
	public void clikcOnShowMyResults() {
		 getDriver().findElement(By.xpath("html/body/div[6]/div/div/div/div[3]/form/div/button")).click();
	}
	
	


}
