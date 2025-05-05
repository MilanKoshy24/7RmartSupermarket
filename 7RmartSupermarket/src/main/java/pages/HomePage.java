package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")private WebElement topRightAdmin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")private WebElement logout;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")private WebElement pagetitle;

	public void topRightAdminClick() {

		topRightAdmin.click();

	}

	public void logoutClick() {

		logout.click();
	}

	public boolean titleDisplayed() {

		return pagetitle.isDisplayed();
	}

}
