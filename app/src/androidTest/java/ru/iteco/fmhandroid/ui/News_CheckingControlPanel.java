package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 21

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.scrollTo;
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
public class News_CheckingControlPanel {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void news_CheckingControlPanel() throws InterruptedException {
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
        Thread.sleep(5000);

        ViewInteraction clickDeleteNewsListStep = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        clickDeleteNewsListStep.check(matches(isDisplayed()));
        clickDeleteNewsListStep.perform(pressKey(61), pressKey(61), pressKey(61),
                pressKey(61), pressKey(61), pressKey(61));
        Thread.sleep(1000);
        clickDeleteNewsListStep.perform(pressKey(61), pressKey(61), pressKey(66));
        Thread.sleep(2000);

        ViewInteraction textView = onView(
                anyOf(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future."),
                        withText("Вы уверены, что хотите безвозвратно удалить документ? Данные изменения нельзя будет отменить в будущем.")));
        textView.check(matches(isDisplayed()));

        ViewInteraction clickCancelMessage = onView(
                allOf(withId(android.R.id.button2)));
        clickCancelMessage.perform(scrollTo(), click());

        ViewInteraction clickEditNewsListStep = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        clickEditNewsListStep.check(matches(isDisplayed()));
        clickEditNewsListStep.perform(pressKey(61), pressKey(61), pressKey(61),
                pressKey(61), pressKey(61), pressKey(61));
        Thread.sleep(1000);
        clickEditNewsListStep.perform(pressKey(61), pressKey(61), pressKey(61), pressKey(66));
        Thread.sleep(2000);

        ViewInteraction checkTextEditing = onView(
                anyOf(withText("Editing"), withText("Редактирование")));
        checkTextEditing.check(matches(isDisplayed()));

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
