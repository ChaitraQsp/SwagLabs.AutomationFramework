package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//declaration
	@FindBy(id = "user-name")
	private WebElement usernameEdt;
	
	@FindBy(id = "password")
	private WebElement passwordEdt;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}


	public WebElement getPasswordEdt() {
		return passwordEdt;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business logic
	/**
	 * This method will perform login operation
	 * @param UN
	 * @param PWD
	 */
	public void loginToApp(String UN, String PWD)
	{
		usernameEdt.sendKeys(UN);
		passwordEdt.sendKeys(PWD);
		loginBtn.click();
	}
	
	

}
