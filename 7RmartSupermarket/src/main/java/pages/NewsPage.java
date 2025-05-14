package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;

public class NewsPage {

	public WebDriver driver;

	public NewsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add' and contains(text(), 'New')]")
	private WebElement newNewsButton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement newNewsContent;
	@FindBy(xpath = "//button[@type='submit' and text()='Save']")
	private WebElement newsSaveButton;
	@FindBy(xpath = "//div[contains(@class, 'alert-success') and contains(., 'News Created Successfully')]")
	private WebElement newsCreationSuccessMessage;
	@FindBy(xpath = "//a[contains(text(), 'Search')]")
	private WebElement newsSerachPage;
	@FindBy(xpath = "//input[@name='un']")
	private WebElement searchInputField;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchButton;
	@FindBy(xpath = "//h1[@class='m-0 text-dark' and contains(text(), 'Manage News')]")
	private WebElement searchAssertionValidation;

	public NewsPage newNewsButtonClick() {

		newNewsButton.click();
		return this;

	}

	public NewsPage newNewsContentClick() {

		newNewsContent.sendKeys(Constant.NEWNEWSCONTENT);
		return this;

	}

	public NewsPage newsSaveButtonClick() {

		newsSaveButton.click();
		return this;

	}

	public boolean successAlertDisplayed() {

		return newsCreationSuccessMessage.isDisplayed();
	}

	public NewsPage newsSerachPageClick() {

		newsSerachPage.click();
		return this;
	}

	public NewsPage searchInputFieldClick() {

		searchInputField.sendKeys(Constant.NEWSSEARCHCONTENT);
		return this;

	}

	public NewsPage searchButtonClick() {

		searchButton.click();
		return this;

	}

	public boolean searchAssertion() {

		return searchAssertionValidation.isDisplayed();
	}

}
