package Proyecto.Utils;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.logging.Logger;

public class BaseTest {
    public static final Logger logger = (Logger) LogManager.getLogger(BaseTest.class);

    public BaseTest() {
        logger.info("Initializing ExtentReport setup from constructor...");
        ExtentReportManager.setUpReport();
    }

    @BeforeSuite
    public void setUpReport() {
        logger.info("Initializing ExtentReport setup...");
        ExtentReportManager.setUpReport();
        logger.info("ExtentReport setup completed successfully.");
    }


    @AfterSuite
    public void tearDown() {
        logger.info("Flushing ExtentReport...");
        ExtentReportManager.flushReport();
        logger.info("ExtentReport flushed successfully.");
    }
}
