package ru.iteco.fmhandroid.ui.applicationtest;

import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.BasicClass;
import ru.iteco.fmhandroid.ui.basic.EditTimeSectionBasic;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageobject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageobject.DateAndTimeSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class EditCalendarSectionTest extends EditTimeSectionBasic {

    LogOutSteps logOutSteps = new LogOutSteps();
    DataHelper dataHelper = new DataHelper();
    ButtonSteps buttonSteps = new ButtonSteps();
    DateAndTimeSteps dateAndTimeSteps = new DateAndTimeSteps();

    @Test
    @DisplayName("В разделе установки даты проверяем работоспособность кнопки Ok")
    public void testTheOkButton() {
        buttonSteps.buttonOkAlert();
        pressBack();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("В разделе установки даты проверяем работоспособность кнопки Cancel")
    public void testTheCancelButton() {
        buttonSteps.buttonCancelAlert();
        pressBack();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("В разделе установки/изменения даты проверяем изменение года, месяца и дня")
    public void testChangeOfDay() {
        dataHelper.changeЕheYearMonthOfTheDay(2023, 11, 15);
        buttonSteps.buttonOkAlert();
        pressBack();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("В разделе установки/изменения даты проверяем изменение года, месяца и дня, случайными данными.")
    public void testRandomChangeOfDay() {
        dataHelper.changeRandomЕheYearMonthOfTheDayFaker();
        buttonSteps.buttonOkAlert();
        pressBack();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("В разделе установки/изменения даты проверяем работоспособность переключения месяца")
    public void changesOfTheMonth() {
        dateAndTimeSteps.nextMonth();
        dateAndTimeSteps.previousMonth();
        buttonSteps.buttonOkAlert();
        pressBack();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("В разделе установки даты проверяем работоспособность выбора года")
    public void changesOfTheYear() {
        dateAndTimeSteps.choiceOfTheYear();
        dateAndTimeSteps.listOfYears();
        buttonSteps.buttonOkAlert();
        pressBack();
        logOutSteps.logOut();
    }

}


