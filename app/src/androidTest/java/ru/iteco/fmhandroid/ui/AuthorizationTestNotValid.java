package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 2

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTestNotValid {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void ThreadSleep() throws InterruptedException {
        Thread.sleep(7000);
    }


    @Test
    @Description("Цифры введены успешно")
    @DisplayName("Ввод в поле логин цифр")
    public void LoginEditTextNumber() {
        ViewInteraction textInputEditTextNumber = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        textInputEditTextNumber.check(matches(isDisplayed()));
        textInputEditTextNumber.perform(typeText("1234567890"), closeSoftKeyboard());

        textInputEditTextNumber.check(matches(withText("1234567890")));
        textInputEditTextNumber.perform(clearText());
    }


    @Test
    @Description("Символы введены успешно")
    @DisplayName("Ввод в поле логин символы на латиницев")
    public void LoginEditTextLatin() {
        ViewInteraction textInputEditTextLatin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        textInputEditTextLatin.check(matches(isDisplayed()));
        textInputEditTextLatin.perform(typeText("hello"));

        textInputEditTextLatin.check(matches(withText("hello")));
        textInputEditTextLatin.perform(clearText());
    }


    @Test
    @Description("Символы введены успешно")
    @DisplayName("Ввод в поле логин специальных символов")
    public void LoginEditTextSpecialCharacters() {
        ViewInteraction textInputEditTextSpecialCharacters = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        textInputEditTextSpecialCharacters.check(matches(isDisplayed()));
        textInputEditTextSpecialCharacters.perform(typeText("!@#$%^&*()"), closeSoftKeyboard());

        textInputEditTextSpecialCharacters.check(matches(withText("!@#$%^&*()")));
        textInputEditTextSpecialCharacters.perform(clearText());
    }


    @Test
    @Description("Символы введены успешно")
    @DisplayName("Ввод в поле логин символы на латиницев")
    public void LoginEditTextMoreThan30Characters() {
        ViewInteraction textInputEditTextMoreThan30Characters = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        textInputEditTextMoreThan30Characters.check(matches(isDisplayed()));
        textInputEditTextMoreThan30Characters.perform(typeText("hello@555*ops^9876%cool#plush&eclair"), closeSoftKeyboard());

        textInputEditTextMoreThan30Characters.check(matches(withText("hello@555*ops^9876%cool#plush&eclair")));
        textInputEditTextMoreThan30Characters.perform(clearText());
    }


    @Test
    @Description("Поле пустое")
    @DisplayName("Поле логин пустое")
    public void LoginEditTextTheFieldIsEmpty() {
        ViewInteraction textInputEditTextTheFieldIsEmpty = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        textInputEditTextTheFieldIsEmpty.check(matches(isDisplayed()));
        textInputEditTextTheFieldIsEmpty.perform(typeText(""), closeSoftKeyboard());

        textInputEditTextTheFieldIsEmpty.check(matches(withText("")));
        textInputEditTextTheFieldIsEmpty.perform(clearText());
    }


    @Test
    @Description("Символы введены успешно")
    @DisplayName("Ввод в поле логин символы на кириллице")
    public void LoginEditTextCyrillic() {
        ViewInteraction editTextCyrillic = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        editTextCyrillic.check(matches(isDisplayed()));
        editTextCyrillic.perform(replaceText("Привет"), closeSoftKeyboard());

        editTextCyrillic.check(matches(withText("Привет")));
        editTextCyrillic.perform(clearText());
    }


    @Test
    @Description("Вход в аккаунт не успешный")
    @DisplayName("Поле логин заполнено, поле пароль пустое с нажатие на кнопку войти")
    public void LoginTestError() {
        ViewInteraction testErrorLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        testErrorLogin.check(matches(isDisplayed()));
        testErrorLogin.perform(typeText("login25"), closeSoftKeyboard());
        testErrorLogin.check(matches(withText("login25")));


        ViewInteraction clickButton = onView(
                allOf(withId(R.id.enter_button)));
        clickButton.check(matches(isDisplayed()));
        clickButton.perform(click());

    }


    @Test
    @Description("Вход в аккаунт не успешный")
    @DisplayName("Поле логин пустое, поле пароль заполнено с нажатие на кнопку войти")
    public void PasswordEditTextNumber() {
        ViewInteraction textInputEditTextNumber = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        textInputEditTextNumber.check(matches(isDisplayed()));
        textInputEditTextNumber.perform(typeText("1234567890"), closeSoftKeyboard());

        textInputEditTextNumber.check(matches(withText("1234567890")));
        textInputEditTextNumber.perform(clearText());
    }


    @Test
    @Description("Символы введены успешно")
    @DisplayName("Ввод в поле пароль символы на латинице")
    public void PasswordEditTextLatin() {
        ViewInteraction textInputEditTextLatin = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        textInputEditTextLatin.check(matches(isDisplayed()));
        textInputEditTextLatin.perform(typeText("hello"), closeSoftKeyboard());


        textInputEditTextLatin.check(matches(withText("hello")));
        textInputEditTextLatin.perform(clearText());
    }


    @Test
    @Description("Символы введены успешно")
    @DisplayName("Ввод в поле пароль специальные символы")
    public void PasswordEditTextSpecialCharacters() {
        ViewInteraction textInputEditTextSpecialCharacters = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        textInputEditTextSpecialCharacters.check(matches(isDisplayed()));
        textInputEditTextSpecialCharacters.perform(typeText("!@#$%^&*()"), closeSoftKeyboard());


        textInputEditTextSpecialCharacters.check(matches(withText("!@#$%^&*()")));
        textInputEditTextSpecialCharacters.perform(clearText());
    }


    @Test
    @Description("Символы введены успешно")
    @DisplayName("Ввод в поле пароль символы на латинице, специальные символы и цифры")
    public void PasswordEditTextMoreThan30Characters() {
        ViewInteraction textInputEditTextMoreThan30Characters = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        textInputEditTextMoreThan30Characters.check(matches(isDisplayed()));
        textInputEditTextMoreThan30Characters.perform(typeText("hello@555*ops^9876%cool#plush&eclair"), closeSoftKeyboard());


        textInputEditTextMoreThan30Characters.check(matches(withText("hello@555*ops^9876%cool#plush&eclair")));
        textInputEditTextMoreThan30Characters.perform(clearText());
    }


    @Test
    @Description("Поле пустое")
    @DisplayName("Поле пароль пустое")
    public void PasswordEditTextTheFieldIsEmpty() {
        ViewInteraction textInputEditTextTheFieldIsEmpty = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        textInputEditTextTheFieldIsEmpty.check(matches(isDisplayed()));
        textInputEditTextTheFieldIsEmpty.perform(replaceText(""), closeSoftKeyboard());


        textInputEditTextTheFieldIsEmpty.check(matches(withText("")));
        textInputEditTextTheFieldIsEmpty.perform(clearText());
    }


    @Test
    @Description("Символы введены успешно")
    @DisplayName("Ввод в поле пароль символы на кириллице")
    public void PasswordEditTextCyrillic() {
        ViewInteraction editTextCyrillic = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        editTextCyrillic.check(matches(isDisplayed()));
        editTextCyrillic.perform(replaceText("Привет"), closeSoftKeyboard());
        editTextCyrillic.check(matches(withText("Привет")));
    }


    @Test
    @Description("Вход в аккаунт не успешный")
    @DisplayName("Поле логин пустое, поле пароль заполнено с нажатие на кнопку войти")
    public void PasswordTestError() {
        ViewInteraction testErrorPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        testErrorPassword.check(matches(isDisplayed()));
        testErrorPassword.perform(typeText("password"), closeSoftKeyboard());
        testErrorPassword.check(matches(withText("password")));


        ViewInteraction clickButton = onView(
                allOf(withId(R.id.enter_button)));
        clickButton.check(matches(isDisplayed()));
        clickButton.perform(click());

    }


    @Test
    @Description("Вход в аккаунт не успешный")
    @DisplayName("Поле логин и поле пароль заполнено не верными данными для входа")
    public void LoginAndPasswordTestIncorrect() {
        ViewInteraction testIncorrectLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        testIncorrectLogin.check(matches(isDisplayed()));
        testIncorrectLogin.perform(typeText("logins"), closeSoftKeyboard());
        testIncorrectLogin.check(matches(withText("logins")));

        ViewInteraction testIncorrectPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        testIncorrectPassword.check(matches(isDisplayed()));
        testIncorrectPassword.perform(typeText("passwords"), closeSoftKeyboard());
        testIncorrectPassword.check(matches(withText("passwords")));


        ViewInteraction clickButton = onView(
                allOf(withId(R.id.enter_button)));
        clickButton.check(matches(isDisplayed()));
        clickButton.perform(click());

    }


    @Test
    @Description("Вход в аккаунт не успешный")
    @DisplayName("Поле логин и пароль пустые")
    public void LoginAndPasswordTestEmpty() {
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


        ViewInteraction clickButton = onView(
                allOf(withId(R.id.enter_button)));
        clickButton.check(matches(isDisplayed()));
        clickButton.perform(click());

    }

}
