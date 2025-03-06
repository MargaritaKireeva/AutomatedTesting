package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PaintingPage {
    private WebDriver driver;

    public PaintingPage(WebDriver driver) {
        this.driver = driver;
    }
    public void verifyPaintingStyle(String style) {
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='grey' and contains(text(), 'Стиль:')]/following-sibling::a")).getText(), style);

    }
}
