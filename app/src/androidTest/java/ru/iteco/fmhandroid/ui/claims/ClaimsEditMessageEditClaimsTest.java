package ru.iteco.fmhandroid.ui.claims;

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
import ru.iteco.fmhandroid.ui.pageObject.InputNewClaimSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsEditMessageEditClaimsTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Раздел Claims. Проверяем раздел Editing Claims")
    @Description("Ввод в поля валидные значения")
    public void claimsEditMessageEditClaims() throws InterruptedException {
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

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction clickStatusButton = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton.perform(scrollTo());
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
                anyOf(withText("Open"), withText("Открыта")));
        checkText.check(matches(isDisplayed()));

        ViewInteraction clickEditProcessing = onView(
                allOf(withId(R.id.edit_processing_image_button)));
        clickEditProcessing.perform(scrollTo());
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
        clickEditProcessing2.perform(scrollTo());
        clickEditProcessing2.check(matches(isDisplayed()));
        clickEditProcessing2.perform(click());

        ViewInteraction inputTittleText = onView(
                allOf(withId(R.id.title_edit_text)));
        inputTittleText.perform(clearText());
        inputTittleText.perform(typeText("Claims:123456789!@#$%^&*()"));
        inputTittleText.check(matches(withText("Claims:123456789!@#$%^&*()")));

        ViewInteraction clickExecutor2 = onView(
                allOf(withId(R.id.executor_drop_menu_auto_complete_text_view)));
        clickExecutor2.check(matches(isDisplayed()));
        clickExecutor2.perform(click(), closeSoftKeyboard());
        Thread.sleep(2000);

        ViewInteraction selectFromTheList2 =
                onView(withText("Ivanov Ivan Ivanovich"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());

        ViewInteraction inputDate = onView(
                allOf(withId(R.id.date_in_plan_text_input_edit_text)));
        inputDate.perform(clearText());
        inputDate.perform(replaceText("25.11.1992"), closeSoftKeyboard());
        inputDate.check(matches(withText("25.11.1992")));

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
        clickStatusButton2.perform(scrollTo());
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
        new LogOutSteps().logOut();
    }
}