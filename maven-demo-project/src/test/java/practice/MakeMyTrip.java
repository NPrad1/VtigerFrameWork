package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import comcast.vtiger.genericUtility.WebDriverUtility;

public class MakeMyTrip {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.maximizePage(driver);
		wlib.waitForPageToLoad(driver);
		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.className("langCardClose")).click();
		WebElement from = driver.findElement(By.id("fromCity"));
		from.sendKeys("Mumb");
		Thread.sleep(2000);
		from.sendKeys(Keys.PAGE_DOWN);
		
				
			
	}

}
