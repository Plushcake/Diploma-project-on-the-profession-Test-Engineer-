package ru.iteco.fmhandroid.ui.authorizationTest;

//Пункт в тест кейсе № 2
//Количество тестов 16

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewInteraction;
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
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageObject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationPage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationNotValidTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);

        try {
            new VerificationPage().checkViewTextAuthorization();
        } catch (NoMatchingViewException e) {
            new LogOutSteps().logOut();
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
        new DataHelper().loginEditTextRandomLatinTextFaker();
        new ButtonSteps().signIn();
    }

    @Test
    @Description("Случайные цифры введены успешно")
    @DisplayName("Ввод в поле логин случайных цифр")
    public void loginEditTextRandomNumber() {
        new DataHelper().loginEditTextRandomNumberFaker();
        new ButtonSteps().signIn();
    }

    @Test
    @Description("Случайные символы введены успешно")
    @DisplayName("Ввод в поле логин случайных символов на кириллице")
    public void loginEditTextRandomCyrillic() {
        new DataHelper().loginEditTextRandomCyrillicFaker();
        new ButtonSteps().signIn();
    }

    @Test
    @Description("Символы введены успешно")
    @DisplayName("Ввод в поле логин специальных символов")
    public void loginEditTextSpecialCharacters() {
        ViewInteraction textInputEditTextSpecialCharacters = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        textInputEditTextSpecialCharacters.check(matches(isDisplayed()));
        textInputEditTextSpecialCharacters.perform(typeText("!@#$%^&*()"), closeSoftKeyboard());
        textInputEditTextSpecialCharacters.check(matches(withText("!@#$%^&*()")));
        new ButtonSteps().signIn();
        textInputEditTextSpecialCharacters.perform(clearText());
    }

    @Test
    @Description("Символы введены успешно")
    @DisplayName("Ввод в поле логин символы на латинице, цифр и специальных символов")
    public void loginEditTextMoreThan30Characters() {
        ViewInteraction textInputEditTextMoreThan30Characters = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        textInputEditTextMoreThan30Characters.check(matches(isDisplayed()));
        textInputEditTextMoreThan30Characters.perform(typeText("hello@555*ops^9876%cool#plush&eclair"), closeSoftKeyboard());
        textInputEditTextMoreThan30Characters.check(matches(withText("hello@555*ops^9876%cool#plush&eclair")));
        new ButtonSteps().signIn();
        textInputEditTextMoreThan30Characters.perform(clearText());
    }


    //Поле пароль.
    @Test
    @Description("Случайные символы введены успешно")
    @DisplayName("Ввод в поле пароль случайных символов на латинице")
    public void passwordEditTextLatin() {
        new DataHelper().passwordEditTextRandomLatinFaker();
        new ButtonSteps().signIn();
    }

    @Test
    @Description("Случайные символы введены успешно")
    @DisplayName("Ввод в поле пароль случайных цифр")
    public void passwordEditTextNumber() {
        new DataHelper().passwordEditTextRandomNumberFaker();
        new ButtonSteps().signIn();
    }

    @Test
    @Description("Случайные символы введены успешно")
    @DisplayName("Ввод в поле пароль случайных символов на кириллице")
    public void passwordEditTextCyrillic() {
        new DataHelper().passwordEditTextRandomLatinFaker();
        new ButtonSteps().signIn();
    }

    @Test
    @Description("Символы введены успешно")
    @DisplayName("Ввод в поле пароль специальных символов")
    public void passwordEditTextSpecialCharacters() {
        ViewInteraction textInputEditTextSpecialCharacters = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        textInputEditTextSpecialCharacters.check(matches(isDisplayed()));
        textInputEditTextSpecialCharacters.perform(typeText("!@#$%^&*()"), closeSoftKeyboard());
        textInputEditTextSpecialCharacters.check(matches(withText("!@#$%^&*()")));
        new ButtonSteps().signIn();
        textInputEditTextSpecialCharacters.perform(clearText());
    }

    @Test
    @Description("Символы введены успешно")
    @DisplayName("Ввод в поле пароль символы на латинице, специальные символы и цифры")
    public void passwordEditTextMoreThan30Characters() {
        ViewInteraction textInputEditTextMoreThan30Characters = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        textInputEditTextMoreThan30Characters.check(matches(isDisplayed()));
        textInputEditTextMoreThan30Characters.perform(typeText("hello@555*ops^9876%cool#plush&eclair"), closeSoftKeyboard());
        textInputEditTextMoreThan30Characters.check(matches(withText("hello@555*ops^9876%cool#plush&eclair")));
        new ButtonSteps().signIn();
        textInputEditTextMoreThan30Characters.perform(clearText());
    }

    //Поле логин и пароль.
    @Test
    @Description("Вход в аккаунт не успешный")
    @DisplayName("Поле логин и поле пароль заполнено не верными данными для входа")
    public void loginAndPasswordTestIncorrect() {
        new DataHelper().loginEditTextRandomLatinTextFaker();
        new DataHelper().passwordEditTextRandomLatinFaker();
        new ButtonSteps().signIn();
    }

    @Test
    @Description("Вход в аккаунт не успешный")
    @DisplayName("Поле логин и пароль пустые")
    public void loginAndPasswordTestEmpty() {
        ViewInteraction testIncorrectLoginEmpty = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        testIncorrectLoginEmpty.check(matches(isDisplayed()));
        testIncorrectLoginEmpty.perform(typeText(""), closeSoftKeyboard());
        testIncorrectLoginEmpty.check(matches(withText("")));

        ViewInteraction testIncorrectPasswordEmpty = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        testIncorrectPasswordEmpty.check(matches(isDisplayed()));
        testIncorrectPasswordEmpty.perform(typeText(""), closeSoftKeyboard());
        testIncorrectPasswordEmpty.check(matches(withText("")));
        new ButtonSteps().signIn();
    }

}
