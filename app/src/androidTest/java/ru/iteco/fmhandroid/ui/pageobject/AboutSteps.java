package ru.iteco.fmhandroid.ui.pageobject;

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

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.Intents;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;

import ru.iteco.fmhandroid.R;

public class AboutSteps {

    private UiDevice device;

    //Нажимаем на Privacy Policy и проверяем переход по url.
    public void clickUrlPrivacyPolicyIntents() {
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

    //Нажимаем на Terms of use и проверяем переход по url.
    public void clickUrlTermsOfUseAndIntents() {
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

    //Переход из браузера в приложение. UiAutomator.
    public void switchingFromBrowserToApp() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressBack();
    }
}
