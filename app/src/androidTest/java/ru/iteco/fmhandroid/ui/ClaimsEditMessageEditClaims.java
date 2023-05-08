package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 15

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
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
public class ClaimsEditMessageEditClaims {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void claimsEditMessageEditClaims() throws InterruptedException {
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

        ViewInteraction clickExecutor = onView(
                allOf(withId(R.id.executor_drop_menu_auto_complete_text_view)));
        clickExecutor.perform(click());
        clickExecutor.perform(replaceText("Ivanov Ivan Ivanovich"));
        clickExecutor.perform(click());

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


        ViewInteraction clickFilter = onView(
                allOf(withId(R.id.filters_material_button)));
        clickFilter.check(matches(isDisplayed()));
        clickFilter.perform(click());

        ViewInteraction clickInProgressFilter = onView(
                allOf(withId(R.id.item_filter_in_progress)));
        clickInProgressFilter.check(matches(isDisplayed()));
        clickInProgressFilter.perform(scrollTo(), click());

        ViewInteraction clickOkFilter = onView(
                allOf(withId(R.id.claim_list_filter_ok_material_button)));
        clickOkFilter.check(matches(isDisplayed()));
        clickOkFilter.perform(scrollTo(), click());
        Thread.sleep(2000);

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction clickEditProcessing = onView(
                allOf(withId(R.id.edit_processing_image_button)));
        clickEditProcessing.check(matches(isDisplayed()));
        clickEditProcessing.perform(click());

        ViewInteraction inputTittleText = onView(
                allOf(withId(R.id.title_edit_text)));
        inputTittleText.perform(clearText());
        inputTittleText.perform(replaceText("Claims:123456789!@#$%^&*()"));
        inputTittleText.check(matches(withText("Claims:123456789!@#$%^&*()")));

        ViewInteraction clickExecutor1 = onView(
                allOf(withId(R.id.executor_drop_menu_auto_complete_text_view)));
        clickExecutor1.perform(click());
        clickExecutor1.perform(replaceText("Ivanov Ivan Ivanovich"));
        clickExecutor1.check(matches(withText("Ivanov Ivan Ivanovich")));
        clickExecutor1.perform(click());

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
        inputTextDescription.perform(replaceText("AddComment:123456789!@#$%^&*(_+)"), closeSoftKeyboard());
        inputTextDescription.check(matches(withText("AddComment:123456789!@#$%^&*(_+)")));

        ViewInteraction clickSave1 = onView(
                allOf(withId(R.id.save_button)));
        clickSave1.perform(scrollTo(), click());
        Thread.sleep(2000);

        ViewInteraction clickEditProcessing1 = onView(
                allOf(withId(R.id.edit_processing_image_button)));
        clickEditProcessing1.perform(click());

        ViewInteraction clickCancel = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel.check(matches(isDisplayed()));
        clickCancel.perform(scrollTo(), click());

        ViewInteraction clickCansel1 = onView(
                allOf(withId(android.R.id.button2)));
        clickCansel1.check(matches(isDisplayed()));
        clickCansel1.perform(scrollTo(), click());

        ViewInteraction clickCansel2 = onView(
                allOf(withId(R.id.cancel_button)));
        clickCansel2.check(matches(isDisplayed()));
        clickCansel2.perform(scrollTo(), click());

        ViewInteraction clickOk = onView(
                allOf(withId(android.R.id.button1)));
        clickOk.check(matches(isDisplayed()));
        clickOk.perform(scrollTo(), click());

        ViewInteraction clickStatusButton = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton.check(matches(isDisplayed()));
        clickStatusButton.perform(click());

        ViewInteraction clickCancel2 = onView(
                anyOf(withText("Cancel"), withText("Отменить")));
        clickCancel2.check(matches(isDisplayed()));
        clickCancel2.perform(click());

        ViewInteraction clickBack = onView(
                allOf(withId(R.id.close_image_button)));
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
