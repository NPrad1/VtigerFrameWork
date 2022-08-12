package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignValidation {
	
	public CampaignValidation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(className="dvHeaderText")
		private WebElement actualCampaignName;
		
		public WebElement getActualCampaignName() {
			return actualCampaignName;
			
		}
		public String actualCampaignName() {
			return actualCampaignName.getText();
		}
}
