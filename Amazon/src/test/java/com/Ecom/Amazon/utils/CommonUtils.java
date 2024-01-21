package com.Ecom.Amazon.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class CommonUtils extends WebDriverUtils {
	
	String weburl = properties.getProperty("WebUrl");
	
	public void launchURL(String url) {
		driver.get(url);
	}
	
	public void selectByValue(By e, String value) {
		
		Select objSelect = new Select(driver.findElement(e));
		objSelect.selectByValue(value);
	}
	
	public void assertText(By e, String txt) {
		System.out.println(driver.findElement(e).getText());
		Assert.assertEquals(driver.findElement(e).getText().contains(txt), true);
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	
	public void sendKeys(By e, String txt) {
		driver.findElement(e).sendKeys(txt);
	}
	
	public void sendKeys(WebElement e , String txt) {
		e.sendKeys(txt);
	}
	
	public void checkWhetherElementIsDisplayed(By e){
		driver.findElement(e).isDisplayed();
	}
	
	public void click(WebElement e) {
		e.click();
	}
	
	public void click(By e) {
		driver.findElement(e).click();
	}
	
	public void waitForVisibility(WebElement e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public void waitForVisibility(By e) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(e)));
	}
	
	public void assertSuccessMsg(By e, String msg) {
		Assert.assertEquals(driver.findElement(e).getText(), msg);
	}
	
	public void navigateToUrl(String url) {	
		driver.navigate().to(weburl+url);	
	}
	
	public void navigateToUrl(String url,String id) {	
		driver.navigate().to(weburl+url+id);	
	}
	
	public void implicitWait(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}


}
