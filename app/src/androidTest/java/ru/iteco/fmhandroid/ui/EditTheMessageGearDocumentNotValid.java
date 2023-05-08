package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 17

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
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EditTheMessageGearDocumentNotValid {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void editTheMessageGearDocumentNotValid() throws InterruptedException {
        Thread.sleep(7000);

        ViewInteraction EnteringLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        EnteringLogin.perform(typeText("login2"), closeSoftKeyboard());

        ViewInteraction EnteringPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        EnteringPassword.perform(typeText("password2"), closeSoftKeyboard());

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

        ViewInteraction clickAdd = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        clickAdd.perform(click());

        ViewInteraction inputTextTitle = onView(
                allOf(withId(R.id.title_edit_text)));
        inputTextTitle.perform(click());
        inputTextTitle.perform(replaceText("ClaimsAddComment"), closeSoftKeyboard());
        inputTextTitle.check(matches(withText("ClaimsAddComment")));

        ViewInteraction clickExecutor = onView(
                allOf(withId(R.id.executor_drop_menu_auto_complete_text_view)));
        clickExecutor.perform(click());
        clickExecutor.perform(replaceText("Ivanov Ivan Ivanovich"));
        clickExecutor.check(matches(withText("Ivanov Ivan Ivanovich")));
        clickExecutor.perform(click());

        ViewInteraction inputData = onView(
                allOf(withId(R.id.date_in_plan_text_input_edit_text)));
        inputData.perform(replaceText("15.11.2010"), closeSoftKeyboard());
        inputData.check(matches(withText("15.11.2010")));

        ViewInteraction inputTime = onView(
                allOf(withId(R.id.time_in_plan_text_input_edit_text)));
        inputTime.perform(replaceText("15:00"), closeSoftKeyboard());
        inputTime.check(matches(withText("15:00")));

        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.description_edit_text)));
        inputDescription.perform(click());
        inputDescription.perform(replaceText("AddComment"), closeSoftKeyboard());
        inputDescription.check(matches(withText("AddComment")));

        ViewInteraction clickSave = onView(
                allOf(withId(R.id.save_button)));
        clickSave.perform(scrollTo(), click());
        Thread.sleep(2000);


        ViewInteraction clickClaimListRecycler = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickClaimListRecycler.check(matches(isDisplayed()));
        clickClaimListRecycler.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction clickStatusButton = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton.check(matches(isDisplayed()));
        clickStatusButton.perform(click());

        ViewInteraction clickStatusTakeTOWork = onView(
                anyOf(withText("take to work"), withText("В работу")));
        clickStatusTakeTOWork.check(matches(isDisplayed()));
        clickStatusTakeTOWork.perform(click());

        ViewInteraction clickStatusButton2 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton2.check(matches(isDisplayed()));
        clickStatusButton2.perform(click());

        ViewInteraction clickStatusThrowOff = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickStatusThrowOff.check(matches(isDisplayed()));
        clickStatusThrowOff.perform(click());

        ViewInteraction inputTextComment = onView(
                allOf(withId(R.id.editText)));
        inputTextComment.perform(replaceText("ПриветМир:12345678901234567890123456789012345678901234567890123456789072"), closeSoftKeyboard());
        inputTextComment.check(matches(withText("ПриветМир:12345678901234567890123456789012345678901234567890123456789072")));
        inputTextComment.check(matches(withText("ПриветМир:12345678901234567890123456789012345678901234567890123456789072")));

        ViewInteraction clickOk = onView(
                allOf(withId(android.R.id.button1)));
        clickOk.check(matches(isDisplayed()));
        clickOk.perform(scrollTo(), click());

        ViewInteraction clickStatusButton3 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton3.check(matches(isDisplayed()));
        clickStatusButton3.perform(click());

        ViewInteraction clickTakeToWork = onView(
                anyOf(withText("take to work"), withText("В работу")));
        clickTakeToWork.check(matches(isDisplayed()));
        clickTakeToWork.perform(click());

        ViewInteraction clickStatusButton4 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton4.check(matches(isDisplayed()));
        clickStatusButton4.perform(click());

        ViewInteraction clickToExecute = onView(
                anyOf(withText("To execute"), withText("Исполнить")));
        clickToExecute.check(matches(isDisplayed()));
        clickToExecute.perform(click());

        ViewInteraction inputTextComment2 = onView(
                allOf(withId(R.id.editText)));
        inputTextComment2.perform(click());
        inputTextComment2.perform(replaceText("ПриветМир:1234567890123456789012345678901234567890123456789012345678907274"), closeSoftKeyboard());
        inputTextComment2.check(matches(withText("ПриветМир:1234567890123456789012345678901234567890123456789012345678907274")));

        ViewInteraction clickOk2 = onView(
                allOf(withId(android.R.id.button1)));
        clickOk2.check(matches(isDisplayed()));
        clickOk2.perform(scrollTo(), click());

        ViewInteraction clickBack = onView(
                allOf(withId(R.id.close_image_button)));
        clickBack.perform(scrollTo());
        clickBack.check(matches(isDisplayed()));
        clickBack.perform(click());
        Thread.sleep(2000);

        ViewInteraction clickAuthorization = onView(
                allOf(withId(R.id.authorization_image_button)));
        clickAuthorization.check(matches(isDisplayed()));
        clickAuthorization.perform(click());


        ViewInteraction textViewLogOutTest = onView(
                anyOf(withText("Log out"), withText("Выйти")));
        textViewLogOutTest.check(matches(isDisplayed()));
        textViewLogOutTest.perform(click());
    }
}
