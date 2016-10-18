package commonClassesReusable;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ByID extends BrowserSelection {

	static WebElement element = null;

	public static void Click_Using_ID(String finalid, String screenshotname) throws IOException, InterruptedException {

		try {
			dynamicwait.WaitUntilElement(By.id(finalid));
			WebElement clickfn = driver.findElement(By.id(finalid));
			Jexecutor.highlightElement(clickfn);
			clickfn.click();
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to Click on" + screenshotname);
		}

	}

	public static void SendKeys_Without_Clearing_Previous_data_Using_ID(String finalid, String screenshotname,
			String entersomething) throws IOException, InterruptedException {
		try {
			dynamicwait.WaitUntilElement(By.id(finalid));
			WebElement sendkeysfn = driver.findElement(By.id(finalid));
			Jexecutor.highlightElement(sendkeysfn);
			sendkeysfn.sendKeys(entersomething);
			 
			 
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}

	}

	public static Boolean GetAttribute_Using_ID(String finalid, String screenshotname, String searchstring)

			throws IOException, InterruptedException {
		Boolean temp1 = false;
		// String comparestring = null;
		try {
			dynamicwait.WaitUntilElement(By.id(finalid));
			WebElement sendkeysfn = driver.findElement(By.id(finalid));
			Jexecutor.highlightElement(sendkeysfn);
			String comparestring = sendkeysfn.getAttribute("title");
			if (searchstring.equals(comparestring)) {
				temp1 = true;
			}
			 
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}
		return temp1;

	}

	
	public static String GetText_Using_ID(String finalid, String screenshotname)
			throws IOException, InterruptedException {
		String textvalue = null;
		try {
			dynamicwait.WaitUntilElement(By.id(finalid));
			WebElement sendkeysfn = driver.findElement(By.id(finalid));
			Jexecutor.highlightElement(sendkeysfn);
			textvalue = sendkeysfn.getText();
			 
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}
		return textvalue;

	}

	public static String GetText_Of_Db_Value_Using_ID(String finalid, String screenshotname, String attributeName)
			throws IOException, InterruptedException {
		String textvalue = null;
		try {
			dynamicwait.WaitUntilElement(By.id(finalid));
			WebElement sendkeysfn = driver.findElement(By.id(finalid));
			Jexecutor.highlightElement(sendkeysfn);
			textvalue = sendkeysfn.getAttribute(attributeName);
			 
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}
		return textvalue;

	}

	public static Boolean IsDisplayed_After_Clearing_Previous_data_Using_ID(String finalid, String screenshotname,
			String entersomething) throws IOException, InterruptedException {
		Boolean temp;
		try {
			WebElement sendkeysfn = driver.findElement(By.id(finalid));
			Jexecutor.highlightElement(sendkeysfn);
			temp = sendkeysfn.isDisplayed();
			 
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}
		return temp;

	}

	public static void Submit_Using_ID(String finalid, String screenshotname) throws IOException, InterruptedException {
		try {
			dynamicwait.WaitUntilElement(By.id(finalid));
			WebElement clickfn = driver.findElement(By.id(finalid));
			Jexecutor.highlightElement(clickfn);
			clickfn.submit();
			 
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to Submit  " + screenshotname);
		}

	}

	public static boolean Dropdown_Select(String finalid, String screenshotname, String ddl_value)
			throws IOException, InterruptedException {
		try {
			Dropdown_Select_Using_ID(finalid, screenshotname, Integer.parseInt(ddl_value));

		} catch (NumberFormatException nfe) {

			Dropdown_Select_Using_ID(finalid, screenshotname, (ddl_value));
			return false;
		}
		return true;
	}

	public static void Dropdown_Select_Using_ID(String finalid, String screenshotname, String dropdown_value)
			throws IOException, InterruptedException {
		try {
			dynamicwait.WaitUntilElement(By.id(finalid));
			WebElement clickfn = driver.findElement(By.id(finalid));
			Jexecutor.highlightElement(clickfn);
			Select select = new Select(driver.findElement(By.id(finalid)));
			select.selectByVisibleText(dropdown_value);
			 
		} catch (Exception e1) {
			throw new java.lang.RuntimeException(
					"Test Case failed as Not able to Select Value from dropdown  " + screenshotname);
		}

	}

	public static void Dropdown_Select_Using_ID_SelectByValue(String finalid, String screenshotname,
			String dropdown_value) throws IOException, InterruptedException {
		try {
			dynamicwait.WaitUntilElement(By.id(finalid));
			WebElement clickfn = driver.findElement(By.id(finalid));
			Jexecutor.highlightElement(clickfn);
			Select select = new Select(driver.findElement(By.id(finalid)));
			// select.selectByVisibleText(dropdown_value);
			select.selectByValue(dropdown_value);
				 
		} catch (Exception e1) {
			throw new java.lang.RuntimeException(
					"Test Case failed as Not able to Select Value from dropdown  " + screenshotname);
		}
	}

	public static void Dropdown_Select_Using_ID(String finalid, String screenshotname, int index_value)
			throws IOException, InterruptedException {
		try {
			dynamicwait.WaitUntilElement(By.id(finalid));
			WebElement clickfn = driver.findElement(By.id(finalid));
			Jexecutor.highlightElement(clickfn);
			Select select = new Select(driver.findElement(By.id(finalid)));
			select.selectByIndex(index_value);
				 
		} catch (Exception e1) {
			throw new java.lang.RuntimeException(
					"Test Case failed as Not able to Select Value from dropdown  " + screenshotname);
		}

	}

	public static void testForcefully_Checkbox_checked(String finalid, String screenshotname)
			throws IOException, InterruptedException {
		Boolean check;

		try {
			dynamicwait.WaitUntilElement(By.id(finalid));
			WebElement clickfn = driver.findElement(By.id(finalid));
			Jexecutor.highlightElement(clickfn);
			check = clickfn.isSelected();
		
			if (check == false) {
				clickfn.click();
			}
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to Check the  " + screenshotname);
		}

	}

	public static void testForcefully_Uncheckbox_checked(String finalid, String screenshotname)
			throws IOException, InterruptedException {
		Boolean check;

		try {
			dynamicwait.WaitUntilElement(By.id(finalid));
			WebElement clickfn = driver.findElement(By.id(finalid));
			Jexecutor.highlightElement(clickfn);
			check = clickfn.isSelected();
		
			if (check == true) {
				clickfn.click();
			}
		} catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to uncheck the  " + screenshotname);
		}

	}

	public static String getDropdownSelectedValue(String finalId, String screenshotname)
			throws IOException, InterruptedException {
		String selectedOption = "";
		try {

			dynamicwait.WaitUntilElement(By.id(finalId));
			WebElement dropdown = driver.findElement(By.id(finalId));
			Select select = new Select(driver.findElement(By.id(finalId)));
			selectedOption = select.getFirstSelectedOption().getText();

			Jexecutor.highlightElement(dropdown);

		}

		catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}
		return selectedOption;
	}

	public static boolean checkDropdownDefaultValue(String finalid, String screenshotname, String searchstring)
			throws IOException, InterruptedException {
		Boolean temp1 = false;
		try {

			dynamicwait.WaitUntilElement(By.id(finalid));
			WebElement dropdown = driver.findElement(By.id(finalid));
			Select select = new Select(driver.findElement(By.id(finalid)));
			String option = select.getFirstSelectedOption().getText();
            Jexecutor.highlightElement(dropdown);

			if (searchstring.equals(option)) {
				temp1 = true;
			}
		
		}

		catch (Exception e1) {
			throw new java.lang.RuntimeException("Test Case failed as Not able to  " + screenshotname);
		}
		return temp1;
	}
}
