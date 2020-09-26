package com.ibm.stax.BusinessLogic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.ibm.stax.BusinessUtilities.Common;
import com.ibm.stax.BusinessUtilities.Page;

public class BaseTest {
	
	public Common cm;
	public Page p;
	public WebDriver driver;

	@BeforeClass
	public void setup() throws IOException, Exception
	{
		//System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    driver.get("https://www.google.com/");
	   
		p=new Page(driver);
		 
	}
	
	
	@AfterClass
	public void Teardown()
	{
		driver.quit();
	}
	
	@AfterMethod
	public void screenshotfail(ITestResult Result) throws IOException
	{
		if(ITestResult.FAILURE==Result.getStatus())
		{
			cm.screenshot(driver);
		}
	}

}
