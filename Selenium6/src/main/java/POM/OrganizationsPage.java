package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement organizationCreateImage;

	@FindBy(name = "accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(id="phone")
	private WebElement phoneTextField;
	
	@FindBy(id="email1")
	private WebElement emailTextBox;

	

	@FindBy(name = "button")
	private WebElement saveButton;

	public WebElement getOrganizationCreateImage() {
		return organizationCreateImage;
	}

	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	public WebElement getEmailTextBox() {
		return emailTextBox;
	}
	
	public void clickOrganizationCreateImage() {
		organizationCreateImage.click();
	}

	public void organizationNameTextField(String orgName) {
		organizationNameTextField.sendKeys(orgName);
	}

	public void phoneTextField(String phonenum) {
		phoneTextField.sendKeys(phonenum);
	}
	
	public void emailTextBox(String emailId) {
		emailTextBox.sendKeys(emailId);
	}
	
	public void saveButton() {
		saveButton.click();
	}
	
}
