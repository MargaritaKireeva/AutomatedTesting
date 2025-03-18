package tests;

import core.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class SearchTest extends BaseTest {
    @Test
    @Description("Test Description: Test checks the operations with the search")
    @Parameters("browser")
    public void testSearchQuery(String browser) {
        // задаем поисковой запрос
        String query = "жираф";
        // открываем главную страницу
        MainPage mainPage = new MainPage(driver);
        // производим поиск и переходим на страницу с результатами поиска
        mainPage.searchFor(query);
        SearchPage searchPage = new SearchPage(driver);
        // проверяем наличие запроса в названии картины
        boolean containsQuery = searchPage.doesFirstPaintingContainQuery(query);
        // если название картины содержит запрос
        if (containsQuery) {
            // тест завершен
            Assert.assertTrue(containsQuery);
        } // иначе переходим на страницу картины
        else {
            searchPage.navigateToFirstPainting();
            PaintingPage paintingPage = new PaintingPage(driver);
            // и проверяем наличие запроса в ключевых словах
            Assert.assertTrue(paintingPage.doKeywordsContainQuery(query));
        }


    }
}
