package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FavoritesPage {
    private WebDriver driver;

//    @FindBy(xpath = "//*[@class='heart']")
//    private WebElement paintingFavorites;


    public FavoritesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPaintingFavoritesId() {
        return driver.findElement(By.xpath("//*[@class='heart']")).getDomAttribute("data-id");
    }
}
