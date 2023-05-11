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
import androidx.test.espresso.matcher.RootMatchers;
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
        inputTextTitle.perform(typeText("ClaimsAddComment"), closeSoftKeyboard());
        inputTextTitle.check(matches(withText("ClaimsAddComment")));
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

        ViewInteraction inputData = onView(
                allOf(withId(R.id.date_in_plan_text_input_edit_text)));
        inputData.perform(replaceText("15.11.1990"), closeSoftKeyboard());
        inputData.check(matches(withText("15.11.1990")));

        ViewInteraction inputTime = onView(
                allOf(withId(R.id.time_in_plan_text_input_edit_text)));
        inputTime.perform(replaceText("15:00"), closeSoftKeyboard());
        inputTime.check(matches(withText("15:00")));

        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.description_edit_text)));
        inputDescription.perform(click());
        inputDescription.perform(typeText("AddComment"), closeSoftKeyboard());
        inputDescription.check(matches(withText("AddComment")));

        ViewInteraction clickSave = onView(
                allOf(withId(R.id.save_button)));
        clickSave.perform(scrollTo(), click());
        Thread.sleep(2000);

        ViewInteraction clickListRecycler = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickListRecycler.check(matches(isDisplayed()));
        clickListRecycler.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction clickStatusProcessing1 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusProcessing1.check(matches(isDisplayed()));
        clickStatusProcessing1.perform(click());

        ViewInteraction clickCancel = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickCancel.check(matches(isDisplayed()));
        clickCancel.perform(click());

        ViewInteraction inputComment = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputComment.check(matches(isDisplayed()));
        inputComment.perform(click());
        inputComment.perform(typeText("CommentTest"), closeSoftKeyboard());

        ViewInteraction clickOk = onView(
                allOf(withId(android.R.id.button1)));
        clickOk.check(matches(isDisplayed()));
        clickOk.perform(scrollTo(), click());

        Thread.sleep(1000);

        ViewInteraction clickEditProcessing = onView(
                allOf(withId(R.id.edit_processing_image_button)));
        clickEditProcessing.check(matches(isDisplayed()));
        clickEditProcessing.perform(scrollTo());
        clickEditProcessing.perform(click());

        Thread.sleep(1000);

        ViewInteraction textInputTitle = onView(
                allOf(withId(R.id.title_edit_text)));
        textInputTitle.check(matches(isDisplayed()));
        textInputTitle.perform(click());
        textInputTitle.perform(clearText());
        textInputTitle.perform(typeText("HelloWorld:Title12345678901234567890123456789012345678901234567890123456789078"), closeSoftKeyboard());
        textInputTitle.check(matches(withText("HelloWorld:Title1234567890123456789012345678901234")));
        Thread.sleep(2000);

        ViewInteraction clickExecutor2 = onView(
                allOf(withId(R.id.executor_drop_menu_auto_complete_text_view)));
        clickExecutor2.check(matches(isDisplayed()));
        clickExecutor2.perform(click(), closeSoftKeyboard());
        Thread.sleep(2000);

        ViewInteraction selectFromTheList2 =
                onView(withText("Ivanov Ivan Ivanovich"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());

        ViewInteraction textInputDescription = onView(
                allOf(withId(R.id.description_edit_text)));
        textInputDescription.check(matches(isDisplayed()));
        textInputDescription.perform(click());
        textInputDescription.perform(clearText());
        textInputDescription.perform(typeText("HelloWorld:Description12345678901234567890123456789012345678901234567890123456789072"), closeSoftKeyboard());
        textInputDescription.check(matches(withText("HelloWorld:Description12345678901234567890123456789012345678901234567890123456789072")));
        Thread.sleep(2000);

        ViewInteraction clickSave2 = onView(
                allOf(withId(R.id.save_button)));
        clickSave2.check(matches(isDisplayed()));
        clickSave2.perform(scrollTo(), click());

        ViewInteraction clickStatusProcessing = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusProcessing.check(matches(isDisplayed()));
        clickStatusProcessing.perform(scrollTo());
        clickStatusProcessing.perform(click());

        ViewInteraction clickCancel1 = onView(
                anyOf(withText("To execute"), withText("Исполнить")));
        clickCancel1.check(matches(isDisplayed()));
        clickCancel1.perform(click());

        ViewInteraction inputComment2 = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputComment2.check(matches(isDisplayed()));
        inputComment2.perform(click());
        inputComment2.perform(typeText("To execute"), closeSoftKeyboard());
        inputComment2.check(matches(withText("To execute")));

        ViewInteraction clickOk2 = onView(
                allOf(withId(android.R.id.button1)));
        clickOk2.check(matches(isDisplayed()));
        clickOk2.perform(scrollTo(), click());

        Thread.sleep(1000);

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
