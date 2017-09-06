package Plus65.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.ui.Wait;
import java.util.concurrent.TimeUnit;
/**
 * Created by rohini
 */

@DefaultUrl("http://staging-admin.arrowmepro.com/login")



public class JobCreation extends PageObject {
	public WebDriver getDriver() {
		super.setImplicitTimeout(20, TimeUnit.SECONDS);
		return super.getDriver();	
	}
	
	public boolean checkElementPresentByXpath(String elementId) {
        try {
        	getDriver().findElement(By.xpath(elementId));
            return true;

        } catch (Exception e) {
        	return false;
        }
    }
	
	public boolean checkElementDisplayedByXpath(String elementId) {
        try {
        	boolean is_displayed = getDriver().findElement(By.xpath(elementId)).isDisplayed();
            return is_displayed;

        } catch (Exception e) {
        	return false;
        }
    }
	
	
//Create job and verify matched partimers 

	public void clickOnJobListings() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Job Listings")));
		getDriver().findElement(By.linkText("Job Listings")).click();
	}
	 
	public void clickOnCreateNewJob() {
		
		getDriver().findElement(By.xpath(".//*[@id='active']/div[1]/form/div[1]/a"))
				.click();
	}
	
	public void enterJobTitle(String jobName) {
		getDriver().findElement(By.id("name")).sendKeys(jobName);//change Title
	}
	
	public void clickOnStartDate() {
		getDriver().findElement(By.id("start_date")).click();
	}
	
	
	public void clickOnStartTime() {
		getDriver().findElement(By.id("start_time")).click();// change Start Time
		getDriver().findElement(By.xpath("//p/span")).click();

			
	}
	
	public void clickOnStartTime(int time, String timeOfDay) {
		getDriver().findElement(By.id("start_time")).click();// change Start// Time
		String hourValue = getDriver().findElement(By.xpath("html/body/div[8]/ul/li[1]/span[2]")).getText();
		String minuteValue = getDriver().findElement(By.xpath("html/body/div[8]/ul/li[3]/span[2]")).getText();
		String timeOfDayValue = getDriver().findElement(By.xpath("html/body/div[8]/ul/li[4]/span[2]")).getText();

		int hourValueInteger = Integer.parseInt(hourValue);
		//System.out.println("Current hourValueInteger= " + hourValueInteger);
		if (hourValueInteger != time) {
			int timeDifference = time - hourValueInteger;
			//System.out.println("Time Difference= " + timeDifference);
			if (timeDifference > 0) {
				
				for (int i = 1; i <= timeDifference; i++) {
					//System.out.println("Time Difference Iteration = " + i);
					getDriver().findElement(By.xpath("html/body/div[8]/ul/li[1]/span[1]")).click();
				}
			} else {
				for (int i = 1; i <= (-1 * timeDifference); i++) {
					//System.out.println("Time Difference Iteration = " + i);
					getDriver().findElement(By.xpath("html/body/div[8]/ul/li[1]/span[3]")).click();
				}
			}

		}

		if (!timeOfDayValue.equals(timeOfDay)) {

			getDriver().findElement(By.xpath("html/body/div[8]/ul/li[4]/span[1]")).click();

		}

		getDriver().findElement(By.xpath("//p/span")).click();

	}
	
	public void clickOnEndDate() {
	
		getDriver().findElement(By.id("end_date")).click();
		
		  }   
	
	
	public void clickOnEndTime() {
		getDriver().findElement(By.id("end_time")).click();// change End Time
		getDriver().findElement(By.xpath("//div[7]/ul/li/span")).click();
		getDriver().findElement(By.xpath("//p/span")).click();
	}
	
	
	public void clickOnEndTime(int time, String timeOfDay) {
		getDriver().findElement(By.id("end_time")).click();// change Start Time
		String hourValue = getDriver().findElement(By.xpath("html/body/div[8]/ul/li[1]/span[2]")).getText();
		String minuteValue = getDriver().findElement(By.xpath("html/body/div[8]/ul/li[3]/span[2]")).getText();
		String timeOfDayValue = getDriver().findElement(By.xpath("html/body/div[8]/ul/li[4]/span[2]")).getText();

		int hourValueInteger = Integer.parseInt(hourValue);
		//System.out.println("Current hourValueInteger= " + hourValueInteger);
		if (hourValueInteger != time) {
			int timeDifference = time - hourValueInteger;
			//System.out.println("Time Difference= " + timeDifference);
			if (timeDifference > 0) {
				
				for (int i = 1; i <= timeDifference; i++) {
					//System.out.println("Time Difference Iteration = " + i);
					getDriver().findElement(By.xpath("html/body/div[8]/ul/li[1]/span[1]")).click();
				}
			} else {
				for (int i = 1; i <= (-1 * timeDifference); i++) {
					//System.out.println("Time Difference Iteration = " + i);
					getDriver().findElement(By.xpath("html/body/div[8]/ul/li[1]/span[3]")).click();
				}
			}

		}

		if (!timeOfDayValue.equals(timeOfDay)) {

			getDriver().findElement(By.xpath("html/body/div[8]/ul/li[4]/span[1]")).click();

		}

		getDriver().findElement(By.xpath("//p/span")).click();

	}
	
	//public void clickOnEndDate() {
		

	 //   WebElement workedTo = getDriver().findElement(By.id("end_date")); // the triger event element

	   // Actions build = new Actions(getDriver()); // here you state ActionBuider
	 //   build.moveToElement(workedTo).click().build().perform(); // Here you perform hover mouse over the needed elemnt to triger the visibility of the hidden
	//}
	public void enterNoOfPartimers() {
		getDriver().findElement(By.id("part_timers_count")).sendKeys("4");// (no of partimer and verify matches should be same) 
	}
	
	public void enterNoOfPartimers(String partimerCount) {
		getDriver().findElement(By.id("part_timers_count")).sendKeys(partimerCount);// (no of partimer and verify matches should be same) 
	}
	public void enterAmountPerHour() {
		getDriver().findElement(By.id("payment")).sendKeys("11");
		
	}
	
	public void selectEventSupervisor() {
		/*getDriver().findElement(By.xpath("html/body/div[4]/div/div[2]/form/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/input")).click();
		WebElement mySelectElement = getDriver().findElement(By.id("event_supervisor_id"));
		Select dropdown= new Select(mySelectElement);
		dropdown.selectByVisibleText("Daily Job Test ES1 First Name Daily Job Test ES1 Last Name");*/
		
		//getDriver().findElement(By.xpath("html/body/div[4]/div/div[2]/form/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/input")).click();
		
			/*getDriver().findElement(By.xpath("html/body/div[4]/div/div[2]/form/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/input")).click();
			//getDriver().findElement(By.xpath("html/body/div[4]/div/div[2]/form/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/input/select/option[2]")).click();
			getDriver().findElement(By.xpath("html/body/div[4]/div/div[2]/form/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/input/ul/li[2]")).click();*/
			
				
			
	/*WebElement select = getDriver().findElement(By.id("event_supervisor_id"));
		List<WebElement> options = select.findElements(By.tagName("option"));
		for (WebElement option : options) {
			System.out.println(option.getText());
		    if("Daily Job Test ES1 First Name Daily Job Test ES1 Last Name".equals(option.getText()))
		        
		    	option.click();  
		} */
		getDriver().findElement(By.xpath("html/body/div[4]/div/div[2]/form/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div/div/div/input")).click();
		Select dropdown = new Select(getDriver().findElement(By.id("event_supervisor_id"))); 
		dropdown.selectByIndex(2);	
	}
	
	public void enterAmountPerHour(String amountPerHour) {
		getDriver().findElement(By.id("payment")).sendKeys(amountPerHour);
		
	}
	//public void selectEventSupervisor() {
		//getDriver().findElement(By.xpath("//input[@value='Event Supervisor']")).click();
		//getDriver().findElement(By.xpath("//div[2]/div/div/div/div/ul/li[2]/span")).click();
	
//}
	public void enterJobInstruction() {
		getDriver().findElement(By.name("job_description")).sendKeys("Hotel Service");
		
}
	public void UploadVideo() {
		getDriver().findElement(By.name("video")).sendKeys("/Users/rohini/Downloads/videoplayback.mp4");
		
}
	public void jobCreationNow() {
	
		getDriver().findElement(By.id("go-to-confirm")).click();
		boolean isElementPresent = checkElementPresentByXpath("html/body/div[2]/div/div[1]/div[3]/div/div/div[3]/button");
		if(isElementPresent)
		{
			getDriver().findElement(By.xpath("html/body/div[2]/div/div[1]/div[3]/div/div/div[3]/button")).click();
		}
		
		
}
	public void jobCreationSubmit() {
		
		try {
			getDriver().findElement(By.id("go-to-submit")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	public void clickOnJobPost() {
		String textValue = getDriver().findElement(By.xpath(".//*[@id='general-modal']/div/div[1]/div[3]/div[2]/div[1]/a")).getText();
		System.out.println("Clicking on: " + textValue);
		getDriver().findElement(By.xpath(".//*[@id='general-modal']/div/div[1]/div[3]/div[2]/div[1]/a")).click();
		//getDriver().findElement(By.partialLinkText("View My Job Post")).click();

	}
	public String shouldSeeMessage(String expectedMessage) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='general-modal']/div/div[1]/div[3]/div[1]/div[1]/div/h5")));
		WebElement sucessMessage;
		sucessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='general-modal']/div/div[1]/div[3]/div[1]/div[1]/div/h5")));
	      return sucessMessage.getText();
	 }

	public void jobMatches(String strng) {
		getDriver().navigate().refresh();
		String numMatches = getDriver().findElement(By.xpath("html/body/div[4]/div/div[3]/div/div/ul/li[3]/a"))
				.getText();// check logic
		//getDriver().findElement(By.xpath("html/body/div[4]/div/div[3]/div/div/ul/li[3]/a")).click();

		Assert.assertEquals(numMatches, strng);
		System.out.println("Job Created Successfully & Mathces verified");
		
	}

	
	
public void clickOnjobMatches(String strng ) {
		
		getDriver().findElement(By.xpath("/html/body/div[4]/div[3]/div/div/ul/li[3]/a")).click();
		getDriver().findElement(By.xpath("//div[3]/div/div/ul/li[3]/a")).click();
		getDriver().findElement(By.xpath("css=div > a > div")).click();
		getDriver().findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/span[2]")).getText();
		
			}
public void logInParttimerAccount(String strng ) {

		getDriver().findElement(By.xpath("//div/form/div[2]/div/input")).sendKeys("");
	

	
		getDriver().findElement(By.xpath("//div/form/div[3]/div/input")).sendKeys("123qwe");


	
		getDriver().findElement(org.openqa.selenium.By.id("login-submit")).click();
	
}

public void clickOnMatchedJob(String strng ) {
	getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/ul/a[1]/li/div/div[1]/div[2]/h4")).click();
	}
public void clickOnAcceptOffer(String strng ) {
	getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div/div/div[4]/button[1]")).click();
	}
// Cancel Partimer //

public void logInPttAcc(String strng ) {

	getDriver().findElement(By.xpath("//div/form/div[2]/div/input")).sendKeys("rohinithyagarajan1990@gmail.com");



	getDriver().findElement(By.xpath("//div/form/div[3]/div/input")).sendKeys("1234qwer");



	getDriver().findElement(org.openqa.selenium.By.id("login-submit")).click();

}

	public void clickOnAllJob(String strng) {
		getDriver().findElement(By.xpath("//li[2]/a/div")).click();

	}

	public void clickOn1stOfAllJob(String strng) {
		getDriver()
				.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/ul/a[1]/li/div/div[1]/div[2]/p[2]"))
				.click();
		getDriver().manage().timeouts().implicitlyWait(1200, TimeUnit.SECONDS);

	}

	public void clickOnApplyForJob(String strng) {
		getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[2]/div/div/div[4]/button")).click();

	}







//cancel job Created//
	
	public void selectfirstJobCreatedforcancel() {
		getDriver().findElement(By.xpath("//div[2]/div/div[2]/a/span")).click();
	}
	public void clickEditofJobCreated() {
	    getDriver().findElement(By.xpath("/html/body/div[4]/div[2]/div/div[1]/div[2]/a")).click();
			}
	public void clickCancelEvent() {
	    getDriver().findElement(By.xpath("//div[3]/a")).click();
			}
	public void clickYesCancelJob() {
	    getDriver().findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/a")).click();
			}
	
	//Partimer Payment By HR //
	
	
	public void clickOnPartimerPayment() {
		getDriver().findElement(By.xpath("//div[3]/ul/li[4]/a")).click();
	}
	public void tickCheckbox() {
		getDriver().findElement(By.xpath("/html/body/div[4]/div[4]/div/div[2]/div/div/div[3]/div/table/tbody[2]/tr[1]/td[1]/div")).click();
	}
	public void selectMarkasProcessing() {
		getDriver().findElement(By.xpath("/html/body/div[4]/div[4]/div/div[2]/div/div/div[2]/div/div/div/div[2]")).click();
		getDriver().findElement(By.xpath("/html/body/div[4]/div[4]/div/div[2]/div/div/div[2]/div/div/div/div[2]/select/option[2]")).click();
	}
	public void clickApply() {
		getDriver().findElement(By.xpath("//a[contains(text(),'Apply')]")).click();
	}
	public void clickMarkasProcessingtoConfirm() {
		getDriver().findElement(By.cssSelector("#mark-as-processing")).click();
	}
	public void clickProcessing () {
		getDriver().findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div/ul/li[2]/a")).click();
	}
	public void tickCheckboxPaid() {
		getDriver().findElement(By.xpath("/html/body/div[4]/div[4]/div/div[2]/div/div/div[2]/div/table/tbody[2]/tr/td[1]")).click();
	}
	public void selectMarkasPaid() {
		getDriver().findElement(By.xpath("/html/body/div[4]/div[4]/div/div[2]/div/div/div[2]/div/div/div/div[1]")).click();
		getDriver().findElement(By.xpath("/html/body/div[4]/div[4]/div/div[2]/div/div/div[2]/div/div/div/div[2]/select/option[2]")).click();
	}
	public void clickApplyforPaying() {
		getDriver().findElement(By.xpath("//a[contains(text(),'Apply')]")).click();
	}
	public void clickPaid () {
		getDriver().findElement(By.cssSelector("#mark-as-paid")).click();
	}
	public void clickPaidButton () {
		getDriver().findElement(By.xpath("/html/body/div[4]/div[2]/div[2]/div/ul/li[2]")).click();
	}
	public String shouldSeePaidConfirmation() {
		String Message= getDriver().findElement(By.xpath("/html/body/div[4]/div[4]/div/div[2]/div/div/div[4]/div[1]/div/div/label")).getText();
	        return Message;// check 
	 }
	
	
	public void selectStartDate(String date) {

		String dateWidgetElementName = "";
		boolean isElementPresent = false;
		boolean isElementClicked = false;

			for (int row = 1; row <= 6; row++ ) {
				for (int col = 1; col <= 7; col++) {
					dateWidgetElementName = "html/body/div[5]/div/table/tbody/tr[" + row + "]/td[" + col + "]/button";
					System.out.println("Element Being Searched :"+ dateWidgetElementName);
					isElementPresent = checkElementPresentByXpath(dateWidgetElementName);
	
					if (isElementPresent) {
						
						String dateInElement = getDriver().findElement(By.xpath(dateWidgetElementName)).getText();
						System.out.println("Date in Element :" + dateInElement);

						if (getDriver().findElement(By.xpath(dateWidgetElementName)).getText().equals(date)) {
							getDriver().findElement(By.xpath(dateWidgetElementName)).click();
							isElementClicked = true;
							break;
						}
					}

				}
				
				if (isElementClicked)
				{
					break;
				}
				
			}
			
	}
	
	public void selectEndDate(String date) {

		String dateWidgetElementName = "";
		boolean isElementPresent = false;
		boolean isElementClicked = false;

			for (int row = 1; row <= 6; row++ ) {
				for (int col = 1; col <= 7; col++) {
					dateWidgetElementName = "html/body/div[6]/div/table/tbody/tr[" + row + "]/td[" + col + "]/button";
					System.out.println("Element Being Searched :"+ dateWidgetElementName);
					isElementPresent = checkElementPresentByXpath(dateWidgetElementName);
	
					if (isElementPresent) {
						
						String dateInElement = getDriver().findElement(By.xpath(dateWidgetElementName)).getText();
						System.out.println("Date in Element :" + dateInElement);

						if (dateInElement.equals(date)) {
							getDriver().findElement(By.xpath(dateWidgetElementName)).click();
							isElementClicked = true;
							break;
						}
					}

				}
				
				if (isElementClicked)
				{
					break;
				}
				
			}
			
	}
	
	
	public void selectDate(String date) {
		List<WebElement> allDates = getDriver().findElements(By.xpath("////table[@class='pika-table']//button"));

		for (int i = 0; i < allDates.size(); i++) {
			String dateInElement = allDates.get(i).getText();
			if (dateInElement.equals(date)) {
				allDates.get(i).click();
				break;
			}
		}

	}
	

	public void refersh() {
		getDriver().navigate().refresh();
		
	}
	
	
	
	
	public void selectDateFunction(String Date, String Month, String whichDateField) {
		
		WebElement dateWidget1;

		boolean isDateFound = false;
		while (!isDateFound) {

			if (whichDateField.equalsIgnoreCase("startdate")) {
				dateWidget1 = getDriver().findElement(By.className("pika-table"));
			} else {
				dateWidget1 = getDriver().findElement(By.xpath("html/body/div[7]/div/table"));
			}
			// List<WebElement> columns =
			// dateWidget.findElements(By.tagName("td"));
			List<WebElement> columns1 = dateWidget1.findElements(By.tagName("button"));

			WebElement checkMonth = columns1.get(1);
			String checkMonthString = checkMonth.getAttribute("data-pika-month");
			// System.out.println(checkMonthString);

			if (checkMonthString.equals(Month)) {

				for (WebElement cell1 : columns1) {
					String dateInCell1 = cell1.getText();
					// System.out.println(dateInCell1);
					if (dateInCell1.equals(Date)) {
						cell1.click();
						break;
					}

					isDateFound = true;
				}
			}

			else {

				if (whichDateField.equalsIgnoreCase("startdate")) {
					getDriver().findElement(By.className("pika-next")).click();
				} else {
					getDriver().findElement(By.xpath("html/body/div[7]/div/div/button[2]")).click();
				}
			}

		}

	}
	
	public void selectDate(String Date, String Month, String whichDateField)
	{
		if (whichDateField.equalsIgnoreCase("startdate"))
		{
			clickOnStartDate();
		}
		else
		{
			clickOnEndDate();
		}
		
		selectDateFunction(Date, Month, whichDateField);
	}

		
		
}