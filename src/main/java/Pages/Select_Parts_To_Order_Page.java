package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class Select_Parts_To_Order_Page extends TestBase {

	@FindBy(xpath = "//button[@id='select_part_search_btn']")
	@CacheLookup
	WebElement Searchbtn;

	@FindBy(xpath = "//*[@id='5177729']/td[2]/a[2]/i")
	@CacheLookup
	WebElement CreatePObtn;

	@FindBy(xpath = "//*[@id='qty_to_order']")
	@CacheLookup
	WebElement QtytoOrder;

	@FindBy(xpath = "//*[@id='add_tocart_btn']")
	@CacheLookup
	WebElement Orderitembtn;

	@FindBy(xpath = "//*[@id='wrapper']/div[3]/div[3]/div/div")
	@CacheLookup
	WebElement alertsuccessmsg;

	@FindBy(id = "vendor_id")
	@CacheLookup
	WebElement vendornamedropdown;

	@FindBy(id = "cb_jqGrid01")
	@CacheLookup
	WebElement checkbox;

	@FindBy(id = "submit_btn")
	@CacheLookup
	WebElement Addtocartbtn;

	@FindBy(xpath = "//*[@id='wrapper']/div[3]/div[3]/div/div")
	@CacheLookup
	WebElement Successmsg;

	@FindBy(xpath = "	//*[@id='5177730']/td[2]/a[3]/i")
	@CacheLookup
	WebElement Quickorderbtn;

	@FindBy(id = "qty_ordered")
	@CacheLookup
	WebElement QuickorderQty;

	@FindBy(id = "quick_order_item_btn")
	@CacheLookup
	WebElement Quick_Order_item_btn;

	public Select_Parts_To_Order_Page() {

		PageFactory.initElements(driver, this);
	}

	public String Create_PO() throws InterruptedException {

		Thread.sleep(3000);

		Searchbtn.click();

		CreatePObtn.click();

		QtytoOrder.clear();

		QtytoOrder.sendKeys("2");

		Thread.sleep(1000);

		waitUntilElementClickable(Orderitembtn, 10);

		String msg = alertsuccessmsg.getText();

		msg = (msg.substring(1)).trim();

		System.out.println(msg);

		return msg;

	}

	public String addtocart() throws InterruptedException {

		selectDropdown(vendornamedropdown, "SAMSUNGMOBILE");

		Thread.sleep(2000);

		Searchbtn.click();

		Thread.sleep(2000);

		waitUntilElementClickable(checkbox, 30);

		Addtocartbtn.click();

		acceptpopup();

		String msg = Successmsg.getText();

		msg = (msg.substring(1)).trim();

		System.out.println("Message:" + msg);

		return msg;

	}

	public void quickadd() throws InterruptedException {

		selectDropdown(vendornamedropdown, "SAIRAM1");

		Thread.sleep(2000);

		Searchbtn.click();

		Thread.sleep(2000);

		Quickorderbtn.click();

		QuickorderQty.sendKeys("2");

		Quick_Order_item_btn.click();

	}

}
