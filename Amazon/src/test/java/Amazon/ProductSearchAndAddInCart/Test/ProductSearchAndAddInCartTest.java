package Amazon.ProductSearchAndAddInCart.Test;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Ecom.Amazon.utils.WebDriverUtils;

public class ProductSearchAndAddInCartTest extends WebDriverUtils{
	
	@Test(groups= {"Smoke"})
	public void productSearch() throws InterruptedException{
		
		logintest.login();
		
		//input[@id='twotabsearchtextbox']
		WebElement gg = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		gg.click();
		Thread.sleep(5000);
		
		gg.sendKeys("hp pavilion laptop");
		
		//input[@id='nav-search-submit-button']
		WebElement ggg = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		ggg.click();
		Thread.sleep(5000);
		
		String OriginalTab = driver.getWindowHandle();
		
		
		//span[@class='a-size-medium a-color-base a-text-normal']
		List<WebElement> gggg = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		for(WebElement ggh : gggg) {
			System.out.println(ggh.getText());
		}
		
//		for (WebElement webElement1 : gggg) {
//			System.out.println(webElement1.getText());
//			if(webElement1.getText().trim().equals("HP Pavilion 15, Ryzen 5 5625U, 15.6 inch(39.6cm) FHD Laptop, 8GB RAM,512GB SSD, AMD Radeon Graphics,B&O Audio, Backlit Keypad(Win 11,Alexa,1.75 Kgs,Natural Silver) 15-eh2050au")) {
//				webElement1.click();
//				break;
//			}
//		}
		//div[contains(@class,'rush-component s-featured-result-item')]//span[@class='a-price-whole'][normalize-space()='44,990']
		Thread.sleep(2000);
		WebElement list = driver.findElement(By.xpath("//div[contains(@class,'rush-component s-featured-result-item')]//span[@class='a-price-whole'][normalize-space()='44,990']"));
		list.click();
		Thread.sleep(5000);
		
		Set<String> windowHandles11 = driver.getWindowHandles();
		System.out.println(windowHandles11);
		String originalTab11 = driver.getWindowHandle();
		for (String windowHandle : windowHandles11) {
			if (!windowHandle.equals(originalTab11)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		Thread.sleep(8000);
		
		//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']
		WebElement ggg1 = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']"));
		ggg1.click();
		Thread.sleep(5000);
		
		
	
		
		
		
	}

}
