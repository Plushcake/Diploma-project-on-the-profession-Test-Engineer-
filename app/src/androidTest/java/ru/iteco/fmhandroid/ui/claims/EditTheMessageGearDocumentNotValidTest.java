package ru.iteco.fmhandroid.ui.claims;

//Пункт в тест кейсе № 17

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
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
import ru.iteco.fmhandroid.ui.pageObject.InputNewClaimSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class EditTheMessageGearDocumentNotValidTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Раздел Claims. Сообщение. Статус процесса Throw off и To execute ввод не валидных згачений.  ")
    @Description("Ввод не валидных значений в поля для комментариев")
    public void editTheMessageGearDocumentNotValid() throws InterruptedException {
        new LogInSteps().logIn();
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

        new InputNewClaimSteps().inputNewClaim();

        ViewInteraction clickClaimListRecycler = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickClaimListRecycler.check(matches(isDisplayed()));
        clickClaimListRecycler.perform(actionOnItemAtPosition(0, click()));


        ViewInteraction clickStatusButton2 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton2.perform(scrollTo());
        clickStatusButton2.check(matches(isDisplayed()));
        clickStatusButton2.perform(click());

        ViewInteraction clickStatusThrowOff = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickStatusThrowOff.check(matches(isDisplayed()));
        clickStatusThrowOff.perform(click());

        ViewInteraction inputTextComment = onView(
                allOf(withId(R.id.editText)));
        inputTextComment.perform(typeText("HelloWorld:12345678901234567890123456789012345678901234567890123456789072"), closeSoftKeyboard());
        inputTextComment.check(matches(withText("HelloWorld:12345678901234567890123456789012345678901234567890123456789072")));

        ViewInteraction clickOk = onView(
                allOf(withId(android.R.id.button1)));
        clickOk.check(matches(isDisplayed()));
        clickOk.perform(scrollTo(), click());

        ViewInteraction clickStatusButton3 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton3.perform(scrollTo());
        clickStatusButton3.check(matches(isDisplayed()));
        clickStatusButton3.perform(click());

        ViewInteraction clickTakeToWork = onView(
                anyOf(withText("take to work"), withText("В работу")));
        clickTakeToWork.check(matches(isDisplayed()));
        clickTakeToWork.perform(click());

        ViewInteraction clickStatusButton4 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton4.perform(scrollTo());
        clickStatusButton4.check(matches(isDisplayed()));
        clickStatusButton4.perform(click());

        ViewInteraction clickToExecute = onView(
                anyOf(withText("To execute"), withText("Исполнить")));
        clickToExecute.check(matches(isDisplayed()));
        clickToExecute.perform(click());

        ViewInteraction inputTextComment2 = onView(
                allOf(withId(R.id.editText)));
        inputTextComment2.perform(click());
        inputTextComment2.perform(typeText("HelloWorld:1234567890123456789012345678901234567890123456789012345678907274"), closeSoftKeyboard());
        inputTextComment2.check(matches(withText("HelloWorld:1234567890123456789012345678901234567890123456789012345678907274")));

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
        new LogOutSteps().logOut();
    }
}
