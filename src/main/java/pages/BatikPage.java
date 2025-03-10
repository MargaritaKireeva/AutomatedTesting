package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BatikPage {
    private WebDriver driver;
//
//    @FindBy(xpath = "//*[@class='heart']")
//    private List<WebElement> paintingHeartList;
//
//    @FindBy(xpath = "//*[@alt='Избранное']")
//    private WebElement favorites;

    public BatikPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstPaintingId() {
        return driver.findElements(By.xpath("//*[@class='heart']")).getFirst().getDomAttribute("data-id");
    }

    public void addPaintingToFavorites(String paintingId) {
        driver.findElements(By.xpath("//*[@class='heart']")).getFirst().click();
    }

    public void navigateToFavorites() {
        driver.findElement(By.xpath("//*[@alt='Избранное']")).click();
    }
}
