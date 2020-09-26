package com.ibm.stax.BusinessUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common extends Page{
	
	public static WebDriver driver;
	public String screenshot_path;
	
	public Common(WebDriver Driver)
	{
		super(driver);
	}
	
	public void maximize_browser()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println(this.getClass().getSimpleName()+" : maximize_browser :- Browser Maximized");
	}

	
	public void explicit_wait(String xpath) throws Exception
	{
		try
		{
			new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}
		catch(Exception e)
		{
			System.out.println(this.getClass().getSimpleName()+" : explicit_wait :-"
					+ " Explicit wait Failed for Element -"+xpath +"\n "+ e.toString());
			e.printStackTrace();
			//screenshot("Failed");
		}
	}
	
	public void explicit_wait_InvisibilityOfElement(String xpath) throws Exception
	{
		try
		{
			new WebDriverWait(driver,30).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
		}
		catch(Exception e)
		{
			System.out.println(this.getClass().getSimpleName()+" : explicit_wait :-"
					+ " Explicit wait Failed for Element -"+xpath +"\n "+ e.toString());
			e.printStackTrace();
			//screenshot("Failed");
		}
	}
	
	
	
	public void screenshot (String name,String class_name) throws IOException
	{
		
	}
	
	public void logger(String log) throws FileNotFoundException
	{
		
		String timestamp = new SimpleDateFormat("dd-MM-yy").format(new Date())+"_"+ new SimpleDateFormat("HH-mm-ss").format(new Date());
		
		String src1="Logs\\"+log+"_"+timestamp+".txt";
		PrintStream out = new PrintStream(new File(src1));
		System.setOut(out);
	}
	
	public void loggermain(String log) throws FileNotFoundException
	{
		
	}
	
	public void scrolldown()
	{
		
		JavascriptExecutor u = (JavascriptExecutor)driver;
		u.executeScript("window.scrollBy(0,400)");
	}
	
	public void scrollup()
	{
		
		JavascriptExecutor u = (JavascriptExecutor)driver;
		u.executeScript("window.scrollBy(0,-200)");
	}
	
	public void scroll_to_top()
	{
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0)");
	}
	
	public void scroll_till_element(String x)
	{
		WebElement element = driver.findElement(By.xpath(x));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public void scroll_to_bottom() throws Exception
	{
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(3000);
	}
	
	public void scroll_horizontally_in_grid(String xpth,int pixel)
	{
		Actions d=new Actions(driver);
		WebElement draggablepart=driver.findElement(By.xpath(xpth));
		d.moveToElement(draggablepart).clickAndHold().moveByOffset(pixel,0).release().perform();
	}
	
	
	public void logout() throws Exception
	{
		
	}
	
	


}
