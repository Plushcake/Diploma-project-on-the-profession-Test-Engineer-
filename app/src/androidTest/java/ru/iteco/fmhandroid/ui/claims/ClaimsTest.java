package ru.iteco.fmhandroid.ui.claims;

//Пункт в тест кейсе № 8

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
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
import ru.iteco.fmhandroid.ui.data.LogIn;
import ru.iteco.fmhandroid.ui.data.LogOut;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Раздел Claims. Проходимся по всем разделам.")
    @Description("Прокликивание в Claims-е всех разделов")
    public void claimsTest() throws InterruptedException {
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

        ViewInteraction clickCancel2 = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel2.check(matches(isDisplayed()));
        clickCancel2.perform(scrollTo(), click());

        ViewInteraction clickOk = onView(
                allOf(withId(android.R.id.button1)));
        clickOk.check(matches(isDisplayed()));
        clickOk.perform(scrollTo(), click());

        Thread.sleep(2000);

        ViewInteraction clickClaimsList = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickClaimsList.check(matches(isDisplayed()));
        clickClaimsList.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction checkButtonChangeStatus = onView(
                allOf(withId(R.id.status_processing_image_button)));
        checkButtonChangeStatus.perform(scrollTo());
        checkButtonChangeStatus.check(matches(isDisplayed()));
        new LogOut().logOut();
    }

}
