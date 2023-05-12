package product;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.ProductPage;
import POM.ValidationandVerification;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;




public class CreateProductWithPOM extends BaseClass {

	
	@Test(groups= {"smokeTest"})
	public void createProduct() throws Throwable {
		
		
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

		ValidationandVerification validate=new ValidationandVerification(driver);
		validate.productValidation(productName);
		
		Thread.sleep(1000);

	}

}
