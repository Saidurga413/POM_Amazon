package Amazon.Login.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ecom.Amazon.utils.CommonUtils;

public class LoginPage extends CommonUtils{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);	
		
	}
	
	@FindBy(xpath = "//span[text()='Hello, sign in']")
	public WebElement OnSign;
	
	@FindBy(xpath = "//input[@id='ap_email']")
	public WebElement UserName;
	
	@FindBy(xpath = "//input[@id='ap_password']")
	public WebElement Password;
	
	@FindBy(xpath = "//input[@id='continue']")
	public WebElement Continue;
	
	@FindBy(xpath = "//input[@id='signInSubmit']")
	public WebElement Submit;

	public void click_OnSign() {
		click(OnSign);
		
	}

	public void enter_UserName(String property) {
		click(UserName);
		UserName.click();
		sendKeys(UserName, property);
		
		
	}

	public void click_Continue() {
		click(Continue);
		
	}

	public void enter_Password(String string) {
		click(Password);
		Password.click();
		sendKeys(Password, string);
		
	}

	public void click_Submit() {
		click(Submit);
		
	}

}
