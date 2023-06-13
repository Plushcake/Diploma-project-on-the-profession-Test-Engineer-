package ru.iteco.fmhandroid.ui.news;
//Пункт в тест кейсе № 22

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;
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
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class NewsCheckingControlPanelFilterNewsTest {


    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("проверяем поля в разделе Filter news")
    @Description("Проверяем заполнение полей. Проверяем Чек боксы на работоспособность")
    public void newsControlPanelFilterNews() throws InterruptedException {
        new LogInSteps().logIn();
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

        ViewInteraction clickControlPanel = onView(
                allOf(withId(R.id.edit_news_material_button)));
        clickControlPanel.check(matches(isDisplayed()));
        clickControlPanel.perform(click());

        ViewInteraction clickSort1 = onView(
                allOf(withId(R.id.sort_news_material_button)));
        clickSort1.check(matches(isDisplayed()));
        clickSort1.perform(click());

        ViewInteraction clickSort2 = onView(
                allOf(withId(R.id.sort_news_material_button)));
        clickSort2.check(matches(isDisplayed()));
        clickSort2.perform(click());

        ViewInteraction clickFilterNews = onView(
                allOf(withId(R.id.filter_news_material_button)));
        clickFilterNews.check(matches(isDisplayed()));
        clickFilterNews.perform(click());

        ViewInteraction checkText = onView(
                anyOf(withText("Filter news"), withText("Фильтровать новости")));
        checkText.check(matches(isDisplayed()));

        ViewInteraction clickCategory1 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory1.check(matches(isDisplayed()));
        clickCategory1.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory1 =
                onView(withText("Объявление"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickCategory1.check(matches(withText("Объявление")));
        Thread.sleep(1000);

        ViewInteraction clickData1 = onView(
                allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text)));
        clickData1.perform(replaceText("01.04.2023"));
        Thread.sleep(1000);

        ViewInteraction clickData2 = onView(
                allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text)));
        clickData2.perform(replaceText("01.05.2023"));
        Thread.sleep(2000);

        ViewInteraction materialCheckBoxActive = onView(
                allOf(withId(R.id.filter_news_active_material_check_box)));
        materialCheckBoxActive.check(matches(isDisplayed()));
        materialCheckBoxActive.perform(click());

        Thread.sleep(1000);

        ViewInteraction materialCheckBoxActive2 = onView(
                allOf(withId(R.id.filter_news_active_material_check_box)));
        materialCheckBoxActive2.check(matches(isDisplayed()));
        materialCheckBoxActive2.perform(click());

        Thread.sleep(1000);

        ViewInteraction materialCheckBoxNotActive = onView(
                allOf(withId(R.id.filter_news_inactive_material_check_box)));
        materialCheckBoxNotActive.check(matches(isDisplayed()));
        materialCheckBoxNotActive.perform(click());

        Thread.sleep(1000);

        ViewInteraction materialCheckBoxNotActive2 = onView(
                allOf(withId(R.id.filter_news_inactive_material_check_box)));
        materialCheckBoxNotActive2.check(matches(isDisplayed()));
        materialCheckBoxNotActive2.perform(click());

        Thread.sleep(2000);

        ViewInteraction clickFilter = onView(
                allOf(withId(R.id.filter_button)));
        clickFilter.check(matches(isDisplayed()));
        clickFilter.perform(click());

        Thread.sleep(3000);

        ViewInteraction checkText1 = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        checkText1.check(matches(isDisplayed()));

        ViewInteraction clickFilterNews2 = onView(
                anyOf(withId(R.id.filter_news_material_button)));
        clickFilterNews2.check(matches(isDisplayed()));
        clickFilterNews2.perform(click());

        Thread.sleep(2000);

        ViewInteraction checkText2 = onView(
                anyOf(withText("Filter news"), withText("Фильтровать новости")));
        checkText2.check(matches(isDisplayed()));


        ViewInteraction clickCancel = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel.perform(click());

        ViewInteraction checkNews = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        checkNews.check(matches(isDisplayed()));

        Thread.sleep(2000);

        new LogOutSteps().logOut();

    }

}
