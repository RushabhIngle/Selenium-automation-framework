package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

	private static WebDriver driver;

	private DriverManager() {
	}

	public static WebDriver getDriver(String browser) {

		if (driver == null) {

			if (browser.equalsIgnoreCase("chrome")) {

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				driver = new ChromeDriver(options);

			} else if (browser.equalsIgnoreCase("firefox")) {
				
				driver = new FirefoxDriver();
				driver.manage().window().maximize();

			} else {
				throw new RuntimeException("Unsupported browser: " + browser);
			}
		}
		
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
