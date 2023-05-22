package ru.iteco.fmhandroid.ui.news;

//Пункт в тест кейсе № 19

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
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
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.LogIn;
import ru.iteco.fmhandroid.ui.data.LogOut;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCheckingTheNewsSectionTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Раздел News проверка кнопок")
    @Description("В разделе News проверяем работоспособность кнопок и переход в разделы")

    public void newsCheckingTheNewsSectionTest() throws InterruptedException {
        new LogIn().logIn();
        ViewInteraction clickMain = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMain.check(matches(isDisplayed()));
        clickMain.perform(click());

        ViewInteraction clickNews = onView(
                anyOf(withText("News"), withText("Новости")));
        clickNews.check(matches(isDisplayed()));
        clickNews.perform(click());


        ViewInteraction checkTextNews = onView(
                anyOf(withText("News"), withText("Новости")));
        checkTextNews.check(matches(isDisplayed()));

        ViewInteraction clickRecyclerViewNews = onView(
                allOf(withId(R.id.news_list_recycler_view)));
        clickRecyclerViewNews.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction clickRecyclerViewNews2 = onView(
                allOf(withId(R.id.news_list_recycler_view)));
        clickRecyclerViewNews2.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction clickSortNews1 = onView(
                allOf(withId(R.id.sort_news_material_button)));
        clickSortNews1.check(matches(isDisplayed()));
        clickSortNews1.perform(click());

        ViewInteraction clickSortNews2 = onView(
                allOf(withId(R.id.sort_news_material_button)));
        clickSortNews2.check(matches(isDisplayed()));
        clickSortNews2.perform(click());

        ViewInteraction clickFilterNews = onView(
                allOf(withId(R.id.filter_news_material_button)));
        clickFilterNews.check(matches(isDisplayed()));
        clickFilterNews.perform(click());

        ViewInteraction checkFilterText = onView(
                allOf(withId(R.id.filter_news_title_text_view)));
        checkFilterText.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction clickEditNews = onView(
                allOf(withId(R.id.edit_news_material_button)));
        clickEditNews.check(matches(isDisplayed()));
        clickEditNews.perform(click());

        ViewInteraction checkNewsListRecycler = onView(
                allOf(withId(R.id.news_list_recycler_view)));
        checkNewsListRecycler.check(matches(isDisplayed()));

        pressBack();

        new LogOut().logOut();

    }

}
