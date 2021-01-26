package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestPropertyFile {

	public static String readPropFile(String Key) throws FileNotFoundException, IOException{
		String Value;
		Properties prop = new Properties();
		File file=new File("resources/Login.properties");
		String PropFile=file.getAbsolutePath();
		prop.load(new FileInputStream (PropFile));
		Value=prop.getProperty(Key);
		return Value;
	}
	
	public static String getURL() throws FileNotFoundException, IOException {
		return readPropFile("LoginURL");
	}
	
	public static String getUserName() throws FileNotFoundException, IOException {
		return readPropFile("UserName");
	}
	
	
	public static String getPassword() throws FileNotFoundException, IOException {
		return readPropFile("Pwd");
	}
	
	public static String getTestData2() throws FileNotFoundException, IOException {
		return readPropFile("TestData2");
	}
	
}
