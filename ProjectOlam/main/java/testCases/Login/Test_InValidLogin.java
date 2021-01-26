package testCases.Login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import webDriver.BaseDriver;

public class Test_InValidLogin extends BaseDriver {
	
	@Test
	public void VerifyUserIsAbleToLoginIntoApplication() throws FileNotFoundException, IOException, InterruptedException {
		LoginPage loginPage =  LoginIntoApplication(getURL(), getUserName(),"test123");
		Assert.assertTrue(loginPage.isInValidLoginMessageDisplayed());
		Logger.getLogger("").info("Validation message is shown");
		
	}

}