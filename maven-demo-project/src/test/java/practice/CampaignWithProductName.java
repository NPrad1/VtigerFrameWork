package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CampaignWithProductName {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		String UN = prop.getProperty("un");
		String PW = prop.getProperty("pw");
		
		Random ran=new Random();
		int ranNo=ran.nextInt(1000);
		
		
		driver.get(URL);
		String parentwin = driver.getWindowHandle();
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();
		
		WebElement more = driver.findElement(By.linkText("More"));
		Actions action=new Actions(driver);
		action.moveToElement(more).perform();

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		
		FileInputStream fis1=new FileInputStream("./data/ExcelData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet s=wb.getSheet("Products");
		Row r=s.getRow(1);
		Cell c=r.getCell(0);
		 String pName = c.getStringCellValue()+ranNo;
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(pName);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  String actPname = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
		  System.out.println(actPname);
		  
		  if(actPname.contains(pName)) {
			  System.out.println("Product created");
		  }
		  else
			  System.out.println("Product not created");
		
		FileInputStream fis2=new FileInputStream("./data/ExcelData.xlsx");
		Workbook wb1=WorkbookFactory.create(fis2);
		
		Sheet sc1=wb1.getSheet("Campaign");
		String cName = sc1.getRow(0).getCell(0).getStringCellValue();
		
		
		driver.navigate().refresh();
		WebElement more1 = driver.findElement(By.linkText("More"));
		action.moveToElement(more1).perform();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		Set<String> Ids = driver.getWindowHandles();
		for(String id:Ids)
		 {
			if(!(id.equals(parentwin))) {
				driver.switchTo().window(id);
				driver.findElement(By.id("search_txt")).sendKeys(pName);
				Thread.sleep(2000);
				driver.findElement(By.className("crmbutton")).click();
				Thread.sleep(2000);
				
				String apName = driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).getText();
				 driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
				 
				System.out.println("Actual Product name id "+apName);
				if(apName.contains(pName))
				{
					System.out.println("Product name is "+pName);
					
				}
				else System.out.println("Product not found");
				
				break;
			}
		}
		driver.switchTo().window(parentwin);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@name='button_Product']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(cName);
		driver.findElement(By.className("crmButton")).click();
		String actcName = driver.findElement(By.className("dvHeaderText")).getText();
		System.out.println(actcName);
		
		if(actcName.contains(cName)) {
			System.out.println("Pass");
		}
		else System.out.println("Fail");
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		action.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
