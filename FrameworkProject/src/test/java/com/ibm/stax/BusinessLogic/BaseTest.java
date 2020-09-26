package com.ibm.stax.BusinessLogic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	WebDriver driver;
	@BeforeClass
	public void logintoapp()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

}
