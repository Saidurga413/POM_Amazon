package Amazon.ProductSearchAndInCart.Page;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ecom.Amazon.utils.CommonUtils;

public class ProductSearchPageAndAddInCartPage extends CommonUtils{
	
	public ProductSearchPageAndAddInCartPage() {
		PageFactory.initElements(driver, this);	
		
	}
	
	@FindBy(xpath = "//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']")
	public WebElement addtocartbutton;
	
	//span[normalize-space()='45,990']
	//div[contains(@class,'rush-component s-featured-result-item')]//span[@class='a-price-whole'][normalize-space()='44,990']
	@FindBy(xpath = "//div[@class='a-section a-spacing-none a-spacing-top-micro puis-price-instructions-style']//span[@class='a-price-whole'][normalize-space()='53,990']")
	public WebElement OnProduct;
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	public WebElement TestBox;
	
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	public WebElement searchSubmitBuutton;

	public void click_Cart() {
		click(addtocartbutton);
		
	}

	public void click_OnProduct() {
		click(OnProduct);
		
	}
	
	public void switch_NewWindowHandles() {
		Set<String> windowHandles11 = driver.getWindowHandles();
		System.out.println(windowHandles11);
		String originalTab11 = driver.getWindowHandle();
		for (String windowHandle : windowHandles11) {
			if (!windowHandle.equals(originalTab11)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

	}

	public void get_ListOfAllItems() {
		List<WebElement> gggg = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		for(WebElement ggh : gggg) {
			System.out.println(ggh.getText());
		}
		
	}

	public void search_TextBox(String string) throws InterruptedException {
		click(TestBox);
		Thread.sleep(5000);
		sendKeys(TestBox, string);
		
	}

	public void click_searchSubmitBuutton() {
		click(searchSubmitBuutton);
		
	}

}
