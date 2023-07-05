package ru.iteco.fmhandroid.ui.claims;

//Пункт в тест кейсе № 12.

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageObject.FilterSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsEditAMessageTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);
    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }

    @Test
    @DisplayName("Раздел Claims. Проверка редактирования сообщения")
    public void claimsEditAMessageTest() {
        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToClaims();

        new FilterSteps().buttonFilter();
        new FilterSteps().filterProgress();
        new FilterSteps().buttonOk();

        new ButtonSteps().listRecyclerClaims();
        new ButtonSteps().buttonAddCommentClaims();
        new ButtonSteps().buttonCancelInAddCommentClaims();
        new ButtonSteps().buttonClickBack();
        new ButtonSteps().listRecyclerClaims();
        new ButtonSteps().buttonStatusClaims();
        pressBack();
        new ButtonSteps().buttonEditingClaims();
        new ButtonSteps().buttonCancelInAddCommentClaims();

        ViewInteraction clickOkInMassage = onView(
                allOf(withId(android.R.id.button1)));
        clickOkInMassage.check(matches(isDisplayed()));
        clickOkInMassage.perform(scrollTo(), click());

        new ButtonSteps().buttonClickBack();
        new ButtonSteps().listRecyclerClaims();
        new ButtonSteps().buttonAddCommentClaims();

        ViewInteraction inputTextComment = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputTextComment.perform(replaceText("CommentTest"));
        inputTextComment.check(matches(withText("CommentTest")));

        new ButtonSteps().buttonSaveCommentClaims();

        ViewInteraction clickCommentButton = onView(
                allOf(withId(R.id.edit_comment_image_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.claim_comments_list_recycler_view),
                                        0),
                                1)));
        clickCommentButton.perform(scrollTo());
        clickCommentButton.check(matches(isDisplayed()));
        clickCommentButton.perform(click());

        new ButtonSteps().buttonCancelCreatingClaims();
        new ButtonSteps().buttonClickBack();
        new LogOutSteps().logOut();
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
