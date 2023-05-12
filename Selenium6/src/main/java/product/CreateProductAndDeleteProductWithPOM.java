package product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.ProductPage;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Webdriver_Utility;

public class CreateProductAndDeleteProductWithPOM extends BaseClass {

	@Test(groups={"smokeTest"})
	public void createProductAndDeleteProduct() throws Throwable {
		HomePage home = new HomePage(driver);
		home.clickProductLink();

		ProductPage prod = new ProductPage(driver);
		prod.clickProductCreateImage();

		Java_Utility jav = new Java_Utility();
		int ranNum = jav.getRandomNum(100);

		Excel_Utility ex = new Excel_Utility();
		String productName = ex.getExcelData("Product", 0, 0) + ranNum;

		prod.enterProductNameTextBox(productName);
		prod.clickSaveButton();

		home.clickProductLink();
		driver.findElement(By.xpath("(//a[text()='" + productName + "'])/../..//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		Webdriver_Utility web = new Webdriver_Utility();

		web.switchToAlertAndAccept(driver);

	}

}
