package Plus65.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;


/**
 * Created by Dhinakaran
 */

@DefaultUrl("http://staging-admin.arrowmepro.com/en/auth/login")

public class JobAttendancePage extends PageObject {
	public WebDriver getDriver() {
		super.setImplicitTimeout(20, TimeUnit.SECONDS);
		return super.getDriver();
	}
	
	public void clickOnJobAttendance() {
		getDriver().findElement(By.xpath("html/body/header/div[2]/div[1]/div[3]/ul/li[3]/a")).click();

	}

	public void openJobAttendanceView() {
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div/div/div/div/div[3]/div/div/div[2]/div[2]/div/div[2]/a/span")).click();

	}

	public void clickOnSelectAllCheckBox() {
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[1]/div/label")).click();

	}
	
	public void clickOnPageNumber(int pageNum) {
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[2]/ul/li["+pageNum+"]/a")).click();

	}
	
	public void clickOnApplyButton() {
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[3]/a")).click();

	}
	
	public void confirmClockInOrOutOrReview() {
		getDriver().findElement(By.xpath("html/body/div[2]/div/div/div[2]/form/div[3]/div/button[2]")).click();

	}
	
	public void selectItemsPerPage(String numOfRecords) {
		if(numOfRecords.equals("10"))
		{
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[4]/ul/li[2]/select")).click();
		Select select = new Select(getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[4]/ul/li[2]/select")));
		select.selectByIndex(0);
		}
		else if(numOfRecords.equals("20"))
		{
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[4]/ul/li[2]/select")).click();
		Select select = new Select(getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[4]/ul/li[2]/select")));
		select.selectByIndex(1);
		}
		else if(numOfRecords.equals("50"))
		{
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[4]/ul/li[2]/select")).click();
		Select select = new Select(getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[4]/ul/li[2]/select")));
		select.selectByIndex(2);
		}
		else if(numOfRecords.equals("100"))
		{
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[4]/ul/li[2]/select")).click();
		Select select = new Select(getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[4]/ul/li[2]/select")));
		select.selectByIndex(3);
		}
		else
		{
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[4]/ul/li[2]/select")).click();
		Select select = new Select(getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[4]/ul/li[2]/select")));
		select.selectByIndex(4);
		}
		

	}
	
	

	public void selectBulkClockIn() {
		System.out.println("Performing Bulk Clock In");
		clickOnSelectAllCheckBox();
		//getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[2]/select")).click();
		Select select = new Select(getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[2]/select")));
		select.selectByIndex(1);
		clickOnApplyButton();
		confirmClockInOrOutOrReview();
		System.out.println("Buck Clock In Completed Sucessfully");

	}
	
	
	
	public void selectBulkClockOut() {
		System.out.println("Performing Bulk Clock Out");
		getDriver().navigate().refresh();
		clickOnSelectAllCheckBox();
		//getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[2]/select")).click();
		Select select = new Select(getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[2]/select")));
		select.selectByIndex(2);
		clickOnApplyButton();
		confirmClockInOrOutOrReview();
		System.out.println("Buck Clock Out Completed Sucessfully");

	}
	
	
	public void selectBulkReview() {
		System.out.println("Performing Bulk Review");
		getDriver().navigate().refresh();
		clickOnSelectAllCheckBox();
		//getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[2]/select")).click();
		Select select = new Select(getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[1]/div/div/div/div[2]/select")));
		select.selectByIndex(3);
		clickOnApplyButton();
		confirmClockInOrOutOrReview();
		System.out.println("Buck Review Completed Sucessfully");

	}
	


	public void moveToNextPage(int pageNumber) {

		getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[2]/ul/li["+pageNumber+"]/a")).click();

	}
	
	public void enterReviewText() {

		getDriver().findElement(By.xpath("html/body/div[2]/div/div/div[2]/div[2]/div/form/div/div[4]/div[2]/textarea")).sendKeys("Test review");

	}
	
	public void submitReview() {

		getDriver().findElement(By.xpath("html/body/div[2]/div/div/div[2]/div[2]/div/form/div/div[6]/div/button")).click();;

	}
	
	public void reviewAllPartimers() {
		
		getDriver().navigate().refresh();

		WebElement partimerListIdentifier = getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[2]"));
		// List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
		List<WebElement> partimerList = partimerListIdentifier.findElements(By.tagName("label"));

		int numOfPages = (int) Math.ceil((partimerList.size() / 10.0)) ;
		//System.out.println("Number Of Pages: " + numOfPages);
		selectItemsPerPage("10");
		for (int i = 2; i <= numOfPages+1; i++) {
			
			if(i>2)
			{
			moveToNextPage(i);
			}
			
			WebElement partimerListIdentifierPerPage = getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[2]"));
			// List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
			List<WebElement> partimerListPerPage = partimerListIdentifierPerPage.findElements(By.tagName("label"));

			for (int j = 1; j <= partimerListPerPage.size(); j++) {
				System.out.println("Reviewing Partimer Number: " + j);
				getDriver().findElement(By.xpath("html/body/div[4]/div/div[4]/div[2]/div/div/div/div[2]/div[" + j + "]/div[2]/div/div[1]/div[3]/div/div/a/div")).click();
				enterReviewText();
				submitReview();

			}
		}

	}
	
		
}