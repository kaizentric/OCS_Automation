package commonClassesReusable;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dynamicwait extends BrowserSelection {

	/**
	 * @param args
	 */
	public static void PageLoad() {
	
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		// TODO Auto-generated method stub
	}

	public static void WaitUntilElement(By by) {
		Boolean elementFound = false;
		long startTime = System.currentTimeMillis();
		long stopTime = System.currentTimeMillis();
		long time = 9000;

		while ((stopTime - startTime) < time) {
			List<WebElement> elements = driver.findElements(by);
			try {
				if (elements != null && elements.size() > 0) {
					elementFound = true;
					break;
				}
			} catch (Exception e) {
				System.out.println("Either Element is not present or Xpath might be wrong");
				log1.fatal("Either Element is not present or Xpath might be wrong");
			}
			stopTime = System.currentTimeMillis();
		}
		if (!elementFound) {
			throw new TimeoutException(String.format(
					"The expected element '{0}' has not found under specified time interval of '{1}' minute(s).", by,
					6000));
		}
	}

	public static Object textToBePresentInElement(final String finalxpath, String screenshotname)
			throws IOException, InterruptedException {
		Thread.sleep(3000);
		try {
			(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.findElement(By.xpath(finalxpath)).getText().length() != 0;
				}
			});

		} catch (Exception e1) {
			System.out.println("Not able to load " + screenshotname);
			log1.info("Not able to load " + screenshotname);
			AssertandScreenshot.ForcefulGenerateScreenshot("Not_able_to_load" + screenshotname);
			throw new java.lang.RuntimeException("Test Case failed as Not able to load the  " + screenshotname);
		}
		return null;

	}

}
