package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import core.BaseTest;
import pages.CatalogPage;
import pages.EmbroideryPage;

public class EmbroideryStyleTest extends BaseTest {
    @Test
    @Description("Test checks the operations with the catalog page and painting characteristics")
    @Parameters("browser")
    public void testVerifyPaintingStyle(String browser) {
        // открываем главную страницу
        MainPage mainPage = new MainPage(driver);
        // переходим в каталог
        mainPage.navigateToCatalog();
        CatalogPage catalogPage = new CatalogPage(driver);
        // переходим в секцию каталога "Вышитые картины"
        catalogPage.navigateToCatalogSection("Вышитые картины");
        EmbroideryPage embroideryPage = new EmbroideryPage(driver);
        // производим поиск по жанру "Городской пейзаж"
        embroideryPage.selectGenre("Городской пейзаж");
        // переходим на страницу картины "Трамвайный путь"
        embroideryPage.navigateToPainting("Трамвайный путь");
        PaintingPage paintingPage = new PaintingPage(driver);
        // проверяем, что стиль картины - реализм
        paintingPage.verifyPaintingStyle("Реализм");
    }
}
