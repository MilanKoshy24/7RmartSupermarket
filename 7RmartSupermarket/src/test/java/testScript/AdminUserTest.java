package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base {

	AdminUserPage admin;
	HomePage home;

	@Test(description = "Verifying whether new user can be created ")
	public void addNewUser() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		RandomDataUtility random = new RandomDataUtility();

		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickOnLoginButton();

		admin = home.manageAdminUserCardClick();

		admin.adminusersNewButtonClick();

		String usernameNew = random.createrandomusername();
		String passwordNew = random.createrandompassword();
		admin.usernameInputField(usernameNew).passwordInputField(passwordNew).usertypeDropdownSelection()
				.saveButtonClick();

		boolean issuccessAlertDisplayed = admin.successAlertDisplayed();
		Assert.assertTrue(issuccessAlertDisplayed, Messages.NEWUSERERROR);
	}

	@Test(description = "Verifying whether newly created user can be searched")
	public void searchUser() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickOnLoginButton();

		admin = home.manageAdminUserCardClick();
		admin.searchButtonClick().searchFieldClick().searchUserSelectionClick().searchingButton();

		boolean isserachTitleDisplayed = admin.searchTitleDisplayed();
		Assert.assertTrue(isserachTitleDisplayed, Messages.USERSEARCHERROR);

	}

}
