package ru.iteco.fmhandroid.ui.pageobject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
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
import androidx.test.espresso.matcher.RootMatchers;

import com.github.javafaker.Faker;

import ru.iteco.fmhandroid.R;

public class InputNewClaimSteps {
    public void inputNewClaimValid() {
        ViewInteraction textInputTitle = onView(
                allOf(withId(R.id.title_edit_text)));
        textInputTitle.check(matches(isDisplayed()));
        textInputTitle.perform(replaceText("Title:123456789Qwertyuiopasdfghjklzxcvbnm%$&^*#!50"));
        textInputTitle.check(matches(withText("Title:123456789Qwertyuiopasdfghjklzxcvbnm%$&^*#!50")));

        ViewInteraction clickExecutor = onView(
                allOf(withId(R.id.executor_drop_menu_auto_complete_text_view)));
        clickExecutor.check(matches(isDisplayed()));
        clickExecutor.perform(click(), closeSoftKeyboard());

        ViewInteraction selectFromTheList =
                onView(withText("Ivanov Ivan Ivanovich"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickExecutor.check(matches(withText("Ivanov Ivan Ivanovich")));

        ViewInteraction editDate = onView(
                allOf(withId(R.id.date_in_plan_text_input_edit_text)));
        editDate.perform(replaceText("01.09.1590"));
        editDate.check(matches(isDisplayed()));


        ViewInteraction editTime = onView(
                allOf(withId(R.id.time_in_plan_text_input_edit_text)));
        editTime.perform(replaceText("12:15"));
        editTime.check(matches(isDisplayed()));


        ViewInteraction textInputEditDescription = onView(
                allOf(withId(R.id.description_edit_text)));
        textInputEditDescription.check(matches(isDisplayed()));
        textInputEditDescription.perform(replaceText("Title:Description123456789Qwertyuiopasdfghjklzx!50"), closeSoftKeyboard());
        textInputEditDescription.check(matches(withText("Title:Description123456789Qwertyuiopasdfghjklzx!50")));


        ViewInteraction clickSave = onView(
                allOf(withId(R.id.save_button)));
        clickSave.check(matches(isDisplayed()));
        clickSave.perform(scrollTo(), click());
    }

    public void inputNewClaimNotValid() {
        ViewInteraction inputTextTitle = onView(
                allOf(withId(R.id.title_edit_text)));
        inputTextTitle.perform(click());
        inputTextTitle.perform(replaceText("ПриветМир:123456781012345678101234567810123456781012345678101234567810"), closeSoftKeyboard());
        inputTextTitle.check(matches(withText("ПриветМир:1234567810123456781012345678101234567810")));

        ViewInteraction clickExecutor = onView(
                allOf(withId(R.id.executor_drop_menu_auto_complete_text_view)));
        clickExecutor.check(matches(isDisplayed()));
        clickExecutor.perform(click(), closeSoftKeyboard());

        ViewInteraction selectFromTheList =
                onView(withText("Ivanov Ivan Ivanovich"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());

        ViewInteraction inputData = onView(
                allOf(withId(R.id.date_in_plan_text_input_edit_text)));
        inputData.perform(replaceText("15.11.1490"), closeSoftKeyboard());

        ViewInteraction inputTime = onView(
                allOf(withId(R.id.time_in_plan_text_input_edit_text)));
        inputTime.perform(replaceText("15:00"), closeSoftKeyboard());

        ViewInteraction inputDescription = onView(
                allOf(withId(R.id.description_edit_text)));
        inputDescription.perform(click());
        inputDescription.perform(replaceText("ПриветМир:12345678101234567810123456781012345678101234567810123456781072"), closeSoftKeyboard());
        inputDescription.check(matches(withText("ПриветМир:12345678101234567810123456781012345678101234567810123456781072")));

        ViewInteraction clickSave = onView(
                allOf(withId(R.id.save_button)));
        clickSave.perform(scrollTo(), click());
    }

    public void inputCreatingClaims() {
        ViewInteraction textInputTitle = onView(
                allOf(withId(R.id.title_edit_text)));
        textInputTitle.check(matches(isDisplayed()));
        textInputTitle.perform(clearText());
        textInputTitle.perform(replaceText("Title:CreatingTest"));
        textInputTitle.check(matches(withText("Title:CreatingTest")));

        ViewInteraction clickExecutor = onView(
                allOf(withId(R.id.executor_drop_menu_auto_complete_text_view)));
        clickExecutor.check(matches(isDisplayed()));
        clickExecutor.perform(click(), closeSoftKeyboard());

        ViewInteraction selectFromTheList =
                onView(withText("Ivanov Ivan Ivanovich"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickExecutor.check(matches(withText("Ivanov Ivan Ivanovich")));

        ViewInteraction editDate = onView(
                allOf(withId(R.id.date_in_plan_text_input_edit_text)));
        editDate.perform(clearText());
        editDate.perform(replaceText("01.09.1490"));
        editDate.check(matches(isDisplayed()));


        ViewInteraction editTime = onView(
                allOf(withId(R.id.time_in_plan_text_input_edit_text)));
        editTime.perform(clearText());
        editTime.perform(replaceText("15:15"));
        editTime.check(matches(isDisplayed()));


        ViewInteraction textInputEditDescription = onView(
                allOf(withId(R.id.description_edit_text)));
        textInputEditDescription.check(matches(isDisplayed()));
        textInputEditDescription.perform(clearText());
        textInputEditDescription.perform(replaceText("Description:CreatingTest"), closeSoftKeyboard());
        textInputEditDescription.check(matches(withText("Description:CreatingTest")));

        ViewInteraction clickSave = onView(
                allOf(withId(R.id.save_button)));
        clickSave.check(matches(isDisplayed()));
        clickSave.perform(scrollTo(), click());
    }

    public void inputCreatingClaimsNotValid() {
        ViewInteraction textInputTitle = onView(
                allOf(withId(R.id.title_edit_text)));
        textInputTitle.check(matches(isDisplayed()));
        textInputTitle.perform(click());
        textInputTitle.perform(clearText());
        textInputTitle.perform(replaceText("HelloWorld:Title12345678901234567890123456789012345678901234567890123456789078"), closeSoftKeyboard());
        textInputTitle.check(matches(withText("HelloWorld:Title1234567890123456789012345678901234")));//android:maxLength="50"

        ViewInteraction clickExecutor = onView(
                allOf(withId(R.id.executor_drop_menu_auto_complete_text_view)));
        clickExecutor.check(matches(isDisplayed()));
        clickExecutor.perform(click(), closeSoftKeyboard());

        ViewInteraction selectFromTheList =
                onView(withText("Ivanov Ivan Ivanovich"))
                        .inRoot(RootMatchers.isPlatformPopup())
                        .perform(click());
        clickExecutor.check(matches(withText("Ivanov Ivan Ivanovich")));

        ViewInteraction textInputDescription = onView(
                allOf(withId(R.id.description_edit_text)));
        textInputDescription.check(matches(isDisplayed()));
        textInputDescription.perform(click());
        textInputDescription.perform(clearText());
        textInputDescription.perform(replaceText("HelloWorld:Description12345678901234567890123456789012345678901234567890123456789072"), closeSoftKeyboard());
        textInputDescription.check(matches(withText("HelloWorld:Description12345678901234567890123456789012345678901234567890123456789072")));//textMultiLine позволяющий сделать текстовое поле многострочным.

        ViewInteraction clickSave = onView(
                allOf(withId(R.id.save_button)));
        clickSave.check(matches(isDisplayed()));
        clickSave.perform(scrollTo(), click());
    }

    public void inputComment() {
        ViewInteraction inputTextComment = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputTextComment.perform(click());
        inputTextComment.perform(replaceText("TestComment:150@#$%()&"));
        inputTextComment.check(matches(withText("TestComment:150@#$%()&")));

    }

    public void inputCommentFaker() {
        Faker faker = new Faker();
        String editMessage = faker.elderScrolls().city();
        ViewInteraction inputTextComment = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputTextComment.perform(click());
        inputTextComment.perform(clearText());
        inputTextComment.perform(replaceText(editMessage));
        inputTextComment.check(matches(withText(editMessage)));

    }

    public void inputCommentStatus() {
        ViewInteraction inputTextCommentThrowOff = onView(
                allOf(withId(R.id.editText)));
        inputTextCommentThrowOff.check(matches(isDisplayed()));
        inputTextCommentThrowOff.perform(click());
        inputTextCommentThrowOff.perform(replaceText("Test:1235098!@#$%^&()Qasdrftgyhjuiklop;mnbvcxz<>*=-%_55"), closeSoftKeyboard());
        inputTextCommentThrowOff.check(matches(withText("Test:1235098!@#$%^&()Qasdrftgyhjuiklop;mnbvcxz<>*=-%_55")));
    }

    public void addCommentTestCyrillic() {
        ViewInteraction inputTextComment = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputTextComment.perform(click());
        inputTextComment.perform(replaceText("ТестКомментария:1234567890И!@#$%^&*(-+)"), closeSoftKeyboard());
        inputTextComment.check(matches(withText("ТестКомментария:1234567890И!@#$%^&*(-+)")));
    }

    public void addCommentTestMore50() {
        ViewInteraction inputTextComment = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputTextComment.perform(click());
        inputTextComment.perform(replaceText("Comment:1234567890qwertyuiopasdfghjklzxcvbnmpoiuytrew55"), closeSoftKeyboard());
        inputTextComment.check(matches(withText("Comment:1234567890qwertyuiopasdfghjklzxcvbnmpoiuytrew55")));
    }

    public void addCommentTestSpecialCharacter() {
        ViewInteraction inputTextComment = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputTextComment.perform(click());
        inputTextComment.perform(typeText("Comment:!@#$%^&*(-+=_/.)"), closeSoftKeyboard());
        inputTextComment.check(matches(withText("Comment:!@#$%^&*(-+=_/.)")));
    }

}
