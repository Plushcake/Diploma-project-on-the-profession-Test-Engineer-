package ru.iteco.fmhandroid.ui.applicationtest;

import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.basic.NewsFilterNewsSectionBasic;
import ru.iteco.fmhandroid.ui.pageobject.ButtonNewsSteps;
import ru.iteco.fmhandroid.ui.pageobject.InputNewNewsSteps;
import ru.iteco.fmhandroid.ui.pageobject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageobject.MoveThroughCategoryInFilterNewsSteps;
import ru.iteco.fmhandroid.ui.verificationpage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsFilterNewsSectionTest extends NewsFilterNewsSectionBasic {

    MoveThroughCategoryInFilterNewsSteps throughCategory = new MoveThroughCategoryInFilterNewsSteps();
    ButtonNewsSteps buttonNewsSteps = new ButtonNewsSteps();
    LogOutSteps logOutSteps = new LogOutSteps();
    VerificationPage verificationPage = new VerificationPage();
    InputNewNewsSteps inputNewNewsSteps = new InputNewNewsSteps();

    @Test
    @DisplayName("Проверка поля Category в разделе Filter News")
    @Description("Проверяем категории на выбираемость")
    public void newsCheckingControlPanelFilterNewsCheckCategory() {
        buttonNewsSteps.buttonEditNews();
//        new ButtonNewsSteps().buttonSortNews();
        buttonNewsSteps.buttonFilterNews();//Раздел Filter News.
        verificationPage.checkTextFilterNews();
        throughCategory.moveThroughCategoryInFilterNews();
        buttonNewsSteps.buttonCancelNews();
        logOutSteps.logOut();

    }

    @Test
    @DisplayName("Проверяем поля в разделе Filter news")
    @Description("Проверяем заполнение полей. Проверяем Чек боксы на работоспособность")
    public void newsCheckingControlPanelFilterNews() {
        buttonNewsSteps.buttonEditNews();
        buttonNewsSteps.buttonFilterNews();//Раздел Filter News.
        verificationPage.checkTextFilterNews();
        inputNewNewsSteps.inputFilterValid();
        buttonNewsSteps.checkBoxFilterNewsActive();
        buttonNewsSteps.checkBoxFilterNewsActive();
        buttonNewsSteps.checkBoxFilterNewsInactive();
        buttonNewsSteps.checkBoxFilterNewsInactive();
        buttonNewsSteps.filterButton();
        verificationPage.checkTextControlPanel();
        logOutSteps.logOut();

    }

    @Test
    @DisplayName("Проверка раздела Filter News")
    @Description("Проверка полей на работоспособность")
    public void newsCheckingFilterNews() {
        buttonNewsSteps.buttonFilterNews();//Раздел Filter News.
        verificationPage.checkFilterNews();
        throughCategory.moveThroughCategoryInFilterNews();
        inputNewNewsSteps.inputFilterValid();
        buttonNewsSteps.filterButton();
        buttonNewsSteps.buttonFilterNews();
        buttonNewsSteps.buttonCancelNews();
        logOutSteps.logOut();

    }

    @Test
    @DisplayName("Раздел News проверка кнопок")
    @Description("В разделе News проверяем работоспособность кнопок и переход в разделы")

    public void newsCheckingTheNewsSectionTest() {
        verificationPage.checkTextNews();
        buttonNewsSteps.recyclerViewNews();//раскрытия сообщения с дополнительной информацией
        buttonNewsSteps.buttonFilterNews();//Раздел Filter News.
        verificationPage.checkFilterNews();
        pressBack();
        buttonNewsSteps.buttonEditNews();
        verificationPage.checkNewsListRecycler();
        pressBack();
        buttonNewsSteps.buttonSortNews();//сортировка сообщения по дате добавления.
        buttonNewsSteps.buttonSortNews();//сортировка сообщения по дате добавления.
        logOutSteps.logOut();

    }
}
