package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;

public class CategoryPage {

	public WebDriver driver;

	public CategoryPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
	private WebElement newCategoryButton;
	@FindBy(xpath = "//input[@id='category']")
	private WebElement categoryName;
	@FindBy(xpath = "//li[@id='134-selectable']")
	private WebElement groupSelection;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement categoryImage;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement categorySave;
	@FindBy(xpath = "//div[contains(@class, 'alert-success')]")
	private WebElement categoryAddedMessage;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@name='un']")
	private WebElement searchInput;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement inputSearch;
	@FindBy(xpath = "//h4[contains(text(), 'Search List Categories')]")
	private WebElement searchAssertion;

	public CategoryPage newCategoryButtonClick() {

		newCategoryButton.click();
		return this;

	}

	public CategoryPage categoryNameClick() {

		categoryName.sendKeys(Constant.CATEGORYNAME);
		return this;

	}

	public CategoryPage groupSelectionClick() {

		groupSelection.click();
		return this;

	}

	public CategoryPage categoryImageInput() {

		categoryImage.sendKeys(Constant.CATEGORYIMAGE);
		return this;

	}

	public CategoryPage categorySaveClick() {

		categorySave.click();
		return this;

	}

	public boolean categoryAddedMessgeDisplayed() {

		return categoryAddedMessage.isDisplayed();
	}

	public CategoryPage searchButtonClick() {

		searchButton.click();
		return this;

	}

	public CategoryPage searchInputClick() {

		searchInput.sendKeys(Constant.CATEGORYSEARCHINPUT);
		return this;

	}

	public CategoryPage inputSearchClick() {

		inputSearch.click();
		return this;
	}

	public boolean searchAssertionDisplayed() {

		return searchAssertion.isDisplayed();
	}

}
