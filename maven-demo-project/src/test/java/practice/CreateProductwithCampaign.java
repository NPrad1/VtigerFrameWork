package practice;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateProductwithCampaign {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		String URL = prop.getProperty("url");
		String username = prop.getProperty("un");
		String password = prop.getProperty("pw");
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		Random ran=new Random();
		int rv=ran.nextInt(1000);
		
		FileInputStream fis1=new FileInputStream("./data/ExcelData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		String pName = wb.getSheet("Products").getRow(1).getCell(0).getStringCellValue()+rv;
		
		driver.findElement(By.name("productname")).sendKeys(pName);
		driver.findElement(By.className("crmbutton")).click();
		String acpName = driver.findElement(By.className("lvtHeaderText")).getText();
		System.out.println("Product created sucessfully"+acpName);
		
		if(acpName.contains(pName)) {
			System.out.println("Pass");
		}
		else
			System.out.println("Fail");
		driver.findElement(By.xpath("//img[@src='themes/softed/images/Home.PNG']")).click();
		WebElement more = driver.findElement(By.linkText("More"));
		
		Actions action=new Actions(driver);
		action.moveToElement(more).perform();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		String cName = wb.getSheet("Campaign").getRow(0).getCell(0).getStringCellValue();
		
		driver.findElement(By.name("campaignname")).sendKeys(cName);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		Thread.sleep(2000);
		Set<String> Ids = driver.getWindowHandles();
		Iterator<String> id = Ids.iterator();
		while(id.hasNext()) {
			String wid = id.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains("Products&action"))
			{
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys(pName);
		driver.findElement(By.className("crmbutton")).click();
		driver.findElement(By.xpath("//a[.='"+pName+"']")).click();
		Set<String> Ids1 = driver.getWindowHandles();
		Iterator<String> id1 = Ids1.iterator();
		while(id1.hasNext()) {
			String wid1 = id1.next();
			driver.switchTo().window(wid1);
			if(driver.getTitle().contains("Campaigns&action")) {
				break;
			}
			
			
		}
		driver.findElement(By.className("crmButton")).click();
		String actcName = driver.findElement(By.className("dvHeaderText")).getText();
		if(actcName.contains(cName)) {
			System.out.println("Pass");
		}
		else
			System.out.println("Fail");
		driver.quit();

	}

}
