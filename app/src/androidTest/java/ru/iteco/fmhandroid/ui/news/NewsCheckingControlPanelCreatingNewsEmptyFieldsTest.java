package ru.iteco.fmhandroid.ui.news;

//Пункт в тест кейсе № 23

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
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

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class NewsCheckingControlPanelCreatingNewsEmptyFieldsTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Проверка не заполненых полей в разделе Creating News")
    @Description("В разделе Creating News проверка не заполненых полей. Проверка кнопки Cancel")
    public void newsCheckingControlPanelCreatingNews() throws InterruptedException {
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

        ViewInteraction clickAddNews = onView(
                allOf(withId(R.id.add_news_image_view)));
        clickAddNews.check(matches(isDisplayed()));
        clickAddNews.perform(click());

        ViewInteraction clickSave = onView(
                allOf(withId(R.id.save_button)));
        clickSave.check(matches(isDisplayed()));
        clickSave.perform(click());

        ViewInteraction checkText = onView(
                anyOf(withText("Creating"), withText("Создание")));
        checkText.check(matches(isDisplayed()));
        checkText.perform(click());


        ViewInteraction clickCancelCreatingNews1 = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancelCreatingNews1.perform(scrollTo());
        clickCancelCreatingNews1.check(matches(isDisplayed()));
        clickCancelCreatingNews1.perform(click());
        Thread.sleep(2000);

        ViewInteraction clickCancelText = onView(
                allOf(withId(android.R.id.button2)));
        clickCancelText.perform(scrollTo(), click());

        Thread.sleep(2000);
        ViewInteraction clickCancelCreatingNews2 = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancelCreatingNews2.check(matches(isDisplayed()));
        clickCancelCreatingNews2.perform(scrollTo(), click());

        ViewInteraction textCheck = onView(
                anyOf(withText("The changes won't be saved, do you really want to log out?"),
                        withText("Изменения не будут сохранены. Вы действительно хотите выйти?")));
        textCheck.check(matches(isDisplayed()));
        Thread.sleep(2000);

        ViewInteraction clickOkText = onView(
                allOf(withId(android.R.id.button1)));
        clickOkText.check(matches(isDisplayed()));
        clickOkText.perform(scrollTo(), click());


        ViewInteraction checkViewControlPanel = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        checkViewControlPanel.check(matches(isDisplayed()));

        Thread.sleep(2000);

        new LogOutSteps().logOut();

    }
}


