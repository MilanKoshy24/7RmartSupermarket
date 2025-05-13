package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;

import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(priority = 1, description = "Verifying whether logging in can be done with valid credentials", retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();

		boolean isdashboarddisplayed = login.dashboardDisplayed();
		Assert.assertTrue(isdashboarddisplayed, Messages.VALIDCREDENTIALERROR);

	}

	@Test(priority = 2, description = "Verifying whether logging in can be done with valid username and invalid password", groups = {
			"smoke" })
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();

		String actual = login.getpagetitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Messages.VALIDUSERNAMEINVALIDPASSWORD);

	}

	@Test(priority = 3, description = "Verifying whether logging in can be done with invalid username and valid password", groups = {
			"smoke" })
	public void verifyLoginWithInvalidUsernameAndValidPassword() throws IOException {

		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();

		boolean istitleDisplayed = login.titleDisplayed();
		Assert.assertTrue(istitleDisplayed, Messages.INVALIDUSERNAMEVALIDPASSWORDERROR);

	}

	@Test(dataProvider = "loginProvider", priority = 4, description = "Verifying whether logging in can be done with invalid credentials")
	public void verifyUserLoginWithInvalidCredentials(String username, String password) throws IOException {

		// String username = ExcelUtility.getStringData(3, 0, "LoginPage");
		// String password = ExcelUtility.getStringData(3, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnLoginButton();

		boolean istitleDisplayed = login.titleDisplayed();
		Assert.assertTrue(istitleDisplayed, Messages.INVALIDCREDENTIALERROR);

	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {
		return new Object[][] { new Object[] { "1234", "1234" }, new Object[] { "1234", "1234" }

		};

	}
}