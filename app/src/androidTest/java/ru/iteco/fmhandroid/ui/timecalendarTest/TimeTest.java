package ru.iteco.fmhandroid.ui.timecalendarTest;


import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageObject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageObject.DateAndTimeSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationPage.VerificationPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class TimeTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);

        try {
            new VerificationPage().checkViewTextAuthorization();
        } catch (NoMatchingViewException e) {
            new LogOutSteps().logOut();
        }
    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }

    @DisplayName("Ввод валидных значений в поля час и минуты в режиме input mode")
    @Description("Проверяем поля на ввод значений")
    @Test
    public void inputTimeInputModeTest() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().timeInPlanTextInput();
        new DateAndTimeSteps().switchToTextInputMode();
        new VerificationPage().checkText();
        new DateAndTimeSteps().settingTimes();
        new DateAndTimeSteps().settingMinutes();
        new ButtonSteps().buttonOkAlert();
        pressBack();
        new LogOutSteps().logOut();
    }

    @DisplayName("Ввод валидных значений в поля час и минуты в режиме clock mode")
    @Description("Проверяем поля на ввод значений")
    @Test
    public void inputTimeClockModeTest() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().timeInPlanTextInput();
        new DataHelper().changeTimes(15, 30);
        new ButtonSteps().buttonOkAlert();
        pressBack();
        new LogOutSteps().logOut();
    }

    @DisplayName("Ввод случайных значений в поля час и минуты в режиме clock mode")
    @Description("Проверяем поля на ввод значений")
    @Test
    public void inputTimeClockModeRandomTest() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().timeInPlanTextInput();
        new DataHelper().changeRandomTimes();
        new ButtonSteps().buttonOkAlert();
        pressBack();
        new LogOutSteps().logOut();
    }

}
