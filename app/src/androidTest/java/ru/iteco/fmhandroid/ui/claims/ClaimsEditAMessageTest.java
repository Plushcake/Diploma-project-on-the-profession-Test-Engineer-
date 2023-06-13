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

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsEditAMessageTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Test
    @DisplayName("Раздел Claims. Проверка редактирования сообщения")
    public void claimsEditAMessageTest() throws InterruptedException {
        new LogInSteps().logIn();
        ViewInteraction clickMainMenu = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu.check(matches(isDisplayed()));
        clickMainMenu.perform(click());

        ViewInteraction clickClaims = onView(
                anyOf(withText("Claims"), withText("Заявки")));
        clickClaims.check(matches(isDisplayed()));
        clickClaims.perform(click());
        Thread.sleep(2000);

        ViewInteraction clickFilter = onView(
                allOf(withId(R.id.filters_material_button)));
        clickFilter.perform(click());

        ViewInteraction clickFilterInProgress = onView(
                allOf(withId(R.id.item_filter_in_progress)));
        clickFilterInProgress.perform(scrollTo(), click());

        ViewInteraction clickOk = onView(
                allOf(withId(R.id.claim_list_filter_ok_material_button)));
        clickOk.perform(scrollTo(), click());
        Thread.sleep(3000);


        ViewInteraction clickMessageOpen = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickMessageOpen.perform(actionOnItemAtPosition(0, click()));

        Thread.sleep(2000);

        ViewInteraction clickAddComment = onView(
                allOf(withId(R.id.add_comment_image_button)));
        clickAddComment.perform(scrollTo());
        clickAddComment.check(matches(isDisplayed()));
        clickAddComment.perform(click());


        ViewInteraction clickCancel = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel.check(matches(isDisplayed()));
        clickCancel.perform(scrollTo(), click());

        Thread.sleep(2000);

        ViewInteraction clickButtonBack1 = onView(
                allOf(withId(R.id.close_image_button)));
        clickButtonBack1.perform(scrollTo());
        clickButtonBack1.check(matches(isDisplayed()));
        clickButtonBack1.perform(click());


        ViewInteraction clickMessageOpen2 = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickMessageOpen2.check(matches(isDisplayed()));
        clickMessageOpen2.perform(actionOnItemAtPosition(0, click()));

        Thread.sleep(1000);

        ViewInteraction clickButtonStatus = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickButtonStatus.perform(scrollTo());
        clickButtonStatus.check(matches(isDisplayed()));
        clickButtonStatus.perform(click());
        pressBack();
        Thread.sleep(2000);

        ViewInteraction clickButtonSetting = onView(
                allOf(withId(R.id.edit_processing_image_button)));
        clickButtonSetting.perform(scrollTo());
        clickButtonSetting.check(matches(isDisplayed()));
        clickButtonSetting.perform(click());

        ViewInteraction clickCancel2 = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel2.check(matches(isDisplayed()));
        clickCancel2.perform(scrollTo(), click());

        ViewInteraction clickOk1 = onView(
                allOf(withId(android.R.id.button1)));
        clickOk1.check(matches(isDisplayed()));
        clickOk1.perform(scrollTo(), click());

        ViewInteraction clickButtonBack2 = onView(
                allOf(withId(R.id.close_image_button)));
        clickButtonBack2.perform(scrollTo());
        clickButtonBack2.check(matches(isDisplayed()));
        clickButtonBack2.perform(click());

        Thread.sleep(2000);

        ViewInteraction clickMessageOpen3 = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickMessageOpen.check(matches(isDisplayed()));
        clickMessageOpen3.perform(actionOnItemAtPosition(0, click()));

        Thread.sleep(2000);

        ViewInteraction clickAddCommentAndEdit = onView(
                allOf(withId(R.id.add_comment_image_button)));
        clickAddCommentAndEdit.perform(scrollTo());
        clickAddCommentAndEdit.check(matches(isDisplayed()));
        clickAddCommentAndEdit.perform(click());
        Thread.sleep(1000);
        ViewInteraction clickAddCommentAndEdit1 = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        clickAddCommentAndEdit1.perform(replaceText("CommentTest"));
        ViewInteraction clickAddCommentAndEdit2 = onView(
                allOf(withId(R.id.save_button)));
        clickAddCommentAndEdit2.perform(click());
        Thread.sleep(2000);

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

        Thread.sleep(2000);

        ViewInteraction clickCancel3 = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel3.check(matches(isDisplayed()));
        clickCancel3.perform(scrollTo(), click());

        ViewInteraction clickButtonBack3 = onView(
                allOf(withId(R.id.close_image_button)));
        clickButtonBack3.perform(scrollTo());
        clickButtonBack3.check(matches(isDisplayed()));
        clickButtonBack3.perform(click());

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
