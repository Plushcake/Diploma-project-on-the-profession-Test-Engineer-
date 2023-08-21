package ru.iteco.fmhandroid.ui.claimsTest;

//Пункт в тест кейсе № 14

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
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageObject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.InputNewClaimSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageObject.StatusProcessingImageClaimsSteps;
import ru.iteco.fmhandroid.ui.verificationPage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsEditMessageChangeStatusInProgress1Test {

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
    @DisplayName("Раздел Claims. Проверяем в сообщении кнопку статус процесса. Проверяем Throw off")
    @Description("Работоспособность пункта Throw off")
    public void ClaimsEditMessageChangeStatusTrowOff() {

        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new InputNewClaimSteps().inputNewClaimValid();
        new ButtonSteps().listRecyclerClaims();
        new VerificationPage().checkStatusInProgress();
        new ButtonSteps().buttonStatusClaims();
        new StatusProcessingImageClaimsSteps().statusThrowOff();
        new StatusProcessingImageClaimsSteps().buttonSaveComment();
        new StatusProcessingImageClaimsSteps().buttonCancelComment();
        new ButtonSteps().buttonStatusClaims();
        new StatusProcessingImageClaimsSteps().statusThrowOff();
        new StatusProcessingImageClaimsSteps().buttonSaveComment();
        new InputNewClaimSteps().inputCommentStatus();
        new StatusProcessingImageClaimsSteps().buttonSaveComment();
        new VerificationPage().checkStatusOpen();
        new ButtonSteps().buttonStatusClaims();
        new StatusProcessingImageClaimsSteps().statusCancel();
        new LogOutSteps().logOut();

    }
}
