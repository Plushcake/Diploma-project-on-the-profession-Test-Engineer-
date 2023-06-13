package ru.iteco.fmhandroid.ui.news;

//Пункт в тест кейсе № 21

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
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
import ru.iteco.fmhandroid.ui.pageObject.ClickDeleteNewsListSteps;
import ru.iteco.fmhandroid.ui.pageObject.ClickEditNewsListSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCheckingControlPanelTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Проверяем раздел Control Panel.")
    @Description("В разделе Control Panel проверяем переходы в подразделы")
    public void newsCheckingControlPanel() throws InterruptedException {
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

        ViewInteraction clickEditNews = onView(
                allOf(withId(R.id.edit_news_material_button)));
        clickEditNews.check(matches(isDisplayed()));
        clickEditNews.perform(click());

        ViewInteraction checkControlPanel = onView(
                allOf(withId(R.id.news_list_recycler_view)));
        checkControlPanel.check(matches(isDisplayed()));

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

        ViewInteraction checkFilterNews = onView(
                allOf(withId(R.id.filter_news_title_text_view)));
        checkFilterNews.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction clickAddNews = onView(
                allOf(withId(R.id.add_news_image_view)));
        clickAddNews.check(matches(isDisplayed()));
        clickAddNews.perform(click());

        ViewInteraction checkTextCreating = onView(
                allOf(withId(R.id.custom_app_bar_title_text_view)));
        checkTextCreating.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction clickRecyclerView1 = onView(
                allOf(withId(R.id.news_list_recycler_view)));
        clickRecyclerView1.perform(actionOnItemAtPosition(0, click()));
        Thread.sleep(2000);

        ViewInteraction clickRecyclerView2 = onView(
                allOf(withId(R.id.news_list_recycler_view)));
        clickRecyclerView2.perform(actionOnItemAtPosition(0, click()));
        Thread.sleep(2000);

        new ClickDeleteNewsListSteps().clickDeleteNewsListStep();

        ViewInteraction textView = onView(
                anyOf(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future."),
                        withText("Вы уверены, что хотите безвозвратно удалить документ? Данные изменения нельзя будет отменить в будущем.")));
        textView.check(matches(isDisplayed()));

        ViewInteraction clickCancelMessage = onView(
                allOf(withId(android.R.id.button2)));
        clickCancelMessage.perform(scrollTo(), click());
        Thread.sleep(2000);

        new ClickEditNewsListSteps().clickEditNewsListStep();

        ViewInteraction checkTextEditing = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        checkTextEditing.check(matches(isDisplayed()));

        pressBack();

        new LogOutSteps()
                .logOut();
    }


}
