package ru.iteco.fmhandroid.ui.claims;
//Пункт в тест кейсе № 13_1

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsAddCommentTestNotValid {

    @Rule
    public ActivityTestRule<AppActivity> mActivityScenarioRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void login() throws InterruptedException {

        Thread.sleep(7000);

        ViewInteraction EnteringLogin = onView(
                anyOf(withHint("Login"), withHint("Логин")));
        EnteringLogin.perform(typeText("login2"), closeSoftKeyboard());

        ViewInteraction EnteringPassword = onView(
                anyOf(withHint("Password"), withHint("Пароль")));
        EnteringPassword.perform(typeText("password2"), closeSoftKeyboard());

        ViewInteraction clickButton = onView(
                allOf(withId(R.id.enter_button)));
        clickButton.perform(click());

        Thread.sleep(3000);

        ViewInteraction clickMainMenu = onView(
                allOf(withId(R.id.main_menu_image_button)));
        clickMainMenu.check(matches(isDisplayed()));
        clickMainMenu.perform(click());

        ViewInteraction clickClaims = onView(
                anyOf(withText("Claims"), withText("Заявки")));
        clickClaims.check(matches(isDisplayed()));
        clickClaims.perform(click());
        Thread.sleep(2000);

    }

    @After
    public void logOut() throws InterruptedException {

        Thread.sleep(2000);
        ViewInteraction clickAuthorization = onView(
                allOf(withId(R.id.authorization_image_button)));
        clickAuthorization.check(matches(isDisplayed()));
        clickAuthorization.perform(click());


        ViewInteraction textViewLogOutTest = onView(
                anyOf(withText("Log out"), withText("Выйти")));
        textViewLogOutTest.check(matches(isDisplayed()));
        textViewLogOutTest.perform(click());
    }

    @Test
    @DisplayName("В разделе Claims проверка Add comment не валидными значениями. Кириллица, цифры и спец символы.")
    @Description("Символы вводятся")
    public void claimsAddCommentTestCyrillic() throws InterruptedException {

        ViewInteraction clickListOpen = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickListOpen.check(matches(isDisplayed()));
        clickListOpen.perform(actionOnItemAtPosition(0, click()));

        Thread.sleep(2000);

        ViewInteraction clickAddComment = onView(
                allOf(withId(R.id.add_comment_image_button)));
        clickAddComment.perform(scrollTo());
        clickAddComment.check(matches(isDisplayed()));
        clickAddComment.perform(click());

        ViewInteraction inputTextComment = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputTextComment.check((matches(isDisplayed())));
        inputTextComment.perform(click());
        inputTextComment.perform(replaceText("ТестКомментария:1234567890И!@#$%^&*(-+)"), closeSoftKeyboard());
        inputTextComment.check(matches(withText("ТестКомментария:1234567890И!@#$%^&*(-+)")));

        Thread.sleep(2000);

        ViewInteraction clickSaves = onView(
                allOf(withId(R.id.save_button)));
        clickSaves.check(matches(isDisplayed()));
        clickSaves.perform(scrollTo(), click());

    }

    @Test
    @DisplayName("В разделе Claims проверка Add comment не валидными значениями. Латиница и цифры")
    @Description("Символы вводятся")
    public void claimsAddCommentTestMore50() throws InterruptedException {

        ViewInteraction clickListOpen = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickListOpen.check(matches(isDisplayed()));
        clickListOpen.perform(actionOnItemAtPosition(0, click()));

        Thread.sleep(2000);

        ViewInteraction clickAddComment = onView(
                allOf(withId(R.id.add_comment_image_button)));
        clickAddComment.perform(scrollTo());
        clickAddComment.check(matches(isDisplayed()));
        clickAddComment.perform(click());

        ViewInteraction inputTextComment = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputTextComment.check((matches(isDisplayed())));
        inputTextComment.perform(click());
        inputTextComment.perform(typeText("Comment:1234567890qwertyuiopasdfghjklzxcvbnmpoiuytrew55"), closeSoftKeyboard());
        inputTextComment.check(matches(withText("Comment:1234567890qwertyuiopasdfghjklzxcvbnmpoiuytrew55")));

        Thread.sleep(2000);

        ViewInteraction clickSaves = onView(
                allOf(withId(R.id.save_button)));
        clickSaves.check(matches(isDisplayed()));
        clickSaves.perform(scrollTo(), click());
    }

    @Test
    @DisplayName("В разделе Claims проверка Add comment не валидными значениями. Латиница и специальные символы")
    @Description("Символы вводятся")
    public void claimsAddCommentTestSpecialCharacter() throws InterruptedException {

        ViewInteraction clickListOpen = onView(
                allOf(withId(R.id.claim_list_recycler_view)));
        clickListOpen.check(matches(isDisplayed()));
        clickListOpen.perform(actionOnItemAtPosition(0, click()));

        Thread.sleep(2000);

        ViewInteraction clickAddComment = onView(
                allOf(withId(R.id.add_comment_image_button)));
        clickAddComment.perform(scrollTo());
        clickAddComment.check(matches(isDisplayed()));
        clickAddComment.perform(click());

        ViewInteraction inputTextComment = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputTextComment.check((matches(isDisplayed())));
        inputTextComment.perform(click());
        inputTextComment.perform(typeText("Comment:!@#$%^&*(-+=_/.)"), closeSoftKeyboard());
        inputTextComment.check(matches(withText("Comment:!@#$%^&*(-+=_/.)")));

        Thread.sleep(2000);

        ViewInteraction clickSaves = onView(
                allOf(withId(R.id.save_button)));
        clickSaves.check(matches(isDisplayed()));
        clickSaves.perform(scrollTo(), click());


    }
}