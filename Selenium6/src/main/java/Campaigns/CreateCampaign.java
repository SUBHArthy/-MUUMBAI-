package Campaigns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;
import generic_utility.Property_Utility;
import generic_utility.Webdriver_Utility;

public class CreateCampaign extends BaseClass{

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}

	@Test
	public void createCampaign() throws Throwable {
	/*	WebDriver driver;
		Property_Utility pro = new Property_Utility();
		String BROWSER = pro.getStringKeyAndValue("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		String url = pro.getStringKeyAndValue("url");
		String un = pro.getStringKeyAndValue("username");
		String pwd = pro.getStringKeyAndValue("password");

		Webdriver_Utility web = new Webdriver_Utility();
		web.getWindowMax(driver);
		web.getImplicitWait(driver);

		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();      */
	
		
		Webdriver_Utility web = new Webdriver_Utility();
		WebElement more = driver.findElement(By.linkText("More"));
		web.mouseOverOnElement(driver, more);

		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		Java_Utility jav = new Java_Utility();
		int ranNum = jav.getRandomNum(1000);

		Excel_Utility ex = new Excel_Utility();
		String data = ex.getExcelData("Campaign", 0, 0) + ranNum;

		driver.findElement(By.name("campaignname")).sendKeys(data);

		driver.findElement(By.name("button")).click();

	}

}
