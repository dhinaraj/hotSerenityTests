package Plus65.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Dhinakaran on 22/12/16.
 */

@DefaultUrl("https://uat.arrowmii.com/en/auth/login")

public class PartimerProfilePage extends PageObject {
	
	PartimerOnBoardingPage partimerOnBoarding;
	
	
	@Override
	public WebDriver getDriver() {
		return super.getDriver();
	}

	public void clickOnProfileLink() {
		getDriver().findElement(By.linkText("Profile")).click();
	}

	public void clickOnEditProfileIcon() {
		getDriver().findElement(By.xpath("html/body/div[1]/div[2]/header/div/div[2]/a[1]")).click();
	}
	

	public void clickOnAddWorkExperience() {
		getDriver().findElement(By.xpath("html/body/div[1]/div[2]/div[3]/div/div[3]/a")).click();
	}

	public void selectServiceLine(String serviceLineName) {
		Select serviceLineDropDown = new Select(
				getDriver().findElement(By.xpath("html/body/div[5]/div/div/div/div/div/form/div[1]/div/input")));
		serviceLineDropDown.selectByVisibleText(serviceLineName);
	}

	public void enterWhatJob(String jobName) {
		getDriver().findElement(By.id("name")).sendKeys(jobName);
	}

	public void enterWhereYouWorked(String enterpriseName) {
		getDriver().findElement(By.id("enterprise_name")).sendKeys(enterpriseName);
	}

	public void clickOnWorkedFrom() {
		getDriver().findElement(By.id("starts_at")).click();
	}

	public void clickOnWorkedTo() {
		
	    WebElement workedTo = getDriver().findElement(By.id("ends_at")); // the triger event element

	    Actions build = new Actions(getDriver()); // heare you state ActionBuider
	    build.moveToElement(workedTo).click().build().perform(); // Here you perform hover mouse over the needed elemnt to triger the visibility of the hidden
	}

	public void enterHoursWorked(String hoursWorked) {
		getDriver().findElement(By.id("hours_worked")).sendKeys(hoursWorked);
	}

	public void enterReferrerEmail(String referrerEmail) {
		getDriver().findElement(By.id("endorsed_by_email")).sendKeys(referrerEmail);
	}

	public void clickOnSubmit() {
		getDriver().findElement(By.xpath("html/body/div[5]/div/div/div/div/div/form/div[9]/button[2]")).click();
	}

	public void selectMonth(String month) {

		Select monthDropDown = new Select(getDriver().findElement(
				By.xpath("html/body/div[5]/div/div/div/div/div/form/div[4]/div/div/div/div/div/div[2]/div/select[1]")));
		monthDropDown.selectByVisibleText(month);

	}

	public void selectYear(String year) {

		Select yearDropDown = new Select(getDriver().findElement(
				By.xpath("html/body/div[5]/div/div/div/div/div/form/div[4]/div/div/div/div/div/div[2]/div/select[2]")));
		yearDropDown.selectByVisibleText(year);

	}

	public void clickOnCloseButtonOnCalendar() {
		getDriver()
				.findElement(By
						.xpath("html/body/div[5]/div/div/div/div/div/form/div[4]/div/div/div/div/div/div[3]/button[3]"))
				.click();

	}

	public void clickOnTodayButtonOnCalendar() {
		getDriver()
				.findElement(By
						.xpath("html/body/div[5]/div/div/div/div/div/form/div[5]/div/div/div/div/div/div[3]/button[1]"))
				.click();

	}

	public void selectStartDate(String Date) {
		// getDriver().findElement(By.xpath("html/body/div[5]/div/div/div/div/div/form/div[5]/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[4]/div")).click();

		WebElement dateWidget = getDriver().findElement(By.id("starts_at_table"));
		List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

		for (WebElement cell : columns) {
			// Select 13th Date
			if (cell.getText().equals("Date")) {
				cell.findElement(By.linkText("Date")).click();
				break;
			}

		}
	}

	public void selectEndDate(String date) {
		// getDriver().findElement(By.xpath("html/body/div[5]/div/div/div/div/div/form/div[5]/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[4]/div")).click();

		WebElement dateWidget = getDriver().findElement(By.id("ends_at_table"));
		List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

		for (WebElement cell : columns) {
			// Select Required Date
			if (cell.getText().equals(date)) {
				cell.findElement(By.linkText(date)).click();
				break;
			}

		}
	}
	
		/****** Edit Profile Details *****/
	

	public void clickOnEditNameIcon() {
		getDriver().findElement(By.cssSelector("a.edit-name > i.material-icons")).click();
	}
	
	public void enterFirstName(String newFirstName) {
		 getDriver().findElement(By.id("first_name")).clear();
		   getDriver().findElement(By.id("first_name")).sendKeys(newFirstName);
	}
	
	public void enterLastName(String newLastName) {
		 getDriver().findElement(By.id("last_name")).clear();
		   getDriver().findElement(By.id("last_name")).sendKeys(newLastName);
	}
	
	public void enterNickName(String newNickName) {
		   getDriver().findElement(By.id("nick_name")).clear();
		   getDriver().findElement(By.id("nick_name")).sendKeys(newNickName);
	}
	
	public void clickOnEditDOBIcon() {
		  getDriver().findElement(By.cssSelector("a.edit-info > i.material-icons")).click();
	}
	
	public void enterDOB(String dateOfBirth) {
		getDriver().findElement(By.id("dob")).click();

		List<WebElement> allDates = getDriver().findElements(By.xpath("//table[@class='picker__table']//div"));

		for (int i = 0; i < allDates.size(); i++) {
			String dateInElement = allDates.get(i).getText();
			if (dateInElement.equals(dateOfBirth)) {
				allDates.get(i).click();
				break;
			}
		}

	}
	
	public void selectStudent() {
		String elementNameToCheck = "//input[@value='Yes']";
		boolean isElementPresent = partimerOnBoarding.checkElementPresentByXpath(elementNameToCheck);
		
		if (isElementPresent)
		{
		getDriver().findElement(By.xpath("//input[@value='Yes']")).click();
		getDriver().findElement(By.cssSelector("li > span")).click();
		}
		else
		{
			getDriver().findElement(By.xpath("//input[@value='No']")).click();
			getDriver().findElement(By.xpath("//ul[@id='select-options-df4405cc-565d-a1c0-108a-1cc265e2bb6c']/li[2]/span")).click();
		
		}
	}
	

	
	public void enterSchoolName(String schoolName) {
		getDriver().findElement(By.id("school_name")).clear();
		   getDriver().findElement(By.id("school_name")).sendKeys(schoolName);
}
	
	public void clickOnEditAddressIcon() {
		   getDriver().findElement(By.cssSelector("a.edit-address > i.material-icons")).click();
}
	
	public void enterNewAddress(String newAddress) {
		getDriver().findElement(By.id("address")).clear();
		   getDriver().findElement(By.id("address")).sendKeys("My New Address");
}
	
	public void clickOnUpdateServiceLineButton() {
		 getDriver().findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[2]/div[1]/div[2]/span/a")).click();
}
	
	public void selectServiceLineCheckBox(String serviceLineName) {
		int i = 1;
		String checkBoxElementName = ".//*[@id='modal-add-serviceline']/form/div[1]/div/div[" + i + "]/span/label";
		boolean isElementPresent = partimerOnBoarding.checkElementPresentByXpath(checkBoxElementName);
		boolean isElementClicked = false;

		while (isElementPresent) {

			if (getDriver().findElement(By.xpath(checkBoxElementName)).getText().equals(serviceLineName)) {
				getDriver().findElement(By.xpath(checkBoxElementName)).click();
				isElementClicked = true;
				break;
			}
			i = i + 1;
			checkBoxElementName = ".//*[@id='modal-add-serviceline']/form/div[1]/div/div[" + i + "]/span/label";
			isElementPresent = partimerOnBoarding.checkElementPresentByXpath(checkBoxElementName);
		}
		
		if (!isElementClicked)
		{
			System.out.println("Intended element not found, clicking on the first Service Line");
			getDriver().findElement(By.xpath(".//*[@id='onboarding']/div/div[2]/form/div[1]/div[1]/span/label")).click();
		}
	}

	
	public void confirmUpdateServiceLine() {
		getDriver().findElement(By.id("btn-save-services")).click();
        }
	
	public void clickOnSaveProfileChangesButton() {
		getDriver().findElement(By.xpath("//button[@id='']")).click();
	}
	
	public void clickOnUploadProfilePicButton() {
		getDriver().findElement(By.id("upload-avatar-button")).click();
		
	}
	



}
