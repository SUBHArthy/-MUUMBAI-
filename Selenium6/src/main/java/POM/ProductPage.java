package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement productCreateImage;

	@FindBy(name = "productname")
	private WebElement productNameTextBox;

	@FindBy(name = "button")
	private WebElement saveButton;

	public WebElement getProductCreateImage() {
		return productCreateImage;
	}

	public WebElement getProductNameTextBox() {
		return productNameTextBox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void clickProductCreateImage() {
		productCreateImage.click();
	}

	public void enterProductNameTextBox(String exceldata) {
		productNameTextBox.sendKeys(exceldata);
	}

	public void clickSaveButton() {
		saveButton.click();
	}
}
