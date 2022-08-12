package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	public  CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	

	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement campaignSave;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement campaignaddProduct;

	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement campaignPlus;
	
	
	public WebElement getCampaignPlus() {
		return campaignPlus;
	}
	public void createCampaign() {
		campaignPlus.click();
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getCampaignSave() {
		return campaignSave;
	}

	public WebElement getAddProduct() {
		return campaignaddProduct;
	}
	//Business logic
	/*this is used to Create Campaign and adding the created products
	 * @author Pradeep
	 */
	public void campaignName(String cName) {
		
		campaignName.sendKeys(cName);
		
		
	}
	public void campaignSave() {
		campaignSave.click();
	}
	public void addProductCampaign() {
		campaignaddProduct.click();
		
	}
}
