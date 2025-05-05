package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsPage {

	public WebDriver driver;

	public NewsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and contains(text(), 'More info')]")private WebElement manageNewsCard;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add' and contains(text(), 'New')]")private WebElement newNewsButton;
	@FindBy(xpath = "//textarea[@id='news']")private WebElement newNewsContent;
	@FindBy(xpath = "//button[@type='submit' and text()='Save']")private WebElement newsSaveButton;
	@FindBy(xpath = "//div[contains(@class, 'alert-success') and contains(., 'News Created Successfully')]")private WebElement newsCreationSuccessMessage;
	@FindBy(xpath = "//a[contains(text(), 'Search')]")private WebElement newsSerachPage;
	@FindBy(xpath = "//input[@name='un']")private WebElement searchInputField;
	@FindBy(xpath = "//button[@name='Search']")private WebElement searchButton;
	@FindBy(xpath = "//h1[@class='m-0 text-dark' and contains(text(), 'Manage News')]")private WebElement searchAssertionValidation;

	

	
	
	public void manageNewsCardClick() {

		manageNewsCard.click();

	}
	
	public void newNewsButtonClick() {

		newNewsButton.click();

	}
	public void newNewsContentClick() {

		newNewsContent.sendKeys("Milans new news 3");

	}
	public void newsSaveButtonClick() {

		newsSaveButton.click();

	}
	
	public boolean successAlertDisplayed() {

		return newsCreationSuccessMessage.isDisplayed();
	}
	
	public void newsSerachPageClick() {

		newsSerachPage.click();

	}
	
	public void searchInputFieldClick() {

		searchInputField.sendKeys("milan");

	}
	
	public void searchButtonClick() {

		searchButton.click();

	}
	
	public boolean searchAssertion() {

		return searchAssertionValidation.isDisplayed();
	}
	
}
