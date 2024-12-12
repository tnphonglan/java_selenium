package Automation.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport/Extentreport.html");
        reporter.config().setReportName("Extent Report | Hương Lan");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java | Hương Lan");
        extentReports.setSystemInfo("Author", "Hương Lan");
        return extentReports;
    }
}
