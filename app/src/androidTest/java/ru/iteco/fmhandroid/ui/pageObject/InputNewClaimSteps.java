package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;

import ru.iteco.fmhandroid.R;

public class InputNewClaimSteps {
    public void inputNewClaim() {
        ViewInteraction textInputTitle = onView(
                allOf(withId(R.id.title_edit_text)));
        textInputTitle.check(matches(isDisplayed()));
        textInputTitle.perform(typeText("Title:123456789Qwertyuiopasdfghjklzxcvbnm%$&^*#!50"));
        textInputTitle.check(matches(withText("Title:123456789Qwertyuiopasdfghjklzxcvbnm%$&^*#!50")));

        ViewInteraction clickExecutor = onView(
                allOf(withId(R.id.executor_drop_menu_auto_complete_text_view)));
        clickExecutor.check(matches(isDisplayed()));
        clickExecutor.perform(click(), closeSoftKeyboard());

        ViewInteraction selectFromTheList =
                onView(withText("Ivanov Ivan Ivanovich"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickExecutor.check(matches(withText("Ivanov Ivan Ivanovich")));

        ViewInteraction editDate = onView(
                allOf(withId(R.id.date_in_plan_text_input_edit_text)));
        editDate.perform(replaceText("01.09.1990"));
        editDate.check(matches(isDisplayed()));


        ViewInteraction editTime = onView(
                allOf(withId(R.id.time_in_plan_text_input_edit_text)));
        editTime.perform(replaceText("12:15"));
        editTime.check(matches(isDisplayed()));


        ViewInteraction textInputEditDescription = onView(
                allOf(withId(R.id.description_edit_text)));
        textInputEditDescription.check(matches(isDisplayed()));
        textInputEditDescription.perform(typeText("Title:Description123456789Qwertyuiopasdfghjklzx!50"), closeSoftKeyboard());
        textInputEditDescription.check(matches(withText("Title:Description123456789Qwertyuiopasdfghjklzx!50")));


        ViewInteraction clickSave = onView(
                allOf(withId(R.id.save_button)));
        clickSave.check(matches(isDisplayed()));
        clickSave.perform(scrollTo(), click());
    }
}
