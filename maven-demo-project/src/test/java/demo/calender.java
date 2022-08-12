package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class calender {
   
   public static void main(String[] args) {
	

	   
	   System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	   WebDriver driver=new ChromeDriver();
	   
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   
	   driver.get("https://www.makemytrip.com/");
	   driver.findElement(By.cssSelector(".langCardClose")).click();
	   
	   driver.findElement(By.id("fromCity")).sendKeys("mum");
	   driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();
	   
	   driver.findElement(By.id("toCity")).sendKeys("go");
	   driver.findElement(By.xpath("//p[.='Goa, India']")).click();
	   
	   driver.findElement(By.xpath("//span[.='Travellers & CLASS']")).click();
	   driver.findElement(By.xpath("//li[@data-cy='adults-3']")).click();
	   driver.findElement(By.xpath("//li[@data-cy='children-2']")).click();
	   driver.findElement(By.xpath("//li[@data-cy='infants-1']")).click();
	   driver.findElement(By.xpath("//li[.='Business']")).click();
	   driver.findElement(By.xpath("//button[.='APPLY']")).click();
	   
	  driver.findElement(By.xpath("//span[.='RETURN']")).click();
	  /*for same page date after clicking on calender
	   */
	   
	//  driver.findElement(By.xpath("(//div[@class='dateInnerCell']/p[.='14'])[2]")).click();
	  
	  //executing loop for 2 times as we want next 2 month date
	  for(int i=0;i<2;i++)
	  {driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		  
	  }
	  driver.findElement(By.xpath("(//div[@class='dateInnerCell']/p[.='14'])[2]")).click();
	   driver.findElement(By.xpath("//a[.='Search']")).click();
	   
   }
}
