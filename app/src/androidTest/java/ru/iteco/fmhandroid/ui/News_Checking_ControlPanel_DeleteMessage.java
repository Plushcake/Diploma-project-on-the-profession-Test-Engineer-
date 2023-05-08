package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
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
public class News_Checking_ControlPanel_DeleteMessage {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void news_Checking_ControlPanel_DeleteMessage() throws InterruptedException {
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

        ViewInteraction textViewControlPanelAndStep1 = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        textViewControlPanelAndStep1.check(matches(isDisplayed()));
        textViewControlPanelAndStep1.perform(pressKey(61), pressKey(61), pressKey(61), pressKey(61), pressKey(61),
                pressKey(61), pressKey(61), pressKey(61), pressKey(66));


        ViewInteraction textViewCheck1 = onView(
                anyOf(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future."),
                        withText("Вы уверены, что хотите безвозвратно удалить документ? Данные изменения нельзя будет отменить в будущем.")));
        textViewCheck1.check(matches(isDisplayed()));

        ViewInteraction checkCancel = onView(
                allOf(withId(android.R.id.button2)));
        checkCancel.check(matches(isDisplayed()));

        ViewInteraction checkOk = onView(
                allOf(withId(android.R.id.button1)));
        checkOk.check(matches(isDisplayed()));

        ViewInteraction clickCancel = onView(
                allOf(withId(android.R.id.button2)));
        clickCancel.perform(scrollTo(), click());

        ViewInteraction textViewControlPanelAndStep2 = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        textViewControlPanelAndStep2.check(matches(isDisplayed()));
        textViewControlPanelAndStep2.perform(pressKey(61), pressKey(61), pressKey(61), pressKey(61), pressKey(61),
                pressKey(61), pressKey(61), pressKey(61), pressKey(66));

        ViewInteraction textViewCheck2 = onView(
                anyOf(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future."),
                        withText("Вы уверены, что хотите безвозвратно удалить документ? Данные изменения нельзя будет отменить в будущем.")));
        textViewCheck2.check(matches(isDisplayed()));

        ViewInteraction clickOk = onView(
                allOf(withId(android.R.id.button1)));
        clickOk.check(matches(isDisplayed()));
        clickOk.perform(scrollTo(), click());

        ViewInteraction textViewControlPanel = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        textViewControlPanel.check(matches(isDisplayed()));

        Thread.sleep(1000);

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
