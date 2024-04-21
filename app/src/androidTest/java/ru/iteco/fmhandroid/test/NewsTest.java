package ru.iteco.fmhandroid.test;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.util.AuthUtils.goToMainPage;

import androidx.test.espresso.ViewInteraction;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.BaseTest;
import ru.iteco.fmhandroid.page.ControlPanelPage;
import ru.iteco.fmhandroid.page.CreatingNewsPage;
import ru.iteco.fmhandroid.page.MainPage;
import ru.iteco.fmhandroid.page.NavPage;
import ru.iteco.fmhandroid.page.NewsPage;

@Epic("Внутренние страницы приложения")
@Feature("Новости")
public class NewsTest extends BaseTest {

    @Before
    public void login() {
        goToMainPage();
    }

    public static String NEWS_CATEGORY = "Объявление";
    public static String NEWS_TITLE = "Тестовая новость";
    public static String NEWS_DESCRIPTION = "Тестовое описание";


    @Test
    @Story("Работа с новостями")
    @Description("Переход на экран с новостями")
    public void goToNewsPageTest() {
        NavPage navPage = new NavPage();
        navPage.goToNewsPage();
        NewsPage newsPage = new NewsPage();
        newsPage.waitUntilPageLoaded();
        newsPage.validatePageLoaded();
    }

    @Test
    @Story("Работа с новостями")
    @Description("Добавление новости")
    public void addNewsTest() {
        NavPage navPage = new NavPage();
        navPage.goToNewsPage();
        NewsPage newsPage = new NewsPage();
        newsPage.waitUntilPageLoaded();
        newsPage.validatePageLoaded();
        newsPage.goToControlPanel();

        ControlPanelPage controlPanelPage = new ControlPanelPage();
        controlPanelPage.waitUntilPageLoaded();
        controlPanelPage.validatePageLoaded();
        controlPanelPage.addNews();

        CreatingNewsPage creatingNewsPage = new CreatingNewsPage();
        creatingNewsPage.waitUntilPageLoaded();
        creatingNewsPage.validatePageLoaded();
        creatingNewsPage.typeCategory(NEWS_CATEGORY);
        String newsTitle = NEWS_TITLE + getRandomNumber();
        creatingNewsPage.typeTitle(newsTitle);
        creatingNewsPage.typeDate();
        creatingNewsPage.typeTime();
        creatingNewsPage.typeDescription(NEWS_DESCRIPTION);

        creatingNewsPage.addNews();
        controlPanelPage.waitUntilPageLoaded();

        NavPage newsNavPage = new NavPage();
        newsNavPage.goToNewsPage();
        NewsPage createdNewsPage = new NewsPage();
        ViewInteraction createdNews = controlPanelPage.findNewsByTitle(newsTitle);
        createdNews.check(matches(isDisplayed()));
    }

    @Test
    @Story("Работа с новостями")
    @Description("Переход на экран с новостями по тапу на all news")
    public void goToNewsPageByAllNewsTest() {
        MainPage mainPage = new MainPage();
        mainPage.waitUntilPageLoaded();
        mainPage.validatePageLoaded();

        mainPage.goToAllNewsButton();

        NewsPage newsPage = new NewsPage();
        newsPage.waitUntilPageLoaded();
        newsPage.validatePageLoaded();
    }

    @Test
    @Story("Работа с новостями")
    @Description("Отображение расширенного описания новости")
    public void checkNewsDescriptionVisibleTest() {
        NavPage navPage = new NavPage();
        navPage.goToNewsPage();

        NewsPage newsPage = new NewsPage();
        newsPage.waitUntilPageLoaded();
        newsPage.validatePageLoaded();
        newsPage.goToControlPanel();

        ControlPanelPage controlPanelPage = new ControlPanelPage();
        controlPanelPage.waitUntilPageLoaded();
        controlPanelPage.validatePageLoaded();
        controlPanelPage.addNews();

        CreatingNewsPage creatingNewsPage = new CreatingNewsPage();
        creatingNewsPage.waitUntilPageLoaded();
        creatingNewsPage.validatePageLoaded();
        creatingNewsPage.typeCategory(NEWS_CATEGORY);
        String newsTitle = NEWS_TITLE + getRandomNumber();
        creatingNewsPage.typeTitle(newsTitle);
        creatingNewsPage.typeDate();
        creatingNewsPage.typeTime();
        String newsDescription = NEWS_DESCRIPTION + getRandomNumber();
        creatingNewsPage.typeDescription(newsDescription);

        creatingNewsPage.addNews();
        controlPanelPage.waitUntilPageLoaded();

        NavPage newsNavPage = new NavPage();
        newsNavPage.goToNewsPage();
        NewsPage createdNewsPage = new NewsPage();
        ViewInteraction createdNews = controlPanelPage.findNewsByTitle(newsTitle);
        createdNews.perform(click());

        newsPage.checkNewsDescriptionVisible(newsDescription);
    }

    private String getRandomNumber(){
        Random random = new Random();
        return String.valueOf(random.nextInt(100_000));
    }

}
