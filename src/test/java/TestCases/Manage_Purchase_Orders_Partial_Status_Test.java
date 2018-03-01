package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.Manage_Purchase_Orders;
import TestBase.TestBase;
import Util.TestUtil;


public class Manage_Purchase_Orders_Partial_Status_Test extends TestBase {

	public ExtentReports extent;
	public ExtentTest extentTest;

	LoginPage loginpage;

	HomePage homepage;

	Manage_Purchase_Orders MPO;

	public Manage_Purchase_Orders_Partial_Status_Test() {

		super();
	}

	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);

	}

	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();

	}

	@BeforeMethod

	public void setup() throws InterruptedException {

		initialization();

		loginpage = new LoginPage();

		homepage = new HomePage();

		MPO = new Manage_Purchase_Orders();

		homepage = loginpage.login(prop.getProperty("un"), prop.getProperty("ps"));

		homepage.ClickonManagePurchaseOrder();

	}

	@Test(enabled = true, priority = 2)

	public void To_Verify_PO_Partial_Status_AND_LOGs() throws InterruptedException {

		extentTest = extent.startTest("To_Verify_PO_Partial_Status_AND_LOGs");
		String msg = MPO.Manage_PO_Partial_Status();

		Assert.assertEquals(msg, "Partial Delivery");

	}

	@AfterMethod(enabled = true)

	public void Closebrowser(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in
																							// extent report

			String screenshotPath = TestUtil.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); // to add screenshot in extent
																							// report
			// extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
			// //to add screencast/video in extent report

		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}

		extent.endTest(extentTest); // ending test and ends the current test and prepare to create html report

		driver.quit();

	}


}
