package ru.iteco.fmhandroid.ui.applicationnotvalidtest;

import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.TimeNotValidBasic;
import ru.iteco.fmhandroid.ui.pageobject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageobject.DateAndTimeSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationpage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class TimeNotValidTest extends TimeNotValidBasic {

    LogOutSteps logOutSteps = new LogOutSteps();
    ButtonSteps buttonSteps = new ButtonSteps();
    DateAndTimeSteps dateAndTimeSteps = new DateAndTimeSteps();
    VerificationPage verificationPage = new VerificationPage();

    @DisplayName("Ввод не валидных значений в поле время в режиме input mode")
    @Description("Проверяем вывод предупреждающего сообщения")
    @Test
    public void inputNotValidTimeTest() {
        dateAndTimeSteps.settingTimesNotValid();
        buttonSteps.buttonOkAlert();
        verificationPage.checkTextAlert();
        buttonSteps.buttonCancelAlert();
        pressBack();
        logOutSteps.logOut();
    }

    @DisplayName("Ввод не валидных значений в поле минуты в режиме input mode")
    @Description("Проверяем вывод предупреждающего сообщения")
    @Test
    public void inputNotValidMinutesTest() {
        dateAndTimeSteps.settingMinutesNotValid();
        buttonSteps.buttonOkAlert();
        verificationPage.checkTextAlert();
        buttonSteps.buttonCancelAlert();
        pressBack();
        logOutSteps.logOut();
    }

    @DisplayName("Ввод не валидных значений в поля время и минуты в режиме input mode")
    @Description("Проверяем вывод предупреждающего сообщения")
    @Test
    public void inputNotValidTimeAndMinutesTest() {
        dateAndTimeSteps.settingTimesNotValid();
        dateAndTimeSteps.settingMinutesNotValid();
        buttonSteps.buttonOkAlert();
        verificationPage.checkTextAlert();
        buttonSteps.buttonCancelAlert();
        pressBack();
        logOutSteps.logOut();
    }
}
