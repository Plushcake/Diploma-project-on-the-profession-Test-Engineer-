package ru.iteco.fmhandroid.ui.about;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.core.AllOf.allOf;

import android.content.Intent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class About {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    //public IntentsTestRule intentsTestRule = new IntentsTestRule(AppActivity.class);

    @Test
    public void aboutTest1() throws InterruptedException {
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

        ViewInteraction clickAbout = onView(
                anyOf(withText("About"), withText("О приложении")));
        clickAbout.check(matches(isDisplayed()));
        clickAbout.perform(click());

        ViewInteraction clickBackCheckBack = onView(
                allOf(withId(R.id.about_back_image_button)));
        clickBackCheckBack.check(matches(isDisplayed()));
        clickBackCheckBack.perform(click());

        ViewInteraction clickMainMenuCheckBack = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenuCheckBack.check(matches(isDisplayed()));
        clickMainMenuCheckBack.perform(click());
        Thread.sleep(1000);

        ViewInteraction clickAboutCheckBack = onView(
                anyOf(withText("About"), withText("О приложении")));
        clickAboutCheckBack.check(matches(isDisplayed()));
        clickAboutCheckBack.perform(click());

        ViewInteraction textCheckView1 = onView(
                allOf(withId(R.id.about_privacy_policy_label_text_view)));
        textCheckView1.check(matches(isDisplayed()));

        ViewInteraction textCheckView2 = onView(
                allOf(withId(R.id.about_terms_of_use_label_text_view)));
        textCheckView2.check(matches(isDisplayed()));

        ViewInteraction clickUrlPrivacyPolicy = onView(
                allOf(withId(R.id.about_privacy_policy_value_text_view)));
        clickUrlPrivacyPolicy.check(matches(isDisplayed()));
//        //Проверяем Url.
        Intents.init();
        clickUrlPrivacyPolicy.perform(click());
        intended(hasData("https://vhospice.org/#/privacy-policy/"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();


//        ViewInteraction clickUrlTermsOfUse = onView(
//                allOf(withId(R.id.about_terms_of_use_value_text_view)));
//        clickUrlTermsOfUse.check(matches(isDisplayed()));
//        Intents.init();
//        clickUrlTermsOfUse.perform(click());
//        intended(hasData("https://vhospice.org/#/terms-of-use"));
//        intended(hasAction(Intent.ACTION_VIEW));
//        Intents.release();

//        ViewInteraction clickBack = onView(
//                allOf(withId(R.id.about_back_image_button)));
//        clickBack.check(matches(isDisplayed()));
//        clickBack.perform(click());
//
//        Thread.sleep(1000);
//
//        ViewInteraction clickAuthorization = onView(
//                allOf(withId(R.id.authorization_image_button)));
//        clickAuthorization.check(matches(isDisplayed()));
//        clickAuthorization.perform(click());
//
//
//        ViewInteraction textViewLogOutTest = onView(
//                anyOf(withText("Log out"), withText("Выйти")));
//        textViewLogOutTest.check(matches(isDisplayed()));
//        textViewLogOutTest.perform(click());
    }

    @Test
    public void aboutTest2() throws InterruptedException {
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

        ViewInteraction clickAbout = onView(
                anyOf(withText("About"), withText("О приложении")));
        clickAbout.check(matches(isDisplayed()));
        clickAbout.perform(click());


        ViewInteraction textCheckView1 = onView(
                allOf(withId(R.id.about_privacy_policy_label_text_view)));
        textCheckView1.check(matches(isDisplayed()));

        ViewInteraction textCheckView2 = onView(
                allOf(withId(R.id.about_terms_of_use_label_text_view)));
        textCheckView2.check(matches(isDisplayed()));
//        //Проверяем Url.
        ViewInteraction clickUrlTermsOfUse = onView(
                allOf(withId(R.id.about_terms_of_use_value_text_view)));
        clickUrlTermsOfUse.check(matches(isDisplayed()));
        Intents.init();
        clickUrlTermsOfUse.perform(click());
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        intended(hasAction(Intent.ACTION_VIEW));
        Intents.release();

    }

}
