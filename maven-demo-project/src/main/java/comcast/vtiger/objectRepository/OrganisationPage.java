
package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organisationName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement organisationSave;@
	
	FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement organisationPlus;
	
	public WebElement getOrganisationPlus() {
		return organisationPlus;
	}
	
	
	

	public WebElement getOrganisationName() {
		return organisationName;
	}
	
	
	public WebElement getOrganisationSave() {
		return organisationSave;
	}
	
	public void organisationPlus() {
		organisationPlus.click();
	}
	
	public void organisationName(String orgName) {
		organisationName.sendKeys(orgName);
		
	}
	
	public void organisationSave() {
		 organisationSave.click();
	 }
// Business Logic
/*used to create and save organisation
*@param organisation name
 * @author Pradeep
 */ 
}
