package listners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import driver.DriverManager;


public class ExtentTestNGlistners implements ITestListener{

	private static ExtentReports extent = new ExtentReports();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onStart(ITestContext context) {

		ExtentSparkReporter spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/test-output/ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test.set(extent.createTest(result.getMethod().getMethodName()));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	    WebDriver driver = DriverManager.getDriver();
		test.get().pass("test passed");
		test.get().addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64),
				"png_1");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	    WebDriver driver = DriverManager.getDriver();
		test.get().fail(result.getThrowable());
		test.get().addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64),
				"png_1");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
