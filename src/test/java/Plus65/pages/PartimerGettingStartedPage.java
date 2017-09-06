package Plus65.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Dhinakaran on 16/03/17.
 */

public class PartimerGettingStartedPage extends PageObject {

	@Override
	public WebDriver getDriver() {
		return super.getDriver();
	}

	public void clickOnUpdateProfile() {
		getDriver().findElement(By.linkText("Update Your Profile")).click();
	}

	public void clickOnAddAWorkExperience() {
		getDriver().findElement(By.linkText("Add A Work Experience")).click();
	}

	public void clickOntakeASkillTest() {
		getDriver().findElement(By.linkText("Take A Skill Test")).click();
	}

	public void clickOnAddBankAccount() {
		getDriver().findElement(By.linkText("Add Bank Account")).click();
	}

	public void clickOnProfileInfoTab() {
		getDriver().findElement(By.xpath("html/body/div[1]/div/div/div[1]/ul/li[1]/a")).click();
	}

	public void enterFirstName(String firstName) {
		getDriver().findElement(By.id("first_name")).clear();
		getDriver().findElement(By.id("first_name")).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		getDriver().findElement(By.id("last_name")).clear();
		getDriver().findElement(By.id("last_name")).sendKeys(lastName);
	}

	public void enterNickName(String nickName) {
		getDriver().findElement(By.id("nick_name")).clear();
		getDriver().findElement(By.id("nick_name")).sendKeys(nickName);
	}

	public void enterDOB(String dateOfBirth) {
		getDriver().findElement(By.id("dob")).click();

		List<WebElement> allDates = getDriver().findElements(By.xpath("//table[@class='picker__table']//div"));

		for (int i = 0; i < allDates.size(); i++) {
			String dateInElement = allDates.get(i).getText();
			if (dateInElement.equals(dateOfBirth)) {
				allDates.get(i).click();
				getDriver().findElement(By.xpath(".//*[@id='dob_root']/div/div/div/div/div[3]/button[3]")).click();
				break;
			}
		}
	}

	public void enterNric(String nricNo) {
		getDriver().findElement(By.id("nric")).clear();
		getDriver().findElement(By.id("nric")).sendKeys(nricNo);
	}

	public void enterAddress(String address) {
		getDriver().findElement(By.id("address")).clear();
		getDriver().findElement(By.id("address")).sendKeys(address);
	}

	public void enterPostalCode(String postalCode) {
		getDriver().findElement(By.id("postal_code")).clear();
		getDriver().findElement(By.id("postal_code")).sendKeys(postalCode);
	}

	public void enterStudentId(String studentId) {
		getDriver().findElement(By.id("schoolId")).clear();
		getDriver().findElement(By.id("schoolId")).sendKeys(studentId);
	}

	public void enterShoolName(String schoolName) {
		getDriver().findElement(By.id("schoolName")).clear();
		getDriver().findElement(By.id("schoolName")).sendKeys(schoolName);
	}

	public void clickEmailAndNotificationTab() {
		getDriver().findElement(By.xpath("//a[contains(@href, 'https://uat.arrowmii.com/en/account/settings/email')]"))
				.click();
	}

	public void clickOnAllEmailNotification() {
		getDriver().findElement(By.xpath(".//*[@id='notification-form']/div/div[2]/div[1]/label/span")).click();
	}

	public void clickOnMatchedOfferNotify() {
		getDriver().findElement(By.xpath(".//*[@id='notification-form']/div/div[2]/div[2]/label/span")).click();
	}

	public void clickOnApprovedApplicationNotify() {
		getDriver().findElement(By.xpath(".//*[@id='notification-form']/div/div[2]/div[3]/label/span")).click();
	}

	public void clickOnJobCancelledNotification() {
		getDriver().findElement(By.xpath(".//*[@id='notification-form']/div/div[2]/div[4]/label/span")).click();
	}

	public void clickOnEndorsementNotification() {
		getDriver().findElement(By.xpath(".//*[@id='notification-form']/div/div[2]/div[5]/label/span")).click();
	}

	public void clickOnUpdateNotificationSettingsButton() {
		getDriver().findElement(By.xpath(".//*[@id='notification-form']/button")).click();
	}

	public void clickOnUpdatePasswordTab() {
		getDriver().findElement(By.xpath("//li[3]/a/span")).click();
	}

	public void enterCurrentPassword(String oldPassword) {
		getDriver().findElement(By.id("old_password")).clear();
		getDriver().findElement(By.id("old_password")).sendKeys(oldPassword);
	}

	public void enterNewPassword(String newPassword) {
		getDriver().findElement(By.id("password")).clear();
		getDriver().findElement(By.id("password")).sendKeys(newPassword);
	}

	public void retypeNewPassword(String newPassword) {
		getDriver().findElement(By.id("password_confirmation")).clear();
		getDriver().findElement(By.id("password_confirmation")).sendKeys(newPassword);
	}

	public void clickOnBankAccountDetailsTab() {
		getDriver().findElement(By.cssSelector("a..firepath-matching-node")).click();
	}

	public void enterBankFirstName(String bankFirstName) {
		getDriver().findElement(By.id("bank_account_first_name")).clear();
		getDriver().findElement(By.id("bank_account_first_name")).sendKeys(bankFirstName);
	}

	public void enterBankLastName(String bankLastName) {
		getDriver().findElement(By.id("bank_account_last_name")).clear();
		getDriver().findElement(By.id("bank_account_last_name")).sendKeys(bankLastName);
	}

	public void selectBank(String bankName) {
	
		getDriver().findElement(By.xpath("html/body/div[1]/div/div/div[2]/form/div/div[4]/div/div/input")).click();
		List<WebElement> allBanks = getDriver().findElements(By.xpath("//div[@class='select-wrapper select-class']//span"));

		for (int i = 0; i < allBanks.size(); i++) {
			String bankNames = allBanks.get(i).getText();
			System.out.println("Bank Names" + bankNames);
			if (bankNames.equals(bankName)) {
				allBanks.get(i).click();
				break;
			}
		}
		
	}

	public void enterBankAccountNumber(String accountNumber) {
		getDriver().findElement(By.id("bank_account_number")).clear();
		getDriver().findElement(By.id("bank_account_number")).sendKeys(accountNumber);
	}

	public void clickOnBankDetailsUpdateButton() {
		getDriver().findElement(By.xpath("html/body/div[1]/div/div/div[2]/form/button")).click();
	}

	public void clickOnUpdateButton() {
		getDriver().findElement(By.id("login-submit")).click();
	}
	
	public void clickOnBankDetailsUpdatedButton() {
		getDriver().findElement(By.xpath("html/body/div[1]/div/div/div[2]/form/button")).click();
	}
	
	

}
