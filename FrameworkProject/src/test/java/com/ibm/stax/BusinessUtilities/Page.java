package com.ibm.stax.BusinessUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {
	
	public WebDriver driver;
	
	public Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public <TPage extends Common> TPage getInstance(Class<TPage> pageClass)
	{
		try
		{
			//syntax to call normal POM
			//return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
			
			//syntax to call PageFactory POM
			return PageFactory.initElements(this.driver,pageClass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

}
