package com.ibm.stax.BusinessLogic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ibm.stax.BusinessUtilities.Common;

public class LoginPage extends Common {
	public Common cm;
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="")
	public WebElement id;
	
	@FindBy(xpath="")
	public WebElement pswd;
	
	@FindBy(xpath="")
	public WebElement btn;
	
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
	
	private void username()
	{
		id.sendKeys("");
	}
	
	private void password()
	{
		pswd.sendKeys("");
	}

	
	private void loginbutton()
	{
		btn.sendKeys("");
	}
}
