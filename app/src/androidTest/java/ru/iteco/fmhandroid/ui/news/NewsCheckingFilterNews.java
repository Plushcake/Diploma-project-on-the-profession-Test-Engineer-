package ru.iteco.fmhandroid.ui.news;

//Пункт в тест кейсе № 20

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
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
import ru.iteco.fmhandroid.ui.data.MoveThroughCategoryInFilterNews;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCheckingFilterNews {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Проверка раздела Filter News")
    @Description("Проверка полей на работоспособность")
    public void newsCheckingFilterNews() throws InterruptedException {
        new LogIn().logIn();
        ViewInteraction clickMainMenu = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu.check(matches(isDisplayed()));
        clickMainMenu.perform(click());
        Thread.sleep(1000);

        ViewInteraction clickNews = onView(
                anyOf(withText("News"), withText("Новости")));
        clickNews.check(matches(isDisplayed()));
        clickNews.perform(click());
        Thread.sleep(2000);

        ViewInteraction clickFilterNews1 = onView(
                allOf(withId(R.id.filter_news_material_button)));
        clickFilterNews1.check(matches(isDisplayed()));
        clickFilterNews1.perform(click());

        ViewInteraction checkTextView = onView(
                allOf(withId(R.id.filter_news_title_text_view)));
        checkTextView.check(matches(isDisplayed()));

        ViewInteraction checkViewCategory = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        checkViewCategory.check(matches(isDisplayed()));

        new MoveThroughCategoryInFilterNews().moveThroughCategoryInFilterNews();

        Thread.sleep(2000);

        ViewInteraction inputDate1 = onView(
                allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text)));
        inputDate1.check(matches(isDisplayed()));
        inputDate1.perform(replaceText("01.04.2023"));

        ViewInteraction inputDate2 = onView(
                allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text)));
        inputDate2.check(matches(isDisplayed()));
        inputDate2.perform(replaceText("01.05.2023"));
        Thread.sleep(2000);

        ViewInteraction clickFilter = onView(
                allOf(withId(R.id.filter_button)));
        clickFilter.check(matches(isDisplayed()));
        clickFilter.perform(click());
        Thread.sleep(3000);

        ViewInteraction clickFilterNews2 = onView(
                allOf(withId(R.id.filter_news_material_button)));
        clickFilterNews2.perform(click());

        ViewInteraction clickCancel = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel.check(matches(isDisplayed()));
        clickCancel.perform(click());

        new LogOut().logOut();

    }

}
