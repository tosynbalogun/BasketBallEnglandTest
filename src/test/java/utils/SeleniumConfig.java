package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumConfig {
    private WebDriver driver;

    public SeleniumConfig(String browser) {
        setupDriver(browser);
    }

    private void setupDriver(String browserType) {
        switch (browserType.toLowerCase()) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
                driver = new ChromeDriver();
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
