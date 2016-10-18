package commonClassesReusable;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class ByName extends BrowserSelection
{

	
	public static void Click_Using_Name(String finalname, String screenshotname) throws IOException, InterruptedException 
	{
		try
		{
		dynamicwait.WaitUntilElement(By.name(finalname));
		WebElement clickfn = driver.findElement(By.name(finalname));
		Jexecutor.highlightElement(clickfn);
		clickfn.click();
		AssertandScreenshot.checkerroralertcomesandaccept(screenshotname);
		AssertandScreenshot.GenerateScreenshot(screenshotname);
		System.out.println(screenshotname);
		 
		}
		catch(Exception e1)
		{
		throw new java.lang.RuntimeException("Test Case failed as Not able to Click on  " + screenshotname);
		}

	}
	
	public static void SendKeys_Without_Clearing_Previous_data_Using_Name(String finalname, String screenshotname, String entersomething) throws IOException, InterruptedException 
	{
		try
		{
		dynamicwait.WaitUntilElement(By.name(finalname));
		WebElement sendkeysfn = driver.findElement(By.name(finalname));
		Jexecutor.highlightElement(sendkeysfn);
		sendkeysfn.sendKeys(entersomething);
		AssertandScreenshot.checkerroralertcomesandaccept(screenshotname);
		AssertandScreenshot.GenerateScreenshot(screenshotname);
		System.out.println(screenshotname);
		 
		}
		catch(Exception e1)
		{
		throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}

	}
	
	public static Boolean GetAttribute_Using_Name(String finalname, String screenshotname, String searchstring) throws IOException, InterruptedException 
	{
		Boolean temp1 = false;
		String comparestring = null;
		try
		{
		dynamicwait.WaitUntilElement(By.name(finalname));
		WebElement sendkeysfn = driver.findElement(By.name(finalname));
		Jexecutor.highlightElement(sendkeysfn);
		comparestring = sendkeysfn.getAttribute("title");
		if(searchstring.equals(comparestring))
		{
			temp1 = true;
		}
		AssertandScreenshot.checkerroralertcomesandaccept(screenshotname);
		AssertandScreenshot.GenerateScreenshot(screenshotname);
		System.out.println(screenshotname);
		 
		}
		catch(Exception e1)
		{
		throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}
		return temp1;

	}
	
	public static void SendKeys_After_Clearing_Previous_data_Using_Name(String finalname, String screenshotname, String entersomething) throws IOException, InterruptedException 
	{
		try
		{
		dynamicwait.WaitUntilElement(By.name(finalname));
		WebElement sendkeysfn = driver.findElement(By.name(finalname));
		Jexecutor.highlightElement(sendkeysfn);
		sendkeysfn.clear();
		sendkeysfn.sendKeys(entersomething);
		AssertandScreenshot.checkerroralertcomesandaccept(screenshotname);
		AssertandScreenshot.GenerateScreenshot(screenshotname);
		System.out.println(screenshotname);
		 
		}
		catch(Exception e1)
		{
		throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}

	}
	
	public static String GetText_Using_Name(String finalname, String screenshotname) throws IOException, InterruptedException 
	{
		String textvalue = null;
		try
		{
		dynamicwait.WaitUntilElement(By.name(finalname));
		WebElement sendkeysfn = driver.findElement(By.name(finalname));
		Jexecutor.highlightElement(sendkeysfn);
		textvalue = sendkeysfn.getText();
		AssertandScreenshot.checkerroralertcomesandaccept(screenshotname);
		AssertandScreenshot.GenerateScreenshot(screenshotname);
		System.out.println(screenshotname);
		 
		}
		catch(Exception e1)
		{
		throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}
		return textvalue;

	}
	
	public static Boolean IsDisplayed_After_Clearing_Previous_data_Using_Name(String finalname, String screenshotname, String entersomething) throws IOException, InterruptedException 
	{
		Boolean temp;
		try
		{
		WebElement sendkeysfn = driver.findElement(By.name(finalname));
		Jexecutor.highlightElement(sendkeysfn);
		temp = sendkeysfn.isDisplayed();
		AssertandScreenshot.checkerroralertcomesandaccept(screenshotname);
		AssertandScreenshot.GenerateScreenshot(screenshotname);
		System.out.println(screenshotname);
		 
		}
		catch(Exception e1)
		{
		throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}
		return temp;

	}
	
	public static void Submit_Using_Name(String finalname, String screenshotname) throws IOException, InterruptedException 
	{
		try
		{
		dynamicwait.WaitUntilElement(By.name(finalname));
		WebElement clickfn = driver.findElement(By.name(finalname));
		Jexecutor.highlightElement(clickfn);
		clickfn.submit();
		AssertandScreenshot.checkerroralertcomesandaccept(screenshotname);
		AssertandScreenshot.GenerateScreenshot(screenshotname);
		System.out.println(screenshotname);
		 
		}
		catch(Exception e1)
		{
		throw new java.lang.RuntimeException("Test Case failed as Not able to Submit  " + screenshotname);
		}

	}
	
	public static boolean Dropdown_Select(String finalname, String screenshotname, String ddl_value) throws IOException, InterruptedException  
	{  
	  try  
	  {  
		  Dropdown_Select_Using_Name(finalname,screenshotname,Integer.parseInt(ddl_value));
	  }  
	  catch(NumberFormatException nfe)  
	  {
		 Dropdown_Select_Using_Name(finalname,screenshotname,(ddl_value));  
	    return false;  
	  }  
	  return true;  
	}
	
	
	public static void Dropdown_Select_Using_Name(String finalname, String screenshotname, String dropdown_value) throws IOException, InterruptedException 
	{
		try
		{
		dynamicwait.WaitUntilElement(By.name(finalname));
		WebElement clickfn = driver.findElement(By.name(finalname));
		Jexecutor.highlightElement(clickfn);
		Select select = new Select(driver.findElement(By.name(finalname)));
		select.selectByValue(dropdown_value);
		AssertandScreenshot.checkerroralertcomesandaccept(screenshotname);
		AssertandScreenshot.GenerateScreenshot(screenshotname);
		System.out.println(screenshotname);
		 
		}
		catch(Exception e1)
		{
		throw new java.lang.RuntimeException("Test Case failed as Not able to Select Value from dropdown  " + screenshotname);
		}

	}
	public static void Dropdown_Select_Using_ByVisibleText(String finalname, String screenshotname, String visible_text) throws IOException, InterruptedException 
	{
		try
		{
		dynamicwait.WaitUntilElement(By.name(finalname));
		WebElement clickfn = driver.findElement(By.name(finalname));
		Jexecutor.highlightElement(clickfn);
		Select select = new Select(driver.findElement(By.name(finalname)));
		select.selectByVisibleText(visible_text);
		AssertandScreenshot.checkerroralertcomesandaccept(screenshotname);
		AssertandScreenshot.GenerateScreenshot(screenshotname);
		System.out.println(screenshotname);
		 
		}
		catch(Exception e1)
		{
		throw new java.lang.RuntimeException("Test Case failed as Not able to Select Value from dropdown  " + screenshotname);
		}

	}
	
	public static void Dropdown_Select_Using_Name(String finalname, String screenshotname, int index_value) throws IOException, InterruptedException 
	{
		try
		{
		dynamicwait.WaitUntilElement(By.name(finalname));
		WebElement clickfn = driver.findElement(By.name(finalname));
		Jexecutor.highlightElement(clickfn);
		Select select = new Select(driver.findElement(By.name(finalname)));
		select.selectByIndex(index_value);
		AssertandScreenshot.checkerroralertcomesandaccept(screenshotname);
		AssertandScreenshot.GenerateScreenshot(screenshotname);
		System.out.println(screenshotname);
		 
		}
		catch(Exception e1)
		{
		throw new java.lang.RuntimeException("Test Case failed as Not able to Select Value from dropdown  " + screenshotname);
		}

	}
	
	
	public static void testForcefully_Checkbox_checked(String finalname, String screenshotname ) throws IOException, InterruptedException
	{
		Boolean check;
		
		try
		{
		dynamicwait.WaitUntilElement(By.id(finalname));
		WebElement clickfn = driver.findElement(By.id(finalname));
		Jexecutor.highlightElement(clickfn);
		check = clickfn.isSelected();
		AssertandScreenshot.checkerroralertcomesandaccept(screenshotname);
		AssertandScreenshot.GenerateScreenshot(screenshotname);
		System.out.println(screenshotname);
		 
		
		if(check == false)
		{
			clickfn.click();
		}
		}
		catch(Exception e1)
		{
		throw new java.lang.RuntimeException("Test Case failed as Not able to Check the  " + screenshotname);
		}

	}
	
	public static void testForcefully_Uncheckbox_checked(String finalname, String screenshotname ) throws IOException, InterruptedException
	{
		Boolean check;
		
		try
		{
		dynamicwait.WaitUntilElement(By.id(finalname));
		WebElement clickfn = driver.findElement(By.id(finalname));
		Jexecutor.highlightElement(clickfn);
		check = clickfn.isSelected();
		AssertandScreenshot.checkerroralertcomesandaccept(screenshotname);
		AssertandScreenshot.GenerateScreenshot(screenshotname);
		System.out.println(screenshotname);
		 
		
		if(check == true)
		{
			clickfn.click();
		}
		}
		catch(Exception e1)
		{
		throw new java.lang.RuntimeException("Test Case failed as Not able to uncheck the  " + screenshotname);
		}

	}

}
