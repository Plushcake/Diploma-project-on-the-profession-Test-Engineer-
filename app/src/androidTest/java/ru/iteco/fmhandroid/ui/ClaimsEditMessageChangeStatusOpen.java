package ru.iteco.fmhandroid.ui;

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
import androidx.test.espresso.matcher.RootMatchers;
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
import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsEditMessageChangeStatusOpen {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void Login() throws InterruptedException {
        Thread.sleep(7000);

        ViewInteraction EnteringLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        EnteringLogin.perform(replaceText("login2"), closeSoftKeyboard());

        ViewInteraction EnteringPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        EnteringPassword.perform(replaceText("password2"), closeSoftKeyboard());

        ViewInteraction clickButton = onView(
                allOf(withId(R.id.enter_button)));
        clickButton.perform(click());


        Thread.sleep(3000);


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

        ViewInteraction inputTittle = onView(
                allOf(withId(R.id.title_edit_text)));
        inputTittle.perform(click());
        inputTittle.perform(replaceText("TestChangeStatus"), closeSoftKeyboard());
        Thread.sleep(1000);

        ViewInteraction clickExecutor = onView(
                allOf(withId(R.id.executor_drop_menu_auto_complete_text_view)));
        clickExecutor.check(matches(isDisplayed()));
        clickExecutor.perform(click(), closeSoftKeyboard());
        Thread.sleep(2000);

        ViewInteraction selectFromTheList =
                onView(withText("Ivanov Ivan Ivanovich"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());

        ViewInteraction inputDate = onView(
                allOf(withId(R.id.date_in_plan_text_input_edit_text)));
        inputDate.perform(replaceText("01.01.1990"), closeSoftKeyboard());
        Thread.sleep(1000);

        ViewInteraction inputTime = onView(
                allOf(withId(R.id.time_in_plan_text_input_edit_text)));
        inputTime.perform(replaceText("07:00"), closeSoftKeyboard());
        Thread.sleep(1000);

        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.description_edit_text)));
        inputDescription.perform(click());
        inputDescription.perform(replaceText("TestChangeStatus"), closeSoftKeyboard());
        Thread.sleep(2000);

        ViewInteraction clickSave = onView(
                allOf(withId(R.id.save_button)));
        clickSave.perform(scrollTo(), click());

    }

    @After
    public void LogOutTest() throws InterruptedException {
        ViewInteraction clickAuthorization = onView(
                allOf(withId(R.id.authorization_image_button)));
        clickAuthorization.check(matches(isDisplayed()));
        clickAuthorization.perform(click());

        Thread.sleep(2000);

        ViewInteraction textViewLogOutTest = onView(
                anyOf(withText("Log out"), withText("Выйти")));
        textViewLogOutTest.check(matches(isDisplayed()));
        textViewLogOutTest.perform(click());
    }


    @Test
    @DisplayName("Раздел Claims. Проверяем в сообщении кнопку статус процесса. Проверяем Cancel")
    @Description("Работоспособность пункта Cancel")
    public void ClaimsEditMessageChangeStatusCancel() throws InterruptedException {
        Thread.sleep(2000);
        ViewInteraction clickRecyclerView = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickRecyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction clickStatusButton = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton.perform(click());

        ViewInteraction clickThrowOff = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickThrowOff.check(matches(isDisplayed()));
        clickThrowOff.perform(click());

        ViewInteraction checkTextCommentThrowOff = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        checkTextCommentThrowOff.check(matches(isDisplayed()));
        checkTextCommentThrowOff.perform(typeText("Trow_Off_Test"));

        ViewInteraction clickSaves2 = onView(
                allOf(withId(android.R.id.button1)));
        clickSaves2.perform(scrollTo(), click());

        ViewInteraction checkStatusOpen = onView(
                anyOf(withText("Open"), withText("Открыта")));
        checkStatusOpen.check(matches(isDisplayed()));

        ViewInteraction clickButtonStatus = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickButtonStatus.check(matches(isDisplayed()));
        clickButtonStatus.perform(click());

        ViewInteraction clickStatusCancel = onView(
                anyOf(withText("Cancel"), withText("Отменить")));
        clickStatusCancel.check(matches(isDisplayed()));
        clickStatusCancel.perform(click());

        Thread.sleep(2000);

        ViewInteraction checkStatusCanceled = onView(
                anyOf(withText("Canceled"), withText("Отменена")));
        checkStatusCanceled.check(matches(isDisplayed()));

        ViewInteraction clickBack = onView(
                allOf(withId(R.id.close_image_button)));
        clickBack.check(matches(isDisplayed()));
        clickBack.perform(click());

        Thread.sleep(2000);

    }

    @Test
    @DisplayName("Раздел Claims. Проверяем в сообщении кнопку статус процесса. Проверяем Take to work")
    @Description("Работоспособность пункта Take to work")
    public void ClaimsEditMessageChangeStatusTakeToWork() throws InterruptedException {
        Thread.sleep(2000);
        ViewInteraction clickRecyclerView = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickRecyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction clickStatusButton = onView(
                allOf(withId(R.id.status_processing_image_button)));
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

        Thread.sleep(2000);

    }
}
