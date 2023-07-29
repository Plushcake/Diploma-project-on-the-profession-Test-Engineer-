package ru.iteco.fmhandroid.ui.timecalendarTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withResourceName;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;


import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.pageObject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageObject.DateAndTimeSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;
import ru.iteco.fmhandroid.ui.verificationPage.VerificationPage;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DateTest {

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
    @DisplayName("В разделе установки даты проверяем работоспособность переключения месяца")
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

    @Test
    @DisplayName("В разделе установки даты проверяем работоспособность кнопки Ok")
    public void testTheOkButton() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().dateInPlanTextInput();
        new ButtonSteps().buttonOkAlert();
        pressBack();
        new LogOutSteps().logOut();
    }

    @Test
    @DisplayName("В разделе установки даты проверяем работоспособность кнопки Cancel")
    public void testTheCancelButton() {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().dateInPlanTextInput();
        new ButtonSteps().buttonCancelAlert();
        pressBack();
        new LogOutSteps().logOut();
    }

    @Test
    @DisplayName("В разделе установки даты проверяем изменение дня")
    public void testChangeOfDay() throws InterruptedException {
        new DataHelper().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
//        new ButtonSteps().dateInPlanTextInput();

//        ViewInteraction materialTextView4 =
//                onView(allOf(withResourceName(is("android:id/month_view")())
////                ), isDescendantOfA(allOf(withClassName(is("android.view.View")), withText("27"))))).perform(click;


        ViewInteraction dateInPlanTextInput = onView(
                allOf(withId(R.id.date_in_plan_text_input_edit_text)));
        dateInPlanTextInput.perform(click());

        ViewInteraction selectFromTheList =
                onView(withText("29"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        //dateInPlanTextInput.check(matches(withText("Ivanov Ivan Ivanovich")));
        Thread.sleep(5000);

        new ButtonSteps().buttonCancelAlert();
        pressBack();
        new LogOutSteps().logOut();
    }


}
