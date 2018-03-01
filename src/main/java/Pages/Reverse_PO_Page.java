package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class Reverse_PO_Page extends TestBase {

	@FindBy(id = "search_vendor_chosen")
	@CacheLookup
	WebElement Vendordropdown;

	@FindBy(xpath = "//*[@id='search_vendor_chosen']/div/div/input")
	@CacheLookup
	WebElement Innertext;

	@FindBy(xpath = "//*[@id='search_vendor_chosen']/div/ul/li[35]") // *[@id='search_vendor_chosen']/div/ul/li
	@CacheLookup
	WebElement Autocompletext;

	@FindBy(xpath = "//div[@class='chosen-search']")
	@CacheLookup
	WebElement dropdowntextfield;

	@FindBy(id = "search_number")
	@CacheLookup
	WebElement Description_text_field;

	@FindBy(xpath = "//*[@id='search_vendor_chosen']/div/ul/li")
	@CacheLookup
	WebElement Vendorchoosetext;

	@FindBy(id = "search_part_btn")
	@CacheLookup
	WebElement searchpart;

	@FindBy(xpath = "//div[@class='btn-toolbar']/button[@id='submit_btn']")
	@CacheLookup
	WebElement searchbtn;

	@FindBy(xpath = "//input[@id='cb_jqGrid01']")
	@CacheLookup
	WebElement checkbox_selectall;

	@FindBy(xpath = "//div[@class='btn-toolbar']//button[contains(text(),'Add Selected to PO List')]")
	@CacheLookup
	WebElement Addselectedtopobtn;

	@FindBy(xpath = "/html/body/div[14]/ul/li")

	WebElement autofillclick;

	@FindBy(xpath = "//div[contains(text(),'Airfiills')]/following-sibling::div/input[@class='quantity inputs']")
	@CacheLookup
	WebElement Order_Qty1;

	@FindBy(xpath = "//div[contains(text(),'suits')]/following-sibling::div/input[@class='quantity inputs']")
	@CacheLookup
	WebElement Order_Qty2;

	@FindBy(xpath = "//div[contains(text(),'DVD')]/following-sibling::div/input[@class='quantity inputs']")
	@CacheLookup
	WebElement Order_Qty3;

	@FindBy(xpath = "//div[contains(text(),'Camera  Primary Description')]/following-sibling::div/input[@class='quantity inputs']")
	@CacheLookup
	WebElement Order_Qty4;

	@FindBy(xpath = "//div[contains(text(),'charters')]/following-sibling::div/input[@class='quantity inputs']")
	@CacheLookup
	WebElement Order_Qty5;

	@FindBy(xpath = "//div[contains(text(),'Computers')]/following-sibling::div/input[@class='quantity inputs']")
	@CacheLookup
	WebElement Order_Qty6;

	@FindBy(xpath = "//div[contains(text(),'mobile part check  Descriptions')]/following-sibling::div/input[@class='quantity inputs']")
	@CacheLookup
	WebElement Order_Qty7;

	@FindBy(xpath = "//div[contains(text(),'Airfiills')]/following-sibling::div/input[@class='quantity_received inputs']  ")
	@CacheLookup
	WebElement Receive_Qty1;

	@FindBy(xpath = "//div[contains(text(),'suits')]/following-sibling::div/input[@class='quantity_received inputs']")
	@CacheLookup
	WebElement Receive_Qty2;

	@FindBy(xpath = "//div[contains(text(),'DVD')]/following-sibling::div/input[@class='quantity_received inputs']  ")
	@CacheLookup
	WebElement Receive_Qty3;

	@FindBy(xpath = "//div[contains(text(),'Camera  Primary Description')]/following-sibling::div/input[@class='quantity_received inputs']")
	@CacheLookup
	WebElement Receive_Qty4;

	@FindBy(xpath = "//div[contains(text(),'charters')]/following-sibling::div/input[@class='quantity_received inputs'] ")
	@CacheLookup
	WebElement Receive_Qty5;

	@FindBy(xpath = "//div[contains(text(),'Computers')]/following-sibling::div/input[@class='quantity_received inputs']")
	@CacheLookup
	WebElement Receive_Qty6;

	@FindBy(xpath = "//div[contains(text(),'mobile part check  Descriptions')]/following-sibling::div/input[@class='quantity_received inputs']")
	@CacheLookup
	WebElement Receive_Qty7;

	@FindBy(xpath = "//div[@id='vcomment']/input")
	@CacheLookup
	WebElement commentfield;


	@FindBy(xpath = "//div[@class='rcvcreate']/button")
	@CacheLookup
	WebElement Receive_Goods_btn;

	@FindBy(xpath = "//div[@class='vendorinp']/input[@class='vendor_invoice']")
	@CacheLookup
	WebElement Vendorinvoice;

	@FindBy(xpath = "//div[@class='control-group']/p[@id='alert_msg_p']")
	@CacheLookup
	WebElement Alertmsg;

	@FindBy(xpath = "//div[@class='btn-toolbar']/button[@id='cancel_ok_btn']")
	@CacheLookup
	WebElement OK_btn;



	@FindBy(id = "mode1")

	WebElement Serial1;

	@FindBy(id = "mode2")

	WebElement Serial2;

	@FindBy(id = "mode3")

	WebElement Serial3;

	@FindBy(id = "mode4")

	WebElement Serial4;

	@FindBy(id = "mode5")

	WebElement Serial5;

	@FindBy(xpath = "//div[@id='po_serial_number']//button[contains(text(),'Save')]")

	WebElement Save_Btb;
	
	@FindBy(id = "serial_not_required")

	WebElement Serial_NOT_required_btn;

	@FindBy(xpath = "//div[@class='btn-toolbar']/button[contains(text(),'ADD')]")

	WebElement ADD;

	@FindBy(id = "primary_desc")

	WebElement Description;

	@FindBy(id = "cost")

	WebElement cost;

	@FindBy(id = "msrp")

	WebElement MSRP;

	@FindBy(id = "price1")

	WebElement Retailprice;

	@FindBy(id = "category_id")

	WebElement Categorydropdown;

	@FindBy(id = "manufacturer_id")

	WebElement manufacturerdropdown;

	@FindBy(id = "add_0")

	WebElement Quickadd;


	public Reverse_PO_Page() {

		PageFactory.initElements(driver, this);

	}


	public ArrayList<String> Create_PO(String Order, String rec, String comm, String serial1, String serial2,
			String serial3,
			String serial4, String serial5) throws InterruptedException {


		Thread.sleep(3000);

		waitUntilElementClickable(Vendordropdown, 40);

		WebElement get = Innertext;

		List<WebElement> option = get.findElements(By.xpath("//*[@id='search_vendor_chosen']/div/ul/li"));

		for (WebElement options : option) {

			String sta = options.getAttribute("innerHTML"); // Drop down click

			if (sta.contentEquals("VENDORSAMSUNG")) {

				options.click();
				break;
			}
		}

		Thread.sleep(2000);

		searchpart.click();

		Thread.sleep(2000);

		switchWindow();

		Thread.sleep(3000);

		waitUntilElementClickable(searchbtn, 30);

		Thread.sleep(2000);

		checkbox_selectall.click();

		Addselectedtopobtn.click();

		switchWindow();

		Thread.sleep(3000);

		for (int i = 1; i <= 4; i++) {

			Thread.sleep(3000);

			driver.findElement(By.xpath("//i[@id='serial_number_btn_" + i + "']")).click();

			Thread.sleep(3000);

			Serial1.sendKeys(serial1);

			Thread.sleep(3000);

			Serial2.sendKeys(serial2);

			Thread.sleep(3000);

			Serial3.sendKeys(serial3);

			Thread.sleep(3000);

			Serial4.sendKeys(serial4);

			Thread.sleep(3000);

			Serial5.sendKeys(serial5);

			waitUntilElementClickable(Save_Btb, 30);

		}


		String productsshowing = driver
				.findElement(By.xpath("//div[@id='mainscreen']/div/div[3]/form/div[2]/div[3]/div[4]/div")).getText();

		System.out.println("Current Product showing " + productsshowing);

		commentfield.sendKeys(comm);

		Vendorinvoice.sendKeys("151");

		waitUntilElementClickable(Receive_Goods_btn, 30);

		// Receive_Goods_btn.click();

		Thread.sleep(3000);

		acceptpopup();


		Thread.sleep(3000);

		String msg = driver.findElement(By.xpath("//div[@class='control-group po_alert_label']")).getText();

		System.out.println(msg);

		driver.findElement(By.xpath("//button[@id='cancel_btn'][2]")).click();

		String verify = driver.findElement(By.id("received_po_number")).getText();

		ArrayList<String> al = new ArrayList<String>();

		al.add(verify);

		al.add(msg);


		return al;

	}

	public ArrayList<String> Create_PO_Partial(String Order, String rec, String Barcode1, String Barcode2,
			String Barcode3,
			String Barcode4, String Barcode5, String Barcode6, String Barcode7, String serial1, String serial2,
			String serial3, String serial4, String serial5)
			throws InterruptedException {

		driver.get("https://ktds.diveshopx.com/1.9.0/reverse_purchase_order");

		Thread.sleep(3000);

		waitUntilElementClickable(Vendordropdown, 30);

		WebElement get = Innertext;

		get.sendKeys("VENDORSAMSUNG");

		Thread.sleep(1000);

		Vendorchoosetext.click();

		Description_text_field.sendKeys(Barcode1);

		autofillclick.click();

		Description_text_field.sendKeys(Barcode2);

		autofillclick.click();

		Description_text_field.sendKeys(Barcode3);

		autofillclick.click();

		Description_text_field.sendKeys(Barcode4);

		autofillclick.click();

		Description_text_field.sendKeys(Barcode5);

		autofillclick.click();

		Description_text_field.sendKeys(Barcode6);

		autofillclick.click();

		Description_text_field.sendKeys(Barcode7);

		autofillclick.click();

		// Order_Qty1.clear();

		// Order_Qty1.sendKeys(Order);

		Thread.sleep(2000);

		Receive_Qty1.clear();

		Receive_Qty1.sendKeys(rec);

		Receive_Qty2.clear();

		Thread.sleep(2000);
		Receive_Qty2.sendKeys(rec);

		Receive_Qty3.clear();

		Thread.sleep(2000);

		Receive_Qty3.sendKeys(rec);

		Receive_Qty4.clear();

		Thread.sleep(2000);

		Receive_Qty4.sendKeys(rec);



		for (int i = 1; i <= 4; i++) {

			Thread.sleep(3000);

			driver.findElement(By.xpath("//i[@id='serial_number_btn_" + i + "']")).click();

			Thread.sleep(3000);

			Serial1.sendKeys(serial1);

			Thread.sleep(3000);

			Serial2.sendKeys(serial2);

			Thread.sleep(3000);

			Serial3.sendKeys(serial3);

			Thread.sleep(3000);

			waitUntilElementClickable(Save_Btb, 30);

		}

		String productsshowing = driver
				.findElement(By.xpath("//div[@id='mainscreen']/div/div[3]/form/div[2]/div[3]/div[4]/div")).getText();

		System.out.println("Current Product showing " + productsshowing);

		Vendorinvoice.sendKeys("151");

		waitUntilElementClickable(Receive_Goods_btn, 30);

		// Receive_Goods_btn.click();

		Thread.sleep(3000);

		acceptpopup();


		Thread.sleep(3000);

		String msg = driver.findElement(By.xpath("//div[@class='control-group po_alert_label']")).getText();

		System.out.println(msg);

		driver.findElement(By.xpath("//button[@id='cancel_btn'][2]")).click();

		String verify = driver.findElement(By.id("received_po_number")).getText();

		ArrayList<String> al = new ArrayList<String>();

		al.add(verify);

		al.add(msg);


		return al;


	}

	public void PartDoestnotexitpopandvendorchanges(String partno, String Descrip, String cost1, String MSRP1,
			String RETAIL1, String Category, String manufacturer) throws InterruptedException {

		Thread.sleep(4000);

		waitUntilElementClickable(Vendordropdown, 30);

		WebElement get = Innertext;

		List<WebElement> option = get.findElements(By.xpath("//*[@id='search_vendor_chosen']/div/ul/li"));

		for (WebElement options : option) {

			String sta = options.getText();

			if (sta.equalsIgnoreCase("VENDORSAMSUNG")) {

				options.click();

				break;
			}
		}

		Thread.sleep(2000);

		waitUntilElementClickable(Vendordropdown, 30);

		WebElement get1 = Innertext;

		get1.sendKeys("VENDOR2");

		Vendorchoosetext.click();

		acceptpopup();

		Description_text_field.sendKeys(partno);

		Description_text_field.sendKeys(Keys.ENTER);

		Thread.sleep(4000);

		Description.sendKeys(Descrip);

		cost.clear();

		cost.sendKeys(cost1);

		MSRP.clear();

		MSRP.sendKeys(MSRP1);

		Retailprice.clear();

		Retailprice.sendKeys(RETAIL1);

		selectDropdown(Categorydropdown, Category);

		selectDropdown(manufacturerdropdown, manufacturer);

		Quickadd.click();

		Description_text_field.sendKeys("pn1001");

		Description_text_field.sendKeys(Keys.ENTER);

		Description_text_field.sendKeys("pn2001");

		Description_text_field.sendKeys(Keys.ENTER);

		Description_text_field.sendKeys("ds785");

		Description_text_field.sendKeys(Keys.ENTER);

		Description_text_field.sendKeys("ds780");

		Description_text_field.sendKeys(Keys.ENTER);

		String text = driver
				.findElement(By.xpath("//div[@id='mainscreen']/div/div[3]/form/div[2]/div[3]/div[4]/div"))
				.getText();

		System.out.println(text);



	}



}
