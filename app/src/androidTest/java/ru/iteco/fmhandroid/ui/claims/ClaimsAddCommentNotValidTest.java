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

import androidx.test.espresso.IdlingRegistry;
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
import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsAddCommentNotValidTest {

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
    @DisplayName("В разделе Claims проверка Add comment не валидными значениями. Кириллица, цифры и спец символы.")
    @Description("Символы вводятся")
    public void claimsAddCommentTestCyrillic() {
        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().listRecyclerClaims();
        new ButtonSteps().buttonAddCommentClaims();

        ViewInteraction inputTextComment = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputTextComment.check((matches(isDisplayed())));
        inputTextComment.perform(click());
        inputTextComment.perform(replaceText("ТестКомментария:1234567890И!@#$%^&*(-+)"), closeSoftKeyboard());
        inputTextComment.check(matches(withText("ТестКомментария:1234567890И!@#$%^&*(-+)")));

        new ButtonSteps().buttonSaveCommentClaims();
        new LogOutSteps().logOut();
    }

    @Test
    @DisplayName("В разделе Claims проверка Add comment не валидными значениями. Латиница и цифры")
    @Description("Символы вводятся")
    public void claimsAddCommentTestMore50() {
        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().listRecyclerClaims();
        new ButtonSteps().buttonAddCommentClaims();

        ViewInteraction inputTextComment = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputTextComment.check((matches(isDisplayed())));
        inputTextComment.perform(click());
        inputTextComment.perform(typeText("Comment:1234567890qwertyuiopasdfghjklzxcvbnmpoiuytrew55"), closeSoftKeyboard());
        inputTextComment.check(matches(withText("Comment:1234567890qwertyuiopasdfghjklzxcvbnmpoiuytrew55")));

        new ButtonSteps().buttonSaveCommentClaims();
        new LogOutSteps().logOut();
    }

    @Test
    @DisplayName("В разделе Claims проверка Add comment не валидными значениями. Латиница и специальные символы")
    @Description("Символы вводятся")
    public void claimsAddCommentTestSpecialCharacter() {
        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().listRecyclerClaims();
        new ButtonSteps().buttonAddCommentClaims();

        ViewInteraction inputTextComment = onView(
                anyOf(withHint("Comment"), withHint("Комментарий")));
        inputTextComment.check((matches(isDisplayed())));
        inputTextComment.perform(click());
        inputTextComment.perform(typeText("Comment:!@#$%^&*(-+=_/.)"), closeSoftKeyboard());
        inputTextComment.check(matches(withText("Comment:!@#$%^&*(-+=_/.)")));

        new ButtonSteps().buttonSaveCommentClaims();
        new LogOutSteps().logOut();
    }
}
