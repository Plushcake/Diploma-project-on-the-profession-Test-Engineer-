package ru.iteco.fmhandroid.ui.applicationnotvalidtest;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.BasicClass;
import ru.iteco.fmhandroid.ui.pageobject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageobject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageobject.InputNewClaimSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageobject.StatusProcessingImageClaimsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsNotValidCreatingClaimsTest extends BasicClass {

    GoToMainMenuSteps goToMainMenuSteps = new GoToMainMenuSteps();
    LogOutSteps logOutSteps = new LogOutSteps();
    ButtonSteps buttonSteps = new ButtonSteps();
    InputNewClaimSteps inputNewClaimSteps = new InputNewClaimSteps();
    StatusProcessingImageClaimsSteps statusProcessingImageClaimsSteps = new StatusProcessingImageClaimsSteps();

    @Test
    @DisplayName("В разделе Claims. Создание Claims. Ввод не валидных значений в поля")
    @Description("Ввод не валидных значений в поля.")
    public void claimsCreatingClaimsNotValid() {
        goToMainMenuSteps.goToClaims();
        buttonSteps.buttonCreatingClaims();
        inputNewClaimSteps.inputNewClaimNotValid();
        buttonSteps.listRecyclerClaims();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusToExecute();
        statusProcessingImageClaimsSteps.inputTextCommentExecute();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        logOutSteps.logOut();
    }
}
