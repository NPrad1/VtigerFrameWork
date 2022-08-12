package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public ProductPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="productname")
	private WebElement productName;
	
	@FindBy(className="crmbutton")
	private WebElement saveProduct;
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement productPlus;
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement deleteProduct;
	
	public WebElement getdeleteProduct() {
		return deleteProduct;
	}
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSaveProduct() {
		return saveProduct;
	}
	public WebElement getProductPlus() {
		return productPlus;
	}
	public void createProduct() {
		productPlus.click();
	}
	public void productName(String pName) {
		productName.sendKeys(pName);
		
	}
	public void deleteProduct() {
		deleteProduct.click();
	}
	public void saveProduct() {
		saveProduct.click();
	}
	//Business Logic
	/* used to create and save product
	*@Param Product name
	 * @author Pradeep
	 */
}
