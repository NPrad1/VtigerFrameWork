package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class deleteProduct {
	public deleteProduct(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement deleteProduct;
	
	public WebElement getDeleteProduct() {
		return deleteProduct;
	}
	//Business Logic
	/* used to delete product
	 * @ Pradeep
	 */

}
