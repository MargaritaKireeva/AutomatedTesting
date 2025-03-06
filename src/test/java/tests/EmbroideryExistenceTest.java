package tests;

import core.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.EmbroideryPage;
import pages.MainPage;

public class EmbroideryExistenceTest extends BaseTest {

    @Test
    @Parameters("browser")
    public void testVerifyPaintingPresent(String browser) {
        MainPage mainPage = new MainPage(driver);
        mainPage.navigateToCatalog();
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.navigateToСatalogSection("Вышитые картины");
        EmbroideryPage embroideryPage = new EmbroideryPage(driver);
        embroideryPage.selectGenre("Городской пейзаж");
        embroideryPage.verifyPaintingPresent("Трамвайный путь");
    }
}
