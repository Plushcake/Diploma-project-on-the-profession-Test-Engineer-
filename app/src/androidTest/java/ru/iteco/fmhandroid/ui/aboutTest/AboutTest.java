package ru.iteco.fmhandroid.ui.aboutTest;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageObject.AboutSteps;
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
    @DisplayName("В разделе About проверяем переход по ссылке, Privacy Policy.")
    public void aboutPrivacyPolicyTest() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToAbout();
        new VerificationPage().idCheckAboutPrivacyPolicy();
        new AboutSteps().clickUrlPrivacyPolicyIntents();
        new AboutSteps().switchingFromBrowserToApp();
        new ButtonMainSteps().buttonBackAbout();
        new LogOutSteps().logOut();
    }


    @Test
    @DisplayName("В разделе About проверяем переход по ссылке, Terms Of Use.")
    public void aboutTermsOfUseTest() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToAbout();
        new VerificationPage().idCheckAboutTermsOfUse();
        new AboutSteps().clickUrlTermsOfUseAndIntents();
        new AboutSteps().switchingFromBrowserToApp();
        new ButtonMainSteps().buttonBackAbout();
        new LogOutSteps().logOut();
    }

    @Test
    @DisplayName("В разделе About проверяем кнопку, назад.")
    public void checkButtonBack() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToAbout();
        new ButtonMainSteps().buttonBackAbout();
        new LogOutSteps().logOut();
    }

}
