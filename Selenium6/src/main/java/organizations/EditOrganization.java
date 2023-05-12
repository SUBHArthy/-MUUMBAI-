package organizations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Property_Utility;
import generic_utility.Webdriver_Utility;

public class EditOrganization extends BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}

	@Test
	public void editOrganization() throws Throwable {
//		WebDriver driver = new ChromeDriver();
//
//		Webdriver_Utility web = new Webdriver_Utility();
//		web.getWindowMax(driver);
//		web.getImplicitWait(driver);
//
//		Property_Utility pro = new Property_Utility();
//		String url = pro.getStringKeyAndValue("url");
//		String un = pro.getStringKeyAndValue("username");
//		String pwd = pro.getStringKeyAndValue("password");
//
//		driver.get(url);
//		driver.findElement(By.name("user_name")).sendKeys(un);
//		driver.findElement(By.name("user_password")).sendKeys(pwd);
//		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		Java_Utility jav = new Java_Utility();
		int ranNum = jav.getRandomNum(1000);

		Excel_Utility ex = new Excel_Utility();
		String org = ex.getExcelData("Organization", 3, 1) + ranNum;

		driver.findElement(By.name("accountname")).sendKeys(org);
		driver.findElement(By.name("button")).click();

//		WebElement organization = driver.findElement(By.linkText("Organizations"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Organizations"));

		Thread.sleep(4000);

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("(//a[text()='" + org + "'])[2]/../..//a[text()='edit']")).click();
		driver.findElement(By.id("email1")).sendKeys("maitysubharthy@gmail.com");
		driver.findElement(By.name("button")).click();

		Thread.sleep(1000);
	}

}
// EDIT FROM GITHUB
//EDIT FROM ECLIPSE
