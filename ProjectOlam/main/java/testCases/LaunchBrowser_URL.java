package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import testData.TestPropertyFile;

public class LaunchBrowser_URL {

	WebDriver driver;
	public static String URL;	
	//public static FirefoxProfile WebDriver;
	public LaunchBrowser_URL(WebDriver driver1){
		this.driver = driver1;
	}
	
	public static WebDriver LaunchBrowser(WebDriver driver) throws FileNotFoundException, IOException{
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dinesh.kalahasthi\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		//DesiredCapabilities cap=DesiredCapabilities.firefox();
		//cap.setCapability(FirefoxDriver.PROFILE, "WebDriver");
		//driver=new FirefoxDriver(cap);
		/*FirefoxOptions options = new FirefoxOptions()
			    .setProfile(new FirefoxProfile());*/
		//ProfilesIni profile=new ProfilesIni();
	//	FirefoxProfile myProfile = profile.getProfile("WebDriver");
			 driver = new FirefoxDriver();
		URL=TestPropertyFile.readPropFile("URL");
		driver.get(URL);
		return driver;
	}
	
	/*public static void main(String[] args) throws IOException {
		LaunchBrowser(driver);
		}*/
}
