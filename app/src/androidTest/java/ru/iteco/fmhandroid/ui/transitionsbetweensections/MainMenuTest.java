package ru.iteco.fmhandroid.ui.transitionsbetweensections;

//Пункт в тест кейсе № 4

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
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
import ru.iteco.fmhandroid.ui.pageObject.ButtonMainSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainMenuTest {


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
    @DisplayName("Проверка перехода между основными разделами.")
    @Description("Переход по разделам Main, Claims, News, About")
    public void mainMenuCheck() {
        new LogInSteps().logIn();
        new GoToMainMenuSteps().goToAbout();

        ViewInteraction checkAbout = onView(
                allOf(withId(R.id.about_privacy_policy_label_text_view)));
        checkAbout.check(matches(isDisplayed()));

        new ButtonMainSteps().buttonBackAbout();
        new GoToMainMenuSteps().goToNews();

        ViewInteraction checkNews = onView(
                allOf(withId(R.id.container_list_news_include)));
        checkNews.check(matches(isDisplayed()));

        new GoToMainMenuSteps().goToClaims();

        ViewInteraction checkClaims = onView(
                allOf(withId(R.id.container_list_claim_include)));
        checkClaims.check(matches(isDisplayed()));

        new GoToMainMenuSteps().goToMain();

        ViewInteraction checkMain = onView(
                allOf(withId(R.id.container_list_news_include_on_fragment_main)));
        checkMain.check(matches(isDisplayed()));

        new LogOutSteps().logOut();

    }

}
