package practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LoginToVtiger {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./data/commondata.properties");
		Properties pboj=new Properties();
		pboj.load(fis);
		
		String Browser = pboj.getProperty("browser");
		String Url = pboj.getProperty("url");
		String UserName = pboj.getProperty("un");
		String Password = pboj.getProperty("pw");
	
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		Actions action=new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//a[.='More']"));
		action.moveToElement(ele).perform();
		driver.findElement(By.name("Integration")).click();
		WebElement drop = driver.findElement(By.id("qccombo"));
		Select s=new Select(drop);
		s.selectByValue("Campaigns");
		
		
		
		

	}

}
