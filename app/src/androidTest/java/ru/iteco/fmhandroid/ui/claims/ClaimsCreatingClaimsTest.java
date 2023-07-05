package ru.iteco.fmhandroid.ui.claims;

//Пункт в тест кейсе № 10

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
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
import ru.iteco.fmhandroid.ui.pageObject.InputNewClaimSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageObject.StatusProcessingImageClaimsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsCreatingClaimsTest {

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
    @DisplayName("Раздел Claims. Создание Claims. Заполнение полей валидными значениями. Проверка предупреждающих сообщений")
    @Description("Поля заполнены валидными значениями. Claims создается успешно.")
    public void claimsCreatingClaimsTest() {
        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToClaims();
        new ButtonSteps().buttonCreatingClaims();
        new InputNewClaimSteps().inputNewClaimValid();
        new ButtonSteps().listRecyclerClaims();
        new ButtonSteps().buttonStatusClaims();
        new StatusProcessingImageClaimsSteps().statusThrowOff();
        new StatusProcessingImageClaimsSteps().buttonSaveComment();
        new StatusProcessingImageClaimsSteps().inputTextCommentThrowOff();
        new ButtonSteps().buttonStatusClaims();
        new StatusProcessingImageClaimsSteps().statusCancel();
        new ButtonSteps().buttonClickBack();
        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().buttonCancelCreatingClaims();

        ViewInteraction checkTextMessage = onView(
                anyOf(withText("The changes won't be saved, do you really want to log out?"),
                        withText("Изменения не будут сохранены. Вы действительно хотите выйти?")));
        checkTextMessage.check(matches(isDisplayed()));

        ViewInteraction clickOkMessage1 = onView(
                allOf(withId(android.R.id.button1)));
        clickOkMessage1.check(matches(isDisplayed()));
        clickOkMessage1.perform(scrollTo(), click());

        ViewInteraction checkTextClaims = onView(
                anyOf(withText("Claims"), withText("Заявки")));
        checkTextClaims.check(matches(isDisplayed()));

        new ButtonSteps().buttonCreatingClaims();
        new ButtonSteps().buttonCancelCreatingClaims();

        new ButtonSteps().buttonCancelAlert();
        new ButtonSteps().buttonCancelCreatingClaims();
        new ButtonSteps().buttonOkAlert();

        new LogOutSteps().logOut();
    }

}
