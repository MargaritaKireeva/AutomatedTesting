package tests;

import core.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;


public class CartTest extends BaseTest {

//    @Test
//    @Description("Test Description: Test checks the operations with the cart page. Test is always false, it was created to check Allure")
//    @Parameters("browser")
//    public void testAddToCartFalse(String browser) {
//        // открываем главную страницу
//        MainPage mainPage = new MainPage(driver);
//        // переходим в каталог
//        mainPage.navigateToCatalog();
//        CatalogPage catalogPage = new CatalogPage(driver);
//        // переходим в секцию каталога "Ювелирное искусство"
//        catalogPage.navigateToCatalogSection("Ювелирное искусство");
//        JewelryPage jewelryPage = new JewelryPage(driver);
//        // получаем ID первой картины на странице
//        String firstPaintingId = jewelryPage.getFirstPaintingId();
//        // вместо извлечения цены картины, просто ставим цену (неправильную)
//        String firstPaintingPrice = "3 000 руб.";
//        // добавляем картину в корзину
//        jewelryPage.addToCart(firstPaintingId);
//        // переходим в корзину
//        jewelryPage.navigateToCart();
//        CartPage cartPage = new CartPage(driver);
//        // сравниваем сохраненные ID и цену с ID и ценой в корзине
//        // цены должна не совпасть и тест упадет
//        Assert.assertTrue(cartPage.areIdAndPriceEquals(firstPaintingId, firstPaintingPrice));
//    }

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

