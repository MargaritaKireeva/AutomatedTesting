package core;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import utils.AllureListener;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static java.util.logging.Level.OFF;


public class BaseTest {
    protected WebDriver driver;
    //public static EventFiringWebDriver driver;

//    public WebDriver getDriver() {
//        return driver;
//    }
    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser, ITestContext iTestContext) {
        driver = DriverManager.getDriver(browser);
        iTestContext.setAttribute("WebDriver", driver);
        driver.manage().window().maximize();
        // открытие сайта
        driver.get("https://artnow.ru/");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        Logger allureLogger = (Logger) LoggerFactory.getLogger("io.qameta.allure.AllureLifecycle");
//        allureLogger.setLevel(OFF);
    }

    public static WebDriver getDriverFromContext(ITestContext iTestContext){
        return (WebDriver) iTestContext.getAttribute("WebDriver") ;
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        DriverManager.quitDriver();
    }

//    @Attachment(value = "Failure screenshot", type = "image/png")
//    public static byte[] captureScreenshot(WebDriver driver) {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }
}
