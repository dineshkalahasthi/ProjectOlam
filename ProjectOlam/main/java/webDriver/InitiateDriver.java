package webDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import testData.TestPropertyFile;

public class InitiateDriver {
	public static WebDriver driver;
	public static String Browser;
	public static String URL;

	
	private static boolean isFirefox(String driveType) {
		return driveType.equalsIgnoreCase("Firefox");

	}

	private static boolean isChrome(String driveType) {
		return driveType.equalsIgnoreCase("Chrome");

	}

	private static WebDriver setFireFoxDriver() {
		File file = new File("src\\drivers\\geckodriver.exe");
		String fireFoxDriver = file.getAbsolutePath();
		System.setProperty("webdriver.gecko.driver", fireFoxDriver);
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myProfile = profile.getProfile("WebDriver");
		myProfile.setPreference("browser.popups.showPopupBlocker", false);
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setProfile(myProfile);
		return new FirefoxDriver(firefoxOptions);
	}

	private static WebDriver setChromeDrive() {
		File file = new File("/Users/dineshkalahasthi/Drivers/chromedriver_87");
		String chromeDriver = file.getAbsolutePath();
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		return new ChromeDriver();

	}

	public static WebDriver LoadDriver() throws FileNotFoundException, IOException {
		URL = TestPropertyFile.readPropFile("URL");
		Browser = TestPropertyFile.readPropFile("Browser");
		if (isFirefox(Browser)) {
			driver = setFireFoxDriver();
	
		} else if (isChrome(Browser)) {
			driver = setChromeDrive();
		}

		else {
			System.out.println("Browser is not initiated");	
			driver=null;
		}
		return driver;
	}
}