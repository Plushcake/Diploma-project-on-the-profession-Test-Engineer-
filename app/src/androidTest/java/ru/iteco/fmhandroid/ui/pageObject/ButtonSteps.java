package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ButtonSteps {
    //Кновка Sign In находящейся в авторизации.
    public void signIn() {
        ViewInteraction clickButton = onView(
                allOf(withId(R.id.enter_button)));
        clickButton.check(matches(isDisplayed()));
        clickButton.perform(click());
    }

    //Нажатие на сообщение в разделе Claims.
    public void listRecyclerClaims() {
        ViewInteraction clickListOpen = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickListOpen.check(matches(isDisplayed()));
        clickListOpen.perform(actionOnItemAtPosition(0, click()));
    }

    //Нажатие на кнопку добавления комментария в разделе Claims в выбранном сообщении.
    public void buttonAddCommentClaims() {
        ViewInteraction clickAddComment = onView(
                allOf(withId(R.id.add_comment_image_button)));
        clickAddComment.perform(scrollTo());
        clickAddComment.check(matches(isDisplayed()));
        clickAddComment.perform(click());
    }
    //Нажатие на кнопку сохранения комментария в разделе Claims в выранном сообщении.
    public void buttonSaveCommentClaims () {
        ViewInteraction clickSaves = onView(
                allOf(withId(R.id.save_button)));
        clickSaves.check(matches(isDisplayed()));
        clickSaves.perform(scrollTo(), click());
    }
}
