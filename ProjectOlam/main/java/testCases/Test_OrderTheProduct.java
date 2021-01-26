package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
import pageObjects.AlmondsPage_Objects;
import pageObjects.Almonds_SubProduct_Page;
import pageObjects.LoginPage;
import pageObjects.MyAccPage_Objects;
import pageObjects.SecureCheckout;
import pageObjects.ShoppingCart;
import testData.TestDataExcel;
import testData.TestDataValue;
import webDriver.BaseDriver;
import webDriver.PageLoadWait;

public class Test_OrderTheProduct extends BaseDriver {

	public static String pageTitle = "Customer Login";
	public static String TC;
	public static String path;
	public static int statRow = 1;
	public static String Scenario = "Test_OrderTheProduct";

	public static String GRADE, SIZEDESC, PACKSIZE, QUANTITY, PURCHASE_TYPE,PRODUCT,SHOP_MENU_PROD;

	static Map<String, Map<String, String>> datamap = new HashMap<>();

	public static ShoppingCart shpCart;
	public static SecureCheckout secCheckout;
	public static Almonds_SubProduct_Page subAlmonds;
	public static LoginPage loginPage;
	public static MyAccPage_Objects myAccPage_Objects;
	public static  AlmondsPage_Objects almondsPage_Objects;


	@BeforeTest
	public void beforeTest(ITestContext context) throws FileNotFoundException, IOException, BiffException {
		//path = System.getProperty("user.dir")+context.getCurrentXmlTest().getParameter("suite_param");
		path="C:\\Users\\dinesh.kalahasthi\\eclipse-workspace_Photon\\OlamEcom\\src\\resources\\TestData2.xls";
		if (!TestDataValue.isRunnable(path, "Test", Scenario)) {
			throw new SkipException("Skipped: " + Scenario);
		}
		datamap = TestDataExcel.readExcel(path, Scenario);
	}

	@DataProvider
	public String[][] TestData() throws IOException {
		return TestDataValue.testDataProvider(path, Scenario);
	}

	@Test(dataProvider = "TestData")
	public void TestOrderReviewProduct(String TcID, String TcRunnable)
			throws FileNotFoundException, IOException, InterruptedException {

		if (!TcRunnable.equalsIgnoreCase("Y")) {
			TestDataExcel.setValueInoCell(path, Scenario, 2, statRow, "Skip");
			statRow++;
			System.out.println("Test Case is Skipped :  ");
			throw new SkipException("TestCase Skipped: " + TcID);
		}
		//Getting input from Excel sheet
		System.out.println("Executing   ::"+Scenario);
		GRADE = datamap.get(TcID).get("Grade");
		SIZEDESC = datamap.get(TcID).get("SizeDescription");
		PACKSIZE = datamap.get(TcID).get("PackSize");
		QUANTITY = datamap.get(TcID).get("Quantity");
		PURCHASE_TYPE=datamap.get(TcID).get("PurchaseType");
		PRODUCT=datamap.get(TcID).get("Product");
		SHOP_MENU_PROD=datamap.get(TcID).get("shopProduct");
        //Initializing the PageObject classes
		shpCart = new ShoppingCart(driver);
		secCheckout = new SecureCheckout(driver);
		subAlmonds = new Almonds_SubProduct_Page(driver);
		Logger APP_LOG=Logger.getLogger("devpinoyLogger");

		LoginIntoApplication(getURL(), getUserName(), getPassword());
		APP_LOG.info("Logged into the OLAM ECOM Application");
		myAccPage_Objects =new MyAccPage_Objects(driver);
		//clickOnElement(myAccPage_Objects.ALMONDS_XPATH);
		//myAccPage_Objects.MouseHoverShop();						
		myAccPage_Objects.selectProdShop(SHOP_MENU_PROD);
		APP_LOG.info("Choose ALmonds from the Shop menu");
		Thread.sleep(2000);
		almondsPage_Objects = new AlmondsPage_Objects(driver);
		almondsPage_Objects.ClickonsubProduct(PRODUCT);
		// Choose the item as SAMPLE and add to to Cart & Review the Order
		AddPrdToCartReview addPrdToCartReview = new AddPrdToCartReview(getDriver());
		addPrdToCartReview.addSelectedProductToCart(PURCHASE_TYPE, GRADE, SIZEDESC, PACKSIZE, QUANTITY);
		subAlmonds.ClickCartButton();
		subAlmonds.ClickCartReviewOrderBtn();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		shpCart.EnterPONum(); // Enters the PO Number in Shopping Cart page
		shpCart.getContractID();
		shpCart.ClickContinue();
		secCheckout.clickAgreeTerms();
		secCheckout.placeOrder();
		APP_LOG.info("**********************END of Test Case ************************ ");
		TestDataExcel.setValueInoCell(path, Scenario, 2, statRow, "pass");
	    statRow++;
	}
	
	

}
