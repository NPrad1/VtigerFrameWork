package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonHeadPhonesTest {

	public static void main(String[] args) throws Throwable  {
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			FileInputStream fis=new FileInputStream("./data/commondata.properties");
			
			String parent = driver.getWindowHandle();
			System.out.println(parent);
			
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Headphones",Keys.ENTER);
			driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
			Set<String> Ids = driver.getWindowHandles();
			for(String id:Ids) {
				{	if((id.equals(Ids)))
				{driver.switchTo().window(id);
			
			
			Actions action=new Actions(driver);
			Thread.sleep(2000);
			action.moveToElement(driver.findElement(By.id("landingImage"))).click().perform();
			WebElement ele = driver.findElement(By.xpath("//input[@name='submit.buy-now']"));
			ele.click();
			
		
				}
			//Amazon.in : Headphones
				}
			//Your Lists

	}

}}
