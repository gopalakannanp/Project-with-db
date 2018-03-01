package TestCases;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
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

public class Reverse_PO_Page_Test extends TestBase {

	public ExtentReports extent;
	public ExtentTest extentTest;

	Reverse_PO_Page RPO;

	LoginPage loginpage;

	HomePage homepage;

	static TestUtil util = new TestUtil();

	String sheetName = "Sheet1";

	String sheetName1 = "partial delivery";

	String sheetName2 = "Sheet2";

	public Reverse_PO_Page_Test() {

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

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@DataProvider
	public Object[][] getCRMTestData1() {
		Object data[][] = TestUtil.getTestData(sheetName1);
		return data;
	}

	@DataProvider
	public Object[][] getCRMTestData2() {

		Object data[][] = TestUtil.getTestData(sheetName2);

		return data;
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

	@Test(dataProvider = "getCRMTestData", enabled = true)

	public void To_Verify_Create_RPO_With_Closed_Status(String Order, String rec, String comm, String serial1,
			String serial2, String serial3, String serial4, String serial5, String msg1) throws InterruptedException {

		extentTest = extent.startTest("To_Verify_Create_RPO_With_Closed_Status");

		ArrayList<String> msg = RPO.Create_PO(Order, rec, comm, serial1, serial2, serial3, serial4, serial5);

		String verify = msg.get(0);

		String messs = msg.get(1);

		Assert.assertEquals(messs, "Purchase Order " + verify + " created successfully!");


	}

	@Test(dataProvider = "getCRMTestData1", enabled = true)

	public void To_Verify_Create_RPO_with_Partial_Status(String Order, String rec, String Barcode1, String Barcode2,
			String Barcode3, String Barcode4, String Barcode5, String Barcode6, String Barcode7, String serial1,
			String serial2, String serial3, String serial4, String serial5)
			throws InterruptedException {

		extentTest = extent.startTest("To_Verify_Create_RPO_with_Partial_Status");

		ArrayList<String> msg = RPO.Create_PO_Partial(Order, rec, Barcode1, Barcode2, Barcode3, Barcode4, Barcode5,
				Barcode6,
				Barcode7, serial1, serial2, serial3, serial4, serial5);

		// Assert.assertEquals(msg, msg1);

	}

	@Test(enabled = false, dataProvider = "getCRMTestData2")

	public void To_Verify_Change_Vendor_AND_PARTDOEST_EXIT(String partno, String Descrip, String cost1, String MSRP1,
			String RETAIL1, String Category, String manufacturer) throws InterruptedException {

		extentTest = extent.startTest("To_Verify_Change_Vendor_AND_PARTDOEST_EXIT(");

		RPO.PartDoestnotexitpopandvendorchanges(partno, Descrip, cost1, MSRP1, RETAIL1, Category, manufacturer);

	}

	@AfterMethod(enabled = true)
	  
	  public void Closebrowser(ITestResult result) throws IOException {
	  
	  if (result.getStatus() == ITestResult.FAILURE) {
	  extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); //
			extentTest.log(LogStatus.FAIL,
	  "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in
	  // extent report
	  
	  String screenshotPath = TestUtil.getScreenshot(driver, result.getName());
	  extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));

	  
	  } else if (result.getStatus() == ITestResult.SKIP) {
	  extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName()); }
	  else if (result.getStatus() == ITestResult.SUCCESS) {
	  extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
	  
	  }
	  
	  extent.endTest(extentTest); // ending test and ends the current test and
	  

	  driver.quit();
	  
	  }

}
