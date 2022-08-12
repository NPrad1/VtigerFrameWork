package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstProgram {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/s?k=by+amzon&adgrpid=67426081828&ext_vrnc=hi&gclid=Cj0KCQjw8uOWBhDXARIsAOxKJ2FEtYrjJ8q5AalSXeOfecyPpcVYb42dAU_K_Wplq3gxwqh-KSlEFbUaAoI8EALw_wcB&hvadid=294136395499&hvdev=c&hvlocphy=9302964&hvnetw=g&hvqmt=b&hvrand=8354415060102641604&hvtargid=kwd-439090989740&hydadcr=15412_1904554&tag=googinhydr1-21&ref=pd_sl_27qjqmnzhv_b");
		driver.findElement(By.xpath("//span[.='Hello, Sign in']")).click();
		driver.findElement(By.id("ap_email")).sendKeys("pradeepkumar05555@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("pradeep1");
		driver.findElement(By.id("signInSubmit")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9pro");
		WebElement element = driver.findElement(By.id("nav-search-submit-button"));
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		driver.findElement(By.className("a-price-whole")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
	}

}
