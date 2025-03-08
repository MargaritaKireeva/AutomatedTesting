package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class CartTest extends BaseTest {
    @Test
    @Parameters("browser")
    public void testAddToCart(String browser) {
        MainPage mainPage = new MainPage(driver);
        mainPage.navigateToCatalog();
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.navigateToСatalogSection("Ювелирное искусство");
        JewelryPage jewelryPage = new JewelryPage(driver);
        String firstPaintingId = jewelryPage.getFirstPaintingId();
        String firstPaintingPrice = jewelryPage.getFirstPaintingPrice();
        jewelryPage.addToCart(firstPaintingId);
        jewelryPage.navigateToCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.areIdAndPriceEquals(firstPaintingId, firstPaintingPrice));
    }
}

