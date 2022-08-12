package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// Decleration
	@FindBy(name = "user_name")
	private WebElement UserNameTextField;

	@FindBy(name = "user_password")
	private WebElement UserPasswordTextField;

	@FindBy(id = "submitButton")
	private WebElement LoginButton;

	// Getter methods
	public WebElement getUserNameTextField() {
		return UserNameTextField;
	}

	public WebElement getUserPasswordTextField() {
		return UserPasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	// Business Logic
	/*
	 * used for login app
	 * 
	 * @param username
	 * 
	 * @password
	 * 
	 * @author Pradeep
	 */
	public void login(String userName, String password) {
		UserNameTextField.sendKeys(userName);
		UserPasswordTextField.sendKeys(password);

		LoginButton.click();

	}

}
