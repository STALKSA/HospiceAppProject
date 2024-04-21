package ru.iteco.fmhandroid.test;

import static ru.iteco.fmhandroid.util.AuthUtils.logIn;
import static ru.iteco.fmhandroid.util.AuthUtils.logOut;
import static ru.iteco.fmhandroid.util.AuthUtils.unsuccessfulLogIn;
import ru.iteco.fmhandroid.util.AuthData;
import ru.iteco.fmhandroid.util.AuthUtils;


import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.Allure;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.BaseTest;
import ru.iteco.fmhandroid.page.LoginPage;
import ru.iteco.fmhandroid.page.MainPage;

@Epic("Авторизация")
@Feature("Вход в систему")
public class LoginTest extends BaseTest {

    @Test
    @Story("Успешный вход в аккаунт")
    @Description("Тест успешного входа в аккаунт")
    public void successfulLoginTest() {
        AuthUtils.logIn();
        AuthUtils.logOut();
    }


    @Test
    @Story("Вход с неверным паролем")
    @Description("Проверка возможности входа в систему с некорректным паролем")
    public void appLoginTestIncorrectPassword() {
        AuthUtils.unsuccessfulLogIn(AuthData.INVALID_LOGIN, AuthData.INVALID_PASSWORD);
        LoginPage loginPage = new LoginPage();
        loginPage.waitUntilErrorMessageLoaded();

        Allure.step("Убедиться, что остались на странице логина");
        loginPage.validatePageLoaded();
    }

    @Test
    @Story("Вход с неверным логином и паролем")
    @Description("Проверка возможности входа в систему с некорректным логином и паролем")
    public void appLoginTestIncorrectLoginAndPassword() {
        AuthUtils.unsuccessfulLogIn(AuthData.INVALID_LOGIN, AuthData.INVALID_PASSWORD);
        LoginPage loginPage = new LoginPage();
        loginPage.waitUntilErrorMessageLoaded();

        Allure.step("Убедиться, что остались на странице логина");
        loginPage.validatePageLoaded();
    }

    @Test
    @Story("Вход с пустыми логином и паролем")
    @Description("Проверка возможности входа в систему с пустыми логином и паролем")
    public void appLoginTestEmptyLoginAndPassword() {
        AuthUtils.unsuccessfulLogIn(AuthData.EMPTY_STRING, AuthData.EMPTY_STRING);
        LoginPage loginPage = new LoginPage();
        loginPage.waitUntilErrorMessageLoaded();

        Allure.step("Убедиться, что остались на странице логина");
        loginPage.validatePageLoaded();
    }
}
