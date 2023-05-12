package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.Webdriver_Utility;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// declaration
	@FindBy(linkText = "Products")
	private WebElement productLinkText;

	@FindBy(linkText = "More")
	private WebElement morelink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLinkText;

	@FindBy(linkText = "Organizations")
	private WebElement organizationLinkText;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutImg;

	@FindBy(linkText = "Contacts")
	private WebElement contactLinkText;

	@FindBy(linkText = "Invoice")
	private WebElement invoiceLinkText;

	

	public void setInvoiceLinkText(WebElement invoiceLinkText) {
		this.invoiceLinkText = invoiceLinkText;
	}

	// @FindBy(xpath= "//a[@class='drop_down_usersettings' and
	// @href='index.php?module=Users&action=Logout']")
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLinkText;

//getter Methods

	// getters methods
	public WebElement getOrganizationLinkText() {
		return organizationLinkText;
	}

	public WebElement getSignoutImg() {
		return signoutImg;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getCampaignsLinkText() {
		return campaignsLinkText;
	}

	public WebElement getProductLinkText() {
		return productLinkText;
	}

	public WebElement getContactLinkText() {
		return contactLinkText;
	}

	public WebElement getSignoutLinkText() {
		return signoutLinkText;
	}
	public WebElement getInvoiceLinkText() {
		return invoiceLinkText;
	}
	
	// Business Logic for Product
	public void clickProductLink() {
		productLinkText.click();
	}

	// Business Logic for More
	public void moreLink(WebDriver driver) {
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.mouseOverOnElement(driver, morelink);
	}

	// Campaign
	public void campaignLinkText() {
		campaignsLinkText.click();
	}

	// Organization
	public void clickOrganizationsLinkText() {
		organizationLinkText.click();
	}

	public void clickContactLinkText() {
		contactLinkText.click();
	}

	public void clickInvoiceLinkText() {
		invoiceLinkText.click();
	}
	
	// Sign out
	public void signoutLink(WebDriver driver) throws Throwable {

		Webdriver_Utility web = new Webdriver_Utility();
		Thread.sleep(1000);
		web.mouseOverOnElement(driver, signoutImg);
		signoutLinkText.click();
	}
}
