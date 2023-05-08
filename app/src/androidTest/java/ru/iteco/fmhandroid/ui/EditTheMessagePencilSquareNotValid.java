package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 18
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
public class EditTheMessagePencilSquareNotValid {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void editTheMessagePencilSquareNotValid() throws InterruptedException {
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

        ViewInteraction clickFilter = onView(
                allOf(withId(R.id.filters_material_button)));
        clickFilter.check(matches(isDisplayed()));
        clickFilter.perform(click());

//        ViewInteraction checkTextFiltering = onView(
//                allOf(withId(R.id.claim_filter_dialog_title)));
//        checkTextFiltering.check(matches(isDisplayed()));
//        checkTextFiltering.check(matches(withText("Filtering")));

        ViewInteraction clickInProgress = onView(
                allOf(withId(R.id.item_filter_in_progress)));
        clickInProgress.check(matches(isDisplayed()));
        clickInProgress.perform(scrollTo(), click());

        ViewInteraction clickOk = onView(
                allOf(withId(R.id.claim_list_filter_ok_material_button)));
        clickOk.check(matches(isDisplayed()));
        clickOk.perform(scrollTo(), click());

        ViewInteraction clickListRecycler = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickListRecycler.check(matches(isDisplayed()));
        clickListRecycler.perform(actionOnItemAtPosition(0, click()));

//        ViewInteraction checkTextOpen = onView(
//                allOf(withId(R.id.status_label_text_view)));
//        checkTextOpen.check(matches(withText("Open")));

        ViewInteraction clickEditProcessing = onView(
                allOf(withId(R.id.edit_processing_image_button)));
        clickEditProcessing.check(matches(isDisplayed()));
        clickEditProcessing.perform(click());

        ViewInteraction textInputTitle = onView(
                allOf(withId(R.id.title_edit_text)));
        textInputTitle.check(matches(isDisplayed()));
        textInputTitle.perform(click());
        textInputTitle.perform(clearText());
        textInputTitle.perform(replaceText("ПриветМир:12345678901234567890123456789012345678901234567890123456789072"), closeSoftKeyboard());
        textInputTitle.check(matches(withText("ПриветМир:1234567890123456789012345678901234567890")));

        ViewInteraction textInputDescription = onView(
                allOf(withId(R.id.description_edit_text)));
        textInputDescription.check(matches(isDisplayed()));
        textInputDescription.perform(click());
        textInputDescription.perform(clearText());
        textInputDescription.perform(replaceText("ПриветМир:12345678901234567890123456789012345678901234567890123456789072"), closeSoftKeyboard());
        textInputDescription.check(matches(withText("ПриветМир:12345678901234567890123456789012345678901234567890123456789072")));
        ;

        ViewInteraction clickSave2 = onView(
                allOf(withId(R.id.save_button)));
        clickSave2.check(matches(isDisplayed()));
        clickSave2.perform(scrollTo(), click());

        ViewInteraction clickStatusProcessing = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusProcessing.check(matches(isDisplayed()));
        clickStatusProcessing.perform(click());

        ViewInteraction clickCancel = onView(
                anyOf(withText("Cancel"), withText("Отменить")));
        clickCancel.check(matches(isDisplayed()));
        clickCancel.perform(click());

//        ViewInteraction checkTextCanceled = onView(
//                allOf(withId(R.id.status_label_text_view)));
//        checkTextCanceled.check(matches(isDisplayed()));
//        checkTextCanceled.check(matches(withText("Canceled")));

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
