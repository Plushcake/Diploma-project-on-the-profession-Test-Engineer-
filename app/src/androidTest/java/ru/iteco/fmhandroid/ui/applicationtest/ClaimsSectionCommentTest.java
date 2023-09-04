package ru.iteco.fmhandroid.ui.applicationtest;

import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.ClaimsSectionCommentBasic;
import ru.iteco.fmhandroid.ui.pageobject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageobject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageobject.InputNewClaimSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageobject.StatusProcessingImageClaimsSteps;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsSectionCommentTest extends ClaimsSectionCommentBasic {

    LogOutSteps logOutSteps = new LogOutSteps();
    ButtonSteps buttonSteps = new ButtonSteps();
    InputNewClaimSteps inputNewClaimSteps = new InputNewClaimSteps();
    StatusProcessingImageClaimsSteps statusProcessingImageClaimsSteps = new StatusProcessingImageClaimsSteps();

    @Test
    @DisplayName("В разделе Claims проверяем Add comment")
    @Description("В поле комментарий введены валидные значения")
    public void claimsAddCommentTest() {
        buttonSteps.buttonAddCommentClaims();
        buttonSteps.buttonCancelInAddCommentClaims();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusThrowOff();
        statusProcessingImageClaimsSteps.inputTextCommentThrowOff();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        buttonSteps.buttonStatusClaims();
        //pressBack();
        //new ButtonSteps().buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusCancel();
        pressBack();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("Раздел Claims. Проверка редактирования комментария")
    public void claimsEditAMessageTest() {
        buttonSteps.claimCommentsListRecycler();
        buttonSteps.buttonCancelCreatingClaims();
        buttonSteps.claimCommentsListRecycler();//Редактирование комментария.
        inputNewClaimSteps.inputCommentFaker();
        buttonSteps.buttonSaveCommentClaims();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusToExecute();
        statusProcessingImageClaimsSteps.inputTextCommentExecute();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        buttonSteps.buttonClickBack();
        logOutSteps.logOut();
    }

}
