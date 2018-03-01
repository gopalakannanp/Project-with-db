package TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Create_New_Purchase_Order_Page;
import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;

public class Create_New_Purchase_Order_Page_Test extends TestBase {

	HomePage homepage;

	LoginPage loginpage;

	Create_New_Purchase_Order_Page CNPO;

	Create_New_Purchase_Order_Page_Test() {

		super();
	}

	@BeforeMethod

	public void setup() throws InterruptedException {

		initialization();

		loginpage = new LoginPage();

		homepage = new HomePage();

		CNPO = new Create_New_Purchase_Order_Page();

		homepage = loginpage.login(prop.getProperty("un"), prop.getProperty("ps"));

		homepage.ClickonCreateNewPurchaseOrder();

	}

	@Test

	public void test() throws InterruptedException {

		CNPO.Create_New_PO();
	}

}
