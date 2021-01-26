package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.Almonds_SubProduct_Page;
import webDriver.PageLoadWait;

public class AddPrdToCartReview extends PageLoadWait{
	
	static WebDriver driver;
	public static Almonds_SubProduct_Page subAlmonds;
	static WebDriverWait wait;
	
	public AddPrdToCartReview(WebDriver driver1) {
		// TODO Auto-generated constructor stub
		super(driver1);
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}
	
	 
	 
	 public void PurchaseAddPrdToCart(String Grade,String SizeDesc,String PackSize,String Quantity) throws InterruptedException{
		 subAlmonds=new Almonds_SubProduct_Page(driver);
		 //wait=new WebDriverWait(driver, 20);
		 Wait().until(ExpectedConditions.elementToBeClickable(subAlmonds.REVIEW_ORDER));
		 subAlmonds.ClickOnPurchase();
		 APP_LOG.info("Click on Purchase ");
		 //System.out.println(subAlmonds.GRADE_DESCRIPTION.size());
		 
		 if(subAlmonds.GRADE_DESCRIPTION.size()>0) {
			 subAlmonds.chooseGradeDesc(Grade);
			 APP_LOG.info("Select GRADE options");
		 }
		 
		 if(ExpectedConditions.visibilityOfAllElements(subAlmonds.SIZE_DESCRIPTION)!=null) {
			 subAlmonds.ChooseSizeDesc(SizeDesc);
			 APP_LOG.info("Select Size Description options");
		 }
		 if(ExpectedConditions.visibilityOfAllElements(subAlmonds.PACK_SIZE)!=null) {
			 subAlmonds.ChoosePackSize(PackSize);
			 APP_LOG.info("Select Pack Size options");
		 }
		 subAlmonds.choosequantity(Quantity);
		// subAlmonds.ChooseTreatmentType();
		 APP_LOG.info("Select Quanitity options");
		 subAlmonds.ChooseDate();
		    subAlmonds.clickAddToCart();
		    APP_LOG.info("Click on 'ADD to Cart' Button");
		    Wait().until(ExpectedConditions.visibilityOf(subAlmonds.ADDED_TO_CART_MSG));
		    System.out.println(subAlmonds.ADDED_TO_CART_MSG.getText());
		    /* subAlmonds.ClickCartButton();
		    subAlmonds.ClickCartReviewOrderBtn();*/
		    		 
	 }
	 
	 public static void SampleAddToCart(){
		 subAlmonds=new Almonds_SubProduct_Page(driver);
		 subAlmonds.clickOnSample();
		 APP_LOG.info("Click on Sample Radio option");
		 subAlmonds.choosequantity("1");
		 APP_LOG.info("Choose the  Quanity options");
		    subAlmonds.clickAddToCart();
		    APP_LOG.info("Click on 'ADD to Cart' Button");
		    /*subAlmonds.ClickCartButton();
		    subAlmonds.ClickCartReviewOrderBtn();*/
		 
	 }

	public void addSelectedProductToCart(String ProductType,String Grade,String SizeDesc,String PackSize,String Quantity) throws InterruptedException {
		if(ProductType.equalsIgnoreCase("Purchase")) {
		    PurchaseAddPrdToCart(Grade,SizeDesc,PackSize,Quantity);
		    }
		    else if(ProductType.equalsIgnoreCase("Sample"))
		    {
		        AddPrdToCartReview.SampleAddToCart();}
		
	}
	 

}
