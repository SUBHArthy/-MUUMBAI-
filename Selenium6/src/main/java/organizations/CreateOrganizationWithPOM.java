package organizations;

import org.testng.annotations.Test;

import POM.HomePage;
import POM.OrganizationsPage;
import POM.ValidationandVerification;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;
import generic_utility.Java_Utility;


public class CreateOrganizationWithPOM extends BaseClass {

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}

	@Test(groups={"smokeTest","regressionTest"})
	public void createOrganizationWithPOM() throws Throwable {

////		WebDriver driver = new ChromeDriver();
//
///*		Webdriver_Utility web = new Webdriver_Utility();
//		web.getWindowMax(driver);
//		web.getImplicitWait(driver);
//
//		Property_Utility p = new Property_Utility();
//		String url = p.getStringKeyAndValue("url");
//		String un = p.getStringKeyAndValue("username");
//		String pw = p.getStringKeyAndValue("password");
//
//		driver.get(url);
//
//		LoginPage login = new LoginPage(driver);
//		login.loginToApp(un, pw); */

		
		HomePage home = new HomePage(driver);
		home.clickOrganizationsLinkText();

		
		
		OrganizationsPage org = new OrganizationsPage(driver);
		org.clickOrganizationCreateImage();

		Java_Utility j = new Java_Utility();
		int ranNum = j.getRandomNum(1000);

		Excel_Utility ex = new Excel_Utility();
		String exeldata = ex.getExcelData("Organization", 3, 1) + ranNum;

		org.organizationNameTextField(exeldata);
		org.saveButton();

		ValidationandVerification validation = new ValidationandVerification(driver);
//		validation.organisationValidation(driver, exeldata);
		validation.organisationValidation(exeldata);
		
		Thread.sleep(1000);

	}

}
