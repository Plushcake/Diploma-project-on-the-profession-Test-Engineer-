package ru.iteco.fmhandroid.ui.claims;

//Пункт в тест кейсе № 14

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
import ru.iteco.fmhandroid.ui.data.InputNewClaim;
import ru.iteco.fmhandroid.ui.data.LogIn;
import ru.iteco.fmhandroid.ui.data.LogOut;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsEditMessageChangeStatusInProgress1 {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Раздел Claims. Проверяем в сообщении кнопку статус процесса. Проверяем Throw off")
    @Description("Работоспособность пункта Throw off")
    public void ClaimsEditMessageChangeStatusTrowOff() throws InterruptedException {

        new LogIn().logIn();

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

        new InputNewClaim().inputNewClaim();

        ViewInteraction clickRecyclerView2 = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickRecyclerView2.check(matches(isDisplayed()));
        clickRecyclerView2.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction checkInProgress = onView(
                anyOf(withText("In progress"), withText("В работе")));
        checkInProgress.check(matches(isDisplayed()));

        ViewInteraction clickButtonStatus5 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickButtonStatus5.perform(scrollTo());
        clickButtonStatus5.check(matches(isDisplayed()));
        clickButtonStatus5.perform(click());

        ViewInteraction clickThrowOff5 = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickThrowOff5.check(matches(isDisplayed()));
        clickThrowOff5.perform(click());

        ViewInteraction clickOk5 = onView(
                allOf(withId(android.R.id.button1)));
        clickOk5.check(matches(isDisplayed()));
        clickOk5.perform(click());

        Thread.sleep(2000);

        ViewInteraction clickCancel5 = onView(
                allOf(withId(android.R.id.button2)));
        clickCancel5.check(matches(isDisplayed()));
        clickCancel5.perform(click());

        ViewInteraction clickButtonStatus4 = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickButtonStatus4.perform(scrollTo());
        clickButtonStatus4.check(matches(isDisplayed()));
        clickButtonStatus4.perform(click());

        ViewInteraction clickThrowOff2 = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickThrowOff2.check(matches(isDisplayed()));
        clickThrowOff2.perform(click());

        ViewInteraction clickOk = onView(
                allOf(withId(android.R.id.button1)));
        clickOk.check(matches(isDisplayed()));
        clickOk.perform(scrollTo(), click());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.editText)));
        textInputEditText3.check(matches(isDisplayed()));
        textInputEditText3.perform(click());
        textInputEditText3.perform(typeText("Test:1235098!@#$%^&()Qasdrftgyhjuiklop;mnbvcxz<>*=-%_55"));
        textInputEditText3.perform(closeSoftKeyboard());
        textInputEditText3.check(matches(withText("Test:1235098!@#$%^&()Qasdrftgyhjuiklop;mnbvcxz<>*=-%_55")));

        ViewInteraction clickOk2 = onView(
                allOf(withId(android.R.id.button1), withText("OK")));
        clickOk2.check(matches(isDisplayed()));
        clickOk2.perform(scrollTo(), click());

        ViewInteraction checkStatusOpen = onView(
                anyOf(withText("Open"), withText("Открыта")));
        checkStatusOpen.check(matches(isDisplayed()));

        Thread.sleep(1000);

        ViewInteraction clickStatus = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatus.perform(scrollTo());
        clickStatus.check(matches(isDisplayed()));
        clickStatus.perform(click());

        ViewInteraction clickToCancel = onView(
                anyOf(withText("Cancel"), withText("Отменить")));
        clickToCancel.check(matches(isDisplayed()));
        clickToCancel.perform(click());

        Thread.sleep(1000);

        new LogOut().logOut();

    }
}

