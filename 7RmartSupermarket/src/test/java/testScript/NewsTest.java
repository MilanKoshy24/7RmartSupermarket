package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;

public class NewsTest extends Base {
	
	@Test(description="verifying whether user is able to add new news")
	public void addNews() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		NewsPage news = new NewsPage(driver);

		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();
		
		news.manageNewsCardClick();
		news.newNewsButtonClick();
		news.newNewsContentClick();
		news.newsSaveButtonClick();
		
		
		boolean issuccessAlertDisplayed = news.successAlertDisplayed();
		Assert.assertTrue(issuccessAlertDisplayed, "New news creation is not successful");
	}

	
	@Test(description="verifying whether user is able to search news")
	public void searchNews() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		NewsPage news = new NewsPage(driver);

		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnLoginButton();
		
		news.manageNewsCardClick();
		news.newsSerachPageClick();
		news.searchInputFieldClick();
		news.searchButtonClick();
		
		
		boolean issearchAssertionValidated = news.searchAssertion();
		Assert.assertTrue(issearchAssertionValidated, "search is not not successful");
	}
}
