package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

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
public class AuthorizationTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void appActivityTest() throws InterruptedException {
        Thread.sleep(10000);
        ViewInteraction textInputEditText = onView(
                allOf(withHint("Login")));
        textInputEditText.check(matches(isDisplayed()));
        textInputEditText.perform(typeText("login2"), closeSoftKeyboard());


        ViewInteraction textInputEditText2 = onView(
                allOf(withHint("Password")));
        textInputEditText2.check(matches(isDisplayed()));
        textInputEditText2.perform(replaceText("password2"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.enter_button)));
        materialButton.check(matches(isDisplayed()));
        materialButton.perform(click());

        Thread.sleep(5000);

        ViewInteraction textView = onView(
                allOf(withText("News"),
                        withParent(withParent(withId(R.id.container_list_news_include_on_fragment_main)))));
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("News")));
    }

}
