package Proyecto.Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportManager {

    public static ExtentReports extent;
    public static ExtentTest test;


    public static void setUpReport() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";


            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setReportName("API Test Automation Report");
            sparkReporter.config().setDocumentTitle("Test Report");


            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);


            extent.setSystemInfo("NAME", "Final Test Report");
            extent.setSystemInfo("Project", "Rest Framework");
        }
    }


    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
