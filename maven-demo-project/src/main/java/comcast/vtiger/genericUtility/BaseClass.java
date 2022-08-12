package comcast.vtiger.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import comcast.vtiger.objectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sDriver;
	
	File_Utility plib=new File_Utility();
	WebDriverUtility wlib=new WebDriverUtility();
	
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void BS() {
		System.out.println("DataBase Connection");
	}
	
	@BeforeTest(groups={"smokeTest","regressionTest"})
	public void BT() {
		System.out.println("execute script in Paralell Mode");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups={"smokeTest","regressionTest"})
	public void BC() throws Throwable {
		
		String BROWSER = plib.getPropertyKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		
		
		else
			if(BROWSER.equalsIgnoreCase("firefox"))
		{	
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
		}
			else
			if(BROWSER.equalsIgnoreCase("edge")) {
				
				WebDriverManager.edgedriver().setup();
				 driver = new EdgeDriver();
			}
			else {
				 driver=new ChromeDriver();
				
			}
		System.out.println("Launching the Browser");
		
		
	}

		@BeforeMethod(groups={"smokeTest","regressionTest"})
			public void BM() throws Throwable {
			System.out.println("Login the Application");
			
			String URL = plib.getPropertyKeyValue("url");
			String username = plib.getPropertyKeyValue("un");
			String password = plib.getPropertyKeyValue("pw");
			wlib.waitForPageToLoad(driver);
			wlib.maximizePage(driver);
			driver.get(URL);
			LoginPage login=new LoginPage(driver);
			login.login(username, password);
			
			sDriver=driver;
		
					}
		@AfterMethod (groups={"smokeTest","regressionTest"})
			public void AM()
			{
			System.out.println("Logout from Application");
				}
		@AfterClass(groups={"smokeTest","regressionTest"})
			public void AC() {
		System.out.println("Close the Browser");
				}
		@AfterTest(groups={"smokeTest","regressionTest"})
			public void AT() {
			System.out.println("Close Paralell Execution");
			}
		@AfterSuite(groups={"smokeTest","regressionTest"})
		public void AS() {
		System.out.println("Close DataBase Connection ");
	}
}
