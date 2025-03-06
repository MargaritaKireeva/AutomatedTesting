package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        driver = DriverManager.getDriver(browser);
        driver.manage().window().maximize();
        // открытие сайта
        driver.get("https://artnow.ru/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void close() {
        DriverManager.quitDriver();
    }
}
