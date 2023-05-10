package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 15

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
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

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ClaimsEditMessageEditClaims {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void claimsEditMessageEditClaims() throws InterruptedException {
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


        ViewInteraction clickAdd = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        clickAdd.perform(click());

        ViewInteraction inputTextTitle = onView(
                allOf(withId(R.id.title_edit_text)));
        inputTextTitle.perform(click());
        inputTextTitle.perform(replaceText("ClaimsAddComment"), closeSoftKeyboard());

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

        ViewInteraction inputData = onView(
                allOf(withId(R.id.date_in_plan_text_input_edit_text)));
        inputData.perform(replaceText("15.11.2010"), closeSoftKeyboard());

        ViewInteraction inputTime = onView(
                allOf(withId(R.id.time_in_plan_text_input_edit_text)));
        inputTime.perform(replaceText("15:00"), closeSoftKeyboard());

        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.description_edit_text)));
        inputDescription.perform(click());
        inputDescription.perform(replaceText("AddComment"), closeSoftKeyboard());

        ViewInteraction clickSave = onView(
                allOf(withId(R.id.save_button)));
        clickSave.perform(scrollTo(), click());
        Thread.sleep(2000);

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction clickStatusButton = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton.check(matches(isDisplayed()));
        clickStatusButton.perform(click());

        ViewInteraction clickTrowOff = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickTrowOff.perform(click());

        ViewInteraction inputTextComment = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputTextComment.perform(typeText("Add Comment Throw Off"), closeSoftKeyboard());

        ViewInteraction clickSaves2 = onView(
                allOf(withId(android.R.id.button1)));
        clickSaves2.perform(scrollTo(), click());
        Thread.sleep(1000);

        ViewInteraction checkText = onView(
                allOf(withId(R.id.status_label_text_view)));
        checkText.check(matches(withText("Open")));

        ViewInteraction clickEditProcessing = onView(
                allOf(withId(R.id.edit_processing_image_button)));
        clickEditProcessing.check(matches(isDisplayed()));
        clickEditProcessing.perform(click());

        ViewInteraction clickCancelEmpty = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancelEmpty.perform(click());

        ViewInteraction clickOkEmpty = onView(
                allOf(withId(android.R.id.button1)));
        clickOkEmpty.check(matches(isDisplayed()));
        clickOkEmpty.perform(scrollTo(), click());

        ViewInteraction clickEditProcessing2 = onView(
                allOf(withId(R.id.edit_processing_image_button)));
        clickEditProcessing2.check(matches(isDisplayed()));
        clickEditProcessing2.perform(click());

        ViewInteraction inputTittleText = onView(
                allOf(withId(R.id.title_edit_text)));
        inputTittleText.perform(clearText());
        inputTittleText.perform(typeText("Claims:123456789!@#$%^&*()"));
        inputTittleText.check(matches(withText("Claims:123456789!@#$%^&*()")));

        ViewInteraction clickExecutor1 = onView(
                allOf(withId(R.id.executor_drop_menu_auto_complete_text_view)));
        clickExecutor1.perform(click());
        clickExecutor1.perform(pressKey(22));
        Thread.sleep(1000);
        clickExecutor1.perform(pressKey(66));
        Thread.sleep(1000);
        clickExecutor1.perform(pressKey(20), pressKey(66), closeSoftKeyboard());
        Thread.sleep(2000);
        clickExecutor1.check(matches(withText("Ivanov Ivan Ivanovich")));

        ViewInteraction inputDate = onView(
                allOf(withId(R.id.date_in_plan_text_input_edit_text)));
        inputDate.perform(clearText());
        inputDate.perform(replaceText("25.11.2011"), closeSoftKeyboard());
        inputDate.check(matches(withText("25.11.2011")));

        ViewInteraction inputTime1 = onView(
                allOf(withId(R.id.time_in_plan_text_input_edit_text)));
        inputTime1.perform(clearText());
        inputTime1.perform(replaceText("16:00"), closeSoftKeyboard());
        inputTime1.check(matches(withText("16:00")));

        ViewInteraction inputTextDescription = onView(
                allOf(withId(R.id.description_edit_text)));
        inputTextDescription.perform(clearText());
        inputTextDescription.perform(typeText("AddComment:123456789!@#$%^&*(_+)"), closeSoftKeyboard());
        inputTextDescription.check(matches(withText("AddComment:123456789!@#$%^&*(_+)")));

        ViewInteraction clickSave1 = onView(
                allOf(withId(R.id.save_button)));
        clickSave1.perform(scrollTo(), click());
        Thread.sleep(2000);

        ViewInteraction clickStatusButton2 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton2.check(matches(isDisplayed()));
        clickStatusButton2.perform(click());

        ViewInteraction clickToExecute = onView(
                anyOf(withText("To execute"), withText("Исполнить")));
        clickToExecute.check(matches(isDisplayed()));
        clickToExecute.perform(click());

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
