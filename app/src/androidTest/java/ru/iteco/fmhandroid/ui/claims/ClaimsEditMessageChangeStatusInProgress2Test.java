package ru.iteco.fmhandroid.ui.claims;
//Пункт в тест кейсе № 14

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.google.android.gms.common.api.Status;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.InputNewClaimSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageObject.StatusProcessingImageClaimsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsEditMessageChangeStatusInProgress2Test {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);
    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }

    @Test
    @DisplayName("Раздел Claims. Проверяем в сообщении кнопку статус процесса. Проверяем To execute")
    @Description("Работоспособность пункта To execute")
    public void ClaimsEditMessageChangeStatusToExecute() {

        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new InputNewClaimSteps().inputNewClaimValid();
        new ButtonSteps().listRecyclerClaims();
        new ButtonSteps().buttonStatusClaims();
        new StatusProcessingImageClaimsSteps().statusToExecute();
        new StatusProcessingImageClaimsSteps().buttonSaveComment();
        new StatusProcessingImageClaimsSteps().buttonCancelComment();
        new ButtonSteps().buttonStatusClaims();
        new StatusProcessingImageClaimsSteps().statusToExecute();

        ViewInteraction inputTextTestExecute = onView(
                allOf(withId(R.id.editText)));
        inputTextTestExecute.check(matches(isDisplayed()));
        inputTextTestExecute.perform(click());
        inputTextTestExecute.perform(typeText("TestExecute:1234567890qwertyuiopasdfghjkl;zxcvbnmWdR_55"), closeSoftKeyboard());
        inputTextTestExecute.check(matches(withText("TestExecute:1234567890qwertyuiopasdfghjkl;zxcvbnmWdR_55")));

        new StatusProcessingImageClaimsSteps().buttonSaveComment();

        ViewInteraction checkStatusExecuted = onView(
                anyOf(withText("Executed"), withText("Выполнена")));
        checkStatusExecuted.check(matches(isDisplayed()));

        new LogOutSteps().logOut();
    }
}
