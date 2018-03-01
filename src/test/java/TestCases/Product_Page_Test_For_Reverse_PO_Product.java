package TestCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.Product_Page_For_Reverse_PO;
import TestBase.TestBase;
import Util.TestUtil;

public class Product_Page_Test_For_Reverse_PO_Product extends TestBase {

	public ExtentReports extent;
	public ExtentTest extentTest;

	LoginPage loginpage;

	HomePage homepage;

	static TestUtil util = new TestUtil();

	Product_Page_For_Reverse_PO productpage;

	String sheetName = "Testdata";

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

		productpage = new Product_Page_For_Reverse_PO();

		homepage = loginpage.login(prop.getProperty("un"), prop.getProperty("ps"));

		homepage.clickonproductpage();

	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	/*
	 * @Test(dataProvider = "getCRMTestData", dependsOnMethods = {
	 * "TestCases.Manage_Purchase_Orders_Test.To_Verify_PO_Closed_Status_AND_LOGs"
	 * })
	 */

	@Test(dataProvider = "getCRMTestData", dependsOnMethods = {
			"TestCases.Manage_Purchase_Orders_Test.To_Verify_PO_Partial_Status_AND_LOGs" })

	public void To_verify_Part_stock_Logs(String partnumber) throws InterruptedException {

		extentTest = extent.startTest("test");

		productpage.Verify_Products_stock_logs(partnumber);

	}

	@AfterMethod

	public void down(ITestResult result) throws IOException {

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
