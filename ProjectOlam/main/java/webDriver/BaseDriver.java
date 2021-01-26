package webDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.HomePage_Objects;
import pageObjects.LoginPage;
import resources.LogConfig;
import testData.TestPropertyFile;

public class BaseDriver extends TestPropertyFile {

	public static WebDriver driver;
	public static String UserNameField = "email";
	public static String PasswordField = "pass";
	public static String LoginButton = "send";
	public static Logger APP_LOG;

	public String LoadDataFromExcel() throws FileNotFoundException, IOException {
		File file = new File(getTestData2());
		return file.getAbsolutePath();
	}
	
	@BeforeMethod
	public void setBaseDriver() throws FileNotFoundException, IOException {
		driver = setDriver(createDriver());
		maximumScreenSize();
		APP_LOG=LogConfig.getLogger(BaseDriver.class);
		//BasicConfigurator.configure();
		//PropertyConfigurator.configure(System.getProperty("user.dir")+"//src//Log4j.properties");
	}

	protected void maximumScreenSize() {
		getDriver().manage().window().maximize();
	}

	protected WebDriver createDriver() throws FileNotFoundException, IOException {
		return createDriver("unnamed test");
	}

	protected WebDriver createDriver(String testName) throws FileNotFoundException, IOException {
		return InitiateDriver.LoadDriver();
	}

	public WebDriver setDriver(WebDriver driver) {
		return driver;

	}

	public WebDriver getDriver() {
		return driver;
	}
	
	
	private WebElement getUserNameField() {
		return getDriver().findElement(By.id(UserNameField));
	}

	public  void EnterUserName(String User) {
		getUserNameField().sendKeys(User);
	}
	
	public void clickOnElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", element);
	}
	
	
	private WebElement getPasswordField() {
		return getDriver().findElement(By.id(PasswordField));
	}

	public void EnterPassword(String PWD) {
		getPasswordField().sendKeys(PWD);
	}

	
	private WebElement getLoginButton() {
		return getDriver().findElement(By.name(LoginButton));
	}
	
	public void ClickOnLoginButton() {
		getLoginButton().click();
	}

	// Methods implemented and used from this Login Page
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public LoginPage LoginIntoApplication(String ApplicationUrl, String User, String PWD) throws InterruptedException {
		getDriver().get(ApplicationUrl);
		APP_LOG.info("Launching Application URL");
		HomePage_Objects homepage=new HomePage_Objects(getDriver());
		homepage.clickMyAccount();
		APP_LOG.info("Clicking on MYAccount Button");
		EnterUserName(User);
		EnterPassword(PWD);
		APP_LOG.info("Entered Credentials");
		ClickOnLoginButton();
		APP_LOG.info("Clicked on LOGIN Button");
		Thread.sleep(7000);
		return new LoginPage(getDriver());
	}

	@AfterMethod
	public void AfterTest() {
		driver.quit();
	}
	
	
		
		//BasicConfigurator.configure();
	
	
	public WebDriver InitiateDriver() throws FileNotFoundException, IOException {
		driver=InitiateDriver.LoadDriver();
		driver.manage().window().maximize();
		
		return driver;
	}

}
