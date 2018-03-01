package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "./src/main/java/Config/Config");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();

			// driver = new HtmlUnitDriver();
			// driver.manage().window().setSize(new Dimension(1024, 768));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));

		}

	}

	public static void mouseHover(WebElement element1, WebElement element) {
		Actions mouse = new Actions(driver);
		mouse.moveToElement(element1);
		mouse.moveToElement(element).click().build().perform();

	}

	public static void switchWindow() {
		for (String childwindow : driver.getWindowHandles()) {
			driver.switchTo().window(childwindow);
		}
	}

	public static void waitUntilElementVisible(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void waitUntilElementClickable(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public static String gettext(WebElement element) {
		return element.getText();
	}

	public static void selectDropdown(WebElement element, String value) {
		new Select(element).selectByVisibleText(value);
		// new Select (element).selectByIndex(arg0);
		// new Select (element).selectByValue(arg0);
	}

	public static void acceptpopup() {

		driver.switchTo().alert().accept();

	}

	public static String acceptmsgpopup() {

		String text = driver.switchTo().alert().getText();

		return text;

	}

	public static void switchtowindow() {

		Iterator<String> itr = driver.getWindowHandles().iterator();

		String parentw = itr.next();

		String childw = itr.next();

		driver.switchTo().window(childw);

	}

	public static void switchtoparentwindow() {

		Iterator<String> itr = driver.getWindowHandles().iterator();

		String parentw = itr.next();

		driver.switchTo().window(parentw);

	}


}
