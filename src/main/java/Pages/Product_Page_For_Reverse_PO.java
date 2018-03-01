package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class Product_Page_For_Reverse_PO extends TestBase {

	@FindBy(id = "keyword")
	@CacheLookup
	WebElement Part_search_textbox;

	@FindBy(id = "submit_btn")
	@CacheLookup
	WebElement Submit_btn;

	@FindBy(xpath = "//table[@id='jqGrid01']//i[@class='icon-edit']")
	@CacheLookup
	WebElement Edit_Product_Page_btn;

	@FindBy(xpath = "//*[@id='stock']")
	@CacheLookup
	WebElement Stock_btn;

	@FindBy(xpath = "//*[@id='showmore']/i")
	@CacheLookup
	WebElement Adjustment_log_btn;

	@FindBy(xpath = "//div[@id='part_log_details']/p[1]")
	@CacheLookup
	WebElement Adjustment_log_msg;

	public Product_Page_For_Reverse_PO() {

		PageFactory.initElements(driver, this);

	}

	public void Verify_Products_stock_logs(String partnumber) throws InterruptedException {

		Part_search_textbox.sendKeys(partnumber);

		Submit_btn.click();

		Thread.sleep(2000);

		waitUntilElementClickable(Edit_Product_Page_btn, 20);

		String Current_stock = Stock_btn.getAttribute("value");

		System.out.println("Quantity in Stock         " + Current_stock);

		Thread.sleep(2000);

		Adjustment_log_btn.click();

		String logmsg = Adjustment_log_msg.getText();

		System.out.println("Inventory Adjustment Log  " + logmsg);

	}


}
