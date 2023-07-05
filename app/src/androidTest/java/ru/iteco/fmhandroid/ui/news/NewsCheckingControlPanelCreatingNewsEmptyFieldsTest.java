package ru.iteco.fmhandroid.ui.news;

//Пункт в тест кейсе № 23

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
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
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.ButtonNewsSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class NewsCheckingControlPanelCreatingNewsEmptyFieldsTest {

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
    @DisplayName("Проверка не заполненых полей в разделе Creating News")
    @Description("В разделе Creating News проверка не заполненых полей. Проверка кнопки Cancel")
    public void newsCheckingControlPanelCreatingNews() {
        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToNews();
        new ButtonNewsSteps().buttonEditNews();
        new ButtonNewsSteps().buttonAddNews();
        new ButtonNewsSteps().buttonSaveNews();

        ViewInteraction checkText = onView(
                anyOf(withText("Creating"), withText("Создание")));
        checkText.check(matches(isDisplayed()));
        checkText.perform(click());

        new ButtonNewsSteps().buttonCancelNews();
        new ButtonNewsSteps().buttonCancelAlert();
        new ButtonNewsSteps().buttonCancelNews();

        ViewInteraction textCheck = onView(
                anyOf(withText("The changes won't be saved, do you really want to log out?"),
                        withText("Изменения не будут сохранены. Вы действительно хотите выйти?")));
        textCheck.check(matches(isDisplayed()));

        new ButtonNewsSteps().buttonOkAlert();

        ViewInteraction checkViewControlPanel = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        checkViewControlPanel.check(matches(isDisplayed()));

        new LogOutSteps().logOut();
    }
}


