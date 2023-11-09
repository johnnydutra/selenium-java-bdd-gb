package drivers;

import core.Constants;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static core.Constants.PROPERTIES_PATH;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;
        String driversPath = System.getProperty("user.dir") + Constants.DRIVERS_PATH;

        switch (getBrowserType()) {
            case CHROME -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.addArguments("--remote-allow-origin=*");
                driver = new ChromeDriver(chromeOptions);
            }
            case FIREFOX -> {
                System.setProperty("webdriver.gecko.browser", driversPath + "geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }

    private static BrowserType getBrowserType() {
        String browser = null;

        try {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream(PROPERTIES_PATH);
            properties.load(file);
            browser = properties.getProperty("browser").toUpperCase().trim();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return BrowserType.valueOf(browser);
    }
}
