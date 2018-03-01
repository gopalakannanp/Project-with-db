package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;


public class HomePage extends TestBase{
	
	
	@FindBy(xpath="//div[@id='offbtn']/button[@id='run_button5']")
	@CacheLookup
	WebElement Officedropdownbtn;
		
	@FindBy(xpath="//*[@id='offbtn']/ul/li[3]/a")
	@CacheLookup
	WebElement POmenu;
	
	@FindBy(xpath = "//div[@id='offbtn']/ul/li/a[contains(text(),'Purchase Order')]")

	WebElement Purchaseordermenu;

	@FindBy(xpath="//*[@id='offbtn']/ul/li[3]/ul/li[1]/a")
	@CacheLookup
	WebElement subPOmenu;
	
	@FindBy(xpath = "//*[@id='offbtn']/ul/li[2]/a")
	@CacheLookup
	WebElement Productmenu;
	
	@FindBy(xpath = "//*[@id='offbtn']/ul/li[2]/ul/li[2]/a")
	@CacheLookup
	WebElement Productsubmenu;

	@FindBy(xpath = "//*[@id='offbtn']/ul/li[3]/ul/li[2]/a")
	@CacheLookup
	WebElement CreatenewPObtn;

	@FindBy(xpath = "//div[@id='offbtn']/ul/li//a[contains(text(),'Manage Purchase Orders')]")
	@CacheLookup
	WebElement CreateManagePObtn;

	@FindBy(xpath = "//div[@id=\"offbtn\"]/ul/li/ul/li/a[contains(text(),'Receive External Order')]")
	@CacheLookup
	WebElement CreatenewRPO;

	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public Select_Parts_To_Order_Page ClickonSelectPartsToOrderPage() throws InterruptedException {
				
		Thread.sleep(3000);
	
		waitUntilElementClickable(Officedropdownbtn, 60);
		
		mouseHover(POmenu, subPOmenu);
		
		switchWindow();
		
		return new Select_Parts_To_Order_Page();
				
	}

	public Create_New_Purchase_Order_Page ClickonCreateNewPurchaseOrder() throws InterruptedException {

		Thread.sleep(3000);

		waitUntilElementClickable(Officedropdownbtn, 60);

		mouseHover(POmenu, CreatenewPObtn);

		switchWindow();

		return new Create_New_Purchase_Order_Page();

	}

	public Manage_Purchase_Orders ClickonManagePurchaseOrder() throws InterruptedException {

		Thread.sleep(3000);

		waitUntilElementClickable(Officedropdownbtn, 60);

		mouseHover(POmenu, CreateManagePObtn);

		switchtowindow();

		return new Manage_Purchase_Orders();

	}

	public Product_Page_For_Reverse_PO clickonproductpage() throws InterruptedException {

		Thread.sleep(1000);

		waitUntilElementClickable(Officedropdownbtn, 60);

		mouseHover(Productmenu, Productsubmenu);

		switchtowindow();

		return new Product_Page_For_Reverse_PO();

	}

	public void ClickOnCreateReversePurchaseOrder() throws InterruptedException {
		
		Thread.sleep(1000);
		
		waitUntilElementClickable(Officedropdownbtn, 60);

		mouseHover(Purchaseordermenu, CreatenewRPO);

		switchtowindow();

	}
}
