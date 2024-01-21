package Amazon.Login.Page;

import org.openqa.selenium.support.PageFactory;

import com.Ecom.Amazon.utils.CommonUtils;

public class LoginPage extends CommonUtils{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);	
	}

}
