package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	private static String browserName = System.getProperty("browser", "Chrome");

	private static final ThreadLocal<WebDriver> DRIVER_LOCAL = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {

		return DRIVER_LOCAL.get();

	}

	public static void setDriver(WebDriver driver) {

		DriverSetup.DRIVER_LOCAL.set(getDriver());

	}

	public static WebDriver getBrowser(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();

		case "edge":
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();

		default:

			throw new RuntimeException("Browser Not Found");

		}

	}

	@BeforeMethod
	public static synchronized void setBrowser() {

		WebDriver webDriver = getBrowser(browserName);
		webDriver.manage().window().maximize();
		setDriver(webDriver);

	}

	@AfterMethod
	public static synchronized void quitBrowser() {

		getDriver().quit();
	}

}
