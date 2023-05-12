package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsCreationPage {

	public ContactsCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement contactCreateImage;

	@FindBy(name = "lastname")
	private WebElement lastNameTextField;

	@FindBy(xpath = "//td[text()='Organization Name 			']/..//img[@src='themes/softed/images/select.gif']")
	private WebElement selectdropdown;

	@FindBy(name = "account_name")
	private WebElement organizationNameText;

	@FindBy(id = "search_txt")
	private WebElement searchbox;

	@FindBy(name = "search")
	private WebElement searchbutton;

	@FindBy(name = "button")
	private WebElement saveButton;

	public WebElement getContactCreateImage() {
		return contactCreateImage;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getSelectdropdown() {
		return selectdropdown;
	}

	public WebElement getOrganizationNameText() {
		return organizationNameText;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	// business Logic
	public void clickContactCreateImage() {
		contactCreateImage.click();
	}

	public void enterLastNameTextField(String exceldata) {
		lastNameTextField.sendKeys(exceldata);
	}

	public void clickSelectDropdown() {
		selectdropdown.click();
	}

	public void clickOrganizationNameText() {
		organizationNameText.click();
	}

	public void enterSearchBox(String data) {
		searchbox.sendKeys(data);
	}

	public void clickSearchButton() {
		searchbutton.click();
	}

	public void clickSaveButton() {
		saveButton.click();
	}
}
