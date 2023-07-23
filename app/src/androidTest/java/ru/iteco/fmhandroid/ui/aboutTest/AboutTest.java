package ru.iteco.fmhandroid.ui.aboutTest;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageObject.ButtonMainSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationPage.VerificationPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AboutTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);

        try {
            new VerificationPage().checkViewTextAuthorization();
        } catch (NoMatchingViewException e) {
            new LogOutSteps().logOut();
        }
    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }

    @Test
    public void aboutPrivacyPolicyTest() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToAbout();
        new ButtonMainSteps().buttonBackAbout();
        new GoToMainMenuSteps().goToAbout();

        ViewInteraction textCheckPrivacy = onView(
                allOf(withId(R.id.about_privacy_policy_label_text_view)));
        textCheckPrivacy.check(matches(isDisplayed()));

        ViewInteraction clickUrlPrivacyPolicy = onView(
                allOf(withId(R.id.about_privacy_policy_value_text_view)));
        clickUrlPrivacyPolicy.check(matches(isDisplayed()));
        //Проверяем Url.
        Intents.init();
        clickUrlPrivacyPolicy.perform(click());
        intended(hasData("https://vhospice.org/#/privacy-policy/"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }

    @Test
    public void aboutTermsOfUseTest() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToAbout();

        ViewInteraction textCheckTerms = onView(
                allOf(withId(R.id.about_terms_of_use_label_text_view)));
        textCheckTerms.check(matches(isDisplayed()));

        ViewInteraction clickUrlTermsOfUse = onView(
                allOf(withId(R.id.about_terms_of_use_value_text_view)));
        clickUrlTermsOfUse.check(matches(isDisplayed()));
        //Проверяем Url.
        Intents.init();
        clickUrlTermsOfUse.perform(click());
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();
    }

}
