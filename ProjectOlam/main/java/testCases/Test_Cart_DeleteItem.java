package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

public class Test_Cart_DeleteItem extends BaseDriver {

	public static String pageTitle = "Customer Login";
	public static String TC;
	public static String path;
	public static int statRow = 1;
	public static String Scenario = "Test_Cart_DeleteItem";

	public static String GRADE, SIZEDESC, PACKSIZE, QUANTITY, PURCHASE_TYPE,PRODUCT;

	static Map<String, Map<String, String>> datamap = new HashMap<>();

	public static ShoppingCart shpCart;
	public static SecureCheckout secCheckout;
	public static Almonds_SubProduct_Page subAlmonds;
	public static LoginPage loginPage;
	public static MyAccPage_Objects myAccPage_Objects;
	public static  AlmondsPage_Objects almondsPage_Objects;


	@BeforeTest
	public void beforeTest(ITestContext context) throws FileNotFoundException, IOException, BiffException {
		path = System.getProperty("user.dir")+context.getCurrentXmlTest().getParameter("suite_param");
		//path="C:\\Users\\dinesh.kalahasthi\\eclipse-workspace_Photon\\OlamEcom\\src\\resources\\TestData2.xls";
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
        //Initializing the PageObject classes
		shpCart = new ShoppingCart(driver);
		secCheckout = new SecureCheckout(driver);
		subAlmonds = new Almonds_SubProduct_Page(driver);

		LoginIntoApplication(getURL(), getUserName(), getPassword());
		myAccPage_Objects =new MyAccPage_Objects(getDriver());
		clickOnElement(myAccPage_Objects.ALMONDS_XPATH);
		Thread.sleep(2000);
		almondsPage_Objects = new AlmondsPage_Objects(getDriver());
		almondsPage_Objects.ClickonsubProduct(PRODUCT);
		// Choose the item as SAMPLE and add to to Cart & Review the Order
		AddPrdToCartReview addPrdToCartReview = new AddPrdToCartReview(getDriver());
		addPrdToCartReview.addSelectedProductToCart(PURCHASE_TYPE, GRADE, SIZEDESC, PACKSIZE, QUANTITY);
		WebDriverWait wait = new WebDriverWait(driver, 30);
    	subAlmonds.ClickCartButton();
    	subAlmonds.clickCartRemoveButton();    
    	subAlmonds.clickYesInPopup();
    	APP_LOG.info("**********************END of Test Case ************************ ");
		TestDataExcel.setValueInoCell(path, Scenario, 2, statRow, "pass");
	    statRow++;
	}
		
}
