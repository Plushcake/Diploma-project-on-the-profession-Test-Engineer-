package ru.iteco.fmhandroid.ui.claims;

//Пункт в тест кейсе № 14

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
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
public class ClaimsEditMessageChangeStatusOpen1Test {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Раздел Claims. Проверяем в сообщении кнопку статус процесса. Проверяем Cancel")
    @Description("Работоспособность пункта Cancel")
    public void ClaimsEditMessageChangeStatusCancel() throws InterruptedException {

        new LogInSteps().logIn();

        ViewInteraction clickMainMenu = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu.check(matches(isDisplayed()));
        clickMainMenu.perform(click());

        ViewInteraction clickClaims = onView(
                anyOf(withText("Claims"), withText("Заявки")));
        clickClaims.check(matches(isDisplayed()));
        clickClaims.perform(click());

        Thread.sleep(1000);

        ViewInteraction clickAddNew = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        clickAddNew.check(matches(isDisplayed()));
        clickAddNew.perform(click());

        Thread.sleep(1000);

        new InputNewClaimSteps().inputNewClaim();

        ViewInteraction clickRecyclerView = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickRecyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction clickStatusButton = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton.perform(scrollTo());
        clickStatusButton.check(matches(isDisplayed()));
        clickStatusButton.perform(click());

        ViewInteraction clickThrowOff = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickThrowOff.check(matches(isDisplayed()));
        clickThrowOff.perform(click());

        ViewInteraction checkTextCommentThrowOff = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        checkTextCommentThrowOff.check(matches(isDisplayed()));
        checkTextCommentThrowOff.perform(typeText("Trow_Off_Test"));

        ViewInteraction clickSaves2 = onView(
                allOf(withId(android.R.id.button1)));
        clickSaves2.perform(scrollTo(), click());

        ViewInteraction checkStatusOpen = onView(
                anyOf(withText("Open"), withText("Открыта")));
        checkStatusOpen.check(matches(isDisplayed()));

        ViewInteraction clickButtonStatus = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickButtonStatus.perform(scrollTo());
        clickButtonStatus.check(matches(isDisplayed()));
        clickButtonStatus.perform(click());

        ViewInteraction clickStatusCancel = onView(
                anyOf(withText("Cancel"), withText("Отменить")));
        clickStatusCancel.check(matches(isDisplayed()));
        clickStatusCancel.perform(click());

        Thread.sleep(2000);

        ViewInteraction checkStatusCanceled = onView(
                anyOf(withText("Canceled"), withText("Отменена")));
        checkStatusCanceled.check(matches(isDisplayed()));

        ViewInteraction clickBack = onView(
                allOf(withId(R.id.close_image_button)));
        clickBack.perform(scrollTo());
        clickBack.check(matches(isDisplayed()));
        clickBack.perform(click());

        Thread.sleep(1000);

        new LogOutSteps().logOut();
    }

}
