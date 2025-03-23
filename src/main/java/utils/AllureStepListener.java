package utils;
import core.DriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.model.TestResult;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.listener.TestLifecycleListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.qameta.allure.model.Status.BROKEN;
import static io.qameta.allure.model.Status.FAILED;

public class AllureStepListener implements StepLifecycleListener {

    public AllureStepListener() {
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
    public void afterStepStop(StepResult result) {

        // Добавляем скриншот и лог для упавших шагов
        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN) {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
                byte[] screenshotBytes = saveScreenshot(driver);
                Allure.addAttachment("Step Screenshot", new ByteArrayInputStream(screenshotBytes));
                Allure.addAttachment("StepLog", saveTextLog("Step failed: " + result.getName()));
            }
            System.out.println("Failed step: " + result.getName());
        } else {
            System.out.println("Finished step: " + result.getName());
        }
    }
}
