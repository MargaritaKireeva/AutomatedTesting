package utils;

import core.BaseTest;
import core.DriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import static io.qameta.allure.model.Status.BROKEN;
import static io.qameta.allure.model.Status.FAILED;

public class AllureListener implements TestLifecycleListener {

    public AllureListener() {
    }

    private static String getTestMethodName(TestResult result) {
        return result.getName();
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void beforeTestStop(TestResult result) {
        if (FAILED == result.getStatus() || BROKEN == result.getStatus()) {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
                byte[] bytes = saveScreenshot(driver);

                SimpleDateFormat timeScreen = new SimpleDateFormat("dd.MM.yyyy 'at' hh.mm.ss");
                String date = timeScreen.format(new Date());
                String name = result.getStatus().name() + " " + date;
                Allure.addAttachment(name + " textLog", saveTextLog(getTestMethodName(result) + " " + result.getStatus().name()));
                Allure.addAttachment(name + " screen", new ByteArrayInputStream(bytes));
            }
        }
    }
}
