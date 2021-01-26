package webDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
//import java.util.logging.Logger;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.LogConfig;

public class PageLoadWait {
	
	public static WebDriver driver;
	public static Logger APP_LOG;
	
	public PageLoadWait(WebDriver driver1) {
		this.driver=driver1;
		//APP_LOG=Logger.getLogger("devpinoyLogger");
		APP_LOG=LogConfig.getLogger(this.getClass());
		//BasicConfigurator.configure();
		//PropertyConfigurator.configure(System.getProperty("user.dir")+"//src//Log4j.properties");
		//PageLoadWait.class.getResource(System.getProperty("user.dir")+"//src//Log4j.properties");
			}
	
	//public static WebElement Loader = driver.findElement());
	//public static String AJAX_IMAGE_LOAD="//*[@id='checkout']/div[@class='checkout-loader']/div[@class='loader']/img[@src='http://olam-ecom-vm-qa-app2.southeastasia.cloudapp.azure.com/aus-almond/pub/static/version1545200783/frontend/Olam/almonds/en_US/images/loader-1.gif']";
	public static String AJAX_IMAGE_LOAD="//img[@src='http://olam-ecom-vm-qa-app2.southeastasia.cloudapp.azure.com/aus-almond/pub/static/version1545200783/frontend/Olam/almonds/en_US/images/loader-1.gif']";
	//"//*[@id='maincontent']//div[@class='loader']"
	
	//public static Logger APP_LOG=Logger.getLogger("devpinoyLogger");

	public static WebDriverWait Wait() {
		WebDriverWait wait=new WebDriverWait(driver, 40);
		return wait;
		}
	
	public static FluentWait<WebDriver> fluentWait() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(320, TimeUnit.SECONDS)
		        .pollingEvery(3, TimeUnit.SECONDS)
		        .ignoring(NoSuchElementException.class);
		return wait;
				
	}
	
	
	public static void  LoaderWait(){
		FluentWait<WebDriver> fluentWait=fluentWait();
		FluentWait<WebDriver> fluentWait2=new FluentWait<WebDriver>(driver)
				.withTimeout(40, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class);
		
		try {
			fluentWait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AJAX_IMAGE_LOAD)));
			System.out.println("Waiting for the page to be loaded");
			fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AJAX_IMAGE_LOAD)));
		}
		catch(Exception e){
			System.out.println("Catch in Fluent wait");
		}
		
		
	}
			
}
