package ru.iteco.fmhandroid.ui.applicationnotvalidtest;
//Пункт в тест кейсе № 13_1


import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.ClaimsNotValidAddCommentBasic;
import ru.iteco.fmhandroid.ui.pageobject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageobject.InputNewClaimSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageobject.StatusProcessingImageClaimsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsNotValidAddCommentTest extends ClaimsNotValidAddCommentBasic {

    LogOutSteps logOutSteps = new LogOutSteps();
    ButtonSteps buttonSteps = new ButtonSteps();
    InputNewClaimSteps inputNewClaimSteps = new InputNewClaimSteps();
    StatusProcessingImageClaimsSteps statusProcessingImageClaimsSteps = new StatusProcessingImageClaimsSteps();

    @Test
    @DisplayName("В разделе Claims проверка Add comment не валидными значениями. Латиница и цифры")
    @Description("Символы вводятся")
    public void claimsAddCommentTest50More() {
        inputNewClaimSteps.addCommentTestMore50();
        buttonSteps.buttonSaveCommentClaims();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusToExecute();
        statusProcessingImageClaimsSteps.inputTextCommentExecute();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("В разделе Claims проверка Add comment не валидными значениями. Кириллица, цифры и спец символы.")
    @Description("Символы вводятся")
    public void claimsAddCommentTestCyrillic() {
        inputNewClaimSteps.addCommentTestCyrillic();
        buttonSteps.buttonSaveCommentClaims();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusToExecute();
        statusProcessingImageClaimsSteps.inputTextCommentExecute();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("В разделе Claims проверка Add comment не валидными значениями. Латиница и специальные символы")
    @Description("Символы вводятся")
    public void claimsAddCommentTestSpecialCharacter() {
        inputNewClaimSteps.addCommentTestSpecialCharacter();
        buttonSteps.buttonSaveCommentClaims();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusToExecute();
        statusProcessingImageClaimsSteps.inputTextCommentExecute();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        logOutSteps.logOut();
    }

}
