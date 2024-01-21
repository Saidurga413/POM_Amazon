package Amazon.ProductSearchAndAddInCart.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecom.Amazon.utils.CaptureScreenshot;
import com.Ecom.Amazon.utils.WebDriverUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class ProductSearchAndAddInCartTest extends WebDriverUtils{
	
	@Test(groups= {"Smoke"})
	public void productSearchAndAddInCartTest() throws InterruptedException{
		
		logintest.login();
		test = extent.createTest("ProductSearchAndAddInCartTest", "This is the test case to validate whether user is able to search the product and also able to add in the cart");	
		test.log(Status.INFO, "After login user is in the homepage");
		
	
		productSearchPageAndAddInCartPages.search_TextBox(properties.getProperty("SearchText"));
		Thread.sleep(5000);
		
		
		productSearchPageAndAddInCartPages.click_searchSubmitBuutton();
		Thread.sleep(5000);
		
		String OriginalTab = driver.getWindowHandle();
		
		

		productSearchPageAndAddInCartPages.get_ListOfAllItems();
		
		Thread.sleep(5000);

		productSearchPageAndAddInCartPages.click_OnProduct();
		Thread.sleep(5000);
		
		productSearchPageAndAddInCartPages.switch_NewWindowHandles();
		Thread.sleep(8000);
		
		productSearchPageAndAddInCartPages.click_Cart();
		Thread.sleep(5000);
		driver.switchTo().window(OriginalTab);
		
		//Take a snap 
		try {
			test.info("Test execution snapshot below: ", MediaEntityBuilder.createScreenCaptureFromPath(new CaptureScreenshot().captureScreen()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.log(Status.PASS, "User has searched the product and able to add in the cart");
		
		
	
		
		
		
	}

}
