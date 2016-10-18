package testScripts;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import commonClassesReusable.BrowserSelection;
import commonClassesReusable.ByName;
import commonClassesReusable.ByXpath;
import commonClassesReusable.ReadDataFromPropertiesFile;

public class TestScript extends BrowserSelection {

	@Test(priority = 1, enabled = true, description = "Login >>	Login with invalid credentials")
	public static void tc_001() throws IOException, InterruptedException {
		try {
			// Navigating to URL
			driver.get(ReadDataFromPropertiesFile.readProperty_CommonProps("baseURL"));
			ByName.SendKeys_After_Clearing_Previous_data_Using_Name(
					ReadDataFromPropertiesFile.readProperty_CommonProps("name_loginPage_UserName_TextBox"),
					"enter incorrect username", "ABCDFED");
			ByName.SendKeys_After_Clearing_Previous_data_Using_Name(
					ReadDataFromPropertiesFile.readProperty_CommonProps("name_loginPage_Password_TextBox"),
					"enter incorrect password", "12345");
			ByXpath.Click_Using_Xpath(
					ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_loginPage_Login_Button"),
					"click on login button");
			Assert.assertTrue(driver.getTitle().equals("Login"), "User is not on the same page(Login page).------>");
		} catch (Exception e) {
			throw new java.lang.RuntimeException(e);
		}
	}

	@Test(priority = 2, enabled = true, description = "Login >>	Login with valid credentials")
	public static void tc_002() throws IOException, InterruptedException {
		try {

			Thread.sleep(2000);
			driver.get(ReadDataFromPropertiesFile.readProperty_CommonProps("baseURL"));
			ByName.SendKeys_After_Clearing_Previous_data_Using_Name(
					ReadDataFromPropertiesFile.readProperty_CommonProps("name_loginPage_UserName_TextBox"),
					"enter correct username", "Admin");
			ByName.SendKeys_After_Clearing_Previous_data_Using_Name(
					ReadDataFromPropertiesFile.readProperty_CommonProps("name_loginPage_Password_TextBox"),
					"enter correct password", "123");
			ByXpath.Click_Using_Xpath(
					ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_loginPage_Login_Button"),
					"click on login button");
			Assert.assertTrue(
					driver.findElements(By.xpath(ReadDataFromPropertiesFile
							.readProperty_CommonProps("xpath_DashBoardPage_Table_QuickLinkColunmName"))).size() > 0,
					"User does not able navigate on Dashboad page.------>");
		} catch (Exception e) {
			throw new java.lang.RuntimeException(e);
		}
	}

	@Test(priority = 3, enabled = true, description = "Operations - site >> 1. Enter text in Site Name textbox 2. Click on Reload Button >> Table should be Filter out accordingly")
	public static void tc_003() throws IOException, InterruptedException {
		try {

			Thread.sleep(2000);
			Actions action = new Actions(driver);
			WebElement operationsMenu = driver.findElement(By
					.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboardPage_OperationsMenu")));
			action.moveToElement(operationsMenu).build().perform();
			Thread.sleep(2000);
			ByXpath.Click_Using_Xpath(
					ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboardPage_Operations_SitesSubMenu"),
					"clicking on sites sub menu under operations menu");
			ByName.SendKeys_After_Clearing_Previous_data_Using_Name(
					ReadDataFromPropertiesFile.readProperty_CommonProps("name_sitesPage_siteNameTextBox"),
					"entering site name in textbox", "facebook");
			ByXpath.Click_Using_Xpath(
					ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_sitesPage_reloadButton"),
					"clicking on reload button");
			int totalSearchRecords = driver.findElements(By.xpath(
					ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_sitePage_searchRecordsContainsKeyword")))
					.size();
			Assert.assertTrue(totalSearchRecords > 0, "No search record found");

		} catch (Exception e) {
			throw new java.lang.RuntimeException(e);
		} finally {
			ByXpath.Click_Using_Xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboarPage"),
					"Clicking on dashbarod menu");
		}
	}

	@Test(priority = 4, enabled = true, description = "Operations - site >> 1. Select 'No' from Published Dropdown >> All the rows of table should be hiddden")
	public static void tc_004() throws IOException, InterruptedException {
		try {

			Thread.sleep(2000);
			Actions action = new Actions(driver);
			WebElement operationsMenu = driver.findElement(By
					.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboardPage_OperationsMenu")));
			action.moveToElement(operationsMenu).build().perform();
			Thread.sleep(2000);
			ByXpath.Click_Using_Xpath(
					ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboardPage_Operations_SitesSubMenu"),
					"clicking on sites sub menu under operations menu");
			ByName.Dropdown_Select_Using_ByVisibleText(
					ReadDataFromPropertiesFile.readProperty_CommonProps("name_sitesPage_publishedDdl"),
					"selecting value from published ddl", "No");
			Thread.sleep(1500);
			driver.findElement(
					By.xpath("html/body/div[2]/div/div[3]/div/form/div[2]/fieldset/table/tbody/tr[2]/td[6]/button"))
					.click();
			int countOfRecordsOnTheGrid = driver
					.findElements(By
							.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_sitePage_searchGridTr")))
					.size();
			Assert.assertTrue(countOfRecordsOnTheGrid == 1, "Records are available in the grid------->");

		} catch (Exception e) {
			throw new java.lang.RuntimeException(e);
		} finally {
			ByXpath.Click_Using_Xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboarPage"),
					"Clicking on dashbarod menu");
		}
	}

	@Test(priority = 5, enabled = true, description = "Operations - site >> 1. Select 'Yes' from Published Dropdown >> All the published sites should be displayed in table")
	public static void tc_005() throws IOException, InterruptedException {
		try {

			Thread.sleep(2000);
			Actions action = new Actions(driver);
			WebElement operationsMenu = driver.findElement(By
					.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboardPage_OperationsMenu")));
			action.moveToElement(operationsMenu).build().perform();
			Thread.sleep(2000);
			ByXpath.Click_Using_Xpath(
					ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboardPage_Operations_SitesSubMenu"),
					"clicking on sites sub menu under operations menu");
			ByName.Dropdown_Select_Using_ByVisibleText(
					ReadDataFromPropertiesFile.readProperty_CommonProps("name_sitesPage_publishedDdl"),
					"selecting value from published ddl", "Yes");
			int countOfTotalRecordsInGrid = driver
					.findElements(By
							.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_sitePage_searchGridTr")))
					.size();
			int countOfRecordsWithPublishedStatus = driver.findElements(By.xpath(ReadDataFromPropertiesFile
					.readProperty_CommonProps("xpath_sitePage_searchGridWithPublishedStatus"))).size();
			Assert.assertTrue(countOfTotalRecordsInGrid - 1 == countOfRecordsWithPublishedStatus,
					"All records are not published----->");
		} catch (Exception e) {
			throw new java.lang.RuntimeException(e);
		} finally {
			ByXpath.Click_Using_Xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboarPage"),
					"Clicking on dashbarod menu");
		}
	}

	@Test(priority = 6, enabled = true, description = "Operations - site >> 1. Click on Edit Button >> A warning message 'Please select an item to edit' should displayed on top of Search Section")
	public static void tc_006() throws IOException, InterruptedException {
		try {

			Thread.sleep(2000);
			Actions action = new Actions(driver);
			WebElement operationsMenu = driver.findElement(By
					.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboardPage_OperationsMenu")));
			action.moveToElement(operationsMenu).build().perform();
			Thread.sleep(2000);
			ByXpath.Click_Using_Xpath(
					ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboardPage_Operations_SitesSubMenu"),
					"clicking on sites sub menu under operations menu");
			ByXpath.Click_Using_Xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_sitesPage_editButton"),
					"clicking on edit button");
			String actualWarningMessage = ByXpath.GetText_Using_Xpath(
					ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_warningMessageLable"),
					"getting warning message");
			Assert.assertTrue(actualWarningMessage.equals("WARNING: Please select an item to edit"),
					"No warning message is ther or message is different than expected");
		} catch (Exception e) {
			throw new java.lang.RuntimeException(e);
		} finally {
			ByXpath.Click_Using_Xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboarPage"),
					"Clicking on dashbarod menu---->");
		}
	}

	@Test(priority = 7, enabled = true, description = "Operations - site >> 1. Select any row from table 2. Click on Edit Button >> User should redirect on Site Edit page")
	public static void tc_007() throws IOException, InterruptedException {
		try {

			Thread.sleep(2000);
			Actions action = new Actions(driver);
			WebElement operationsMenu = driver.findElement(By
					.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboardPage_OperationsMenu")));
			action.moveToElement(operationsMenu).build().perform();
			Thread.sleep(2000);
			ByXpath.Click_Using_Xpath(
					ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboardPage_Operations_SitesSubMenu"),
					"clicking on sites sub menu under operations menu");
			ByXpath.Click_Using_Xpath(
					ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_sitePagesearchGridFirstRowCheckBox"),
					"clicking on first record's checkbox");
			ByXpath.Click_Using_Xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_sitesPage_editButton"),
					"clicking on edit button");
			String editRecordPageHeading = ByXpath.GetText_Using_Xpath(
					ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_sitePage_editRecordPage"),
					"getting edit record page heading");
			Assert.assertTrue(editRecordPageHeading.equals("Site Edit"),
					"User is not on edit mode or heading changed.");
		} catch (Exception e) {
			throw new java.lang.RuntimeException(e);
		} finally {
			ByXpath.Click_Using_Xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboarPage"),
					"Clicking on dashbarod menu");
		}

	}

	@Test(priority = 8, enabled = true, description = "Operations - roster - calendar view")
	public static void tc_008() throws IOException, InterruptedException {
		try {

			Thread.sleep(2000);
			Actions ac = new Actions(driver);
			ac.moveToElement(
					driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathOpertion"))))
					.build().perform();
			Thread.sleep(1500);

			ac.moveToElement(
					driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathRoster"))))
					.build().perform();

			Thread.sleep(1500);

			ByXpath.Click_Using_Xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathCal"),
					"click Staff type");
			Thread.sleep(1500);

			ByXpath.Click_Using_Xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathAddstaf"),
					"click Staff type");

			ByXpath.Click_Using_Xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathStaf"),
					"click Staff type");
			Select sel = new Select(
					driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathDropShif"))));

			sel.selectByVisibleText("Day");
			// select assign type
			sel = new Select(driver
					.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathDropAssisgn"))));
			sel.selectByVisibleText("Relief");

			driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathClick"))).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathStafName"))).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathSave"))).click();
			Thread.sleep(1500);

			Assert.assertTrue(
					driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathSucsMsg")))
							.getText().contains("Success"),
					"Not found");
		} catch (Exception e) {
			throw new java.lang.RuntimeException(e);
		} finally {
			ByXpath.Click_Using_Xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboarPage"),
					"Clicking on dashbarod menu");
		}

	}

	@Test(priority = 9, enabled = true, description = "Operations - site>>Click on any name in the grid")
	public void tc_009() throws InterruptedException, IOException {
		try {

			Thread.sleep(2000);
			Actions ac = new Actions(driver);
			ac.moveToElement(
					driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathOpertion"))))
					.build().perform();
			Thread.sleep(1500);

			// click on site
			driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathSite"))).click();
			Thread.sleep(1500);
			driver.findElement(
					By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathSiteGrid_facebooktext")))
					.click();
			Thread.sleep(1500);
			Assert.assertTrue(
					driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathSiteRecord")))
							.getText().contains("Site Edit"),
					"Not found");

		} catch (Exception e) {
			throw new java.lang.RuntimeException(e);
		} finally {
			ByXpath.Click_Using_Xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboarPage"),
					"Clicking on dashbarod menu");
		}

	}

	@Test(priority = 10, enabled = true, description = "Operations - site>>Click on any name in the grid")
	public void tc_010() throws InterruptedException, IOException {
		try {

			Thread.sleep(2000);
			Actions ac = new Actions(driver);
			ac.moveToElement(
					driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathOpertion"))))
					.build().perform();
			Thread.sleep(1500);

			// click on site
			driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathSite"))).click();
			Thread.sleep(1500);
			driver.findElement(
					By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathSiteGrid_facebooktext")))
					.click();
			Thread.sleep(1500);
			Assert.assertTrue(
					driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathSiteDetail")))
							.getText().contains("Site Details"),
					"Not found");
		} catch (Exception e) {
			throw new java.lang.RuntimeException(e);
		} finally {
			ByXpath.Click_Using_Xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboarPage"),
					"Clicking on dashbarod menu");
		}

	}

	@Test(priority = 11, enabled = true, description = "Operations - site>>Click on any code in the grid")
	public void tc_011() throws InterruptedException, IOException {
		try {

			Thread.sleep(2000);
			Actions ac = new Actions(driver);
			ac.moveToElement(
					driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathOpertion"))))
					.build().perform();
			Thread.sleep(1500);

			// click on site
			driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathSite"))).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathSiteGridFb")))
					.click();
			Thread.sleep(1500);
			Assert.assertTrue(
					driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathSiteDetail")))
							.getText().contains("Site Details"),
					"Not found");

		} catch (Exception e) {
			throw new java.lang.RuntimeException(e);
		} finally {
			ByXpath.Click_Using_Xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboarPage"),
					"Clicking on dashbarod menu");
		}

	}

	@Test(priority = 12, enabled = true, description = "Operations - site>>Click on header checkbox in the grid")
	public void tc12() throws InterruptedException, IOException {
		try {

			Thread.sleep(2000);
			Actions ac = new Actions(driver);
			Thread.sleep(1500);
			ac.moveToElement(driver.findElement(By.xpath(".//*[@id='smoothmenu']/ul/li[3]/a"))).build().perform();
			Thread.sleep(1500);
			driver.findElement(By.xpath(".//*[@id='smoothmenu']/ul/li[3]/ul/li[1]/a")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/form/div[2]/table/tbody/tr[1]/th[1]/input"))
					.click();
			Thread.sleep(1500);
			List<WebElement> ele = driver.findElements(By.xpath("//*[contains(@name, 'checkid')]"));
			int x = 0;
			for (WebElement e : ele) {
				if (e.isSelected()) {
					x = x + 1;
				} else
					Assert.fail();
				if (x == 2)
					Assert.assertEquals(true, true);
			}
		} catch (Exception e) {
			throw new java.lang.RuntimeException(e);
		} finally {

			ByXpath.Click_Using_Xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboarPage"),
					"Clicking on dashbarod menu");
		}
	}

	@Test(priority = 13, enabled = true, description = "Operations - site>>Go to sites page")
	public void tc_013() throws InterruptedException, IOException {
		try {

			Thread.sleep(2000);
			Actions ac = new Actions(driver);
			ac.moveToElement(
					driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathOpertion"))))
					.build().perform();
			Thread.sleep(1500);

			// click on site
			driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathSite"))).click();
			Thread.sleep(1500);
			Select sel = new Select(
					driver.findElement(By.xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpathDropdown"))));

			String value = sel.getFirstSelectedOption().getText();
			Assert.assertEquals(value, "Yes");
		} catch (Exception e) {
			throw new java.lang.RuntimeException(e);
		} finally {
			ByXpath.Click_Using_Xpath(ReadDataFromPropertiesFile.readProperty_CommonProps("xpath_dashboarPage"),
					"Clicking on dashbarod menu");
		}
	}
}