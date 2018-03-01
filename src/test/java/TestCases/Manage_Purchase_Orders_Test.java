package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.Manage_Purchase_Orders;
import TestBase.TestBase;

public class Manage_Purchase_Orders_Test extends TestBase {

	LoginPage loginpage;

	HomePage homepage;

	Manage_Purchase_Orders MPO;

	@BeforeMethod

	public void setup() throws InterruptedException {

		initialization();

		loginpage = new LoginPage();

		homepage = new HomePage();

		MPO = new Manage_Purchase_Orders();

		homepage = loginpage.login(prop.getProperty("un"), prop.getProperty("ps"));



		homepage.ClickonManagePurchaseOrder();

	}



	@Test(dependsOnMethods = { "TestCases.Reverse_PO_Page_Test.To_Verify_Create_RPO_With_Closed_Status" })

	public void To_Verify_PO_Closed_Status_AND_LOGs() throws InterruptedException {

		String msg = MPO.Manage_PO_Closed_Status();

		Assert.assertEquals(msg, "Closed");

	}

	@Test(enabled = true, dependsOnMethods = {
			"TestCases.Reverse_PO_Page_Test.To_Verify_Create_RPO_with_Partial_Status" })

	public void To_Verify_PO_Partial_Status_AND_LOGs() throws InterruptedException {

		String msg = MPO.Manage_PO_Partial_Status();

		Assert.assertEquals(msg, "Partial Delivery");

	}

	@AfterMethod

	public void down() {

		driver.quit();
	}


}

