package TestComponents.comp;

import Automation.resources.ExtentReportNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listener extends BaseTest implements ITestListener {

    //     Implement methods from ITestListener interface as needed
    //     For example, you can override onTestStart, onTestSuccess, onTestFailure, etc.
    //     to add custom behavior for test events.
    //
    //     Example:
    ExtentReportNG extentReport = new ExtentReportNG();
    ExtentTest test;
    ExtentReports extent = extentReport.getreportobject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());//cannot do result.getmethodname because Itestreuslt does not have getmethodname method,result is object od Itestresult
        extentTest.set(test);
        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        extentTest.get().fail(result.getThrowable());
        // Get WebDriver instance from test class
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).driver();  // You must define getDriver() in BaseTest

        String screenshotPath = null;
        try {
            screenshotPath = BaseTest.getScreenshot(driver, result.getMethod().getMethodName());
            extentTest.get().addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
        extentTest.get().skip(result.getThrowable());
    }
        @Override public void onFinish (ITestContext context){
            extent.flush();  // ← flush() is called here, but not overridden!
        }

        // You can add code here to take a screenshot or log additional information
    }
