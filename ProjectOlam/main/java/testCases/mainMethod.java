package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
import testData.TestDataValue;

public class mainMethod {
	
	static WebDriver driver;
	String Scenario="Cart_DeleteItem";
	@BeforeTest
	public void beforeTest(ITestContext context) throws FileNotFoundException, IOException, BiffException {
	String	path1 = System.getProperty("user.dir")+context.getCurrentXmlTest().getParameter("suite_param");
	System.out.println(path1);
		String path="C:\\Users\\dinesh.kalahasthi\\eclipse-workspace_Photon\\OlamEcom\\Resources\\TestData2.xls";
		if (!TestDataValue.isRunnable(path, "Test", Scenario)) {
			throw new SkipException("Skipped: " + Scenario);
		}
		//datamap = TestDataExcel.readExcel(path, Scenario);
	}

		
	/*public static void main(String[] args) throws FileNotFoundException, IOException {
		String Browser = TestPropertyFile.readPropFile("Browser");
	if(Browser.equalsIgnoreCase("Firefox")){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dinesh.kalahasthi\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		ProfilesIni profile=new ProfilesIni();
		FirefoxProfile myProfile = profile.getProfile("WebDriver");
		myProfile.setPreference("browser.popups.showPopupBlocker", false);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(myProfile);
		driver = new FirefoxDriver(firefoxOptions);	
	}
	else if(Browser.equalsIgnoreCase("Chrome")){
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver");
		driver=new ChromeDriver();
	}	
	else{S
		System.out.println("Browser is not initiated");
	}
}*/
	//public static void main(String[] args) throws BiffException, IOException {
		/*String path="C:\\Users\\dinesh.kalahasthi\\eclipse-workspace_Photon\\OlamEcom\\Resources\\TestData2.xls";
	//	TestDataExcel.readExcel(path, "Test_Login");
		System.out.println("*************************");
		TestDataExcel.readTcRunnable(path, "Test_Login");
		System.out.println("*************************");*/
	//	TestDataValue.testDataProvider(path, "Test_Login");
		//String	path1 = System.getProperty("user.dir")+context.getCurrentXmlTest().getParameter("suite_param");
	@Test
	public void main() {
		System.out.println("path");}
		
		/*
		Workbook wrkbk=Workbook.getWorkbook(new File(path));
		int NoOfSheets=wrkbk.getNumberOfSheets();
		System.out.println(NoOfSheets);
		String[] sheet=wrkbk.getSheetNames();
		for (String sheets : sheet) {
			System.out.println(sheets);
			
		}
		Sheet workSheet=wrkbk.getSheet("Test_Login");
		TestDataValue.testDataProvider(path, "Test_Login");
		wrkbk.close();*/
	}
//}