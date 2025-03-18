package tests;

import core.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import utils.AllureListener;

import java.io.ByteArrayInputStream;

import static core.DriverManager.getDriver;
import static org.openqa.selenium.devtools.v131.page.Page.captureScreenshot;

public class CartTest extends BaseTest {

    @Test
    @Description("Test Description: Test checks the operations with the cart page. Test is always false, it was created to check Allure")
    @Parameters("browser")
    public void testAddToCartFalse(String browser) {
        MainPage mainPage = new MainPage(driver);
        mainPage.navigateToCatalog();
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.navigateToCatalogSection("Ювелирное искусство");
        JewelryPage jewelryPage = new JewelryPage(driver);
        String firstPaintingId = jewelryPage.getFirstPaintingId();
        String firstPaintingPrice = "3 000 руб.";
        jewelryPage.addToCart(firstPaintingId);
        jewelryPage.navigateToCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.areIdAndPriceEquals(firstPaintingId, firstPaintingPrice));
//        try {
//            Assert.assertTrue(cartPage.areIdAndPriceEquals(firstPaintingId, firstPaintingPrice));
//        } catch (AssertionError e) {
//            byte[] bytes = captureScreenshot(driver);
//            Allure.addAttachment("Failure screen", new ByteArrayInputStream(bytes));
//            Allure.addAttachment("Failure details", "Тест завершился неудачей: " + e.getMessage());
//            throw e;
//        }
    }

    @Test
    @Description("Test Description: Test checks the operations with the cart page")
    @Parameters("browser")
    public void testAddToCart(String browser) {
        // открываем главную страницу
        MainPage mainPage = new MainPage(driver);
        // переходим в каталог
        mainPage.navigateToCatalog();
        CatalogPage catalogPage = new CatalogPage(driver);
        // переходим в секцию каталога "Ювелирное искусство"
        catalogPage.navigateToCatalogSection("Ювелирное искусство");
        JewelryPage jewelryPage = new JewelryPage(driver);
        // получаем ID первой картины на странице
        String firstPaintingId = jewelryPage.getFirstPaintingId();
        // получаем цену первой картины на странице
        String firstPaintingPrice = jewelryPage.getFirstPaintingPrice();
        // добавляем картину в корзину
        jewelryPage.addToCart(firstPaintingId);
        // переходим в корзину
        jewelryPage.navigateToCart();
        CartPage cartPage = new CartPage(driver);
        // сравниваем сохраненные ID и цену с ID и ценой в корзине
        Assert.assertTrue(cartPage.areIdAndPriceEquals(firstPaintingId, firstPaintingPrice));
    }


}

