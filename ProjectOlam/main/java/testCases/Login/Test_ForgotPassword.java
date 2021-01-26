package testCases.Login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import webDriver.BaseDriver;

public class Test_ForgotPassword extends BaseDriver {

	@Test
	public void VerifyUserIsNavigatedToForgotPasswordPage() throws FileNotFoundException, IOException, InterruptedException {		
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.clickOnForgotPasswordLink(getURL());
		Assert.assertTrue(loginPage.isForgotPasswordPageDisplayed());
		Logger.getLogger("").info("User is navigated to forgot password page.");
		
	}

}