package tests;

import core.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.EmbroideryPage;
import pages.MainPage;

public class EmbroideryExistenceTest extends BaseTest {

    @Test
    @Description("Test checks the operations with the catalog page and painting existence")
    @Parameters("browser")
    public void testVerifyPaintingPresent(String browser) {
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
        // проверяем, что картина "Трамвайный путь" присутствует в выдаче
        embroideryPage.verifyPaintingPresent("Трамвайный путь");
    }
}
