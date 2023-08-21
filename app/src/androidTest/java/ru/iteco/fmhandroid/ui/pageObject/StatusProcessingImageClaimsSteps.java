package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class StatusProcessingImageClaimsSteps {
    //Выбор статуса сообщения в разделе Claims.
    public void statusThrowOff() {
        ViewInteraction clickStatusThrowOff = onView(
                anyOf(withText("Throw off"), withText("Сбросить")));
        clickStatusThrowOff.perform(scrollTo());
        clickStatusThrowOff.check(matches(isDisplayed()));
        clickStatusThrowOff.perform(click());
    }

    //Выбор статуса сообщения в разделе Claims
    public void statusToExecute() {
        ViewInteraction clickStatusToExecute = onView(
                anyOf(withText("To execute"), withText("Исполнить")));
        clickStatusToExecute.check(matches(isDisplayed()));
        clickStatusToExecute.perform(click());
    }

    //Выбор статуса сообщения в разделе Claims
    public void statusTakeToWork() {
        ViewInteraction clickStatusTakeToWork = onView(
                anyOf(withText("take to work"), withText("В работу")));
        clickStatusTakeToWork.check(matches(isDisplayed()));
        clickStatusTakeToWork.perform(click());
    }

    //Ввод символов в поле комментарий через Hint
    public void inputTextCommentThrowOff() {
        ViewInteraction inputTextCommentThrowOff = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputTextCommentThrowOff.check(matches(isDisplayed()));
        inputTextCommentThrowOff.perform(typeText("Trow_Off_Test"));
        inputTextCommentThrowOff.check(matches(withText("Trow_Off_Test")));
    }

    //Ввод не валидных символов в поле комментарий
    public void inputTextCommentThrowOffNotValid() {
        ViewInteraction inputTextCommentThrowOff = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputTextCommentThrowOff.check(matches(isDisplayed()));
        inputTextCommentThrowOff.perform(typeText("HelloWorld:12345678901234567890123456789012345678901234567890123456789072"));
        inputTextCommentThrowOff.check(matches(withText("HelloWorld:12345678901234567890123456789012345678901234567890123456789072")));
    }

    //Ввод символов в поле комментарий через ID.
    public void inputTextCommentExecute() {
        ViewInteraction inputTextCommentExecute = onView(
                allOf(withId(R.id.editText)));
        inputTextCommentExecute.check(matches(isDisplayed()));
        inputTextCommentExecute.perform(typeText("TestExecuteClose"), closeSoftKeyboard());
        inputTextCommentExecute.check(matches(withText("TestExecuteClose")));
    }

    //Ввод не валидных символов в поле коментарий.
    public void inputTextCommentExecuteNotValid() {
        ViewInteraction inputTextCommentExecute = onView(
                allOf(withId(R.id.editText)));
        inputTextCommentExecute.check(matches(isDisplayed()));
        inputTextCommentExecute.perform(typeText("HelloWorld:1234567890123456789012345678901234567890123456789012345678907274"), closeSoftKeyboard());
        inputTextCommentExecute.check(matches(withText("HelloWorld:1234567890123456789012345678901234567890123456789012345678907274")));
    }

    //Кнопка сохранения или кнопка Ok.
    public void buttonSaveComment() {
        ViewInteraction buttonSaveComment = onView(
                allOf(withId(android.R.id.button1)));
        buttonSaveComment.check(matches(isDisplayed()));
        buttonSaveComment.perform(click());
    }

    //Кнопка отмена.
    public void buttonCancelComment() {
        ViewInteraction buttonCancelComment = onView(
                allOf(withId(android.R.id.button2)));
        buttonCancelComment.check(matches(isDisplayed()));
        buttonCancelComment.perform(click());

    }

    //Выбор статуса сообщения в разделе Claims.
    public void statusCancel() {
        ViewInteraction clickStatusCancel = onView(
                anyOf(withText("Cancel"), withText("Отменить")));
        clickStatusCancel.perform(scrollTo());
        clickStatusCancel.check(matches(isDisplayed()));
        clickStatusCancel.perform(click());
    }

}
