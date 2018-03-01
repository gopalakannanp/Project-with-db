package TestCases;

import java.io.IOException;
import java.util.ArrayList;

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
import Pages.Reverse_PO_Page;
import TestBase.TestBase;
import Util.TestUtil;

public class Create_Reverse_PO_with_Partial_Status extends TestBase {

	public ExtentReports extent;
	public ExtentTest extentTest;

	Create_Reverse_PO_with_Partial_Status() {

		super();
	}

	Reverse_PO_Page RPO;

	LoginPage loginpage;

	HomePage homepage;

	static TestUtil util = new TestUtil();

	String sheetName1 = "partial delivery";

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

		RPO = new Reverse_PO_Page();

		homepage = loginpage.login(prop.getProperty("un"), prop.getProperty("ps"));

		homepage.ClickOnCreateReversePurchaseOrder();

	}

	@DataProvider
	public Object[][] getCRMTestData1() {
		Object data[][] = TestUtil.getTestData(sheetName1);
		return data;
	}

	@Test(dataProvider = "getCRMTestData1", enabled = true, priority = 1)

	public void To_Verify_Create_RPO_with_Partial_Status(String Order, String rec, String Barcode1, String Barcode2,
			String Barcode3, String Barcode4, String Barcode5, String Barcode6, String Barcode7, String serial1,
			String serial2, String serial3, String serial4, String serial5) throws InterruptedException {

		extentTest = extent.startTest("To_Verify_Create_RPO_With_Partial_Status");

		ArrayList<String> msg = RPO.Create_PO_Partial(Order, rec, Barcode1, Barcode2, Barcode3, Barcode4, Barcode5,
				Barcode6, Barcode7, serial1, serial2, serial3, serial4, serial5);

		// Assert.assertEquals(msg, msg1);

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
