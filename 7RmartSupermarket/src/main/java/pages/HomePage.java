package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement topRightAdmin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")
	private WebElement logout;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement pagetitle;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and contains(text(), 'More info')]")
	private WebElement manageNewsCard;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and contains(@class, 'small-box-footer')]")
	private WebElement manageAdminUserCard;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")
	private WebElement categoryButton;

	public NewsPage manageNewsCardClick() {

		manageNewsCard.click();
		return new NewsPage(driver);

	}

	public AdminUserPage manageAdminUserCardClick() {

		manageAdminUserCard.click();
		return new AdminUserPage(driver);

	}

	public CategoryPage categoryButtonClick() {

		categoryButton.click();
		return new CategoryPage(driver);

	}

	public HomePage topRightAdminClick() {

		topRightAdmin.click();
		return this;

	}

	public LoginPage logoutClick() {

		logout.click();
		return new LoginPage(driver);
	}

	public boolean titleDisplayed() {

		return pagetitle.isDisplayed();
	}

}
