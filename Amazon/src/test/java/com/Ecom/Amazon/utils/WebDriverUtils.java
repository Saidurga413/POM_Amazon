package com.Ecom.Amazon.utils;

import java.io.FileInputStream;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.Ecom.Amazon.utils.PageInitialiser;
import com.aventstack.extentreports.ExtentReports;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.log4testng.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;



public class WebDriverUtils extends PageInitialiser{

	protected static WebDriver driver;
	protected static Properties properties;
	protected static ChromeOptions chromeOptions;
	protected static Logger log;


	public WebDriverUtils() {

		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream("src\\main\\resources\\Configuration\\config.properties");
			properties.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("io exception");

		}

	}

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;


	@BeforeSuite(alwaysRun=true)
	protected void extentReport() {
		System.out.println("Before Suite");
		htmlReporter = new ExtentSparkReporter("Amazon\\ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@BeforeMethod(alwaysRun=true)
	protected void initializaton() {

    	htmlReporter = new ExtentSparkReporter("ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
    	
		//Launch Browser and login
		String browserName = properties.getProperty("browser");
		driver = getDriver(browserName);

		new PageInitialiser().initializeAllPages();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}


	private static WebDriver getDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
//			driver = WebDriverManager.chromedriver().create();
//			return driver;
			
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/Driver/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			
			chromeOptions.addArguments("--start-maximized");
			return new ChromeDriver(chromeOptions);
		} else if (browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Driver\\geckodriver-v0.33.0-win64\\geckodriver.exe");
			return new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver","<Add location>");
			return new InternetExplorerDriver();
		}
		return null;
	}



	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();

	}

	@AfterSuite(alwaysRun=true)
	public void publish_extent() {
		extent.flush();
	}

}
