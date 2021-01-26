package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;import org.openqa.selenium.support.ui.ExpectedConditions;

import webDriver.PageLoadWait;

public class Success_PageObjects extends PageLoadWait{

	public Success_PageObjects(WebDriver driver1) {
		super(driver1);
		this.driver=driver1;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='maincontent']/div[3]/div/div[2]/p[1]") 
	public static WebElement SUCCESS_MSG;
	
	@FindBy(how=How.XPATH,using="//*[@id='maincontent']/div[3]/div/div[2]/p[2]") 
	public static WebElement ORDER_NUM;
	
	@FindBy(how=How.XPATH,using="//*[@id='maincontent']/div[3]/div/div[2]/div[1]/div[1]/div[2]/div[3]/address") 
	public static WebElement SHIPPING_ADDRESS;
	//#maincontent > div.columns > div > div.checkout-success > div.box.box-order-shipping-method > div.box-container > div.box-content > div:nth-child(3) > address
	
	@FindBy(how=How.XPATH,using="//*[@id='maincontent']/div[3]/div/div[2]/div[1]/div[1]/div[2]/div[1]/address") 
	public static WebElement BILLING_ADDRESS;
	
	
	
	
	
	
	public void getSuccessMsg() {
		//SUCCESS_MSG.getText();
		Wait().until(ExpectedConditions.visibilityOf(SUCCESS_MSG));
		System.out.println(SUCCESS_MSG.getText());
	}
	
	public void getOrderNum() {
		System.out.println(" Your Order Number is ::");
		System.out.println(ORDER_NUM.getText());
	}

	public void ValidateShippingAddress() {
		APP_LOG.info("Validating the availability of Shipping Address");
		System.out.println("Shipping Address is ::");
		if(SHIPPING_ADDRESS.isEnabled()) {
			//SHIPPING_ADDRESS.click();
			System.out.println(SHIPPING_ADDRESS.getText());
		}
		else if(!SHIPPING_ADDRESS.isEnabled()) {
			System.out.println("Shipping Address is not available");
		}
	}
	
	public void ValidateBillingAddress() {
		APP_LOG.info("Validating the availability of Billing Address");
		System.out.println("Billing  Address is ::");
		if(BILLING_ADDRESS.isEnabled()) {
			//BILLING_ADDRESS.click();
			System.out.println(BILLING_ADDRESS.getText());
		}
		else if(!BILLING_ADDRESS.isEnabled()) {
			System.out.println("Billing Address is not available");
		}
	}
	
	public void SuccessPageActions() {
		getSuccessMsg();
		getOrderNum();
		ValidateShippingAddress();
		System.out.println("**********************************");
		ValidateBillingAddress();
	}
}
