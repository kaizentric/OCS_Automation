package commonClassesReusable;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ByXpath extends BrowserSelection {

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	static List<WebElement> eleXpath = null;
	
	public static void Click_Using_Xpath(String finalxpath, String screenshotname)
			throws IOException, InterruptedException {
		try {
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			WebElement clickfn = driver.findElement(By.xpath(finalxpath));
			Jexecutor.highlightElement(clickfn);
			clickfn.click();
			
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to Click on  " + screenshotname);
		}

	}

	// fxn for popups appearing for short duration
	public static String GetText_Using_Xpath_early(String finalxpath, String screenshotname)
			throws IOException, InterruptedException {
		String textvalue = null;
		try {
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			WebElement sendkeysfn = driver.findElement(By.xpath(finalxpath));
			// Jexecutor.highlightElement(sendkeysfn);
			textvalue = sendkeysfn.getText();
			
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}
		return textvalue;

	}

	public static void SendKeys_Without_Clearing_Previous_data_Using_Xpath(String finalxpath, String screenshotname,
			String entersomething) throws IOException, InterruptedException {
		try {
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			WebElement sendkeysfn = driver.findElement(By.xpath(finalxpath));
			Jexecutor.highlightElement(sendkeysfn);
			sendkeysfn.sendKeys(entersomething);
			
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}

	}

	public static Boolean GetAttribute_Using_Xpath(String finalxpath, String screenshotname, String searchstring)
			throws IOException, InterruptedException {
		Boolean temp1 = false;
		String comparestring = null;
		try {
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			WebElement sendkeysfn = driver.findElement(By.xpath(finalxpath));
			Jexecutor.highlightElement(sendkeysfn);
			comparestring = sendkeysfn.getAttribute("title");
			if (searchstring.equals(comparestring)) {
				temp1 = true;
			}
			
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}
		return temp1;

	}

	public static void SendKeys_After_Clearing_Previous_data_Using_Xpath(String finalxpath, String screenshotname,
			String entersomething) throws IOException, InterruptedException {
		try {
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			WebElement sendkeysfn = driver.findElement(By.xpath(finalxpath));
			Jexecutor.highlightElement(sendkeysfn);
			sendkeysfn.clear();
			sendkeysfn.sendKeys(entersomething);
			
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}

	}

	public static String GetText_Using_Xpath(String finalxpath, String screenshotname)
			throws IOException, InterruptedException {
		String textvalue = null;
		try {
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			WebElement sendkeysfn = driver.findElement(By.xpath(finalxpath));

			textvalue = sendkeysfn.getText();
			
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}
		return textvalue;

	}

	public static boolean IsDisplayed_After_Clearing_Previous_data_Using_Xpath(String finalxpath, String screenshotname)
			throws IOException, InterruptedException {
		boolean temp;
		try {
			WebElement sendkeysfn = driver.findElement(By.xpath(finalxpath));
			Jexecutor.highlightElement(sendkeysfn);
			temp = sendkeysfn.isDisplayed();
			
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}
		return temp;

	}

	public static void Submit_Using_Xpath(String finalxpath, String screenshotname)
			throws IOException, InterruptedException {
		try {
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			WebElement clickfn = driver.findElement(By.xpath(finalxpath));
			Jexecutor.highlightElement(clickfn);
			clickfn.submit();
			
		} catch (Exception e1) {
			
			throw new java.lang.RuntimeException("Test Case failed as Not able to Submit  " + screenshotname);
		}

	}

	public static boolean Dropdown_Select(String finalxpath, String screenshotname, String ddl_value)
			throws IOException, InterruptedException {
		try {
			Dropdown_Select_Using_Xpath(finalxpath, screenshotname, Integer.parseInt(ddl_value));
		} catch (NumberFormatException nfe) {
			Dropdown_Select_Using_Xpath(finalxpath, screenshotname, (ddl_value));
			return false;
		}
		return true;
	}

	public static void Dropdown_Select_Using_Xpath(String finalxpath, String screenshotname, int index_value)
			throws IOException, InterruptedException {
		try {
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			WebElement clickfn = driver.findElement(By.xpath(finalxpath));
			Jexecutor.highlightElement(clickfn);
			Select select = new Select(driver.findElement(By.xpath(finalxpath)));
			select.selectByIndex(index_value);
			
		} catch (Exception e1) {
			throw new java.lang.RuntimeException(
					"Test Case failed as Not able to Select Value from dropdown  " + screenshotname);
		}

	}

	public static void Dropdown_Select_Using_Xpath(String finalxpath, String screenshotname, String dropdown_value)
			throws IOException, InterruptedException {
		try {
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			WebElement clickfn = driver.findElement(By.xpath(finalxpath));
			Jexecutor.highlightElement(clickfn);
			Select select = new Select(driver.findElement(By.xpath(finalxpath)));
			select.selectByVisibleText(dropdown_value);
			
		} catch (Exception e1) {
			throw new java.lang.RuntimeException(
					"Test Case failed as Not able to Select Value from dropdown  " + screenshotname);
		}

	}

	public static void testForcefully_Checkbox_checked(String finalxpath, String screenshotname)
			throws IOException, InterruptedException {
		Boolean check;

		try {
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			WebElement clickfn = driver.findElement(By.xpath(finalxpath));
			Jexecutor.highlightElement(clickfn);
			check = clickfn.isSelected();
			
			if (check == false) {
				clickfn.click();
			}
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to Check the  " + screenshotname);
		}

	}

	public static void testForcefully_Uncheckbox_checked(String finalxpath, String screenshotname)
			throws IOException, InterruptedException {
		Boolean check;

		try {
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			WebElement clickfn = driver.findElement(By.xpath(finalxpath));
			Jexecutor.highlightElement(clickfn);
			check = clickfn.isSelected();
			
			if (check == true) {
				clickfn.click();
			}
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to uncheck the  " + screenshotname);
		}
	}

	public static int getSizeUsingXpath(String xpath, String screenshotname) throws IOException, InterruptedException {
		try {
			int size = 0;
			size = driver.findElements(By.xpath(xpath)).size();
			return size;

		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to" + screenshotname);
		}
	}

	public static String GetAttributeValue_Using_Xpath(String finalxpath, String screenshotname, String attributeName)
			throws IOException, InterruptedException {
		
		String value = "";
		try {
			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			WebElement ele = driver.findElement(By.xpath(finalxpath));
			value=ele.getAttribute(attributeName);
			return value;
			
		} catch (Exception e) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to uncheck the  " + screenshotname);
		}
		
	}

	public static String getDropdownSelectedValue(String finalxpath, String screenshotname)
			throws IOException, InterruptedException {
		String selectedOption = "";
		try {

			dynamicwait.WaitUntilElement(By.xpath(finalxpath));
			WebElement dropdown = driver.findElement(By.xpath(finalxpath));
			Select select = new Select(driver.findElement(By.xpath(finalxpath)));
			selectedOption = select.getFirstSelectedOption().getText();

			Jexecutor.highlightElement(dropdown);

		}

		catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}
		return selectedOption;
	}

	public static void enterTextInMultibleTextboxes(String urlPath, String[] xPathArray, String[] valuesArray)
	/**
	 * Make Sure The Text Values are same order as Xpath values. Also the data
	 * Type should accurate
	 */
	{
		driver.get(urlPath);
		if (xPathArray.length == valuesArray.length) {
			byte i = 0;
			for (String st : xPathArray) {
				try {
					ByXpath.SendKeys_After_Clearing_Previous_data_Using_Xpath(st, "Entering_Text_Through_Array",
							valuesArray[i]);
					i++;
				} catch (Exception e) {
					System.out.println("Problem Occur in ByXpath.enterTextInMultibleTextboxes() function.");
					// TODO: handle exception
				}
			}

		} else {
			System.out.println("Please Check xPath array and Value Array");
		}
	}

	public static String GetText_Of_Db_Value_Using_Xpath(String finalXpath, String screenshotname, String attributeName)
			throws IOException, InterruptedException {
		String textvalue = null;
		try {
			dynamicwait.WaitUntilElement(By.xpath(finalXpath));
			WebElement sendkeysfn = driver.findElement(By.xpath(finalXpath));
			Jexecutor.highlightElement(sendkeysfn);
			textvalue = sendkeysfn.getAttribute(attributeName);
			
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}
		return textvalue;

	}
	public static void Dropdown_Select_Using_ByVisibleText(String finalname, String screenshotname, String visible_text) throws IOException, InterruptedException 
	{
		try
		{
		dynamicwait.WaitUntilElement(By.xpath(finalname));
		WebElement clickfn = driver.findElement(By.xpath(finalname));
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
	
	
}
