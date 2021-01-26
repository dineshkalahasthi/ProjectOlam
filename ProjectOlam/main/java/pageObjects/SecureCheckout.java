package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webDriver.PageLoadWait;

public class SecureCheckout extends PageLoadWait {

	WebDriver driver;
	public SecureCheckout(WebDriver driver1){
		super(driver1);
		this.driver=driver1;
		PageFactory.initElements(driver, this);
			}
	
	@FindBy(how=How.ID,using="YYWLDNP") 
	public static WebElement DELI_INSTR_TEXT_BOX;
	
	@FindBy(how=How.XPATH,using="//*[@id='checkout-step-shipping]/div[1]/div/div/div[@class='shipping-address-item selected-item']") 
	public static WebElement SHIPPING_ADDRESS;
		
	@FindBy(how=How.XPATH,using="//*[@id='opc-sidebar']/div[2]/div/div/span/input")
	public static WebElement AGREE_TERMS;
	
	@FindBy(how=How.XPATH,using="//*[@id='opc-sidebar']//div[@class='place-order-wrapper']/button")
	public static WebElement PLACE_ORDER;
	
	@FindBy(how=How.XPATH,using="//*[@id='opc-sidebar']//div[@class='place-order-wrapper']/button[2]")
	public static WebElement CANCEL_ORDER;
	
	@FindBy(how=How.XPATH,using="//*[@id='checkout-step-shipping']/div[1]/div/div/div/button/span[contains(text(),'Ship Here')]")
	public static WebElement SHIP_HERE;
	
	@FindBy(how=How.XPATH,using="//*[@id='checkout-payment-method-load']/div/div/div[2]/div[2]/div[1]/div[@class='checkout-billing-address']")
	public static WebElement BILLING_ADDRESS;
	
	WebDriverWait wait;
	
	public void clickAgreeTerms(){
		LoaderWait();
		Wait().until(ExpectedConditions.elementToBeClickable(AGREE_TERMS));
		if(!AGREE_TERMS.isDisplayed()) {
			driver.navigate().refresh();
			Wait().until(ExpectedConditions.elementToBeClickable(AGREE_TERMS));
		}
		AGREE_TERMS.click();
	}
	
	public void placeOrder(){
		Wait().until(ExpectedConditions.elementToBeClickable(PLACE_ORDER));
		PLACE_ORDER.click();
		APP_LOG.info("Clicking on Place order button");
	}
	
	public void calcelOrder(){
		Wait().until(ExpectedConditions.elementToBeClickable(CANCEL_ORDER));
		CANCEL_ORDER.click();
		APP_LOG.info("Clicking on Cancel button ");
	}
	
	public void ValidateShippingAddress() {
		APP_LOG.info("Validating the availability of Shipping Address");
		if(SHIPPING_ADDRESS.isSelected()) {
			//SHIPPING_ADDRESS.click();
			System.out.println(SHIPPING_ADDRESS.getText());
		}
		else if(!SHIPPING_ADDRESS.isEnabled()) {
			System.out.println("Shipping Address is not available");
		}
	}
	
	public void ValidateBillingAddress() {
		APP_LOG.info("Validating the availability of Billing Address");
		if(BILLING_ADDRESS.isEnabled()) {
			//BILLING_ADDRESS.click();
			System.out.println(BILLING_ADDRESS.getText());
		}
		else if(!BILLING_ADDRESS.isEnabled()) {
			System.out.println("Billing Address is not available");
		}
	}
	
}
