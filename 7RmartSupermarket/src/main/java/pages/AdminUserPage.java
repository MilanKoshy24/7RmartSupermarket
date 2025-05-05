package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {

	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='nav-link']//p[contains(text(),'Admin Users')]")private WebElement sidebarAdminUsers;
	@FindBy(xpath = "//p[text()='Manage Users']")private WebElement sidebarManageUsers;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")private WebElement adminuserNewButton;
	@FindBy(xpath = "//input[@name='username']")private WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']")private WebElement passowrdField;
	@FindBy(xpath = "//select[@name='user_type']")private WebElement usertypeDropdown;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']")private WebElement saveButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")private WebElement searchButton;
	@FindBy(xpath = "//input[@name='un']")private WebElement searchField;
	@FindBy(xpath = "//select[@name='ut']")private WebElement searchUsertypeSelection;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Search']")private WebElement searchingButton;
	@FindBy(xpath = "//h4[text()='Search Admin Users']")private WebElement searchTitle;
	@FindBy(xpath = "//h5[contains(text(), 'Alert')]")private WebElement userCreationSuccessMessage;
	
	
	
	public void sidebarAdminusersClick() {

		sidebarAdminUsers.click();

	}

	public void sidebarManageUsersClick() {

		sidebarManageUsers.click();

	}

	public void adminusersNewButtonClick() {

		adminuserNewButton.click();

	}

	public void usernameInputField(String usernameNew) {

		usernameField.sendKeys(usernameNew);

	}

	public void passwordInputField(String passwordNew) {

		passowrdField.sendKeys(passwordNew);

	}

	public void usertypeDropdownSelection() {

		Select selection = new Select(usertypeDropdown);
		selection.selectByIndex(1);

	}

	public void saveButtonClick() {

		saveButton.click();

	}

	public void searchButtonClick() {

		searchButton.click();
	}

	public void searchFieldClick() {

		searchField.sendKeys("MonkeyDluffy");
	}

	public void searchUserSelectionClick() {

		Select selection = new Select(searchUsertypeSelection);
		selection.selectByIndex(1);

	}

	public void searchingButton() {

		searchingButton.click();

	}
	
	public boolean searchTitleDisplayed() {

		return searchTitle.isDisplayed();
	}
	
	public boolean successAlertDisplayed() {

		return userCreationSuccessMessage.isDisplayed();
	}


}
