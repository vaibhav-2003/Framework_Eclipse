package com.ibm.stax.Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.BaseTest;
import com.ibm.stax.BusinessLogic.LoginPage;

public class Login extends BaseTest {
	
	@Test
	public void logintoapp() throws Exception
	{
	    p.getInstance(LoginPage.class).signin();
	}
		
}
