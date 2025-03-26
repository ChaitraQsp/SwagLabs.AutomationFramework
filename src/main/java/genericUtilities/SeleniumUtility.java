package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to selenium
 * @author Chaitra M
 *
 */
public class SeleniumUtility {

	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * this method will add implicitly wait of 10 seconds
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for element to be visible in DOM
	 * @param driver
	 * @param element
	 */
	public void waitForVisibilityOfElement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle dropdown by index 
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by Visible Text 
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, String visibleText)
	{
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	/**
	 * This method will handle dropdown by value 
	 * @param element
	 * @param index
	 */
	public void handleDropdown(String value,WebElement element)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	//mousehover, scrollto element, dragand drop, contextclick, double click
	
	/**
	 * This method will perform mouse hovering action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform Scroll to element action
	 * @param driver
	 * @param element
	 */
	public void scrollToElementAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	/**
	 * This method will perform double click action
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform right click action
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver, WebElement src, WebElement target)
	{
		Actions act = new Actions(driver);
	    act.dragAndDrop(src, target).perform();
	}
	
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver , int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * This method will handle frame by NAME or ID
	 * @param driver
	 * @param frameNameOrID
	 */
	public void handleFrame(WebDriver driver , String frameNameOrID)
	{
		driver.switchTo().frame(frameNameOrID);
	}
	
	
	/**
	 * This method will handle frame by frame element
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver , WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method will accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will accept dismiss popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will enter data to alert popup
	 * @param driver
	 */
	public void enterTextAlert(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	/**
	 * This method will get text from alert popup
	 * @param driver
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will capture screenshot and return the absolute path to caller
	 * @param driver
	 * @param Screenshotname
	 * @return 
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String Screenshotname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+Screenshotname+".png");
		FileHandler.copy(src, dst);
		
		return dst.getAbsolutePath(); //extent reports
	}
	
	
	
	
	
}
