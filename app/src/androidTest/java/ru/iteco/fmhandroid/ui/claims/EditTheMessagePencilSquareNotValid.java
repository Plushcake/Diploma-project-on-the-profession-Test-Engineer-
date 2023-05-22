package ru.iteco.fmhandroid.ui.claims;

//Пункт в тест кейсе № 18

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
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
public class EditTheMessagePencilSquareNotValid {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Раздел Claims. Сообщение. Проверяем Editing Claims.")
    @Description("Ввод не валидных значений в поля в разделе Editing Claims")
    public void editTheMessagePencilSquareNotValid() throws InterruptedException {

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

        ViewInteraction clickAdd = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        clickAdd.perform(click());

       new InputNewClaim().inputNewClaim();

        ViewInteraction clickListRecycler = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickListRecycler.check(matches(isDisplayed()));
        clickListRecycler.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction clickStatusProcessing1 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusProcessing1.perform(scrollTo());
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
        clickEditProcessing.perform(scrollTo());
        clickEditProcessing.check(matches(isDisplayed()));
        clickEditProcessing.perform(click());

        Thread.sleep(1000);

        ViewInteraction textInputTitle = onView(
                allOf(withId(R.id.title_edit_text)));
        textInputTitle.check(matches(isDisplayed()));
        textInputTitle.perform(click());
        textInputTitle.perform(clearText());
        textInputTitle.perform(typeText("HelloWorld:Title12345678901234567890123456789012345678901234567890123456789078"), closeSoftKeyboard());
        //textInputTitle.check(matches(withText("HelloWorld:Title1234567890123456789012345678901234")));
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
        //textInputDescription.check(matches(withText("HelloWorld:Description12345678901234567890123456789012345678901234567890123456789072")));
        Thread.sleep(2000);

        ViewInteraction clickSave2 = onView(
                allOf(withId(R.id.save_button)));
        clickSave2.check(matches(isDisplayed()));
        clickSave2.perform(scrollTo(), click());

        ViewInteraction clickStatusProcessing = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusProcessing.perform(scrollTo());
        clickStatusProcessing.check(matches(isDisplayed()));
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

        new LogOut().logOut();
    }

}
