package ru.iteco.fmhandroid.ui.pageobject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;

public class ButtonMainSteps {

    //Кнопка Назад в разделе About.
    public void buttonBackAbout() {
        ViewInteraction clickBack = onView(
                allOf(withId(R.id.about_back_image_button)));
        clickBack.check(matches(isDisplayed()));
        clickBack.perform(click());
    }

    //Кнопка перехода в раздел Our Mission.
    public void buttonLoveIsAll() {
        ViewInteraction clickButtonLoveIsAll = onView(
                allOf(withId(R.id.our_mission_image_button)));
        clickButtonLoveIsAll.check(matches(isDisplayed()));
        clickButtonLoveIsAll.perform(click());
    }

    //Выбор сообщения News в разделе Main.
    public void containerListNews() {
        ViewInteraction clickButtonListNews = onView(
                allOf(withId(R.id.expand_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container_list_news_include_on_fragment_main),
                                        0),
                                4)));
        clickButtonListNews.check(matches(isDisplayed()));
        clickButtonListNews.perform(click());
    }

    //Двойное нажатие на сообщение в News в разделе Main.
    public void containerListDoubleTapNews() {
        new ButtonMainSteps().containerListNews();
        new ButtonMainSteps().containerListNews();
    }

    //Выбор сообщения News по позиции.
    public void newsListRecycler() {
        ViewInteraction recyclerViewList = onView(
                allOf(withId(R.id.news_list_recycler_view),
                        childAtPosition(
                                withId(R.id.all_news_cards_block_constraint_layout),
                                0)));
        recyclerViewList.check(matches(isDisplayed()));
        recyclerViewList.perform(actionOnItemAtPosition(0, click()));
    }

    //Выбор сообщения News по позиции. Двойное нажатие.
    public void newsListDoubleTapRecycler() {
        new ButtonMainSteps().newsListRecycler();
        new ButtonMainSteps().newsListRecycler();
    }


    //Выбор сообщения Claims по позиции.
    public void claimsListRecycler() {
        ViewInteraction recyclerViewClaims = onView(
                allOf(withId(R.id.claim_list_recycler_view),
                        childAtPosition(
                                withId(R.id.all_claims_cards_block_constraint_layout),
                                4)));
        recyclerViewClaims.check(matches(isDisplayed()));
        recyclerViewClaims.perform(actionOnItemAtPosition(0, click()));
    }

    //Выбор сообщения Claims в разделе Main.
    public void containerListClaims() {
        ViewInteraction clickButtonListClaims = onView(
                allOf(withId(R.id.expand_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container_list_claim_include_on_fragment_main),
                                        0),
                                3)));
        clickButtonListClaims.check(matches(isDisplayed()));
        clickButtonListClaims.perform(click());
    }

    public void containerListDoubleTapClaims() {
        new ButtonMainSteps().containerListClaims();
        new ButtonMainSteps().containerListClaims();
    }

    //Кнопка All News в разделе Main.
    public void buttonAllNews() {
        ViewInteraction clickAllNews = onView((withId(R.id.all_news_text_view)));
        clickAllNews.check(matches(isDisplayed()));
        clickAllNews.perform(click());
    }

    //Кнопка All Claims в разделе Main.
    public void buttonAllClaims() {
        ViewInteraction clickAllClaims = onView(
                allOf(withId(R.id.all_claims_text_view),
                        childAtPosition(
                                allOf(withId(R.id.container_list_claim_include_on_fragment_main),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                1)),
                                1)));
        clickAllClaims.check(matches(isDisplayed()));
        clickAllClaims.perform(click());
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
