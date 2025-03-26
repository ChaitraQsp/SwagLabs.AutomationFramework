package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of TestNG
 * 
 * @author Chaitra M
 *
 */
public class ListenersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " - @Test execution Started");

		// Create Test in Extent Report
		test = report.createTest(methodName);

	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " - @Test PASS");

		// Log the status PASS in extent report
		test.log(Status.PASS, methodName + " - @Test PASS");

	}

	public void onTestFailure(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " - @Test FAIL");

		System.out.println(result.getThrowable());

		// Log the Status FAIL in Extent Reports
		test.log(Status.FAIL, methodName + " - @Test FAIL");
		test.log(Status.WARNING, result.getThrowable());

		// Capture Screenshot
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();

		String screenshotName = methodName + "-" + j.getSystemDateInFormat();

		try {
			
			String path = s.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			//Attach the screenshot to Extent Report
			test.addScreenCaptureFromPath(path);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " - @Test SKIP");

		System.out.println(result.getThrowable());

		// Log the Status SKIP in Extent Reports
		test.log(Status.SKIP, methodName + " - @Test SKIP");
		test.log(Status.WARNING, result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

		System.out.println("Suite execution Started");

		// Basic Configuration of Extent reports
		ExtentSparkReporter esr = new ExtentSparkReporter(
				".\\ExtentReports\\Report - " + new JavaUtility().getSystemDateInFormat() + ".html");
		esr.config().setDocumentTitle("Swag Labs Execution Report");
		esr.config().setReportName("Automation Execution Report");
		esr.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows Family");
		report.setSystemInfo("Base URL", "https://www.saucedemo.com/");
		report.setSystemInfo("Reporter Name", "Chaitra");

	}

	public void onFinish(ITestContext context) {

		System.out.println("Suite execution Finished");

		// Generate the extent Reports
		report.flush();

	}

}
