package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driver.DriverManager;


public class GoogleTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = DriverManager.getDriver("chrome");
	}

	@Test
	public void launchBrowserAndOpenGoogle() {
		driver.get("https://www.google.com");
	}

	@AfterMethod
	public void tearDown() {
		DriverManager.quitDriver();

	}
}
