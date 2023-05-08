package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 10

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

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ClaimsCreatingClaimsTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void claimsCreatingClaimsTest() throws InterruptedException {
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

        ViewInteraction clickButtonAddNewClaim1 = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        clickButtonAddNewClaim1.check(matches(isDisplayed()));
        clickButtonAddNewClaim1.perform(click());

        ViewInteraction textInputTitle = onView(
                allOf(withId(R.id.title_edit_text)));
        textInputTitle.check(matches(isDisplayed()));
        textInputTitle.perform(typeText("Title:123456789Qwertyuiopasdfghjklzxcvbnm%$&^*#!50"));
        textInputTitle.check(matches(withText("Title:123456789Qwertyuiopasdfghjklzxcvbnm%$&^*#!50")));

        ViewInteraction clickShowDropDownMenu = onView(
                allOf(withId(R.id.executor_drop_menu_text_input_layout)));
        clickShowDropDownMenu.perform(click());

        ViewInteraction clickExecutor = onView(
                allOf(withId(R.id.executor_drop_menu_auto_complete_text_view)));
        clickExecutor.perform(click());
        clickExecutor.perform(pressKey(22));
        Thread.sleep(1000);
        clickExecutor.perform(pressKey(66));
        Thread.sleep(1000);
        clickExecutor.perform(pressKey(20), pressKey(66), closeSoftKeyboard());
        Thread.sleep(4000);
        clickExecutor.check(matches(withText("Ivanov Ivan Ivanovich")));

        ViewInteraction editDate = onView(
                allOf(withId(R.id.date_in_plan_text_input_edit_text)));
        editDate.perform(replaceText("01.09.2010"));
        editDate.check(matches(isDisplayed()));


        ViewInteraction editTime = onView(
                allOf(withId(R.id.time_in_plan_text_input_edit_text)));
        editTime.perform(replaceText("12:15"));
        editTime.check(matches(isDisplayed()));


        ViewInteraction textInputEditDescription = onView(
                allOf(withId(R.id.description_edit_text)));
        textInputEditDescription.check(matches(isDisplayed()));
        textInputEditDescription.perform(typeText("HelloTest&1*5%2@"), closeSoftKeyboard());


        ViewInteraction clickSave = onView(
                allOf(withId(R.id.save_button)));
        clickSave.check(matches(isDisplayed()));
        clickSave.perform(scrollTo(), click());
        Thread.sleep(2000);


        ViewInteraction clickRecyclerView = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickRecyclerView.check(matches(isDisplayed()));
        clickRecyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction clickStatusProcessing = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusProcessing.check(matches(isDisplayed()));
        clickStatusProcessing.perform(click());
        ViewInteraction clickStatusThrowOff = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickStatusThrowOff.perform(click());

        ViewInteraction checkTextCommentThrowOff = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        checkTextCommentThrowOff.check(matches(isDisplayed()));
        checkTextCommentThrowOff.perform(typeText("Trow_Off_Test"));

        ViewInteraction clickSaves2 = onView(
                allOf(withId(android.R.id.button1)));
        clickSaves2.perform(scrollTo(), click());

        ViewInteraction clickStatusButton2 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton2.perform(scrollTo());
        clickStatusButton2.perform(click());

        ViewInteraction clickStatusCancel = onView(
                anyOf(withText("Cancel"), withText("Отменить")));
        clickStatusCancel.perform(click());

        ViewInteraction clickButtonBack2 = onView(
                allOf(withId(R.id.close_image_button)));
        clickButtonBack2.check(matches(isDisplayed()));
        clickButtonBack2.perform(click());


        ViewInteraction clickButtonAddNewClaim2 = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        clickButtonAddNewClaim2.check(matches(isDisplayed()));
        clickButtonAddNewClaim2.perform(click());

        ViewInteraction clickCancel = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel.check(matches(isDisplayed()));
        clickCancel.perform(scrollTo(), click());

        ViewInteraction checkTextMessage = onView(
                anyOf(withText("The changes won't be saved, do you really want to log out?"),
                        withText("Изменения не будут сохранены. Вы действительно хотите выйти?")));
        checkTextMessage.check(matches(isDisplayed()));

        ViewInteraction clickOk3 = onView(
                allOf(withId(android.R.id.button1)));
        clickOk3.check(matches(isDisplayed()));
        clickOk3.perform(scrollTo(), click());

        ViewInteraction checkTextClaims2 = onView(
                anyOf(withText("Claims"), withText("Заявки")));
        checkTextClaims2.check(matches(isDisplayed()));

        ViewInteraction clickButtonAddNewClaim3 = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        clickButtonAddNewClaim3.check(matches(isDisplayed()));
        clickButtonAddNewClaim3.perform(click());

        ViewInteraction clickCancel2 = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel2.check(matches(isDisplayed()));
        clickCancel2.perform(scrollTo(), click());

        ViewInteraction clickCancel3 = onView(
                allOf(withId(android.R.id.button2)));
        clickCancel3.check(matches(isDisplayed()));
        clickCancel3.perform(scrollTo(), click());


        ViewInteraction clickCancel4 = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel4.check(matches(isDisplayed()));
        clickCancel4.perform(scrollTo(), click());

        Thread.sleep(2000);

        ViewInteraction clickOk4 = onView(
                allOf(withId(android.R.id.button1)));
        clickOk4.check(matches(isDisplayed()));
        clickOk4.perform(scrollTo(), click());

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
