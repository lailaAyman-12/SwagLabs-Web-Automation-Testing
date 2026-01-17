package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            String path = "src/test/resources/config.properties";
            FileInputStream fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            System.out.println("Failed to load config.properties file");
            e.printStackTrace();
        }
    }

    private ConfigReader() {}

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}