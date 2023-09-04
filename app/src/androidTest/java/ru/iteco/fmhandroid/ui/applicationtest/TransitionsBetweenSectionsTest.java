package ru.iteco.fmhandroid.ui.applicationtest;

import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.BasicClass;
import ru.iteco.fmhandroid.ui.pageobject.ButtonMainSteps;
import ru.iteco.fmhandroid.ui.pageobject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageobject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationpage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class TransitionsBetweenSectionsTest extends BasicClass {

    GoToMainMenuSteps goToMainMenuSteps = new GoToMainMenuSteps();
    LogOutSteps logOutSteps = new LogOutSteps();
    VerificationPage verificationPage = new VerificationPage();
    ButtonSteps buttonSteps = new ButtonSteps();
    ButtonMainSteps buttonMainSteps = new ButtonMainSteps();

    @Test
    @DisplayName("Проверка раздела Love Is All")
    @Description("Проверяем успешный переход в раздел")
    public void loveIsAllTest() {
        buttonMainSteps.buttonLoveIsAll();
        verificationPage.checkTextLoveIsAll();
        buttonSteps.listRecyclerOurMission();
        buttonSteps.listRecyclerOurMission();
        verificationPage.checkOurMission();
        logOutSteps.logOut();

    }

    @Test
    @DisplayName("Проверка перехода между основными разделами.")
    @Description("Переход по разделам Main, Claims, News, About")
    public void mainMenuCheck() {
        goToMainMenuSteps.goToAbout();
        verificationPage.checkAboutPrivacyPolicy();
        buttonMainSteps.buttonBackAbout();
        goToMainMenuSteps.goToNews();
        verificationPage.checkContainerInNews();
        goToMainMenuSteps.goToClaims();
        verificationPage.checkContainerInClaims();
        goToMainMenuSteps.goToMain();
        verificationPage.checkContainerListNews();
        logOutSteps.logOut();

    }

    @Test
    @DisplayName("Проверка на работоспособность кнопки Main menu, our mission и authorization")
    @Description("Прокликивание кнопок Main menu, our mission и authorization")
    public void navigationPanelToSections() {
        goToMainMenuSteps.clickButtonMainMenu();
        pressBack();
        buttonMainSteps.buttonLoveIsAll();
        verificationPage.checkOurMission();
        pressBack();
        logOutSteps.logOut();
    }

}

