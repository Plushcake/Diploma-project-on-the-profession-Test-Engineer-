package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AppActivityTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void ThreadSleep() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Test
    public void appActivityTest() {
        ViewInteraction textInputEditTextNumber = onView(
                allOf(withHint("Login")));
        textInputEditTextNumber.perform(replaceText("1234567890"), closeSoftKeyboard());

        ViewInteraction checkNumber = onView(
                allOf(withText("1234567890"), withHint("Login")));
        checkNumber.check(matches(withText("1234567890")));
        checkNumber.perform(clearText());


        ViewInteraction textInputEditTextLatin = onView(
                allOf(withHint("Login")));
        textInputEditTextLatin.perform(replaceText("hello"));

        ViewInteraction checkLatin = onView(
                allOf(withText("hello"), withHint("Login")));
        checkLatin.check(matches(withText("hello")));
        checkLatin.perform(clearText());


        ViewInteraction textInputEditTextSpecialCharacters = onView(
                allOf(withHint("Login")));
        textInputEditTextSpecialCharacters.perform(replaceText("!@#$%^&*()"));

        ViewInteraction checkSpecialCharacters = onView(
                allOf(withText("!@#$%^&*()"), withHint("Login")));
        checkSpecialCharacters.check(matches(withText("!@#$%^&*()")));
        checkSpecialCharacters.perform(clearText());


        ViewInteraction textInputEditTextMoreThan30Characters = onView(
                allOf(withHint("Login")));
        textInputEditTextMoreThan30Characters.perform(replaceText("hello@555*ops^9876%cool#plush&eclair"));

        ViewInteraction checkTextMoreThan30Characters = onView(
                allOf(withText("hello@555*ops^9876%cool#plush&eclair"), withHint("Login")));
        checkTextMoreThan30Characters.check(matches(withText("hello@555*ops^9876%cool#plush&eclair")));
        checkTextMoreThan30Characters.perform(clearText());


        ViewInteraction textInputEditTextTheFieldIsEmpty = onView(
                allOf(withHint("Login")));
        textInputEditTextTheFieldIsEmpty.perform(replaceText(""));

        ViewInteraction checkTheFieldIsEmpty = onView(
                allOf(withText(""), withHint("Login")));
        checkTheFieldIsEmpty.check(matches(withText("")));
        checkTheFieldIsEmpty.perform(clearText());

        ViewInteraction clickButton = onView(
                allOf(withId(R.id.enter_button), withText("Sign in")));
        clickButton.check(matches(isDisplayed()));
        clickButton.perform(click());

        ViewInteraction imageView = onView(
                allOf(withContentDescription("app background image"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));
    }

}
