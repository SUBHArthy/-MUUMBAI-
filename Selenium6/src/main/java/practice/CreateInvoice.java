package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Property_Utility;
import generic_utility.Webdriver_Utility;

public class CreateInvoice {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}

	@Test
	public void createInvoice() throws Throwable {
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

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		Java_Utility jav = new Java_Utility();
		int ranNum = jav.getRandomNum(100);

		Excel_Utility ex = new Excel_Utility();
		String cont = ex.getExcelData("Contacts", 0, 1) + ranNum;
		String org = ex.getExcelData("Organization", 3, 1);

		driver.findElement(By.name("lastname")).sendKeys(cont);
		driver.findElement(By.name("button")).click();

		WebElement more = driver.findElement(By.linkText("More"));
		web.mouseOverOnElement(driver, more);
		driver.findElement(By.linkText("Invoice")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		driver.findElement(
				By.xpath("//td[text()='Contact Name 			']/..//img[@src='themes/softed/images/select.gif']"))
				.click();

		web.switchToWindow(driver, "Contacts&action");

		driver.findElement(By.id("search_txt")).sendKeys(cont);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[contains(text(),'" + cont + "')]")).click();

		web.switchToAlertAndAccept(driver);

		Thread.sleep(3000);

		web.switchToWindow(driver, "Invoice&action");

		driver.findElement(By
				.xpath("//td[text()='Organization Name 			']/..//img[@src='themes/softed/images/select.gif']"))
				.click();

		web.switchToWindow(driver, "Accounts&action");

		driver.findElement(By.id("search_txt")).sendKeys(org);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + org + "']")).click();

		web.switchToAlertAndAccept(driver);

	}
}