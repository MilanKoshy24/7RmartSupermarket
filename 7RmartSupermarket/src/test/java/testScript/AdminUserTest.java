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
	HomePage home;

	@Test(description="Verifying whether new user can be created ")
	public void addNewUser() throws IOException {
		
		

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		AdminUserPage addUser = new AdminUserPage(driver);
		RandomDataUtility random = new RandomDataUtility();

		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();

		addUser.sidebarAdminusersClick();
		addUser.sidebarManageUsersClick();
		addUser.adminusersNewButtonClick();

		String usernameNew = random.createrandomusername();
		String passwordNew = random.createrandompassword();
		addUser.usernameInputField(usernameNew);
		addUser.passwordInputField(passwordNew);

		addUser.usertypeDropdownSelection();
		addUser.saveButtonClick();

		boolean issuccessAlertDisplayed = addUser.successAlertDisplayed();
		Assert.assertTrue(issuccessAlertDisplayed,Messages.NEWUSERERROR );
	}

	@Test(description="Verifying whether newly created user can be searched")
	public void searchUser() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		AdminUserPage addUser = new AdminUserPage(driver);

		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();

		addUser.sidebarAdminusersClick();
		addUser.sidebarManageUsersClick();
		addUser.searchButtonClick();
		addUser.searchFieldClick();
		addUser.searchUserSelectionClick();
		addUser.searchingButton();
		
		boolean isserachTitleDisplayed = addUser.searchTitleDisplayed();
		Assert.assertTrue(isserachTitleDisplayed,Messages.USERSEARCHERROR);

	}

}
