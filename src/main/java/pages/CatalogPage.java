package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CatalogPage {
    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click and open the catalog section page")
    public void navigateToCatalogSection(String sectionName) {
        String xPath = String.format("//*[contains(text(), '%s')]", sectionName);
        driver.findElement(By.xpath(xPath)).click();
    }
}
