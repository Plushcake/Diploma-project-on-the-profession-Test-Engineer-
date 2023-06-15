package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;

public class StatusProcessingImageClaimsSteps {
    //Выбор статуса сообщения в разделе Claims.
    public void statusThrowOff() {
        ViewInteraction clickStatusThrowOff = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickStatusThrowOff.perform(scrollTo());
        clickStatusThrowOff.check(matches(isDisplayed()));
        clickStatusThrowOff.perform(click());
    }

    //Выбор статуса сообщения в разделе Claims.
    public void statusCancel() {
        ViewInteraction clickStatusCancel = onView(
                anyOf(withText("Cancel"), withText("Отменить")));
        clickStatusCancel.perform(scrollTo());
       // clickStatusCancel.check(matches(isDisplayed()));
        clickStatusCancel.perform(click());
    }
}
