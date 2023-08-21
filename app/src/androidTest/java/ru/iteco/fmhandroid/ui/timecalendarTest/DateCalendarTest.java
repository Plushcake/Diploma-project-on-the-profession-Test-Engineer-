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
public class DateCalendarTest {

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

    @Test
    @DisplayName("В разделе установки/изменения даты проверяем изменение года, месяца и дня")
    public void testChangeOfDay() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().dateInPlanTextInput();
        new DataHelper().changeЕheYearMonthOfTheDay(2023, 11, 15);
        new ButtonSteps().buttonOkAlert();
        pressBack();
        new LogOutSteps().logOut();
    }

    @Test
    @DisplayName("В разделе установки/изменения даты проверяем изменение года, месяца и дня, случайными данными.")
    public void testRandomChangeOfDay() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().dateInPlanTextInput();
        new DataHelper().changeRandomЕheYearMonthOfTheDayFaker();
        new ButtonSteps().buttonOkAlert();
        pressBack();
        new LogOutSteps().logOut();
    }

    @Test
    @DisplayName("В разделе установки/изменения даты проверяем работоспособность переключения месяца")
    public void changesOfTheMonth() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().dateInPlanTextInput();
        new DateAndTimeSteps().nextMonth();
        new DateAndTimeSteps().previousMonth();
        new ButtonSteps().buttonOkAlert();
        pressBack();
        new LogOutSteps().logOut();
    }

    @Test
    @DisplayName("В разделе установки даты проверяем работоспособность выбора года")
    public void changesOfTheYear() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().dateInPlanTextInput();
        new DateAndTimeSteps().choiceOfTheYear();
        new DateAndTimeSteps().listOfYears();
        new ButtonSteps().buttonOkAlert();
        pressBack();
        new LogOutSteps().logOut();
    }

}
