package com.ibm.stax.BusinessLogic;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.BusinessUtilities.Common;

public class LoginPage extends Common {
	public Common cm;
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void signin() throws Exception
	{
		try
		{
			System.out.println("Shri Ganesh");
			System.out.println(this.getClass().getSimpleName() +":Login is successful :- Passed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(this.getClass().getSimpleName() +":Login is failed :- Failed");
		}
	}

}
