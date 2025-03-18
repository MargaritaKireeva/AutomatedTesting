package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import utils.AllureListener;

import java.util.List;

public class JewelryPage {
    private WebDriver driver;

    public JewelryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get ID of the first painting on the jewelry page")
    public String getFirstPaintingId() {
        return driver.findElements(By.xpath("//*[@class='heart']")).getFirst().getDomAttribute("data-id");
    }

    @Step("Get price of the first painting on the jewelry page")
    public String getFirstPaintingPrice() {
        return driver.findElements(By.xpath("//div[@class='price']")).getFirst().getText();
    }

    @Step("Add painting by ID to the cart")
    public void addToCart(String paintingId) {
        String xpathWithId = String.format("//div[@class='oclick' and contains(@id, '%s')]", paintingId);
        driver.findElement(By.xpath(xpathWithId)).click();
    }

    @Step("Click and open the cart page")
    public void navigateToCart() {
        driver.findElement(By.xpath("//*[@class='ok-button']")).click();
    }




    public void verifyPaintingPresent(String paintingName) {
        List<WebElement> paintings = driver.findElements(By.xpath("//div[@itemprop='name']")).stream()
                .filter(element -> element.getText().contains(paintingName))
                .toList();
        Assert.assertFalse(paintings.isEmpty());
    }

    public void navigateToPainting(String paintingName) {
        List<WebElement> paintings = driver.findElements(By.xpath("//div[@itemprop='name']")).stream()
                .filter(element -> element.getText().contains(paintingName))
                .toList();
        if (!paintings.isEmpty()) {
            paintings.getFirst().click();
        }
    }
}