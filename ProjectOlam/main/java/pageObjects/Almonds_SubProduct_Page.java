package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import webDriver.PageLoadWait;

public class Almonds_SubProduct_Page extends PageLoadWait{
	//public static WebDriver driver;
	
	public Almonds_SubProduct_Page(WebDriver driver1) {
		// TODO Auto-generated constructor stub
		super(driver1);
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID,using="cart-btn") 
	public static WebElement ADD_TO_CART_ID;
	
	@FindBy(how=How.XPATH,using="//*[@id='product-options-wrapper']/div/div/div[1]/div/div")
	public static WebElement PURCHASE_rBUTTON;
	
	@FindBy(how=How.XPATH,using="//*[@id='product-options-wrapper']/div/div/div[1]/div/div[2]")
	public static WebElement SAMPLE_rBUTTON;
	
	@FindBy(how=How.XPATH,using="//*[@id='product-options-wrapper']/div/div/div[2]/div/div")
	public static List<WebElement> GRADE_DESCRIPTION;
	
	@FindBy(how=How.XPATH,using="//*[@id='product-options-wrapper']/div/div/div[3]/div[@class='swatch-attribute-options clearfix']/div")
	public static List<WebElement> SIZE_DESCRIPTION;	
	
	@FindBy(how=How.XPATH,using="//*[@id='product-options-wrapper']/div/div/div[4]/div/div")
	public static List<WebElement> PACK_SIZE;
	
	@FindBy(how=How.ID,using="userQty")
	public static WebElement QUANITITY;
	
	@FindBy(how=How.ID,using="datepicker")
	public static WebElement DATE_PICKER;
	//*[@id="product_addtocart_form"]/div[2]/div[2]/span[2]/div/span/input[1]
	
	@FindBy(how=How.CLASS_NAME,using="review-order-button")
	public static WebElement REVIEW_ORDER;
	
	@FindBy(how=How.XPATH,using="//span[@class='counter-number']")
	public static WebElement NOTIF_NUMBER;
	
	@FindBy(how=How.XPATH,using="//a[@class='action showcart']")
	public static WebElement CART_BUTTON;
	
	@FindBy(how=How.XPATH,using="//div[@class='product actions']/div[@class='secondary']/a")
	public static List<WebElement> CART_REMOVE_BUTTON;
	//*[@id="mini-cart"]/li/div/div/div[4]/div/a
	
	@FindBy(how=How.XPATH,using="//*[@id='minicart-content-wrapper']/div/div[3]/div[1]/a/span/span")
	public static WebElement CART_REVIVEW_ORDER;
	
	@FindBy(how=How.XPATH,using="//*[@id='product-options-wrapper']/div/div/div[5]/div/div")
	public static WebElement TREATMENT_TYPE;
	
	@FindBy(how=How.XPATH,using="//div[@class='modal-inner-wrap']/footer/button[@class='action-primary action-accept']/span") 
	public static WebElement REMOVE_YES_BUTTON;
	
	@FindBy(how=How.XPATH,using="//div[@class='modal-inner-wrap']/footer/button[@class='action-secondary action-dismiss']/span") 
	public static WebElement REMOVE_NO_BUTTON;
	
	@FindBy(how=How.XPATH,using="//*[@id='maincontent']/div[1]/div[2]/div[1]/div/div")
	public static WebElement ADDED_TO_CART_MSG;
	
	
	
	//int shopItemSize=SHOP_CART_TABLE.size();
	public void clickYesInPopup() {
		Wait().until(ExpectedConditions.elementToBeClickable(REMOVE_YES_BUTTON));
		REMOVE_YES_BUTTON.click();
		APP_LOG.info("Accepting the Pop-up to remove the item from Cart");
	}
	
	public void clickNoInPopup() {
		Wait().until(ExpectedConditions.elementToBeClickable(REMOVE_NO_BUTTON));
		REMOVE_NO_BUTTON.click();
		APP_LOG.info("Decline the Pop-up to remove the item from Cart");
	}
	
			
	public void ClickOnPurchase(){
		Wait().until(ExpectedConditions.elementToBeClickable(PURCHASE_rBUTTON));
		PURCHASE_rBUTTON.click();
	}
	
	public void clickOnSample(){
		Wait().until(ExpectedConditions.elementToBeClickable(SAMPLE_rBUTTON));
		SAMPLE_rBUTTON.click();
	}
	
	public void choosequantity(String num){
		Wait().until(ExpectedConditions.elementToBeClickable(QUANITITY));
		QUANITITY.clear();
		QUANITITY.sendKeys(num);
	}
	Actions action;
	public void ChooseDate(){
		action=new Actions(driver);
		DATE_PICKER.click();
		action.moveToElement(driver.findElement(By.id("ui-datepicker-div"))).build().perform();
		action.moveToElement(driver.findElement(By.className("ui-datepicker-days-cell-over"))).click().build().perform();
		
	}
	
	public void clickAddToCart(){
		Wait().until(ExpectedConditions.elementToBeClickable(ADD_TO_CART_ID));
		ADD_TO_CART_ID.click();
		}
	
	public void ClickCartButton(){
		//wait =new WebDriverWait(driver, 20);
		Wait().until(ExpectedConditions.elementToBeClickable(CART_BUTTON));
		Wait().until(ExpectedConditions.elementToBeClickable(NOTIF_NUMBER));
		CART_BUTTON.click();
		APP_LOG.info("Clicked on Mini Cart Button");
		/*if(CART_BUTTON.isDisplayed()||NOTIF_NUMBER.isDisplayed()) {
		Wait().until(ExpectedConditions.elementToBeClickable(CART_BUTTON));
		CART_BUTTON.click();
		}
		else {
		Wait().until(ExpectedConditions.elementToBeClickable(NOTIF_NUMBER));
		CART_BUTTON.click();}*/
	}
	
	public void clickCartRemoveButton(){
		//wait=new WebDriverWait(driver, 20);
		Wait().until(ExpectedConditions.visibilityOfAllElements(CART_REMOVE_BUTTON));
		APP_LOG.info("Click on  mini Cart Remove button");
		CART_REMOVE_BUTTON.get(0).click();
	}
	
	public void ClickCartReviewOrderBtn(){
		//wait=new WebDriverWait(driver, 20);
		Wait().until(ExpectedConditions.elementToBeClickable(CART_REVIVEW_ORDER));
		APP_LOG.info("Click on  mini cart Review Order Button");
		CART_REVIVEW_ORDER.click();
	}
	
	public void chooseGradeDesc(String Str) {
		
		if(Str.equalsIgnoreCase("Extra Supreme")) {
			       GRADE_DESCRIPTION.get(0).click();
			       }
		else if(Str.equalsIgnoreCase("Supreme")) {
			GRADE_DESCRIPTION.get(1).click();
		}		
		else{
			GRADE_DESCRIPTION.get(2).click();
		}
	}
	
	public void ChooseSizeDesc(String Str) {
		
		if(Str.equalsIgnoreCase("23/25")) {
			SIZE_DESCRIPTION.get(0).click();
		}
		else if(Str.equalsIgnoreCase("25/27")) {
			SIZE_DESCRIPTION.get(1).click();
		}
		else if(Str.equalsIgnoreCase("20/22")) {
			SIZE_DESCRIPTION.get(2).click();
		}
		else if(Str.equalsIgnoreCase("27/30")) {
			SIZE_DESCRIPTION.get(3).click();
		}
		else if(Str.equalsIgnoreCase("30/32")) {
			SIZE_DESCRIPTION.get(4).click();
		}else if(Str.equalsIgnoreCase("18/20")) {
			SIZE_DESCRIPTION.get(5).click();
		}
		else if(Str.equalsIgnoreCase("36/40")) {
			SIZE_DESCRIPTION.get(6).click();
		}
	}
	
	public void ChoosePackSize(String Str) {
		if(Str.equalsIgnoreCase("1T")) {
       PACK_SIZE.get(0).click();}
		else if(Str.equalsIgnoreCase("12.5kg")) {
			PACK_SIZE.get(1).click();
		}		
		else{
			PACK_SIZE.get(2).click();
		}
	}
	
	public void ChooseTreatmentType(){
		TREATMENT_TYPE.click();
	}
	
}