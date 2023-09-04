package ru.iteco.fmhandroid.ui.basic;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageobject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageobject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageobject.InputNewClaimSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageobject.StatusProcessingImageClaimsSteps;
import ru.iteco.fmhandroid.ui.verificationpage.VerificationPage;

public class EditTheMessageGearDocumentPencilSquareNotValidBasic {

    VerificationPage authorizationPage = new VerificationPage();
    LogOutSteps logOutSteps = new LogOutSteps();
    GoToMainMenuSteps goToMainMenuSteps = new GoToMainMenuSteps();
    DataHelper dataHelper = new DataHelper();
    ButtonSteps buttonSteps = new ButtonSteps();
    InputNewClaimSteps inputNewClaimSteps = new InputNewClaimSteps();
    StatusProcessingImageClaimsSteps statusProcessingImageClaimsSteps = new StatusProcessingImageClaimsSteps();


    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);

        try {
            authorizationPage.checkViewTextAuthorization();
        } catch (NoMatchingViewException e) {
            logOutSteps.logOut();
        }

        dataHelper.logIn();
        goToMainMenuSteps.goToClaims();
        buttonSteps.buttonCreatingClaims();
        inputNewClaimSteps.inputNewClaimValid();
        buttonSteps.listRecyclerClaims();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusThrowOff();
    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }
}
