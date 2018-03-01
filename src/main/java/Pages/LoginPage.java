package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//*[@id='email_id']")
	WebElement username;

	@FindBy(xpath = "//*[@id='password']")
	WebElement password;

	@FindBy(xpath = "//*[@id='login_btn']")
	WebElement submit;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String un, String ps) {
		username.sendKeys(un);
		password.sendKeys(ps);
		submit.click();
		return new HomePage();
	}

}

