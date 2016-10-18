package commonClassesReusable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Jexecutor extends BrowserSelection {
	public static void highlightElement(WebElement element) throws InterruptedException {
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
				"color: brown; border: 4px solid black;");
		Thread.sleep(1000);*/
	}
	
	public static void hidePopup(WebElement element) throws InterruptedException {

		// js.executeScript("arguments[0].setAttribute(style.visibility='visible';
		// ");
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility='hidden';",element);
			//((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';",element);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
