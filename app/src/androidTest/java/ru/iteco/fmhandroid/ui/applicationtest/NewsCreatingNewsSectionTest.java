package ru.iteco.fmhandroid.ui.applicationtest;

import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.BasicClass;
import ru.iteco.fmhandroid.ui.basic.NewsCreatingNewsSectionBasic;
import ru.iteco.fmhandroid.ui.pageobject.ButtonNewsSteps;
import ru.iteco.fmhandroid.ui.pageobject.InputNewNewsSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageobject.MoveThroughCategoryInCreateEditSteps;
import ru.iteco.fmhandroid.ui.verificationpage.VerificationPage;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCreatingNewsSectionTest extends NewsCreatingNewsSectionBasic {

    ButtonNewsSteps buttonNewsSteps = new ButtonNewsSteps();
    LogOutSteps logOutSteps = new LogOutSteps();
    VerificationPage verificationPage = new VerificationPage();
    InputNewNewsSteps inputNewNewsSteps = new InputNewNewsSteps();
    MoveThroughCategoryInCreateEditSteps moveThroughCategoryInCreateEditSteps = new MoveThroughCategoryInCreateEditSteps();

    @Test
    @DisplayName("Проверка поле Category разделе Creating News")
    @Description("Проверяем поле Category. Проверяем работоспособность выбора категорий")
    public void newsCheckingControlPanelCreatingNewsCheckCategory() {
        moveThroughCategoryInCreateEditSteps.moveThroughCategoryInCreateEdit();
        pressBack();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("Проверка не заполненых полей в разделе Creating News")
    @Description("В разделе Creating News проверка не заполненых полей. Проверка кнопки Cancel")
    public void newsCheckingControlPanelCreatingNewsEmptyFields() {
        buttonNewsSteps.buttonSaveNews();
        verificationPage.checkTextCreating();
        buttonNewsSteps.buttonCancelNews();
        buttonNewsSteps.buttonCancelAlert();
        buttonNewsSteps.buttonCancelNews();
        verificationPage.checkTextAlertLogOut();
        buttonNewsSteps.buttonOkAlert();
        verificationPage.checkTextControlPanel();
        logOutSteps.logOut();
    }

    @Test
    @DisplayName("Проверка полей в разделе Creating News")
    @Description("Проверяем поля на работоспособность и ввод валидных значений.")
    public void newsCheckingControlPanelCreatingNewsFilledFieldsTest() {
        inputNewNewsSteps.inputNewNewsValid();
        buttonNewsSteps.buttonSaveNews();
        logOutSteps.logOut();
    }

}


