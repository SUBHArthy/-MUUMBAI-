package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.Property_Utility;
import generic_utility.Webdriver_Utility;

public class EmptyBrowser {

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}

	public void emptyBrowser() throws Throwable {
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
	}
}
