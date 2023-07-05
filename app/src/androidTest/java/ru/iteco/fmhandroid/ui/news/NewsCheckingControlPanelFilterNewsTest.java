package ru.iteco.fmhandroid.ui.news;
//Пункт в тест кейсе № 22

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
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
import ru.iteco.fmhandroid.ui.pageObject.InputNewNewsSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

public class NewsCheckingControlPanelFilterNewsTest {


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
    @DisplayName("Проверяем поля в разделе Filter news")
    @Description("Проверяем заполнение полей. Проверяем Чек боксы на работоспособность")
    public void newsControlPanelFilterNews() {
        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToNews();
        new ButtonNewsSteps().buttonEditNews();
        new ButtonNewsSteps().buttonSortNews();
        new ButtonNewsSteps().buttonSortNews();
        new ButtonNewsSteps().buttonFilterNews();

        ViewInteraction checkTextFilterNews = onView(
                anyOf(withText("Filter news"), withText("Фильтровать новости")));
        checkTextFilterNews.check(matches(isDisplayed()));

        new InputNewNewsSteps().inputFilterValid();

        new ButtonNewsSteps().checkBoxFilterNewsActive();
        new ButtonNewsSteps().checkBoxFilterNewsActive();

        new ButtonNewsSteps().checkBoxFilterNewsInactive();
        new ButtonNewsSteps().checkBoxFilterNewsInactive();
        new ButtonNewsSteps().filterButton();

        ViewInteraction checkTextControlPanel = onView(
                anyOf(withText("Control panel"), withText("Панель \\n управления")));
        checkTextControlPanel.check(matches(isDisplayed()));

        new LogOutSteps().logOut();

    }

}
