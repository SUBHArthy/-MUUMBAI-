package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_utility.Property_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderVtiger {
	@Test(dataProvider = "dataProvider_test")
	public void companyDetails(String name,String phoneNum,String Email) throws Throwable
	{
		Property_Utility plib=new Property_Utility();
		String BROWSER = plib.getStringKeyAndValue("browser");
		
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
			driver.findElement(By.name("accountname")).sendKeys(name);
			driver.findElement(By.id("phone")).sendKeys(phoneNum);
			driver.findElement(By.id("email1")).sendKeys(Email);
			Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
	/*	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();*/
		driver.quit();
		Thread.sleep(2000);
	}
	@DataProvider
	public Object[][] dataProvider_test() throws Throwable
	{
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="AAA";
		objArr[0][1]="9845555258";
		objArr[0][2]="sfgjhg@gmail.com";
		
		Thread.sleep(2000);
		objArr[1][0]="BBB";
		objArr[1][1]="983596544";
		objArr[1][2]="hgfug@gamil.com";
		
		Thread.sleep(2000);
		objArr[2][0]="CCC";
		objArr[2][1]="6652445643";
		objArr[2][2]="ehfjefkjb@gmail.com";
		
		return objArr;

	}
}

