package comcast.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.cj.jdbc.Driver;

import comcast.vtiger.genericUtility.WebDriverUtility;

public class HomePage {
	
	//initialisation
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	//decleration
	@FindBy(linkText="Organizations")
	private WebElement Organisation;
	
	@FindBy(linkText="Products")
	private WebElement Products;
	
	@FindBy(linkText="More")
	private WebElement more;
	
	
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOut;
	
	@FindBy(name="Campaigns")
	private WebElement Campaigns;
	
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement home;
	

	
	public WebElement getHome()
	{
		return home;
	}

	public WebElement getOrganisation() {
		return Organisation;
	}

	public WebElement getProducts() {
		return Products;
	}

	public WebElement getMore() {
		return more;
	}

	public WebElement getSignOut() {
		return SignOut;
	}

	public WebElement getCampaigns() {
		return Campaigns;
	}
	
	//Business logic
	/*
	*@used for clicking various elements on home page
	*/
	
	
	public void Organisation() {
		Organisation.click();
		
	}
	public void Products() {
		Products.click();
		
	}
	public void more(){
		more.click();
	}
	public void SignOut(WebDriver driver) {
		
		 
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		SignOut.click();
		
	}
	public void Campaigns() {
		Campaigns.click();
	}
	public void Home() {
		home.click();
	}
}
