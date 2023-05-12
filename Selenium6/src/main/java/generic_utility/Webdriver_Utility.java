package generic_utility;

import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_Utility {

	/**
	 * @author maity this method is used to maximize the window
	 * @param driver
	 */

	public void getWindowMax(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * @author maity this method is used to synchronize the automation Script
	 * @param driver
	 */

	public void getImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * After every action it will for next action to perform
	 * 
	 * @author maity
	 */
	public void scriptTimeOut(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(20));
	}

	/**
	 * used to wait for element to be clickable in GUI and check for specific
	 * element for every 500 milliseconds
	 * 
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement Element, int pollingTime) {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}

	/**
	 * used to switch to any Window based on window title
	 * 
	 * @param driver
	 * @param PartialWindowTitle
	 * @author maity
	 * 
	 */
	public void switchToWindow(WebDriver driver, String PartialWindowTitle) {

		Set<String> allId = driver.getWindowHandles();
		Iterator<String> id = allId.iterator();
		while (id.hasNext()) {
			String wh = id.next();
			driver.switchTo().window(wh);
			String title = driver.getTitle();
			if (title.contains(PartialWindowTitle)) {
				break;
			}

		}
	}

	/**
	 * used to switch to AlertWindow and Accept(click on ok Button)
	 * 
	 * @param driver
	 * @author maity
	 */
	public void switchToAlertAndAccept(WebDriver driver) {

		driver.switchTo().alert().accept();

	}

	/**
	 * used to switch to AlertWindow and dismiss(click on Cancel Button)
	 * 
	 * @param driver
	 * @author maity
	 */
	public void switchToAlertAndDismiss(WebDriver driver) {

		driver.switchTo().alert().dismiss();

	}

	/**
	 * used to switch to frame window based on Index
	 * 
	 * @param driver
	 * @param index
	 * @author maity
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * 
	 * used to switch to frame window based on id or name attribute
	 * 
	 * @param driver
	 * @param id_name_attribute
	 * @author maity
	 */
	public void switchToFrame(WebDriver driver, String id_name_Attribute) {
		driver.switchTo().frame(id_name_Attribute);
	}

	public void switchToFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	/**
	 * used to select the value from the dropDown based on index
	 * 
	 * @param element
	 * @param index
	 * @author maity
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * used to select the value from the dropDown based on text
	 * 
	 * @param element
	 * @param text
	 * @author maity
	 */
	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * used to place mouse cursor on specified element
	 * 
	 * @param driver
	 * @param element
	 * @author maity
	 * 
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();

	}

	/**
	 * used to right click on specific element
	 * 
	 * @param driver
	 * @param element
	 * @author maity
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	
	public void moveByOffest(WebDriver driver, int x, int y) {
		Actions act = new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}

	/**
	 * this method is used too take screenshot
	 * @param sDriver
	 * @param methodName
	 * 
	 */
	public String takeScreenshot(WebDriver sDriver, String methodName) {

		Date date = new Date();
		date.toString().replace(" ", " ").replace(":", "-");
		// TakesScreenshot ts=(TakesScreenshot)driver;
		return null;
	}

}
