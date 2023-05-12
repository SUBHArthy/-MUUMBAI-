package Contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import POM.ContactsCreationPage;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationsPage;
import POM.ValidationandVerification;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Property_Utility;
import generic_utility.Webdriver_Utility;

public class CreateContactwithOrganizationWithPOM extends BaseClass {

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}

	@Test(groups= {"smokeTest","regressionTest"})
	public void createContactwithOrganizationWithPOM() throws Throwable {


		HomePage home = new HomePage(driver);

		home.clickOrganizationsLinkText();
		OrganizationsPage org = new OrganizationsPage(driver);
		org.clickOrganizationCreateImage();

		Java_Utility jav = new Java_Utility();
		int ranNum = jav.getRandomNum(1000);

		Excel_Utility excel = new Excel_Utility();
		String name = excel.getExcelData("Contacts", 0, 1) + ranNum;
		String Org = excel.getExcelData("Organization", 3, 1) + ranNum;

		org.organizationNameTextField(Org);
		org.saveButton();

		Thread.sleep(1000);
		
		home.clickContactLinkText();
		
		ContactsCreationPage contact = new ContactsCreationPage(driver);
		contact.clickContactCreateImage();

		contact.enterLastNameTextField(name);
		contact.clickSelectDropdown();

		Webdriver_Utility web = new Webdriver_Utility();
		web.switchToWindow(driver, "Accounts&action");

		contact.enterSearchBox(Org);
		contact.clickSearchButton();

		driver.findElement(By.xpath("//a[text()='" + Org + "']")).click();
		Thread.sleep(3000);

		web.switchToWindow(driver, "Contacts&action");
		contact.clickSaveButton();

		Thread.sleep(1000);
		
//		ValidationandVerification  validation=new ValidationandVerification(driver);
//		validation.contactWithOrganizationValidation(name, Org);
//
//		Thread.sleep(1000);

	}

}
