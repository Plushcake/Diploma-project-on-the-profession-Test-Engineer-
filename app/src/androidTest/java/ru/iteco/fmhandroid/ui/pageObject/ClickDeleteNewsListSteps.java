package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;

import ru.iteco.fmhandroid.R;

public class ClickDeleteNewsListSteps {

    public void clickDeleteNewsListStep() {
        ViewInteraction clickDeleteNewsListStep = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        clickDeleteNewsListStep.check(matches(isDisplayed()));
        clickDeleteNewsListStep.perform(pressKey(61), pressKey(61), pressKey(61),
                pressKey(61), pressKey(61), pressKey(61));
        clickDeleteNewsListStep.perform(pressKey(61), pressKey(61), pressKey(66));
    }

    public void buttonDeleteNews() {
        onView(allOf(withId(R.id.delete_news_item_image_view),
                isDescendantOfA(allOf(withId(R.id.news_item_material_card_view),
                        hasDescendant(allOf(withId(R.id.news_item_title_text_view), withText("Test button delete news"))))))).perform(click());
    }

    public void buttonDeleteExperiment() {
        onView(withId(R.id.news_list_recycler_view)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0, ChildViewWithIdStep.clickChildViewWithIdStep(R.id.delete_news_item_image_view)));
    }

}


