package ru.iteco.fmhandroid.ui;

//Пункт в тест кейсе № 8

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
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
public class ClaimsTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void claimsTest() throws InterruptedException {
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

        ViewInteraction checkClaim = onView(
                allOf(withId(R.id.container_list_claim_include)));
        checkClaim.check(matches(isDisplayed()));


        ViewInteraction clickButtonFilter = onView(
                allOf(withId(R.id.filters_material_button)));
        clickButtonFilter.check(matches(isDisplayed()));
        clickButtonFilter.perform(click());

        ViewInteraction checkTextFiltering = onView(
                anyOf(withText("Filtering"), withText("Фильтрация")));
        checkTextFiltering.check(matches(isDisplayed()));


        ViewInteraction clickCancel1 = onView(
                allOf(withId(R.id.claim_filter_cancel_material_button)));
        clickCancel1.check(matches(isDisplayed()));
        clickCancel1.perform(scrollTo(), click());

        ViewInteraction clickAddNewClaims = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        clickAddNewClaims.check(matches(isDisplayed()));
        clickAddNewClaims.perform(click());


        Thread.sleep(2000);


        ViewInteraction checkTextCreating = onView(
                anyOf(withText("Creating"), withText("Создание")));
        checkTextCreating.check(matches(isDisplayed()));
        checkTextCreating.check(matches(withText("Creating")));


        ViewInteraction clickCancel2 = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel2.check(matches(isDisplayed()));
        clickCancel2.perform(scrollTo(), click());

        ViewInteraction clickOk = onView(
                allOf(withId(android.R.id.button1)));
        clickOk.check(matches(isDisplayed()));
        clickOk.perform(scrollTo(), click());

        ViewInteraction clickClaimsList = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickClaimsList.check(matches(isDisplayed()));
        clickClaimsList.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction checkButtonChangeStatus = onView(
                allOf(withId(R.id.status_processing_image_button)));
        checkButtonChangeStatus.check(matches(isDisplayed()));


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
