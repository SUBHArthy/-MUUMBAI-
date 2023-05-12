package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.OrganizationsPage;
import generic_utility.BaseClass;
import generic_utility.Excel_Utility;

public class DataProviderEx1 extends BaseClass{

	
	@Test(dataProvider = "dataProviderMethod")
	public void createOrganization(String name,String phoneNum,String Email) throws Throwable{
		
		HomePage home = new HomePage(driver);
		home.clickOrganizationsLinkText();

		OrganizationsPage org = new OrganizationsPage(driver);
		org.clickOrganizationCreateImage();
		org.organizationNameTextField(name);
		org.phoneTextField(phoneNum);
		org.emailTextBox(Email);
		org.saveButton();
		
		
	}

	@DataProvider
	public Object[][] dataProviderMethod() throws Throwable {
		Excel_Utility ex=new Excel_Utility();
		Object[][] value=ex.readMultipleData("Organization");
		return value;
		
	}
}
