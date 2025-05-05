package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	
	
	public WebDriver driver;

	public CategoryPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")private WebElement categoryButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")private WebElement newCategoryButton;
	@FindBy(xpath = "//input[@id='category']")private WebElement categoryName;
	@FindBy(xpath = "//li[@id='134-selectable']")private WebElement groupSelection;
	@FindBy(xpath = "//input[@id='main_img']")private WebElement categoryImage;
	@FindBy(xpath = "//button[@name='create']")private WebElement categorySave;
	@FindBy(xpath = "//div[contains(@class, 'alert-success')]")private WebElement categoryAddedMessage;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")private WebElement searchButton;
	@FindBy(xpath = "//input[@name='un']")private WebElement searchInput;
	@FindBy(xpath = "//button[@name='Search']")private WebElement inputSearch;
	@FindBy(xpath = "//h4[contains(text(), 'Search List Categories')]")private WebElement searchAssertion;
	
	
	
	
	
	public void categoryButtonClick() {

		categoryButton.click();

	}

	public void newCategoryButtonClick() {

		newCategoryButton.click();

	}

	public void categoryNameClick() {

		categoryName.sendKeys("mangos3");

	}
	
	public void groupSelectionClick() {

		groupSelection.click();

	}
	
	public void categoryImageInput() {

		categoryImage.sendKeys("C:\\Users\\milan\\eclipse-workspace\\7RmartSupermarket\\src\\test\\resources\\mango.jpg");

	}
	
	public void categorySaveClick() {

		categorySave.click();

	}
	
	
	public boolean categoryAddedMessgeDisplayed() {

		return categoryAddedMessage.isDisplayed();
	}

	
	public void searchButtonClick() {

		searchButton.click();

	}
	
	public void searchInputClick() {

		searchInput.sendKeys("mangos");

	}
	
	public void inputSearchClick() {

		inputSearch.click();

	}
	
	
	public boolean searchAssertionDisplayed() {

		return searchAssertion.isDisplayed();
	}
	
	

}
