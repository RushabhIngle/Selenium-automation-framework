package tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.DriverManager;


public class GoogleTest {

	WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		driver = DriverManager.getDriver(browser);
	}

	@Test(dataProvider = "logindata")
	public void launchBrowserAndOpenGoogle(String user, String pass) {
		driver.get("https://www.google.com");
	}

	@AfterMethod
	public void tearDown() {
		DriverManager.quitDriver();

	}
}
