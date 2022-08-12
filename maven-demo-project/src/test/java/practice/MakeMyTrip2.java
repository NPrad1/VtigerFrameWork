package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip2 {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.className("langCardClose")).click();
		
		driver.findElement(By.id("fromCity")).sendKeys("mumb");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']"));
		for(WebElement option:options) {
			System.out.println(option.getText());
			if(option.getText().contains("Mumbai, India")) {
				option.click();
				break;
				
			}
			else System.out.println("Not found");
		}
		driver.findElement(By.id("toCity")).sendKeys("del");
		List<WebElement> eles = driver.findElements(By.className("toCity"));
		for(WebElement ele:eles) {
			if(ele.getText().contains("Delhi"))
			{
				ele.click();
				break;
			}
		}

	}

}
