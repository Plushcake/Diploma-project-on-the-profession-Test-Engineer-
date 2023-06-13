package ru.iteco.fmhandroid.ui.news;

//Пункт в тест кейсе № 22

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
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
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageObject.MoveThroughCategoryInFilterNewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCheckingControlPanelFilterNewsCheckCategoryTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Проверка поля Category в разделе Filter News")
    @Description("Проверяем категории на выбираемость")
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

        new MoveThroughCategoryInFilterNewsSteps().moveThroughCategoryInFilterNews();

        ViewInteraction clickCancel =
                onView(withId(R.id.cancel_button));
        clickCancel.perform(click());

        Thread.sleep(1000);

        new LogOutSteps().logOut();

    }


}
