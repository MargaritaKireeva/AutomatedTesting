package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import utils.AllureListener;

import java.time.Duration;
import java.util.List;

public class FavoritesPage {
    private WebDriver driver;

//    @FindBy(xpath = "//*[@class='heart']")
//    private WebElement paintingFavorites;


    public FavoritesPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get ID of the painting on the favorites page")
    public String getPaintingFavoritesId() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='heart']")));
        return element.getDomAttribute("data-id");
    }
}
