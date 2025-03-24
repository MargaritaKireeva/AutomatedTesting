package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Objects;

public class CartPage {
    private WebDriver driver;


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get ID of the first painting on the page")
    public String getPaintingId() {
        return driver.findElements(By.xpath("//*[@class='c_del control']")).getFirst().getDomAttribute("data-id");
    }

    @Step("Get price of the first painting on the page")
    public String getFirstPaintingPrice() {
        return driver.findElements(By.xpath("//div[@class='price']")).getFirst().getText();
    }

    @Step("Compare the ID and price in the cart and the ID and price from " +
            "the page where the product was added to the cart")
    public boolean areIdAndPriceEquals(String paintingId, String price) {
        return (Objects.equals(paintingId, getPaintingId()) & Objects.equals(price, getFirstPaintingPrice()));

    }


}
