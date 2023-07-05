package ru.iteco.fmhandroid.ui.claims;

//Пункт в тест кейсе № 17

import androidx.test.espresso.IdlingRegistry;
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
import ru.iteco.fmhandroid.ui.pageObject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.InputNewClaimSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageObject.StatusProcessingImageClaimsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class EditTheMessageGearDocumentNotValidTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);
    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }

    @Test
    @DisplayName("Раздел Claims. Сообщение. Статус процесса Throw off и To execute ввод не валидных згачений.  ")
    @Description("Ввод не валидных значений в поля для комментариев")
    public void editTheMessageGearDocumentNotValid() {
        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new InputNewClaimSteps().inputNewClaimValid();
        new ButtonSteps().listRecyclerClaims();
        new ButtonSteps().buttonStatusClaims();
        new StatusProcessingImageClaimsSteps().statusThrowOff();
        new StatusProcessingImageClaimsSteps().inputTextCommentThrowOffNotValid();
        new StatusProcessingImageClaimsSteps().buttonSaveComment();
        new ButtonSteps().buttonStatusClaims();
        new StatusProcessingImageClaimsSteps().statusTakeToWork();
        new ButtonSteps().buttonStatusClaims();
        new StatusProcessingImageClaimsSteps().statusToExecute();
        new StatusProcessingImageClaimsSteps().inputTextCommentExecuteNotValid();
        new StatusProcessingImageClaimsSteps().buttonSaveComment();
        new LogOutSteps().logOut();
    }
}
