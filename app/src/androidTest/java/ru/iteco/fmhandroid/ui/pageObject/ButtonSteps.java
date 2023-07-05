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

    //Кнопка добавления комментария в разделе Claims, в выбранном сообщении (Add Comment).
    public void buttonAddCommentClaims() {
        ViewInteraction clickAddComment = onView(
                allOf(withId(R.id.add_comment_image_button)));
        clickAddComment.perform(scrollTo());
        clickAddComment.check(matches(isDisplayed()));
        clickAddComment.perform(click());
    }

    //Кнопка Cancel в разделе добавить комментарий (Add Comment).
    public void buttonCancelInAddCommentClaims() {
        ViewInteraction clickCancelInAddCommentClaims = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancelInAddCommentClaims.check(matches(isDisplayed()));
        clickCancelInAddCommentClaims.perform(scrollTo(), click());
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
        clickBack.check(matches(isDisplayed()));
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
        ViewInteraction clickAddNewClaims = onView(
                allOf(withId(R.id.add_new_claim_material_button)));
        clickAddNewClaims.check(matches(isDisplayed()));
        clickAddNewClaims.perform(click());
    }

    //Кнопка Cancel в разделе Creating Claims.
    public void buttonCancelCreatingClaims() {
        ViewInteraction clickCancel = onView(
                allOf(withId(R.id.cancel_button)));
        clickCancel.check(matches(isDisplayed()));
        clickCancel.perform(scrollTo(), click());
    }

    //Кнопка Editing Claims. Переход в разделе Editing Claims
    public void buttonEditingClaims() {
        ViewInteraction clickButtonEditClaims = onView(
                allOf(withId(R.id.edit_processing_image_button)));
        clickButtonEditClaims.perform(scrollTo());
        clickButtonEditClaims.check(matches(isDisplayed()));
        clickButtonEditClaims.perform(click());
    }

    //Выбор сообщения в разделе Love Is All
    public void listRecyclerOurMission() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.our_mission_item_list_recycler_view)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));
    }

    public void buttonOkAlert() {
        ViewInteraction clickOkMessage = onView(
                allOf(withId(android.R.id.button1)));
        clickOkMessage.check(matches(isDisplayed()));
        clickOkMessage.perform(scrollTo(), click());
    }

    public void buttonCancelAlert() {
        ViewInteraction clickCancelMessage = onView(
                allOf(withId(android.R.id.button2)));
        clickCancelMessage.check(matches(isDisplayed()));
        clickCancelMessage.perform(scrollTo(), click());
    }

}
