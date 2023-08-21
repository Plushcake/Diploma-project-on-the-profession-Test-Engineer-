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
public class TimeNotValidTest {

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

    @DisplayName("Ввод не валидных значений в поле время в режиме input mode")
    @Description("Проверяем вывод предупреждающего сообщения")
    @Test
    public void inputNotValidTimeTest() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().timeInPlanTextInput();
        new DateAndTimeSteps().switchToTextInputMode();
        new VerificationPage().checkText();
        new DateAndTimeSteps().settingTimesNotValid();
        new ButtonSteps().buttonOkAlert();
        new VerificationPage().checkTextAlert();
        new ButtonSteps().buttonCancelAlert();
        pressBack();
        new LogOutSteps().logOut();
    }

    @DisplayName("Ввод не валидных значений в поле минуты в режиме input mode")
    @Description("Проверяем вывод предупреждающего сообщения")
    @Test
    public void inputNotValidMinutesTest() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().timeInPlanTextInput();
        new DateAndTimeSteps().switchToTextInputMode();
        new VerificationPage().checkText();
        new DateAndTimeSteps().settingMinutesNotValid();
        new ButtonSteps().buttonOkAlert();
        new VerificationPage().checkTextAlert();
        new ButtonSteps().buttonCancelAlert();
        pressBack();
        new LogOutSteps().logOut();
    }

    @DisplayName("Ввод не валидных значений в поля время и минуты в режиме input mode")
    @Description("Проверяем вывод предупреждающего сообщения")
    @Test
    public void inputNotValidTimeAndMinutesTest() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().timeInPlanTextInput();
        new DateAndTimeSteps().switchToTextInputMode();
        new VerificationPage().checkText();
        new DateAndTimeSteps().settingTimesNotValid();
        new DateAndTimeSteps().settingMinutesNotValid();
        new ButtonSteps().buttonOkAlert();
        new VerificationPage().checkTextAlert();
        new ButtonSteps().buttonCancelAlert();
        pressBack();
        new LogOutSteps().logOut();
    }
}
