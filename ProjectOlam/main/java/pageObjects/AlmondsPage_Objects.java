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

public class AlmondsPage_Objects extends PageLoadWait{
	WebDriver driver;

	
	//@FindBy(how=How.XPATH,using="//*[@id='maincontent']//div[contains(text(),'Almonds Kern NP')]") 
	@FindBy(how=How.XPATH,using="//*[@id='maincontent']//div[@class='prod-name']")
	public static WebElement Almonds_Kern_NP;
	
	@FindBy(how=How.XPATH,using="//*[@id='maincontent']//div[@class='prod-name']")
	public static WebElement Almonds_Kernel_Carmel;
	
	@FindBy(how=How.XPATH,using="//*[@id='maincontent']/div[4]/div/div[3]/ol/li")
	public static List<WebElement> ALMONDS_PROD_LIST;
	
		
	public AlmondsPage_Objects(WebDriver driver1){
		super(driver1);
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}
	
	public void selectProduct(String Product) {
		int size=ALMONDS_PROD_LIST.size();
		for(int i=1;i<=size;i++) {
			WebElement SUB_PRODUCT=driver.findElement(By.xpath("//ol[@class='product-items row prod-display']/li["+i+"]/div/div[2]/div"));
			String subProd=SUB_PRODUCT.getText();
			//System.out.println(subProd);
			if(Product.equalsIgnoreCase(subProd)) {
				APP_LOG.info("Getting the sub Product object to be clicked");
				WebElement clickProduct=driver.findElement(By.xpath("//ol[@class='product-items row prod-display']/li["+i+"]/div/div[3]/div[2]/button"));
				Wait().until(ExpectedConditions.elementToBeClickable(clickProduct));
				APP_LOG.info("Clicking on Sub-Product  :"+subProd);
				clickProduct.click();
				break;
			}
			
		}
	}
	
	public void getTextOfSubProduct(WebElement subProduct){
		System.out.println(subProduct.getText());
	}
	public void ClickonsubProduct(String subProduct) {
		//subProduct.findElement(By.xpath("//*[@id='maincontent']//button[@class='prod-btn']/span")).click();
		selectProduct(subProduct);
	}
}
