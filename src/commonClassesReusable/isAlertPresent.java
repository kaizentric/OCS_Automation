package commonClassesReusable;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class isAlertPresent extends BrowserSelection {
	public static boolean checkAlertPresent() {

		boolean presentFlag = false;

		try {

			driver.switchTo().alert();

			presentFlag = true;
		} catch (NoAlertPresentException ex) {

			System.out.println("Verified that their is no alert present");
			
		}
		return presentFlag;
	}

	public static boolean acceptAlert() throws InterruptedException {

		boolean presentFlag = false;
		Thread.sleep(2000);
		try {
			// Check the presence of alert
			Alert alert = driver.switchTo().alert();
			// Alert present; set the flag
			presentFlag = true;
			// if present consume the alert
			alert.accept();
			System.out.println("Alert Accepted");
		} catch (NoAlertPresentException ex) {

			ex.printStackTrace();
		}
		Thread.sleep(5000);
		return presentFlag;
	}

	public static boolean rejectAlert() throws InterruptedException, IOException {

		boolean presentFlag = false;
		Thread.sleep(2000);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		FileUtils.copyFile(scrFile, new File("Results\\modaldialogue.jpeg"));
		System.out.println("Screenshot has been generated for modaldialogue");
		System.out.println("Screenshot taken");
		try {

			Alert alert = driver.switchTo().alert();

			presentFlag = true;

			alert.dismiss();
			System.out.println("Alert Rejected");
		} catch (NoAlertPresentException ex) {
			// Alert not present
			ex.printStackTrace();
		}
		Thread.sleep(5000);
		return presentFlag;
	}
}
