package commonClassesReusable;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AssertandScreenshot extends BrowserSelection {
	public static boolean isTextPresent(String text) {
		try {
			boolean b;
			b = driver.getPageSource().contains(text);
			return b;
		} catch (Exception e) {
			System.out.println(text + " ------ not present test case failed");
			System.exit(0);
			return false;
		}
	}

	/*
	 * public static void contactassert() throws InterruptedException {
	 * System.out.println("contact assert"); Thread.sleep(2000);
	 * assertTrue(isTextPresent("Contact Summary"));
	 * System.out.println("User is at Contacts Page");
	 * 
	 * } public static void adminassert() throws InterruptedException {
	 * System.out.println("admin assert"); Thread.sleep(2000);
	 * assertTrue(isTextPresent("Organizational Chart"));
	 * System.out.println("User is at Admin Page");
	 * 
	 * }
	 */
	public static void GenerateScreenshot(String SSname) throws IOException, InterruptedException {
		try {
			if ("Error" == driver.getTitle() || "Server Error" == driver.getTitle()) {
				Thread.sleep(4000);
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// Now you can do whatever you need to do with it, for example
				// copy somewhere
				FileUtils.copyFile(scrFile,
						new File("Results\\" + ReadDataFromPropertiesFile.readProperty_CommonProps("newfoldercreated")
								+ "\\Screenshot\\" + SSname + ".jpeg"));
				System.out.println("Screenshot has been generated for server error and location is  " + SSname);

			}
			// It will check whether server error is coming in a page
			if (isTextPresent("Server") || isTextPresent("Page not found") || isTextPresent("Server Error")) {
				Thread.sleep(4000);
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// Now you can do whatever you need to do with it, for example
				// copy somewhere
				FileUtils.copyFile(scrFile,
						new File("Results\\" + ReadDataFromPropertiesFile.readProperty_CommonProps("newfoldercreated")
								+ "\\Screenshot\\" + SSname + ".jpeg"));
				System.out.println("Screenshot has been generated for " + SSname);

			}
			/*
			 * else { System.out.println("Everything is working fine"); }
			 */
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Everything is working fine");
		}

	}

	public static void ForcefulGenerateScreenshot(String SSname) throws IOException, InterruptedException {
		// It will check whether server error is coming in a page

		Thread.sleep(4000);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		FileUtils.copyFile(scrFile,
				new File("Results\\" + ReadDataFromPropertiesFile.readProperty_CommonProps("newfoldercreated")
						+ "\\Screenshot\\" + SSname + ".jpeg"));
		System.out.println("Screenshot has been generated for " + SSname);
		System.out.println("Screenshot taken");

	}

	public static void alertScreenshot(String SSname)
			throws IOException, InterruptedException, HeadlessException, AWTException {

		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png",
				new File("Results\\" + ReadDataFromPropertiesFile.readProperty_CommonProps("newfoldercreated")
						+ "\\Screenshot\\" + SSname + ".jpeg"));
		System.out.println("Screenshot has been generated for " + SSname);
	}

	public static void checkerroralertcomesandaccept(String SSname)
			throws IOException, InterruptedException, HeadlessException, AWTException {
		boolean abc = isAlertPresent.checkAlertPresent();
		if (abc == true) {
			alertScreenshot(SSname);
			isAlertPresent.acceptAlert();

		}
	}

	public static void GenerateScreenshot1(int SSname) throws IOException, InterruptedException {
		try {
			if ("Error" == driver.getTitle() || "Server Error" == driver.getTitle()) {
				Thread.sleep(4000);
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// Now you can do whatever you need to do with it, for example
				// copy somewhere
				FileUtils.copyFile(scrFile,
						new File("Results\\" + ReadDataFromPropertiesFile.readProperty_CommonProps("newfoldercreated")
								+ "\\Screenshot\\" + SSname + ".jpeg"));
				System.out.println("Screenshot has been generated for server error and location is  " + SSname);

			}
			// It will check whether server error is coming in a page
			if (isTextPresent("Server") || isTextPresent("Page not found") || isTextPresent("Server Error")) {
				Thread.sleep(4000);
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// Now you can do whatever you need to do with it, for example
				// copy somewhere
				FileUtils.copyFile(scrFile,
						new File("Results\\" + ReadDataFromPropertiesFile.readProperty_CommonProps("newfoldercreated")
								+ "\\Screenshot\\" + SSname + ".jpeg"));
				System.out.println("Screenshot has been generated for " + SSname);
			}
			/*
			 * else { System.out.println("Everything is working fine"); }
			 */
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Everything is working fine");
		}

	}

}
