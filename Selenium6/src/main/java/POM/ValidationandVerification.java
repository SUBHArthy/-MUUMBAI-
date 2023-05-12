package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic_utility.Webdriver_Utility;

public class ValidationandVerification {

	public ValidationandVerification(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "dtlview_Organization Name")
	private WebElement actualOrganizationData;

	@FindBy(id = "dtlview_Campaign Name")
	private WebElement actualCampaignData;

	@FindBy(id = "dtlview_Product")
	private WebElement actualCampaignWithProductData;

	@FindBy(id = "dtlview_Product Name")
	private WebElement actualProductData;

	@FindBy(id = "dtlview_Last Name")
	private WebElement actualContactData;

	@FindBy(id = "mouseArea_Organization Name")
	private WebElement actualContactwithOrganizationData;

	public WebElement getActualOrganizationData() {
		return actualOrganizationData;
	}

	public WebElement getActualCampaignData() {
		return actualCampaignData;
	}

	public WebElement getActualCampaignWithProductData() {
		return actualCampaignWithProductData;
	}

	public WebElement getActualProductData() {
		return actualProductData;
	}

	public WebElement getActualContactData() {
		return actualContactData;
	}

	public WebElement getActualContactwithOrganizationData() {
		return actualContactwithOrganizationData;
	}

//	public void organisationValidation(WebDriver driver,String data) {
	public void organisationValidation(String data) {
		String actdata = actualOrganizationData.getText();
//		if (actdata.contains(data)) {
//			System.out.println("pass");
//		} else {
//			System.out.println("fail");
//		}

		Assert.assertEquals(actdata, data);
	}

//	public void productValidation(WebDriver driver, String data) {
	public void productValidation(String data) {
		String actData = actualProductData.getText();
//		if (actData.contains(data)) {
//			System.out.println("pass");
//		} else {
//			System.out.println("fail");
//		}
		Assert.assertEquals(actData, data);
	}

//	public void campaignWithProductValidation(WebDriver driver, String data, String Data) {
	public void campaignWithProductValidation(String data, String Data) {
		String actdata = actualCampaignData.getText();
		String actData = actualCampaignWithProductData.getText();
//		if (actdata.contains(data) && actData.contains(Data)) {
//			System.out.println("pass");
//		} else {
//			System.out.println("fail");
//		}
		Assert.assertEquals(actdata, data);
		Assert.assertEquals(actData, Data);

	}

//	public void contactWithOrganizationValidation(WebDriver driver, String data, String Data) {
	public void contactWithOrganizationValidation(String data, String Data) {
		String actdata = actualContactData.getText();
		String actData = actualContactwithOrganizationData.getText();
//		if (actdata.contains(data) && actData.contains(Data)) {
//			System.out.println("pass");
//		} else {
//			System.out.println("fail");
//		}
		Assert.assertEquals(actdata, data);
		Assert.assertEquals(actData, Data);
	}
}
