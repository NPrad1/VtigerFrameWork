package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationValidation {
	
	public OrganisationValidation(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="span.dvHeaderText")
	private WebElement actualOrganisationName;
	
	public WebElement getactualOrganisationName() {
		return actualOrganisationName;
	}
	
	public String actualOrganisationName() {
		return actualOrganisationName.getText();
	}
}
