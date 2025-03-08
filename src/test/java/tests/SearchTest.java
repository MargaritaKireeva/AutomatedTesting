package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class SearchTest extends BaseTest {
    @Test
    @Parameters("browser")
    public void testSearchQuery(String browser) {
        String query = "жираф";
        MainPage mainPage = new MainPage(driver);
        mainPage.searchFor(query);
        SearchPage searchPage = new SearchPage(driver);
        boolean containsQuery = searchPage.doesFirstPaintingContainQuery(query);
        if (containsQuery) {
            Assert.assertTrue(containsQuery);
        }
        else {
            searchPage.navigateToFirstPainting();
            PaintingPage paintingPage = new PaintingPage(driver);
            Assert.assertTrue(paintingPage.doKeywordsContainQuery(query));
        }


    }
}
