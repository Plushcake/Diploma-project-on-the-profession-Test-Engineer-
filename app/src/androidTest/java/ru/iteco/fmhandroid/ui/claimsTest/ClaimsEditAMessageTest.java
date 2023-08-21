package ru.iteco.fmhandroid.ui.claimsTest;

//Пункт в тест кейсе № 12.


import static androidx.test.espresso.Espresso.pressBack;


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
import ru.iteco.fmhandroid.ui.pageObject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageObject.FilterSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.InputNewClaimSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationPage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsEditAMessageTest {

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
    @DisplayName("Раздел Claims. Проверка редактирования сообщения")
    public void claimsEditAMessageTest() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();

        new FilterSteps().buttonFilter();
        new FilterSteps().filterProgress();
        new FilterSteps().buttonOk();

        new ButtonSteps().listRecyclerClaims();
        new ButtonSteps().buttonAddCommentClaims();
        new ButtonSteps().buttonCancelInAddCommentClaims();
        new ButtonSteps().buttonClickBack();
        new ButtonSteps().listRecyclerClaims();
        new ButtonSteps().buttonStatusClaims();
        pressBack();
        new ButtonSteps().buttonEditingClaims();
        new ButtonSteps().buttonCancelInAddCommentClaims();
        new ButtonSteps().buttonOkAlert();
        new ButtonSteps().buttonClickBack();
        new ButtonSteps().listRecyclerClaims();
        new ButtonSteps().buttonAddCommentClaims();
        new InputNewClaimSteps().inputComment();
        new ButtonSteps().buttonSaveCommentClaims();
        new ButtonSteps().claimCommentsListRecycler();
        new ButtonSteps().buttonCancelCreatingClaims();
        new ButtonSteps().buttonClickBack();
        new LogOutSteps().logOut();
    }

}
