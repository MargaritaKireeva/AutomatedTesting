package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import utils.AllureListener;

import java.util.List;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Check if the name of the painting contains the words from the search")
    public boolean doesFirstPaintingContainQuery(String query) {
        WebElement firstPainting = driver.findElements(By.xpath("//div[@itemprop='name']")).getFirst();
        return firstPainting.getText().contains(query);
    }

    @Step("Click and open the painting page")
    public void navigateToFirstPainting() {
        driver.findElements(By.xpath("//div[@itemprop='name']")).getFirst().click();
    }

}
