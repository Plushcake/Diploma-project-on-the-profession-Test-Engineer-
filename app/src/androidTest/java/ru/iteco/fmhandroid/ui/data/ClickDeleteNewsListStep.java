package ru.iteco.fmhandroid.ui.data;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;

public class ClickDeleteNewsListStep {

    public void clickDeleteNewsListStep() throws InterruptedException {
        ViewInteraction clickDeleteNewsListStep = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        clickDeleteNewsListStep.check(matches(isDisplayed()));
        clickDeleteNewsListStep.perform(pressKey(61), pressKey(61), pressKey(61),
                pressKey(61), pressKey(61), pressKey(61));
        clickDeleteNewsListStep.perform(pressKey(61), pressKey(61), pressKey(66));
    }
}
