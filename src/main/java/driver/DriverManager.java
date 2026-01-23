package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    public static void setDriver(String browser) {

        if (driver.get() == null) {

            WebDriver driverRef;

            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driverRef = new ChromeDriver(options);

            } else if (browser.equalsIgnoreCase("firefox")) {
                driverRef = new FirefoxDriver();
                driverRef.manage().window().maximize();

            } else {
                throw new RuntimeException("Unsupported browser: " + browser);
            }

            driver.set(driverRef); // 🔥 MOST IMPORTANT LINE
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
