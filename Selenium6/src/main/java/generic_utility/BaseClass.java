package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import POM.HomePage;
import POM.LoginPage;

public class BaseClass {

	public static WebDriver sdriver;
	public WebDriver driver;

	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void bS() {
		System.out.println("DataConnection");
	}

	@BeforeTest(groups={"smokeTest","regressionTest"})
	public void bT() {
		System.out.println("Parallel execution");
	}

	
//	@Parameters("BROWSER")
	@BeforeClass(groups={"smokeTest","regressionTest"})
	
//	public void bC(String BROWSER)throws Throwable {
	public void bC() throws Throwable {

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
		sdriver=driver;
		System.out.println("Launching the Application");
	}

	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void bM() throws Throwable {
		Webdriver_Utility web = new Webdriver_Utility();
		web.getWindowMax(driver);
		web.getImplicitWait(driver);

		Property_Utility pro = new Property_Utility();
		String url = pro.getStringKeyAndValue("url");
		String un = pro.getStringKeyAndValue("username");
		String pw = pro.getStringKeyAndValue("password");

//		Excel_Utility ex = new Excel_Utility();
//		String url = ex.getExcelData("Login", 0, 0);
//		String un = ex.getExcelData("Login", 1, 0);
//		String pw = ex.getExcelData("Login", 2, 0);

		driver.get(url);

		LoginPage login = new LoginPage(driver);
		login.loginToApp(un, pw);
		System.out.println("login to the Application");
	}

	@AfterMethod(groups={"smokeTest","regressionTest"})	
	public void aM() throws Throwable {
		HomePage home = new HomePage(driver);
		home.signoutLink(driver);
		System.out.println("logout from Application");

	}

	@AfterClass(groups={"smokeTest","regressionTest"})
	public void aC() {
		driver.close();
		System.out.println("Close the browser");
	}

	@AfterTest(groups={"smokeTest","regressionTest"})
	public void aT() {
		System.out.println("parallel execution done");
	}

	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void aS() {
		System.out.println("Database closed");
	}

}
