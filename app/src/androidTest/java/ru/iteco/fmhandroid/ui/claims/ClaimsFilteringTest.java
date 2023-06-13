package ru.iteco.fmhandroid.ui.claims;

//Пункт в тест кейсе № 9

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
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
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsFilteringTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Проверяем фильтрацию сообщений.")
    @Description("Проверяем работоспособность каждого пункта.")
    public void claimsFilteringCheck() throws InterruptedException {
        new LogInSteps().logIn();
        ViewInteraction clickMain = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMain.check(matches(isDisplayed()));
        clickMain.perform(click());

        ViewInteraction clickClaims = onView(
                anyOf(withText("Claims"), withText("Заявки")));
        clickClaims.check(matches(isDisplayed()));
        clickClaims.perform(click());

        ViewInteraction clickButtonFilters1 = onView(
                allOf(withId(R.id.filters_material_button)));
        clickButtonFilters1.check(matches(isDisplayed()));
        clickButtonFilters1.perform(click());

        ViewInteraction clickOpen1 = onView(
                allOf(withId(R.id.item_filter_open)));
        clickOpen1.check(matches(isDisplayed()));
        clickOpen1.perform(scrollTo(), click());

        ViewInteraction clickProgress1 = onView(
                allOf(withId(R.id.item_filter_in_progress)));
        clickProgress1.check(matches(isDisplayed()));
        clickProgress1.perform(scrollTo(), click());

        ViewInteraction clickOk1 = onView(
                allOf(withId(R.id.claim_list_filter_ok_material_button)));
        clickOk1.check(matches(isDisplayed()));
        clickOk1.perform(scrollTo(), click());

        Thread.sleep(3000);


        ViewInteraction checkButtonRefresh = onView(
                allOf(withId(R.id.claim_retry_material_button),
                        withParent(allOf(withId(R.id.all_claims_cards_block_constraint_layout),
                                withParent(withId(R.id.container_list_claim_include))))));
        checkButtonRefresh.check(matches(isDisplayed()));

        ViewInteraction clickButtonFilters2 = onView(
                allOf(withId(R.id.filters_material_button)));
        clickButtonFilters2.check(matches(isDisplayed()));
        clickButtonFilters2.perform(click());

        ViewInteraction clickOpen2 = onView(
                allOf(withId(R.id.item_filter_open)));
        clickOpen2.check(matches(isDisplayed()));
        clickOpen2.perform(scrollTo(), click());

        ViewInteraction clickProgress2 = onView(
                allOf(withId(R.id.item_filter_in_progress)));
        clickProgress2.check(matches(isDisplayed()));
        clickProgress2.perform(scrollTo(), click());

        ViewInteraction clickExecuted = onView(
                allOf(withId(R.id.item_filter_executed)));
        clickExecuted.check(matches(isDisplayed()));
        clickExecuted.perform(scrollTo(), click());

        ViewInteraction clickCancelled = onView(
                allOf(withId(R.id.item_filter_cancelled)));
        clickCancelled.check(matches(isDisplayed()));
        clickCancelled.perform(scrollTo(), click());

        ViewInteraction clickOk2 = onView(
                allOf(withId(R.id.claim_list_filter_ok_material_button)));
        clickOk2.check(matches(isDisplayed()));
        clickOk2.perform(scrollTo(), click());

        Thread.sleep(3000);

        ViewInteraction clickButtonFilters3 = onView(
                allOf(withId(R.id.filters_material_button)));
        clickButtonFilters3.check(matches(isDisplayed()));
        clickButtonFilters3.perform(click());

        ViewInteraction checkCancel = onView(
                allOf(withId(R.id.claim_filter_cancel_material_button)));
        checkCancel.check(matches(isDisplayed()));

        ViewInteraction clickCancel = onView(
                allOf(withId(R.id.claim_filter_cancel_material_button)));
        clickCancel.check(matches(isDisplayed()));
        clickCancel.perform(scrollTo(), click());
        new LogOutSteps().logOut();
    }

}
