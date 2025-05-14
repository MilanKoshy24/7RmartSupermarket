package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends Base {
	NewsPage news;
	HomePage home;
	
	@Test(description="verifying whether user is able to add new news")
	public void addNews() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
	

		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home=login.clickOnLoginButton();
		news=home.manageNewsCardClick();
		
		news.newNewsButtonClick().newNewsContentClick().newsSaveButtonClick();
		
		
		boolean issuccessAlertDisplayed = news.successAlertDisplayed();
		Assert.assertTrue(issuccessAlertDisplayed,Messages.NEWNEWSERROR );
	}

	
	@Test(description="verifying whether user is able to search news")
	public void searchNews() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home=login.clickOnLoginButton();
		
		news=home.manageNewsCardClick();
		news.newsSerachPageClick().searchInputFieldClick().searchButtonClick();
		
		
		boolean issearchAssertionValidated = news.searchAssertion();
		Assert.assertTrue(issearchAssertionValidated, Messages.NEWSSEARCHERROR);
	}
}
