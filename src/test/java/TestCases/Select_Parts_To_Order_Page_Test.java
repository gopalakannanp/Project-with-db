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
import Pages.Select_Parts_To_Order_Page;
import TestBase.TestBase;
import Util.TestUtil;

public class Select_Parts_To_Order_Page_Test extends TestBase {
	
	public ExtentReports extent;

	public ExtentTest extentTest;

	HomePage homepage;

	LoginPage loginpage;

	static TestUtil util = new TestUtil();

	Select_Parts_To_Order_Page  selectorder;
	
	public Select_Parts_To_Order_Page_Test(){
		
		super();
	}
	
	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);

	}

	@BeforeMethod
	
	public void setup() throws InterruptedException {
		
		initialization();
		
		selectorder= new Select_Parts_To_Order_Page();
		
		loginpage=new LoginPage();
		
		homepage= new HomePage();
		
		homepage=loginpage.login(prop.getProperty("un"), prop.getProperty("ps"));
		
		homepage.ClickonSelectPartsToOrderPage();
	}
	
	@Test(enabled = true, priority = 1)
	
	public void To_Verify_Create_PO() throws InterruptedException {

		extentTest = extent.startTest("To_Verify_Create_PO");

		String Verify = selectorder.Create_PO();

		Assert.assertEquals(Verify, "Part has been added to shopping cart successfully");


	}

	@Test(enabled = true)

	public void To_Verify_ADD_TO_CART() throws InterruptedException {

		extentTest = extent.startTest("To_Verify_ADD_TO_CART");

		String Verify = selectorder.addtocart();

		Assert.assertEquals(Verify, "Parts added to Cart successfully");


	}

	@Test(enabled = true)

	public void To_Verify_Quick_ADD() throws InterruptedException {
		
		extentTest = extent.startTest("To_Verify_Quick_ADD");

		selectorder.quickadd();

	}
	 
	@AfterTest

	public void endReport() {
		extent.flush();
		extent.close();
	}

	@AfterMethod
	
	public void close(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName());

			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable());

			String screenshotPath = TestUtil.getScreenshot(driver, result.getName());

			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));

		} else if (result.getStatus() == ITestResult.SKIP) {

			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}

		extent.endTest(extentTest);

		driver.quit();
	}

}
