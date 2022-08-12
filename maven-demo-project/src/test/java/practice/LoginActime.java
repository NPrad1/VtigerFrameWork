package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginActime {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		FileInputStream fis = new FileInputStream("./data/commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		String Url = prop.getProperty("urla");
		String username = prop.getProperty("una");
		String password = prop.getProperty("pwa");
		
		driver.get(Url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		driver.findElement(By.id("container_users")).click();
		driver.findElement(By.xpath("//span[.='White, Jane']")).click();
		Thread.sleep(2000);
		WebElement jse = driver.findElement(By.className("rateCell"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0]ScrollInToView(true)",jse);
		
		driver.findElement(By.id("ext-gen710")).click();
		driver.findElement(By.xpath("(//div[@class='rateCellWrapper'])[5]")).sendKeys("60");
		driver.findElement(By.xpath("//div[.='OK']")).click();
		
		
		

	}

}
