package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AuthorizationUiTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void registerIdlingResources() throws InterruptedException {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);
        Thread.sleep(10000);
    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }

    @Test
    public void Authorization() {
        ViewInteraction textView = onView(
                allOf(withText("Authorization"),
                        withParent(withParent(withId(R.id.nav_host_fragment)))));
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("Authorization")));
    }

    @Test
    public void Login() {
        ViewInteraction editText1 = onView(
                allOf(withHint("Login"),
                        withParent(withParent(withId(R.id.login_text_input_layout)))));
        editText1.check(matches(isDisplayed()));
        editText1.check(matches(withHint("Login")));
    }

    @Test
    public void Password() {
        ViewInteraction editText2 = onView(
                allOf(withHint("Password"),
                        withParent(withParent(withId(R.id.password_text_input_layout)))));
        editText2.check(matches(isDisplayed()));
        editText2.check(matches(withHint("Password")));
    }

    @Test
    public void SignIn() {
        ViewInteraction button = onView(
                allOf(withId(R.id.enter_button), withText("SIGN IN"), withContentDescription("Save"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class)))));
        button.check(matches(isDisplayed()));
        button.check(matches(withText("SIGN IN")));
    }

}
