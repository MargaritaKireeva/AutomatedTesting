package tests;

import core.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class SearchTest extends BaseTest {
    @Test
    @Description("Test checks the operations with the search by name (test will fail because the name of the first painting in the search doesn't contain \"жираф\")")
    @Parameters("browser")
    public void testSearchQueryName(String browser) {
        // задаем поисковой запрос
        String query = "жираф";
        // открываем главную страницу
        MainPage mainPage = new MainPage(driver);
        // производим поиск и переходим на страницу с результатами поиска
        mainPage.searchFor(query);
        SearchPage searchPage = new SearchPage(driver);
        // проверяем наличие запроса в названии картины
        boolean containsQuery = searchPage.doesFirstPaintingContainQuery(query);
        // проверяем содержит ли название картины запрос
        Assert.assertTrue(containsQuery);

    }

    @Test
    @Description("Test checks the operations with the search by keywords")
    @Parameters("browser")
    public void testSearchQueryWithKeywords(String browser) {
        // задаем поисковой запрос
        String query = "жираф";
        // открываем главную страницу
        MainPage mainPage = new MainPage(driver);
        // производим поиск и переходим на страницу с результатами поиска
        mainPage.searchFor(query);
        SearchPage searchPage = new SearchPage(driver);
        // переходим на страницу картины
        searchPage.navigateToFirstPainting();
        PaintingPage paintingPage = new PaintingPage(driver);
        // и проверяем наличие запроса в ключевых словах
        Assert.assertTrue(paintingPage.doKeywordsContainQuery(query));

    }
}
