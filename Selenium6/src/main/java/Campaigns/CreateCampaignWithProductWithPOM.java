package Campaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import POM.ProductPage;
import POM.ValidationandVerification;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Property_Utility;
import generic_utility.Webdriver_Utility;

@Listeners(generic_utility.ListnerImp.class)
public class CreateCampaignWithProductWithPOM extends BaseClass {

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}

	@Test(groups={"smokeTest"})
	public void CreateCampaignWithProduct() throws Throwable {



		HomePage home = new HomePage(driver);
		home.clickProductLink();

		Assert.assertEquals(true, false);
		
		Java_Utility jav = new Java_Utility();
		int ranNum = jav.getRandomNum(100);

		Excel_Utility excel = new Excel_Utility();
		String productName = excel.getExcelData("Product", 0, 0) + ranNum;
		String campName = excel.getExcelData("Campaign", 0, 0) + ranNum;

		ProductPage pp = new ProductPage(driver);
		pp.clickProductCreateImage();
		pp.enterProductNameTextBox(productName);
		pp.clickSaveButton();

		home.getMorelink().click();
		home.campaignLinkText();

		CampaignPage campaign = new CampaignPage(driver);
		campaign.clickCampaignCreateImage();

		campaign.enterCampaignNameTextField(campName);
		campaign.clickSelectDropdown();

		Webdriver_Utility web = new Webdriver_Utility();

		web.switchToWindow(driver, "Products&action");

		campaign.enterSearchbox(productName);
		campaign.clickSearchbutton();
		driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();

		web.switchToWindow(driver, "Campaigns&action");

		campaign.clickSaveButton();

		ValidationandVerification  validation=new ValidationandVerification(driver);
		validation.campaignWithProductValidation(campName,productName);
		
		Thread.sleep(2000);

	}

}
