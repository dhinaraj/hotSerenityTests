package Plus65.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by glen on 22/12/16.
 */


@DefaultUrl("https://staging-admin.arrowmepro.com/auth/login")



public class AdminHomepage extends PageObject{
	FileWriter fout;
	BufferedWriter bw;


    @Override
    public WebDriver getDriver() { return super.getDriver();}

    public void enterEmailAddress(String email) {  getDriver().manage().window().maximize();  getDriver().findElement(By.xpath("//div/form/div[2]/div/input")).sendKeys(email);}

    public void enterPassword(String pwd) { getDriver().findElement(By.xpath("//div/form/div[3]/div/input")).sendKeys(pwd);}


    public void clickSignIn() { getDriver().findElement(org.openqa.selenium.By.id("login-submit")).click();}

	public void logout() {
		getDriver().findElement(org.openqa.selenium.By.xpath("//i[contains(text(),'arrow_drop_down')]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().findElement(org.openqa.selenium.By.xpath("//a[contains(text(),'Logout')]")).click();
		
	}
	
	public void quitAdminDriver() {
		getDriver().quit();
	}

	 public void checkPageLoadTimeasArrowmiiAdmin(){
		 		getDriver().manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		 		getDriver().manage().timeouts().pageLoadTimeout(120000, TimeUnit.MILLISECONDS);
		 		
		 		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 		Date date = new Date();
		 		
		 		getDriver().get("https://staging-admin.arrowmepro.com/auth/login");

	    		
	    	    getDriver().findElement(By.id("email")).clear();
	    	    getDriver().findElement(By.id("email")).sendKeys("arrowme@email.com");
	    	    getDriver().findElement(By.id("password")).clear();
	    	    getDriver().findElement(By.id("password")).sendKeys("123qwe");
	    	    getDriver().findElement(By.id("login-submit")).click();

	    	    
	    	    while(true)
	    	    {
		 		
		 		try {
					fout= new  FileWriter  (new File(new File(".").getAbsolutePath()+"/Logs","Admin-"+ dateFormat.format(date) +".txt"), true);
					bw= new BufferedWriter(fout);
					
				getDriver().findElement(By.linkText("Dashboard")).click();
	    	    getDriver().findElement(By.xpath("//div[2]/div/div/div/ul/li[2]/a/div")).click();
	    	    logTime("Jobs-Dashboard");
	    	    getDriver().findElement(By.xpath("//div[2]/div/div/div/ul/li[3]/a")).click();
	    	    logTime("Sales-Dashboard");
	    	    getDriver().findElement(By.xpath("//div[2]/div/div/div/ul/li/a/div")).click();
	    	    logTime("Gerneral-Dashboard");
	    	    
	    	    getDriver().findElement(By.linkText("Users")).click();
	    	    logTime("Admin-Users");
	    	    getDriver().findElement(By.xpath("//div[2]/div/ul/li[2]/a")).click();	//Part timers
	    	    logTime("Part timer-Users");
	    	    getDriver().findElement(By.xpath("//div[2]/div/ul/li[3]/a")).click();   //Blacklists'
	    	    logTime("Blacklist-Users");
	    	    
	    	    getDriver().findElement(By.linkText("Enterprises")).click();
	    	    logTime("Enterprises");
	    	    
	    	    getDriver().findElement(By.xpath("//li[4]/ul/li/a")).click();
	    	    getDriver().findElement(By.linkText("Owning Groups")).click();
	    	    logTime("Owning Groups-Setup");
	    	    getDriver().findElement(By.linkText("Corporate Chains")).click();
	    	    logTime("Corporate Chains-Setup");
	    	    
	    	    getDriver().findElement(By.xpath("//li[5]/ul/li/a")).click();
	    	    getDriver().findElement(By.linkText("Credit")).click();
	    	    logTime("Credit-Manage");
	    	    getDriver().findElement(By.linkText("Service Lines")).click();
	    	    logTime("Service Lines-Manage");
	    	    getDriver().findElement(By.linkText("Skill Tests")).click();
	    	    logTime("Skill Tests-Manage");
	    	    getDriver().findElement(By.linkText("Referral Bonus")).click();
	    	    logTime("Referral Bonus-Manage");
	    	    getDriver().findElement(By.linkText("Enterprise Types")).click();
	    	    logTime("Enterprise Types-Manage");
	    	    
	    	    getDriver().findElement(By.xpath("//li[6]/ul/li/a")).click();
	    	    getDriver().findElement(By.linkText("Part Timer Data")).click();
	    	    logTime("Part Timer Data-Reports");
	    	    getDriver().findElement(By.linkText("Part Timer Rating")).click();
	    	    logTime("Part Timer Rating-Reports");
	    	    getDriver().findElement(By.linkText("Service Line Usage")).click();
	    	    logTime("Service Line Usage-Reports");
	    	    getDriver().findElement(By.linkText("Fulfilment Rate")).click();
	    	    logTime("Fulfilment Rate-Reports");
	    	    getDriver().findElement(By.linkText("Fund Management")).click();
	    	    logTime("Fund Management-Reports");
	    	    
	    	    getDriver().findElement(By.xpath("//li[7]/ul/li/a")).click();
	    	    getDriver().findElement(By.linkText("Configuration")).click();
	    	    logTime("Configuration-Systemsettings");
	    	    getDriver().findElement(By.linkText("Skill Test Translation")).click();
	    	    logTime("Skill Test Translation-Systemsettings");
	    	    getDriver().findElement(By.linkText("General Translation")).click();
	    	    logTime("General Translation-Systemsettings");
	    	    
	    	    getDriver().findElement(By.xpath("(//li[@id='inactive']/a)[4]")).click();
	    	    getDriver().findElement(By.linkText("Batch Part Timer Upload")).click();
	    	    logTime("Batch Part Timer Upload-Tools");
	    	    getDriver().findElement(By.linkText("Matching Logic Finder")).click();
	    	    logTime("Matching Logic Finder-Tools");
	    	    getDriver().findElement(By.linkText("Ratings Calculator")).click();
	    	    logTime("Ratings Calculator-Tools");
	    	    getDriver().findElement(By.linkText("Broadcasting Iterator")).click();
	    	    logTime("Broadcasting Iterator-Tools");
	    	    getDriver().findElement(By.linkText("Commander")).click();
	    	    logTime("Commander-Tools");
	    	    
	    	    
		 		} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	    finally {

					try {

						if (bw != null)
							bw.close();

						if (fout != null)
							fout.close();

					} catch (IOException ex) {

						ex.printStackTrace();

					}

				}
	    	    }
	    }
	 	public void logTime(String pageName)
	 	{
	 		Long loadtime = (Long)((JavascriptExecutor)getDriver()).executeScript(
	 			    "return performance.timing.loadEventEnd - performance.timing.navigationStart;");
	 		try {
	 			bw.write(pageName + "\t" + loadtime + "\t" + new Date());
	 			bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		
	 	}
}
