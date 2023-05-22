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

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.InputNewClaim;
import ru.iteco.fmhandroid.ui.data.LogIn;
import ru.iteco.fmhandroid.ui.data.LogOut;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsEditMessageChangeStatusInProgress2 {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Раздел Claims. Проверяем в сообщении кнопку статус процесса. Проверяем To execute")
    @Description("Работоспособность пункта To execute")
    public void ClaimsEditMessageChangeStatusToExecute() throws InterruptedException {

        new LogIn().logIn();

        ViewInteraction clickMainMenu = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu.check(matches(isDisplayed()));
        clickMainMenu.perform(click());

        ViewInteraction clickClaims = onView(
                anyOf(withText("Claims"), withText("Заявки")));
        clickClaims.check(matches(isDisplayed()));
        clickClaims.perform(click());
        Thread.sleep(1000);

        ViewInteraction clickAddNew = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        clickAddNew.check(matches(isDisplayed()));
        clickAddNew.perform(click());
        Thread.sleep(1000);

        new InputNewClaim().inputNewClaim();

        ViewInteraction clickRecyclerView2 = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickRecyclerView2.check(matches(isDisplayed()));
        clickRecyclerView2.perform(actionOnItemAtPosition(0, click()));
        Thread.sleep(2000);

        ViewInteraction clickStatus2 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatus2.perform(scrollTo());
        clickStatus2.check(matches(isDisplayed()));
        clickStatus2.perform(click());
        Thread.sleep(1000);

        ViewInteraction clickToExecute2 = onView(
                anyOf(withText("To execute"), withText("Исполнить")));
        clickToExecute2.check(matches(isDisplayed()));
        clickToExecute2.perform(click());

        ViewInteraction clickOk2 = onView(
                allOf(withId(android.R.id.button1)));
        clickOk2.check(matches(isDisplayed()));
        clickOk2.perform(scrollTo(), click());
        Thread.sleep(2000);

        ViewInteraction clickCancel2 = onView(
                allOf(withId(android.R.id.button2)));
        clickCancel2.check(matches(isDisplayed()));
        clickCancel2.perform(scrollTo(), click());

        ViewInteraction clickStatus3 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatus3.perform(scrollTo());
        clickStatus3.check(matches(isDisplayed()));
        clickStatus3.perform(click());
        Thread.sleep(1000);

        ViewInteraction clickToExecute3 = onView(
                anyOf(withText("To execute"), withText("Исполнить")));
        clickToExecute3.check(matches(isDisplayed()));
        clickToExecute3.perform(click());

        ViewInteraction inputTextTestExecute = onView(
                allOf(withId(R.id.editText)));
        inputTextTestExecute.check(matches(isDisplayed()));
        inputTextTestExecute.perform(click());
        inputTextTestExecute.perform(typeText("TestExecute:1234567890qwertyuiopasdfghjkl;zxcvbnmWdR_55"), closeSoftKeyboard());
        inputTextTestExecute.check(matches(withText("TestExecute:1234567890qwertyuiopasdfghjkl;zxcvbnmWdR_55")));

        ViewInteraction clickOk3 = onView(
                allOf(withId(android.R.id.button1)));
        clickOk3.check(matches(isDisplayed()));
        clickOk3.perform(scrollTo(), click());

        ViewInteraction checkStatusExecuted = onView(
                anyOf(withText("Executed"), withText("Выполнена")));
        checkStatusExecuted.check(matches(isDisplayed()));

        Thread.sleep(2000);

        new LogOut().logOut();
    }
}
