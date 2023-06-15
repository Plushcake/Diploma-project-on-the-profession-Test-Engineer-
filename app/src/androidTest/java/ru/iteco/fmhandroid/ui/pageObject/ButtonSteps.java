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

    //Кнопка добавления комментария в разделе Claims, в выбранном сообщении.
    public void buttonAddCommentClaims() {
        ViewInteraction clickAddComment = onView(
                allOf(withId(R.id.add_comment_image_button)));
        clickAddComment.perform(scrollTo());
        clickAddComment.check(matches(isDisplayed()));
        clickAddComment.perform(click());
    }

    //Кнопка смены статуса сообщения в разделе Claims, в выбранном сообщении.
    public void buttonStatusClaims() {
        ViewInteraction clickStatusButton = onView(
                allOf(withId(R.id.status_processing_image_button)));
        clickStatusButton.perform(scrollTo());
        clickStatusButton.check(matches(isDisplayed()));
        clickStatusButton.perform(click());
    }

    //Кнопка "Назад" в разделе Claims в выбранном собщении.
    public void buttonClickBack() {
        ViewInteraction clickBack = onView(
                allOf(withId(R.id.close_image_button)));
        clickBack.perform(scrollTo());
        clickBack.perform(click());
    }

    //Кнопка сохранения комментария в разделе Claims в выбранном сообщении.
    public void buttonSaveCommentClaims() {
        ViewInteraction clickSaves = onView(
                allOf(withId(R.id.save_button)));
        clickSaves.check(matches(isDisplayed()));
        clickSaves.perform(scrollTo(), click());
    }

    //Кнопка Creating Claims в разделе Claims.
    public void buttonCreatingClaims() {
        ViewInteraction clickAdd = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        clickAdd.check(matches(isDisplayed()));
        clickAdd.perform(click());
    }

}
