package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String reportPath =
                    System.getProperty("user.dir")
                    + "/test-output/ExtentReport.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName(
                    "Automation Exercise Test Report");

            sparkReporter.config().setDocumentTitle(
                    "Extent Report");

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo(
                    "Project",
                    "Automation Exercise");

            extent.setSystemInfo(
                    "Framework",
                    "Selenium + TestNG");

            extent.setSystemInfo(
                    "Software Testing Engineer",
                    "Muhammed Raafat ELGarf");

            System.out.println(
                    "Extent Report Path : " + reportPath);
        }


        System.out.println(
                "Extent Report Path : "
                + System.getProperty("user.dir")
                + "/test-output/ExtentReport.html");

        return extent;
    }
}