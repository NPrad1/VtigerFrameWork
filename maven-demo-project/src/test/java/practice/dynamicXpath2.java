package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicXpath2 {
 

		public static void main(String[] args) throws Throwable {
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get("https://www.makemytrip.com/");
			driver.findElement(By.className("langCardClose")).click();
			//driver.findElement(By.xpath("//li[.='Round Trip']")).click();
			WebElement from = driver.findElement(By.id("fromCity"));
			from.sendKeys("mum");
			Thread.sleep(1000);
			String src = "Mumbai, India";
			driver.findElement(By.xpath("//p[.='"+src+"']")).click();
			
			WebElement des = driver.findElement(By.id("toCity"));
			des.sendKeys("del");
			Thread.sleep(1000);
			String des1 = "New Delhi, India";
			driver.findElement(By.xpath("//p[.='"+des1+"']")).click();
			
		
		//Navigating to departure
			driver.findElement(By.xpath("//label[@for='departure']")).click();
			
			String requiredMonth = "November";
			String requiredYear = "2022";
			String requiredDate = "14";
			
			String currentMonthYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
			String currentMonth = currentMonthYear.split(" ")[0];
			String currentYear= currentMonthYear.split(" ")[1];
			
			while(!(currentMonth.equalsIgnoreCase(requiredMonth)&&currentYear.equalsIgnoreCase(requiredYear))){
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				currentMonthYear=driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
				currentMonth=currentMonthYear.split(" ")[0];
				currentYear=currentMonthYear.split(" ")[1];
				
			}
			
				driver.findElement(By.xpath("(//p[text()='"+requiredDate+"'])[1]")).click();
			
			
			

		}

	}


