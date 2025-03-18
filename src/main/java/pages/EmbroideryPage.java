package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import utils.AllureListener;

import java.util.List;
import java.util.stream.Collectors;

public class EmbroideryPage {
    private WebDriver driver;

    public EmbroideryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select genre by its name")
    public void selectGenre(String genre) {
        String xPath = String.format("//input[@type='checkbox' and following-sibling::text()[contains(., ' %s')]]", genre);
        driver.findElement(By.xpath(xPath)).click();
        driver.findElement(By.xpath("//*[@id='applymsg']")).click();
    }

    @Step("Get list of all paintings, filter painting by name and assert that list is not empty")
    public void verifyPaintingPresent(String paintingName) {
        List<WebElement> paintings = driver.findElements(By.xpath("//div[@itemprop='name']")).stream()
                .filter(element -> element.getText().contains(paintingName))
                .toList();
       Assert.assertFalse(paintings.isEmpty());
    }

    @Step("Click and open the page with painting")
    public void navigateToPainting(String paintingName) {
        List<WebElement> paintings = driver.findElements(By.xpath("//div[@itemprop='name']")).stream()
                .filter(element -> element.getText().contains(paintingName))
                .toList();
        if (!paintings.isEmpty()) {
            paintings.getFirst().click();
        }
    }
}
