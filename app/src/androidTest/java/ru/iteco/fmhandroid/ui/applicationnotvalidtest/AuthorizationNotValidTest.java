package ru.iteco.fmhandroid.ui.applicationnotvalidtest;

//Пункт в тест кейсе № 2
//Количество тестов 16


import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.basic.BasicClass;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageobject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationpage.VerificationPage;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationNotValidTest extends BasicClass {

    VerificationPage authorizationPage = new VerificationPage();
    LogOutSteps logOutSteps = new LogOutSteps();
    DataHelper dataHelper = new DataHelper();
    ButtonSteps buttonSteps = new ButtonSteps();

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);

        try {
            authorizationPage.checkViewTextAuthorization();
        } catch (NoMatchingViewException e) {
            logOutSteps.logOut();
        }

    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }

    //Поле логин.
    @Test
    @Description("Случайные символы введены успешно")
    @DisplayName("Ввод в поле логин случайных символов на латинице")
    public void loginEditTextRandomTextLatin() {
        dataHelper.loginEditTextRandomLatinTextFaker();
        buttonSteps.signIn();
    }

    @Test
    @Description("Случайные цифры введены успешно")
    @DisplayName("Ввод в поле логин случайных цифр")
    public void loginEditTextRandomNumber() {
        dataHelper.loginEditTextRandomNumberFaker();
        buttonSteps.signIn();
    }

    @Test
    @Description("Случайные символы введены успешно")
    @DisplayName("Ввод в поле логин случайных символов на кириллице")
    public void loginEditTextRandomCyrillic() {
        dataHelper.loginEditTextRandomCyrillicFaker();
        buttonSteps.signIn();
    }

    @Test
    @Description("Символы введены успешно")
    @DisplayName("Ввод в поле логин специальных символов")
    public void loginEditTextSpecialCharacters() {
        dataHelper.loginEditTextSpecialCharacters();
        buttonSteps.signIn();
    }

    @Test
    @Description("Символы введены успешно")
    @DisplayName("Ввод в поле логин символы на латинице, цифр и специальных символов")
    public void loginEditTextMoreThan30Characters() {
        dataHelper.loginEditTextMoreThan30Characters();
        buttonSteps.signIn();
    }

    //Поле пароль.
    @Test
    @Description("Случайные символы введены успешно")
    @DisplayName("Ввод в поле пароль случайных символов на латинице")
    public void passwordEditTextLatin() {
        dataHelper.passwordEditTextRandomLatinFaker();
        buttonSteps.signIn();
    }

    @Test
    @Description("Случайные символы введены успешно")
    @DisplayName("Ввод в поле пароль случайных цифр")
    public void passwordEditTextNumber() {
        dataHelper.passwordEditTextRandomNumberFaker();
        buttonSteps.signIn();
    }

    @Test
    @Description("Случайные символы введены успешно")
    @DisplayName("Ввод в поле пароль случайных символов на кириллице")
    public void passwordEditTextCyrillic() {
        dataHelper.passwordEditTextRandomLatinFaker();
        buttonSteps.signIn();
    }

    @Test
    @Description("Символы введены успешно")
    @DisplayName("Ввод в поле пароль специальных символов")
    public void passwordEditTextSpecialCharacters() {
        dataHelper.passwordEditTextSpecialCharacters();
        buttonSteps.signIn();
    }

    @Test
    @Description("Символы введены успешно")
    @DisplayName("Ввод в поле пароль символы на латинице, специальные символы и цифры")
    public void passwordEditTextMoreThan30Characters() {
        dataHelper.passwordEditTextMoreThan30Characters();
        buttonSteps.signIn();
    }

    //Поле логин и пароль.
    @Test
    @Description("Вход в аккаунт не успешный")
    @DisplayName("Поле логин и поле пароль заполнено не верными данными для входа")
    public void loginAndPasswordTestIncorrect() {
        dataHelper.loginEditTextRandomLatinTextFaker();
        dataHelper.passwordEditTextRandomLatinFaker();
        buttonSteps.signIn();
    }

    @Test
    @Description("Вход в аккаунт не успешный")
    @DisplayName("Поле логин и пароль пустые")
    public void loginAndPasswordTestEmpty() {
        dataHelper.loginAndPasswordTestEmpty();
        buttonSteps.signIn();
    }

}
