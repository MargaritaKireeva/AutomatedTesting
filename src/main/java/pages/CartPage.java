package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class CartPage {
    private WebDriver driver;

//    @FindBy(xpath = "//*[@class='heart']")
//    private WebElement paintingFavorites;


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPaintingId() {
        return driver.findElements(By.xpath("//*[@class='c_del control']")).getFirst().getDomAttribute("data-id");
    }

    public String getFirstPaintingPrice() {
        return driver.findElements(By.xpath("//div[@class='price']")).getFirst().getText();
    }

    public boolean areIdAndPriceEquals(String paintingId, String price) {
        return Objects.equals(paintingId, getPaintingId()) & Objects.equals(price, getFirstPaintingPrice());

    }


}
