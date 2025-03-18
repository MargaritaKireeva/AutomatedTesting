package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }
    public static WebDriver getDriver(String browser) {
        if (driver.get() == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\ritak\\IdeaProjects\\drivers\\chromedriver.exe");
                driver.set(new ChromeDriver());
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.firefox.driver", "C:\\Users\\ritak\\IdeaProjects\\drivers\\geckodriver.exe");
                driver.set(new FirefoxDriver());
            }
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
