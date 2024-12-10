package Automation.listeners;

import Automation.helpers.CaptureHelper;
import Automation.helpers.PropertiesHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub
        System.out.println("onStart");
        PropertiesHelper.loadAllFiles();

    }

    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub
        System.out.println("onFinish");

    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("onTestStart: " + arg0.getName());
        CaptureHelper.startRecord(arg0.getName());

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("onTestSuccess: " + arg0.getName());

        CaptureHelper.stopRecord();

    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("onTestFailure: " + arg0.getName());
        CaptureHelper.takeScreenshot(arg0.getName());

        CaptureHelper.stopRecord();

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("onTestSkipped: " + arg0.getName());

        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
        System.out.println("onTestFailedButWithinSuccessPercentage");

    }
}
