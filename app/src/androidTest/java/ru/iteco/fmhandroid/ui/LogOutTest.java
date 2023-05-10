package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 6

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
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
public class LogOutTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void logOutTest() throws InterruptedException {
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

        ViewInteraction clickAuthorization = onView(
                allOf(withId(R.id.authorization_image_button)));
        clickAuthorization.check(matches(isDisplayed()));
        clickAuthorization.perform(click());

        ViewInteraction textViewLogOutTest = onView(
                anyOf(withText("Log out"), withText("Выйти")));
        textViewLogOutTest.check(matches(isDisplayed()));
        textViewLogOutTest.perform(click());

        ViewInteraction EnteringLogin1 = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        EnteringLogin1.perform(typeText("login2"), closeSoftKeyboard());

        ViewInteraction EnteringPassword1 = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        EnteringPassword1.perform(typeText("password2"), closeSoftKeyboard());

        ViewInteraction clickButton1 = onView(
                allOf(withId(R.id.enter_button)));
        clickButton1.perform(click());

        Thread.sleep(3000);

        ViewInteraction clickAuthorization2 = onView(
                allOf(withId(R.id.authorization_image_button)));
        clickAuthorization2.check(matches(isDisplayed()));
        clickAuthorization2.perform(click());


        ViewInteraction textViewLogOutTest2 = onView(
                anyOf(withText("Log out"), withText("Выйти")));
        textViewLogOutTest2.check(matches(isDisplayed()));
        textViewLogOutTest2.perform(click());
    }


}
