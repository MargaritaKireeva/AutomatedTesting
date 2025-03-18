package tests;

import core.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class FavoritesTest extends BaseTest {
    @Test
    @Description("Test Description: Test checks the operations with the catalog and favorites pages")
    @Parameters("browser")
    public void testAddToFavorites(String browser) {
        // открываем главную страницу
        MainPage mainPage = new MainPage(driver);
        // переходим в каталог
        mainPage.navigateToCatalog();
        CatalogPage catalogPage = new CatalogPage(driver);
        // переходим в секцию каталога "Батик"
        catalogPage.navigateToCatalogSection("Батик");
        BatikPage batikPage = new BatikPage(driver);
        // получаем ID первой картины на странице
        String firstPaintingId = batikPage.getFirstPaintingId();
        // добавляем картину в избранное
        batikPage.addPaintingToFavorites(firstPaintingId);
        // переходим в избранное
        batikPage.navigateToFavorites();
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        // получаем ID картины в избранном
        String paintingFavoritesId = favoritesPage.getPaintingFavoritesId();
        // проверяем полученные ID на соответствие
        Assert.assertEquals(paintingFavoritesId, firstPaintingId);
    }
}
