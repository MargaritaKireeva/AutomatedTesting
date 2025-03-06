package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCatalog() {
        driver.findElement(By.xpath("//*[contains(text(), 'Каталог')]")).click();
    }

    public void searchFor(String query) {
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(query);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
