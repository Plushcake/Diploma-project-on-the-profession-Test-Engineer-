package ru.iteco.fmhandroid.ui.pageobject;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class DateAndTimeSteps {
    //Клик по стрелке в право. Переключение месяца.
    public void nextMonth() {
        ViewInteraction clickNextMonth = onView(
                allOf(withClassName(is("androidx.appcompat.widget.AppCompatImageButton")), withContentDescription("Next month"),
                        childAtPosition(
                                allOf(withClassName(is("android.widget.DayPickerView")),
                                        childAtPosition(
                                                withClassName(is("com.android.internal.widget.DialogViewAnimator")),
                                                0)),
                                2)));
        clickNextMonth.perform(scrollTo(), click());
    }

    //Клик по стрелке в лево. Переключение месяца.
    public void previousMonth() {
        ViewInteraction clickPreviousMonth = onView(
                allOf(withClassName(is("androidx.appcompat.widget.AppCompatImageButton")), withContentDescription("Previous month"),
                        childAtPosition(
                                allOf(withClassName(is("android.widget.DayPickerView")),
                                        childAtPosition(
                                                withClassName(is("com.android.internal.widget.DialogViewAnimator")),
                                                0)),
                                1)));
        clickPreviousMonth.perform(scrollTo(), click());
    }

    //Клик по выбору Года.
    public void choiceOfTheYear() {
        ViewInteraction choiceOfTheYear = onView(
                allOf(withClassName(is("com.google.android.material.textview.MaterialTextView")), withText("2023"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                0),
                        isDisplayed()));
        choiceOfTheYear.perform(click());
    }

    //Появился список годов. Клик по Году 2024.
    public void listOfYears() {
        DataInteraction listOfYears = onData(anything())
                .inAdapterView(allOf(withClassName(is("android.widget.YearPickerView")),
                        childAtPosition(
                                withClassName(is("com.android.internal.widget.DialogViewAnimator")),
                                1)))
                .atPosition(1);
        listOfYears.perform(scrollTo(), click());
    }

    //Смена вида часов, на ввод цифр.
    public void switchToTextInputMode() {
        ViewInteraction switchToTextInputMode = onView(
                allOf(withClassName(is("androidx.appcompat.widget.AppCompatImageButton")), withContentDescription("Switch to text input mode for the time input."),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        4),
                                0),
                        isDisplayed()));
        switchToTextInputMode.perform(click());
    }

    //Смена вида часов, на циферблат.
    public void switchToTextClockMode() {
        ViewInteraction switchToTextClockMode = onView(
                allOf(withClassName(is("androidx.appcompat.widget.AppCompatImageButton")), withContentDescription("Switch to clock mode for the time input."),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        4),
                                0),
                        isDisplayed()));
        switchToTextClockMode.perform(click());
    }



    //Установка времени в часах.
    public void settingTimes() {
        ViewInteraction settingTimes = onView(
                allOf(withClassName(is("androidx.appcompat.widget.AppCompatEditText")),
                        childAtPosition(
                                allOf(withClassName(is("android.widget.RelativeLayout")),
                                        childAtPosition(
                                                withClassName(is("android.widget.TextInputTimePickerView")),
                                                1)),
                                0),
                        isDisplayed()));
        settingTimes.perform(replaceText("15"), closeSoftKeyboard());
    }

    //Установка времени в минутах.
    public void settingMinutes() {
        ViewInteraction settingMinutes = onView(
                allOf(withClassName(is("androidx.appcompat.widget.AppCompatEditText")),
                        childAtPosition(
                                allOf(withClassName(is("android.widget.RelativeLayout")),
                                        childAtPosition(
                                                withClassName(is("android.widget.TextInputTimePickerView")),
                                                1)),
                                3),
                        isDisplayed()));
        settingMinutes.perform(replaceText("25"), closeSoftKeyboard());
    }

    //Установка времени в часах. Не валидные значения.
    public void settingTimesNotValid() {
        ViewInteraction settingTimesNotValid = onView(
                allOf(withClassName(is("androidx.appcompat.widget.AppCompatEditText")),
                        childAtPosition(
                                allOf(withClassName(is("android.widget.RelativeLayout")),
                                        childAtPosition(
                                                withClassName(is("android.widget.TextInputTimePickerView")),
                                                1)),
                                0),
                        isDisplayed()));
        settingTimesNotValid.perform(replaceText("25"), closeSoftKeyboard());
    }

    //Установка времени в минутах. Не валидные значения.
    public void settingMinutesNotValid() {
        ViewInteraction settingMinutesNotValid = onView(
                allOf(withClassName(is("androidx.appcompat.widget.AppCompatEditText")),
                        childAtPosition(
                                allOf(withClassName(is("android.widget.RelativeLayout")),
                                        childAtPosition(
                                                withClassName(is("android.widget.TextInputTimePickerView")),
                                                1)),
                                3),
                        isDisplayed()));
        settingMinutesNotValid.perform(replaceText("61"), closeSoftKeyboard());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
