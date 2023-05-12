package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {

	public InvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Invoice...']")
	private WebElement invoiceCreateImage;

	@FindBy(xpath = "//td[text()='Contact Name 			']/..//img[@src='themes/softed/images/select.gif']")
	private WebElement selectDropDownContact;

	@FindBy(xpath = "//td[text()='Organization Name 			']/..//img[@src='themes/softed/images/select.gif']")
	private WebElement selectDropDownOrganization;

	@FindBy(id = "search_txt")
	private WebElement searchbox;

	@FindBy(name = "search")
	private WebElement searchbutton;

	@FindBy(name = "button")
	private WebElement saveButton;

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getInvoiceCreateImage() {
		return invoiceCreateImage;
	}

	public WebElement getSelectDropDownContact() {
		return selectDropDownContact;
	}

	public WebElement getSelectDropDownOrganization() {
		return selectDropDownOrganization;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void clickInvoiceCreateImage() {
		invoiceCreateImage.click();
	}

	public void clickSelectDropDownContact() {
		selectDropDownContact.click();

	}

	public void clickSelectDropDownOrganization() {
		selectDropDownOrganization.click();

	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void enterSearchbox(String exceldata) {
		searchbox.sendKeys(exceldata);
	}

	public void clickSearchbutton() {
		searchbutton.click();
	}

}
