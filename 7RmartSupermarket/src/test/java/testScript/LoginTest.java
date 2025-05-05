package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;

import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(priority=1,description="Verifying whether logging in can be done with valid credentials")
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();
		boolean isdashboarddisplayed = login.dashboardDisplayed();
		Assert.assertTrue(isdashboarddisplayed, "User is unable to login successfully");

	}

	@Test(priority=2,description="Verifying whether logging in can be done with valid username and invalid password")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();
		String actual = login.getpagetitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, "User is able to login with invalid username");

	}

	@Test(priority=3,description="Verifying whether logging in can be done with invalid username and valid password")
	public void verifyLoginWithInvalidUsernameAndValidPassword() throws IOException {

		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();
		
		boolean istitleDisplayed = login.titleDisplayed();
		Assert.assertTrue(istitleDisplayed, "user was able to login with invalid credentials");

	}

	@Test(priority=4,description="Verifying whether logging in can be done with invalid credentials")
	public void verifyUserLoginWithInvalidCredentials() throws IOException {

		String username = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();
		
		boolean istitleDisplayed = login.titleDisplayed();
		Assert.assertTrue(istitleDisplayed, "user was able to login with invalid credentials");

	}

}