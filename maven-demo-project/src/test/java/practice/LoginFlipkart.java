package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFlipkart {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String Url = prop.getProperty("urlf");
		String username = prop.getProperty("unf");
		String password = prop.getProperty("pwf");
		
		driver.get(Url);
		
	//	Actions action=new Actions(driver);
	//	action.click().perform();
		
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		WebElement ele = driver.findElement(By.xpath("(//div[@class='exehdJ'])[1]"));
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
	//Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!
		
		Actions action =new Actions(driver);
		action.moveToElement(ele).perform();
		driver.navigate().refresh();
		
		//action.contextClick(ele).perform();
		
		
		//driver.findElement(By.xpath("//div[.='Wishlist']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//img[@alt='Travel']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@scoopclassname='_3pJKMX']")).sendKeys("hyd");
		Thread.sleep(2000);
		
		
		
		
		
		
		
		
		
		
	}

}
