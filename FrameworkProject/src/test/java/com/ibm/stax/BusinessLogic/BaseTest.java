package com.ibm.stax.BusinessLogic;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ibm.stax.BusinessUtilities.Common;
import com.ibm.stax.BusinessUtilities.Page;

public class BaseTest {
	
	
	public Page p;
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void suitesetup()
	{
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Login"+Common.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
	}
	
	//@Parameters("Browser")

	@BeforeClass
	public void setup() throws IOException, Exception
	{
		
		/*if(Browser.equalsIgnoreCase("chrome"))
		{
		    System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
			driver=new ChromeDriver();
		}
		
	  if(Browser.equalsIgnoreCase("firefox"))
	{
			System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else if(Browser.equalsIgnoreCase("ie"))
		{
			driver=new InternetExplorerDriver();
		}*/
		
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    driver.get("https://www.google.com/");
	   
		p=new Page(driver);
		 
	}
	
	
	@AfterClass
	public void Teardown()
	{
		//driver.quit();
	}
	
	@AfterMethod
	public void screenshotfail(ITestResult Result) throws IOException
	{
		
		if(ITestResult.FAILURE==Result.getStatus())
		{
			Common.screenshot(driver);
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Common.screenshot(driver)).build());
		}
		/*else if(ITestResult.SUCCESS==Result.getStatus())
		{
			Common.screenshot(driver);
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Common.screenshot(driver)).build());
		}
		
		else if(ITestResult.SKIP==Result.getStatus())
		{
			Common.screenshot(driver);
			logger.skip("Test Skipped",MediaEntityBuilder.createScreenCaptureFromPath(Common.screenshot(driver)).build());
		}
		*/
		
		report.flush();
		
	}

}
