package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "target/screenshots/" + screenshotName.replaceAll("[^a-zA-Z0-9_\\-]", "_") + ".png";
        File dest = new File(path);

        try {
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}