package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import utils.AllureListener;


public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click and open the catalog page")
    public void navigateToCatalog() {
        driver.findElement(By.xpath("//*[contains(text(), 'Каталог')]")).click();
    }

    @Step("Enter query in the search field and click on search button")
    public void searchFor(String query) {
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(query);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
