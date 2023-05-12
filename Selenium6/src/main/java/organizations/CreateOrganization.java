package organizations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Property_Utility;
import generic_utility.Webdriver_Utility;

public class CreateOrganization extends BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}

	@Test
	public void createOrganization() throws Throwable {
//		WebDriver driver = new ChromeDriver();

	/*	Webdriver_Utility web = new Webdriver_Utility();
		web.getWindowMax(driver);
		web.getImplicitWait(driver);

		Property_Utility pro = new Property_Utility();
		String url = pro.getStringKeyAndValue("url");
		String un = pro.getStringKeyAndValue("username");
		String pwd = pro.getStringKeyAndValue("password");

		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();     */

		driver.findElement(By.linkText("Organizations")).click();
		
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		Java_Utility jav = new Java_Utility();
		int ranNum = jav.getRandomNum(1000);

		Excel_Utility ex = new Excel_Utility();
		String org = ex.getExcelData("Organization", 3, 1) + ranNum;

		driver.findElement(By.name("accountname")).sendKeys(org);
		driver.findElement(By.name("button")).click();

		Thread.sleep(1000);
	}
}