package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// create Constructor(initialization)
		public LoginPage(WebDriver driver) {

			PageFactory.initElements(driver, this);
		}

		// declaration
		@FindBy(name = "user_name")
		private WebElement usernameEdtTxt;

		@FindBy(name = "user_password")
		private WebElement passwordEdTxt;

		@FindBy(id = "submitButton")
		private WebElement submitBtn;

		public WebElement getUsernameEdtTxt() {
			return usernameEdtTxt;
		}

		public WebElement getPasswordEdTxt() {
			return passwordEdTxt;
		}

		public WebElement getSubmitBtn() {
			return submitBtn;
		}

	//business logic
		public void loginToApp(String username, String password) {
			usernameEdtTxt.sendKeys(username);
			passwordEdTxt.sendKeys(password);
			submitBtn.click();
		}
}
