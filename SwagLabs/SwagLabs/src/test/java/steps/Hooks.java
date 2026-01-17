package steps;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ExtentManager;
import utils.ScreenshotUtils;

public class Hooks {

    private WebDriver driver;
    private ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {
        driver = DriverFactory.getDriver();
        test = ExtentManager.getInstance().createTest(scenario.getName());
        test.log(Status.INFO, "Starting scenario: " + scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (test == null) return;

        if (scenario.isFailed()) {
            test.log(Status.FAIL, "Step failed");
            if (driver != null) {
                String screenshotPath = ScreenshotUtils.takeScreenshot(driver, scenario.getName() + "_step");
                try {
                    test.addScreenCaptureFromPath(screenshotPath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            test.log(Status.PASS, "Step passed");
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (test != null) {
            if (scenario.isFailed()) {
                test.log(Status.FAIL, "Scenario failed: " + scenario.getName());
                if (driver != null) {
                    String screenshotPath = ScreenshotUtils.takeScreenshot(driver, scenario.getName() + "_final");
                    try {
                        test.addScreenCaptureFromPath(screenshotPath);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                test.log(Status.PASS, "Scenario passed: " + scenario.getName());
            }
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DriverFactory.quitDriver();
        driver = null;
    }
}