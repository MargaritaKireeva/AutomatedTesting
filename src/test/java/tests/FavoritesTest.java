package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class FavoritesTest extends BaseTest {
    @Test
    @Parameters("browser")
    public void testAddToFavorites(String browser) {
        MainPage mainPage = new MainPage(driver);
        mainPage.navigateToCatalog();
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.navigateToСatalogSection("Батик");
        BatikPage batikPage = new BatikPage(driver);
        String firstPaintingId = batikPage.getFirstPaintingId();
        batikPage.addPaintingToFavorites(firstPaintingId);
        batikPage.navigateToFavorites();
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        String paintingFavoritesId = favoritesPage.getPaintingFavoritesId();
        Assert.assertEquals(paintingFavoritesId, firstPaintingId);
    }
}
