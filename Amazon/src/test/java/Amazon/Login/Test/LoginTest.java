package Amazon.Login.Test;

import com.aventstack.extentreports.Status;

import java.io.IOException;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.Amazon.utils.ExcelUtils;
import com.Ecom.Amazon.utils.CaptureScreenshot;
import com.Ecom.Amazon.utils.WebDriverUtils;

public class LoginTest extends WebDriverUtils{
	
	@Test(groups= {"Smoke"}) 
	public void login() throws InterruptedException {
		
		test = extent.createTest("Login_Amazon", "This is the test case to validate whether user is able to login into the application");	
		
		System.out.println(properties.getProperty("url"));
		test.log(Status.INFO, "User has the url to login : "+ properties.getProperty("url"));
		
		commonUtils.launchURL(properties.getProperty("url"));
		Thread.sleep(10000);
	
		loginPage.click_OnSign();
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
		
		loginPage.enter_UserName(username.getString("Username"));
		Thread.sleep(5000);
		
		
		loginPage.click_Continue();
		Thread.sleep(5000);
		
		
		loginPage.enter_Password(password.getString("Password"));
		
		Thread.sleep(5000);
		
		loginPage.click_Submit();
		Thread.sleep(5000);
		
		String expectedTitle = loginPage.homePageTitle();
		test.log(Status.INFO, "Home Page Title recored from Web application " + expectedTitle);

		String actualTitle = properties.getProperty("HomePageTitle");
		test.log(Status.INFO, "Actual Title is " + actualTitle);

		//Validating the title in homepage after login
		Thread.sleep(2000);
		Assert.assertEquals(actualTitle, expectedTitle);
		
		//Take a snap 
		try {
			test.info("Test execution snapshot below: ", MediaEntityBuilder.createScreenCaptureFromPath(new CaptureScreenshot().captureScreen()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		test.log(Status.PASS, "User has logged into the application");
		
		
		
	}

}
