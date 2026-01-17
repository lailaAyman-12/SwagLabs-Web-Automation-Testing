package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");

            if ("edge".equalsIgnoreCase(browser)) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-infobars");

                System.setProperty("webdriver.edge.driver", "F:\\edgedriver_win64\\msedgedriver.exe");
                driver = new EdgeDriver(options);
            } else {
                // ممكن تضيفي دعم لبراوزر تاني هنا (Chrome, Firefox...)
                throw new RuntimeException("Unsupported browser: " + browser);
            }

            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}