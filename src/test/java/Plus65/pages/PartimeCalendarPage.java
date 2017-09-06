package Plus65.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Dhinakaran on 22/12/16.
 */

public class PartimeCalendarPage extends PageObject {

	@Override
	public WebDriver getDriver() {
		return super.getDriver();
	}

	public void clickOnMyCalenderLink() {
		getDriver().findElement(By.partialLinkText("My Calendar")).click();
	}

	public void clickOnAddEvent() {
		getDriver().findElement(By.xpath("html/body/div[1]/div[2]/div[2]/a")).click();
	}

	public void enterName() {
		getDriver().findElement(By.id("name")).sendKeys("Test Event");
	}

	public void enterNotes() {
		getDriver().findElement(By.id("notes")).sendKeys("Test Notes");
	}

	public void enterStartDate(String Date) {
		getDriver().findElement(By.id("start_date")).click();

		WebElement dateWidget = getDriver().findElement(By.className("pika-table"));
		List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

		for (WebElement cell : columns) {
			String dateInCell = cell.getText();
			if (cell.getText().equals(Date)) {
				cell.click();
				break;
			}

		}
	}

	public void enterEndDate(String Date) {
		getDriver().findElement(By.id("end_date")).sendKeys(Date);

		/*
		 * getDriver().findElement(By.id("end_date")).click();
		 * 
		 * WebElement dateWidget =
		 * getDriver().findElement(By.className("pika-table")); List<WebElement>
		 * columns = dateWidget.findElements(By.tagName("td"));
		 * 
		 * for (WebElement cell : columns) { String dateInCell = cell.getText();
		 * if (cell.getText().equals(Date)) { cell.click(); break; }
		 * 
		 * }
		 */
	}

	public void enterStartTime() {
		getDriver().findElement(By.id("start_time")).click();
		getDriver().findElement(By.xpath("html/body/div[9]/p/span")).click();

	}

	public void enterEndTime() {
		getDriver().findElement(By.id("end_time")).click();
		getDriver().findElement(By.xpath("html/body/div[9]/ul/li[4]/span[1]")).click();
		getDriver().findElement(By.xpath("html/body/div[9]/p/span")).click();

	}

	public void clickOnAddEventConfirmation() {
		getDriver().findElement(By.xpath("//button[@type='submit']")).click();

	}

}
