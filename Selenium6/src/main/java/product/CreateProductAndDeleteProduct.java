package product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Property_Utility;
import generic_utility.Webdriver_Utility;

public class CreateProductAndDeleteProduct {

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}

	public void createProductAndDeleteProduct() throws Throwable {
		WebDriver driver = new ChromeDriver();

		Webdriver_Utility web = new Webdriver_Utility();
		web.getWindowMax(driver);
		web.getImplicitWait(driver);

		Property_Utility pro = new Property_Utility();
		String url = pro.getStringKeyAndValue("url");
		String un = pro.getStringKeyAndValue("username");
		String pwd = pro.getStringKeyAndValue("password");

		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();

		Java_Utility jav = new Java_Utility();
		int ranNum = jav.getRandomNum(100);

		Excel_Utility ex = new Excel_Utility();
		String data = ex.getExcelData("Product", 0, 0) + ranNum;

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("productname")).sendKeys(data);
		driver.findElement(By.name("button")).click();

		/*
		 * 1st Approach
		 * 
		 * driver.findElement(By.name("Delete")).click();
		 * web.switchToAlertAndAccept(driver);
		 */

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("(//a[text()='" + data + "'])[2]/../..//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		web.switchToAlertAndAccept(driver);

		boolean flag = false;
		List<WebElement> allpro = driver.findElements(By.xpath("//a[@title='Products']"));
		for (WebElement proo : allpro) {
			String product = proo.getText();
			if (product.equals(data)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("product " + data + " deleted successfully");
		} else {
			System.out.println("product " + data + " not deleted successfully");
		}

		WebElement useracnt = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		web.mouseOverOnElement(driver, useracnt);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

	}

}
