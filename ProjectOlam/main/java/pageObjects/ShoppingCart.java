package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import webDriver.PageLoadWait;

public class ShoppingCart extends PageLoadWait{

	static WebDriver driver;
	public ShoppingCart(WebDriver driver1){
		super(driver1);
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID,using="po_number")
	public static WebElement PO_NUMBER;
	
	@FindBy(how=How.XPATH,using="//*[@id='form-validate']/div[1]/div[2]/span[2]")
	public static WebElement CONTRACT_ID;
	
	@FindBy(how=How.XPATH,using="//*[@id='shopping-cart-table']/tbody/tr")
	public static List<WebElement> SHOP_CART_TABLE;
	
	@FindBy(how=How.XPATH,using="//td/div/span[@class='product-item-name']")
	public static WebElement SHOP_CART_TABLE_PROD_NAME;
	
	@FindBy(how=How.XPATH,using="")
	public static WebElement SHP_CART_QUANTITY;
	
	@FindBy(how=How.ID,using="cart-6160-delivery-date")
	public static WebElement SHP_CART_DATE;
	
	@FindBy(how=How.XPATH,using="//*[@id='shopping-cart-table']//a[@class='action action-delete']")
	public static WebElement SHP_CART_DEL_BTN;
	
	@FindBy(how=How.XPATH,using="//*[@id='maincontent']//button[@class='continue']") 
	public static WebElement CONTINUE_BTN;
	
	@FindBy(how=How.XPATH,using="//*[@id='maincontent']//button[@class='cancel']") 
	public static WebElement CANCEL_BTN;
	
	/*@FindBy(how=How.XPATH,using="//div[@class='modal-inner-wrap']/footer/button[@class='action-primary action-accept']/span") 
	public static WebElement REMOVE_YES_BUTTON;
	
	@FindBy(how=How.XPATH,using="//div[@class='modal-inner-wrap']/footer/button[@class='action-secondary action-dismiss']/span") 
	public static WebElement REMOVE_NO_BUTTON;
	*/
	
	
	//int shopItemSize=SHOP_CART_TABLE.size();
	/*public void clickYesInPOpup() {
		Wait(driver).until(ExpectedConditions.elementToBeClickable(REMOVE_YES_BUTTON));
		REMOVE_YES_BUTTON.click();
	}
	
	public void clickNoInPOpup() {
		Wait(driver).until(ExpectedConditions.elementToBeClickable(REMOVE_NO_BUTTON));
		REMOVE_YES_BUTTON.click();
	}*/
	
	public void EnterPONumber(String PO_Num){
		Wait().until(ExpectedConditions.elementToBeClickable(CONTINUE_BTN));
		PO_NUMBER.clear();
		PO_NUMBER.sendKeys(PO_Num);
		APP_LOG.info("PO Number Entered : "+PO_Num);
	}
	public void getContractID(){
		System.out.println("Getting the contract ID   :"+CONTRACT_ID.getText());
		
	}
		
	public void EnterPONum(){
		PO_NUMBER.clear();
		PO_NUMBER.sendKeys("445566");
	}
	
	/*public void SelectPrdRow(){
		System.out.println(shopItemSize);
		Action.moveToElement(SHOP_CART_TABLE.get(shopItemSize)).moveToElement(SHP_CART_QUANTITY).sendKeys("1");
		}*/
	
	public void ClickContinue(){
		Wait().until(ExpectedConditions.elementToBeClickable(CONTINUE_BTN));
		CONTINUE_BTN.click();
		APP_LOG.info("Clicked on Continue button to proceed with the order");
	}
	
	public void ValidateCartList() {
		for(int i=0;i<SHOP_CART_TABLE.size();i++){
			SHOP_CART_TABLE.get(i);
			String Prod=SHOP_CART_TABLE.get(i).findElement(By.xpath("//td/div/span[@class='product-item-name']")).getText();
			System.out.println(Prod);
		}
		
	}
	
	public void ContinueShopping() {
		APP_LOG.info("Enter PO Number");
		EnterPONum();
		getContractID();
		ClickContinue();
	}
	
}
