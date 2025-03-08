package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean doesFirstPaintingContainQuery(String query) {
        WebElement firstPainting = driver.findElements(By.xpath("//div[@itemprop='name']")).getFirst();
        return firstPainting.getText().contains(query);
    }

    public void navigateToFirstPainting() {
        driver.findElements(By.xpath("//div[@itemprop='name']")).getFirst().click();
    }

}
