package ru.iteco.fmhandroid.ui.transitionsbetweensectionsTest;

//Пункт в тест кейсе № 7

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageObject.ButtonMainSteps;
import ru.iteco.fmhandroid.ui.pageObject.ButtonNewsSteps;
import ru.iteco.fmhandroid.ui.pageObject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationPage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainTest {

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
    @DisplayName("Проверка раздела Main")
    @io.qameta.allure.kotlin.Description("В разделе Main переходим между разделами")
    public void mainTest() {
        new DataHelper().logIn();
        new VerificationPage().checkContainerListNews();
        new ButtonMainSteps().containerListNews();
        new ButtonMainSteps().containerListNews();
        new ButtonNewsSteps().recyclerViewNews();
        new ButtonMainSteps().newsListRecycler();
        new ButtonMainSteps().newsListRecycler();
        new ButtonMainSteps().buttonAllNews();
        new GoToMainMenuSteps().goToMain();
        new ButtonMainSteps().containerListClaims();
        new ButtonMainSteps().containerListClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().buttonCancelCreatingClaims();
        new ButtonSteps().buttonOkAlert();
        new ButtonMainSteps().containerListNews();
        new ButtonMainSteps().buttonAllClaims();
        new VerificationPage().checkContainerInClaims();
        new GoToMainMenuSteps().goToMain();
        new ButtonMainSteps().containerListNews();
        new ButtonMainSteps().claimsListRecycler();
        new ButtonSteps().buttonClickBack();
        new LogOutSteps().logOut();

    }

}
