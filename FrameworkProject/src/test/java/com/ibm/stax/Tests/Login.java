package com.ibm.stax.Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.BaseTest;
import com.ibm.stax.BusinessLogic.LoginPage;

public class Login extends BaseTest {
	
	@Test
	public void logintoapp() throws Exception
	{
		logger=report.createTest("Login to application");
		logger.info("Start Application");
	    p.getInstance(LoginPage.class).signin();
	    logger.pass("Login is succesfull");
	}
		
}
