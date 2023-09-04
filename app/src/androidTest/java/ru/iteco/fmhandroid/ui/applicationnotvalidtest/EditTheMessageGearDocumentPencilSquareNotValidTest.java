package ru.iteco.fmhandroid.ui.applicationnotvalidtest;

//Пункт в тест кейсе № 17

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.EditTheMessageGearDocumentPencilSquareNotValidBasic;
import ru.iteco.fmhandroid.ui.pageobject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageobject.InputNewClaimSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageobject.StatusProcessingImageClaimsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class EditTheMessageGearDocumentPencilSquareNotValidTest extends EditTheMessageGearDocumentPencilSquareNotValidBasic {

    LogOutSteps logOutSteps = new LogOutSteps();
    ButtonSteps buttonSteps = new ButtonSteps();
    InputNewClaimSteps inputNewClaimSteps = new InputNewClaimSteps();
    StatusProcessingImageClaimsSteps statusProcessingImageClaimsSteps = new StatusProcessingImageClaimsSteps();

    @Test
    @DisplayName("Раздел Claims. Сообщение. Статус процесса Throw off и To execute ввод не валидных значений.  ")
    @Description("Ввод не валидных значений в поля для комментариев")
    public void editTheMessageGearDocumentNotValid() {
        statusProcessingImageClaimsSteps.inputTextCommentThrowOffNotValid();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusTakeToWork();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusToExecute();
        statusProcessingImageClaimsSteps.inputTextCommentExecuteNotValid();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("Раздел Claims. Сообщение. Проверяем Editing Claims.")
    @Description("Ввод не валидных значений в поля в разделе Editing Claims")
    public void editTheMessagePencilSquareNotValid() {
        statusProcessingImageClaimsSteps.inputTextCommentThrowOff();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        buttonSteps.buttonEditingClaims();
        inputNewClaimSteps.inputCreatingClaimsNotValid();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusToExecute();
        statusProcessingImageClaimsSteps.inputTextCommentExecute();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        logOutSteps.logOut();
    }
}
