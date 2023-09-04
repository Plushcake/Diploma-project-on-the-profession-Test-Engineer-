package ru.iteco.fmhandroid.ui.applicationtest;

import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.BasicClass;
import ru.iteco.fmhandroid.ui.basic.ClaimsStatusSectionBasic;
import ru.iteco.fmhandroid.ui.pageobject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageobject.InputNewClaimSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageobject.StatusProcessingImageClaimsSteps;
import ru.iteco.fmhandroid.ui.verificationpage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsStatusSectionTest extends ClaimsStatusSectionBasic {

    LogOutSteps logOutSteps = new LogOutSteps();
    VerificationPage verificationPage = new VerificationPage();
    ButtonSteps buttonSteps = new ButtonSteps();
    InputNewClaimSteps inputNewClaimSteps = new InputNewClaimSteps();
    StatusProcessingImageClaimsSteps statusProcessingImageClaimsSteps = new StatusProcessingImageClaimsSteps();

    @Test
    @DisplayName("Раздел Claims. Проверяем в сообщении кнопку статус процесса. Проверяем Throw off")
    @Description("Работоспособность пункта Throw off")
    public void ClaimsEditMessageChangeStatusTrowOff() {
        verificationPage.checkStatusInProgress();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusThrowOff();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        statusProcessingImageClaimsSteps.buttonCancelComment();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusThrowOff();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        inputNewClaimSteps.inputCommentStatus();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        verificationPage.checkStatusOpen();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusCancel();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("Раздел Claims. Проверяем в сообщении кнопку статус процесса. Проверяем To execute")
    @Description("Работоспособность пункта To execute")
    public void ClaimsEditMessageChangeStatusToExecute() {
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusToExecute();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        statusProcessingImageClaimsSteps.buttonCancelComment();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusToExecute();
        inputNewClaimSteps.inputCommentStatus();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        verificationPage.checkStatusExecuted();
        pressBack();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("Раздел Claims. Проверяем в сообщении кнопку статус процесса. Проверяем Cancel")
    @Description("Работоспособность пункта Cancel")
    public void ClaimsEditMessageChangeStatusCancel() {
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusThrowOff();
        statusProcessingImageClaimsSteps.inputTextCommentThrowOff();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        verificationPage.checkStatusOpen();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusCancel();
        verificationPage.checkStatusCancel();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("Раздел Claims. Проверяем в сообщении кнопку статус процесса. Проверяем Take to work")
    @Description("Работоспособность пункта Take to work")
    public void ClaimsEditMessageChangeStatusTakeToWork() {
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusThrowOff();
        statusProcessingImageClaimsSteps.inputTextCommentThrowOff();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusTakeToWork();
        verificationPage.checkStatusInProgress();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusToExecute();
        statusProcessingImageClaimsSteps.inputTextCommentExecute();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        buttonSteps.buttonClickBack();
        logOutSteps.logOut();
    }
}
