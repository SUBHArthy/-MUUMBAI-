package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement campaignCreateImage;

	@FindBy(name = "campaignname")
	private WebElement campaignNameTextField;

	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement selectDropdown;

	@FindBy(id = "search_txt")
	private WebElement searchbox;

	@FindBy(name = "search")
	private WebElement searchbutton;

	@FindBy(name = "button")
	private WebElement saveButton;

	public WebElement getCampaignCreateImage() {
		return campaignCreateImage;
	}

	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getSelectDropdown() {
		return selectDropdown;
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

	public void clickCampaignCreateImage() {
		campaignCreateImage.click();
	}

	public void enterCampaignNameTextField(String exceldata) {
		campaignNameTextField.sendKeys(exceldata);
	}

	public void clickSelectDropdown() {
		selectDropdown.click();
	}

	public void enterSearchbox(String productname) {
		searchbox.sendKeys(productname);
	}

	public void clickSearchbutton() {
		searchbutton.click();
	}

	public void clickSaveButton() {
		saveButton.click();
	}

}
