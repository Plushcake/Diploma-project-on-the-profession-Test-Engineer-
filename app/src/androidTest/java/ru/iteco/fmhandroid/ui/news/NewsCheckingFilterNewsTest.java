package ru.iteco.fmhandroid.ui.news;

//Пункт в тест кейсе № 20

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

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
import ru.iteco.fmhandroid.ui.pageObject.ButtonNewsSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.InputNewNewsSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;
import ru.iteco.fmhandroid.ui.pageObject.MoveThroughCategoryInFilterNewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsCheckingFilterNewsTest {

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
    @DisplayName("Проверка раздела Filter News")
    @Description("Проверка полей на работоспособность")
    public void newsCheckingFilterNews() {
        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToNews();
        new ButtonNewsSteps().buttonFilterNews();

        ViewInteraction checkTextView = onView(
                allOf(withId(R.id.filter_news_title_text_view)));
        checkTextView.check(matches(isDisplayed()));

        new MoveThroughCategoryInFilterNewsSteps().moveThroughCategoryInFilterNews();

        new InputNewNewsSteps().inputFilterValid();

        new ButtonNewsSteps().filterButton();
        new ButtonNewsSteps().buttonFilterNews();
        new ButtonNewsSteps().buttonCancelNews();
        new LogOutSteps().logOut();

    }

}
