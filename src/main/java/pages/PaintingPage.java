package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import utils.AllureListener;


public class PaintingPage {
    private WebDriver driver;

    public PaintingPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Compare style on the page and style from parameters")
    public void verifyPaintingStyle(String style) {
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='grey' and contains(text(), 'Стиль:')]/following-sibling::a")).getText(), style);

    }

    @Step("Check if the keywords of the painting contain words from the search")
    public boolean doKeywordsContainQuery(String query) {
        String keywords = driver.findElement(By.xpath("//div[@class='txt-p lft grey']")).getText();
        return keywords.contains(query);
    }
}
