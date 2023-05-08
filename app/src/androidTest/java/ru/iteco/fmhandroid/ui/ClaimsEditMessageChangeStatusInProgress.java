package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 14

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressKey;
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
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ClaimsEditMessageChangeStatusInProgress {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

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
        clickExecutor.perform(click());
        clickExecutor.perform(pressKey(22));
        Thread.sleep(1000);
        clickExecutor.perform(pressKey(66));
        Thread.sleep(1000);
        clickExecutor.perform(pressKey(20), pressKey(66), closeSoftKeyboard());
        Thread.sleep(2000);
        clickExecutor.check(matches(withText("Ivanov Ivan Ivanovich")));
        Thread.sleep(2000);

        ViewInteraction inputDate = onView(
                allOf(withId(R.id.date_in_plan_text_input_edit_text)));
        inputDate.perform(replaceText("01.01.2011"), closeSoftKeyboard());
        Thread.sleep(1000);

        ViewInteraction inputTime = onView(
                allOf(withId(R.id.time_in_plan_text_input_edit_text)));
        inputTime.perform(replaceText("07:00"), closeSoftKeyboard());
        Thread.sleep(1000);

        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.description_edit_text)));
        inputDescription.perform(click());
        inputDescription.perform(replaceText("TestChangeStatus"), closeSoftKeyboard());
        Thread.sleep(1000);

        ViewInteraction clickSave = onView(
                allOf(withId(R.id.save_button)));
        clickSave.perform(scrollTo(), click());

        Thread.sleep(2000);
    }

    @After
    public void logOutTest() throws InterruptedException {
        ViewInteraction clickAuthorization = onView(
                allOf(withId(R.id.authorization_image_button)));
        clickAuthorization.perform(click());

        Thread.sleep(1000);

        ViewInteraction textViewLogOutTest = onView(
                anyOf(withText("Log out"), withText("Выйти")));
        textViewLogOutTest.perform(click());
    }

    @Test
    public void ClaimsEditMessageChangeStatusTrowOff() throws InterruptedException {
        ViewInteraction clickRecyclerView2 = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickRecyclerView2.check(matches(isDisplayed()));
        clickRecyclerView2.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction clickButtonStatus3 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickButtonStatus3.check(matches(isDisplayed()));
        clickButtonStatus3.perform(click());

        ViewInteraction clickThrowOff = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickThrowOff.check(matches(isDisplayed()));
        clickThrowOff.perform(click());

        ViewInteraction clickCancel = onView(
                allOf(withId(android.R.id.button2)));
        clickCancel.check(matches(isDisplayed()));
        clickCancel.perform(scrollTo(), click());

        ViewInteraction clickButtonStatus5 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickButtonStatus5.check(matches(isDisplayed()));
        clickButtonStatus5.perform(click());

        ViewInteraction clickThrowOff5 = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickThrowOff5.check(matches(isDisplayed()));
        clickThrowOff5.perform(click());

        ViewInteraction clickOk5 = onView(
                allOf(withId(android.R.id.button1)));
        clickOk5.check(matches(isDisplayed()));
        clickOk5.perform(scrollTo(), click());

        Thread.sleep(2000);

        ViewInteraction clickCancel5 = onView(
                allOf(withId(android.R.id.button2)));
        clickCancel5.check(matches(isDisplayed()));
        clickCancel5.perform(scrollTo(), click());

        ViewInteraction clickButtonStatus4 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickButtonStatus4.check(matches(isDisplayed()));
        clickButtonStatus4.perform(click());

        ViewInteraction clickThrowOff2 = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickThrowOff2.check(matches(isDisplayed()));
        clickThrowOff2.perform(click());

        ViewInteraction clickOk = onView(
                allOf(withId(android.R.id.button1)));
        clickOk.check(matches(isDisplayed()));
        clickOk.perform(scrollTo(), click());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.editText)));
        textInputEditText3.perform(click());
        textInputEditText3.perform(typeText("Test:1235098!@#$%^&()Qasdrftgyhjuiklop;mnbvcxz<>*=-%_55"), closeSoftKeyboard());
        textInputEditText3.check(matches(withText("Test:1235098!@#$%^&()Qasdrftgyhjuiklop;mnbvcxz<>*=-%_55")));
        Thread.sleep(3000);

        ViewInteraction clickOk2 = onView(
                allOf(withId(android.R.id.button1)));
        clickOk2.check(matches(isDisplayed()));
        clickOk2.perform(scrollTo(), click());

        ViewInteraction clickStatus = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatus.check(matches(isDisplayed()));
        clickStatus.perform(click());

        ViewInteraction clickToCancel = onView(
                anyOf(withText("Cancel"), withText("Отменить")));
        clickToCancel.check(matches(isDisplayed()));
        clickToCancel.perform(click());

        ViewInteraction clickBack = onView(
                allOf(withId(R.id.close_image_button)));
        clickBack.check(matches(isDisplayed()));
        clickBack.perform(click());

        Thread.sleep(2000);

    }

    @Test
    public void ClaimsEditMessageChangeStatusToExecute() throws InterruptedException {
        ViewInteraction clickRecyclerView2 = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickRecyclerView2.check(matches(isDisplayed()));
        clickRecyclerView2.perform(actionOnItemAtPosition(0, click()));
        Thread.sleep(2000);

        ViewInteraction clickStatus = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatus.check(matches(isDisplayed()));
        clickStatus.perform(click());

        ViewInteraction clickToExecute = onView(
                anyOf(withText("To execute"), withText("Исполнить")));
        clickToExecute.check(matches(isDisplayed()));
        clickToExecute.perform(click());

        ViewInteraction clickCancel = onView(
                allOf(withId(android.R.id.button2)));
        clickCancel.check(matches(isDisplayed()));
        clickCancel.perform(scrollTo(), click());

        ViewInteraction clickStatus2 = onView(
                allOf(withId(R.id.status_processing_image_button)));
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
        Thread.sleep(2000);

        ViewInteraction clickOk3 = onView(
                allOf(withId(android.R.id.button1)));
        clickOk3.check(matches(isDisplayed()));
        clickOk3.perform(scrollTo(), click());

//        ViewInteraction clickBack = onView(
//                allOf(withId(R.id.close_image_button)));
//        clickBack.check(matches(isDisplayed()));
//        clickBack.perform(click());

        Thread.sleep(2000);

    }

}

