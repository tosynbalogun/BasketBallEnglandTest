package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {
    public static WebDriver getDriver(String browserType) {
        switch (browserType.toLowerCase()) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
                return new FirefoxDriver();
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
                return new ChromeDriver();
        }
    }
}
