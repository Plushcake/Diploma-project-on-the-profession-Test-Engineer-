package ru.iteco.fmhandroid.ui.applicationtest;

import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.BasicClass;
import ru.iteco.fmhandroid.ui.basic.NewsEditingNewsSectionBasic;
import ru.iteco.fmhandroid.ui.pageobject.ButtonNewsSteps;
import ru.iteco.fmhandroid.ui.pageobject.InputNewNewsSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageobject.MoveThroughCategoryInCreateEditSteps;
import ru.iteco.fmhandroid.ui.verificationpage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsEditingNewsSectionTest extends NewsEditingNewsSectionBasic {

    ButtonNewsSteps buttonNewsSteps = new ButtonNewsSteps();
    LogOutSteps logOutSteps = new LogOutSteps();
    VerificationPage verificationPage = new VerificationPage();
    InputNewNewsSteps inputNewNewsSteps = new InputNewNewsSteps();
    MoveThroughCategoryInCreateEditSteps moveThroughCategoryInCreateEditSteps = new MoveThroughCategoryInCreateEditSteps();

    @Test
    @DisplayName("Проверка поля Title в разделе Editing News")
    @Description("Проверяем полe Title и выбор категорий в поле Category.")
    public void checkItemCategory() {
        verificationPage.checkTextEditing();
        moveThroughCategoryInCreateEditSteps.moveThroughCategoryInCreateEdit();
        pressBack();
        logOutSteps.logOut();

    }

    @Test
    @DisplayName("Проверка полей в разделе Editing News")
    @Description("Вводим в поля валидные значения")
    public void CreateMessage() {
        inputNewNewsSteps.inputNewNewsValid();
        buttonNewsSteps.switchActive();
        verificationPage.checkTextSwitchNotActive();
        buttonNewsSteps.switchActive();
        verificationPage.checkTextSwitchActive();
        buttonNewsSteps.buttonSaveNews();
        logOutSteps.logOut();

    }
}
