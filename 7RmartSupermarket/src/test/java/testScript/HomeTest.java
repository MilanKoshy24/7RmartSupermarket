package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {

	HomePage home;

	@Test(description = "Verifying whether user is able to logout after logging in")
	public void logout() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickOnLoginButton();

		home.topRightAdminClick().logoutClick();

		boolean istitleDisplayed = login.titleDisplayed();
		Assert.assertTrue(istitleDisplayed, Messages.LOGOUTERROR);
	}

}
