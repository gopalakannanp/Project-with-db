package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class Manage_Purchase_Orders extends TestBase {

	@FindBy(xpath = "//*[@id='search_btn']")

	WebElement Search_btn;

	@FindBy(xpath = "//div[@class='switch switch-mini switch-default has-switch']/div//label[@class='switch-mini']")

	WebElement List_Manual_PO_btn;

	@FindBy(id = "po_status")

	WebElement PO_Status_dropdown;

	@FindBy(xpath = "//table[@id='jqGrid01']/tbody/tr[2]/td[2]")

	WebElement Status_text;

	@FindBy(xpath = "//table[@id='jqGrid01']/tbody/tr[2]/td[1]")

	WebElement PO_number;


	@FindBy(xpath = "//table[@id='jqGrid01']/tbody/tr[2]/td/a[@title='Review'] ")

	WebElement Edit_Btn;

	@FindBy(xpath = "//a[@id='showmore']/i")

	WebElement Log_btn;

	@FindBy(xpath = "//div[@id='part_log_details']/p")

	WebElement Log_msg;

	public Manage_Purchase_Orders() {

		PageFactory.initElements(driver, this);

	}

	public String Manage_PO_Closed_Status() throws InterruptedException {

		Thread.sleep(2000);

		// List_Manual_PO_btn.click();

		selectDropdown(PO_Status_dropdown, "Closed");

		waitUntilElementClickable(Search_btn, 30);

		// String text =
		// driver.findElement(By.xpath("//table[@id='jqGrid01']/tbody/tr[2]/td[2]")).getText();

		String text = driver.findElement(By.xpath("//div[@id='main_grid']//tbody/tr[2]/td[2]")).getText();

		System.out.println("Status---------" + text);

		String po_no = PO_number.getAttribute("title");

		System.out.println("Purchase order number-------" + po_no);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//table[@id='jqGrid01']/tbody/tr[2]/td/a[@title='Review']")).click();

		// part_no_click.click();

		Thread.sleep(3000);

		waitUntilElementClickable(Log_btn, 60);

		List<WebElement> msg = driver.findElements(By.xpath("//div[@id='part_log_details']/p"));

		for (WebElement logmsg : msg) {

			System.out.println(logmsg.getText());

		}


		return text;
	}

	public String Manage_PO_Partial_Status() throws InterruptedException {

		Thread.sleep(3000);

		// waitUntilElementClickable(List_Manual_PO_btn, 60);

		selectDropdown(PO_Status_dropdown, "Partial Delivery");

		waitUntilElementClickable(Search_btn, 30);

		String text = Status_text.getText();

		System.out.println("Status---------" + text);

		String po_no = PO_number.getAttribute("title");

		System.out.println("Purchase order number-------" + po_no);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//table[@id='jqGrid01']/tbody/tr[2]/td/a[@title='Review']")).click();

		Thread.sleep(3000);

		waitUntilElementClickable(Log_btn, 60);

		List<WebElement> msg = driver.findElements(By.xpath("//div[@id='part_log_details']/p"));

		for (WebElement logmsg : msg) {

			System.out.println(logmsg.getText());

		}

		return text;

	}

}
