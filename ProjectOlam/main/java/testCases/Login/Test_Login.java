package testCases.Login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jxl.read.biff.BiffException;
import pageObjects.HomePage_Objects;
import pageObjects.LoginPage;
import testData.TestDataExcel;
import testData.TestDataValue;
import testData.TestPropertyFile;
import webDriver.BaseDriver;


public class Test_Login extends BaseDriver {
	//public static WebDriver driver;
	private String USERNAME,PWD;
	String pageTitle="Customer Login";
	public String Scenario="Test_Login";
	String TC;
	String path;
	int    statRow=1;
	LoginPage loginPage;
	HomePage_Objects homePage;
	BaseDriver dr;
	
	Map<String,Map<String,String>> datamap=new HashMap<>();
	
@BeforeTest
public void beforeTest(ITestContext context) throws FileNotFoundException, IOException, BiffException {
	//path = TestPropertyFile.readPropFile("TestDataPath");
	//path=System.getProperty("user.dir")+context.getCurrentXmlTest().getParameter("suite_param");
   path="/Users/dineshkalahasthi/ProjectOlam/resources/TestData2.xls";	
//path="C:\\Users\\dinesh.kalahasthi\\eclipse-workspace_Photon\\OlamEcom\\src\\resources\\TestData2.xls";
	//Scenario=System.getProperty("user.dir")+context.getCurrentXmlTest().getParameter("Scenario");
	//path = System.getProperty("user.dir")+context.getCurrentXmlTest().getParameter("suite_param");
	//System.out.println(path);
	
	if(!TestDataValue.isRunnable(path, "Test", Scenario)) {
		throw new SkipException("Skipped: " +Scenario);
	}
	datamap=TestDataExcel.readExcel(path, Scenario);
}

@DataProvider
public Object[][] TestData() throws IOException {	
return TestDataValue.testDataProvider(path, Scenario);
}

@Test(dataProvider="TestData")
	public void Login(String TcId,String TcRunnable ) throws FileNotFoundException, IOException, InterruptedException {
	
	if(!TcRunnable.equalsIgnoreCase("Y")) {
		TestDataExcel.setValueInoCell(path, Scenario, 2, statRow, "Skip");
		statRow++;
		System.out.println("Test Case is Skipped :  ");
		throw new SkipException("TestCase Skipped: "+ TcId);
	}
	System.out.println("Executing   ::"+Scenario);
	//Logger APP_LOG=Logger.getLogger("devpinoyLogger");
	
	//PropertyConfigurator.configure(TestPropertyFile.readPropFile("Log4j"));
	//BasicConfigurator.configure();
	//Logging(APP_LOG,Scenario,"Initiating WebDriver");
	
	//driver=initiateDriver.InitiateDriver();
	//Initializing the page object classes by invoking the constructors
	APP_LOG.info("Initializing the reference page objects");
	loginPage=new LoginPage(driver);
	homePage=new HomePage_Objects(driver);
	APP_LOG.info("Logging into the application");
	LoginIntoApplication(getURL(), getUserName(), getPassword());
	Thread.sleep(5000);
	APP_LOG.info("**********************END of Test Case ************************ ");
    TestDataExcel.setValueInoCell(path, Scenario, 2, statRow, "pass");
    statRow++;
			}
/*
@AfterTest
public void AfterTest(){
	if(driver!=null) {
	driver.quit();}
}*/

}