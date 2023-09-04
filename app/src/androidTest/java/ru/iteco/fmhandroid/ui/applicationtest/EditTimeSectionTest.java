package ru.iteco.fmhandroid.ui.applicationtest;

import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.EditTimeSectionBasic;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageobject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageobject.DateAndTimeSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationpage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class EditTimeSectionTest extends EditTimeSectionBasic {

    LogOutSteps logOutSteps = new LogOutSteps();
    VerificationPage verificationPage = new VerificationPage();
    DataHelper dataHelper = new DataHelper();
    ButtonSteps buttonSteps = new ButtonSteps();
    DateAndTimeSteps dateAndTimeSteps = new DateAndTimeSteps();

    @DisplayName("Нажимаем на кнопку отмены в режиме input mode")
    @Description("Проверяем работоспособность кнопки ok")
    @Test
    public void buttonCancelTest() {
        dateAndTimeSteps.switchToTextInputMode();
        verificationPage.checkText();
        buttonSteps.buttonOkAlert();
        pressBack();
        logOutSteps.logOut();
    }

    @DisplayName("Нажимаем на кнопку хорошо в режиме input mode")
    @Description("Проверяем работоспособность кнопки cancel")
    @Test
    public void buttonOkTest() {
        dateAndTimeSteps.switchToTextInputMode();
        verificationPage.checkText();
        buttonSteps.buttonCancelAlert();
        pressBack();
        logOutSteps.logOut();
    }

    @DisplayName("Переходим из двух режимом часов. Input mode и clock mode")
    @Description("Проверяем работоспособность кнопки смены режимов часов")
    @Test
    public void switchClockMode() {
        dateAndTimeSteps.switchToTextInputMode();
        verificationPage.checkText();
        dateAndTimeSteps.switchToTextClockMode();
        buttonSteps.buttonCancelAlert();
        pressBack();
        logOutSteps.logOut();
    }

    @DisplayName("Ввод валидных значений в поля час и минуты в режиме input mode")
    @Description("Проверяем поля на ввод значений")
    @Test
    public void inputTimeInputModeTest() {
        dateAndTimeSteps.switchToTextInputMode();
        verificationPage.checkText();
        dateAndTimeSteps.settingTimes();
        dateAndTimeSteps.settingMinutes();
        buttonSteps.buttonOkAlert();
        pressBack();
        logOutSteps.logOut();
    }

    @DisplayName("Ввод валидных значений в поля час и минуты в режиме clock mode")
    @Description("Проверяем поля на ввод значений")
    @Test
    public void inputTimeClockModeTest() {
        dataHelper.changeTimes(15, 30);
        buttonSteps.buttonOkAlert();
        pressBack();
        logOutSteps.logOut();
    }

    @DisplayName("Ввод случайных значений в поля час и минуты в режиме clock mode")
    @Description("Проверяем поля на ввод значений")
    @Test
    public void inputTimeClockModeRandomTest() {
        dataHelper.changeRandomTimes();
        buttonSteps.buttonOkAlert();
        pressBack();
        logOutSteps.logOut();
    }
}
