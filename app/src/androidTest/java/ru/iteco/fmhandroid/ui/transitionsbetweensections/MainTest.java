package ru.iteco.fmhandroid.ui.transitionsbetweensections;

//Пункт в тест кейсе № 7

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.ButtonMainSteps;
import ru.iteco.fmhandroid.ui.pageObject.ButtonNewsSteps;
import ru.iteco.fmhandroid.ui.pageObject.ButtonSteps;
import ru.iteco.fmhandroid.ui.pageObject.GoToMainMenuSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogInSteps;
import ru.iteco.fmhandroid.ui.pageObject.LogOutSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainTest {

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
    @DisplayName("Проверка раздела Main")
    @io.qameta.allure.kotlin.Description("В разделе Main переходим между разделами")
    public void mainTest() {
        new LogInSteps().logIn();

        ViewInteraction checkTextNews = onView(
                allOf(withId(R.id.container_list_news_include_on_fragment_main)));
        checkTextNews.check(matches(isDisplayed()));

        new ButtonMainSteps().containerListNews();
        new ButtonMainSteps().containerListNews();
        new ButtonNewsSteps().recyclerViewNews();

        new ButtonMainSteps().newsListRecycler();
        new ButtonMainSteps().newsListRecycler();

        new ButtonMainSteps().buttonAllNews();
        ;
        new GoToMainMenuSteps().goToMain();

        new ButtonMainSteps().containerListClaims();
        new ButtonMainSteps().containerListClaims();

        new ButtonSteps().buttonCreatingClaims();

        ViewInteraction checkCreatingClaims = onView(
                allOf(withId(R.id.custom_app_bar_title_text_view),
                        withParent(allOf(withId(R.id.container_custom_app_bar_include_on_fragment_create_edit_claim),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))))));
        checkCreatingClaims.check(matches(isDisplayed()));

        new ButtonSteps().buttonCancelCreatingClaims();

        new ButtonSteps().buttonOkAlert();

        new ButtonMainSteps().containerListNews();
        new ButtonMainSteps().buttonAllClaims();

        ViewInteraction checkEditClaims = onView(
                allOf(withId(R.id.container_list_claim_include)));
        checkEditClaims.check(matches(isDisplayed()));

        new GoToMainMenuSteps().goToMain();
        new ButtonMainSteps().containerListNews();
        new ButtonMainSteps().claimsListRecycler();

        new ButtonSteps().buttonClickBack();
        new LogOutSteps().logOut();

    }

}
