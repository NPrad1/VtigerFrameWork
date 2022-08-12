package comcast.vtiger.genericUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	/* Wait for page to Load before identifying any synchronized element in DOM
	 * @author Pradeep Kumar
	 * 
	 * 
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	/*After every action it will wait for next action to perform
	 * @Author Pradeep
	 * 
	 */
	public void scriptTimeOut(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
		
	}
	/*Wait for element to be clickable in GUI and check for the element for every .5seconds
	
	 * @param driver
	 * @param element
	 * @Pradeep
	 * 
	 */

	public void waitForElementTobeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	/*Wait for element to be clickable in GUI and check for the element for every specified pollingTime
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @Author Pradeep
	 * 
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement Element,int pollingTime)
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(pollingTime));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
		
	}
	/*used to switch the window based on Window title
	 * @param driver
	 * @param PartialWindowTitle
	 * @author Pradeep
	 */
	 public void switchToWindow(WebDriver driver,String PartialWindowTitle) {
		 Set<String> allId = driver.getWindowHandles();
		 Iterator<String> it = allId.iterator();
		 while(it.hasNext()) {
			 String wid = it.next();
			 driver.switchTo().window(wid);
			 if(driver.getTitle().contains(PartialWindowTitle)) {
				 break;
			 }
		 }
		 
	 }
	 /*This method is to switch to AlertWindow and Accept(click on OK button)
	  * param driver
	  * @author Pradeep
	  */
	 public void switchToAlertAndAccept(WebDriver driver) {
		 driver.switchTo().alert().accept();
		 
	 }
	 /*This method is to switch to AlertWindow and Dismiss(click on Cancel button)
	  * param driver
	  * @author Pradeep
	  */
	 public void switchToAlertDismiss(WebDriver driver) 
	 {
		 driver.switchTo().alert().dismiss();
	 }
	 
	 /*used to switch to frame window based on Index
	  * @param driver
	  * @param index
	  * @author Pradeep
	  */
	 
	 public void switchToframe(WebDriver driver,int index)
	 {
		 driver.switchTo().frame(index);
		 
	 }
	 
	 /*used to switch to frame window based on id or name attribute
	  * @param driver
	  * @param id_name_attribute
	  * @author Pradeep
	  */
	 public void switchToFrame(WebDriver driver,String id_name_Attribute)
	 {
		 driver.switchTo().frame(id_name_Attribute);
		 
	 }
	  
	 
	 /*used to select the value from the dropdown based on index
	  * @param element
	  * @index
	  * @author Pradeep
	  */
	 public void select(WebElement element,int index)
	 {
		 Select sel=new Select(element);
		 sel.selectByIndex(index);
		 
	 }
	 
	 
	 /*used to select the value from the dropdown based on text
	  * @param element
	  * @param driver
	  * @author
	  */
	 public void select(WebElement element,String text)
	 {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	 }
	  
	 /*used to place mouse cursor on specified element
	  * @param driver
	  * @param element
	  * @author Shobha
	  */
	 
	 public void mouseOverOnElement(WebDriver driver,WebElement element)
	 {
		 Actions action=new Actions(driver) ;
		 action.moveToElement(element).perform();
	 }
	  
	 /*used to right click on specific element
	  * @param driver
	  * @param element
	  * @author Pradeep
	  */
	  public void rightClickOnElement(WebDriver driver,WebElement element)
	  {
		  Actions action =new Actions(driver);
		  action.contextClick().perform();
		  
	  }
	  
	  /*used to click on Particular element
	   * @param driver
	   * @param element
	   * @author
	   */
	  public void clickOnElement(WebDriver driver,WebElement element)
	  {
		  Actions action=new Actions(driver);
		  action.click(element).perform();
	  }
	  
	  /*used for maximize the Screen
	   * @param driver
	   * @author Pradeep
	   */
	  public void maximizePage(WebDriver driver) {
		  driver.manage().window().maximize();
	  }
	
		
	
}
