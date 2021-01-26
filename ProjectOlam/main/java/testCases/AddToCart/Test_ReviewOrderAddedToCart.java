package testCases.AddToCart;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
import testCases.AddPrdToCartReview;
import testData.TestDataExcel;
import testData.TestDataValue;
import webDriver.BaseDriver;

public class Test_ReviewOrderAddedToCart extends BaseDriver {

	// public static WebDriver driver;
	public static String pageTitle = "Customer Login";
	public static String TC;
	public static String path;
	public static int statRow = 1;
	public static String Scenario = "Test_OrderTheProduct";
	//public static String PURCHASE_TYPE = "Purchase";
	public static String GRADE, SIZEDESC, PACKSIZE, QUANTITY, PURCHASE_TYPE,PRODUCT;
	Map<String, Map<String, String>> datamap = new HashMap<>();

	public static LoginPage loginPage;
	public static MyAccPage_Objects myAccPage_Objects;
	public static  AlmondsPage_Objects almondsPage_Objects;
	public static Almonds_SubProduct_Page subAlmonds;

	@BeforeTest
	public void beforeTest(ITestContext context) throws FileNotFoundException, IOException, BiffException {
		path = super.LoadDataFromExcel();
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

		GRADE = datamap.get(TcID).get("Grade");
		SIZEDESC = datamap.get(TcID).get("SizeDescription");
		PURCHASE_TYPE=datamap.get(TcID).get("PurchaseType");
		PACKSIZE = datamap.get(TcID).get("PackSize");
		QUANTITY = datamap.get(TcID).get("Quantity");
		PRODUCT=datamap.get(TcID).get("Product");
		LoginIntoApplication(getURL(), getUserName(), getPassword());

		myAccPage_Objects =new MyAccPage_Objects(getDriver());
		subAlmonds=new Almonds_SubProduct_Page(driver);
		clickOnElement(myAccPage_Objects.ALMONDS_XPATH);

		Thread.sleep(2000);
		almondsPage_Objects = new AlmondsPage_Objects(getDriver());
		almondsPage_Objects.ClickonsubProduct(PRODUCT);
		AddPrdToCartReview addPrdToCartReview = new AddPrdToCartReview(getDriver());
		addPrdToCartReview.addSelectedProductToCart(PURCHASE_TYPE, GRADE, SIZEDESC, PACKSIZE, QUANTITY);
		subAlmonds.ClickCartButton();
	    subAlmonds.ClickCartReviewOrderBtn();
	}

}
