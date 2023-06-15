package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;

import ru.iteco.fmhandroid.R;

public class MoveThroughCategoryInCreateEditSteps {

    public void moveThroughCategoryInCreateEdit() {

        ViewInteraction checkInputTitle = onView(
                allOf(withId(R.id.news_item_title_text_input_edit_text)));
        checkInputTitle.perform(clearText());

        ViewInteraction clickCategory1 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory1.check(matches(isDisplayed()));
        clickCategory1.perform(clearText());
        clickCategory1.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory1 =
                onView(withText("Объявление"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        checkInputTitle.check(matches(withText("Объявление")));


        ViewInteraction clickCategory2 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory2.check(matches(isDisplayed()));
        clickCategory2.perform(clearText());
        clickCategory2.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory2 =
                onView(withText("День рождения"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        checkInputTitle.check(matches(withText("День рождения")));


        ViewInteraction clickCategory3 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory3.check(matches(isDisplayed()));
        clickCategory3.perform(clearText());
        clickCategory3.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory3 =
                onView(withText("Зарплата"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        checkInputTitle.check(matches(withText("Зарплата")));


        ViewInteraction clickCategory4 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory4.check(matches(isDisplayed()));
        clickCategory4.perform(clearText());
        clickCategory4.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory4 =
                onView(withText("Профсоюз"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        checkInputTitle.check(matches(withText("Профсоюз")));


        ViewInteraction clickCategory5 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory5.check(matches(isDisplayed()));
        clickCategory5.perform(clearText());
        clickCategory5.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory5 =
                onView(withText("Праздник"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        checkInputTitle.check(matches(withText("Праздник")));


        ViewInteraction clickCategory6 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory6.check(matches(isDisplayed()));
        clickCategory6.perform(clearText());
        clickCategory6.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory6 =
                onView(withText("Массаж"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        checkInputTitle.check(matches(withText("Массаж")));


        ViewInteraction clickCategory7 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory7.check(matches(isDisplayed()));
        clickCategory7.perform(clearText());
        clickCategory7.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory7 =
                onView(withText("Благодарность"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        checkInputTitle.check(matches(withText("Благодарность")));


        ViewInteraction clickCategory8 = onView(
                allOf(withId(R.id.news_item_category_text_auto_complete_text_view)));
        clickCategory8.check(matches(isDisplayed()));
        clickCategory8.perform(clearText());
        clickCategory8.perform(click(), closeSoftKeyboard());

        ViewInteraction moveThroughCategory8 =
                onView(withText("Нужна помощь"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        checkInputTitle.check(matches(withText("Нужна помощь")));
    }
}
