package ru.iteco.fmhandroid.ui.applicationtest;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.ClaimsSectionBasic;
import ru.iteco.fmhandroid.ui.basic.ClaimsStatusSectionBasic;
import ru.iteco.fmhandroid.ui.pageobject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageobject.FilterSteps;
import ru.iteco.fmhandroid.ui.pageobject.InputNewClaimSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageobject.StatusProcessingImageClaimsSteps;
import ru.iteco.fmhandroid.ui.verificationpage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsSectionTest extends ClaimsSectionBasic {

    LogOutSteps logOutSteps = new LogOutSteps();
    VerificationPage verificationPage = new VerificationPage();
    ButtonSteps buttonSteps = new ButtonSteps();
    InputNewClaimSteps inputNewClaimSteps = new InputNewClaimSteps();
    StatusProcessingImageClaimsSteps statusProcessingImageClaimsSteps = new StatusProcessingImageClaimsSteps();
    FilterSteps filterSteps = new FilterSteps();

    @Test
    @DisplayName("Раздел Claims. Проходимся по всем разделам.")
    @Description("Прокликивание в Claims-е всех разделов")
    public void claimsTest() {
        filterSteps.buttonFilter();
        verificationPage.checkTextFilteringInFilter();
        filterSteps.buttonCancel();
        buttonSteps.buttonCreatingClaims();
        verificationPage.checkTextCreatingClaims();
        buttonSteps.buttonCancelCreatingClaims();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        buttonSteps.listRecyclerClaims();
        verificationPage.checkButtonStatus();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("Проверяем фильтрацию сообщений.")
    @Description("Проверяем работоспособность каждого пункта.")
    public void claimsFilteringCheck() {
        filterSteps.buttonFilter();
        filterSteps.filterOpen();
        filterSteps.filterProgress();
        filterSteps.buttonOk();
        filterSteps.buttonFilter();
        filterSteps.filterOpen();
        filterSteps.filterProgress();
        filterSteps.filterExecuted();
        filterSteps.filterCancelled();
        filterSteps.buttonOk();
        filterSteps.buttonFilter();
        verificationPage.checkButtonCancelInFilter();
        filterSteps.buttonCancel();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("Раздел Claims. Создание Claims. Заполнение полей валидными значениями. Проверка предупреждающих сообщений")
    @Description("Поля заполнены валидными значениями. Claims создается успешно.")
    public void claimsCreatingClaimsTest() {
        buttonSteps.buttonCreatingClaims();
        inputNewClaimSteps.inputNewClaimValid();
        buttonSteps.listRecyclerClaims();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusThrowOff();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        statusProcessingImageClaimsSteps.inputTextCommentThrowOff();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusCancel();
        buttonSteps.buttonClickBack();
        buttonSteps.buttonCreatingClaims();
        buttonSteps.buttonCancelCreatingClaims();
        verificationPage.checkTextAlertLogOut();
        buttonSteps.buttonOkAlert();
        verificationPage.checkTextCreatingClaims();
        buttonSteps.buttonCreatingClaims();
        buttonSteps.buttonCancelCreatingClaims();
        buttonSteps.buttonCancelAlert();
        buttonSteps.buttonCancelCreatingClaims();
        buttonSteps.buttonOkAlert();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("Раздел Claims. Проверяем раздел Editing Claims")
    @Description("Ввод в поля валидные значения")
    public void claimsEditMessageEditClaims() {
        buttonSteps.buttonCreatingClaims();
        inputNewClaimSteps.inputNewClaimValid();
        buttonSteps.listRecyclerClaims();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusThrowOff();
        statusProcessingImageClaimsSteps.inputTextCommentThrowOff();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        verificationPage.checkStatusOpen();
        buttonSteps.buttonEditingClaims();
        buttonSteps.buttonCancelCreatingClaims();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        buttonSteps.buttonEditingClaims();//Редактирование Claims
        inputNewClaimSteps.inputCreatingClaims();
        buttonSteps.buttonStatusClaims();
        statusProcessingImageClaimsSteps.statusToExecute();
        statusProcessingImageClaimsSteps.inputTextCommentExecute();
        statusProcessingImageClaimsSteps.buttonSaveComment();
        logOutSteps.logOut();
    }

}
