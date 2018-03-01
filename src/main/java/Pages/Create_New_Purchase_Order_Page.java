package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class Create_New_Purchase_Order_Page extends TestBase {

	@FindBy(id = "vendor_id")
	@CacheLookup
	WebElement vendor_name_dropdown;

	@FindBy(xpath = "//*[@id='create_new_po']/div[2]/div[1]/div[2]/div/span/span/div/div/a")
	@CacheLookup
	WebElement Go_btn;

	@FindBy(xpath = "//div//input[@id='updated_cost_6779142']")
	@CacheLookup
	WebElement Cost_field;

	@FindBy(id = "updated_extended_cost_6779142")
	@CacheLookup
	WebElement Ext_Cost_field;

	@FindBy(id = "set_discount")
	@CacheLookup
	WebElement Set_discount_btn;

	@FindBy(id = "setdiscount")
	@CacheLookup
	WebElement discount_text;

	@FindBy(id = "sub_btn")
	@CacheLookup
	WebElement Update;

	@FindBy(xpath = "//*[@id='6779142']/td[16]/a[1]/i")
	@CacheLookup
	WebElement Edit_btn;

	@FindBy(id = "popart_comments")
	@CacheLookup
	WebElement Comments;

	@FindBy(id = "comment_btn")
	@CacheLookup
	WebElement Add_btn;

	@FindBy(id = "generate_po_btn")
	@CacheLookup
	WebElement Create_Po_btn;

	@FindBy(id = "account_number")
	@CacheLookup
	WebElement Acc_no;

	@FindBy(id = "po_shipping_method_id")
	@CacheLookup
	WebElement Ship_via_dropdown;

	@FindBy(id = "po_payment_method_id")
	@CacheLookup
	WebElement Payment_method;

	@FindBy(id = "vendor_email")
	@CacheLookup
	WebElement Vendor_email;

	@FindBy(xpath = "//div[@class='switch-on switch-animate']")
	@CacheLookup
	WebElement email_PO_OFF;

	@FindBy(id = "generate_order_btn")
	@CacheLookup
	WebElement Generate_PO;

	public Create_New_Purchase_Order_Page() {

		PageFactory.initElements(driver, this);

	}

	public void Create_New_PO() throws InterruptedException {

		selectDropdown(vendor_name_dropdown, "ATEST");

		Thread.sleep(2000);
		Go_btn.click();

		// String current_cost = Cost_field.getAttribute("value");

		// System.out.println("Current cost " + current_cost);
		/*
		 * Thread.sleep(2000); Cost_field.clear();
		 * 
		 * Thread.sleep(1000); // driver.switchTo().alert().accept();
		 * 
		 * Cost_field.sendKeys("70000"); Thread.sleep(2000);
		 * 
		 * // driver.switchTo().alert().accept();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * 
		 * // driver.switchTo().alert().accept();
		 * 
		 * 
		 * // driver.switchTo().alert().accept();
		 * 
		 * 
		 * Set_discount_btn.click();
		 * 
		 * 
		 * Thread.sleep(2000);
		 * 
		 * discount_text.clear();
		 * 
		 * Thread.sleep(1000);
		 * 
		 * discount_text.sendKeys("5"); Thread.sleep(2000); Update.click();
		 * 
		 * 
		 * String msg = Ext_Cost_field.getAttribute("title");
		 * 
		 * System.out.println(msg);
		 * 
		 * acceptpopup(); Thread.sleep(2000); String updatedmsg =
		 * driver.switchTo().alert().getText();
		 * 
		 * System.out.println(updatedmsg); Thread.sleep(2000);
		 * System.out.println(current_cost); Thread.sleep(2000);
		 * Set_discount_btn.click(); Thread.sleep(2000); discount_text.sendKeys("10");
		 * Thread.sleep(2000); Update.click();
		 * 
		 */

		Thread.sleep(3000);

		waitUntilElementClickable(Create_Po_btn, 60);
		// Create_Po_btn.click();

		Thread.sleep(1000);

		Acc_no.sendKeys("1452");

		selectDropdown(Ship_via_dropdown, "Best Way");

		selectDropdown(Payment_method, "Credit Card");
		Thread.sleep(1000);

		// email_PO_OFF.click();
		Vendor_email.clear();

		Vendor_email.sendKeys("kannangopal52@yahoo.com");

		Generate_PO.click();

	}



}
