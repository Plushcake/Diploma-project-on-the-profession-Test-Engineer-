package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 1

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
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
public class AuthorizationTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    //Ввести в cmd команду allure serve
    @Test
    @DisplayName("Проверка авторизации пользователя")
    @Description("Вход в аккаунт успешный")
    public void EnterAuthorizationTest() throws InterruptedException {
        Thread.sleep(7000);

        ViewInteraction checkTextAuthorization = onView(
                anyOf(withText("Authorization"), withText("Авторизация")));
        checkTextAuthorization.check(matches(isDisplayed()));

        ViewInteraction checkTextHintLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        checkTextHintLogin.check(matches(isDisplayed()));

        ViewInteraction checkTextHintPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        checkTextHintPassword.check(matches(isDisplayed()));

        ViewInteraction checkTextButtonSignIn = onView(
                anyOf(withText("Sign in"), withText("Войти")));
        checkTextButtonSignIn.check(matches(isDisplayed()));

        Thread.sleep(1000);

        ViewInteraction EnteringLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        EnteringLogin.check(matches(isDisplayed()));
        EnteringLogin.perform(typeText("login2"), closeSoftKeyboard());
        EnteringLogin.check(matches(withText("login2")));

        ViewInteraction EnteringPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        EnteringPassword.check(matches(isDisplayed()));
        EnteringPassword.perform(typeText("password2"), closeSoftKeyboard());
        EnteringPassword.check(matches(withText("password2")));

        ViewInteraction clickButton = onView(
                allOf(withId(R.id.enter_button)));
        clickButton.check(matches(isDisplayed()));
        clickButton.perform(click());


        Thread.sleep(3000);


        ViewInteraction textViewNews = onView(
                allOf(withId(R.id.container_list_news_include_on_fragment_main)));
        textViewNews.check(matches(isDisplayed()));
        textViewNews.check(matches(withId(R.id.container_list_news_include_on_fragment_main)));


        ViewInteraction clickAuthorization = onView(
                allOf(withId(R.id.authorization_image_button)));
        clickAuthorization.check(matches(isDisplayed()));
        clickAuthorization.perform(click());


        ViewInteraction textViewLogOutTest = onView(
                allOf(withId(android.R.id.title)));
        textViewLogOutTest.check(matches(isDisplayed()));
        textViewLogOutTest.perform(click());
    }
}
