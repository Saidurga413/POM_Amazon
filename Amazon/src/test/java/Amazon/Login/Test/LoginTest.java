package Amazon.Login.Test;



import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Amazon.utils.ExcelUtils;
import com.Ecom.Amazon.utils.WebDriverUtils;

public class LoginTest extends WebDriverUtils{
	
	@Test(groups= {"Smoke"}) 
	public void login() throws InterruptedException {
		System.out.println("Amit");
		System.out.println(properties.getProperty("url"));
		
		commonUtils.launchURL(properties.getProperty("url"));
		Thread.sleep(10000);
		
		WebElement ele = driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
		ele.click();
		Thread.sleep(5000);
		
		//input[@id='ap_email']
		WebElement ele1 = driver.findElement(By.xpath("//input[@id='ap_email']"));
		ele1.click();
		ele1.clear();
		Thread.sleep(5000);
		/** Enter Username & Password **/
		String filepath = properties.getProperty("TestData");
		JSONObject username = new JSONObject();
		JSONObject password = new JSONObject();
		try {
			username = new ExcelUtils().readRowField("GeneralData", "Username",filepath);
			password = new ExcelUtils().readRowField("GeneralData", "Password",filepath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		loginPage.enter_userName(username.getString("Username"));
//		loginPage.enter_password(password.getString("Password"));
		ele1.sendKeys(username.getString("Username"));
		
		
		
		
		WebElement ele3 = driver.findElement(By.xpath("//input[@id='continue']"));
		ele3.click();
		Thread.sleep(5000);
		
		//driver.close();
		//ap_password
		WebElement ele33 = driver.findElement(By.xpath("//input[@id='ap_password']"));
		ele33.click();
		ele33.clear();
		Thread.sleep(5000);
		ele33.sendKeys(password.getString("Password"));
		
		//signInSubmit
		WebElement ele34 = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		ele34.click();
		Thread.sleep(5000);
		
		
	}

}
