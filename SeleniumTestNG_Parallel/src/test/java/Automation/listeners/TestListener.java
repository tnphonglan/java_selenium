package Automation.listeners;

import Automation.helpers.CaptureHelper;
import Automation.helpers.PropertiesHelper;
import Automation.reports.ExtentReportManager;
import Automation.reports.ExtentTestManager;
import Automation.utils.LogUtils;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext result) {
        PropertiesHelper.loadAllFiles();

    }

    @Override
    public void onFinish(ITestContext result) {
        //Kết thúc và thực thi Extents Report
        ExtentReportManager.getExtentReports().flush();

    }

    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info("");
        LogUtils.info("************" + result.getName() + "************");
        CaptureHelper.startRecord(result.getName());
        //Bắt đầu ghi 1 TCs mới vào Extent Report
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("");
        LogUtils.info("==>" + result.getName() + " is successfully");
        CaptureHelper.stopRecord();
        //Extent Report
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.info("");
        LogUtils.error("==>" + result.getName() + " is Fail");
        CaptureHelper.takeScreenshot(result.getName());
        CaptureHelper.stopRecord();
        //Extent Report
        ExtentTestManager.addScreenshot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.info("");
        LogUtils.warn("************" + result.getName() + " is Skip");
        CaptureHelper.stopRecord();
        //Extent Report
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LogUtils.info("");
        LogUtils.info("onTestFailedButWithinSuccessPercentage" + result.getName());

    }
}
