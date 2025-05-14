package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base{
	
	HomePage home;
	CategoryPage category;

	@Test(description="verifying whether user is able to add new category")
	public void addCategory() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		

		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home=login.clickOnLoginButton();
		
		category=home.categoryButtonClick();
	
		category.newCategoryButtonClick().categoryNameClick().groupSelectionClick().categoryImageInput().categorySaveClick();
		
		
			
		boolean iscategoryAddedMessgeDisplayed = category.categoryAddedMessgeDisplayed();
		Assert.assertTrue(iscategoryAddedMessgeDisplayed, Messages.NEWCATEGORYERROR);
	}
	
	@Test(description="verifying whether user is able to search category")
	public void searchCategory() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		

		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home=login.clickOnLoginButton();
		category=home.categoryButtonClick();
	
		category.searchButtonClick().searchInputClick().inputSearchClick();
		
	
		
		
			
		boolean issearchAssertionDisplayed = category.searchAssertionDisplayed();
		Assert.assertTrue(issearchAssertionDisplayed,Messages.CATEGORYSEARCHERROR);
	}
	
	
}
