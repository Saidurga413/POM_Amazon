package com.Ecom.Amazon.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CaptureScreenshot extends WebDriverUtils {
	
	public String captureScreen() throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest ="D://Automation_Reports//screenshots//SCREEN.png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
		
	}

}
