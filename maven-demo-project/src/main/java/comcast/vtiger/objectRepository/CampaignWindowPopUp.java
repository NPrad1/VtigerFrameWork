package comcast.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignWindowPopUp {
	public CampaignWindowPopUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search")
	private WebElement search;
	
	@FindBy(id="search_txt")
	private WebElement productName;

	
	public WebElement getProductName() {
		return productName;
	}


	public WebElement getSearch() {
		return search;
	}
	public void productNameCapmaign(String pName) {
		productName.sendKeys(pName);
	}
	
	public void searchProductCampaign(WebDriver driver,String pName) {
		search.click();
		driver.findElement(By.xpath("//a[.='"+pName+"']")).click();
		
		
	}
}
