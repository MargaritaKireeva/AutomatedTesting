package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import core.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.EmbroideryPage;

public class EmbroideryStyleTest extends BaseTest {
    @Test
    @Parameters("browser")
    public void testVerifyPaintingStyle(String browser) {
        MainPage mainPage = new MainPage(driver);
        mainPage.navigateToCatalog();
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.navigateToСatalogSection("Вышитые картины");
        EmbroideryPage embroideryPage = new EmbroideryPage(driver);
        embroideryPage.selectGenre("Городской пейзаж");
        embroideryPage.navigateToPainting("Трамвайный путь");
        PaintingPage paintingPage = new PaintingPage(driver);
        paintingPage.verifyPaintingStyle("Реализм");
    }
}
