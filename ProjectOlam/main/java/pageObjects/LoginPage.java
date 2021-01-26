package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public static String inValidLoginMessage = "//div[@class='page messages']//div[@data-bind='html: message.text']";
	public static String forgotPasswordLink ="//a[@class='remind']";
	public static String titleTextForForgotPasswordPage= "//div[@class='page-title-wrapper']//h1//span";
		
		
	//Initializing the WebElements of the Login Page
	@FindBy(how=How.XPATH,using="//*[@id='email']") 
	public static  WebElement UserNameField;
	
	@FindBy(how=How.XPATH,using="//*[@id='pass']") 
	public static  WebElement PasswordField;
	
	@FindBy(how=How.XPATH,using="//*[@id='send2']/span") 
	public static  WebElement LoginButton;
	
	//Adding the Constructor of the class, which is gets the reference driver object from the actual class file
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Methods to perform actions on each of this page objects
	public void EnterUserName(String User){
		UserNameField.sendKeys(User);
	}

	public void EnterPassword(String PWD){
		PasswordField.sendKeys(PWD);
	}
	public void ClickLoginButton(){
		LoginButton.click();
	}
	
	//Methods implemented and used from this Login Page
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public void AccountLogin(String User,String PWD){
		EnterUserName(User);
		EnterPassword(PWD);
		ClickLoginButton();
	}
	
	private WebElement getInValidLoginMessageElement() throws InterruptedException {
		Thread.sleep(4000);
		return driver.findElement(By.xpath(inValidLoginMessage));
	}
	
	public boolean isInValidLoginMessageDisplayed() throws InterruptedException {
		return getInValidLoginMessageElement().getText().contains("Invalid login or password.");
	}
	
	private WebElement getForgotPasswordLink() {
		return driver.findElement(By.xpath(forgotPasswordLink));
	}
	
	public void clickOnForgotPasswordLink(String URL) {
		driver.get(URL);
		getForgotPasswordLink().click();
	}
		
	public boolean isForgotPasswordPageDisplayed() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath(titleTextForForgotPasswordPage)).getText());
		return driver.findElement(By.xpath(titleTextForForgotPasswordPage)).getText().contains("FORGOT YOUR PASSWORD");
		
		
	}
	
}
