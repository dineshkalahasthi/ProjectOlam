package testCases;

import org.apache.log4j.Logger;
import org.testng.Reporter;

public class ErrorReport {

	public void Logging(Logger APP_LOG,String testDataType,String Message) {
		APP_LOG.info(testDataType+ " " +Message);
		Reporter.log(testDataType+ " " +Message+"<br>");
	}
	
}
