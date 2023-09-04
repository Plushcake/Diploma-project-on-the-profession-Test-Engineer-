package ru.iteco.fmhandroid.ui.applicationtest;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.BasicClass;
import ru.iteco.fmhandroid.ui.pageobject.ButtonMainSteps;
import ru.iteco.fmhandroid.ui.pageobject.ButtonNewsSteps;
import ru.iteco.fmhandroid.ui.pageobject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageobject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationpage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainSectionTest extends BasicClass {

    GoToMainMenuSteps goToMainMenuSteps = new GoToMainMenuSteps();
    ButtonNewsSteps buttonNewsSteps = new ButtonNewsSteps();
    LogOutSteps logOutSteps = new LogOutSteps();
    VerificationPage verificationPage = new VerificationPage();
    ButtonSteps buttonSteps = new ButtonSteps();
    ButtonMainSteps buttonMainSteps = new ButtonMainSteps();

    @Test
    @DisplayName("Проверка раздела Main")
    @Description("В разделе Main переходим между разделами")
    public void mainTest() {
        verificationPage.checkContainerListNews();
        buttonMainSteps.containerListDoubleTapNews();
        buttonNewsSteps.recyclerViewNews();
        buttonMainSteps.newsListDoubleTapRecycler();
        buttonMainSteps.buttonAllNews();
        goToMainMenuSteps.goToMain();
        buttonMainSteps.containerListDoubleTapClaims();
        buttonSteps.buttonCreatingClaims();
        buttonSteps.buttonCancelCreatingClaims();
        buttonSteps.buttonOkAlert();
        buttonMainSteps.containerListNews();
        buttonMainSteps.buttonAllClaims();
        verificationPage.checkContainerInClaims();
        goToMainMenuSteps.goToMain();
        buttonMainSteps.containerListNews();
        buttonMainSteps.claimsListRecycler();
        buttonSteps.buttonClickBack();
        logOutSteps.logOut();
    }

}
