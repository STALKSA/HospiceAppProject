package ru.iteco.fmhandroid.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.util.TestUtils.waitDisplayed;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.Allure;
import ru.iteco.fmhandroid.R;
import io.qameta.allure.Step;

public class AboutPage {

    ViewInteraction versionTitle = onView(withId(R.id.about_version_title_text_view));
    ViewInteraction privacyTitle = onView(withId(R.id.about_privacy_policy_label_text_view));
    ViewInteraction termsOfUseTitle = onView(withId(R.id.about_terms_of_use_label_text_view));

    @Step("Проверить, что заголовок версии отображается")
    public void checkVersionTitleDisplayed() {
        versionTitle.check(matches(isDisplayed()));
    }

    @Step("Проверить, что заголовок политики конфиденциальности отображается")
    public void checkPrivacyTitleDisplayed() {
        privacyTitle.check(matches(isDisplayed()));
    }

    @Step("Проверить, что заголовок условий использования отображается")
    public void checkTermsOfUseTitleDisplayed() {
        termsOfUseTitle.check(matches(isDisplayed()));
    }

    @Step("Ожидать загрузки страницы")
    public void waitUntilPageLoaded() {
        onView(isRoot()).perform(waitDisplayed(R.id.about_version_title_text_view, 6000));
    }

    @Step("Перейти на страницу О приложении")
    public void goToAboutPage() {
        NavPage navPage = new NavPage();
        navPage.goToAboutPage();
    }
}