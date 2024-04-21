package ru.iteco.fmhandroid.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static ru.iteco.fmhandroid.util.TestUtils.waitDisplayed;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class NewsPage {
    private ViewInteraction newsContainer = onView(withId(R.id.container_list_news_include));
    private ViewInteraction goToControlPanelButton = onView(withId(R.id.edit_news_material_button));

    @Step("Проверка корректной загрузки страницы с новостями")
    public void validatePageLoaded() {
        newsContainer.check(matches(isDisplayed()));
        goToControlPanelButton.check(matches(isDisplayed()));
    }

    @Step("Ожидание загрузки страницы с новостями")
    public void waitUntilPageLoaded() {
        onView(isRoot()).perform(waitDisplayed(R.id.container_list_news_include, 6000));
    }

    @Step("Переход на панель управления новостями")
    public void goToControlPanel() {
        goToControlPanelButton.perform(click());
    }

    @Step("Проверка отображения описания новости")
    public void checkNewsDescriptionVisible(String description) {
        onView(allOf(withText(description), isDisplayed())).check(matches(isDisplayed()));
    }

}
