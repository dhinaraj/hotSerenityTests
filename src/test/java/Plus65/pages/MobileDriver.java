package Plus65.pages;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class MobileDriver {
	public static AppiumDriver driver = null;
	public static String os=null;
	

	public static void setupAndroidDriver() { 
	  os="android";
      File appDir = new File("/Users/prasad/Arrowme_Mobile/arrowme_partimer_mobile/android/app/build/outputs/apk/");
      File app = new File(appDir, "app-release.apk");
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability("platformName", "Android");
      capabilities.setCapability("platformVersion", "7.0");
      capabilities.setCapability("deviceName", "device");
      capabilities.setCapability("automationName", "uiautomator2");
      capabilities.setCapability("app", app.getAbsolutePath());
      capabilities.setCapability("newCommandTimeout", 800);
      //capabilities.setCapability("bundleId", "com.plus65dev.partimer");
      try {
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

      	} catch (MalformedURLException e) {
      		// TODO Auto-generated catch block
      		e.printStackTrace();
      	}
      
    }
	
	
	public static void setupIOSDriver() { 
		os="ios";
		File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File("/Users/prasad/Library/Developer/Xcode/DerivedData/arrowme_partimer_mobile-aknatudpzelxmogzwemewuuwjait/Build/Products/Debug-iphonesimulator/");
//	   File appDir = new File("/Users/prasad/Library/Developer/Xcode/DerivedData/arrowme_partimer_mobile-aknatudpzelxmogzwemewuuwjait/Build/Products/Debug-iphoneos/");

		File app = new File(appDir, "arrowme_partimer_mobile.app");
//		File app = new File(appDir, "ArrowMii 2.0.4.ipa");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "10.3");
        capabilities.setCapability("deviceName", "iPhone 6s");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("newCommandTimeout", 800);
//        capabilities.setCapability("bundleId", "com.plus65dev.partimer");
//        capabilities.setCapability("xcodeConfigFile", "/Users/prasad/Desktop/a.xcconfig");
//        capabilities.setCapability("udid", "47b51179ccabec2c4a11cc7c80630f9322c53a3a");
        try {
			driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
    		Thread.sleep(3000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
          if(driver.findElementsByAccessibilityId("Allow").size()>=1)
          	driver.findElementByAccessibilityId("Allow").click();
          try {
    		Thread.sleep(2000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
	}
    
}
