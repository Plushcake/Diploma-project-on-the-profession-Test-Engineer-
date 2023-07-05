package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class FilterSteps {

    public void buttonFilter() {
        ViewInteraction clickButtonFilters = onView(
                allOf(withId(R.id.filters_material_button)));
        clickButtonFilters.check(matches(isDisplayed()));
        clickButtonFilters.perform(click());
    }

    public void filterOpen() {
        ViewInteraction clickOpen = onView(
                allOf(withId(R.id.item_filter_open)));
        clickOpen.check(matches(isDisplayed()));
        clickOpen.perform(scrollTo(), click());
    }

    public void filterProgress() {
        ViewInteraction clickProgress = onView(
                allOf(withId(R.id.item_filter_in_progress)));
        clickProgress.check(matches(isDisplayed()));
        clickProgress.perform(scrollTo(), click());
    }

    public void filterExecuted() {
        ViewInteraction clickExecuted = onView(
                allOf(withId(R.id.item_filter_executed)));
        clickExecuted.check(matches(isDisplayed()));
        clickExecuted.perform(scrollTo(), click());
    }

    public void filterCancelled() {
        ViewInteraction clickCancelled = onView(
                allOf(withId(R.id.item_filter_cancelled)));
        clickCancelled.check(matches(isDisplayed()));
        clickCancelled.perform(scrollTo(), click());
    }

    public void buttonOk() {
        ViewInteraction buttonOk = onView(
                allOf(withId(R.id.claim_list_filter_ok_material_button)));
        buttonOk.perform(scrollTo(), click());
    }

    public void buttonCancel() {
        ViewInteraction buttonCancel = onView(
                allOf(withId(R.id.claim_filter_cancel_material_button)));
        buttonCancel.check(matches(isDisplayed()));
        buttonCancel.perform(click());
    }
}
