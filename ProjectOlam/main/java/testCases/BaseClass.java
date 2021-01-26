package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import jxl.read.biff.BiffException;
import testData.TestDataExcel;
import testData.TestDataValue;

public class BaseClass {
	
	WebDriver driver;
	String path;
	String Scenario;
	Map<String,Map<String,String>> datamap=new HashMap<>();
	
	public BaseClass(WebDriver driver1) {
		// TODO Auto-generated constructor stub
		this.driver=driver1;
	}
	
	
	@BeforeTest
	public void beforeTest() throws FileNotFoundException, IOException, BiffException {
		//path = TestPropertyFile.readPropFile("TestDataPath");
		path="C:\\Users\\dinesh.kalahasthi\\eclipse-workspace_Photon\\OlamEcom\\Resources\\TestData2.xls";
		
		if(!TestDataValue.isRunnable(path, "Test", Scenario)) {
			throw new SkipException("Skipped: " +Scenario);
		}
		datamap=TestDataExcel.readExcel(path, "Test_Login");
	}
	
	
@AfterTest
public void afterTest() {
	if(driver!=null) {
		driver.quit();
	}
}
	

}
