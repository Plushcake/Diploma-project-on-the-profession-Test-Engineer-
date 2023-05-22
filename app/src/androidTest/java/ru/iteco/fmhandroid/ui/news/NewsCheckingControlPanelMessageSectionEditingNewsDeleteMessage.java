package ru.iteco.fmhandroid.ui.news;
//Пункт в тест кейсе № 25

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
import ru.iteco.fmhandroid.ui.data.ClickDeleteNewsListStep;
import ru.iteco.fmhandroid.ui.data.ClickEditNewsListStep;
import ru.iteco.fmhandroid.ui.data.LogIn;
import ru.iteco.fmhandroid.ui.data.LogOut;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class NewsCheckingControlPanelMessageSectionEditingNewsDeleteMessage {
    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Проверка кнопки cancel удаление сообщения")
    @Description("Проверка кнопки Cancel в разделе Editing News. Удаление сообщения.")
    public void DeleteMessage() throws InterruptedException {
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

        ViewInteraction clickEditingNews = onView(
                allOf(withId(R.id.edit_news_material_button)));
        clickEditingNews.check(matches(isDisplayed()));
        clickEditingNews.perform(click());

        Thread.sleep(2000);

        new ClickEditNewsListStep().clickEditNewsListStep();

        ViewInteraction clickCancelEditing = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancelEditing.check(matches(isDisplayed()));
        clickCancelEditing.perform(scrollTo(), click());

        ViewInteraction clickCancelMessage = onView(
                allOf(withId(android.R.id.button2)));
        clickCancelMessage.check(matches(isDisplayed()));
        clickCancelMessage.perform(scrollTo(), click());

        ViewInteraction clickCancelEditing2 = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancelEditing2.check(matches(isDisplayed()));
        clickCancelEditing2.perform(scrollTo(), click());

        ViewInteraction checkTextMessage = onView(
                anyOf(withText("The changes won't be saved, do you really want to log out?"),
                        withText("Изменения не будут сохранены. Вы действительно хотите выйти?")));
        checkTextMessage.check(matches(isDisplayed()));

        Thread.sleep(2000);

        ViewInteraction clickOkMessage = onView(
                allOf(withId(android.R.id.button1)));
        clickOkMessage.check(matches(isDisplayed()));
        clickOkMessage.perform(scrollTo(), click());

        Thread.sleep(1000);

        new ClickDeleteNewsListStep().clickDeleteNewsListStep();

        ViewInteraction checkMessageDelete = onView(
                anyOf(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future."),
                        withText("Вы уверены, что хотите безвозвратно удалить документ? Данные изменения нельзя будет отменить в будущем.")));
        checkMessageDelete.check(matches(isDisplayed()));

        Thread.sleep(2000);

        ViewInteraction clickCancelMessageDelete = onView(
                allOf(withId(android.R.id.button2)));
        clickCancelMessageDelete.check(matches(isDisplayed()));
        clickCancelMessageDelete.perform(scrollTo(), click());

        Thread.sleep(1000);

        new ClickDeleteNewsListStep().clickDeleteNewsListStep();

        ViewInteraction checkMessageDelete2 = onView(
                anyOf(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future."),
                        withText("Вы уверены, что хотите безвозвратно удалить документ? Данные изменения нельзя будет отменить в будущем.")));
        checkMessageDelete2.check(matches(isDisplayed()));

        Thread.sleep(2000);

        ViewInteraction clickOkMessageDelete = onView(
                allOf(withId(android.R.id.button1)));
        clickOkMessageDelete.check(matches(isDisplayed()));
        clickOkMessageDelete.perform(scrollTo(), click());

        Thread.sleep(3000);

        new LogOut().logOut();
    }


}
