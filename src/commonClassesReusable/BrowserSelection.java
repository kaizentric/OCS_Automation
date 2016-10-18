package commonClassesReusable;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class BrowserSelection {
	protected static WebDriver driver;
	public static WebDriver globalSeleniumInstance;
	public static WebDriverBackedSelenium BackedSelenium;
	public static Logger log1 = Logger.getLogger("rootLogger");

	@BeforeSuite
	public static WebDriver beforeSuite() throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("Properties\\CommonProps.properties");
		properties.load(fis);

		String browser = properties.getProperty("browser_name");
		System.out.println("Selected browser is " + browser);
		switch (browser) {

		case "MF":
			System.out.println("Running FireFox");
			log1.info("Running FireFox");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;

		case "GC":
			System.setProperty("webdriver.chrome.driver", "Browser_Files/chromedriver.exe");
			System.out.println("Running Chrome");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

			break;

		case "IE":
			System.setProperty("webdriver.ie.driver", "Browser_Files/IEDriverServer.exe");
			DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(dc);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;

		case "AS":
			System.setProperty("webdriver.safari.driver", "Browser_Files\\SafariSetup.exe");
			System.out.println("Running Safari");
			driver = new SafariDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

			break;

		default:
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			System.out.println("Running Default Browser");
			log1.info("Running Default Browser");

			break;
		}
		return driver;
	}

	@AfterSuite
	public static void afterSuite() throws InterruptedException {
		System.out.println("After Suite");
		Thread.sleep(5000);
		driver.quit();
	}
}
