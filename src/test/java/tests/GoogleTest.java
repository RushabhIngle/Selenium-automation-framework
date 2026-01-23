package tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import driver.DriverManager;



@Listeners(listners.ExtentTestNGlistners.class)
public class GoogleTest {

	
	@BeforeMethod
	public void setUp() {
		DriverManager.setDriver("chrome");	
	}

	@Test
	public void launchBrowserAndOpenGoogle() throws IOException {
        WebDriver driver = DriverManager.getDriver(); // 🔥 fetch per thread
//		test = extent.createTest("Google lauch through chrome");
		driver.get("https://www.google.com");
//		test.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64), "png_1");
//		test.info("validate title");
		Assert.assertEquals(driver.getTitle(), "Google");
//		test.pass("passed");
	}

	@Test
	public void launchAutomationExercise() throws IOException {
        WebDriver driver = DriverManager.getDriver(); // 🔥 fetch per thread

//		test = extent.createTest("Google lauch through chrome");
		driver.get("https://automationexercise.com/");
//		test.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64), "png_1");
//		test.info("validate title");
		Assert.assertEquals(driver.getTitle(), "Automation Exercise");
//		test.pass("passed");
	}

	@AfterMethod
	public void tearDown() {
		DriverManager.quitDriver();
	}
}
