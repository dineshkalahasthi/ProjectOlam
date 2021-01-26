package pageObjects;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import resources.LogConfig;
import webDriver.PageLoadWait;

public class MyAccPage_Objects extends PageLoadWait{
	
    static WebDriver driver;
	Logger log=LogConfig.getLogger(this.getClass());
			//getLogger("devpinoyLogger");
	
	public MyAccPage_Objects(WebDriver driver1){
		super(driver1);
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}
	
	
	/*@FindBy(how=How.CSS,using="div.container-fluid.nav-container > ul>li.level0.nav-1.level-top.parent>a>span")  
	public static  WebElement SHOP_XPATH;*/
	@FindBy(how=How.XPATH,using="//div[@class='container-fluid nav-container']/ul/li[1]/a/span[2]")  
	public static  WebElement SHOP_XPATH;

	@FindBy(how=How.XPATH,using="//*[@id='ui-id-12']/li[1]/ul/li")  
	public static  List<WebElement> SHOP_MENU;
	//div[@class='container-fluid nav-container']/ul/li[1]/ul/li/a/span
	
	@FindBy(how=How.XPATH,using="//a//span[contains(text(),'Almonds')]")  
	public static  WebElement ALMONDS_XPATH;
	
	@FindBy(how=How.XPATH,using="//*[@id='ui-id-22']/span[contains(text(),'Walnuts')]") 
	public static  WebElement WALNUTS_XPATH;
	
	@FindBy(how=How.XPATH,using="//*[@id='ui-id-23']/span[contains(text(),'Pistachios')]")  
	public static  WebElement PISTACHIOS_XPATH;
	
	@FindBy(how=How.XPATH,using="//*[@id='ui-id-24']/span[contains(text(),'Hazelnuts')]")  
	public static  WebElement HAZELNUTS_XPATH;
	
	@FindBy(how=How.XPATH,using="//*[@id='ui-id-25']/span[contains(text(),'Cashew')]")  
	public static  WebElement CASHEW_XPATH;
	
	@FindBy(how=How.XPATH,using="//*[@id='ui-id-26']/span[contains(text(),'Peanuts')]")  
	public static  WebElement PEANUTS_XPATH;
	
	public static Actions action;
		
	public static void MouseHoverShop(){
		//Wait().until(ExpectedConditions.visibilityOf(SHOP_XPATH));
		action=new Actions(driver);
		action.moveToElement(SHOP_XPATH).build().perform();
			}
	
	public static void selectAlmonds(){
		action.moveToElement(ALMONDS_XPATH).click().build().perform();
	}
	
	public  void selectProdShop(String ShopProd) {
		int size=SHOP_MENU.size();
		for(int i=1;i<=size;i++) {
			APP_LOG.info("Getting the Product object to be clicked");
		WebElement SHOP_PROD= driver.findElement(By.xpath("//div[@class='container-fluid nav-container']/ul/li[1]/ul/li["+i+"]/a/span"));
		String text=SHOP_PROD.getAttribute("innerHTML");
		//System.out.println(text);
		if(ShopProd.equalsIgnoreCase(text)) {
			APP_LOG.info("Clicking on Product  :"+text);
			//action.moveToElement(driver.findElement(By.xpath("//div[@class='container-fluid nav-container']/ul/li[1]/ul/li["+i+"]/a/span"))).click().build().perform();
			//action.moveToElement(driver.findElement(By.xpath("//ul/li["+i+"]"))).click().build().perform();
				JavascriptExecutor executor = (JavascriptExecutor)driver;
			    executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@class='container-fluid nav-container']/ul/li[1]/ul/li["+i+"]/a/span")));
			
			break;
		}
	}
	
	}
	
}
