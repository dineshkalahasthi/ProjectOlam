package pageObjects;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webDriver.PageLoadWait;

public class HomePage_Objects extends PageLoadWait{

	WebDriver driver;
	//public String MY_ACCOUNT_XPATH="//div[@class='dropdown']/button/li/a[contains(text(),'My Account')]";
		
	public HomePage_Objects(WebDriver driver1){
		super(driver1);
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}
	Actions action;
	
	///html/body/div[1]/header/div[2]/ul/div/button/li/a
	@FindBy(how=How.XPATH,using= "//div[@class='dropdown']/button/li/a[contains(text(),'My Account')]") ////div[@class='dropdown']/button/li/a[contains(text(),'My Account')]
	public static WebElement MyAccountButton;
	
	// Main Menu dropdown objects
		@FindBy(how=How.XPATH,using="//*[@id='ui-id-17']/span[contains(text(),'News & Markets Insights')]")
		public static WebElement NEWS_MARKETS;
		
		@FindBy(how=How.XPATH,using="//*[@id='ui-id-18']/span[2][contains(text(),'Our Supply Chain')]")
		public static WebElement OUR_SUPPLY_CHAIN;
		
		@FindBy(how=How.XPATH,using="//*[@id='ui-id-19']/span[contains(text(),'About Olam')]")
		public static WebElement ABOUT_OLAM;
		
		@FindBy(how=How.XPATH,using="//*[@id='ui-id-20']/span")
		public static WebElement FAQ;
		
		@FindBy(how=How.XPATH,using="//div[@class='footer-section-categories']/div/li[3]/a")
		public static WebElement FAQ_FOOTER;
		
		@FindBy(how=How.ID,using="search")
		public static WebElement SEARCH_BOX;
		
		@FindBy(how=How.XPATH,using="//strong[@class='logo']/img")
		public static WebElement OLAM_IMAGE;
		
		@FindBy(how=How.XPATH,using="ui-id-15")
		public static WebElement MENU_BAR;
		
		@FindBy(how=How.XPATH,using="//div[@class='minicart-wrapper']/a")
		public static WebElement CART_BUTTON;
		
		@FindBy(how=How.XPATH,using="//*[@id='maincontent']/div[2]/div/div[@class='widget block block-static-block']")
		public static WebElement NEW_ARRIVALS_SECTION;
		
		@FindBy(how=How.XPATH,using="//*[@id='maincontent']//div[@class='block-content']/ol")
		public static List<WebElement> NEW_ARRIVALS_PRODUCTS_LIST;	
		
		@FindBy(how=How.XPATH,using="//*[@id=\"maincontent\"]//div[@class='block-title']/h2[contains(text(),'PURCHASE BY CATEGORY')]")
		public static WebElement PROD_BY_CATEGORY;
		
		@FindBy(how=How.XPATH,using="//*[@id=\"maincontent\"]//div[@class='block-content']/ol[@class='category-items row']")
		public static List<WebElement> PROD_BY_CAT_LIST;
		
	
		
	
	//Methods to do actions on the web Elements	
	public void clickMyAccount(){
		Wait().until(ExpectedConditions.visibilityOf(MyAccountButton));
		MyAccountButton.click();
	}
	public void clickInputSearchBox(String SearchCriteria) {
		Wait().until(ExpectedConditions.visibilityOf(SEARCH_BOX));
		SEARCH_BOX.clear();
		SEARCH_BOX.sendKeys(SearchCriteria);		
	}
	public void ClickCartbutton() {
		Wait().until(ExpectedConditions.visibilityOf(CART_BUTTON));
		CART_BUTTON.click();
	}
	
	//Validation Methods of Home Page
	public void validateLogo() {
		Wait().until(ExpectedConditions.visibilityOf(OLAM_IMAGE));
		APP_LOG.info("  OLAM Inage is present on the screen ");
	}
	
	public void validateMyAccBut() {
		Wait().until(ExpectedConditions.visibilityOf(MyAccountButton));
		APP_LOG.info("  My Account button is available on the screen ");
	}
		
	public void ValidateMenuBar() {
		Wait().until(ExpectedConditions.visibilityOf(MENU_BAR));
		APP_LOG.info("  All the Menu Options are available on the screen ");
	}
	
	public void ValidateSearchBox() {
		Wait().until(ExpectedConditions.visibilityOf(SEARCH_BOX));
		APP_LOG.info("  Search Box is available on the screen ");
	}
	
	public void validateNewArrivals(int index) {
		Wait().until(ExpectedConditions.visibilityOf(NEW_ARRIVALS_SECTION));
		APP_LOG.info("  New Arrival section is available in Home Page ");
		NEW_ARRIVALS_PRODUCTS_LIST.get(index).click();
		Wait().until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='tab-label-product.info.specs-title'][contains(text(),'PRODUCT DETAILS')]"))));	
		APP_LOG.info("Product details page can be navigated by clicking on new arrivals list");
	}
	
	public void validateProdByCategory(int ind) {
		Wait().until(ExpectedConditions.visibilityOf(PROD_BY_CATEGORY));
		APP_LOG.info("  Product by Category section is available in Home Page ");
		PROD_BY_CAT_LIST.get(ind).click();
		Wait().until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='maincontent']//ol//div[contains(text(),'Almonds Inshell Non Periel')]"))));	
		APP_LOG.info("Product List page can be navigated by clicking on new arrivals list");
	}
	
}
