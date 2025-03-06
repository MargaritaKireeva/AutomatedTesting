package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {
    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToСatalogSection(String sectionName) {
        String xPath = String.format("//*[contains(text(), '%s')]", sectionName);
        driver.findElement(By.xpath(xPath)).click();
    }
}
