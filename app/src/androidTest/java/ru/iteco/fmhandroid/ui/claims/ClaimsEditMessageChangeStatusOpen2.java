package ru.iteco.fmhandroid.ui.claims;
//Пункт в тест кейсе № 14

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
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
public class ClaimsEditMessageChangeStatusOpen2 {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Раздел Claims. Проверяем в сообщении кнопку статус процесса. Проверяем Take to work")
    @Description("Работоспособность пункта Take to work")
    public void ClaimsEditMessageChangeStatusTakeToWork() throws InterruptedException {

        new LogIn().logIn();

        ViewInteraction clickMainMenu = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu.check(matches(isDisplayed()));
        clickMainMenu.perform(click());

        ViewInteraction clickClaims = onView(
                anyOf(withText("Claims"), withText("Заявки")));
        clickClaims.check(matches(isDisplayed()));
        clickClaims.perform(click());
        Thread.sleep(2000);

        ViewInteraction clickAddNew = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        clickAddNew.check(matches(isDisplayed()));
        clickAddNew.perform(click());
        Thread.sleep(1000);

        new InputNewClaim().inputNewClaim();

        ViewInteraction clickRecyclerView = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickRecyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction clickStatusButton = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton.perform(scrollTo());
        clickStatusButton.check(matches(isDisplayed()));
        clickStatusButton.perform(click());

        ViewInteraction clickStatusThrowOff = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickStatusThrowOff.perform(click());

        ViewInteraction checkTextCommentThrowOff = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        checkTextCommentThrowOff.check(matches(isDisplayed()));
        checkTextCommentThrowOff.perform(replaceText("Trow_Off_Test_Тест_Тест"));

        ViewInteraction clickSaves2 = onView(
                allOf(withId(android.R.id.button1)));
        clickSaves2.perform(scrollTo(), click());

        Thread.sleep(1000);

        ViewInteraction clickButtonStatus2 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickButtonStatus2.perform(scrollTo());
        clickButtonStatus2.check(matches(isDisplayed()));
        clickButtonStatus2.perform(click());
        Thread.sleep(2000);

        ViewInteraction clickTakeToWork = onView(
                anyOf(withText("take to work"), withText("В работу")));
        clickTakeToWork.check(matches(isDisplayed()));
        clickTakeToWork.perform(click());

        Thread.sleep(1000);

        ViewInteraction checkStatusInProgress = onView(
                anyOf(withText("In progress"), withText("В работе")));
        checkStatusInProgress.check(matches(isDisplayed()));

        Thread.sleep(1000);

        ViewInteraction clickStatus = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatus.perform(scrollTo());
        clickStatus.check(matches(isDisplayed()));
        clickStatus.perform(click());
        Thread.sleep(1000);

        ViewInteraction clickToExecute = onView(
                anyOf(withText("To execute"), withText("Исполнить")));
        clickToExecute.check(matches(isDisplayed()));
        clickToExecute.perform(click());
        Thread.sleep(2000);

        ViewInteraction inputTextTestExecute = onView(
                allOf(withId(R.id.editText)));
        inputTextTestExecute.check(matches(isDisplayed()));
        inputTextTestExecute.perform(click());
        inputTextTestExecute.perform(typeText("TestExecuteClose"), closeSoftKeyboard());
        inputTextTestExecute.check(matches(withText("TestExecuteClose")));
        Thread.sleep(1000);

        ViewInteraction clickOk3 = onView(
                allOf(withId(android.R.id.button1)));
        clickOk3.check(matches(isDisplayed()));
        clickOk3.perform(scrollTo(), click());
        Thread.sleep(2000);

        ViewInteraction clickBack = onView(
                allOf(withId(R.id.close_image_button)));
        clickBack.perform(scrollTo());
        clickBack.check(matches(isDisplayed()));
        clickBack.perform(click());

        Thread.sleep(1000);

        new LogOut().logOut();

    }

}
