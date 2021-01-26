package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import testData.TestPropertyFile;

public class initiateDriver {
	public static WebDriver driver;
	public static String Browser;
	public static String URL;
	
	public initiateDriver(WebDriver driver1){
		this.driver=driver1;
	}
	
	public static WebDriver InitiateDriver() throws FileNotFoundException, IOException{
		URL= TestPropertyFile.readPropFile("URL");
		Browser= TestPropertyFile.readPropFile("Browser");
	if(Browser.equalsIgnoreCase("Firefox")){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dinesh.kalahasthi\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		ProfilesIni profile=new ProfilesIni();
		FirefoxProfile myProfile = profile.getProfile("WebDriver");
		myProfile.setPreference("browser.popups.showPopupBlocker", false);

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(myProfile);
		driver = new FirefoxDriver(firefoxOptions);	
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	else if(Browser.equalsIgnoreCase("Chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dinesh.kalahasthi\\Selenium_Required Things\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	else{
		System.out.println("Browser is not initiated");
	}
	return driver;
		
}
	}