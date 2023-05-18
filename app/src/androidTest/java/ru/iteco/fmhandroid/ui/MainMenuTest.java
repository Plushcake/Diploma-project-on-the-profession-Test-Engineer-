package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 4

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
@RunWith(AllureAndroidJUnit4.class)
public class MainMenuTest {


    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Проверка перехода между основными разделами.")
    @Description("Переход по разделам Main, Claims, News, About")
    public void mainMenuCheck() throws InterruptedException {
        Thread.sleep(7000);

        ViewInteraction EnteringLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        EnteringLogin.perform(typeText("login2"), closeSoftKeyboard());

        ViewInteraction EnteringPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        EnteringPassword.perform(typeText("password2"), closeSoftKeyboard());

        ViewInteraction clickButton = onView(
                allOf(withId(R.id.enter_button)));
        clickButton.perform(click());


        Thread.sleep(3000);


        ViewInteraction clickMainMenu1 = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu1.check(matches(isDisplayed()));
        clickMainMenu1.perform(click());

        ViewInteraction clickAbout = onView(
                anyOf(withText("About"), withText("О приложении")));
        clickAbout.check(matches(isDisplayed()));
        clickAbout.perform(click());


        ViewInteraction checkAbout = onView(
                allOf(withId(R.id.about_privacy_policy_label_text_view)));
        checkAbout.check(matches(isDisplayed()));

        Thread.sleep(2000);

        ViewInteraction clickBack = onView(
                allOf(withId(R.id.about_back_image_button)));
        clickBack.check(matches(isDisplayed()));
        clickBack.perform(click());


        ViewInteraction clickMainMenu2 = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu2.check(matches(isDisplayed()));
        clickMainMenu2.perform(click());


        ViewInteraction clickNews = onView(
                anyOf(withText("News"), withText("Новости")));
        clickNews.check(matches(isDisplayed()));
        clickNews.perform(click());

        Thread.sleep(2000);

        ViewInteraction checkNews = onView(
                allOf(withId(R.id.container_list_news_include)));
        checkNews.check(matches(isDisplayed()));

        ViewInteraction clickMainMenu3 = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu3.check(matches(isDisplayed()));
        clickMainMenu3.perform(click());


        ViewInteraction clickClaims = onView(
                anyOf(withText("Claims"), withText("Заявки")));
        clickClaims.check(matches(isDisplayed()));
        clickClaims.perform(click());

        Thread.sleep(2000);

        ViewInteraction checkClaims = onView(
                allOf(withId(R.id.container_list_claim_include)));
        checkClaims.check(matches(isDisplayed()));

        ViewInteraction clickMainMenu4 = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu4.check(matches(isDisplayed()));
        clickMainMenu4.perform(click());


        ViewInteraction clickMain = onView(
                anyOf(withText("Main"), withText("Главная")));
        clickMain.check(matches(isDisplayed()));
        clickMain.perform(click());

        Thread.sleep(2000);

        ViewInteraction checkMain = onView(
                allOf(withId(R.id.container_list_news_include_on_fragment_main)));
        checkMain.check(matches(isDisplayed()));

        ViewInteraction clickAuthorization = onView(
                allOf(withId(R.id.authorization_image_button)));
        clickAuthorization.check(matches(isDisplayed()));
        clickAuthorization.perform(click());


        ViewInteraction textViewLogOutTest = onView(
                anyOf(withText("Log out"), withText("Выйти")));
        textViewLogOutTest.check(matches(isDisplayed()));
        textViewLogOutTest.perform(click());
    }


}
