package practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.InvoicePage;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;

public class CreateInvoiceWithPOM extends BaseClass {

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}

	@Test
	public void createInvoice() throws Throwable {

		HomePage home=new HomePage(driver);
		home.moreLink(driver);
		home.clickInvoiceLinkText();
		
		InvoicePage invoice=new InvoicePage(driver);
		invoice.clickInvoiceCreateImage();
		invoice.clickSelectDropDownContact();
		

		Excel_Utility ex = new Excel_Utility();
		String cont = ex.getExcelData("Contacts", 0, 1) ;
		String org = ex.getExcelData("Organization", 3, 1);
		
		Webdriver_Utility web=new Webdriver_Utility();
		web.switchToWindow(driver,"Contacts&action");

		invoice.enterSearchbox(cont);
		invoice.clickSearchbutton();
		
		driver.findElement(By.xpath("//a[text()=' Maity']")).click();
		web.switchToAlertAndAccept(driver);
		
		Thread.sleep(3000);
		web.switchToWindow(driver,"Invoice&action");
		
		
		invoice.clickSelectDropDownOrganization();
		
		web.switchToWindow(driver,"Accounts&action");
		invoice.enterSearchbox(org);
		invoice.clickSearchbutton();
		
		
		driver.findElement(By.xpath("//a[text()='" + org + "']")).click();
		web.switchToAlertAndAccept(driver);
		
		
		web.switchToWindow(driver,"Invoice&action");
		Thread.sleep(2000);
	}
}
