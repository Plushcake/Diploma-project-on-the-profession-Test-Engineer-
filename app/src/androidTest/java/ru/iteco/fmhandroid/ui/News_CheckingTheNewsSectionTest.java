package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 19

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class News_CheckingTheNewsSectionTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void news_CheckingTheNewsSectionTest() throws InterruptedException {
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

        ViewInteraction clickMain = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMain.check(matches(isDisplayed()));
        clickMain.perform(click());

        ViewInteraction clickNews = onView(
                anyOf(withText("News"), withText("Новости")));
        clickNews.check(matches(isDisplayed()));
        clickNews.perform(click());
        Thread.sleep(3000);

        ViewInteraction clickRecyclerViewNews = onView(
                allOf(withId(R.id.news_list_recycler_view)));
        clickRecyclerViewNews.perform(actionOnItemAtPosition(0, click()));
        Thread.sleep(2000);
        //Не закрывается вкладка.
        ViewInteraction clickRecyclerViewNews2 = onView(
                allOf(withId(R.id.news_list_recycler_view)));
        clickRecyclerViewNews2.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction clickSortNews1 = onView(
                allOf(withId(R.id.sort_news_material_button)));
        clickSortNews1.check(matches(isDisplayed()));
        clickSortNews1.perform(click());
        Thread.sleep(2000);

        ViewInteraction clickSortNews2 = onView(
                allOf(withId(R.id.sort_news_material_button)));
        clickSortNews2.check(matches(isDisplayed()));
        clickSortNews2.perform(click());
        Thread.sleep(2000);

        ViewInteraction clickFilterNews = onView(
                allOf(withId(R.id.filter_news_material_button)));
        clickFilterNews.check(matches(isDisplayed()));
        clickFilterNews.perform(click());
        Thread.sleep(2000);

        ViewInteraction checkFilterText = onView(
                allOf(withId(R.id.filter_news_title_text_view)));
        checkFilterText.check(matches(isDisplayed()));
        Thread.sleep(2000);

        pressBack();

        ViewInteraction clickEditNews = onView(
                allOf(withId(R.id.edit_news_material_button)));
        clickEditNews.check(matches(isDisplayed()));
        clickEditNews.perform(click());

        ViewInteraction checkNewsListRecycler = onView(
                allOf(withId(R.id.news_list_recycler_view)));
        checkNewsListRecycler.check(matches(isDisplayed()));
        Thread.sleep(2000);

        pressBack();


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
